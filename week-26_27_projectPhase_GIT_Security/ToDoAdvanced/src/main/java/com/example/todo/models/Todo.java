package com.example.todo.models;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private LocalDate creationDate;
  private String title;
  private String content;
  private Boolean urgent;
  private LocalDate dueDate;
  private Boolean completed;
  private LocalDate completitionDate;
  @ManyToOne
  @JoinColumn
  private TodoOwner owner;

  public Todo(String title, String content, Boolean urgent, LocalDate dueDate, TodoOwner owner) {
    this.creationDate = LocalDate.now();//strange is that readout object from jason has always this field null like it was not using constructor
    this.title = title;
    this.content = content;
    if (urgent == null) {
      this.urgent = false;
    } else this.urgent = urgent;
    this.dueDate=dueDate;
    this.owner = owner;

    this.completed = false;
    this.completitionDate = null;
  }
}
