package com.qf.suselibrary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dao.ManagerDao;
import com.qf.suselibrary.entity.Manager;
import com.qf.suselibrary.service.ManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Manager)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 18:15:43
 */
@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Manager queryById(Integer id) {
        return this.managerDao.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(Manager manager) {

        return this.managerDao.insert(manager);
    }

    /**
     * 修改数据
     *
     * @param manager 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(Manager manager) {

        return this.managerDao.update(manager);
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键数组
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(JSONArray ids) {
        return this.managerDao.deleteById(ids);
    }

    //分页查所有
    @Override
    public List<Manager> queryAll(Integer page, Integer limit) {
        if (page == null || limit == null) {
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;
        return managerDao.queryAll(page,limit);
    }

    //统计数据总数
    @Override
    public Long countManger() {
        return managerDao.count();
    }
}
