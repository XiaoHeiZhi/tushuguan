package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.entity.BorrowCard;
import com.qf.suselibrary.entity.Rules;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.BorrowCardService;
import com.qf.suselibrary.service.RulesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (BorrowCard)表控制层
 *
 * @author makejava
 * @since 2022-07-13 16:34:59
 */
@RestController
@RequestMapping("borrowCard")
public class BorrowCardController {
    /**
     * 服务对象
     */
    @Resource
    private BorrowCardService borrowCardService;

    @Resource
    private RulesService rulesService;


    @PatchMapping
    public ResponseData update(@RequestBody BookUpdata bookUpdata) {
        Integer i = borrowCardService.update(bookUpdata);

        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);

    }


    /**
     * 分页查询
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public ResponseData queryAll(Integer page, Integer limit) {//由于前端是问号传参所以可以直接用形参来接收参数
        List<BorrowCardService> books_list = borrowCardService.queryAll(page, limit);
        Long count = borrowCardService.querycountBook();

        return new ResponseData("0", "success", count, books_list);

    }


    @PostMapping("insert")
    public ResponseData insert(){
        List<Rules> rule_list = rulesService.queryAll();
        HashMap<String, Object> res = new HashMap<>();
        res.put("rule_list", rule_list);
        return new ResponseData(ResponseCode.SUCCESS, res);

    }

    @PutMapping("insert")
    public ResponseData insert(@RequestBody String info ){
        JSONObject jsonObject = JSONObject.parseObject(info);
        BorrowCard borrowCard=new BorrowCard();
        borrowCard.setPassword(jsonObject.getString("password"));
        borrowCard.setReader(jsonObject.getString("reader"));
        borrowCard.setRuleId(Integer.parseInt(jsonObject.getString("rule_id")));
        borrowCard.setStatus(Integer.parseInt(jsonObject.getString("status")));
        Integer i= borrowCardService.insert(borrowCard);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData queryById(@PathVariable("id") Integer id) {
        BorrowCard card = borrowCardService.queryById(id);
        List<Rules> rule_list = rulesService.queryAll();
        HashMap<String, Object> res = new HashMap<>();
        res.put("card", card);
        res.put("rule_list", rule_list);
        return new ResponseData(ResponseCode.SUCCESS, res);
    }

    /**
     * 新增数据
     *
     * @param borrowCard 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<BorrowCard> add(BorrowCard borrowCard) {
        return null;
    }

    /**
     * 编辑数据
     *
     * @param
     * @return 编辑结果
     */
    @PutMapping
    public ResponseData updateAll(@RequestBody String info ){
        JSONObject jsonObject = JSONObject.parseObject(info);
        BorrowCard borrowCard=new BorrowCard();
        borrowCard.setId(Integer.parseInt(jsonObject.getString("id")));
        borrowCard.setPassword(jsonObject.getString("password"));
        borrowCard.setReader(jsonObject.getString("reader"));
        borrowCard.setRuleId(Integer.parseInt(jsonObject.getString("rule_id")));
        borrowCard.setStatus(Integer.parseInt(jsonObject.getString("status")));
        Integer i= borrowCardService.updateAll(borrowCard);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

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
        JSONArray idArr = (JSONArray) jsonObject.get("ids");
        Integer i = borrowCardService.deleteById(idArr);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

    }


    @GetMapping("conditions")
    public ResponseData queryConditions(String reader, Integer page, Integer limit) {


        Map<String, Object> map = borrowCardService.queryByconditions(reader, page, limit);

        return new ResponseData("0", "SUCCESS", (Long) map.get("count"), map.get("borrowcard_list"));

    }

}

