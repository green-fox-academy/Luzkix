package com.example.todo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestUserRolesController {
  @GetMapping("admin/get")
  public String getAdmin(){
    return "Hi Admin";
  }

  @GetMapping("user/get")
  public String getUser() {
    return "Hi user";
  }
}
