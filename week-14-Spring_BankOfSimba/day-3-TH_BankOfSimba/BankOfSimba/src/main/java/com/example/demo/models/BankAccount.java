package com.example.demo.models;

public class BankAccount {
  private String name;
  private int balance;
  private String animalType;
  private Boolean king;
  private Boolean badGuy;

  public BankAccount() {
  }

  public BankAccount(String name, int balance, String animalType, boolean king, boolean badGuy) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.king = king;
    this.badGuy = badGuy;
  }

  public void increaseBalance(int number) {
    balance += number;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public Boolean getKing() {
    return king;
  }

  public void setKing(Boolean king) {
    this.king = king;
  }

  public Boolean getBadGuy() {
    return badGuy;
  }

  public void setBadGuy(Boolean badGuy) {
    this.badGuy = badGuy;
  }
}

