package com.qf.suselibrary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qf.suselibrary.dao")
@SpringBootApplication
public class SuseLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SuseLibraryApplication.class, args);
    }

}
