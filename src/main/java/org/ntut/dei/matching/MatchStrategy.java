package org.ntut.dei.matching;

import java.util.List;

import org.ntut.dei.models.UserProfile;

public interface MatchStrategy {
    List<UserProfile> match(UserProfile userProfile, List<UserProfile> candidates);
}
