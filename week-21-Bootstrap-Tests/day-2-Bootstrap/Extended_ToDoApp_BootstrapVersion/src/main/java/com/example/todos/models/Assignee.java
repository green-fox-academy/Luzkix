package com.example.todos.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Assignee implements Comparable<Assignee>{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String email;

  @OneToMany(mappedBy = "assignee")
  private List<Todo> todos;

  //public Assignee(){}


  @Override
  public int compareTo(Assignee other) {
    return (int)(id - other.getId());
  }

  @Override
  public String toString() {
    return this.name;
  }
}
