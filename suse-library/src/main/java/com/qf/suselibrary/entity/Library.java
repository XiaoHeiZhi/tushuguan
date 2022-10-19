package com.qf.suselibrary.entity;

import java.io.Serializable;

/**
 * (Library)实体类
 *
 * @author makejava
 * @since 2022-07-13 15:46:06
 */
public class Library implements Serializable {
    private static final long serialVersionUID = 665468637006275456L;

    private Integer id;

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

