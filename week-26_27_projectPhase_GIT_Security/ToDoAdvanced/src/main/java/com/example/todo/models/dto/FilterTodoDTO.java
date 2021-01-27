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
public class FilterTodoDTO {
  private String method;
  private String filterBy;
  private String filterOperation;
  private Long id;
  private String title;
  private Boolean urgent;
  private Boolean completed;
  private LocalDate dueDate;
  private String userName;
}
