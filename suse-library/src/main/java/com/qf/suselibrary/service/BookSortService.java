package com.qf.suselibrary.service;

import com.qf.suselibrary.entity.BookSort;

import java.util.List;

/**
 * (BookSort)表服务接口
 *
 * @author makejava
 * @since 2022-07-11 22:20:34
 */
public interface BookSortService {


    List<BookSort> queryAll();
}
