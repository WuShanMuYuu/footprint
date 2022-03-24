package com.keirlwus.syncdata.footprint.entity.baseObjectInfo;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-24 14:39
 *
 * @author krielwus
 */
public class OracleStorageInfo implements Serializable {
    private static final long serialVersionUID = 4860126555925059937L;

    /**
     * storage{
     *     initial 64K
     *     next 8K
     *     minextents 1
     *     maxextents unlimited
     * }
     */

    /**
     * 初始大小
     */
    private String initial;
    /**
     * 下一个大小
     */
    private String next;
    /**
     * 最小数量 一般默认 1
     */
    private int minextents;
    /**
     * 最大数量 不限制 一般默认  unlimited
     */
    private int maxextents;

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public int getMinextents() {
        return minextents;
    }

    public void setMinextents(int minextents) {
        this.minextents = minextents;
    }

    public int getMaxextents() {
        return maxextents;
    }

    public void setMaxextents(int maxextents) {
        this.maxextents = maxextents;
    }

    public OracleStorageInfo(String initial, String next, int minextents, int maxextents) {
        this.initial = initial;
        this.next = next;
        this.minextents = minextents;
        this.maxextents = maxextents;
    }

    public OracleStorageInfo() {
    }

    @Override
    public String toString() {
        return "OracleStorageInfo{" + "initial='" + initial + '\'' + ", next='" + next + '\'' + ", minextents=" + minextents + ", maxextents=" + maxextents + '}';
    }
}
