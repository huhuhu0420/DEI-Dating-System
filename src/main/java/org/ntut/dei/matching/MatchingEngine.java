package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.User;
import org.ntut.dei.specifications.SpecificationBuilder;

public class MatchingEngine {
    private MatchStrategy matchingStrategy;
    private List<User> candidates;

    public MatchingEngine(List<User> candidates) {
        this.candidates = candidates;
        this.matchingStrategy = new DefaultMatchStrategy();
    }

    public void setMatchStrategy(MatchStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public List<User> match(User user, SpecificationBuilder specificationBuilder) {
        return matchingStrategy.match(user, candidates, specificationBuilder);
    }
}
