package com.xxx.design.singleton;

/**
 * @author sicwen
 * @date 2019/01/11
 */
public class SingletonObject {
    /**
     * 私有化构造，不允许外界创建对象
     */
    private SingletonObject(){
        System.out.println("SingletonObject.SingletonObject");
    }

    /**
     * 使用volatile修饰，防止由内存可见性原因导致多次创建实例.
     */
    private static volatile SingletonObject instance;

    public static SingletonObject getInstance(){
        if(instance == null) {
            synchronized (SingletonObject.class) {
                //有可能instance已经被其中一个线程修改了，但是主内存中的instance没有及时更新.
                //所以instance要使用volatile修饰.
                if (instance == null) {
                    instance = new SingletonObject();
                }
            }
        }
        return instance;
    }
}