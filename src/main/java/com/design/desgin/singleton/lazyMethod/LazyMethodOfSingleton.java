package com.design.desgin.singleton.lazyMethod;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式实现(懒汉模式)
 * 与 饿汉模式相对比 优点: 支持了懒加载 即 方法调用时才进行加载
 * 缺点: synchronized修饰 导致方法的并发性能大大降低， 如果量化为1的话,相当如串行操作. 若该方法在项目中被频繁调用, 容易倒持项目性能瓶颈.
 */
public class LazyMethodOfSingleton {

    private AtomicLong id = new AtomicLong(0);

    private static LazyMethodOfSingleton instance;

    private LazyMethodOfSingleton() {
    }

    public static synchronized LazyMethodOfSingleton getInstance() { //对象级别的锁
        if (instance == null) {
            instance =  new LazyMethodOfSingleton();
        }
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println("LazyMethodOfSingleton : "+LazyMethodOfSingleton.getInstance().getId());
        System.out.println("LazyMethodOfSingleton : "+LazyMethodOfSingleton.getInstance().getId());
        System.out.println("LazyMethodOfSingleton : "+LazyMethodOfSingleton.getInstance().getId());
    }
}
