package org.hillel.filter;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharsetEncodingFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType("text/html;charset=UTF-8"); // указывем, что контент наш будет текстом и хтмл-ом
        chain.doFilter(request, response);
    }
}
