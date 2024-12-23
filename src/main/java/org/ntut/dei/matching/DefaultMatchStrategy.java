package org.ntut.dei.matching;

import java.util.ArrayList;
import java.util.List;

import org.ntut.dei.models.User;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.specifications.Specification;
import org.ntut.dei.specifications.SpecificationBuilder;

public class DefaultMatchStrategy implements MatchStrategy {
    public List<User> match(User user, List<User> candidates, SpecificationBuilder specificationBuilder) {
        Specification<UserProfile> spec = specificationBuilder.buildSpecificationFromPreferences(user.getUserProfile());
        List<User> matches = new ArrayList<User>();
        for (User candidate : candidates) {
            if (candidate.equals(user)) {
                continue;
            }
            if (spec.isSatisfiedBy(candidate.getUserProfile())) {
                matches.add(candidate);
            }
        }
        return matches;
    }
}
