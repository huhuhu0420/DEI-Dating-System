package org.ntut.dei.matching;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class DefaultMatchStrategyTest {

    private MatchStrategy matchStrategy;
    private User user;
    private List<User> candidates;

    @BeforeEach
    public void setUp() {
        matchStrategy = new DefaultMatchStrategy();
        candidates = new ArrayList<User>();

        UserProfile user1 = new UserProfileBuilder()
                .setName("user1")
                .setAge(20)
                .setGenderIdentity(GenderIdentityEnum.MALE)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .build();
        user = new User(user1);
        candidates.add(user);

        UserProfile user2 = new UserProfileBuilder()
                .setName("user2")
                .setAge(20)
                .setGenderIdentity(GenderIdentityEnum.FEMALE)
                .setSexualOrientation(SexualOrientation.OTHER)
                .build();
        candidates.add(new User(user2));

        UserProfile user3 = new UserProfileBuilder()
                .setName("user3")
                .setAge(20)
                .setGenderIdentity(GenderIdentityEnum.CUSTOM, "custom")
                .build();
        candidates.add(new User(user3));
    }

    @Test
    public void testMatch() {
        List<User> matches = matchStrategy.match(user, candidates);
        assertEquals(1, matches.size());
        assertEquals("user2", matches.get(0).getUsername());
    }
}
