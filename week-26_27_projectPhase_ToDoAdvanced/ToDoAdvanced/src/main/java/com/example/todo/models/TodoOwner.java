package com.example.todo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class TodoOwner {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;
  private String userName;
  private String password;
  @OneToMany(mappedBy = "owner")
  @JsonIgnore
  private List<Todo> todos;

  public TodoOwner(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }
}
