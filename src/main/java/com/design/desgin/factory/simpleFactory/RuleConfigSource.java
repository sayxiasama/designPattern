package com.design.desgin.factory.simpleFactory;

import com.design.desgin.factory.common.bean.RuleConfig;
import com.design.desgin.factory.common.parse.IRuleConfigParse;
import com.design.desgin.factory.simpleFactory.parseFactory.RuleConfigParseFactory;

/**
 * @ClassName:RuleConfigSource
 * @Describe:
 *  根据不同的文件后缀 获取不同的解析器对象
 * @Data:2020/3/313:32
 * @Author:Ago
 * @Version 1.0
 */
public class RuleConfigSource {

    // load
    public RuleConfig load(String filePath) throws IllegalAccessException {
        String fileExtension =  getFileExtension(filePath);
        IRuleConfigParse parse = RuleConfigParseFactory.createParse2(fileExtension);
        if(parse == null ){
            throw new RuntimeException("fileExtension is not support " + filePath);
        }
        String configText = "";
        RuleConfig ruleConfig = parse.parseConfig();
        return ruleConfig;
    }


    // resolvePath
    public String getFileExtension(String filePath){
        //...省略解析步骤
        return "json";
    }

    public static void main(String[] args) throws IllegalAccessException {
        RuleConfigSource source = new RuleConfigSource();
        source.load("xxx.json");
    }

}
