package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankAccountController {

  @GetMapping("/show")
  public String showOneAccount (Model model) {
    BankAccount bankAccount = new BankAccount("Simba", 2000, "lion");
    model.addAttribute("name", bankAccount.getName());
    model.addAttribute("balance", bankAccount.getBalance());
    model.addAttribute("animalType", bankAccount.getAnimalType());
    return "showOneAccount";
  }

  @GetMapping("/showMultiple")
  public String showMultipleAccounts (Model model) {
    List<BankAccount> accounts = new ArrayList<>();
    accounts.add(new BankAccount("Bamba", 1000, "lion"));
    accounts.add(new BankAccount("Samba", 1500, "monkey"));
    accounts.add(new BankAccount("Rumba", 2000, "bird"));
    accounts.add(new BankAccount("Lamba", 2500, "fish"));
    accounts.add(new BankAccount("Mamba", 3000, "snake"));

    model.addAttribute("accounts", accounts);
    return "showMultipleAccounts";
  }


  @GetMapping("/utext")
  public String utextDemo (Model model) {
    model.addAttribute("utextDemo", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "utext";
  }

}
