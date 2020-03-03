package com.design.desgin.factory.common.parse;


import com.design.desgin.factory.common.bean.RuleConfig;

/**
 * @ClassName:PropertiesConfigParse
 * @Describe:
 * @Data:2020/3/313:35
 * @Author:Ago
 * @Version 1.0
 */
public class PropertiesConfigParse implements IRuleConfigParse {
    @Override
    public RuleConfig parseConfig() {
        System.out.println("this is PropertiesConfigParse!");
        return null;
    }
}
