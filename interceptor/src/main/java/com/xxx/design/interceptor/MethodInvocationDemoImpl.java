package com.xxx.design.interceptor;

import com.xxx.design.interceptor.api.MethodInterceptorDemo;
import com.xxx.design.interceptor.api.MethodInvocationDemo;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;


/**
 * @author sicwen
 * @date 2019/01/22
 */
public class MethodInvocationDemoImpl implements MethodInvocationDemo {

    /**
     * 被代理的对象
     */
    private Object target;

    /**
     * 被增强的方法
     */
    private Method method;

    /**
     * 方法参数
     */
    private Object[] params;

    /**
     * 存放所有的拦截器
     */
    private List<MethodInterceptorDemo> list = new LinkedList<>();

    /**
     * 当前拦截器的下标
     */
    private int currentInterceptorIndex = -1;

    public void addInterceptor(MethodInterceptorDemo e){
        list.add(e);
    }

    @Override
    public Object proceed() {
        if(currentInterceptorIndex == list.size()-1){
            //调用没有代理时的方法.
            System.out.println("被代理的方法......");
            return null;
        }
        MethodInterceptorDemo interceptor = list.get(++currentInterceptorIndex);
        //这里把this传进去，在实际的拦截器中再调用proceed 继续调用下一个拦截器.
        return interceptor.invoke(this);
    }
}
