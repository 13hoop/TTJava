package com.yongren.github.com.yongren.github.ThreadDemo;


/**
 *  Process: 资源分配的最小单位
 *  Thread： CPU调度的最小单位
 *
 *  Java中的多线程从语言角度来说就是3个接口 Thread，Runable， Callable， 在此基础上组合Future和线程池
 *
 *
 *  5种state
 *  new，runable，running，blocked，dead
 *
 *
 *
 *  concurrency & parallelism
 */

public class YRTheadDemo {

    public static void main(String[] args) {
        ThreadA a = new ThreadA();
//        a.run();
        a.start();
    }
}

class ThreadA extends Thread {
    int times = 0;
    boolean stoped = false;
    public void run() {
        stoped = true;
        while (stoped) {
            times++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getCurrentClassAndMethodNames() + " ~ " + this.times);

//            if(times == 10) this.stop();
            if(times == 10) {
                stoped = false;
                Thread.yield();
            }
        }
    }

    public void metherName() {
        System.out.println(this.getCurrentClassAndMethodNames());
    }

    public String getCurrentClassAndMethodNames() {
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
        final StackTraceElement e = stack[2];
        final String s = e.getClassName();
        return s.substring(s.lastIndexOf('.') + 1, s.length()) + "." + e.getMethodName();
    }
}