package com.qf.suselibrary.Exception;

import com.alibaba.fastjson.JSONObject;
import com.qf.suselibrary.result.ResponseCode;
import com.qf.suselibrary.result.ResponseData;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Component
public class GlobalException implements HandlerExceptionResolver {

        @Override
        public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        //代码执行到这里，那么就意味着程序一定报错了
        ResponseData responseData = new ResponseData();
        if (e instanceof BusinessException) {
            BusinessException ex = (BusinessException) e;
            responseData.setCode(ex.getCode());
            responseData.setInfo(ex.getInfo());
        } else if (e instanceof SQLException) {
            responseData.setCode(ResponseCode.SQLEXCEPTION.getCode());
            responseData.setInfo(ResponseCode.SQLEXCEPTION.getInfo());
        } else {
            responseData.setCode(ResponseCode.FAILED.getCode());
            responseData.setInfo(ResponseCode.FAILED.getInfo());
        }

            try {
                String s = JSONObject.toJSONString(responseData);
                httpServletResponse.setContentType("text/html;charset=UTF-8");
                httpServletResponse.getWriter().write(s);
                httpServletResponse.getWriter().flush();
                httpServletResponse.getWriter().close();
            }catch (IOException ex){
                ex.printStackTrace();
            }

            return null;
    }
}
