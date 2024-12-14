package org.ntut.dei.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class InterestSpecificationTest {
    private UserProfile userProfile;
    private UserProfileBuilder userProfileBuilder;

    @BeforeEach
    public void setUp() {
        userProfileBuilder = new UserProfileBuilder();
        userProfile = userProfileBuilder.setInterests(Arrays.asList("Reading", "Traveling")).build();
    }

    @Test
    public void testIsSatisfiedBy_withMatchingInterest() {
        List<String> interests = Arrays.asList("Reading", "Traveling");
        InterestSpecification specification = new InterestSpecification(interests);

        assertTrue(specification.isSatisfiedBy(userProfile));
    }

    @Test
    public void testIsSatisfiedBy_withDifferInterest() {
        List<String> interests = Arrays.asList("hiking", "swimming");
        InterestSpecification specification = new InterestSpecification(interests);

        assertFalse(specification.isSatisfiedBy(userProfile));
    }
}