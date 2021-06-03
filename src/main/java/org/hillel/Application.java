package org.hillel;

import org.hillel.config.WebJspConfig;
import org.hillel.filter.CharsetEncodingFilter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
//import org.springframework.web.filter.CharacterEncodingFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.Filter;
import java.nio.charset.StandardCharsets;


//public class Application {
//public class Application extends AbstractDispatcherServletInitializer {  // first variant
public class Application extends AbstractAnnotationConfigDispatcherServletInitializer {  // second variant
    // ======================  second  variant ====================================

    @Override
    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebJspConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/welcome", "/auth"};
    }

    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName())};
    }

    // ======================  first  variant ====================================
   /* @Override
    protected WebApplicationContext createServletApplicationContext() {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(WebJspConfig.class);
        return annotationConfigWebApplicationContext;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/welcome"};
    }



    @Override
    protected WebApplicationContext createRootApplicationContext() {
        return null;
    }*/
// this is before create controller
/*implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {  // получает servletContext от tomcat'a
        // это и есть по сути есть qweb.xm_
        final ServletRegistration.Dynamic welcomeServlet = servletContext.addServlet("welcomeServlet", WelcomeServlet.class);
        welcomeServlet.addMapping("/welcome");
        final ServletRegistration.Dynamic authServlet = servletContext.addServlet("authServlet", AuthenticationServlet.class);
        authServlet.addMapping("/auth");
        FilterRegistration.Dynamic charsetFilter = servletContext.addFilter("charsetFilter", new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName()));
        charsetFilter.addMappingForUrlPatterns(null, true, "/*");
            }*/


}
