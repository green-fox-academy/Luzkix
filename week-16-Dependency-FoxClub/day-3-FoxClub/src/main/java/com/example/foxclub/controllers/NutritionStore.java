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
public class NutritionStore {
  private FoxService foxService;

  @Autowired
  public NutritionStore (FoxService foxService) {
    this.foxService = foxService;
  }

  @GetMapping("/nutrition")
  public String nutritionPage (Model model) {
    String loggedUser = MainController.getLoggedUser();
    Fox fox = foxService.getFoxByName(loggedUser);
    if (loggedUser.isEmpty()) {
      model.addAttribute("successfulSign", false);
      return "nutritionStore";
    } else {
      List<String> foodToSelect = Arrays.stream(Configurations.Food.values())
          .map(a -> a.toString())
          .filter(a -> !a.equals(fox.getFood()))
          .collect(Collectors.toList());
      List<String> drinksToSelect = Arrays.stream(Configurations.Drinks.values())
          .map(a -> a.toString())
          .filter(a -> !a.equals(fox.getDrink()))
          .collect(Collectors.toList());

      model.addAttribute("name", loggedUser.toUpperCase());
      model.addAttribute("foxFood", fox.getFood().isEmpty()? "nothing":fox.getFood().toLowerCase());
      model.addAttribute("foxDrink", fox.getDrink().isEmpty()? "nothing":fox.getDrink().toLowerCase());
      model.addAttribute("successfulSign", true);
      model.addAttribute("favouriteFood", foodToSelect);
      model.addAttribute("favouriteDrink", drinksToSelect);

      return "nutritionStore";
    }
  }

  @PostMapping("/nutrition")
  public String setNutritions (@RequestParam String foodString, @RequestParam String drinkString) {
    String loggedUser = MainController.getLoggedUser();
    Fox fox = foxService.getFoxByName(loggedUser);
    if(!foodString.equals(fox.getFood())){
      String log = loggedUser + " no longer eats " + fox.getFood().toLowerCase() + ", instead started eating " + foodString.toLowerCase();
      foxService.addHistory(loggedUser,log);
    }
    if(!drinkString.equals(fox.getDrink())){
      String log = loggedUser + " no longer drinks " + fox.getDrink().toLowerCase() + ", instead started drinking " + drinkString.toLowerCase();
      foxService.addHistory(loggedUser,log);
    }

    fox.setFood(foodString);
    fox.setDrink(drinkString);
    return "redirect:/";
  }
}
