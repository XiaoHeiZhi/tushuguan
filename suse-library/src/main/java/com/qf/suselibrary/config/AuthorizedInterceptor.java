package com.qf.suselibrary.config;

import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.entity.Admin;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import com.qf.suselibrary.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 前端需要做数据操作
 * 拦截前端的所有请求进行判定
 *      1.登录操作怎么办 ----- 释放登录请求
 *      2.可能还有一些其他的请求？ --- 根据实际情况实际处理
 *
 */
@Component
public class AuthorizedInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(AuthorizedInterceptor.class);


    @Autowired
    private AdminService adminService;

    /**
     *
     * 释放路径的白名单
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public static final String[] noAuthorizes = {
            "/users/login",
            ".jpg",
            "/borrowBooks",
            "/show",
            "/manager",
            "/admin",
            "/books",
            "/bookSort",
            "/borrowCard",
            "/library",
            "/managers",
            "/rules"
    };


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1.获取请求信息
        /**
         * requestURI ---- /users/login
         * requestURL ---- http://localhost:8520/    users/login
         *
         */
        String requestURI = request.getRequestURI();
        logger.info("本次请求为："+requestURI);
        //2.释放白名单里面的路径
        for(String noAuthorize : noAuthorizes){
            if(requestURI.contains(noAuthorize)){
                return true;
            }
        }
        //----因为涉及到跨域   前端在发送请求的时候，会提前发起一个OPTIONS类型的预检请求
        //3.释放预检请求（OPTIONS）
        String method = request.getMethod();
        if (method.equalsIgnoreCase("OPTIONS")) {
            return true;
        }
        //4.获取请求中的token ---token存放在cookie中
        Cookie[] cookies = request.getCookies();
        String token = "";
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }
        //5.验证token是否存在 （redis--本次采用mysql）
        Admin admin = adminService.queryByRemark(token);
        if (admin == null) {
            ResponseData responseData = new ResponseData(ResponseCode.USERINFO_ERROR);
            String s = JSONObject.toJSONString(responseData);
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(s);
            response.getWriter().flush();
            response.getWriter().close();
            return false;
        }

        return true;
    }
}
