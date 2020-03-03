package com.design.desgin.singleton.singletonExtend;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader;

/**
 * @ClassName:SingletonExtendMethod2
 * @Describe:
 * 这样的方式传递参数会导致参数一直都是第一个创建instance时传入的 paramA，paramB.  一旦instance不被销毁. 后面所有调用getinstance得到的都是第一次创建时的 AB。
 * 而此时这样隐式调用构造函数的方法, 让使用者很难拍查出来问题.
 * @Data:2020/3/39:58
 * @Author:Ago
 * @Version 1.0
 */
public class SingletonExtendMethod2 {

    private static SingletonExtendMethod2 instance = null;

    private Integer paramA;

    private Integer paramB;


    private SingletonExtendMethod2(Integer paramA,Integer paramB){
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static synchronized SingletonExtendMethod2 getInstance(Integer paramA,Integer paramB){
        if(instance == null){
            instance = new SingletonExtendMethod2(paramA,paramB);
        }
        return instance;
    }

    public static void main(String[] args) {
        SingletonExtendMethod2 instance1 = SingletonExtendMethod2.getInstance(10, 20);
        SingletonExtendMethod2 instance2 = SingletonExtendMethod2.getInstance(1, 2);
        System.out.println("A:"+instance1.paramA+" B:"+instance1.paramB);
        System.out.println("A:"+instance2.paramA+" B:"+instance2.paramB);
    }
}
