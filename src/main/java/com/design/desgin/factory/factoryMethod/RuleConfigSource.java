package com.design.desgin.factory.factoryMethod;

import com.design.desgin.factory.common.bean.RuleConfig;
import com.design.desgin.factory.common.parse.IRuleConfigParse;
import com.design.desgin.factory.factoryMethod.parseFactory.IRuleConfigParseFactoryMap;
import com.design.desgin.factory.factoryMethod.parseFactory.IRuleConfigPaseFactory;

/**
 * @ClassName:RuleConfigSource
 * @Describe:
 *  同样模仿简单工厂的业务场景 使用  工厂方法实现.
 * @Data:2020/3/314:35
 * @Author:Ago
 * @Version 1.0
 */
public class RuleConfigSource {

    // load
    public RuleConfig load(String filePath) throws IllegalAccessException {
        String extension = getFileExtension(filePath);
        IRuleConfigPaseFactory parseFactory = IRuleConfigParseFactoryMap.getParseFactory(extension);
        if(parseFactory == null  ){
            throw  new IllegalAccessException("filePath is bad!");
        }
        IRuleConfigParse parse = parseFactory.createParse();
        String configText = ""; // 解析后的内容
        RuleConfig ruleConfig = parse.parseConfig();

        return ruleConfig;
    }


    // reslovepath
    public String  getFileExtension(String filePath){
        //...省略解析步骤

        return "json";
    }

    public static void main(String[] args) throws IllegalAccessException {
        RuleConfigSource source = new RuleConfigSource();
        source.load("xxx.json");
    }
}
