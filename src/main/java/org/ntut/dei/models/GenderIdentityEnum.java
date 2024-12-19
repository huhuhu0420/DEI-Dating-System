package org.ntut.dei.models;

public enum GenderIdentityEnum {
    MALE("Male"),
    FEMALE("Female"),
    NON_BINARY("Non-binary"),
    GENDERQUEER("Genderqueer"),
    AGENDER("Agender"),
    TRANSGENDER("Transgender"),
    GENDER_FLUID("Gender fluid"),
    TWO_SPIRIT("Two-spirit"),
    OTHER("Other"),
    CUSTOM("Custom");

    private String displayName;

    GenderIdentityEnum(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

}
