package com.example.foxclub.services;

import com.example.foxclub.models.Fox;
import java.util.List;

public interface FoxService {
  boolean checkFox (String foxName);
  void addFox(String foxName, String food, String drink, List<String> trick);
  void deleteFox(String foxName);
  Fox getFoxByName(String foxName);
  void addHistory (String foxName, String history);
  List<String> getHistory (String foxName);
}
