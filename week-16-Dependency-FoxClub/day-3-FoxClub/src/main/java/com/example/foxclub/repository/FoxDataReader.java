package com.example.foxclub.repository;

import static java.util.Collections.emptyList;


import com.example.foxclub.configurations.Configurations;
import com.example.foxclub.models.Fox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FoxDataReader {

  public static List<Fox> loadAllSavedFoxes() {

    try {
      Path foxesPath = Paths.get(Configurations.getFoxesSaveFile());

      List<Fox> loadedFoxes = Files.lines(foxesPath)
          .map(line -> line.trim().split(";"))
          .map(parts -> new Fox(parts[0], parts[1], parts[2]))
          .map(fox -> loadTricksForFox(fox))
          .map(fox -> loadHistoryForFox(fox))
          .collect(Collectors.toList());

      return loadedFoxes;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return emptyList();
  }

  private static Fox loadTricksForFox(Fox fox) {
    List<String[]> loadedTricks = loadAllTricks();
    for (String[] tricks : loadedTricks) {
      if (tricks[0].equals(fox.getName())) {
        for (int i = 0; i < tricks.length; i++) {
          fox.addTrick(tricks[i]);
        }
        return fox;
      }
    }
    return fox;
  }

  private static Fox loadHistoryForFox(Fox fox) {
    List<String[]> loadedHistory = loadAllHistory();
    for (String[] foxHistory : loadedHistory) {
      if (foxHistory[0].equals(fox.getName())) {
        for (int i = 0; i < foxHistory.length; i++) {
          fox.addHistory(foxHistory[i]);
        }
        return fox;
      }
    }
    return fox;
  }

  public static List<String[]> loadAllTricks() {

    try {
      Path tricksPath = Paths.get(Configurations.getTricksSaveFile());

      List<String[]> loadedTricks = Files.lines(tricksPath)
          .map(line -> line.trim().split(";"))
          .collect(Collectors.toList());

      return loadedTricks;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return emptyList();
  }

  public static List<String[]> loadAllHistory() {

    try {
      Path historyPath = Paths.get(Configurations.getHistorySaveFile());

      List<String[]> loadedHistory = Files.lines(historyPath)
          .map(line -> line.trim().split(";"))
          .collect(Collectors.toList());

      return loadedHistory;
    } catch (IOException e) {
      e.printStackTrace();
    }

    return emptyList();
  }

}
