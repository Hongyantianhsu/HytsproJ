package com.bsz.dao;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit.
/**
 * Entity mapped to table "COOKIE_INFO".
 */
@Entity
public class CookieInfo {

    @Id
    private Long id;
    private String url;
    private String result;
    private Long time;

    @Generated(hash = 368764985)
    public CookieInfo() {
    }

    public CookieInfo(Long id) {
        this.id = id;
    }
    
    public CookieInfo(String url, String result, Long time) {
        this.url = url;
        this.result = result;
        this.time = time;
    }

    @Generated(hash = 2016268278)
    public CookieInfo(Long id, String url, String result, Long time) {
        this.id = id;
        this.url = url;
        this.result = result;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
