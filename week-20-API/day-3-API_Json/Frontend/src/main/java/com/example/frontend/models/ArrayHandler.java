package com.example.frontend.models;

import java.util.Arrays;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArrayHandler {
  private String what;
  private int[] numbers;

  @Override
  public String toString() {


    return "{'what': "+what+", "+"'numbers': " + Arrays.toString(numbers) +"}";
  }
}
