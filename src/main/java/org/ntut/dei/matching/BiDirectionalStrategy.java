package org.ntut.dei.matching;

import java.util.ArrayList;
import java.util.List;

import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.specifications.Specification;
import org.ntut.dei.specifications.AgeRangeSpecification;
import org.ntut.dei.specifications.IdentitySpecification;
import org.ntut.dei.specifications.InterestSpecification;

public class BiDirectionalStrategy implements MatchStrategy {
    @Override
    public List<User> match(User user, List<User> candidates) {
        Specification<UserProfile> spec = buildSpecificationFromPreferences(user.getUserProfile());
        List<User> matches = new ArrayList<User>();

        for (User candidate : candidates) {
            if (user.equals(candidate)) {
                continue;
            }
            if (spec.isSatisfiedBy(candidate.getUserProfile())) {
                // Check if the candidate is interested in the user
                Specification<UserProfile> cadidateSpec = buildSpecificationFromPreferences(candidate.getUserProfile());

                if (cadidateSpec.isSatisfiedBy(user.getUserProfile())) {
                    matches.add(candidate);
                }
            }
        }

        return matches;
    }

    private Specification<UserProfile> buildSpecificationFromPreferences(UserProfile userProfile) {
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
