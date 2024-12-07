package org.ntut.dei.specifications;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class IdentitySpecificationTest {
    private IdentitySpecification identitySpecification;
    private UserProfile userProfile;

    @BeforeEach
    public void setUp() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        userProfile = userProfileBuilder.build();
    }

    @Test
    public void testIsSatisfiedBy_withPreferredGenderIdentity() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        GenderIdentity female = new GenderIdentity(GenderIdentityEnum.FEMALE);
        List<GenderIdentity> preferredGenderIdentities = Arrays.asList(male, female);
        identitySpecification = new IdentitySpecification(preferredGenderIdentities);

        userProfile.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE));
        assertTrue(identitySpecification.isSatisfiedBy(userProfile));

        userProfile.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.FEMALE));
        assertTrue(identitySpecification.isSatisfiedBy(userProfile));
    }

    @Test
    public void testIsSatisfiedBy_withNonPreferredGenderIdentity() {
        GenderIdentity male = new GenderIdentity(GenderIdentityEnum.MALE);
        GenderIdentity female = new GenderIdentity(GenderIdentityEnum.FEMALE);
        List<GenderIdentity> preferredGenderIdentities = Arrays.asList(male, female);
        identitySpecification = new IdentitySpecification(preferredGenderIdentities);

        userProfile.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.NON_BINARY));
        assertFalse(identitySpecification.isSatisfiedBy(userProfile));
    }

    @Test
    public void testIsSatisfiedBy_withCustomGenderIdentityMatchingDisplayName() {
        GenderIdentity customGenderIdentity = new GenderIdentity(GenderIdentityEnum.CUSTOM, "CustomIdentity");

        List<GenderIdentity> preferredGenderIdentities = Arrays.asList(customGenderIdentity);
        identitySpecification = new IdentitySpecification(preferredGenderIdentities);

        userProfile.setGenderIdentity(customGenderIdentity);
        assertTrue(identitySpecification.isSatisfiedBy(userProfile));
    }

    @Test
    public void testIsSatisfiedBy_withCustomGenderIdentityNonMatchingDisplayName() {
        GenderIdentity customGenderIdentity = new GenderIdentity(GenderIdentityEnum.CUSTOM, "CustomIdentity");

        List<GenderIdentity> preferredGenderIdentities = Arrays.asList(customGenderIdentity);
        identitySpecification = new IdentitySpecification(preferredGenderIdentities);

        userProfile.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.CUSTOM, "DifferentCustomIdentity"));
        assertFalse(identitySpecification.isSatisfiedBy(userProfile));
    }
}