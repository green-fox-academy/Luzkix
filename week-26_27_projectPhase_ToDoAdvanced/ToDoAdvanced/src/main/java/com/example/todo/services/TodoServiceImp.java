package com.example.todo.services;

import com.example.todo.models.Todo;
import com.example.todo.models.TodoOwner;
import com.example.todo.models.dto.ErrorDTO;
import com.example.todo.models.dto.FilterTodoDTO;
import com.example.todo.models.dto.FilteredTodosResponseDTO;
import com.example.todo.models.dto.UpdateTodoDTO;
import com.example.todo.repositories.TodoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImp implements TodoService {
  private TodoRepository todoRepository;
  private UserService userService;
  /*private UserRepository userRepository;*/

  @Autowired
  public TodoServiceImp(TodoRepository todoRepository,
                        UserService userService/*, UserRepository userRepository*/) {
    this.todoRepository = todoRepository;
    this.userService = userService;
    /*this.userRepository = userRepository;*/
  }

  @Override
  public ErrorDTO setError(String errorMessage) {
    ErrorDTO errorDTO = new ErrorDTO(errorMessage);
    return errorDTO;
  }

  @Override
  public Todo createTodo(Todo input) throws NullPointerException {
    if (input == null || input.getTitle() == null || input.getContent() == null) {
      throw new NullPointerException();
    }
    Todo newTodo =
        new Todo(input.getTitle(), input.getContent(), input.getUrgent(), input.getDueDate());
    todoRepository.save(newTodo);
    return newTodo;
  }

  @Override
  public FilteredTodosResponseDTO filterTodos(FilterTodoDTO filter)
      throws NullPointerException, NoMatchingResultException {
    if (filter.getMethod().equals("all")) {
      List<Todo> allTodos = todoRepository.findAll();
      FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(allTodos);
      return response;
    }
    if (filter.getMethod().equals("filter")) {
      if (filter.getFilterBy().equals("id")) {
        if (filter.getFilterOperation().equals("higher") && filter.getId() != null) {
          List<Todo> filteredTodos = todoRepository.findHigherThanId(filter.getId());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
        if (filter.getFilterOperation().equals("lower") && filter.getId() != null) {
          List<Todo> filteredTodos = todoRepository.findLowerThanId(filter.getId());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
        if (filter.getFilterOperation().equals("equals") && filter.getId() != null) {
          List<Todo> filteredTodos = todoRepository.findEqualAsId(filter.getId());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("title")) {
        if (filter.getTitle() != null) {
          List<Todo> filteredTodos = todoRepository.containsInTitle(filter.getTitle());
          if (filteredTodos.isEmpty()) {
            throw new NoMatchingResultException("No matching results were found");
          }
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("urgent")) {
        if (filter.getUrgent() == true) {
          List<Todo> filteredTodos = todoRepository.findByUrgentTrue();
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("urgent")) {
        if (filter.getUrgent() == false) {
          List<Todo> filteredTodos = todoRepository.findByUrgentFalse();
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("completed")) {
        if (filter.getCompleted() == true) {
          List<Todo> filteredTodos = todoRepository.findByCompletedTrue();
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("completed")) {
        if (filter.getCompleted() == false) {
          List<Todo> filteredTodos = todoRepository.findByCompletedFalse();
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("dueDate")) {
        if (filter.getFilterOperation().equals("higher") && filter.getDueDate() != null) {
          List<Todo> filteredTodos = todoRepository.findByDueDateGreaterThan(filter.getDueDate());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("dueDate")) {
        if (filter.getFilterOperation().equals("lower") && filter.getDueDate() != null) {
          List<Todo> filteredTodos = todoRepository.findByDueDateLessThan(filter.getDueDate());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("dueDate")) {
        if (filter.getFilterOperation().equals("equals") && filter.getDueDate() != null) {
          List<Todo> filteredTodos = todoRepository.findByDueDateEquals(filter.getDueDate());
          FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
          return response;
        }
      }
      if (filter.getFilterBy().equals("userName")) {
        if (filter.getUserName() != null) {
          TodoOwner owner = userService.findOwnerBasedOnUserName(filter.getUserName());
          if (owner == null) {
            throw new NoMatchingResultException("No matching results were found");
          } else {
            List<Todo> filteredTodos = owner.getTodos();
            FilteredTodosResponseDTO response = new FilteredTodosResponseDTO(filteredTodos);
            return response;
          }
        }
      }
      throw new NullPointerException();
    }
    throw new NullPointerException();
  }

  @Override
  public Todo updateTodo(UpdateTodoDTO input)
      throws NullPointerException, NoMatchingResultException {
    if (input == null || input.getId() == null) {
      throw new NullPointerException();
    }

    Todo updatedTodo = todoRepository.findById(input.getId()).orElse(null);

    if (updatedTodo == null) {
      throw new NoMatchingResultException("There is no ToDo with ID: " + input.getId());
    }
    if (input.getTitle() != null) {
      updatedTodo.setTitle(input.getTitle());
    }
    if (input.getContent() != null) {
      updatedTodo.setContent(input.getContent());
    }
    if (input.getUrgent() != null) {
      updatedTodo.setUrgent(input.getUrgent());
    }
    if (input.getDueDate() != null) {
      updatedTodo.setDueDate(input.getDueDate());
    }
    if (input.getCompleted() != null) {
      updatedTodo.setCompleted(input.getCompleted());
    }
    if (input.getCompletitionDate() != null) {
      updatedTodo.setCompletitionDate(input.getCompletitionDate());
    }
    if (input.getOwnerId() != null) {
      TodoOwner owner = userService.findOwnerById(input.getOwnerId());
      if (owner == null) {
        throw new NoMatchingResultException("There is no User with ID: " + input.getOwnerId());
      }
      updatedTodo.setOwner(owner);
    }

    todoRepository.save(updatedTodo);
    return updatedTodo;
  }
}
