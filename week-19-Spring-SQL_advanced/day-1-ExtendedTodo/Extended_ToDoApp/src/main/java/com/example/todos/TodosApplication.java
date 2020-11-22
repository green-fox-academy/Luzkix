package com.example.todos;

import com.example.todos.models.Todo;
import com.example.todos.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodosApplication implements CommandLineRunner {

  private TodoRepository repo;
  @Autowired
  public TodosApplication (TodoRepository repo) {
    this.repo = repo;
  }


  public static void main(String[] args) {
    SpringApplication.run(TodosApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {
/*    repo.save(new Todo("I have to learn Object Relational Mapping"));
    repo.save(new Todo("I have to piss"));
    repo.save(new Todo("I have to shit"));*/
  }
}
