package com.example.foxclub.controllers;

import com.example.foxclub.services.FoxService;
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


  public static void setCheckedName(String nameToCheck) {
    checkedName = nameToCheck;
  }

  @GetMapping("/")
  public String basePage(Model model) {
    if (loggedUser.isEmpty()) {
      return "index_notLogged";
    } else {
      model.addAttribute("foxName",
          "<strong style='color: red'>" + loggedUser.toUpperCase() + "</strong>");
      return "redirect:/index";
    }
  }

  @GetMapping("/index")
  public String indexPage(Model model) {
    if (loggedUser.isEmpty()) {
      return "index_notLogged";
    } else {
      model.addAttribute("foxName",
          "<strong style='color: red'>" + loggedUser.toUpperCase() + "</strong>");
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
      model.addAttribute("existingUser", "The name you have provided - <strong>" + name
          + "</strong> - is already taken as a name: <strong>" + checkedName + "</strong>. Please try a new one.");
      return "signup";
    } else {
      foxService.addFox(name);
      loggedUser=name;
      return "redirect:/";
    }
  }

  @GetMapping("/logout")
  public String logOut() {
    loggedUser="";
    return "redirect:/";
  }

  @GetMapping("/save")
  public String saveProgress(Model model) {
    foxService.saveAllFoxes();
    return "save";
  }

  @GetMapping("/delete")
  public String deleteFox() {
    return "delete";
  }

  @GetMapping("/deleteConfirm")
  public String deleteFox(Model model) {
    foxService.deleteFox(loggedUser);
    loggedUser="";
    model.addAttribute("delete",true);
    return "delete";
  }
}
