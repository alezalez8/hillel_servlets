package org.hillel;

import org.hillel.servlet.AuthenticationServlet;
import org.hillel.servlet.WelcomeServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.nio.charset.StandardCharsets;

public class Application implements WebApplicationInitializer {
    public void onStartup(ServletContext servletContext) throws ServletException {  // получает servletContext от tomcat'a
        // это и есть по сути есть web.xml
        final ServletRegistration.Dynamic welcomeServlet = servletContext.addServlet("welcomeServlet", WelcomeServlet.class);
        welcomeServlet.addMapping("/welcome");
        final ServletRegistration.Dynamic authServlet = servletContext.addServlet("authServlet", AuthenticationServlet.class);
        authServlet.addMapping("/auth");
        FilterRegistration.Dynamic charsetFilter = servletContext.addFilter("charsetFilter", new CharacterEncodingFilter(StandardCharsets.UTF_8.displayName()));
        charsetFilter.addMappingForUrlPatterns(null, true, "/*");

    }
}
