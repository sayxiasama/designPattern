package com.design.desgin.factory.factoryMethod.parseFactory;

import java.util.HashMap;
import java.util.Map;

public class IRuleConfigParseFactoryMap {

    private static final Map<String,IRuleConfigPaseFactory> cachedFactoryMap = new HashMap<>();

    static{
        cachedFactoryMap.put("json",new JsonRuleParseFactory());
        cachedFactoryMap.put("properties",new PropertiesConfigParseFactory());
    }

    public static IRuleConfigPaseFactory getParseFactory(String fileExtension) throws IllegalAccessException {
        if(fileExtension == null || fileExtension.isEmpty()){
            throw new IllegalAccessException("fileExtension is not be null ");
        }
        IRuleConfigPaseFactory parseFactory = cachedFactoryMap.get(fileExtension);

        return parseFactory;
    }
}
