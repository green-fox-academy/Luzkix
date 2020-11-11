package com.example.todos.controllers;

import com.example.todos.models.Todo;
import com.example.todos.repositories.TodoRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
//@RequestMapping("/todo")
public class TodoController {
  private TodoRepository repository;
  @Autowired
  public TodoController (TodoRepository repository) {
    this.repository = repository;
  }


  @GetMapping({ "/", "/list" })
  public String list(@RequestParam(value = "isActive", required = false) Boolean isActive, Model model) {
    if(isActive == null) {
      model.addAttribute("todos", repository.findAll());
    } else if (isActive) {
      model.addAttribute("todos", repository.findAll().stream().filter(task-> !task.isDone()).collect(Collectors.toList()));
    } else if (!isActive) {
      model.addAttribute("todos", repository.findAll().stream().filter(task-> task.isDone()).collect(Collectors.toList()));
    } else {
    }
  return "todos";
  }

  @GetMapping("/addTask")
  public String addTaskForm(Model model){
    model.addAttribute("newTask", new Todo());
    return "addTask";
  }

  @PostMapping("/addTask")
  public String addTaskSubmit(@ModelAttribute Todo newTask, Model model){
    repository.save(newTask);
    return "redirect:/";
  }

}