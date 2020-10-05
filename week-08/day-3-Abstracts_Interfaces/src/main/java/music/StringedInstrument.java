package main.java.music;

public abstract class StringedInstrument extends Instrument {
  protected int numberOfStrings;

  public void play () {
    sound();
  }

  abstract void sound ();
}
