package org.ntut.dei.jersey;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.ntut.dei.Main;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JettyServer {
    private static final Logger logger = LoggerFactory.getLogger(JettyServer.class);

    public static void main(String args[]) throws Exception {
        logger.info("Starting Jetty server...");
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        context.setContextPath("/");

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setResourceBase(Main.class.getClassLoader().getResource("webapp").toExternalForm());
        resourceHandler.setDirectoriesListed(false); // Disable directory listing
        resourceHandler.setWelcomeFiles(new String[] { "index.html" }); // Set default page

        HandlerList handlers = new HandlerList();

        org.eclipse.jetty.servlet.ServletHolder jerseyServlet = context.addServlet(ServletContainer.class, "/*");
        jerseyServlet.setInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,
                JerseyConfig.class.getName());

        handlers.addHandler(resourceHandler);
        handlers.addHandler(context);

        server.setHandler(handlers);

        try {
            server.start();
            logger.info("Jetty server started on port 8080.");
            server.join();
        } finally {
            server.destroy();
            logger.info("Jetty server stopped.");
        }
    }
}
