package com.example.foxclub.repository;

import com.example.foxclub.models.Fox;
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
  public void saveAllFoxes(List<Fox> foxes) {
  dataWriter.saveAllFoxes(foxes);
  }

}
