package com.example.webshop.controllers;

import com.example.webshop.models.ShopItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShopItemController {
  private final List<ShopItem> items = new ArrayList<>();
  public static String selectedCurrency = "CZK";

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

  @GetMapping("/euro")
  public String pricesToEur(Model model) {
    selectedCurrency = "EUR";
    model.addAttribute("items", items);
    return "index";
  }

  @GetMapping("/original-currency")
  public String pricesToCZK(Model model) {
    selectedCurrency = "CZK";
    model.addAttribute("items", items);
    return "index";
  }

  @GetMapping("/only-available")
  public String showOnlyAvailable(Model model) {
    List<ShopItem> filteredItems= items.stream()
        .filter(item -> item.getQuantityOfStock() > 0)
        .collect(Collectors.toList());

    model.addAttribute("items", filteredItems);
    return "index";
  }

  @GetMapping("/cheapest-first")
  public String cheapestFirst(Model model) {
    Comparator<ShopItem> cheapestFirst = Comparator.comparing(item -> item.getPrice());

    List<ShopItem> orderedItems= items.stream()
        .sorted(cheapestFirst)
        .collect(Collectors.toList());

    model.addAttribute("items", orderedItems);
    return "index";
  }

  @GetMapping("/contains-nike")
  public String containsNike(Model model) {
    List<ShopItem> containsNike= items.stream()
        .filter(item -> item.getDescription().toLowerCase().contains("nike"))
        .collect(Collectors.toList());

    model.addAttribute("items", containsNike);
    return "index";
  }

  @GetMapping("/average-stock")
  public String averageStock(Model model) {
    double averageStock = items.stream()
        .mapToDouble(ShopItem::getQuantityOfStock)
        .average()
        .getAsDouble();

    String sentence = "Average stock: " + String.format("%.1f", averageStock);
    model.addAttribute("sentence", sentence);
    return "average-expensive-stock";
  }

  @GetMapping("/most-expensive")
  public String mostExpensiveStock(Model model) {
    Comparator<ShopItem> cheapestFirst = Comparator.comparing(item -> item.getPrice());

    List<ShopItem> orderedItems= items.stream()
        .sorted(cheapestFirst.reversed())
        .collect(Collectors.toList());

    String sentence = "Most expensive stock: " + orderedItems.get(0).getName();
    model.addAttribute("sentence", sentence);
    return "average-expensive-stock";
  }

  @PostMapping("/search")
  public String mostExpensiveStock(@RequestParam String searchString, Model model) {
     List<ShopItem> filteredItems = items.stream()
        .filter(a -> a.getName().toLowerCase().contains(searchString.toLowerCase())
            || a.getDescription().toLowerCase().contains(searchString.toLowerCase()))
        .collect(Collectors.toList());

    model.addAttribute("items", filteredItems);
    return "index";
  }
}
