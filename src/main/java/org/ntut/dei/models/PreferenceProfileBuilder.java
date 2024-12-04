package org.ntut.dei.models;

import java.util.ArrayList;
import java.util.List;

public class PreferenceProfileBuilder {
    private GenderIdentity preferedGenderIdentity;
    private List<String> preferedInterests;
    private AgeRange ageRange;

    public PreferenceProfileBuilder() {
        this.preferedGenderIdentity = GenderIdentity.CUSTOM;
        this.preferedInterests = new ArrayList<>();
        this.ageRange = new AgeRange(0, 100);
    }

    public PreferenceProfileBuilder setPreferedGenderIdentity(GenderIdentity preferedGenderIdentity) {
        this.preferedGenderIdentity = preferedGenderIdentity;
        return this;
    }

    public PreferenceProfileBuilder setPreferedInterests(List<String> preferedInterests) {
        this.preferedInterests = preferedInterests;
        return this;
    }

    public PreferenceProfileBuilder setAgeRange(AgeRange ageRange) {
        this.ageRange = ageRange;
        return this;
    }

    public PreferenceProfile build() {
        return new PreferenceProfile(preferedGenderIdentity, preferedInterests, ageRange);
    }
}
