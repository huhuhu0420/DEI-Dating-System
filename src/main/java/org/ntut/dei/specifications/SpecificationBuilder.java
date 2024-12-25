package org.ntut.dei.specifications;

import java.util.List;

import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.UserProfile;

public class SpecificationBuilder {
    public Specification<UserProfile> buildSpecificationFromPreferences(UserProfile userProfile) {
        PreferenceProfile preferences = userProfile.getPreferenceProfile();

        Specification<UserProfile> identitySpec = new IdentitySpecification(preferences.getPreferedGenderIdentity());

        int minAge = preferences.getPreferedAgeRange().getMinAge();
        int maxAge = preferences.getPreferedAgeRange().getMaxAge();
        Specification<UserProfile> ageSpec = new AgeRangeSpecification(minAge, maxAge);

        List<String> interests = preferences.getPreferedInterests();
        Specification<UserProfile> interestSpec = new InterestSpecification(interests);

        Specification<UserProfile> spec = identitySpec.and(ageSpec).and(interestSpec);

        return spec;
    }
}
