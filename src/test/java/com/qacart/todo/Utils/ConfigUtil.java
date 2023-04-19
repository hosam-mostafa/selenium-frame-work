package com.qacart.todo.Utils;

import java.util.Properties;

public class ConfigUtil {
    private  Properties properties;
    private static ConfigUtil configUtil;
    public ConfigUtil(){
        String environment = System.getProperty("env","production");
        switch (environment){
            case "production":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/Config/production.properties");
                break;
            case"local":
                properties = PropertiesUtil.loadProperties("src/test/java/com/qacart/todo/Config/local.properties");
                break;
            default:
                throw new RuntimeException("Environment is not supported");

        }
    }
    public static ConfigUtil getInstance(){
        if (configUtil == null){
            configUtil = new ConfigUtil();
        }
        return configUtil;
    }
    public  String getBaseUrl(){
        String prop = properties.getProperty("baseUrl");
        if (prop != null){ return prop;}
        throw new RuntimeException("could not find the baseUrl in the property file");
    }
    public  String getEmail(){
        String prop = properties.getProperty("email");
        if (prop != null){ return prop;}
        throw new RuntimeException("could not find the email in the property file");
    }
    public  String getPassword(){
        String prop = properties.getProperty("password");
        if (prop != null){ return prop;}
        throw new RuntimeException("could not find the password in the property file");
    }
}
