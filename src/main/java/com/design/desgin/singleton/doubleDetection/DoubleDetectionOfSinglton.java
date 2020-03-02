package com.design.desgin.singleton.doubleDetection;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例实现模式(双重检测)
 *  综合了 饿汉模式 与 懒汉模式的 优点. 同时还支持懒加载, 并发性能也高于懒汉模式。
 *  一旦instance被创建,再调用getInstance时,也不会触发加锁逻辑. 只有当instance为null的时候才会触发加锁逻辑,
 *
 */
public class DoubleDetectionOfSinglton {

    private AtomicLong id = new AtomicLong(0);
    private static DoubleDetectionOfSinglton instance;

    private DoubleDetectionOfSinglton() {
    }

    public static DoubleDetectionOfSinglton getInstance(){
        if(instance == null ){
            synchronized (DoubleDetectionOfSinglton.class){ //类级别的锁
                if(instance == null ){
                    instance  = new DoubleDetectionOfSinglton();
                }
            }
        }
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
    }

    public static void main(String[] args) {
        System.out.println("DoubleDetection:"+DoubleDetectionOfSinglton.getInstance().getId());
        System.out.println("DoubleDetection:"+DoubleDetectionOfSinglton.getInstance().getId());
        System.out.println("DoubleDetection:"+DoubleDetectionOfSinglton.getInstance().getId());
    }

    /*
    这种实现方式有些问题。因为指令重排序，
    可能会导致 DoubleDetectionOfSinglton 对象被 new 出来，并且赋值给 instance 之后，
    还没来得及初始化（执行构造函数中的代码逻辑），就被另一个线程使用了。
    要解决这个问题，
    我们需要给 instance 成员变量加上 volatile 关键字，禁止指令重排序才行。
    实际上，只有很低版本的 Java 才会有这个问题。
    我们现在用的高版本的 Java 已经在 JDK 内部实现中解决了这个问题
    （解决的方法很简单，只要把对象 new 操作和初始化操作设计为原子操作，就自然能禁止重排序）。
     */
}
