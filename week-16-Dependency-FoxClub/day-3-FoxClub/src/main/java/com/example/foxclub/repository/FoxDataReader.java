package com.example.foxclub.repository;

import static java.util.Collections.emptyList;


import com.example.foxclub.configurations.Configurations;
import com.example.foxclub.models.Fox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FoxDataReader {

  public List<String[]> returnAllfoxProperties() {

    try {
      Path path = Paths.get(Configurations.getFoxesSaveFile());
      List<String>lines = Files.readAllLines(path);
      List<String[]> splitedLines = new ArrayList<>();
      for(String line : lines) {
        splitedLines.add(line.split(";"));
      }
      return splitedLines;
    } catch (IOException e) {
      e.printStackTrace();
    }
    return emptyList();
  }


  public static List<Fox> loadAllSavedFoxes() {

    try {
      Path path = Paths.get(Configurations.getFoxesSaveFile());
      return Files.lines(path)
          .map(line -> line.trim().split(";"))
          .map(parts -> new Fox(LocalDateTime.parse(parts[0]), parts[1]))
          .collect(Collectors.toList());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return emptyList();
  }

}
