package com.qf.suselibrary.controller;

import com.qf.suselibrary.dto.BookBorrowDto;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("show")
public class BookBorrowController {

    @Autowired
    private BooksService booksService;

    @GetMapping
    public ResponseData queryBorrow(BookBorrowDto bookBorrowDto){
        Map<String,Object> map = booksService.queryBorrow(bookBorrowDto);
        return new ResponseData(ResponseCode.SUCCESS,map);
    }
}
