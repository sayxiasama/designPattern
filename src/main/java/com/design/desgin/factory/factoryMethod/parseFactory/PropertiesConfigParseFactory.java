package com.design.desgin.factory.factoryMethod.parseFactory;


import com.design.desgin.factory.common.parse.IRuleConfigParse;
import com.design.desgin.factory.common.parse.PropertiesConfigParse;

/**
 * @ClassName:PropertiesConfigParseFactory
 * @Describe:
 * @Data:2020/3/314:49
 * @Author:Ago
 * @Version 1.0
 */
public class PropertiesConfigParseFactory implements IRuleConfigPaseFactory {
    @Override
    public IRuleConfigParse createParse() {
        System.out.println("this is PropertiesConfigParseFactory !!!!");
        return new PropertiesConfigParse();
    }
}
