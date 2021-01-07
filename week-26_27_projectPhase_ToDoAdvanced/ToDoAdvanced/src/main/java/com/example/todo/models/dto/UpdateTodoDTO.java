package com.example.todo.models.dto;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateTodoDTO {
  private Long id;
  private String title;
  private String content;
  private Boolean urgent;
  private LocalDate dueDate;
  private Boolean completed;
  private LocalDate completitionDate;
  private Long ownerId;
}
