package org.ntut.dei.models;

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
        this.genderIdentity = GenderIdentity.OTHER;
        this.sexualOrientation = SexualOrientation.OTHER;
        this.bio = "";
        this.interests = null;
    }

    public UserProfileBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public UserProfileBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public UserProfileBuilder setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
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
        this.interests = interests;
        return this;
    }

    public UserProfile build() {
        return new UserProfile(name, age, genderIdentity, sexualOrientation, bio, interests);
    }
}
