package com.bccoder.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
//@ImportResource("classpath:transaction.xml")
@MapperScan({"com.bccoder.transaction.persistence.mappers"})
public class SpringbootTransactionApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootTransactionApplication.class, args);
    }

}
