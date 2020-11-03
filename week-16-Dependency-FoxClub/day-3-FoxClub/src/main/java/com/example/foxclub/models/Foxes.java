package com.example.foxclub.models;

import com.example.foxclub.services.FoxService;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class Foxes {
  private static List<Fox> allFoxes;

  public Foxes () {
    this.allFoxes = FoxService.loadAllSavedFoxes();
  }

  public static List<Fox> getAllFoxes() {
    return allFoxes;
  }

  public static void addFoxToListOfFoxes(Fox fox) {
    allFoxes.add(fox);
  }

  public static void setNewListOfFoxes(List<Fox> foxes) {
    allFoxes = foxes;
  }
}
