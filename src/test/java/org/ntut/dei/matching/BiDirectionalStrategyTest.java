package org.ntut.dei.matching;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.models.BasicUser;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;
import org.ntut.dei.specifications.SpecificationBuilder;

public class BiDirectionalStrategyTest {

    private MatchStrategy matchStrategy;
    private User user;
    private List<User> candidates;

    @BeforeEach
    public void setUp() {
        matchStrategy = new BiDirectionalStrategy();
        candidates = new ArrayList<User>();

        UserProfile user1 = new UserProfileBuilder()
                .setName("user1")
                .setAge(20)
                .setGenderIdentityWithEnum(GenderIdentityEnum.MALE)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .build();
        user = new BasicUser(user1);
        candidates.add(user);

        UserProfile user2 = new UserProfileBuilder()
                .setName("user2")
                .setAge(20)
                .setGenderIdentityWithEnum(GenderIdentityEnum.FEMALE)
                .setSexualOrientation(SexualOrientation.HOMOSEXUAL)
                .build();
        candidates.add(new BasicUser(user2));

        UserProfile user3 = new UserProfileBuilder()
                .setName("user3")
                .setAge(20)
                .setGenderIdentity(GenderIdentityEnum.CUSTOM, "custom")
                .build();
        candidates.add(new BasicUser(user3));
    }

    @Test
    public void testMatch() {
        SpecificationBuilder specificationBuilder = new SpecificationBuilder();
        List<User> matches = matchStrategy.match(user, candidates, specificationBuilder);
        assertEquals(0, matches.size());
    }
}
