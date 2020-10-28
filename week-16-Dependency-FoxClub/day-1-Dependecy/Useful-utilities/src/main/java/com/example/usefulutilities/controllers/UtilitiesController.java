package com.example.usefulutilities.controllers;

import com.example.usefulutilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UtilitiesController {

  @Autowired
  UtilityService utilityService;


  @GetMapping("/useful")
  public String homepage () {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String colored (Model model) {
    model.addAttribute("fullColor", "background-color: " + utilityService.randomColor() + ";");
    return "colored";
  }

  @PostMapping("/useful/email")
  public String emailValidation (Model model, @RequestParam String emailInput) {
    String textResponse = "";
    String formatResponse = "";

    if(utilityService.validateEmail(emailInput)) {
      textResponse="<p style='color:green;'>"+emailInput+" is a valid email address</p>";
      formatResponse="background-color:green";
    } else {
      textResponse="<p style='color:red;'>"+emailInput+" is not a valid email address!</p>";
      formatResponse="background-color:red";
    }
    model.addAttribute("EmailFormatStyle", formatResponse);
    model.addAttribute("EmailFormatResponse", textResponse);
    return "useful";
  }

  @PostMapping("/useful/encode")
  public String encode (@RequestParam String word, @RequestParam Integer ciphre, Model model) {
    String textResponse = utilityService.caesar(word, ciphre);
    model.addAttribute("cipherResult", "Encoded word/sentence is: <strong>"+textResponse+"</strong>");

    return "useful";
  }

  @PostMapping("/useful/decode")
  public String decode (@RequestParam String word, @RequestParam Integer ciphre, Model model) {
    String textResponse = utilityService.caesar(word, ciphre*(-1));
    model.addAttribute("cipherResult", "Decoded word/sentence is: <strong>"+textResponse+"</strong>");
    return "useful";
  }

}
