package com.xxx.design.singleton;

import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @author sicwen
 * @date 2019/01/11
 */
public class SingletonTest {
    @Test
    public void testSingleton() throws IOException {
        final CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                        SingletonObject.getInstance();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            t.start();
        }
        latch.countDown();
        System.in.read();
    }
}
