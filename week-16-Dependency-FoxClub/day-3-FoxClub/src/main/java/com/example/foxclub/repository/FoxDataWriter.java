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
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private String serializeFox(Fox fox) {
    String foxToBeStored =String.format("%s;%s", fox.getLastChange(), fox.getName());
    return foxToBeStored;
  }

}
