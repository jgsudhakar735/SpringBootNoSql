package com.jgsudhakar.nosql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootNoSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootNoSqlApplication.class, args);
    }

}
