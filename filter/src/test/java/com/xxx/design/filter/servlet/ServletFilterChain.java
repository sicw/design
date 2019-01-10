package com.xxx.design.filter.servlet;

import javax.servlet.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * java web serlet中，request response的过滤器实现方式
 */
public class ServletFilterChain implements FilterChain {

    /**
     * 存放注册的Filter
     */
    private List<Filter> filters = new ArrayList<>(3);

    public void addFilter(Filter filter){
        filters.add(filter);
    }

    /**
     * 记录Filter的位置
     */
    private int currentFilter = 0;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
        if(currentFilter < filters.size()){
            Filter filter = filters.get(currentFilter++);
            filter.doFilter(request,response,this);
        }
    }
}
