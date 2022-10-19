package com.qf.suselibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dto.BookBorrowDto;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.dto.Booksdto;
import com.qf.suselibrary.entity.Books;

import java.util.List;
import java.util.Map;

/**
 * (Books)表服务接口
 *
 * @author makejava
 * @since 2022-07-11 22:20:48
 */
public interface BooksService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Books queryById(Integer id);

    /**
     *
     * @param books
     * @return
     */
    Integer insert(Books books);


    Integer update(BookUpdata bookUpdata);


    Integer deleteById(JSONArray ids);

    List<Booksdto> queryAll(Integer page, Integer limit);

    Long querycountBook();

    Integer updateAll(Books books);

    Map<String, Object> queryByconditions(Books books, Integer page, Integer limit);



    /**
     * 借书量查询
     * @param bookBorrowDto
     * @return
     */
    Map<String, Object> queryBorrow(BookBorrowDto bookBorrowDto);
}
