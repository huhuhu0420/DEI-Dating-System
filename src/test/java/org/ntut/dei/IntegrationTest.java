package org.ntut.dei;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.DefaultMatchStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;
import org.ntut.dei.specifications.SpecificationBuilder;

public class IntegrationTest {
        @Test
        public void testIntegration() {
                // Integration test
                UserProfile alexProfile = new UserProfileBuilder()
                                .setName("Alex")
                                .setAge(20)
                                .setGenderIdentityWithEnum(GenderIdentityEnum.MALE)
                                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                                .setInterests(List.of("Music"))
                                .build();
                PreferenceProfile alexPreference = new PreferenceProfileBuilder()
                                .setAgeRange(18, 25)
                                .setPreferedGenderIdentityWithEnum(List.of(GenderIdentityEnum.FEMALE))
                                .addPreferenceGenderIdentityWithEnum(GenderIdentityEnum.CUSTOM, "Helicopter")
                                .setPreferedInterests(List.of("Music", "Movies"))
                                .build();
                alexProfile.setPreferenceProfile(alexPreference);
                User alex = UserFactory.createUser(alexProfile, false);

                UserProfile aliceProfile = new UserProfileBuilder()
                                .setName("Alice")
                                .setAge(22)
                                .setGenderIdentity(GenderIdentityEnum.CUSTOM, "Helicopter")
                                .setSexualOrientation(SexualOrientation.PANSEXUAL)
                                .setInterests(List.of("Music"))
                                .build();
                PreferenceProfile alicePreference = new PreferenceProfileBuilder()
                                .setAgeRange(10, 30)
                                .setPreferedInterests(List.of("Music", "Movies"))
                                .build();
                aliceProfile.setPreferenceProfile(alicePreference);
                User alice = UserFactory.createUser(aliceProfile, true);

                UserProfile bobProfile = new UserProfileBuilder()
                                .setName("Bob")
                                .setAge(25)
                                .setGenderIdentityWithEnum(GenderIdentityEnum.FEMALE)
                                .setInterests(List.of("Movies"))
                                .build();
                PreferenceProfile bobPreference = new PreferenceProfileBuilder()
                                .setAgeRange(20, 30)
                                .addPreferenceGenderIdentityWithEnum(GenderIdentityEnum.CUSTOM, "Airplane")
                                .build();
                bobProfile.setPreferenceProfile(bobPreference);
                User bob = UserFactory.createUser(bobProfile, false);

                List<User> users = List.of(alex, alice, bob);

                SpecificationBuilder specificationBuilder = new SpecificationBuilder();

                MatchingEngine engine = new MatchingEngine(users);
                engine.setMatchStrategy(new BiDirectionalStrategy());
                List<User> matches = engine.match(alex, specificationBuilder);
                assertEquals(1, matches.size());

                engine.setMatchStrategy(new DefaultMatchStrategy());
                matches = engine.match(alex, specificationBuilder);
                assertEquals(2, matches.size());
                assertTrue(matches.get(0).isPremium());

        }
}
