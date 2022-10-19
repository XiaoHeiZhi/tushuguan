package com.qf.suselibrary.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public static final String[] ORIGINS={"GET","POST","DELETE","PUT","PATCH"};


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")                     //释放所有的请求
                .allowedOriginPatterns("*")                       //释放所有的源
                .allowedHeaders(CorsConfiguration.ALL)            //允许访问的请求设置请求头信息
                .allowedMethods(ORIGINS)                          // 设置允许访问的请求方式
                .allowCredentials(true)                           //允许请求携带Cookie
                .maxAge(3600);                                    //预检请求的有效时间
    }

    @Autowired
    private AuthorizedInterceptor authorizedInterceptor;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authorizedInterceptor);
//    }
}
