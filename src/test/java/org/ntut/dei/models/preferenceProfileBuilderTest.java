package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class preferenceProfileBuilderTest {
    private PreferenceProfile preferenceProfile;
    private List<GenderIdentity> genderIdentities;
    private List<String> interests;

    @Test
    public void testBuilder() {
        genderIdentities = Arrays.asList(new GenderIdentity(GenderIdentityEnum.MALE),
                new GenderIdentity(GenderIdentityEnum.FEMALE));
        interests = Arrays.asList("Reading", "Traveling");
        preferenceProfile = new PreferenceProfileBuilder().setAgeRange(25, 35)
                .setPreferedGenderIdentity(genderIdentities)
                .setPreferedInterests(interests).build();

        assertNotNull(preferenceProfile);
        assertEquals(genderIdentities, preferenceProfile.getPreferedGenderIdentity());
        assertEquals(interests, preferenceProfile.getPreferedInterests());
        assertEquals(25, preferenceProfile.getPreferedAgeRange().getMinAge());
        assertEquals(35, preferenceProfile.getPreferedAgeRange().getMaxAge());
    }
}
