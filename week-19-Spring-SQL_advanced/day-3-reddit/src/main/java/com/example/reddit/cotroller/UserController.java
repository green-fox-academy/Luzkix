package com.example.reddit.cotroller;

import com.example.reddit.model.User;
import com.example.reddit.service.UserService;
import com.example.reddit.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

  private UserService userService;
  private VoteService voteService;
  @Autowired
  public UserController(UserService userService, VoteService voteService) {
    this.userService = userService;
    this.voteService = voteService;
  }

  @GetMapping ("/login")
  String loginPageForm (Model model) {
    model.addAttribute("wrongLogin", false);
    return "login";
  }

  @PostMapping("/login")
  String loginPageSubmit (@RequestParam String userEmail, @RequestParam String password ,Model model) {
    if(userService.tryToLogInTheUser(userEmail, password)){
      return "redirect:/";
    } else {
      model.addAttribute("wrongLogin", true);
      return "login";
    }
  }

  @GetMapping ("/signUp")
  String signUpPageForm (Model model) {
    model.addAttribute("wrongSignUp", false);
    return "signUp";
  }

  @PostMapping("/signUp")
  String signUpPageSubmit (@RequestParam String userName, @RequestParam String userEmail, @RequestParam String password ,Model model) {
    if(userService.tryAddNewUser(userName, userEmail, password)){
      return "redirect:/";
    } else {
      model.addAttribute("wrongSignUp", true);
      return "signUp";
    }
  }

  @GetMapping ("/logout")
  String logout () {
    userService.logout();
    return "login";
  }

  @GetMapping ("/account")
  String showAccountDetails (Model model) {
    if(userService.loggedUser() == null){
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("actualAccount", userService.loggedUser());
    return "account";
  }

  @GetMapping ("/editAccount")
  String editAccountDetails (Model model) {
    if(userService.loggedUser() == null){
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("actualAccount", userService.loggedUser());
    model.addAttribute("wrongEditAccount", false);
    return "editAccount";
  }

  @PostMapping ("/editAccount")
  String editedAccountDetailsSubmit (@ModelAttribute User updatedUser, Model model) {
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());

    if(userService.saveEditedAccountOfUser(updatedUser)){
      return "redirect:/";
    } else {
      model.addAttribute("loggedUser", userService.loggedUser().getUserName());
      model.addAttribute("actualAccount", userService.loggedUser());
      model.addAttribute("wrongEditAccount", true);
      return "editAccount";
    }
  }


}
