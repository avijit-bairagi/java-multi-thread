package com.ovi.multithread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MultiThreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultiThreadApplication.class, args);
    }

}
