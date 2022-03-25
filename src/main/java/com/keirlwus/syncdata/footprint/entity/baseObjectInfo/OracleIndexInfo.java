package com.keirlwus.syncdata.footprint.entity.baseObjectInfo;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-25 17:00
 * ORACLE表索引
 *
 * @author krielwus
 */
public class OracleIndexInfo implements Serializable {

    private static final long serialVersionUID = 487293509313256650L;
    /**
     * Index name
     */
    private String index_name;
    /**
     * Table or cluster name
     */
    private String table_name;
    /**
     * Column name or attribute of object column
     */
    private String column_name;
    /**
     * Position of column or attribute within index
     */
    private Integer column_position;
    /**
     * Maximum length of the column or attribute, in bytes
     */
    private Integer column_length;
    /**
     * Maximum length of the column or attribute, in characters
     */
    private Integer char_length;
    /**
     * DESC if this column is sorted descending on disk, otherwise ASC
     */
    private String descend;
    /**
     *
     */
    private String index_type;

    public String getIndex_name() {
        return index_name;
    }

    public void setIndex_name(String index_name) {
        this.index_name = index_name;
    }

    public String getTable_name() {
        return table_name;
    }

    public void setTable_name(String table_name) {
        this.table_name = table_name;
    }

    public String getColumn_name() {
        return column_name;
    }

    public void setColumn_name(String column_name) {
        this.column_name = column_name;
    }

    public int getColumn_position() {
        return column_position;
    }

    public void setColumn_position(Integer column_position) {
        this.column_position = column_position;
    }

    public int getColumn_length() {
        return column_length;
    }

    public void setColumn_length(Integer column_length) {
        this.column_length = column_length;
    }

    public int getChar_length() {
        return char_length;
    }

    public void setChar_length(Integer char_length) {
        this.char_length = char_length;
    }

    public String getDescend() {
        return descend;
    }

    public void setDescend(String descend) {
        this.descend = descend;
    }

    public String getIndex_type() {
        return index_type;
    }

    public void setIndex_type(String index_type) {
        this.index_type = index_type;
    }

    public OracleIndexInfo() {
    }

    public OracleIndexInfo(String index_name, String table_name, String column_name, Integer column_position, Integer column_length, Integer char_length, String descend, String index_type) {
        this.index_name = index_name;
        this.table_name = table_name;
        this.column_name = column_name;
        this.column_position = column_position;
        this.column_length = column_length;
        this.char_length = char_length;
        this.descend = descend;
        this.index_type = index_type;
    }

    @Override
    public String toString() {
        return "OracleIndexInfo{" + "index_name='" + index_name + '\'' + ", table_name='" + table_name + '\'' + ", column_name='" + column_name + '\'' + ", column_position='" + column_position + '\'' + ", column_length='" + column_length + '\'' + ", char_length='" + char_length + '\'' + ", descend='" + descend + '\'' + ", index_type='" + index_type + '\'' + '}';
    }
}
