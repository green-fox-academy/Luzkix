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
  UtilityService randomColor;


  @GetMapping("/useful")
  public String homepage () {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String colored (Model model) {
    /*int randomNum = (int) (Math.random()*10);
    List<String> colors = new ArrayList<>();
    colors.addAll(Arrays.asList("lightblue", "white", "whitesmoke", "chocolate",
        "black", "darkblue", "cornflowerblue", "snow", "gold", "red"));
    String randomColor = colors.get(randomNum);*/
    model.addAttribute("fullColor", "background-color: " + randomColor.randomColor() + ";");
    return "colored";
  }

  @PostMapping("/useful/encode")
  public String encode (@RequestParam String word, @RequestParam Integer ciphre ) {

    return "useful";
  }

  @PostMapping("/useful/decode")
  public String decode (@RequestParam String word, @RequestParam Integer ciphre ) {

    return "useful";
  }

}
