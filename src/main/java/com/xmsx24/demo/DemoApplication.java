package com.xmsx24.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws JsonProcessingException {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("================================start success==========================");
    }


}
