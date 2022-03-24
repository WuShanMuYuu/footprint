package com.keirlwus.syncdata.footprint.entity;

import java.io.Serializable;

/**
 * Created by krielwus on 2022-03-24 11:00
 * 响应结果出参
 * @author krielwus
 */
public class ResponseInfo implements Serializable {

    private static final long serialVersionUID = 6373336658847530343L;

    private int code;
    private String message;
    private Object object;
    private String extend_params;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getExtend_params() {
        return extend_params;
    }

    public void setExtend_params(String extend_params) {
        this.extend_params = extend_params;
    }

    public ResponseInfo(int code, String message, Object object, String extend_params) {
        this.code = code;
        this.message = message;
        this.object = object;
        this.extend_params = extend_params;
    }

    public ResponseInfo() {
    }

    @Override
    public String toString() {
        return "responseInfo{" + "code=" + code + ", message='" + message + '\'' + ", object=" + object + ", extend_params='" + extend_params + '\'' + '}';
    }
}
