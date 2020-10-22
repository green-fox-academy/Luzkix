package com.example.webshop.models;

import com.example.webshop.controllers.ShopItemController;

public class ShopItem {
  private String name;
  private String type;
  private String description;
  private float price;
  private int quantityOfStock;

  public ShopItem (){
  }

  public ShopItem(String name, String type, String description, float price, int quantityOfStock) {
    this.name = name;
    this.type = type;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getDescription() {
    return description;
  }

  public float getPrice() {
    return price;
  }

  public int getQuantityOfStock() {
    return quantityOfStock;
  }

  public String getPriceInSelectedCurrency () {
    if (ShopItemController.selectedCurrency.equals("CZK")) {
      return String.format("%.0f", price) + " Kč";
    } else if (ShopItemController.selectedCurrency.equals("EUR")) {
      return String.format("%.1f", price*CurrencyExchangeRate.eur)  + " €";
    } else return price + " Kč";
  }
}

