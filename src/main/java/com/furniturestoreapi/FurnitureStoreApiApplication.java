package com.furniturestoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;


@SpringBootApplication
@CrossOrigin
public class FurnitureStoreApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FurnitureStoreApiApplication.class, args);
    }

}
