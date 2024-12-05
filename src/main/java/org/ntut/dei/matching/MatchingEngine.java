package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.UserProfile;

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

    public List<UserProfile> match(UserProfile userProfile, List<UserProfile> candidates) {
        return matchingStrategy.match(userProfile, candidates);
    }
}
