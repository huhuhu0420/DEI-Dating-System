package org.ntut.dei.jersey;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.validation.ValidationFeature;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("org.ntut.dei.jersey");
        register(JacksonFeature.class);
        register(ValidationFeature.class);
    }
}
