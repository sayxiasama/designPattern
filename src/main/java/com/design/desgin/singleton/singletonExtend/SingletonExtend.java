package com.design.desgin.singleton.singletonExtend;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @ClassName:SingletonExtend
 * @Describe: 扩展:  普通单例模式 不支持显示创建 所以我们如果需要创建带有参数的单例对象 可以使用下面的方法
 * @Data:2020/3/218:07
 * @Author:Ago
 * @Version 1.0
 */
public class SingletonExtend {

    // method 1:

    private static SingletonExtend instance = null;

    private final int paramA;

    private final int paramB;

    private SingletonExtend(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static SingletonExtend getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first");
        }
        return instance;
    }

    public static SingletonExtend init(int paramA, int paramB) {
        if (instance != null) {
            throw new RuntimeException("singletonExtend has been created");
        }
        instance = new SingletonExtend(paramA, paramB);

        return instance;
    }

    public static void main(String[] args) {
        SingletonExtend.init(10,50);
        SingletonExtend instance = SingletonExtend.getInstance();
        System.out.println(instance.paramA);
        System.out.println(instance.paramB);
    }
}
