package com.keirlwus.syncdata.footprint.entity.baseObjectInfo;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by krielwus on 2022-03-24 14:05
 *
 * @author krielwus
 */
public class OracleTableInfo implements Serializable {
    private static final long serialVersionUID = 5512588527481946101L;

    /**
     * 表名
     */
    private String table_name;
    /**
     * 表空间
     */
    private String tablespace_name;
    /**
     * 空闲百分比
     */
    private int pctfree;
    /**
     * 初始事务数 一般 1
     */
    private int initrans;
    /**
     * 最大事务数 一般 255
     */
    private int maxtrans;
    /**
     * 存储信息
     */
    private OracleStorageInfo storage;
    /**
     * 列字段信息集
     */
    private OracleTableColumns[] columns;

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getTablespace_name() {
        return tablespace_name;
    }

    public void setTablespace_name(String tablespace_name) {
        this.tablespace_name = tablespace_name;
    }

    public int getPctfree() {
        return pctfree;
    }

    public void setPctfree(int pctfree) {
        this.pctfree = pctfree;
    }

    public int getInitrans() {
        return initrans;
    }

    public void setInitrans(int initrans) {
        this.initrans = initrans;
    }

    public int getMaxtrans() {
        return maxtrans;
    }

    public void setMaxtrans(int maxtrans) {
        this.maxtrans = maxtrans;
    }

    public OracleStorageInfo getStorage() {
        return storage;
    }

    public void setStorage(OracleStorageInfo storage) {
        this.storage = storage;
    }

    public OracleTableColumns[] getColumns() {
        return columns;
    }

    public void setColumns(OracleTableColumns[] columns) {
        this.columns = columns;
    }

    public OracleTableInfo(String table_name, String tablespace_name, int pctfree, int initrans, int maxtrans, OracleStorageInfo storage, OracleTableColumns[] columns) {
        this.table_name = table_name;
        this.tablespace_name = tablespace_name;
        this.pctfree = pctfree;
        this.initrans = initrans;
        this.maxtrans = maxtrans;
        this.storage = storage;
        this.columns = columns;
    }

    public OracleTableInfo(String table_name, String tablespace_name, OracleTableColumns[] columns) {
        this.table_name = table_name;
        this.tablespace_name = tablespace_name;
        this.columns = columns;
    }

    public OracleTableInfo() {
    }

    @Override
    public String toString() {
        return "OracleTableInfo{" + "table_name='" + table_name + '\'' + ", tablespace_name='" + tablespace_name + '\'' + ", pctfree=" + pctfree + ", initrans=" + initrans + ", maxtrans=" + maxtrans + ", storage=" + storage + ", columns=" + Arrays.toString(columns) + '}';
    }
}
