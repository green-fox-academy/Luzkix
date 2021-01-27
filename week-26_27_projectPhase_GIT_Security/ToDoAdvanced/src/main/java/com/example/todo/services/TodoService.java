package com.example.todo.services;

import com.example.todo.models.Todo;
import com.example.todo.models.dto.ErrorDTO;
import com.example.todo.models.dto.FilteredTodosResponseDTO;
import com.example.todo.models.dto.FilterTodoDTO;
import com.example.todo.models.dto.UpdateTodoDTO;

public interface TodoService {

  ErrorDTO setError(String error);

  Todo createTodo(Todo input, String token);

  FilteredTodosResponseDTO filterTodos(FilterTodoDTO filter) throws NullPointerException, NoMatchingResultException;

  Todo updateTodo(UpdateTodoDTO updatedTodoData, String token) throws NullPointerException,
      NoMatchingResultException, NoMatchingOwnerException;
}
