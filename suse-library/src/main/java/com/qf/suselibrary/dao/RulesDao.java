package com.qf.suselibrary.dao;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.Rules;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (Rules)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 19:19:56
 */
public interface RulesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rules queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param rules    查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Rules> queryAllByLimit(Rules rules, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param
     * @return 总行数
     */
    long countInt();
    long count(Rules rules);

    /**
     * 新增数据
     *
     * @param rules 实例对象
     * @return 影响行数
     */
    int insertInt(Rules rules);
    Rules insert(Rules rules);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rules> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Rules> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Rules> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Rules> entities);

    /**
     * 修改数据
     *
     * @param rules 实例对象
     * @return 影响行数
     */
    int updateInt(Rules rules);
    Rules update(Rules rules);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteByInt(@Param("ids") JSONArray ids);
    int deleteById(Integer id);


    List<Rules> queryAllInt(@Param("page")Integer page,@Param("limit") Integer limit);
    List<Rules> queryAll();



}

