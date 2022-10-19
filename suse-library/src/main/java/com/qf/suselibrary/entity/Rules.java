package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (Rules)实体类
 *
 * @author makejava
 * @since 2022-07-13 19:19:56
 */
public class Rules implements Serializable {
    private static final long serialVersionUID = 296053185400165922L;

    private Integer id;
    /**
     * 限制本数
     */
    private Integer borrowNum;
    /**
     * 限制天数
     */
    private Integer limitDay;

    private String borrowLibrary;

    private String overtimeFee;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBorrowNum() {
        return borrowNum;
    }

    public void setBorrowNum(Integer borrowNum) {
        this.borrowNum = borrowNum;
    }

    public Integer getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(Integer limitDay) {
        this.limitDay = limitDay;
    }

    public String getBorrowLibrary() {
        return borrowLibrary;
    }

    public void setBorrowLibrary(String borrowLibrary) {
        this.borrowLibrary = borrowLibrary;
    }

    public String getOvertimeFee() {
        return overtimeFee;
    }

    public void setOvertimeFee(String overtimeFee) {
        this.overtimeFee = overtimeFee;
    }

}

