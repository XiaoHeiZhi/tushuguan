package com.qf.suselibrary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dao.RulesDao;
import com.qf.suselibrary.entity.Rules;
import com.qf.suselibrary.service.RulesService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Rules)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 19:19:56
 */
@Service("rulesService")
public class RulesServiceImpl implements RulesService {
    @Resource
    private RulesDao rulesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Rules queryById(Integer id) {
        return this.rulesDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param rules       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param rules 实例对象
     * @return 实例对象
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Rules insert(Rules rules){
        return rulesDao.insert(rules);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insertInt(Rules rules) {

        return rulesDao.insertInt(rules);
    }


    /**
     * 修改数据
     *
     * @param rules 实例对象
     * @return 实例对象
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Rules update(Rules rules) {

        return rulesDao.update(rules);
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateInt(Rules rules) {

        return rulesDao.updateInt(rules);
    }


    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(Integer id) {
        return this.rulesDao.deleteById(id) > 0;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteByInt(JSONArray ids) {
        // 因为所删除的表有外键关系
        //先要把有关联的外键表数据删除
        //再删除当前数据
        // 设计中间表的的时候,尽可能不采用外键(外键缺点-维护性比较差)
        return this.rulesDao.deleteByInt(ids);
    }

    @Override
    public List<Rules> queryAll() {
        return this.rulesDao.queryAll();
    }
    @Override
    public List<Rules> queryAllInt(Integer page, Integer limit) {
        if(page==null||limit==null){
            page=0;
            limit=10;
        }
        page=(page-1)*limit;
        return rulesDao.queryAllInt(page,limit);
    }



    @Override
    public Long countInt() {
        return rulesDao.countInt();
    }
}
