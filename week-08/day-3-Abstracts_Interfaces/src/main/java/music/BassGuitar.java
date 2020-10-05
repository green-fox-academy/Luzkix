package main.java.music;

public class BassGuitar extends StringedInstrument{
  protected String sound;

  public BassGuitar() {
    this.numberOfStrings = 4;
    this.name = "Bass Guitar";
    this.sound = "Duum-duum-duum";
  }

  public BassGuitar (int strings) {
    this.numberOfStrings = strings;
    this.name = "Bass Guitar";
    this.sound = "Duum-duum-duum";
  }

  @Override
  void sound() {
    System.out.println(name + ", a " + numberOfStrings + "-stringed instrument that goes " + sound);
  }
}