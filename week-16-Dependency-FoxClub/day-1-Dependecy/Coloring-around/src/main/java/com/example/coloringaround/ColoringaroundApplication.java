package com.example.coloringaround;

import com.example.coloringaround.services.MyColor;
import com.example.coloringaround.services.Printer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ColoringaroundApplication implements CommandLineRunner {
  @Autowired
  @Qualifier("red")
  MyColor red;

  @Autowired
  @Qualifier("green")
  MyColor green;

  @Autowired
  Printer printer;


  public static void main(String[] args) {
    SpringApplication.run(ColoringaroundApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
    red.printColor();
    green.printColor();
  }
}
