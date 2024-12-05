package org.ntut.dei.models;

public enum GenderIdentity {
    MALE("Male"),
    FEMALE("Female"),
    NON_BINARY("Non-binary"),
    GENDERQUEER("Genderqueer"),
    AGENDER("Agender"),
    TRANSGENDER("Transgender"),
    GENDER_FLUID("Gender fluid"),
    TWO_SPIRIT("Two-spirit"),
    OTHER("Other"),
    CUSTOM("");

    private String displayName;

    GenderIdentity(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setCustomeDisplayName(String customDisplayName) {
        if (this == CUSTOM) {
            this.displayName = customDisplayName;
        } else {
            throw new UnsupportedOperationException("Cannot set custom display name for non-custom identity");
        }
    }

}
