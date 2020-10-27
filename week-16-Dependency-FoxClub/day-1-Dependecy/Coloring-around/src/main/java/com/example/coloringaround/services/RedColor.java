package com.example.coloringaround.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("red")
public class RedColor implements MyColor {
/*  private final Printer printer;

  public RedColor (Printer printer) {
    this.printer = printer;
  }*/
  @Autowired
  Printer printer;

  @Override
  public void printColor() {

    printer.log("It is red color");
  }
}
