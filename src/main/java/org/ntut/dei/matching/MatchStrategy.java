package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.User;

public interface MatchStrategy {
    List<User> match(User user, List<User> candidates);
}
