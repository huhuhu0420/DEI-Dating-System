package org.ntut.dei.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OrSpecificationTest {
    // Test case 1
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

        OrSpecification<Object> orSpec = new OrSpecification<>(leftSpec, rightSpec);
        assertTrue(orSpec.isSatisfiedBy(candidate));
    }

    // Test case 2
    @Test
    void testIsSatisfiedByOneTrue() {
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

        OrSpecification<Object> orSpec = new OrSpecification<>(leftSpec, rightSpec);
        assertTrue(orSpec.isSatisfiedBy(candidate));
    }

    // Test case 3
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

        OrSpecification<Object> orSpec = new OrSpecification<>(leftSpec, rightSpec);
        assertFalse(orSpec.isSatisfiedBy(candidate));
    }
}
