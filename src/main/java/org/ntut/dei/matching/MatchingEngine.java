package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.User;

public class MatchingEngine {
    private MatchStrategy matchingStrategy;

    public MatchingEngine() {
        this.matchingStrategy = new DefaultMatchStrategy();
    }

    public MatchingEngine(MatchStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public void setMatchStrategy(MatchStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public List<User> match(User userProfile, List<User> candidates) {
        return matchingStrategy.match(userProfile, candidates);
    }
}
