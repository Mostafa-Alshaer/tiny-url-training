package com.example.tinyurltraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TinyUrlTrainingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TinyUrlTrainingApplication.class, args);
    }

}
