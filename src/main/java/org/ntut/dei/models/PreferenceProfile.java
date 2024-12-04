package org.ntut.dei.models;

import java.util.List;

public class PreferenceProfile {
    private GenderIdentity preferedGenderIdentity;
    private List<String> preferedInterests;
    private AgeRange preferedAgeRange;

    public PreferenceProfile(GenderIdentity preferedGenderIdentity, List<String> preferedInterests, AgeRange ageRange) {
        this.preferedGenderIdentity = preferedGenderIdentity;
        this.preferedInterests = preferedInterests;
        this.preferedAgeRange = ageRange;
    }

    public GenderIdentity getPreferedGenderIdentity() {
        return preferedGenderIdentity;
    }

    public List<String> getPreferedInterests() {
        return preferedInterests;
    }

    public AgeRange getPreferedAgeRange() {
        return preferedAgeRange;
    }
}