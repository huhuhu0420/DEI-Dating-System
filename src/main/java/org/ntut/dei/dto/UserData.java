package org.ntut.dei.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserData {

    @JsonProperty("name")
    @NotNull
    private String name;

    @JsonProperty("age")
    @NotNull
    private int age;

    @JsonProperty("genderIdentity")
    @NotNull
    private GenderIdentity genderIdentity;

    @JsonProperty("sexualOrientation")
    private SexualOrientation sexualOrientation;

    @JsonProperty("bio")
    private String bio;

    @JsonProperty("interests")
    private List<String> interests;

    @JsonProperty("preferedGenderIdentity")
    private List<GenderIdentity> preferedGenderIdentity;

    @JsonProperty("preferedInterests")
    private List<String> preferedInterests;

    @JsonProperty("preferedMinAge")
    private int preferedMinAge;

    @JsonProperty("preferedMaxAge")
    private int preferedMaxAge;

    @JsonProperty("matchStrategy")
    private String matchStrategy;

    @JsonProperty("premium")
    private boolean premium;

    // fromUser method
    public static UserData fromUser(User user) {
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

    // toUser method
    public User toUser() {
        UserProfileBuilder userProfileBuilder = new UserProfileBuilder();
        PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();

        userProfileBuilder.setName(name);
        userProfileBuilder.setAge(age);
        userProfileBuilder.setGenderIdentity(genderIdentity);
        if (sexualOrientation != null) {
            userProfileBuilder.setSexualOrientation(sexualOrientation);
        }
        if (bio != null) {
            userProfileBuilder.setBio(bio);
        }
        if (interests != null) {
            userProfileBuilder.setInterests(interests);
        }
        if (preferedGenderIdentity != null) {
            preferenceProfileBuilder.setPreferedGenderIdentity(preferedGenderIdentity);
        }
        if (preferedMinAge != 0) {
            preferenceProfileBuilder.setAgeRange(preferedMinAge, preferedMaxAge);
        }
        if (preferedInterests != null) {
            preferenceProfileBuilder.setPreferedInterests(preferedInterests);
        }

        UserProfile userProfile = userProfileBuilder.build();
        PreferenceProfile preferenceProfile = preferenceProfileBuilder.build();
        userProfile.setPreferenceProfile(preferenceProfile);

        User user = UserFactory.createUser(name, userProfile, premium);

        return user;
    }
}
