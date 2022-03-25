package com.keirlwus.syncdata.footprint.oracle;

import com.keirlwus.syncdata.footprint.defaultConnection.DefaultConnectParams;
import com.keirlwus.syncdata.footprint.defaultConnection.connectInfo.OracleConnectInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by krielwus on 2022-03-24 15:22
 * Oracle connect test class
 *
 * @author krielwus
 */
public class OracleConnectTest {

    public static Connection getOracleConn() {
        Connection conn = null;
//        OracleConnectInfo oracleConnectInfo = new OracleConnectInfo(DefaultConnectParams.ORA_TYPE, DefaultConnectParams.ORA_URL, DefaultConnectParams.ORA_USERNAME, DefaultConnectParams.ORA_PASSWORD, DefaultConnectParams.ORA_DRIVERCLASSNAME);
//        oracleConnectInfo.setType(DefaultConnectParams.ORA_TYPE);
        try {
            Class.forName(DefaultConnectParams.ORA_DRIVERCLASSNAME);
            conn = DriverManager.getConnection(DefaultConnectParams.ORA_URL, DefaultConnectParams.ORA_USERNAME, DefaultConnectParams.ORA_PASSWORD);
            System.out.println("连接成功");
        }catch (SQLException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }



    public static void main(String[] args) {
        getOracleConn();
    }
}
