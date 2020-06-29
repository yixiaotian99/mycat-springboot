package com.xiao.mycat.orders;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan("com.xiao.mycat.orders.dao")
@SpringBootApplication
public class MycatOrdersApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycatOrdersApplication.class, args);
    }

}
