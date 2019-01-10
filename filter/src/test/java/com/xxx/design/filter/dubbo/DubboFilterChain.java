package com.xxx.design.filter.dubbo;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * dubbo中，invoker的过滤器实现
 */
public class DubboFilterChain {

    /**
     * 存放注册的Filter
     */
    private List<Filter> filters = new ArrayList<>(3);

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    /**
     * 使用chain将Filter串连起来
     * @param chain
     * @return
     */
    public FilterChain buildFilterChain(FilterChain chain){
        FilterChain last = chain;
        for (int i = filters.size() - 1; i >= 0; i--) {
            final Filter filter = filters.get(i);
            final FilterChain next = last;
            last = new FilterChain() {
                @Override
                public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
                    filter.doFilter(request,response,next);
                }
            };
        }
        return last;
    }

}
