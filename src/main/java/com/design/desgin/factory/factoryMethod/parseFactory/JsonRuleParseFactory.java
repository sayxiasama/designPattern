package com.design.desgin.factory.factoryMethod.parseFactory;


import com.design.desgin.factory.common.parse.IRuleConfigParse;
import com.design.desgin.factory.common.parse.JsonRuleConfigParse;

/**
 * @ClassName:JsonRuleParseFactory
 * @Describe:
 * @Data:2020/3/314:48
 * @Author:Ago
 * @Version 1.0
 */
public class JsonRuleParseFactory implements  IRuleConfigPaseFactory {
    @Override
    public IRuleConfigParse createParse() {
        System.out.println("this is JsonRuleParseFactory !!!");
        return new JsonRuleConfigParse();
    }
}
