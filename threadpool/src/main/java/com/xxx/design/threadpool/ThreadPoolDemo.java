package com.xxx.design.threadpool;

import java.util.concurrent.*;

/**
 * @author sicwen
 * @date 2019/01/17
 */
public class ThreadPoolDemo {

    private ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(100);
    private CountDownLatch latch = new CountDownLatch(1);
    private boolean isAlive = true;

    public ThreadPoolDemo(){
        this(3);
    }

    public ThreadPoolDemo(int poolSize){
        for (int i = 0; i < poolSize; i++) {
            new Thread(new RunnableDemo()).start();
        }
        //开始执行线程
        latch.countDown();
    }

    public void execute(Runnable task) throws InterruptedException {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void destory(){
        isAlive = false;
    }

    private class RunnableDemo implements Runnable{
        @Override
        public void run() {
            try {
                //等待所有线程创建完成
                latch.await();
                while(isAlive) {
                    Runnable runnable = queue.poll(1000, TimeUnit.MILLISECONDS);
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
