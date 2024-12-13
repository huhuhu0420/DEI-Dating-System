package org.ntut.dei.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;

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
}
