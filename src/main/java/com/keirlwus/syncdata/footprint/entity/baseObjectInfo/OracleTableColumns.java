package com.keirlwus.syncdata.footprint.entity.baseObjectInfo;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-24 14:07
 *
 * @author krielwus
 */
public class OracleTableColumns implements Serializable {
    private static final long serialVersionUID = 46256564804366122L;

    /**
     * 字段名
     */
    private String column_name;
    /**
     * 字段类型
     */
    private String data_type;
    /**
     * 长度
     */
    private String data_length;
    /**
     * 是否为空
     */
    private String nullable;
    /**
     * 注释
     */
    private String comments;

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public String getData_type() {
        return data_type;
    }

    public void setData_type(String data_type) {
        this.data_type = data_type;
    }

    public String getData_length() {
        return data_length;
    }

    public void setData_length(String data_length) {
        this.data_length = data_length;
    }

    public String getNullable() {
        return nullable;
    }

    public void setNullable(String nullable) {
        this.nullable = nullable;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public OracleTableColumns(String column_name, String data_type, String data_length, String nullable, String comments) {
        this.column_name = column_name;
        this.data_type = data_type;
        this.data_length = data_length;
        this.nullable = nullable;
        this.comments = comments;
    }

    public OracleTableColumns() {
    }

    @Override
    public String toString() {
        return "OracleTableColumns{" + "column_name='" + column_name + '\'' + ", data_type='" + data_type + '\'' + ", data_length='" + data_length + '\'' + ", nullable='" + nullable + '\'' + ", comments='" + comments + '\'' + '}';
    }
}
