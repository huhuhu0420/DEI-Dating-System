package org.ntut.dei.models;

import java.util.ArrayList;
import java.util.List;

public class PreferenceProfileBuilder {
    private List<GenderIdentity> preferedGenderIdentity;
    private List<String> preferedInterests;
    private AgeRange ageRange;

    public PreferenceProfileBuilder() {
        this.preferedGenderIdentity = new ArrayList<>();
        this.preferedInterests = new ArrayList<>();
        this.ageRange = new AgeRange(0, 100);
    }

    public PreferenceProfileBuilder setPreferedGenderIdentity(List<GenderIdentity> preferedGenderIdentity) {
        this.preferedGenderIdentity = preferedGenderIdentity;
        return this;
    }

    public PreferenceProfileBuilder setPreferedGenderIdentityWithEnum(List<GenderIdentityEnum> preferedGenderIdentity) {
        for (GenderIdentityEnum genderIdentityEnum : preferedGenderIdentity) {
            this.preferedGenderIdentity.add(new GenderIdentity(genderIdentityEnum));
        }
        return this;
    }

    public PreferenceProfileBuilder addPreferenceGenderIdentity(GenderIdentityEnum genderIdentityEnum) {
        this.preferedGenderIdentity.add(new GenderIdentity(genderIdentityEnum));
        return this;
    }

    public PreferenceProfileBuilder addPreferenceGenderIdentityWithEnum(GenderIdentityEnum genderIdentityEnum,
            String customGenderIdentity) {
        GenderIdentity genderIdentity = new GenderIdentity(genderIdentityEnum);
        genderIdentity.setCustomGenderIdentity(customGenderIdentity);
        if (genderIdentityEnum == GenderIdentityEnum.CUSTOM) {
            this.preferedGenderIdentity.add(genderIdentity);
        }
        return this;
    }

    public PreferenceProfileBuilder setPreferedInterests(List<String> preferedInterests) {
        if (preferedInterests == null) {
            return this;
        }
        this.preferedInterests = preferedInterests;
        return this;
    }

    public PreferenceProfileBuilder setAgeRange(int min, int max) {
        this.ageRange = new AgeRange(min, max);
        return this;
    }

    public PreferenceProfile build() {
        return new PreferenceProfile(preferedGenderIdentity, preferedInterests, ageRange);
    }
}
