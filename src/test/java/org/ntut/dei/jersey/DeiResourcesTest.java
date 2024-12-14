package org.ntut.dei.jersey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ntut.dei.dto.UserData;
import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;
import org.ntut.dei.models.PreferenceProfile;
import org.ntut.dei.models.PreferenceProfileBuilder;
import org.ntut.dei.models.SexualOrientation;
import org.ntut.dei.models.User;
import org.ntut.dei.models.UserFactory;
import org.ntut.dei.models.UserProfile;
import org.ntut.dei.models.UserProfileBuilder;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

class DeiResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(DeiResources.class);
    }

    @BeforeEach
    public void setUp() throws Exception {
        super.setUp();
        UserFactory.clearUsers();
    }

    @Test
    void testMatch() {
        UserData userRequest = new UserData();
        userRequest.setName("Alice");
        userRequest.setAge(25);
        userRequest.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.FEMALE));
        userRequest.setSexualOrientation(SexualOrientation.HETEROSEXUAL);
        userRequest.setPreferedMinAge(20);
        userRequest.setPreferedMaxAge(30);

        UserProfile userProfile = new UserProfileBuilder().setName("Bob").setAge(40)
                .setGenderIdentity(new GenderIdentity(GenderIdentityEnum.MALE))
                .setSexualOrientation(SexualOrientation.HETEROSEXUAL).build();
        PreferenceProfile preferenceProfile = new PreferenceProfileBuilder().setAgeRange(20, 30).build();
        userProfile.setPreferenceProfile(preferenceProfile);
        UserFactory.addUser(UserFactory.createUser(userProfile, false));

        // Send a POST request to the match endpoint
        Response response = target("/api/match").request().post(jakarta.ws.rs.client.Entity.json(userRequest));

        // Assert the HTTP response status
        assertEquals(200, response.getStatus(), "Expected HTTP status 200");

        // Assert the response entity
        @SuppressWarnings("unchecked")
        List<String> responseBody = response.readEntity(List.class);
        System.err.println(responseBody);
        assertEquals(0, responseBody.size(), "Expected an empty response list");
    }

    @Test
    void testCreateUser() {
        UserData userRequest = new UserData();
        userRequest.setName("Alice");
        userRequest.setAge(25);
        userRequest.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.FEMALE));

        // Send a POST request to the user endpoint
        Response response = target("/api/user").request().post(jakarta.ws.rs.client.Entity.json(userRequest));
        List<User> users = UserFactory.getUsers();

        // Assert the HTTP response status
        assertEquals(200, response.getStatus(), "Expected HTTP status 200");

        // Assert the response entity
        assertEquals(1, users.size(), "Expected a single user in the list");
    }

}
