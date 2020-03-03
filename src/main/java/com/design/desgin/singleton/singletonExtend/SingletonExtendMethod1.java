package com.design.desgin.singleton.singletonExtend;

/**
 * @ClassName:SingletonExtend
 * @Describe:
 * Method1:  使用init方法, 调用getInstance之前必须调用init方法传递参数. 不能通过GetInstance直接创建单例对象.
 * @Data:2020/3/218:07
 * @Author:Ago
 * @Version 1.0
 */
public class SingletonExtendMethod1 {

    // method 1:
    private static SingletonExtendMethod1 instance = null;

    private final int paramA;

    private final int paramB;

    private SingletonExtendMethod1(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonExtendMethod1 getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first");
        }
        return instance;
    }

    public static SingletonExtendMethod1 init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("singletonExtend has been created");
        }
        instance = new SingletonExtendMethod1(paramA, paramB);

        return instance;
    }

    public static void main(String[] args) {
        SingletonExtendMethod1.init(10,50);
        SingletonExtendMethod1 instance = SingletonExtendMethod1.getInstance();
        System.out.println(instance.paramA);
        System.out.println(instance.paramB);
    }
}
