package com.qf.suselibrary.service;

import com.qf.suselibrary.entity.Library;

import java.util.List;

/**
 * (Library)表服务接口
 *
 * @author makejava
 * @since 2022-07-13 15:46:07
 */
public interface LibraryService {



    List<Library> queryAll();
}
