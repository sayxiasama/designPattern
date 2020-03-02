package com.design.desgin.singleton.staticInnerClass;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName:StaticInnerClassOfSingleton
 * @Describe:
 * @Data:2020/3/216:17
 * @Author:Ago
 * @Version 1.0
 */

/**
 * 单例模式实现(静态内部类)
 * SingletonHolder是一个静态内部类，当外部类被创建的时候,并不会创建内部类的实例对象, 只有调用getInstance的时候才会创建内部类对象.
 * insance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载
 */
public class StaticInnerClassOfSingleton {

    private AtomicLong id = new AtomicLong();

    private static class SingleTonHolder{
        private static final StaticInnerClassOfSingleton instance = new StaticInnerClassOfSingleton();
    }

    public static StaticInnerClassOfSingleton getInstance(){
        return SingleTonHolder.instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println("StaticInnerClassOfSingleton:"+StaticInnerClassOfSingleton.getInstance().getId());
        System.out.println("StaticInnerClassOfSingleton:"+StaticInnerClassOfSingleton.getInstance().getId());
        System.out.println("StaticInnerClassOfSingleton:"+StaticInnerClassOfSingleton.getInstance().getId());
    }
}
