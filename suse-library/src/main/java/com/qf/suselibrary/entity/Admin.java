package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (Admin)实体类
 *
 * @author makejava
 * @since 2022-07-11 22:19:28
 */
public class Admin implements Serializable {
    private static final long serialVersionUID = -27026201414983163L;

    private Integer id;

    private String name;

    private String username;

    private String password;

    private Integer enabled;

    private String userface;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEnabled() {
        return enabled;
    }

    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    public String getUserface() {
        return userface;
    }

    public void setUserface(String userface) {
        this.userface = userface;
    }

    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

