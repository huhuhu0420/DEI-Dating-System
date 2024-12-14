package org.ntut.dei.models;

import java.util.List;

public class PreferenceProfile {
    private List<GenderIdentity> preferedGenderIdentity;
    private List<String> preferedInterests;
    private AgeRange preferedAgeRange;

    public PreferenceProfile(List<GenderIdentity> preferedGenderIdentity, List<String> preferedInterests,
            AgeRange ageRange) {
        this.preferedGenderIdentity = preferedGenderIdentity;
        this.preferedInterests = preferedInterests;
        this.preferedAgeRange = ageRange;
    }

    public List<GenderIdentity> getPreferedGenderIdentity() {
        return preferedGenderIdentity;
    }

    public List<String> getPreferedInterests() {
        return preferedInterests;
    }

    public AgeRange getPreferedAgeRange() {
        return preferedAgeRange;
    }

    public void setPreferedGenderIdentity(List<GenderIdentity> preferedGenderIdentity) {
        this.preferedGenderIdentity = preferedGenderIdentity;
    }
}