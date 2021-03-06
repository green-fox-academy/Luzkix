package com.example.foxclub.services;

import com.example.foxclub.models.Fox;
import com.example.foxclub.models.Foxes;
import com.example.foxclub.repository.FoxRepository;
import java.util.List;

public interface FoxService {
  boolean checkFox (String foxName);
  void addFox(String foxName, String food, String drink, List<String> trick);
  static List<Fox> loadAllSavedFoxes(){
    return FoxRepository.loadAllSavedFoxes();
  };
  void saveAllFoxes();
  void deleteFox(String foxName);
  Fox getFoxByName(String foxName);
  void addHistory (String foxName, String history);
}
