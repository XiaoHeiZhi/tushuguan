package com.qf.suselibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.BorrowBooks;

import java.util.List;
import java.util.Map;

/**
 * (BorrowBooks)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 18:13:46
 */
public interface BorrowBooksService {

    //  通过id查，（编辑）
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BorrowBooks queryById(Integer id);



    /**
     * 新增数据
     *
     * @param borrowBooks 实例对象
     * @return 实例对象
     */
    Integer insert(BorrowBooks borrowBooks);

    /**
     * 修改数据
     *
     * @param borrowBooks 实例对象
     * @return 实例对象
     */
    Integer update(BorrowBooks borrowBooks);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    Integer deleteById(JSONArray ids);
    //  分页查所有
    List<BorrowBooks> queryAll(Integer page, Integer limit);
    //  统计总行数
    Long countBorrowBooks();

    Map<String, Object> queryByConditions(BorrowBooks borrowBooks, Integer page, Integer limit);


}
