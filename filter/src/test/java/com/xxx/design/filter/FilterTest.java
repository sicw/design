package com.xxx.design.filter;

import com.xxx.design.filter.dubbo.DubboFilterChain;
import com.xxx.design.filter.servlet.ServletFilterChain;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class FilterTest {
    @Test
    public void testServletFilter() throws Exception {
        ServletFilterChain chain = new ServletFilterChain();
        chain.addFilter(new Filter1());
        chain.addFilter(new Filter2());
        chain.addFilter(new Filter3());
        chain.doFilter(null,null);
    }

    @Test
    public void testDubboFilter() throws Exception {
        DubboFilterChain chain = new DubboFilterChain();
        chain.addFilter(new Filter1());
        chain.addFilter(new Filter2());
        chain.addFilter(new Filter3());
        chain.buildFilterChain(new EmptyDubboFilter()).doFilter(null,null);
    }


    private class EmptyDubboFilter implements FilterChain{
        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            //do nothing
        }
    }

}