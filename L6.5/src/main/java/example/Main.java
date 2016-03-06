package example;

import accountServer.AccountServer;
import accountServer.AccountServerController;
import accountServer.AccountServerControllerMBean;
import accountServer.AccountServerI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import resources.TestResource;
import resources.TestResourceController;
import resources.TestResourceControllerMBean;
import servlets.AdminPageServlet;
import servlets.HomePageServlet;
import servlets.ResourcePageServlet;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;

/**
 * Created by Mike on 04.03.2016.
 */
public class Main {
    static final Logger logger = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            logger.error("Use port as the first argument");
            System.exit(1);
        }

        int port = Integer.valueOf(args[0]);
        logger.info("Starting at http://127.0.0.1:" + port);

        AccountServerI accountServer = new AccountServer(10);
        TestResource testResource = new TestResource();

        AccountServerControllerMBean serverStatistics = new AccountServerController(accountServer);
        TestResourceControllerMBean testResourceStatistics = new TestResourceController(testResource);
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name = new ObjectName("Admin:type=AccountServerController.usersLimit");
        ObjectName name2 = new ObjectName("Admin:type=ResourceServerController");
        mbs.registerMBean(serverStatistics, name);
        mbs.registerMBean(testResourceStatistics, name2);

        Server server = new Server(port);
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new HomePageServlet(accountServer)), HomePageServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new AdminPageServlet(accountServer)), AdminPageServlet.PAGE_URL);
        context.addServlet(new ServletHolder(new ResourcePageServlet(testResourceStatistics)), ResourcePageServlet.PAGE_URL);

        ResourceHandler resourceHandler = new ResourceHandler();
        resourceHandler.setDirectoriesListed(true);
        resourceHandler.setResourceBase("static");

        HandlerList handlers = new HandlerList();
        handlers.setHandlers(new Handler[]{resourceHandler, context});
        server.setHandler(handlers);

        server.start();
        logger.info("Server started");
        server.join();
    }
}
