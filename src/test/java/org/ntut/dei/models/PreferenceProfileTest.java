package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PreferenceProfileTest {
    private PreferenceProfile preferenceProfile;
    private List<GenderIdentity> genderIdentities;
    private List<String> interests;
    private AgeRange ageRange;

    @BeforeEach
    public void setUp() {
        genderIdentities = Arrays.asList(new GenderIdentity(GenderIdentityEnum.MALE),
                new GenderIdentity(GenderIdentityEnum.FEMALE));
        interests = Arrays.asList("Reading", "Traveling");
        ageRange = new AgeRange(25, 35);
        preferenceProfile = new PreferenceProfile(genderIdentities, interests, ageRange);
    }

    @Test
    public void testConstructor() {
        assertNotNull(preferenceProfile);
        assertEquals(genderIdentities, preferenceProfile.getPreferedGenderIdentity());
        assertEquals(interests, preferenceProfile.getPreferedInterests());
        assertEquals(ageRange, preferenceProfile.getPreferedAgeRange());
    }

    @Test
    public void testGetPreferedGenderIdentity() {
        assertEquals(genderIdentities, preferenceProfile.getPreferedGenderIdentity());
    }

    @Test
    public void testGetPreferedInterests() {
        assertEquals(interests, preferenceProfile.getPreferedInterests());
    }

    @Test
    public void testGetPreferedAgeRange() {
        assertEquals(ageRange, preferenceProfile.getPreferedAgeRange());
    }

    @Test
    public void testSetPreferedGenderIdentity() {
        List<GenderIdentity> newGenderIdentities = Arrays.asList(new GenderIdentity(GenderIdentityEnum.NON_BINARY),
                new GenderIdentity(GenderIdentityEnum.CUSTOM));
        preferenceProfile.setPreferedGenderIdentity(newGenderIdentities);
        assertEquals(newGenderIdentities, preferenceProfile.getPreferedGenderIdentity());
    }
}