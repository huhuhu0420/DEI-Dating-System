package org.ntut.dei.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.SexualOrientation;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRequest {

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

    public UserRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public GenderIdentity getGenderIdentity() {
        return genderIdentity;
    }

    public void setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public void setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public List<GenderIdentity> getPreferedGenderIdentity() {
        return preferedGenderIdentity;
    }

    public void setPreferedGenderIdentity(List<GenderIdentity> preferenceGenderIdentity) {
        this.preferedGenderIdentity = preferenceGenderIdentity;
    }

    public List<String> getPreferedInterests() {
        return preferedInterests;
    }

    public void setPreferedInterests(List<String> preferenceInterests) {
        this.preferedInterests = preferenceInterests;
    }

    public int getPreferedMinAge() {
        return preferedMinAge;
    }

    public void setPreferedMinAge(int preferenceMinAge) {
        this.preferedMinAge = preferenceMinAge;
    }

    public int getPreferedMaxAge() {
        return preferedMaxAge;
    }

    public void setPreferedMaxAge(int preferenceMaxAge) {
        this.preferedMaxAge = preferenceMaxAge;
    }

    public String getMatchStrategy() {
        return matchStrategy;
    }

    public void setMatchStrategy(String matchStrategy) {
        this.matchStrategy = matchStrategy;
    }
}
