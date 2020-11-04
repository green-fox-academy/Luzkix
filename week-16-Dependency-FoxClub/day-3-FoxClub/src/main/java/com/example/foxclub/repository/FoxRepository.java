package com.example.foxclub.repository;

import com.example.foxclub.models.Fox;
import java.util.List;

public interface FoxRepository {

  static List<Fox> loadAllSavedFoxes(){
    return FoxDataReader.loadAllSavedFoxes();
  };

  void saveAllFoxes(List<Fox> foxes);


}
