package org.ntut.dei.models;

import java.util.List;

import org.ntut.dei.utils.DefaultCompatibilityMatrix;

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
        this.preferenceProfile = null;
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

    public GenderIdentityEnum getGenderIdentityEnum() {
        return genderIdentity.getGenderIdentityEnum();
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

    public void setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
    }

    public PreferenceProfile getPreferenceProfile() {
        if (preferenceProfile == null) {
            // If the user has not set a preference profile, use the default compatibility
            // matrix
            DefaultCompatibilityMatrix compatibilityMatrix = DefaultCompatibilityMatrix.getInstance();
            List<GenderIdentity> defaultSexualOrientation = compatibilityMatrix
                    .getDefaultPreferencedGenderIdentities(sexualOrientation, genderIdentity);
            PreferenceProfileBuilder preferenceProfileBuilder = new PreferenceProfileBuilder();
            preferenceProfile = preferenceProfileBuilder.setPreferedGenderIdentity(defaultSexualOrientation)
                    .setPreferedInterests(interests).build();
            return preferenceProfile;
        } else if (preferenceProfile.getPreferedGenderIdentity().isEmpty()) {
            // If the user has set a preference profile but has not set any preferred
            preferenceProfile.setPreferedGenderIdentity(
                    DefaultCompatibilityMatrix.getInstance().getDefaultPreferencedGenderIdentities(sexualOrientation,
                            genderIdentity));
            return preferenceProfile;
        } else {
            return preferenceProfile;
        }
    }

    public void setPreferenceProfile(PreferenceProfile preferenceProfile) {
        this.preferenceProfile = preferenceProfile;
    }

    public void setCustomGenderIdentity(String customDisplayName) {
        if (genderIdentity.getGenderIdentityEnum() == GenderIdentityEnum.CUSTOM) {
            genderIdentity.setCustomGenderIdentity(customDisplayName);
        } else {
            throw new UnsupportedOperationException("Cannot set custom display name for non-custom identity");
        }
    }
}
