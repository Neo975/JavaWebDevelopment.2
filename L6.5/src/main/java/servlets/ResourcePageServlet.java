package servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import resources.TestResource;
import resources.TestResourceController;
import resources.TestResourceControllerMBean;
import resources.sax.ReadXMLFileSAX;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Mike on 04.03.2016.
 */
public class ResourcePageServlet extends HttpServlet {
    private final Logger logger = LogManager.getLogger(ResourcePageServlet.class.getSimpleName());
    public static final String PAGE_URL = "/resources";
    private TestResourceControllerMBean testResourceController;

    public ResourcePageServlet(TestResourceControllerMBean testResourceController) {
        this.testResourceController = testResourceController;
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("ResourcePageServlet.doPost(), entry point");
        String pathName = request.getParameter("path");
        if(pathName != null) {
            logger.info("ResourcePageServlet.doPost(), POST parameter path: " + pathName);
            TestResource testResource = (TestResource) ReadXMLFileSAX.readXML(pathName);
            testResourceController.setTestResource(testResource);
            response.getWriter().println("Http request received, parameter path: " + pathName);
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        } else {
            logger.info("ResourcePageServlet.doPost(), POST parameter path is NULL");
            response.getWriter().println("Http request received, parameter path is NULL");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}
