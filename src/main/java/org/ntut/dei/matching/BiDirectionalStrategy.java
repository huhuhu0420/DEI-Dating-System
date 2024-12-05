package org.ntut.dei.matching;

import java.util.ArrayList;
import java.util.List;

import org.ntut.dei.models.UserProfile;
import org.ntut.dei.specifications.Specification;

public class BiDirectionalStrategy implements MatchStrategy {
    private List<UserProfile> potentialMatches = new ArrayList<UserProfile>();

    public BiDirectionalStrategy(List<UserProfile> potentialMatches) {
        this.potentialMatches = potentialMatches;
    }

    @Override
    public List<UserProfile> match(UserProfile userProfile, List<UserProfile> candidates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'match'");
    }
}
