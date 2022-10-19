package com.qf.suselibrary.dto;

public class BookBorrowDto {

    /**
     * 书名
     */
    private String name;

    /**
     * 书被借的次数
     */
    private Integer value;


    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
