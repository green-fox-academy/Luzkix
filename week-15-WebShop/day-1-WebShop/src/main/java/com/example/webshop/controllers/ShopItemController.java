package com.example.webshop.controllers;

import com.example.webshop.models.ShopItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopItemController {
  private final List<ShopItem> items = new ArrayList<>();

  ShopItemController () {
    items.addAll(Arrays.asList(new ShopItem("Running shoes","Nike running shoes for every day sport",1000f,5),
        new ShopItem("Printer","Some HP printer that will print pages",3000f,2),
        new ShopItem("Coca cola","0.5l standard coke",25f,0),
        new ShopItem("Wokin","Chicken with fried rice and WOKIN sauce",119f,100),
        new ShopItem("T-shirt","Blue with a corgi on a bike",300f,1)
    ));
  }

  @GetMapping("/index")
  public String showAllItems(Model model) {
    model.addAttribute("items", items);
    return "index";
  }

}
