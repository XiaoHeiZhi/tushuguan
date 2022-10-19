package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.entity.Manager;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.ManagerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Manager)表控制层
 *
 * @author makejava
 * @since 2022-07-13 18:15:42
 */
@RestController
@RequestMapping("managers")
public class ManagerController {
    /**
     * 服务对象
     */
    @Resource
    private ManagerService managerService;


    //  分页查所有
    @GetMapping
    private ResponseData queryAll(Integer page,Integer limit){
        List<Manager> managerList=managerService.queryAll(page,limit);
        Long count =managerService.countManger();
        return new ResponseData("0","success",count,managerList);
    }



//  通过id查，（编辑）
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData queryById(@PathVariable("id") Integer id) {
        Manager manager = managerService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS,manager);
    }
    //  删除
    @DeleteMapping
    public ResponseData delete(@RequestBody String ids){
        JSONObject jsonObject = JSONObject.parseObject(ids);
        JSONArray idArr=(JSONArray) jsonObject.get("ids");
        Integer i = managerService.deleteById(idArr);
        if (i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }
    //  添加
    @PostMapping
    public ResponseData insert(@RequestBody Manager manager){
        Integer insert = managerService.insert(manager);
        if (insert>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }

    //  修改
    @PutMapping
    public ResponseData update(@RequestBody Manager manager){
        Integer i = managerService.update(manager);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }
}

