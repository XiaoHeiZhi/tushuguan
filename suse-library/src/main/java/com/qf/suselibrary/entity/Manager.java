package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (Manager)实体类
 *
 * @author makejava
 * @since 2022-07-13 18:15:42
 */
public class Manager implements Serializable {
    private static final long serialVersionUID = 269403798425260772L;

    private Integer id;

    private String name;

    private String account;

    private String password;

    private String email;


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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}

