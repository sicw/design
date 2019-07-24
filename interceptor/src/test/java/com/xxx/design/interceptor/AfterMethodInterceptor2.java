package com.xxx.design.interceptor;

import com.xxx.design.interceptor.api.MethodInterceptorDemo;
import com.xxx.design.interceptor.api.MethodInvocationDemo;

/**
 * @author sicwen
 * @date 2019/01/22
 */
public class AfterMethodInterceptor2 implements MethodInterceptorDemo {
    @Override
    public Object invoke(MethodInvocationDemo mi) {
        Object result = mi.proceed();
        System.out.println("after method advice 2 ......");
        return result;
    }
}
