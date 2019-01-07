package com.xxx.filter;

import javax.servlet.*;
import java.io.IOException;

public class Filter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter2.init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter2.doFilter");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        System.out.println("Filter2.destroy");
    }
}
