package com.example.lastfresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LastfreshApplication {

    public static void main(String[] args) {
        SpringApplication.run(LastfreshApplication.class, args);
    }

}
