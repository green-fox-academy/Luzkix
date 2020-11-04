package com.example.foxclub.controllers;

import com.example.foxclub.configurations.Configurations;
import com.example.foxclub.models.Fox;
import com.example.foxclub.services.FoxService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TrickCentre {
  private FoxService foxService;

  @Autowired
  public TrickCentre (FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/tricks")
  public String trickCentrePage (Model model) {
    String loggedUser = MainController.getLoggedUser();
    Fox fox = foxService.getFoxByName(loggedUser);
    if (loggedUser.isEmpty()) {
      model.addAttribute("successfulSign", false);
      return "trickCentre";
    } else {
      model.addAttribute("successfulSign", true);
      model.addAttribute("name", loggedUser);
      model.addAttribute("tricks",foxService.getFoxByName(loggedUser).getTricks());

      if (foxService.getFoxByName(loggedUser).getTricks().size() == 0){
        model.addAttribute("noKnownTricks", true);
      } else model.addAttribute("noKnownTricks", false);

      List<String> tricksToSelect = Arrays.stream(Configurations.Tricks.values())
          .map(a -> a.toString())
          .collect(Collectors.toList());
      tricksToSelect.removeAll(fox.getTricks());

      model.addAttribute("tricksToLearn", tricksToSelect);
      model.addAttribute("knownTricks", fox.getTricks());

      return "trickCentre";
    }
  }

  @PostMapping("/tricks")
  public String learnTricks (@RequestParam String teachTricks, @RequestParam String forgetTricks) {
    String loggedUser = MainController.getLoggedUser();
    Fox fox = foxService.getFoxByName(loggedUser);

    if (!teachTricks.equals("-")) {
      fox.addTrick(teachTricks);
    }

    if (!forgetTricks.equals("-")) {
      List<String> tricksAfterForget = fox.getTricks();
      tricksAfterForget.remove(forgetTricks);
      fox.setTricks(tricksAfterForget);
    }

    return "redirect:/index";
  }
}
