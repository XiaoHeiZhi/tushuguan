package com.qf.suselibrary.service;

import com.qf.suselibrary.entity.Admin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Map;

/**
 * (Admin)表服务接口
 *
 * @author makejava
 * @since 2022-07-11 22:19:28
 */
public interface AdminService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Admin queryById(Integer id);

    /**
     * 分页查询
     *
     * @param admin       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Admin> queryByPage(Admin admin, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param admin 实例对象
     * @return 实例对象
     */
    Admin insert(Admin admin);

    /**
     * 修改数据
     *
     * @param admin 实例对象
     * @return 实例对象
     *
     */
    Admin update(Admin admin);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> login(String username, String password);

    /**
     * token查询用户
     * @param token
     * @return
     */
    Admin queryByRemark(String token);

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */

}
