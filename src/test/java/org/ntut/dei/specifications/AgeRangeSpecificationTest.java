
package org.ntut.dei.specifications;

import org.junit.jupiter.api.Test;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AgeRangeSpecificationTest {

    @Test
    public void testIsSatisfiedBy_withinRange() {
        AgeRangeSpecification spec = new AgeRangeSpecification(18, 30);
        UserProfileBuilder builder = new UserProfileBuilder();
        UserProfile user = builder.setAge(25).build();

        assertTrue(spec.isSatisfiedBy(user));
    }

    @Test
    public void testIsSatisfiedBy_belowRange() {
        AgeRangeSpecification spec = new AgeRangeSpecification(18, 30);
        UserProfileBuilder builder = new UserProfileBuilder();
        UserProfile user = builder.setAge(17).build();

        assertFalse(spec.isSatisfiedBy(user));
    }

    @Test
    public void testIsSatisfiedBy_aboveRange() {
        AgeRangeSpecification spec = new AgeRangeSpecification(18, 30);
        UserProfileBuilder builder = new UserProfileBuilder();
        UserProfile user = builder.setAge(31).build();

        assertFalse(spec.isSatisfiedBy(user));
    }

}