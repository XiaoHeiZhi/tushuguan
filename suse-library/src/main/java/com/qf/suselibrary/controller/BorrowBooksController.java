package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.entity.BorrowBooks;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.BorrowBooksService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (BorrowBooks)表控制层
 *
 * @author makejava
 * @since 2022-07-13 18:13:45
 */
@RestController
@RequestMapping("borrowBooks")
public class BorrowBooksController {
    /**
     * 服务对象
     */
    @Resource
    private BorrowBooksService borrowBooksService;

    //  通过id查,(编辑)
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData queryById(@PathVariable("id") Integer id) {
        BorrowBooks borrowBooks = borrowBooksService.queryById(id);
        return new ResponseData(ResponseCode.SUCCESS,borrowBooks);
    }
    //  分页查所有
    @GetMapping
    public ResponseData queryAll(Integer page,Integer limit){
        List<BorrowBooks> borrowBooksList= borrowBooksService.queryAll(page,limit);
        Long count=borrowBooksService.countBorrowBooks();
        return new ResponseData("0","success",count,borrowBooksList);
    }

    //  添加
    @PostMapping
    public ResponseData insert(@RequestBody BorrowBooks borrowBooks){
        Integer i = borrowBooksService.insert(borrowBooks);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS,borrowBooks);
        }
        return new ResponseData(ResponseCode.FAILED);
    }
    //  删除
    @DeleteMapping
    public ResponseData delete(@RequestBody String ids){
        JSONObject jsonObject = JSONObject.parseObject(ids);
        JSONArray idArr=(JSONArray) jsonObject.get("ids");
        Integer i = borrowBooksService.deleteById(idArr);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }
    //  修改
    @PutMapping
    public ResponseData update(@RequestBody BorrowBooks borrowBooks){
        Integer i = borrowBooksService.update(borrowBooks);
        if(i>0){
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);
    }
    //  条件查询
    @GetMapping("conditions")
    public ResponseData queryByConditions(BorrowBooks borrowBooks, Integer page, Integer limit){
        Map<String,Object> map=borrowBooksService.queryByConditions(borrowBooks,page,limit);
        return new ResponseData("0","success",(Long)map.get("count"),map.get("borrowBooks_list"));
    }

}

