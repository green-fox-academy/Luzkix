package com.example.todos.controllers;

import com.example.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todo")
public class TodoController {
  private TodoRepository repository;
  @Autowired
  public TodoController (TodoRepository repository) {
    this.repository = repository;
  }


  @GetMapping({ "/", "/list" })
  public String list(Model model) {

    model.addAttribute("todos", repository.findAll());

  return "todos";
  }

}
