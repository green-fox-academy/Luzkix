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
    items.addAll(Arrays.asList(
        new ShopItem("adidas", "running", "running shoes", 100, 10),
        new ShopItem("adidas", "lifestyle", "formula 1 jacket", 200, 11),
        new ShopItem("adidas", "basketball", "shirt", 300, 0),
        new ShopItem("adidas", "football", "shoes", 555, 14),
        new ShopItem("nike", "running", "shirt", 150, 15),
        new ShopItem("nike", "basketball", "shoes", 2020, 16),
        new ShopItem("nike", "lifestyle","shoes", 180, 0),
        new ShopItem("nike", "lifestyle","jacket", 1280, 7),
        new ShopItem("nike", "baseball", "jacket", 199, 6),
        new ShopItem("puma", "lifestyle","jacket", 228, 5),
        new ShopItem("puma", "football", "shirt", 315, 44),
        new ShopItem("oakley", "lifestyle","backpack", 404, 22),
        new ShopItem("oakley", "lifestyle","glasses", 379, 6),
        new ShopItem("adidas", "cycling", "glasses", 820, 8),
        new ShopItem("hugo boss", "lifestyle","jacket", 555, 0),
        new ShopItem("hugo boss","lifestyle", "trousers", 1150, 2),
        new ShopItem("puma", "running", "shoes", 555, 0),
        new ShopItem("adidas", "golf", "shirt", 580, 3)
    ));
  }

  @GetMapping("/index")
  public String showAllItems(Model model) {
    model.addAttribute("items", items);
    return "index";
  }

  @GetMapping("/index-extended")
  public String showExtendedMenu(Model model) {
    model.addAttribute("items", items);
    model.addAttribute("hideStandardMenu", true);
    model.addAttribute("hideSearchBar", true);
    return "index";
  }

  @GetMapping("/euro")
  public String pricesToEur(Model model) {
    selectedCurrency = "EUR";
    model.addAttribute("items", items);
    model.addAttribute("hideStandardMenu", true);
    model.addAttribute("hideSearchBar", true);
    return "index";
  }

  @GetMapping("/original-currency")
  public String pricesToCZK(Model model) {
    selectedCurrency = "CZK";
    model.addAttribute("items", items);
    model.addAttribute("hideStandardMenu", true);
    model.addAttribute("hideSearchBar", true);
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
        .filter(item -> item.getDescription().toLowerCase().contains("nike") ||
         item.getName().toLowerCase().contains("nike"))
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

    String sentence = "Average stock: " + String.format("%.1f", averageStock) + " pieces.";

    model.addAttribute("sentence", sentence);
    model.addAttribute("hideMainTable", true);
    model.addAttribute("showItemDetail", true);
    return "index";
  }

  @GetMapping("/most-expensive")
  public String mostExpensiveStock(Model model) {
    Comparator<ShopItem> cheapestFirst = Comparator.comparing(item -> item.getPrice());

    List<ShopItem> orderedItems= items.stream()
        .sorted(cheapestFirst.reversed())
        .collect(Collectors.toList());

    String sentence = "Most expensive item: " + orderedItems.get(0).getName() + ", "
        + orderedItems.get(0).getDescription() + ", " + orderedItems.get(0).getPriceInSelectedCurrency();

    model.addAttribute("sentence", sentence);
    model.addAttribute("hideMainTable", true);
    model.addAttribute("showItemDetail", true);
    return "index";
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

  @GetMapping("/filter-by-type/sport")
  public String filterTypeSport (Model model) {
    List<ShopItem> sport = items.stream()
        .filter(a -> a.getType().toLowerCase().contains("running") ||
                a.getType().toLowerCase().contains("basketball") ||
                a.getType().toLowerCase().contains("football") ||
                a.getType().toLowerCase().contains("baseball") ||
                a.getType().toLowerCase().contains("cycling") ||
                a.getType().toLowerCase().contains("golf"))
        .collect(Collectors.toList());
    model.addAttribute("items", sport);
    model.addAttribute("hideStandardMenu", true);
    model.addAttribute("hideSearchBar", true);
    return "index";
  }

  @GetMapping("/filter-by-type/lifestyle")
  public String filterTypeLifestyle (Model model) {
    List<ShopItem> lifestyle = items.stream()
        .filter(a -> a.getType().toLowerCase().contains("lifestyle"))
        .collect(Collectors.toList());
    model.addAttribute("items", lifestyle);
    model.addAttribute("hideStandardMenu", true);
    model.addAttribute("hideSearchBar", true);
    return "index";
  }


}
