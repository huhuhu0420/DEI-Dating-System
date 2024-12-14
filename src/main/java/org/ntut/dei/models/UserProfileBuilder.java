package org.ntut.dei.models;

import java.util.ArrayList;
import java.util.List;

public class UserProfileBuilder {
    private String name;
    private int age;
    private GenderIdentity genderIdentity;
    private SexualOrientation sexualOrientation;
    private String bio;
    private List<String> interests;

    public UserProfileBuilder() {
        this.name = "";
        this.age = 0;
        this.genderIdentity = new GenderIdentity(GenderIdentityEnum.OTHER);
        this.sexualOrientation = SexualOrientation.OTHER;
        this.bio = "";
        this.interests = new ArrayList<>();
    }

    public UserProfileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserProfileBuilder setGenderIdentityWithEnum(GenderIdentityEnum genderIdentity) {
        this.genderIdentity = new GenderIdentity(genderIdentity);
        return this;
    }

    public UserProfileBuilder setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
        return this;
    }

    public UserProfileBuilder setGenderIdentity(GenderIdentityEnum genderIdentity, String customGenderIdentity) {
        this.genderIdentity = new GenderIdentity(genderIdentity);
        if (genderIdentity == GenderIdentityEnum.CUSTOM) {
            this.genderIdentity.setCustomGenderIdentity(customGenderIdentity);
        }
        return this;
    }

    public UserProfileBuilder setSexualOrientation(SexualOrientation sexualOrientation) {
        this.sexualOrientation = sexualOrientation;
        return this;
    }

    public UserProfileBuilder setBio(String bio) {
        this.bio = bio;
        return this;
    }

    public UserProfileBuilder setInterests(List<String> interests) {
        if (interests == null) {
            return this;
        }
        this.interests = interests;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(name, age, genderIdentity, sexualOrientation, bio, interests);
    }
}
