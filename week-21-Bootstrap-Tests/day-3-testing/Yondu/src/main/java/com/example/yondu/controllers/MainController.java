package com.example.yondu.controllers;

import com.example.yondu.models.ArrowStats;
import com.example.yondu.models.ErrorMessage;
import com.example.yondu.services.ArrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  private ArrowService arrowService;
  public MainController(ArrowService arrowService) {
    this.arrowService = arrowService;
  }


  @GetMapping("/yondu")
  @ResponseBody
  public ResponseEntity<?> calculateSpeed (@RequestParam (required = false) Float distance, @RequestParam (required = false) Float time) {
    if (distance == null || time == null) {
      ErrorMessage error = arrowService.errorMessage("Distance or Time not set! Calculating speed is impossible!");
      return ResponseEntity.badRequest().body(error);
    }else {
      ArrowStats stats = arrowService.calculateSpeed(distance, time);
      return ResponseEntity.ok().body(stats);
    }
  }
}
