package com.xxx.design.filter.aop;

/**
 * @author sicwen
 * @date 2019/01/22
 */
public class MethodInterceptorDemoImpl1 implements MethodInterceptorDemo {
    @Override
    public Object invoke(MethodInvocationDemo mi) {
        System.out.println("拦截器1");
        return mi.proceed();
    }
}
