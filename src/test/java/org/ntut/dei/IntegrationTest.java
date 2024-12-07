package org.ntut.dei;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.ntut.dei.matching.MatchingEngine;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

public class IntegrationTest {
    @Test
    public void testIntegration() {
        // Integration test
        UserProfile alexProfile = new UserProfileBuilder()
                .setName("Alex")
                .setAge(20)
                .setGenderIdentity(GenderIdentityEnum.MALE)
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL)
                .build();
        PreferenceProfile alexPreference = new PreferenceProfileBuilder()
                .setAgeRange(18, 25)
                .setPreferedGenderIdentityWithEnum(List.of(GenderIdentityEnum.FEMALE))
                .addPreferenceGenderIdentityWithEnum(GenderIdentityEnum.CUSTOM, "Helicopter")
                .setPreferedInterests(List.of("Music", "Movies"))
                .build();
        alexProfile.setPreferenceProfile(alexPreference);
        User alex = new User(alexProfile);

        UserProfile aliceProfile = new UserProfileBuilder()
                .setName("Alice")
                .setAge(22)
                .setGenderIdentity(GenderIdentityEnum.CUSTOM, "Helicopter")
                .setSexualOrientation(SexualOrientation.PANSEXUAL)
                .build();
        PreferenceProfile alicePreference = new PreferenceProfileBuilder()
                .setAgeRange(20, 30)
                .setPreferedInterests(List.of("Music", "Movies"))
                .build();
        aliceProfile.setPreferenceProfile(alicePreference);
        User alice = new User(aliceProfile);

        List<User> users = List.of(alex, alice);

        MatchingEngine engine = new MatchingEngine();
    }
}
