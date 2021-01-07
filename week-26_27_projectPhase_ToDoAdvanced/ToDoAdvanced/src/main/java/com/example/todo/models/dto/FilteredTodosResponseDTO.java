package com.example.todo.models.dto;

import com.example.todo.models.Todo;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FilteredTodosResponseDTO {
  private List<Todo>filteredTodos;
}
