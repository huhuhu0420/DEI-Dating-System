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
        for (String interest : interests) {
            if (candidateInterests.contains(interest)) {
                return true;
            }
        }
        return false;
    }
}
