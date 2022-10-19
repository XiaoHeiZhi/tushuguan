package com.qf.suselibrary.controller;

import com.qf.suselibrary.service.LibraryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Library)表控制层
 *
 * @author makejava
 * @since 2022-07-13 15:46:06
 */
@RestController
@RequestMapping("library")
public class LibraryController {
    /**
     * 服务对象
     */
    @Resource
    private LibraryService libraryService;


}

