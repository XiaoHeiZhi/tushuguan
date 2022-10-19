package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.entity.Rules;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * (Rules)表控制层
 *
 * @author makejava
 * @since 2022-07-13 19:19:56
 */
@RestController
@RequestMapping("rules")
public class RulesController {
    /**
     * 服务对象
     */
    @Autowired
    private RulesService rulesService;
    //分页查询
    // http://localhost:8080/employees?page=1 & limit =10
    @GetMapping
    public ResponseData queryAllInt(Integer page,Integer limit){
        List<Rules> rules_List = rulesService.queryAllInt(page,limit);
        Long count = rulesService.countInt();
        return new ResponseData("0","success",count,rules_List);
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData queryByInt(@PathVariable("id") Integer id) {
        Rules rules = rulesService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS,rules);
    }
    /**
     * 新增数据
     *
     * @param rules 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseData insertInt(@RequestBody Rules rules) {
        Integer i= rulesService.insertInt(rules);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new  ResponseData(ResponseCode.FAILED);
    }

    /**
     * 编辑数据
     *
     * @param rules 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseData updateInt(@RequestBody Rules rules) {
        Integer i= rulesService.updateInt(rules);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new  ResponseData(ResponseCode.FAILED);
    }

    /**
     * 删除数据
     *
     * @param
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseData delete(@RequestBody String ids) {
        JSONObject jsonObject = JSONObject.parseObject(ids);
        JSONArray idArr= (JSONArray) jsonObject.get("ids");
        Integer i = rulesService.deleteByInt(idArr);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }



}

