package org.auctionproject.web.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by bishal on 3/13/17.
 */
public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

//    private String TMP_FOLDER = "/tmp";
//    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024;


    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        ServletRegistration.Dynamic appServlet = servletContext.addServlet("mvc", new DispatcherServlet(
//                new GenericWebApplicationContext()));
//
//        appServlet.setLoadOnStartup(1);
//
//        MultipartConfigElement multipartConfigElement = new MultipartConfigElement(TMP_FOLDER,
//                MAX_UPLOAD_SIZE, MAX_UPLOAD_SIZE * 2, MAX_UPLOAD_SIZE / 2);
//
//        appServlet.setMultipartConfig(multipartConfigElement);
//    }
}
