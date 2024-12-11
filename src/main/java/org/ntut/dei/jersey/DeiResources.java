package org.ntut.dei.jersey;

import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

import org.ntut.dei.dto.UserRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/api")
public class DeiResources {
    private static final Logger logger = LoggerFactory.getLogger(DeiResources.class);

    @POST
    @Path("/match")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response match(@Valid UserRequest userRequest) {
        logger.info("matching users...");
        List<String> response = new ArrayList<>();
        return Response.ok(response).build();
    }
}
