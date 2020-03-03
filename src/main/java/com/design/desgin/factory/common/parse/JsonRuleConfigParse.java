package com.design.desgin.factory.common.parse;


import com.design.desgin.factory.common.bean.RuleConfig;

/**
 * @ClassName:JsonRuleConfigParse
 * @Describe:
 * @Data:2020/3/313:34
 * @Author:Ago
 * @Version 1.0
 */
public class JsonRuleConfigParse implements IRuleConfigParse {
    @Override
    public RuleConfig parseConfig() {
        System.out.println("this is JsonRuleConfigParse!");
        return null;
    }
}
