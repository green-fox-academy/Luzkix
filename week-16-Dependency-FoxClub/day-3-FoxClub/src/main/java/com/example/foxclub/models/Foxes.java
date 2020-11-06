package com.example.foxclub.models;

import com.example.foxclub.services.FoxService;
import java.util.List;

public class Foxes {
  private static List<Fox> loadedFoxes = FoxService.loadAllSavedFoxes();
  private static List<Fox> allFoxes = loadedFoxes;

  public Foxes () {}

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
