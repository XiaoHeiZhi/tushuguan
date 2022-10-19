package com.qf.suselibrary.controller;

import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private AdminService adminService;

    @PostMapping("login")
    public ResponseData login(@RequestBody String info){

        if(info != null && info != ""){
            JSONObject jsonObject = JSONObject.parseObject(info);
            String username =(String) jsonObject.get("username");
            String password =(String) jsonObject.get("password");
            Map<String,Object> user_info=adminService.login(username,password);
            if(user_info.get("info") != null){
                return new ResponseData(ResponseCode.DATAERROR,user_info);
            }
            return new ResponseData(ResponseCode.SUCCESS,user_info);

        }

        return new ResponseData(ResponseCode.DATAERROR);

    }

}
