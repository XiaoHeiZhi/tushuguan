package com.qf.suselibrary.dao;

import com.qf.suselibrary.entity.BookSort;

import java.util.List;

/**
 * (BookSort)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-11 22:20:34
 */
public interface BookSortDao {

    List<BookSort> queryAll();

}

