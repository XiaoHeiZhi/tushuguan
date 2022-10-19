package com.qf.suselibrary.dao;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.BorrowBooks;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;


import java.util.List;

/**
 * (BorrowBooks)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 18:13:45
 */
public interface BorrowBooksDao {

    //  通过id查，（编辑）
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BorrowBooks queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param borrowBooks 查询条件
     * @param pageable    分页对象
     * @return 对象列表
     */
    List<BorrowBooks> queryAllByLimit(BorrowBooks borrowBooks, @Param("pageable") Pageable pageable);
//  统计总行数
    /**
     * 统计总行数
     *
     *
     * @return 总行数
     */
    long count();
//  添加
    /**
     * 新增数据
     *
     * @param borrowBooks 实例对象
     * @return 影响行数
     */
    int insert(BorrowBooks borrowBooks);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowBooks> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BorrowBooks> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowBooks> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BorrowBooks> entities);

    /**
     * 修改数据
     *
     * @param borrowBooks 实例对象
     * @return 影响行数
     */
    int update(BorrowBooks borrowBooks);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") JSONArray ids);
    //  分页查所有
    List<BorrowBooks> queryAll(@Param("page") Integer page,@Param("limit") Integer limit);

    List<BorrowBooks> queryPageByConditions(@Param("borrowBooks") BorrowBooks borrowBooks, @Param("page") Integer page, @Param("limit") Integer limit);

    List<BorrowBooks> queryByConditions(@Param("borrowBooks") BorrowBooks borrowBooks);

}

