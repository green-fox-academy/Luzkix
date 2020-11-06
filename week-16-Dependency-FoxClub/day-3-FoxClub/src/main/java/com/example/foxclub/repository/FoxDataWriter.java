package com.example.foxclub.repository;

import com.example.foxclub.configurations.Configurations;
import com.example.foxclub.models.Fox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class FoxDataWriter {

  public void saveAllFoxes(List<Fox> foxes) {
    try {
      Files.write(Paths.get(Configurations.getFoxesSaveFile()), foxes.stream()
          .map(fox -> (serializeFox(fox)))
          .collect(Collectors.toList()));

      Files.write(Paths.get(Configurations.getTricksSaveFile()), foxes.stream()
          .map(fox -> (serializeTricks(fox)))
          .collect(Collectors.toList()));

      Files.write(Paths.get(Configurations.getHistorySaveFile()), foxes.stream()
          .map(fox -> (serializeHistory(fox)))
          .collect(Collectors.toList()));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String serializeFox(Fox fox) {
    String foxToBeStored =String.format("%s;%s;%s", fox.getName(), fox.getFood(), fox.getDrink());
    return foxToBeStored;
  }

  private String serializeTricks(Fox fox) {
    List<String> tricks = fox.getTricksForSaving();
    if(tricks.isEmpty()) {
      tricks.add(0, fox.getName());
      return String.join(";", tricks);
    } else if(tricks.get(0).equals(fox.getName())) {
      tricks.set(0, fox.getName());
      return String.join(";", tricks);
    } else {
      tricks.add(0, fox.getName());
      return String.join(";", tricks);
    }
  }

  private String serializeHistory(Fox fox) {
    List<String> history = fox.getHistoryForSaving();
    if(history.isEmpty()) {
      history.add(0, fox.getName());
      return String.join(";", history);
    } else if(history.get(0).equals(fox.getName())) {
      history.set(0, fox.getName());
      return String.join(";", history);
    } else {
      history.add(0, fox.getName());
      return String.join(";", history);
    }
  }
}
