package com.example.foxclub.repository;

import com.example.foxclub.models.Fox;
import java.text.Normalizer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoxRepositoryImpl implements FoxRepository {
  private final FoxDataWriter dataWriter;
  private final FoxDataReader dataReader;

  @Autowired
  public FoxRepositoryImpl (FoxDataWriter dataWriter, FoxDataReader dataReader) {
    this.dataWriter = dataWriter;
    this.dataReader = dataReader;
  }

  @Override
  public List<String[]> returnAllfoxProperties() {
    return dataReader.returnAllfoxProperties();
  }

  @Override
  public boolean checkFox(String name) {
    for(String[] fox : returnAllfoxProperties()) {
      if (removeDiacritic(fox[1].toLowerCase()).equals(removeDiacritic(name.toLowerCase()))) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Fox findFoxByName(String name) {
    return null;
  }

  @Override
  public void saveAllFoxes(List<Fox> foxes) {
  dataWriter.saveAllFoxes(foxes);
  }

  //method eliminating the diactritics from names
  public static String removeDiacritic(String string) {
    return Normalizer.normalize(string, Normalizer.Form.NFD)
        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
  }
}
