package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWebController {

  @RequestMapping(value = "/web/greeting", method = RequestMethod.GET)
  public String greeting(Model model) {
    model.addAttribute("name", " World");
    return "greeting";
  }
}
