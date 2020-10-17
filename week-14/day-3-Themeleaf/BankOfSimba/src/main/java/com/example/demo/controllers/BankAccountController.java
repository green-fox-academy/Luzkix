package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BankAccountController {
  List<BankAccount> accounts = new ArrayList<>();

  public BankAccountController () {
    accounts.add(new BankAccount("Pavla", 1500, "monkey", false, false));
    accounts.add(new BankAccount("Petra", 2000, "bird", false, true));
    accounts.add(new BankAccount("Petr", 2500, "fish", false, false));
    accounts.add(new BankAccount("Zdenek", 1000, "lion", true, false));
    accounts.add(new BankAccount("Janca", 3000, "snake", false, true));
  }

  @GetMapping("/showOne")
  public String showOneAccount (Model model) {
    BankAccount bankAccount = new BankAccount("Simba", 2000, "lion", true, false);
    model.addAttribute("name", bankAccount.getName());
    model.addAttribute("balance", bankAccount.getBalance());
    model.addAttribute("animalType", bankAccount.getAnimalType());
    return "showOneAccount";
  }

  @GetMapping("/accounts")
  public String showAllAccounts(Model model) {

    model.addAttribute("accounts", accounts);
    return "allAccounts";
  }

  @GetMapping("/utext")
  public String utextDemo (Model model) {
    model.addAttribute("utextDemo", "This is an <em>HTML</em> text. <b>Enjoy yourself!</b>");
    return "utext";
  }

  @PostMapping("/addMoney")
  public String addMoney (@RequestParam String name) {
    for(BankAccount account: accounts) {
      if (account.getName().toLowerCase().equals(name.toLowerCase())) {
        if (account.getIsKing()) {
          account.increaseBalance(100);
        } else {
          account.increaseBalance(10);
        }
      }
    }
    return "redirect:/accounts";
  }

}
