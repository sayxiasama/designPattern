package com.design.desgin.singleton.EnumOfSingleton;

import java.util.concurrent.atomic.AtomicLong;

public enum EnumOfSingleton {

    INSTANCE;
    private AtomicLong id = new AtomicLong(0);

    public Long getId(){
        return id.incrementAndGet();
    }
    public static void main(String[] args) {
        System.out.println("EnumOfSingleton:"+EnumOfSingleton.INSTANCE.getId());
        System.out.println("EnumOfSingleton:"+EnumOfSingleton.INSTANCE.getId());
        System.out.println("EnumOfSingleton:"+EnumOfSingleton.INSTANCE.getId());
    }
}
