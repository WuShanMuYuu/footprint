package com.keirlwus.syncdata.footprint.oracle.base;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.keirlwus.syncdata.footprint.entity.ResponseInfo;
import com.keirlwus.syncdata.footprint.entity.baseObjectInfo.*;
import com.keirlwus.syncdata.footprint.oracle.OracleConnectTest;
import com.keirlwus.syncdata.footprint.oracle.oracleConn.OracleDBConn;
import com.keirlwus.syncdata.footprint.params.ResultCodeUtil;

import java.sql.*;

/**
 * Created by krielwus on 2022-03-24 17:14
 *
 * @author krielwus
 */
public class BasicDictionary {

    /**
     * 查询表字段信息
     *
     * @param ORA_CONN
     * @param TABLE_NAME
     * @return
     */
    public ResponseInfo getTableColumns(Connection ORA_CONN, String TABLE_NAME) {
        ResultSet rs = null;
        Statement stmt = null;
        String query_sql = "select t.COLUMN_NAME,t.DATA_TYPE,t.DATA_LENGTH,t.NULLABLE,c.COMMENTS,t.COLUMN_ID from  user_tab_columns t,user_col_comments c where t.table_name = c.table_name and t.column_name = c.column_name and  t.table_name = '" + TABLE_NAME.toUpperCase() + "' order by t.COLUMN_ID asc";
        try {
            stmt = ORA_CONN.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(query_sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            int num = rsmd.getColumnCount();
            rs.last();
            int row_count = rs.getRow();
            if (row_count > 1) {
                System.out.println("返回行数：" + row_count);
            }
            rs.beforeFirst();
            JSONArray jsonArray = new JSONArray();
            while (rs.next()) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 1; i <= num; i++) {
                    String key = String.valueOf(rsmd.getColumnName(i));
                    String value = String.valueOf(rs.getString(i));
                    jsonObject.put(key, value);
                }
                jsonArray.add(jsonObject);
            }
            return new ResponseInfo(ResultCodeUtil.SUCCEED_CODE, ResultCodeUtil.SUCCEED_MESSAGE, jsonArray, "行数：" + row_count);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(ResultCodeUtil.ERROR_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                    rs = null;
                }
                if (stmt != null) {
                    stmt.close();
                    stmt = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResponseInfo(ResultCodeUtil.ERROR_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }
        }
    }

    /**
     * 查询表存储信息
     *
     * @param ORA_CONN
     * @param TABLE_NAME
     * @return
     */
    public ResponseInfo getTableStorage(Connection ORA_CONN, String TABLE_NAME) {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            String query_sql = "select a.table_name as table_name,a.tablespace_name,a.status,a.pct_free,a.ini_trans,a.max_trans,a.initial_extent," + "a.next_extent,a.min_extents,a.max_extents from user_tables a where a.table_name = '" + TABLE_NAME.toUpperCase() + "'";
            statement = ORA_CONN.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query_sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            OracleTableInfo oracleTableInfo = new OracleTableInfo();
            OracleStorageInfo oracleStorageInfo = new OracleStorageInfo();

            int num = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= num; i++) {
                    oracleStorageInfo.setInitial(resultSet.getString("initial_extent"));
                    oracleStorageInfo.setNext(resultSet.getString("next_extent"));
                    oracleStorageInfo.setMinextents(resultSet.getInt("min_extents"));
                    oracleStorageInfo.setMaxextents(resultSet.getInt("max_extents"));

                    oracleTableInfo.setTable_name(resultSet.getString("table_name"));
                    oracleTableInfo.setTablespace_name(resultSet.getString("tablespace_name"));
                    oracleTableInfo.setPctfree(resultSet.getInt("pct_free"));
                    oracleTableInfo.setInitrans(resultSet.getInt("ini_trans"));
                    oracleTableInfo.setMaxtrans(resultSet.getInt("max_trans"));
                    oracleTableInfo.setStorage(oracleStorageInfo);
                }
            }
            return new ResponseInfo(ResultCodeUtil.SUCCEED_CODE, ResultCodeUtil.SUCCEED_MESSAGE, oracleTableInfo, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(ResultCodeUtil.EXCEPTION_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResponseInfo(ResultCodeUtil.ERROR_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }
        }
    }

    /**
     * 查询表索引
     *
     * @param ORA_CONN
     * @param TABLE_NAME
     * @return
     */
    public ResponseInfo getTableIndex(Connection ORA_CONN, String TABLE_NAME) {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //查询索引语句
            String query_sql = "select t.index_name,t.table_name,t.column_name,t.column_position,t.column_length,t.char_length,t.descend,i.index_type " + "from user_ind_columns t,user_indexes i where t.index_name = i.index_name and t.table_name = i.table_name and t.table_name = '" + TABLE_NAME.toUpperCase() + "'";
            statement = ORA_CONN.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query_sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int num = resultSetMetaData.getColumnCount();
            if (num < 1) {
                return new ResponseInfo(ResultCodeUtil.ERROR_CODE, ResultCodeUtil.NO_DATA, null, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }
            OracleIndexInfo oracleIndexInfo = new OracleIndexInfo();
            while (resultSet.next()) {
                for (int i = 0; i < num; i++) {
                    oracleIndexInfo.setIndex_name(resultSet.getString("index_name"));
                    oracleIndexInfo.setTable_name(resultSet.getString("table_name"));
                    oracleIndexInfo.setColumn_name(resultSet.getString("column_name"));
                    oracleIndexInfo.setColumn_position(resultSet.getInt("column_position"));
                    oracleIndexInfo.setColumn_length(resultSet.getInt("column_length"));
                    oracleIndexInfo.setChar_length(resultSet.getInt("char_length"));
                    oracleIndexInfo.setDescend(resultSet.getString("descend"));
                    oracleIndexInfo.setIndex_type(resultSet.getString("index_type"));
                }
            }
            return new ResponseInfo(ResultCodeUtil.SUCCEED_CODE, ResultCodeUtil.SUCCEED_MESSAGE, oracleIndexInfo, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(ResultCodeUtil.EXCEPTION_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResponseInfo(ResultCodeUtil.SQLEXCEPTION_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }

        }
    }

    /**
     * 查询表 主键
     *
     * @param ORA_CONN
     * @param TABLE_NAME
     * @return
     */
    public ResponseInfo getTablePrimary(Connection ORA_CONN, String TABLE_NAME) {
        ResultSet resultSet = null;
        Statement statement = null;
        try {
            //查询索引语句
            String query_sql = "select cu.owner,cu.constraint_name,cu.table_name,cu.column_name,cu.position from user_cons_columns cu, user_constraints au where cu.constraint_name = au.constraint_name and au.constraint_type = 'P' and au.table_name = '" + TABLE_NAME.toUpperCase() + "'";
            statement = ORA_CONN.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(query_sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int num = resultSetMetaData.getColumnCount();
            if (num < 1) {
                return new ResponseInfo(ResultCodeUtil.ERROR_CODE, ResultCodeUtil.NO_DATA, null, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }
            OraclePrimaryInfo oraclePrimaryInfo = new OraclePrimaryInfo();
            while (resultSet.next()) {
                for (int i = 0; i < num; i++) {
                    oraclePrimaryInfo.setOwner(resultSet.getString("owner"));
                    oraclePrimaryInfo.setConstraint_name(resultSet.getString("constraint_name"));
                    oraclePrimaryInfo.setTable_name(resultSet.getString("table_name"));
                    oraclePrimaryInfo.setColumn_name(resultSet.getString("column_name"));
                    oraclePrimaryInfo.setPosition(resultSet.getInt("position"));
                }
            }
            return new ResponseInfo(ResultCodeUtil.SUCCEED_CODE, ResultCodeUtil.SUCCEED_MESSAGE, oraclePrimaryInfo, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseInfo(ResultCodeUtil.EXCEPTION_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    statement = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return new ResponseInfo(ResultCodeUtil.SQLEXCEPTION_CODE, e.toString(), ResultCodeUtil.DEFAULT_RESULT_OBJECT, ResultCodeUtil.DEFAULT_EXTEND_PARAMS);
            }

        }
    }

    public static void main(String[] args) {
        Connection connection = OracleConnectTest.getOracleConn();
        System.out.println(new BasicDictionary().getTableColumns(connection, "HOSPITAL_INFO"));
        System.out.println(new BasicDictionary().getTableStorage(connection, "HOSPITAL_INFO"));
        System.out.println(new BasicDictionary().getTableIndex(connection, "HOSPITAL_INFO"));
        System.out.println(new BasicDictionary().getTablePrimary(connection, "HOSPITAL_INFO"));

        if (null != connection) {
            new OracleDBConn().OracleConnectClose(connection);
        }
    }
}
