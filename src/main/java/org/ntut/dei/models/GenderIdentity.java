package org.ntut.dei.models;

public class GenderIdentity {
    private String genderIdentity;
    private GenderIdentityEnum genderIdentityEnum;

    public GenderIdentity() {
    }

    public GenderIdentity(GenderIdentityEnum genderIdentity) {
        this.genderIdentityEnum = genderIdentity;
        this.genderIdentity = genderIdentity.getDisplayName();
    }

    public GenderIdentity(GenderIdentityEnum genderIdentity, String customGenderIdentity) {
        this.genderIdentityEnum = genderIdentity;
        this.genderIdentity = genderIdentity.getDisplayName();
        if (genderIdentity == GenderIdentityEnum.CUSTOM) {
            this.genderIdentity = customGenderIdentity;
        }
    }

    public String getGenderIdentity() {
        if (genderIdentity == null) {
            return genderIdentityEnum.getDisplayName();
        }
        return genderIdentity;
    }

    public GenderIdentityEnum getGenderIdentityEnum() {
        return genderIdentityEnum;
    }

    public void setCustomGenderIdentity(String genderIdentity) {
        if (genderIdentityEnum == GenderIdentityEnum.CUSTOM) {
            this.genderIdentity = genderIdentity;
        }
    }

}
