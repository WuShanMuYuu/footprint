package com.keirlwus.syncdata.footprint.oracle.oracleConn;

import com.keirlwus.syncdata.footprint.defaultConnection.DefaultConnectParams;
import com.keirlwus.syncdata.footprint.defaultConnection.connectInfo.OracleConnectInfo;
import com.keirlwus.syncdata.footprint.entity.ResponseInfo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by krielwus on 2022-03-24 16:53
 *
 * @author krielwus
 */
public class OracleDBConn {

    public ResponseInfo getOracleConn(OracleConnectInfo oracleConnectInfo) {
        Connection connection = null;
        try {
            Class.forName(DefaultConnectParams.ORA_DRIVERCLASSNAME);
            connection = DriverManager.getConnection(oracleConnectInfo.getUrl(), oracleConnectInfo.getUsername(), oracleConnectInfo.getPassword());
            if (null != connection) {
                return new ResponseInfo(1001, "ORACLE Connection Succeeded!", connection, "");
            } else {
                return new ResponseInfo(4001, "ORACLE Connection is null! Please check your url", null, "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseInfo(4001, "ORACLE connection catch SQLException , ExceptionMessage in extend_params", null, e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(4001, "ORACLE connection catch Exception , ExceptionMessage in extend_params", null, e.toString());
        }
    }

    public ResponseInfo OracleConnectClose(Connection oracle_conn) {
        try {
            if (null != oracle_conn) {
                oracle_conn.close();
                return new ResponseInfo(1001, "ORACLE Connection close Succeeded!", null, "");
            } else {
                return new ResponseInfo(4001, "ORACLE Connection in is null", null, "");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseInfo(4001, "ORACLE connection close catch SQLException , ExceptionMessage in extend_params", null, e.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(4001, "ORACLE connection close catch Exception , ExceptionMessage in extend_params", null, e.toString());
        }
    }
}
