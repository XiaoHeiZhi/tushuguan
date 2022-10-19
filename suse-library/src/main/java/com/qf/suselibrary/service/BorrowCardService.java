package com.qf.suselibrary.service;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.entity.BorrowCard;

import java.util.List;
import java.util.Map;

/**
 * (BorrowCard)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 16:35:00
 */
public interface BorrowCardService {

    Integer update(BookUpdata bookUpdata);


    Integer deleteById(JSONArray ids);

    List<BorrowCardService> queryAll(Integer page, Integer limit);

    Long querycountBook();

    Integer insert(BorrowCard borrowCard);

    BorrowCard queryById(Integer id);

    Integer updateAll(BorrowCard borrowCard);

    Map<String, Object> queryByconditions(String reader, Integer page, Integer limit);

}
