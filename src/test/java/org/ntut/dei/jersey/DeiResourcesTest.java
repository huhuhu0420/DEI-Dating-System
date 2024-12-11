package org.ntut.dei.jersey;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.jupiter.api.Test;
import org.ntut.dei.dto.UserRequest;
import org.ntut.dei.models.GenderIdentity;
import org.ntut.dei.models.GenderIdentityEnum;

import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

class MatchResourceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(DeiResources.class); // Replace with your resource
    }

    @Test
    void testMatch() {
        UserRequest userRequest = new UserRequest();
        userRequest.setName("Alice");
        userRequest.setAge(25);
        userRequest.setGenderIdentity(new GenderIdentity(GenderIdentityEnum.FEMALE));

        // Send a POST request to the match endpoint
        Response response = target("/api/match").request().post(null);

        // Assert the HTTP response status
        assertEquals(200, response.getStatus(), "Expected HTTP status 200");

        // Assert the response entity
        List<String> responseBody = response.readEntity(List.class);
        assertEquals(0, responseBody.size(), "Expected an empty response list");
    }
}
