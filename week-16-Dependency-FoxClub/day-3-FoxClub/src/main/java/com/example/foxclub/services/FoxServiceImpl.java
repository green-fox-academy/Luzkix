package com.example.foxclub.services;

import com.example.foxclub.controllers.MainController;
import com.example.foxclub.models.Fox;
import com.example.foxclub.models.Foxes;
import com.example.foxclub.repository.FoxRepository;
import java.text.Normalizer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FoxServiceImpl implements FoxService {
  private final FoxRepository foxRepository;
  private final Foxes foxes;

  @Autowired
  public FoxServiceImpl(FoxRepository foxRepository, Foxes foxes) {
    this.foxRepository = foxRepository;
    this.foxes = foxes;
  }

  @Override
  public boolean checkFox(String foxName) {
    for (Fox fox : Foxes.getAllFoxes()) {
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
  public void addFox(String foxName) {
    Foxes.addFoxToListOfFoxes(new Fox(foxName));
  }

  @Override
  public List<String[]> returnAllfoxProperties() {
    return foxRepository.returnAllfoxProperties();
  }

  @Override
  public void saveAllFoxes() {
    System.out.println(Foxes.getAllFoxes());
    foxRepository.saveAllFoxes(Foxes.getAllFoxes());
  };

  @Override
  public void deleteFox(String foxName) {
    List<Fox> newListOfFoxes = Foxes.getAllFoxes();
    for (Fox fox : newListOfFoxes) {
      if (fox.getName().equals(foxName)) {
        newListOfFoxes.remove(fox);
      }
    }
    Foxes.setNewListOfFoxes(newListOfFoxes);
  }

}
