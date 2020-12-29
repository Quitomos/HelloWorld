package com.quitomos.j2ee2.Filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println(((HttpServletRequest) servletRequest).getRequestURL());
        System.out.println("from");
        System.out.println(servletRequest.getRemoteAddr());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
