package com.example.foxclub.services;

import com.example.foxclub.controllers.MainController;
import com.example.foxclub.models.Fox;
import com.example.foxclub.repository.FoxRepository;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxServiceImpl implements FoxService {
  private final FoxRepository foxRepository;


  @Autowired
  public FoxServiceImpl(FoxRepository foxRepository) {
    this.foxRepository = foxRepository;

  }

  @Override
  public boolean checkFox(String foxName) {
    for (Fox fox : foxRepository.findAll()) {
      if (removeDiacritic(fox.getName().toLowerCase())
          .equals(removeDiacritic(foxName.toLowerCase()))) {
        MainController.setCheckedName(fox.getName());
        return true;
      }
    }
    return false;
  }
  //method eliminating the diactritics from names
  public static String removeDiacritic(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }

  @Override
  public Fox getFoxByName(String foxName) {
    for (Fox fox : foxRepository.findAll()) {
      if (removeDiacritic(fox.getName().toLowerCase())
          .equals(removeDiacritic(foxName.toLowerCase()))) {
        return fox;
      }
    }
    return null;
  }

  @Override
  public void addFox(String foxName, String food, String drink, List<String> tricks) {
    foxRepository.save(new Fox(foxName, food, drink, tricks));
    /*Foxes.addFoxToListOfFoxes(new Fox(foxName, food, drink, tricks));*/
  }

  @Override
  public void deleteFox(String foxName) {

    List<Fox> originalListOfFoxes = foxRepository.findAll();
    List<Fox> newListOfFoxes = originalListOfFoxes;
    for (Fox fox : originalListOfFoxes) {
      if (fox.getName().equals(foxName)) {
        newListOfFoxes.remove(fox);
        break;
      }
    }
    foxRepository.saveAll(newListOfFoxes);
  }

  @Override
  public void addHistory(String foxName, String history) {
    Fox updatedFox =  getFoxByName(foxName);
    updatedFox.addHistory(LocalDateTime.now()
        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
        + ":"
        + history);
    foxRepository.save(updatedFox);
  }

  @Override
  public List<String> getHistory(String foxName) {

    return getFoxByName(foxName).getHistoryForSaving();
  }
}

