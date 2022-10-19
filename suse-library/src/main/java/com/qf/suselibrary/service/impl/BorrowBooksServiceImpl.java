package com.qf.suselibrary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dao.BorrowBooksDao;
import com.qf.suselibrary.entity.BorrowBooks;
import com.qf.suselibrary.service.BorrowBooksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BorrowBooks)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 18:13:46
 */
@Service("borrowBooksService")
public class BorrowBooksServiceImpl implements BorrowBooksService {
    @Resource
    private BorrowBooksDao borrowBooksDao;

    //  通过id查，（编辑）
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BorrowBooks queryById(Integer id) {
        return this.borrowBooksDao.queryById(id);
    }


    /**
     * 新增数据
     *
     * @param borrowBooks 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(BorrowBooks borrowBooks) {
        return this.borrowBooksDao.insert(borrowBooks);
    }

    /**
     * 修改数据
     *
     * @param borrowBooks 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(BorrowBooks borrowBooks) {
        return  this.borrowBooksDao.update(borrowBooks);
    }

    /**
     * 通过主键删除数据
     *
     * @param ids 主键
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(JSONArray ids) {
        return this.borrowBooksDao.deleteById(ids);
    }
    //  分页查所有
    @Override
    public List<BorrowBooks> queryAll(Integer page, Integer limit) {
        if (page == null || limit == null) {
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;
        return borrowBooksDao.queryAll(page,limit);
    }
    //  统计总行数
    @Override
    public Long countBorrowBooks() {
        return borrowBooksDao.count();
    }

    @Override
    public Map<String, Object> queryByConditions(BorrowBooks borrowBooks, Integer page, Integer limit) {
        if (page == null || limit == null) {
            page = 1;
            limit = 10;
        }
        page = (page - 1) * limit;
        //分页查询的前面10条数据
        List<BorrowBooks> borrowBooks_list=borrowBooksDao.queryPageByConditions(borrowBooks,page,limit);
        // 没有分页的时候,当前的条件一共能查到多少条数据
        List<BorrowBooks> borrowBooks1=borrowBooksDao.queryByConditions(borrowBooks);
        Long count=Long.valueOf(borrowBooks1.size());
        HashMap<String,Object> map=new HashMap<>();
        map.put("borrowBooks_list",borrowBooks_list);
        map.put("count",count);
        return map;
    }

}
