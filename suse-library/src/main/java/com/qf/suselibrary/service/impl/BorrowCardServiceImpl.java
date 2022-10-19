package com.qf.suselibrary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dao.BorrowCardDao;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.dto.BorrowCardDto;
import com.qf.suselibrary.entity.BorrowCard;
import com.qf.suselibrary.service.BorrowCardService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BorrowCard)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 16:35:00
 */
@Service("borrowCardService")
public class BorrowCardServiceImpl implements BorrowCardService {
    @Resource
    private BorrowCardDao borrowCardDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public BorrowCard queryById(Integer id) {
        return this.borrowCardDao.queryById(id);
    }




    /**
     * 新增数据
     *
     * @param borrowCard 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(BorrowCard borrowCard) {
        return this.borrowCardDao.insert(borrowCard);
    }

    /**
     * 修改数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer update(BookUpdata bookUpdata) {
        BorrowCard borrowCard=new BorrowCard();
        borrowCard.setId(bookUpdata.getId());
        switch (bookUpdata.getField()){
            case "rule_id":
                borrowCard.setRuleId(Integer.parseInt(bookUpdata.getValue()));
                break;
            case "password":
                borrowCard.setPassword(bookUpdata.getValue());
                break;
            case "status":
                borrowCard.setStatus(Integer.parseInt(bookUpdata.getValue()));
                break;

        }
        return this.borrowCardDao.update(borrowCard);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAll(BorrowCard borrowCard) {
        return this.borrowCardDao.update(borrowCard);
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(JSONArray ids) {
        return  this.borrowCardDao.deleteById(ids) ;
    }


    @Override
    public List<BorrowCardService> queryAll(Integer page, Integer limit) {

        if(page == null || limit == null){
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;

        List<BorrowCardService> borrowCardServiceList = borrowCardDao.queryAll(page, limit);

        return borrowCardServiceList;
    }

    @Override
    public Long querycountBook() {
        return borrowCardDao.count();
    }



    @Override
    public Map<String, Object> queryByconditions(String reader, Integer page, Integer limit) {
        if (page == null || limit == null) {
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;

        //分页查询的前面10条数据
        List<BorrowCardDto>  borrowcard_list = borrowCardDao.queryPageByconditions(reader, page, limit);
        //没有分页的时候，当前的条件一功能查到多少条数据
        List<BorrowCardDto> borrowCardServices = borrowCardDao.queryByconditions(reader);
        Long count = Long.valueOf(borrowCardServices.size());

        HashMap<String, Object> map = new HashMap<>();
        map.put("borrowcard_list", borrowcard_list);
        map.put("count", count);
        return map;
    }
}
