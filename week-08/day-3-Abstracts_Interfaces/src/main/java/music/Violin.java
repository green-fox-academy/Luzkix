package main.java.music;

public class Violin extends StringedInstrument{
  protected String sound;

  public Violin() {
    this.numberOfStrings = 4;
    this.name = "Violin";
    this.sound = "Screech";
  }

  public Violin (int strings) {
    this.numberOfStrings = strings;
    this.name = "Violin";
    this.sound = "Screech";
  }

  @Override
  void sound() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}