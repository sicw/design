package com.xxx.design.threadpool;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author sicwen
 * @date 2019/01/17
 */
public class ThreadPoolTest {

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo threadPool = new ThreadPoolDemo(3);

        for (int i = 0; i < 100; i++) {
            final int finalI = i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" 执行 "+"Task"+ finalI);
                }
            });
        }
        Thread.sleep(3000);
        threadPool.destory();
    }
}
