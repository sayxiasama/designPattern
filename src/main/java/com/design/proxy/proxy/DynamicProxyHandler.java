package com.design.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName:DynamicProxyHandler
 * @Describe:
 * 动态代理的处理函数类,
 * @Data:2020/3/413:34
 * @Author:Ago
 * @Version 1.0
 */
public class DynamicProxyHandler implements InvocationHandler {
    private Object proxyObject;

    public DynamicProxyHandler(Object proxyObject) {
        this.proxyObject = proxyObject;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long s = System.currentTimeMillis();
        //注意: 此处invoke方法中不能使用参数中的proxy, 不然会引起堆栈溢出.
        //原因: 此方法中的proxy是一个代理对象, 调用代理对象的任何方法 都会再一次触发invoke, 导致递归, 又无终止条件，最终导致了堆栈溢出.
        Object result = method.invoke(proxyObject, args);
        long e = System.currentTimeMillis();
        long response =  s - e;
        System.out.println("-----------------------"+ response);
        return result;
    }
}
