package com.example.foxclub.repository;

import com.example.foxclub.configurations.FilesConfiguration;
import com.example.foxclub.models.Fox;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoxDataWriter {
  private FilesConfiguration configuration;
  @Autowired
  public FoxDataWriter (FilesConfiguration configuration) {
    this.configuration = configuration;
  }

  public void saveAllFoxes(List<Fox> foxes) {
    try {
      Files.write(Paths.get(configuration.filename), foxes.stream()
          .map(fox -> (serializeFox(fox)))
          .collect(Collectors.toList()));
    } catch (IOException e) {
      e.printStackTrace();
    }

    /*try {
      Files.write(Paths.get(configuration.filename), (serializeFox(fox) + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
    } catch (IOException e) {
      e.printStackTrace();
    }*/
  }

  private String serializeFox(Fox fox) {
    String foxToBeStored =String.format("%s;%s", fox.getLastChange(), fox.getName());
    return foxToBeStored;
  }

}
