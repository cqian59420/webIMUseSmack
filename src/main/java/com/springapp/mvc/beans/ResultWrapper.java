package com.springapp.mvc.beans;
/********************************************
 * 文件名称: ResultWrapper <br/>
 * 开发人员:  Terrance
 * 开发时间: 2015/9/21 9:35
 *********************************************/

import com.springapp.utils.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ResultWrapper {

    private static Properties properties;

    static {
        properties = PropertiesUtil.newInstance("SysMessage.properties");
    }

    private Logger logger = LoggerFactory.getLogger(ResultWrapper.class);
    private String code;//返回的代码
    private Object result;//返回的结果
    private String message;//代码对应的描述

    /*
        * 输入对应的代码和自定义的message
     */
    public ResultWrapper(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /*
        *
     */
    public ResultWrapper(String code, String message, Object result) {
        this.code = code;
        this.result = result;
        this.message = message;
    }

    /*
        * code 输入对应的code，返回properties错误的消息
     */
    public ResultWrapper(String code) {
        this.code = code;
        this.message = properties.getProperty(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
        setMessage(properties.getProperty(code));
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
