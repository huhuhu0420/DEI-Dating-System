package org.ntut.dei.specifications;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class SpecificationBuilderTest {

    private SpecificationBuilder specificationBuilder;
    private UserProfile userProfile;
    private PreferenceProfile preferenceProfile;

    @BeforeEach
    public void setUp() {
        specificationBuilder = new SpecificationBuilder();
        preferenceProfile = new PreferenceProfileBuilder().build();
        userProfile = new UserProfileBuilder().build();
        userProfile.setPreferenceProfile(preferenceProfile);
    }

    @Test
    public void testBuildSpecificationFromPreferences() {

        Specification<UserProfile> spec = specificationBuilder.buildSpecificationFromPreferences(userProfile);

        assertNotNull(spec);
        assertTrue(spec.isSatisfiedBy(userProfile));
    }
}
