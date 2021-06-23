package org.hillel;

import org.hillel.config.RootConfig;
import org.hillel.config.WebJspConfig;
import org.hillel.config.WebTLConfig;
import org.hillel.filter.CharsetEncodingFilter;
import org.hillel.servlet.AuthenticationServlet;
import org.hillel.servlet.WelcomeServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.support.AbstractDispatcherServletInitializer;

import javax.servlet.*;
import java.nio.charset.StandardCharsets;

public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {  // получает servletContext от tomcat'a


        // =====  этот глобальный аппликешнконтекст, который содержит все необходимые бины в системе, кроме бинов в контроллере =======
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class);
        servletContext.addListener(new ContextLoaderListener(rootConfig));// tomcat понимает, что у нас есть спринг и пытается поднять
        // applicationContext, и этот applicationContext включить в servletcontext api, т.е. в  tomcat
        // -------------------------------------------------------------------------------------------------



        // ===== этот аппликешнконтекст содержит бины, необходимые для работы jsp mvc ===================================================
        AnnotationConfigWebApplicationContext jspAppContext = new AnnotationConfigWebApplicationContext();
        jspAppContext.register(WebJspConfig.class);

        ServletRegistration.Dynamic jspServlet =
                servletContext.addServlet("jspServlet", new DispatcherServlet(jspAppContext));
        jspServlet.addMapping("/wellcome");
        // -------------------------------------------------------------------------------------------------



        // ===== этот аппликешнконтекст необходим для работы нашего thymeleaf mvc =======================================================
        AnnotationConfigWebApplicationContext tlAppContext = new AnnotationConfigWebApplicationContext();
        tlAppContext.register(WebTLConfig.class);

        ServletRegistration.Dynamic tlServlet =
                servletContext.addServlet("tlServlet", new DispatcherServlet(tlAppContext));
        tlServlet.addMapping("/tl", "/tl/*");
       // -------------------------------------------------------------------------------------------------


        FilterRegistration.Dynamic charsetFilter = servletContext.addFilter("charsetFilter", new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName()));
        charsetFilter.addMappingForUrlPatterns(null, true, "/*");

        servletContext.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"));

    }



}

// second variant

   /* @Override
    protected Class<?>[] getRootConfigClasses() {
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
*/

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
        // это и есть по сути есть web.xml
        final ServletRegistration.Dynamic welcomeServlet = servletContext.addServlet("welcomeServlet", WelcomeServlet.class);
        welcomeServlet.addMapping("/welcome");
        final ServletRegistration.Dynamic authServlet = servletContext.addServlet("authServlet", AuthenticationServlet.class);
        authServlet.addMapping("/auth");
        FilterRegistration.Dynamic charsetFilter = servletContext.addFilter("charsetFilter", new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName()));
        charsetFilter.addMappingForUrlPatterns(null, true, "/*");
            }*/



