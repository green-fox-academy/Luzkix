package com.example.demo.controllers;

public class BankAccount {
  private String name;
  private int balance;
  private String animalType;
  private boolean isKing;
  private boolean isBadGuy;

  public BankAccount(String name, int balance, String animalType, boolean isKing, boolean isBadGuy) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = isKing;
    this.isBadGuy = isBadGuy;
  }

  public void increaseBalance (int number) {
    balance += number;
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public Boolean getKing() {
    return isKing;
  }

  public boolean getIsKing() {
    return isKing;
  }

  public boolean getIsBadGuy() {
    return isBadGuy;
  }
}
