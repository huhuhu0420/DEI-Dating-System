package org.ntut.dei.matching;

import java.util.ArrayList;
import java.util.List;

import org.ntut.dei.models.User;
import org.ntut.dei.specifications.Specification;

public class BiDirectionalStrategy implements MatchStrategy {
    private List<User> potentialMatches = new ArrayList<User>();

    public BiDirectionalStrategy(List<User> potentialMatches) {
        this.potentialMatches = potentialMatches;
    }

    @Override
    public List<User> match(User userProfile, List<User> candidates) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'match'");
    }
}
