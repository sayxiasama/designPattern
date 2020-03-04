package com.design.proxy.method;

/**
 * describe:
 * jdk代理, 被代理对象的接口
 * 注: 使用jdk动态代理的话, 必须要使用接口.
 * 原因: 因为jdk动态代理是程序运行中根据被代理类的接口来动态生成代理类的class文件，
 * 由于java是单继承， 运行时生成的代理类已经集成了 Proxy类，不能再集成其他类，所以只能通过实现被代理类的接口的形式。 所以jdk动态代理，代理类必须要有接口.
 * author: Ago
 */
public interface ISourceMethod {

    String methodInvokeTest();
}
