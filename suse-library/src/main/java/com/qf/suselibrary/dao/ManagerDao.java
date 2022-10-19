package com.qf.suselibrary.dao;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Manager)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 18:15:42
 */
public interface ManagerDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Manager queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param manager  查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Manager> queryAllByLimit(Manager manager, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     *
     * @return 总行数
     */
    long count();

    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int insert(Manager manager);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Manager> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Manager> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Manager> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Manager> entities);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 影响行数
     */
    int update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 影响行数
     */
    int deleteById(@Param("ids") JSONArray ids);
    //分页查所有
    List<Manager> queryAll(@Param("page") Integer page,@Param("limit") Integer limit);

}

