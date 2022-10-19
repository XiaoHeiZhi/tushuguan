package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (BorrowCard)实体类
 *
 * @author makejava
 * @since 2022-07-13 16:34:59
 */
public class BorrowCard implements Serializable {
    private static final long serialVersionUID = -91334914193435236L;

    private Integer id;

    private String password;

    private String reader;

    private Integer ruleId;
    /**
     * 0注销，1正常
     */
    private Integer status;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReader() {
        return reader;
    }

    public void setReader(String reader) {
        this.reader = reader;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

