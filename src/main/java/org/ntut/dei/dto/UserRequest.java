package org.ntut.dei.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.SexualOrientation;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null fields from JSON
public class UserRequest {

    @JsonProperty("name")
    @NotNull // Validation annotation to enforce presence
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

    @JsonProperty("preferenceGenderIdentity")
    private List<GenderIdentity> preferenceGenderIdentity;

    @JsonProperty("preferenceInterests")
    private List<String> preferenceInterests;

    @JsonProperty("preferenceMinAge")
    private int preferenceMinAge;

    @JsonProperty("preferenceMaxAge")
    private int preferenceMaxAge;

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

    public List<GenderIdentity> getPreferenceGenderIdentity() {
        return preferenceGenderIdentity;
    }

    public void setPreferenceGenderIdentity(List<GenderIdentity> preferenceGenderIdentity) {
        this.preferenceGenderIdentity = preferenceGenderIdentity;
    }

    public List<String> getPreferenceInterests() {
        return preferenceInterests;
    }

    public void setPreferenceInterests(List<String> preferenceInterests) {
        this.preferenceInterests = preferenceInterests;
    }

    public int getPreferenceMinAge() {
        return preferenceMinAge;
    }

    public void setPreferenceMinAge(int preferenceMinAge) {
        this.preferenceMinAge = preferenceMinAge;
    }

    public int getPreferenceMaxAge() {
        return preferenceMaxAge;
    }

    public void setPreferenceMaxAge(int preferenceMaxAge) {
        this.preferenceMaxAge = preferenceMaxAge;
    }
}
