package org.ntut.dei.models;

import java.util.List;
import java.util.Set;

public class PreferenceProfile {
    private Set<GenderIdentity> preferedGenderIdentity;
    private List<String> preferedInterests;
    private AgeRange preferedAgeRange;

    public PreferenceProfile(Set<GenderIdentity> preferedGenderIdentity, List<String> preferedInterests,
            AgeRange ageRange) {
        this.preferedGenderIdentity = preferedGenderIdentity;
        this.preferedInterests = preferedInterests;
        this.preferedAgeRange = ageRange;
    }

    public Set<GenderIdentity> getPreferedGenderIdentity() {
        return preferedGenderIdentity;
    }

    public List<String> getPreferedInterests() {
        return preferedInterests;
    }

    public AgeRange getPreferedAgeRange() {
        return preferedAgeRange;
    }
}