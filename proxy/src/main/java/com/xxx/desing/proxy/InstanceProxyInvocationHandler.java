package com.xxx.desing.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class InstanceProxyInvocationHandler implements InvocationHandler {

    private HelloService instance;

    public InstanceProxyInvocationHandler(HelloService instance){
        this.instance = instance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if("sayHello".equals(method.getName())){
            System.out.println("前置增强");
            instance.sayHello();
            System.out.println("后置增强");
        }
        return null;
    }
}
