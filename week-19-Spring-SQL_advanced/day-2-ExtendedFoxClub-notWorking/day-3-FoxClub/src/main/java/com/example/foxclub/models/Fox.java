package com.example.foxclub.models;

import com.example.foxclub.configurations.Configurations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "foxes")
public class Fox {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column (columnDefinition = "varchar(255) default 'default'") //
  private String name;
  private String food = new String();
  private String drink = new String();
  @ElementCollection
  private List<String> tricks = new ArrayList<>(); //tricks list contains name of the fox at position 0
  @ElementCollection
  private List<String> history = new ArrayList<>(); //history list contains name of the fox at position 0

  public Fox(){}

  public Fox (String name) {
    this.name = name;
    //this.lastChange = LocalDateTime.now();
  }

  public Fox (String name, String food, String drink) {
    this.name = name;
    this.food = food;
    this.drink = drink;
  }

  public Fox (String name, String food, String drink, List<String> tricks) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks = tricks;
  }

  public Fox (String name, String food, String drink, List<String> tricks, List<String> history) {
    this.name = name;
    this.food = food;
    this.drink = drink;
    this.tricks = tricks;
    this.history = history;
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
    List<String> tricksToReturn = tricks;
    System.out.println(tricks);

    if(tricksToReturn.isEmpty()) {
      return tricksToReturn;
    } else if(tricksToReturn.get(0).equals(name)) {
      tricksToReturn.remove(0);
      return tricksToReturn;
    } else
      return tricksToReturn;
  }

  public List<String> getTricksForSaving() {
    return tricks;
  }

  public void addTrick(String trick) {
    tricks.add(trick);
  }

  public void setTricks(List<String> tricks) {
    this.tricks = tricks;
  }

  public List<String> getHistory() {
    List<String> historyToReturn = history;
    if(historyToReturn.isEmpty()) {
      return historyToReturn;
    } else if(historyToReturn.get(0).equals(name)) {
      historyToReturn.remove(0);
      return historyToReturn;
    } else
      return historyToReturn;
  }

  public List<String> getHistoryForSaving() {
    return history;
  }

  public void setHistory(List<String> history) {
    this.history = history;
  }

  public void addHistory(String action) {
    history.add(action);
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

  @Override
  public String toString() {
    return this.name;
  }
}
