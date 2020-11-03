package com.example.foxclub.repository;

import com.example.foxclub.models.Fox;
import java.util.List;

public interface FoxRepository {
  List<String[]> returnAllfoxProperties();

  static List<Fox> loadAllSavedFoxes(){
    return FoxDataReader.loadAllSavedFoxes();
  };

  boolean checkFox(String name);

  Fox findFoxByName(String name);

  void saveAllFoxes(List<Fox> foxes);


}
