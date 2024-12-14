package org.ntut.dei.specifications;

import java.util.List;

import org.ntut.dei.models.UserProfile;

public class InterestSpecification extends AbstractSpecification<UserProfile> {
    private List<String> interests;

    public InterestSpecification(List<String> interests) {
        this.interests = interests;
    }

    @Override
    public boolean isSatisfiedBy(UserProfile candidate) {
        List<String> candidateInterests = candidate.getInterests();
        if (interests.isEmpty()) {
            return true;
        }
        for (String candidateInterest : candidateInterests) {
            if (interests.contains(candidateInterest)) {
                return true;
            }
        }
        return false;
    }
}
