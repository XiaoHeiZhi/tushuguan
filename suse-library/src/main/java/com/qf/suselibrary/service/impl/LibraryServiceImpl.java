package com.qf.suselibrary.service.impl;

import com.qf.suselibrary.dao.LibraryDao;
import com.qf.suselibrary.entity.Library;
import com.qf.suselibrary.service.LibraryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Library)表服务实现类
 *
 * @author makejava
 * @since 2022-07-13 15:46:07
 */
@Service("libraryService")
public class LibraryServiceImpl implements LibraryService {
    @Resource
    private LibraryDao libraryDao;

    @Override
    public List<Library> queryAll() {
        return libraryDao.queryAll();
    }
}
