package com.keirlwus.syncdata.footprint.defaultConnection.connectInfo;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-24 10:25
 *
 * @author krielwus
 */
public class oracleConnectInfo implements Serializable {

    private static final long serialVersionUID = -2945124045666927944L;

//    private static String type = "oracle";
//    private static String url = "jdbc:oracle:thin:@//127.0.0.1:1521/tengyi";
//    private static String username = "productmanager";
//    private static String password = "root123456";
//    private static String driverClassName = "oracle.jdbc.driver.OracleDriver";

    private String type;
    private String url;
    private String username;
    private String password;
    private String driverClassName;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public oracleConnectInfo(String type, String url, String username, String password, String driverClassName) {
        this.type = type;
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
    }

    public oracleConnectInfo() {
    }

    @Override
    public String toString() {
        return "oracleConnectInfo{" + "type='" + type + '\'' + ", url='" + url + '\'' + ", username='" + username + '\'' + ", password='" + password + '\'' + ", driverClassName='" + driverClassName + '\'' + '}';
    }
}
