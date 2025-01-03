package org.ntut.dei;

import java.util.List;

import org.ntut.dei.matching.BiDirectionalStrategy;
import org.ntut.dei.matching.DefaultMatchStrategy;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;
import org.ntut.dei.specifications.SpecificationBuilder;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.PreferenceProfileBuilder;

public class Main {
        public static void main(String[] args) {
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

                MatchingEngine engine = new MatchingEngine(users);
                SpecificationBuilder specificationBuilder = new SpecificationBuilder();
                List<User> matches = List.of();

                engine.setMatchStrategy(new DefaultMatchStrategy());
                matches = engine.match(alex, specificationBuilder);
                System.out.println("Matches for Alex using DefaultMatchStrategy:");
                for (User match : matches) {
                        System.out.println(match.getDescription());
                }

                engine.setMatchStrategy(new BiDirectionalStrategy());
                matches = engine.match(alex, specificationBuilder);
                System.out.println("Matches for Alex using BiDirectionalStrategy:");
                for (User match : matches) {
                        System.out.println(match.getDescription());
                }

        }
}
