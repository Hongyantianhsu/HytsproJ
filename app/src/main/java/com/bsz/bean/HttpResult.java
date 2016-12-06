package com.bsz.bean;

/**
 * Created by sunyan on 16/12/5.
 */
public class HttpResult<T> {
    private String errorcode;
    private T data;

    public String getErrorcode() {
        return errorcode;
    }

    public void setErrorcode(String errorcode) {
        this.errorcode = errorcode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
