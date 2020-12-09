package com.example.groot.services;

import com.example.groot.models.dto.ErrorDTO;
import com.example.groot.models.dto.GrootMessageDTO;
import org.springframework.stereotype.Service;

@Service
public class GrootServiceImp {
  public GrootMessageDTO grootMessage(String message) {
    GrootMessageDTO grootMessage = new GrootMessageDTO();
    grootMessage.setReceived(message);
    grootMessage.setTranslated("I am Groot!");
    return grootMessage;
  }

  public ErrorDTO errorMessage(String s) {
    ErrorDTO errorMessage = new ErrorDTO();
    errorMessage.setError(s);
    return errorMessage;
  }
}
