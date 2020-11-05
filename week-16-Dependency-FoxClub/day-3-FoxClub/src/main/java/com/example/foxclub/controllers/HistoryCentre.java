package com.example.foxclub.controllers;


import com.example.foxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HistoryCentre {
  private FoxService foxService;

  @Autowired
  public HistoryCentre(FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/history")
  public String historyPage(Model model) {

      return "history";

  }

}
