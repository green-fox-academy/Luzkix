package main.java.music;

public class ElectricGuitar extends StringedInstrument{
  protected String sound;

  public ElectricGuitar() {
    this.numberOfStrings = 6;
    this.name = "Electric Guitar";
    this.sound = "Twang";
  }

  public ElectricGuitar (int strings) {
    this.numberOfStrings = strings;
    this.name = "Electric Guitar";
    this.sound = "Twang";
  }

  @Override
  void sound() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}
