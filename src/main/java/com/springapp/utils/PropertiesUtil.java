package com.springapp.utils;
/********************************************
 * 文件名称: PropertiesUtil <br/>
 * 开发人员:  Terrance
 * 开发时间: 2015/9/21 9:36
 *********************************************/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

    private PropertiesUtil() {
    }

    public static Properties newInstance(String propertiesName) {
        InputStream is = PropertiesUtil.class.getClassLoader().getResourceAsStream(propertiesName);
        Properties p = new Properties();
        try {
            p.load(is);
        } catch (IOException e) {
            logger.error("读取配置文件出错", e);
        }
        return p;
    }
}
