package com.example.groot.controllers;

import com.example.groot.models.dto.ErrorDTO;
import com.example.groot.models.dto.GrootMessageDTO;
import com.example.groot.services.GrootServiceImp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
public class GuardianController {
  private GrootServiceImp grootServiceImp;
  public GuardianController (GrootServiceImp grootServiceImp) {
    this.grootServiceImp = grootServiceImp;
  }

  @GetMapping("/groot")
  public ResponseEntity<?> grootMessage(@RequestParam (required = false) String  message) {
    try {
      if (message == null) {
        ErrorDTO error = grootServiceImp.errorMessage("I am Groot!");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
      } else {
        GrootMessageDTO result = grootServiceImp.grootMessage(message);
        return ResponseEntity.ok().body(result);
      }
    } catch (NullPointerException e) {
      ErrorDTO error = grootServiceImp.errorMessage("I am Groot!");
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
  }

}
