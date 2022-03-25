package com.keirlwus.syncdata.footprint.entity.baseObjectInfo;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-25 17:30
 *
 * @author krielwus
 */
public class OraclePrimaryInfo implements Serializable {
    private static final long serialVersionUID = 582446504297443713L;
    /**
     * Owner of the constraint definition
     */
    private String owner;
    /**
     * Name associated with the constraint definition
     */
    private String constraint_name;
    /**
     * Name associated with table with constraint definition
     */
    private String table_name;
    /**
     * Name associated with column or attribute of object column specified in the constraint definition
     */
    private String column_name;
    /**
     * Original position of column or attribute in definition
     */
    private Integer position;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getConstraint_name() {
        return constraint_name;
    }

    public void setConstraint_name(String constraint_name) {
        this.constraint_name = constraint_name;
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

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    public OraclePrimaryInfo(String owner, String constraint_name, String table_name, String column_name, Integer position) {
        this.owner = owner;
        this.constraint_name = constraint_name;
        this.table_name = table_name;
        this.column_name = column_name;
        this.position = position;
    }

    public OraclePrimaryInfo() {
    }

    @Override
    public String toString() {
        return "OraclePrimaryInfo{" + "owner='" + owner + '\'' + ", constraint_name='" + constraint_name + '\'' + ", table_name='" + table_name + '\'' + ", column_name='" + column_name + '\'' + ", position=" + position + '}';
    }
}
