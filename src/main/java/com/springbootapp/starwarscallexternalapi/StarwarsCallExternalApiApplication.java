package com.springbootapp.starwarscallexternalapi;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@JsonAutoDetect
public class StarwarsCallExternalApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarwarsCallExternalApiApplication.class, args);
    }
}
