package com.example.coloringaround.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("green")
public class GreenColor implements MyColor {
  @Override
  public void printColor() {
    System.out.println("It is green color");
  }
}
