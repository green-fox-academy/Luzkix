package com.example.foxclub.configurations;

import org.springframework.stereotype.Component;

@Component
public class Configurations {
  private static String foxesSaveFile = "src/main/resources/static/files/savedData/foxes.txt";
  private static String tricksSaveFile = "src/main/resources/static/files/savedData/tricks.txt";
  private static String historySaveFile = "src/main/resources/static/files/savedData/history.txt";
  private static int maxNumberOfRandomTricks = 4;

  public enum Drinks {WATER, JUICE, COLA, FANTA, SPRITE, TONIC, NONALCOHOLIC, ALCOHOLIC, LIQUID}
  public enum Food {PIZZA, PASTA, STEAK, CHICKEN, SOUP, SOUVLAKI, POTATOES, DOG}
  public enum Tricks {JAVA, HTML, SPRINGBOOT, GITHUB, CSS, SQL, WATCHTV}

  public static String getFoxesSaveFile() {
    return foxesSaveFile;
  }
  public static String getTricksSaveFile() {
    return tricksSaveFile;
  }
  public static String getHistorySaveFile() {
    return historySaveFile;
  }

  public static int getMaxNumberOfRandomTricks() {
    return maxNumberOfRandomTricks;
  }

}
