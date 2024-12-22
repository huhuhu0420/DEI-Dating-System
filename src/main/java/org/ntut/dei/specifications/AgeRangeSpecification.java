package org.ntut.dei.specifications;

import org.ntut.dei.models.UserProfile;

public class AgeRangeSpecification implements Specification<UserProfile> {
    private int minAge;
    private int maxAge;

    public AgeRangeSpecification(int minAge, int maxAge) {
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    @Override
    public boolean isSatisfiedBy(UserProfile candidate) {
        int candidateAge = candidate.getAge();
        return candidateAge >= minAge && candidateAge <= maxAge;
    }

}
