package com.example.foxclub.models;

import com.example.foxclub.configurations.Configurations;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fox {
  private String name;
  private String food = new String();
  private String drink = new String();
  private LocalDateTime lastChange;
  private List<String> tricks = new ArrayList<>();

  public Fox (String name) {
    this.name = name;
    this.lastChange = LocalDateTime.now();
  }

  public Fox (String name, String food, String drink, List<String> tricks) {
    this.lastChange = LocalDateTime.now();
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks = tricks;
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

  public void setFood(String food) {
    this.food = food;
  }

  public String getDrink() {
    return drink;
  }

  public void setDrink(String drink) {
    this.drink = drink;
  }

  public List<String> getTricks() {
    return tricks;
  }

  public void addTrick(String trick) {
    tricks.add(trick);
  }

  public void setTricks(List<String> tricks) {
    this.tricks = tricks;
  }

  public static List<String> getRandomTricks() {
    int randomNumber = (int)(Math.random()*Configurations.getMaxNumberOfRandomTricks());
    List<String> originalListOfTricks = Arrays.stream(Configurations.Tricks.values())
        .map(trick -> trick.toString())
        .collect(Collectors.toList());
    List<String> tricks = new ArrayList<>();

    if(randomNumber > 0) {
      List<String>selectedTricks = new ArrayList<>();
      List<String> unusedTricks = originalListOfTricks;
      for (int i = 0; i < randomNumber; i++) {
        if(!selectedTricks.isEmpty()) {
          unusedTricks.removeAll(selectedTricks);
          selectedTricks.add(unusedTricks.get((int)(Math.random()*(unusedTricks.size()))));
        } else selectedTricks.add(unusedTricks.get((int)(Math.random()*(unusedTricks.size()))));
      }
      return selectedTricks;
    }

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
