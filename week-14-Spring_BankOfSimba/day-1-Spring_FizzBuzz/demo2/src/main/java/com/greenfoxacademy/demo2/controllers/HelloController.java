package com.greenfoxacademy.demo2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

  @ResponseBody
  @GetMapping("/hello")
  public String hello(@RequestParam int page, @RequestParam (required = false) String name) {
    return "Hello, " + name + ". Page: " + page;
  }

  @ResponseBody
  @PostMapping("/hello")
  public String helloPost() {
    return "hello world";
  }

  @GetMapping("/hello-from-html")
  public String helloFromHtml(Model model) {
    String name = "Zdenek";
    model.addAttribute("user", name);
    return "hello";
  }
}
