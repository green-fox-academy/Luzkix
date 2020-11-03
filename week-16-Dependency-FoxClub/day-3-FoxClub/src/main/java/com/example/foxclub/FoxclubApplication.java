package com.example.foxclub;

import com.example.foxclub.repository.FoxDataWriter;
import com.example.foxclub.services.FoxService;
import com.example.foxclub.services.FoxServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FoxclubApplication {

  public static void main(String[] args) {
    SpringApplication.run(FoxclubApplication.class, args);

  }

}
