package org.ntut.dei.jersey;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/hello")
public class DeiResources {
    private static final Logger logger = LoggerFactory.getLogger(DeiResources.class);

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello() {
        logger.info("Saying hello...");
        return "Hello, World!";
    }
}
