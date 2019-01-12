package com.xxx.design.proxy;

import com.xxx.desing.proxy.HelloService;
import com.xxx.desing.proxy.HelloServiceImpl;
import com.xxx.desing.proxy.InstanceProxyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {

    /**
     * JDK代理接口
     * 为接口动态生产实现类
     */
    @Test
    public void interfaceProxyTest(){
        HelloService service = (HelloService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{HelloService.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                if("sayHello".equals(method.getName())) {
                    System.out.println("Hello");
                }
                return null;
            }
        });

        service.sayHello();

    }

    /**
     * JDK代理实例类
     */
    @Test
    public void instanceProxyTest(){
        HelloService service = (HelloService) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                                                            new Class[]{HelloService.class},
                                                            new InstanceProxyInvocationHandler(new HelloServiceImpl()));
        service.sayHello();
    }

}
