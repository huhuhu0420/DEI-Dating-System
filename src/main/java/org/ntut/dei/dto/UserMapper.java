package org.ntut.dei.dto;

import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class UserMapper {

    // Converts User to UserData DTO
    public static UserData toDTO(User user) {
        UserData userData = new UserData();
        userData.setName(user.getUserProfile().getName());
        userData.setAge(user.getUserProfile().getAge());
        userData.setGenderIdentity(user.getUserProfile().getGenderIdentity());
        userData.setSexualOrientation(user.getUserProfile().getSexualOrientation());
        userData.setBio(user.getUserProfile().getBio());
        userData.setInterests(user.getUserProfile().getInterests());
        userData.setPreferedGenderIdentity(user.getUserProfile().getPreferenceProfile().getPreferedGenderIdentity());
        userData.setPreferedInterests(user.getUserProfile().getPreferenceProfile().getPreferedInterests());
        userData.setPreferedMinAge(user.getUserProfile().getPreferenceProfile().getPreferedAgeRange().getMinAge());
        userData.setPreferedMaxAge(user.getUserProfile().getPreferenceProfile().getPreferedAgeRange().getMaxAge());
        userData.setPremium(user.isPremium());
        return userData;
    }

    // Converts UserData DTO to User
    public static User toEntity(UserData userData) {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();

        userProfileBuilder.setName(userData.getName());
        userProfileBuilder.setAge(userData.getAge());
        userProfileBuilder.setGenderIdentity(userData.getGenderIdentity());

        if (userData.getSexualOrientation() != null) {
            userProfileBuilder.setSexualOrientation(userData.getSexualOrientation());
        }
        if (userData.getBio() != null) {
            userProfileBuilder.setBio(userData.getBio());
        }
        if (userData.getInterests() != null) {
            userProfileBuilder.setInterests(userData.getInterests());
        }
        if (userData.getPreferedGenderIdentity() != null) {
            preferenceProfileBuilder.setPreferedGenderIdentity(userData.getPreferedGenderIdentity());
        }
        if (userData.getPreferedMinAge() != 0) {
            preferenceProfileBuilder.setAgeRange(userData.getPreferedMinAge(), userData.getPreferedMaxAge());
        }
        if (userData.getPreferedInterests() != null) {
            preferenceProfileBuilder.setPreferedInterests(userData.getPreferedInterests());
        }

        UserProfile userProfile = userProfileBuilder.build();
        PreferenceProfile preferenceProfile = preferenceProfileBuilder.build();
        userProfile.setPreferenceProfile(preferenceProfile);

        User user = UserFactory.createUser(userData.getName(), userProfile, userData.isPremium());

        return user;
    }
}
