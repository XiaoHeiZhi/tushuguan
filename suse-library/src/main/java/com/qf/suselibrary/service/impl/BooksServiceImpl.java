package com.qf.suselibrary.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.qf.suselibrary.dao.BooksDao;
import com.qf.suselibrary.dto.BookBorrowDto;
import com.qf.suselibrary.dto.BookUpdata;
import com.qf.suselibrary.dto.Booksdto;
import com.qf.suselibrary.entity.Books;
import com.qf.suselibrary.service.BooksService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Books)表服务实现类
 *
 * @author makejava
 * @since 2022-07-11 22:20:48
 */
@Service("booksService")
public class BooksServiceImpl implements BooksService {
    @Resource
    private BooksDao booksDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Books queryById(Integer id) {
        return this.booksDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param books       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */


    /**
     * 新增数据
     *
     * @param books 实例对象
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer insert(Books books) {

        return this.booksDao.insert(books);
    }


    /**
     * 修改数据
     *
     * @param
     * @return 实例对象
     */
    @Override
    @Transactional(rollbackFor = Exception.class)//添加事务
    public Integer update(BookUpdata bookUpdata) {
        Books book=new Books();
        book.setId(bookUpdata.getId());
        switch (bookUpdata.getField()){
            case "description":
                book.setDescription(bookUpdata.getValue());
                break;
            case "position":
                book.setPosition(bookUpdata.getValue());
                break;
            case "status":
                book.setStatus(Integer.parseInt(bookUpdata.getValue()));

        }
        return this.booksDao.update(book);
    }

    /**
     * 通过主键删除数据
     *
     * @param
     * @return 是否成功
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer deleteById(JSONArray ids){
        return this.booksDao.deleteById(ids) ;
    };

    @Override
    public List<Booksdto> queryAll(Integer page, Integer limit) {

        if(page == null || limit == null){
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;

        List<Booksdto> booksdtos = booksDao.queryAll(page, limit);

        return booksdtos;
    }

    @Override
    public Long querycountBook() {
        return booksDao.count();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Integer updateAll(Books books) {
        return booksDao.update(books);
    }

    @Override
    public Map<String, Object> queryByconditions(Books books, Integer page, Integer limit) {
        if (page == null || limit == null) {
            page = 0;
            limit = 10;
        }
        page = (page - 1) * limit;

        //分页查询的前面10条数据
        List<Booksdto>  books_list = booksDao.queryPageByconditions(books, page, limit);
        //没有分页的时候，当前的条件一功能查到多少条数据
        List<Booksdto> booksDtos = booksDao.queryByconditions(books);
        Long count = Long.valueOf(booksDtos.size());

        HashMap<String, Object> map = new HashMap<>();
        map.put("books_list", books_list);
        map.put("count", count);
        return map;
    }


    /**
     * 借阅量查询
     *
     * @param bookBorrowDto
     * @return
     */
    @Override
    public Map<String, Object> queryBorrow(BookBorrowDto bookBorrowDto) {
        List<BookBorrowDto> borrow_list = booksDao.queryBorrow();
        HashMap<String, Object> map = new HashMap<>();
        map.put("list",borrow_list);

        return map;

    }
}
