package com.design.desgin.singleton.singletonExtend;

/**
 * @ClassName:SingletonExtendMethod3
 * @Describe:
 *将参数放到另外一个全局变量中。
 * 具体的代码实现如下。
 * Config 是一个存储了 paramA 和 paramB 值的全局变量。
 * 里面的值既可以像下面的代码那样通过静态常量来定义，也可以从配置文件中加载得到。
 * 实际上，这种方式是最值得推荐的
 * @Data:2020/3/310:11
 * @Author:Ago
 * @Version 1.0
 */
public class SingletonExtendMethod3 {

     private static  SingletonExtendMethod3 instance = null ;

     private Integer paramA;

     private Integer paramB;

     private SingletonExtendMethod3(){
         this.paramA = SingletonExtendMethod3Config.paramA;
         this.paramB = SingletonExtendMethod3Config.paramB;
     }

     public static SingletonExtendMethod3 getInstance(){
         if(instance == null ){
             instance = new SingletonExtendMethod3();
         }
         return instance;
     }

    public static void main(String[] args) {
        SingletonExtendMethod3 instance = SingletonExtendMethod3.getInstance();
        System.out.println(instance.paramA);
    }
}
