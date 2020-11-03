package com.example.foxclub.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Fox {
  private String name;
  private String food;
  private String drink;
  private LocalDateTime lastChange;
  private List<String> tricks = new ArrayList<>();

  public Fox (String name) {
    this.name = name;
    this.lastChange = LocalDateTime.now();
  }

  public Fox (String name, String food, String drink, String trick) {
    this.lastChange = LocalDateTime.now();
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks.add(trick);
  }
  //využití pro vyčítání souborů - potřeba pak opravit!
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

  public List<String> getTricks() {
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
    return this.name;
  }
}
