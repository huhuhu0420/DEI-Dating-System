package org.ntut.dei.jersey;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        packages("org.ntut.dei.jersey");
    }
}
