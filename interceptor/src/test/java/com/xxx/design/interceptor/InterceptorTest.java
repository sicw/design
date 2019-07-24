package com.xxx.design.interceptor;

import com.xxx.design.interceptor.api.MethodInterceptorDemo;
import org.junit.Test;

/**
 * @author sichengwen
 * @date 2019/07/24
 *
 *
 * 不论是 Filter，Interceptor
 * 都是将类用一个共同的东西串联起来，比如MethodInvocation，ServletFilterChain
 * 然后可以使用proceed(), doFilter() 执行链中的下一个规则
 *
 * 这里还有个技巧就是 在proceed()和doFilter()执行的前和后做一些文章。
 *
 * 比如：
 *     在servlet中
 *     在doFilter前 执行过滤request的操作
 *     执行请求返回response
 *     在doFilter返回后 执行过滤response的操作
 *
 *     在aop中
 *     在proceed()前 执行before增强
 *     执行目标方法
 *     在proceed()返回后 执行after增强
 *
 */
public class InterceptorTest {

    @Test
    public void testAopInterceptor(){
        MethodInterceptorDemo before1 = new BeforeMethodInterceptor1();
        MethodInterceptorDemo before2 = new BeforeMethodInterceptor2();
        MethodInterceptorDemo after1 = new AfterMethodInterceptor1();
        MethodInterceptorDemo after2 = new AfterMethodInterceptor2();

        MethodInvocationDemoImpl invocation = new MethodInvocationDemoImpl();
        invocation.addInterceptor(after2);
        invocation.addInterceptor(before1);
        invocation.addInterceptor(before2);
        invocation.addInterceptor(after1);

        //调用拦截器链
        invocation.proceed();
    }
}
