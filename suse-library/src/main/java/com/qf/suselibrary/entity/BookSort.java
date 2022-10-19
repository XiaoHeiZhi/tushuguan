package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (BookSort)实体类
 *
 * @author makejava
 * @since 2022-07-11 22:20:34
 */
public class BookSort implements Serializable {
    private static final long serialVersionUID = 808969416437861762L;

    private Integer id;
    /**
     * 书籍类型名
     */
    private String name;

    private String description;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

