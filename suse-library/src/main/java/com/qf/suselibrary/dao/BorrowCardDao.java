package com.qf.suselibrary.dao;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dto.BorrowCardDto;
import com.qf.suselibrary.entity.BorrowCard;
import com.qf.suselibrary.service.BorrowCardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * (BorrowCard)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-13 16:34:59
 */
public interface BorrowCardDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    BorrowCard queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param borrowCard 查询条件
     * @param pageable   分页对象
     * @return 对象列表
     */
    List<BorrowCard> queryAllByLimit(BorrowCard borrowCard, @Param("pageable") Pageable pageable);



    /**
     * 新增数据
     *
     * @param borrowCard 实例对象
     * @return 影响行数
     */
    int insert(BorrowCard borrowCard);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowCard> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<BorrowCard> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<BorrowCard> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<BorrowCard> entities);

    /**
     * 修改数据
     *
     * @param borrowCard 实例对象
     * @return 影响行数
     */
    int update(BorrowCard borrowCard);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 影响行数
     */
    int deleteById(@Param("ids") JSONArray ids);



    List<BorrowCardService> queryAll(@Param("page") Integer page, @Param("limit") Integer limit);

    Long count();

    List<BorrowCardDto> queryPageByconditions(@Param("reader") String reader, @Param("page") Integer page, @Param("limit") Integer limit);

    List<BorrowCardDto> queryByconditions(@Param("reader") String reader);
}

