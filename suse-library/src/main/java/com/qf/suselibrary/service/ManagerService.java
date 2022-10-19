package com.qf.suselibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.Manager;

import java.util.List;

/**
 * (Manager)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 18:15:43
 */
public interface ManagerService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Manager queryById(Integer id);



    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Integer insert(Manager manager);

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    Integer update(Manager manager);

    /**
     * 通过主键删除数据
     *
     * @param ids 主键数组
     * @return 是否成功
     */
    Integer deleteById(JSONArray ids);
    // 分页查所有
    List<Manager> queryAll(Integer page, Integer limit);
    //统计总行数
    Long countManger();

}
