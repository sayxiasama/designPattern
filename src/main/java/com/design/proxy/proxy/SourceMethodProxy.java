package com.design.proxy.proxy;

import com.design.proxy.method.ISourceMethod;
import com.design.proxy.method.SourceMethod;
import com.google.common.collect.Lists;

import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @ClassName:SourceMethodProxy
 * @Describe:
 * SourceMethod代理类
 * @Data:2020/3/413:29
 * @Author:Ago
 * @Version 1.0
 */
public class SourceMethodProxy {

    private Class<?> [] interfacesMethod ;

    private static List<Class<?> []> list = Lists.newArrayList();

    public static Object createProxy(Object proxyObject){
        //获取代理类实现的第一个接口.
        Class<?>[] interfaces = proxyObject.getClass().getInterfaces();

        //创建动态代理处理函数类. (该类实现了InvocationHandler接口, 我们常说的invoke方法再该类中实现)
        DynamicProxyHandler handler = new DynamicProxyHandler(proxyObject);
        //返回一个代理类的实例.
        return Proxy.newProxyInstance(proxyObject.getClass().getClassLoader(), interfaces, handler);
    }



   /*   该方法暂时未想到 不依赖spring框架如何实现为多个类生成代理对象 :(
        public static Object createProxy(){
        Reflections reflections = new Reflections();
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ProxyMethod.class);
        Iterator<Class<?>> iterator = typesAnnotatedWith.iterator();
        while(iterator.hasNext()){
            Class<?> next = iterator.next();
            Class<?>[] interfaces1 = next.getInterfaces();
            list.add(interfaces1);
        }
    }*/



    public static void main(String[] args) {
        SourceMethodProxy proxy = new SourceMethodProxy();
        ISourceMethod method = (ISourceMethod) proxy.createProxy(new SourceMethod());
        /*
          经过断点跟踪我们发现程序直到调用代理类方法时才会进入 DynamicProxyHandler中的invoke方法
          因为在动态代理类的定义中，构造函数是含参的构造，参数就是我们invocationHandler 实例，
          而每一个被代理接口的方法都会在代理类中生成一个对应的实现方法，并在实现方法中最终调用invocationHandler 的invoke方法，
          这就解释了为何执行代理类的方法会自动进入到我们自定义的invocationHandler的invoke方法中，
          然后在我们的invoke方法中再利用jdk反射的方式去调用真正的被代理类的业务方法，而且还可以在方法的前后去加一些我们自定义的逻辑。比如切面编程AOP等。
        */
        method.methodInvokeTest();
    }
}
