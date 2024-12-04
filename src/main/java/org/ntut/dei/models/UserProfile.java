package org.ntut.dei.models;

import java.util.List;

public class UserProfile {
    private String name;
    private int age;
    private GenderIdentity genderIdentity;
    private SexualOrientation sexualOrientation;
    private String bio;
    private List<String> interests;
    private PreferenceProfile preferenceProfile;

    public UserProfile(String name, int age, GenderIdentity genderIdentity, SexualOrientation sexualOrientation,
            String bio, List<String> interests) {
        this.name = name;
        this.age = age;
        this.genderIdentity = genderIdentity;
        this.sexualOrientation = sexualOrientation;
        this.bio = bio;
        this.interests = interests;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public GenderIdentity getGenderIdentity() {
        return genderIdentity;
    }

    public SexualOrientation getSexualOrientation() {
        return sexualOrientation;
    }

    public String getBio() {
        return bio;
    }

    public List<String> getInterests() {
        return interests;
    }

    public PreferenceProfile getPreferenceProfile() {
        return preferenceProfile;
    }

    public void setPreferenceProfile(PreferenceProfile preferenceProfile) {
        this.preferenceProfile = preferenceProfile;
    }
}
