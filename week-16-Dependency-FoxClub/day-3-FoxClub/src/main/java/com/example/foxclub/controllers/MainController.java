package com.example.foxclub.controllers;

import com.example.foxclub.configurations.Configurations;
import com.example.foxclub.models.Fox;
import com.example.foxclub.services.FoxService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
  private static String loggedUser = new String();
  private static String checkedName = new String();
  private FoxService foxService;

  @Autowired
  public MainController(FoxService foxService) {
    this.foxService = foxService;
  }

  public static String getLoggedUser() {
    return loggedUser;
  }

  public FoxService getFoxService() {
    return foxService;
  }

  public static void setCheckedName(String nameToCheck) {
    checkedName = nameToCheck;
  }

  @GetMapping("/")
  public String basePage(Model model) {
    if (loggedUser.isEmpty()) {
      return "index_notLogged";
    } else {
      return "redirect:/index";
    }
  }

  @GetMapping("/index")
  public String indexPage(Model model) {
    if (loggedUser.isEmpty()) {
      return "index_notLogged";
    } else {
      model.addAttribute("foxName", loggedUser);
      model.addAttribute("foxFood", foxService.getFoxByName(loggedUser).getFood());
      model.addAttribute("foxDrink", foxService.getFoxByName(loggedUser).getDrink());
      model.addAttribute("foxTrick", foxService.getFoxByName(loggedUser).getTricks().size());
      model.addAttribute("tricks",foxService.getFoxByName(loggedUser).getTricks());

      if (foxService.getFoxByName(loggedUser).getTricks().size() == 0){
        model.addAttribute("noKnownTricks", true);
      } else model.addAttribute("noKnownTricks", false);

      return "index";
    }
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }

  @PostMapping("/login")
  public String loginPage(@RequestParam String name, Model model) {
    if (foxService.checkFox(name)) {
      loggedUser = checkedName;
      return "redirect:index";
    } else {
      model.addAttribute("wrongUser", "The name you have provided - <strong>" + name
          + "</strong> - is not in our database!");
      model.addAttribute("wrongLogin", true);
      return "login";
    }
  }

  @GetMapping("/signup")
  public String signUpPage() {
    return "signup";
  }

  @PostMapping("/signup")
  public String signUpPage(@RequestParam String name, Model model) {
    if (foxService.checkFox(name)) {
      model.addAttribute("successfullSign", false);
      model.addAttribute("existingUser", "The name you have provided - <strong>" + name
          + "</strong> - is already taken as a name: <strong>" + checkedName + "</strong>. Please try a new one.");
      return "signup";
    } else {
      loggedUser=name;
      model.addAttribute("successfullSign", true);
      model.addAttribute("name", name);
      model.addAttribute("favouriteFood", Configurations.Food.values());
      model.addAttribute("favouriteDrink", Configurations.Drinks.values());
      //model.addAttribute("favouriteTrick", Configurations.Tricks.values());
      return "signup";
    }
  }

  @PostMapping("/signup2")
  public String signUpPage2(@RequestParam String foodString, @RequestParam String drinkString, Model model) {
    foxService.addFox(loggedUser,foodString, drinkString, Fox.getRandomTricks());

    return "redirect:/index";
  }



  @GetMapping("/logout")
  public String logOut() {
    loggedUser="";
    return "redirect:/index";
  }

  @GetMapping("/save")
  public String saveProgress() {
    foxService.saveAllFoxes();
    return "save";
  }

  @GetMapping("/delete")
  public String deleteFoxPage(Model model) {
    model.addAttribute("delete",false);
    if(!loggedUser.isEmpty()){
      model.addAttribute("name",loggedUser);
      model.addAttribute("loggedIn",true);
    }
    return "delete";
  }

  @PostMapping("/deleteConfirm")
  public String deleteFox(Model model) {
    foxService.deleteFox(loggedUser);
    loggedUser="";
    model.addAttribute("delete",true);
    return "delete";
  }
}
