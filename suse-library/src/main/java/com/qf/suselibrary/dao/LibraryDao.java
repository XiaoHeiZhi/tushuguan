package com.qf.suselibrary.dao;

import com.qf.suselibrary.entity.Library;

import java.util.List;

/**
 * (Library)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 15:46:06
 */
public interface LibraryDao {

    List<Library> queryAll();

}

