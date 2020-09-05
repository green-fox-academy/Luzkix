package Comparable;

/**
 * Created by aze on 2017.03.29..
 */
public class Thing implements Comparable<Thing> {
  private String name;
  private boolean completed;

  public Thing(String name) {
    this.name = name;
  }

  public void complete() {
    this.completed = true;
  }

  @Override
  public String toString() {
    return (completed ? "[x] " : "[ ] ") + name;
  }

  @Override
  public int compareTo(Thing other) {
    if (this.completed && !other.completed) {
      if (this.name.charAt(0) < other.name.charAt(0)) {
        return -1;
      }
      if (this.name.charAt(0) == other.name.charAt(0)) {
        return 0;
      }
      return 1;
    }
    if (this.completed == other.completed) {
      if (this.name.charAt(0) < other.name.charAt(0)) {
        return -1;
      }
      if (this.name.charAt(0) == other.name.charAt(0)) {
        return 0;
      }
      return 0;
    } else return 1;
  }
}