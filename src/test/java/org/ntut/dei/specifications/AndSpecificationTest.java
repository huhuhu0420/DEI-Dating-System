package org.ntut.dei.specifications;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AndSpecificationTest {

    @Test
    void testIsSatisfiedByBothTrue() {
        Specification<Object> leftSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return true;
            }
        };
        Specification<Object> rightSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return true;
            }
        };
        Object candidate = new Object();

        AndSpecification<Object> andSpec = new AndSpecification<>(leftSpec, rightSpec);
        assertTrue(andSpec.isSatisfiedBy(candidate));
    }

    @Test
    void testIsSatisfiedByOneFalse() {
        Specification<Object> leftSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return true;
            }
        };
        Specification<Object> rightSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return false;
            }
        };
        Object candidate = new Object();

        AndSpecification<Object> andSpec = new AndSpecification<>(leftSpec, rightSpec);
        assertFalse(andSpec.isSatisfiedBy(candidate));
    }

    @Test
    void testIsSatisfiedByBothFalse() {
        Specification<Object> leftSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return false;
            }
        };
        Specification<Object> rightSpec = new Specification<Object>() {
            @Override
            public boolean isSatisfiedBy(Object candidate) {
                return false;
            }
        };
        Object candidate = new Object();

        AndSpecification<Object> andSpec = new AndSpecification<>(leftSpec, rightSpec);
        assertFalse(andSpec.isSatisfiedBy(candidate));
    }

}