package com.springapp.mvc.beans;
/********************************************
 * 文件名称: UserAccount <br/>
 * 开发人员:  Terrance
 * 开发时间: 2015/9/21 9:50
 *********************************************/

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UserAccount {
    private Logger logger = LoggerFactory.getLogger(UserAccount.class);

    private String userName;
    private String userPass;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }
}
