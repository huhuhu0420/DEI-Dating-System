package org.ntut.dei.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PreferenceProfileBuilderTest {
    @Test
    public void testPreferenceProfileBuilder() {
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();
        List<String> interests = List.of("testInterest", "testInterest2");
        PreferenceProfile preferenceProfile = preferenceProfileBuilder
                .setPreferedGenderIdentity(GenderIdentity.MALE)
                .setPreferedInterests(interests)
                .setAgeRange(new AgeRange(10, 20))
                .build();

        assertEquals(GenderIdentity.MALE, preferenceProfile.getPreferedGenderIdentity());
        assertEquals(interests, preferenceProfile.getPreferedInterests());
        assertEquals(10, preferenceProfile.getPreferedAgeRange().getMinAge());
        assertEquals(20, preferenceProfile.getPreferedAgeRange().getMaxAge());
    }

    @Test
    public void testPreferenceProfileBuilderWithDefaultValues() {
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();
        PreferenceProfile preferenceProfile = preferenceProfileBuilder.build();

        assertEquals(GenderIdentity.CUSTOM, preferenceProfile.getPreferedGenderIdentity());
        assertEquals(new ArrayList<>(), preferenceProfile.getPreferedInterests());
        assertEquals(0, preferenceProfile.getPreferedAgeRange().getMinAge());
        assertEquals(100, preferenceProfile.getPreferedAgeRange().getMaxAge());
    }
}
