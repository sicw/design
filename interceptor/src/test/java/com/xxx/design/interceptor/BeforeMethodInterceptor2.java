package com.xxx.design.interceptor;

import com.xxx.design.interceptor.api.MethodInterceptorDemo;
import com.xxx.design.interceptor.api.MethodInvocationDemo;

/**
 * @author sicwen
 * @date 2019/01/22
 */
public class BeforeMethodInterceptor2 implements MethodInterceptorDemo {
    @Override
    public Object invoke(MethodInvocationDemo mi) {
        System.out.println("before method advice 2 ......");
        return mi.proceed();
    }
}
