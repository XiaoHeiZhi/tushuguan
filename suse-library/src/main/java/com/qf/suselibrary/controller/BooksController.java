package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.dto.Booksdto;
import com.qf.suselibrary.entity.BookSort;
import com.qf.suselibrary.entity.Books;
import com.qf.suselibrary.entity.Library;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.BookSortService;
import com.qf.suselibrary.service.BooksService;
import com.qf.suselibrary.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Books)表控制层
 *
 * @author makejava
 * @since 2022-07-11 22:20:47
 */
@RestController
@RequestMapping("books")
public class BooksController {
    /**
     * 服务对象
     */
    @Autowired
    private BooksService booksService;

    @Autowired
    private BookSortService bookSortService;
    @Autowired
    private LibraryService libraryService;

    /**
     *
     *
     * @param
     * @param
     * @return 查询结果
     */
    @GetMapping
    public ResponseData queryAll(Integer page, Integer limit) {
        //由于前端是问号传参所以可以直接用形参来接收参数
        List<Booksdto> books_list = booksService.queryAll(page,limit);
        Long count = booksService.querycountBook();

        return new ResponseData("0", "success",count ,books_list);

    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseData queryById(@PathVariable("id") Integer id) {
        Books book = booksService.queryById(id);
        List<BookSort> bookSorts_list = bookSortService.queryAll();
        List<Library> library_list = libraryService.queryAll();
        HashMap<String, Object> res = new HashMap<>();
        res.put("book", book);
        res.put("bookSorts_list", bookSorts_list);
        res.put("library_list", library_list);
        return new ResponseData(ResponseCode.SUCCESS, res);
    }


    @GetMapping("conditions")
    public ResponseData queryConditions(Books books, Integer page, Integer limit) {
        Map<String, Object> map = booksService.queryByconditions(books, page, limit);
        System.out.println(map.get("books_list"));
        return new ResponseData("0", "SUCCESS" , (Long) map.get("count"),map.get("books_list"));

    }


    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */



    @PostMapping("insert")
    public ResponseData insert(){
        List<BookSort> bookSorts_list = bookSortService.queryAll();
        List<Library> library_list = libraryService.queryAll();

        HashMap<String, Object> res = new HashMap<>();
        res.put("bookSorts_list", bookSorts_list);
        res.put("library_list", library_list);
        return new ResponseData(ResponseCode.SUCCESS, res);

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
        Books books=new Books();
        books.setId(Integer.parseInt(jsonObject.getString("id")));
        books.setDescription(jsonObject.getString("description"));
        books.setAuthor(jsonObject.getString("author"));
        books.setLibraryId(Integer.parseInt(jsonObject.getString("library")));
        books.setName(jsonObject.getString("name"));
        books.setPosition(jsonObject.getString("position"));
        books.setSortId(Integer.parseInt(jsonObject.getString("sort")));
        books.setStatus(Integer.parseInt(jsonObject.getString("status")));
        Integer i= booksService.updateAll(books);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

    }


    @PutMapping("insert")
    public ResponseData insert(@RequestBody String info ){
        JSONObject jsonObject = JSONObject.parseObject(info);
        Books books=new Books();
        books.setDescription(jsonObject.getString("description"));
        books.setAuthor(jsonObject.getString("author"));
        books.setLibraryId(Integer.parseInt(jsonObject.getString("library")));
        books.setName(jsonObject.getString("name"));
        books.setPosition(jsonObject.getString("position"));
        books.setSortId(Integer.parseInt(jsonObject.getString("sort")));
        books.setStatus(Integer.parseInt(jsonObject.getString("status")));
        Integer i= booksService.insert(books);

        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

    }

    @PatchMapping
    public ResponseData update(@RequestBody BookUpdata bookUpdata) {
        Integer i = booksService.update(bookUpdata);

        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        }
        return new ResponseData(ResponseCode.FAILED);

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
        Integer i = booksService.deleteById(idArr);
        if (i > 0) {
            return new ResponseData(ResponseCode.SUCCESS);
        } else {
            return new ResponseData(ResponseCode.FAILED);
        }

    }

}

