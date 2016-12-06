package com.bsz.exception;

/**
 * Http请求异常处理类
 * Created by sunyan on 16/12/5.
 */
public class HttpTimeException extends RuntimeException {
    public HttpTimeException(String errcode){
        getExceptionMessage(errcode);
    }

    private String getExceptionMessage(String errcode) {
        String message = "";
        switch (errcode){
            case  "0":
                break;
            case "40040":
                message = "请求超时";
                break;
        }
        return message;
    }
}
