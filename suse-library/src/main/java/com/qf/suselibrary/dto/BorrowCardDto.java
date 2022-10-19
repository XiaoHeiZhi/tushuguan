package com.qf.suselibrary.dto;

public class BorrowCardDto {
    Integer id;
    String password;
    String reader;
    Integer rule_id;
    Integer status;

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

    public Integer getRule_id() {
        return rule_id;
    }

    public void setRule_id(Integer rule_id) {
        this.rule_id = rule_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
