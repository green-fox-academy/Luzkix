package com.example.todos.controllers;

import com.example.todos.models.Todo;
import com.example.todos.repositories.TodoRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
  public String addTaskSubmit(@ModelAttribute Todo newTodo){
    repository.save(newTodo);
    return "redirect:/";
  }

  @GetMapping("/{id}/delete")
  public String deleteTask(@PathVariable long id, Model model) {
    repository.delete(repository.getOne(id));
    return "redirect:/";
  }

  @GetMapping("/{id}/edit")
  public String editTaskForm(@PathVariable long id, Model model) {
    model.addAttribute("editedTask", repository.getOne(id));
    return "editTask";
  }

  @PostMapping("/{id}/edit")
  public String editTaskSave(@ModelAttribute Todo updatedTodo, @PathVariable long id){
    updatedTodo.setId(id);
    repository.save(updatedTodo);
    return "redirect:/";
  }

  @PostMapping("/search")
  public String searchTodo(@RequestParam String search, Model model){

    model.addAttribute("todos", repository.findTodoByString(search));
    return "todos";
  }
}
