package org.ntut.dei.dto;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.ntut.dei.models.*;

public class UserMapperTest {

    @Test
    public void testToDTO() {
        // Setup
        PreferenceProfile preferenceProfile = new PreferenceProfileBuilder()
                .setPreferedGenderIdentity(List.of(new GenderIdentity(GenderIdentityEnum.MALE)))
                .setPreferedInterests(List.of("Reading"))
                .setAgeRange(25, 35)
                .build();

        UserProfile userProfile = new UserProfileBuilder()
                .setName("John Doe")
                .setAge(30)
                .setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE))
                .setSexualOrientation(SexualOrientation.QUEER)
                .setBio("Love hiking and outdoor activities.")
                .setInterests(List.of("Hiking", "Reading"))
                .build();
        userProfile.setPreferenceProfile(preferenceProfile);

        User user = UserFactory.createUser("John Doe", userProfile, true);

        // Execute
        UserData userData = UserMapper.toDTO(user);

        // Verify
        assertEquals("John Doe", userData.getName());
        assertEquals(30, userData.getAge());
        assertEquals("Male", userData.getGenderIdentity().getGenderIdentity());
        assertEquals(SexualOrientation.QUEER, userData.getSexualOrientation());
        assertEquals("Love hiking and outdoor activities.", userData.getBio());
        assertEquals(List.of("Hiking", "Reading"), userData.getInterests());
        assertEquals("Male", userData.getPreferedGenderIdentity().get(0).getGenderIdentity());
        assertEquals(List.of("Reading"), userData.getPreferedInterests());
        assertEquals(25, userData.getPreferedMinAge());
        assertEquals(35, userData.getPreferedMaxAge());
        assertTrue(userData.isPremium());
    }

    @Test
    public void testToEntity() {
        // Setup
        UserData userData = new UserData();
        userData.setName("Jane Smith");
        userData.setAge(28);
        userData.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.FEMALE));
        userData.setSexualOrientation(SexualOrientation.BISEXUAL);
        userData.setBio("Avid reader and writer.");
        userData.setInterests(List.of("Writing", "Reading"));
        userData.setPreferedGenderIdentity(List.of(new GenderIdentity(GenderIdentityEnum.MALE)));
        userData.setPreferedInterests(List.of("Writing"));
        userData.setPreferedMinAge(27);
        userData.setPreferedMaxAge(37);
        userData.setPremium(false);

        // Execute
        User user = UserMapper.toEntity(userData);

        // Verify
        assertEquals("Jane Smith", user.getUserProfile().getName());
        assertEquals(28, user.getUserProfile().getAge());
        assertEquals("Female", user.getUserProfile().getGenderIdentity().getGenderIdentity());
        assertEquals(SexualOrientation.BISEXUAL, user.getUserProfile().getSexualOrientation());
        assertEquals("Avid reader and writer.", user.getUserProfile().getBio());
        assertEquals(List.of("Writing", "Reading"), user.getUserProfile().getInterests());
        assertEquals("Male",
                user.getUserProfile().getPreferenceProfile().getPreferedGenderIdentity().get(0).getGenderIdentity());
        assertEquals(List.of("Writing"), user.getUserProfile().getPreferenceProfile().getPreferedInterests());
        assertEquals(27, user.getUserProfile().getPreferenceProfile().getPreferedAgeRange().getMinAge());
        assertEquals(37, user.getUserProfile().getPreferenceProfile().getPreferedAgeRange().getMaxAge());
        assertFalse(user.isPremium());
    }
}