package com.design.proxy.method;

/**
 * @ClassName:SourceMethod
 * @Describe:
 *  被代理的类.
 * @Data:2020/3/413:28
 * @Author:Ago
 * @Version 1.0
 */
public class SourceMethod implements  ISourceMethod{
    @Override
    public String methodInvokeTest() {
        System.out.println("-------- invoke success !");
        return "find me :)";
    }
}
