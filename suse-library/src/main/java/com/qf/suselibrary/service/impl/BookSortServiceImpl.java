package com.qf.suselibrary.service.impl;

import com.qf.suselibrary.dao.BookSortDao;
import com.qf.suselibrary.entity.BookSort;
import com.qf.suselibrary.service.BookSortService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (BookSort)表服务实现类
 *
 * @author makejava
 * @since 2022-07-11 22:20:34
 */
@Service("bookSortService")
public class BookSortServiceImpl implements BookSortService {
    @Resource
    private BookSortDao bookSortDao;


    @Override
    public List<BookSort> queryAll() {
        return bookSortDao.queryAll();
    }

}
