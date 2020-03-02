package com.design.desgin.singleton.hugryMethod;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 单例模式实现(懒汉模式)
 * 在类加载的时候 instance实例就已经创建好了，所以是instance实例的创建过程是线程安全的.
 * 但是这样的实现方式不支持懒加载(HugryMethodOfSingleton 被用到的时候才加载)
 */
public class HugryMethodOfSingleton {

    private AtomicLong id = new AtomicLong(0);

    private static final HugryMethodOfSingleton  instance = new HugryMethodOfSingleton();

    private HugryMethodOfSingleton() {
    }

    public static HugryMethodOfSingleton getInstance(){
        return instance;
    }

    public Long getId(){
        return id.incrementAndGet();
       /* ps: 这里 AtomicLong 中的两个方法简单说明一下
       * incrementAndGet(param)
       * return param + 1; 先+1 后返回
       *
       * getAndIncrement(param)
       * temp = param;
       * param = temp +1;
       * return temp;
       *    先返回param 后加 1
       * */


    }


    public static void main(String[] args) {
        System.out.println(HugryMethodOfSingleton.getInstance().getId());
        System.out.println(HugryMethodOfSingleton.getInstance().getId());
        System.out.println(HugryMethodOfSingleton.getInstance().getId());
    }
}
