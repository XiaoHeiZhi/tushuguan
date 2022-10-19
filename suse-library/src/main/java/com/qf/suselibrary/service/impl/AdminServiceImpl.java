package com.qf.suselibrary.service.impl;

import com.qf.suselibrary.dao.AdminDao;
import com.qf.suselibrary.entity.Admin;
import com.qf.suselibrary.service.AdminService;
import com.qf.suselibrary.util.Md5Util;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * (Admin)表服务实现类
 *
 * @author makejava
 * @since 2022-07-11 22:19:28
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminDao adminDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Admin queryById(Integer id) {
        return this.adminDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param admin       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Admin> queryByPage(Admin admin, PageRequest pageRequest) {
        long total = this.adminDao.count(admin);
        return new PageImpl<>(this.adminDao.queryAllByLimit(admin, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Admin insert(Admin admin) {
        this.adminDao.insert(admin);
        return admin;
    }

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Admin update(Admin admin) {
        this.adminDao.update(admin);
        return this.queryById(admin.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String username) {
        return this.adminDao.deleteById(username) > 0;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String,Object> result=new HashMap<>();

        //1.先通过用户名去数据库中查找当前用户
        Admin admin = adminDao.queryByUserName(username);

        //2.使用MD5算法给password加密
        String pwd = Md5Util.get(password, username);

        //3.对数据进行判断
        if(admin == null || !admin.getPassword().equals(pwd)){
            result.put("info","用户名和密码错误");
            return result;
        }

        //工作的时候会将token放在redis（缓存）中（前后端分离的时候），如果前后端不分离 ---- 放在session中

        //4.登录验证成功以后  token是一个随机字符串.
        String token = UUID.randomUUID().toString();

        //5.将token存放在hr对象中   正常情况token需要放在redis非关系型数据库中
        admin.setRemark(token);

        //6.将数据更新到数据库中
        adminDao.update(admin);

        //7.将数据返回
        admin.setPassword("");
        result.put("userinfo",admin);

        return result;

    }

    @Override
    public Admin queryByRemark(String token) {

        return adminDao.queryByRemark(token);
    }


}
