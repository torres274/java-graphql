package com.example.java.graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class JavaGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaGraphqlApplication.class, args);
    }

}
