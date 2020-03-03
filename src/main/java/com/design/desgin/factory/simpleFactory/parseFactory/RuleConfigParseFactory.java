package com.design.desgin.factory.simpleFactory.parseFactory;


import com.design.desgin.factory.common.parse.IRuleConfigParse;
import com.design.desgin.factory.common.parse.JsonRuleConfigParse;
import com.design.desgin.factory.common.parse.PropertiesConfigParse;

import java.util.HashMap;
import java.util.Map;

public class RuleConfigParseFactory {

    // method 1
    public static IRuleConfigParse createParse(String configFormat) throws IllegalAccessException {
        IRuleConfigParse parse = null;

        if (configFormat.equalsIgnoreCase("json")) {
            parse = new JsonRuleConfigParse();
        } else if (configFormat.equalsIgnoreCase("properties")) {
            parse = new PropertiesConfigParse();
        }
        return parse;
    }

    //method 2
    private static final Map<String, IRuleConfigParse> cachedParse = new HashMap<>();

    static {
        cachedParse.put("json", new JsonRuleConfigParse());
        cachedParse.put("properties", new PropertiesConfigParse());
    }

    public static IRuleConfigParse createParse2(String configFormat) throws IllegalAccessException {
        if (configFormat == null || cachedParse.isEmpty()) {
            throw new IllegalAccessException("configFormat is not be null ");
        }
        IRuleConfigParse parse = cachedParse.get(configFormat);
        System.out.println("this is createMethod 2 ! ");
        return parse;
    }
}
