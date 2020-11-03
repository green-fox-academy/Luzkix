package com.example.foxclub.models;

import java.time.LocalDateTime;
import java.util.List;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private List<Trick> tricks;
  private LocalDateTime lastChange;

  public Fox (String name) {
    this.name = name;
    this.lastChange = LocalDateTime.now();
  }
  public Fox (LocalDateTime lastChange, String name) {
    this.name = name;
    this.lastChange=lastChange;
  }

  public String getName() {
    return name;
  }

  public String getFood() {
    return food;
  }

  public String getDrink() {
    return drink;
  }

  public List<Trick> getTricks() {
    return tricks;
  }

  public LocalDateTime getLastChange() {
    return lastChange;
  }

  public void setLastChange() {
    this.lastChange = LocalDateTime.now();
  }


  @Override
  public String toString() {
    return this.lastChange.toString() + ";" + this.name ;
  }
}
