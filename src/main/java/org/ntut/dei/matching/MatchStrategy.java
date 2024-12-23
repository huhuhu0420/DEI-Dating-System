package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.User;
import org.ntut.dei.specifications.SpecificationBuilder;

public interface MatchStrategy {
    List<User> match(User user, List<User> candidates, SpecificationBuilder specificationBuilder);
}
