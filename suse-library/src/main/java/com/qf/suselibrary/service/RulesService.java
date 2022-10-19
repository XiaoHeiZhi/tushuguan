package com.qf.suselibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.entity.Rules;

import java.util.List;

/**
 * (Rules)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 19:19:56
 */
public interface RulesService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Rules queryById(Integer id);



    /**
     * 新增数据
     *
     * @param rules 实例对象
     * @return 实例对象
     */
    Rules insert(Rules rules);
    Integer insertInt(Rules rules);

    /**
     * 修改数据
     *
     * @param rules 实例对象
     * @return 实例对象
     */
    Rules update(Rules rules);
    Integer updateInt(Rules rules);

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    Integer deleteByInt(JSONArray ids);
    boolean deleteById(Integer id);

    List<Rules> queryAll();
    List<Rules> queryAllInt(Integer page, Integer limit);

    Long countInt();

}
