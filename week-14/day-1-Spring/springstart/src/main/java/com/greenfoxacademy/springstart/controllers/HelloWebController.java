package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWebController {
  AtomicLong atomicLong = new AtomicLong();

  @GetMapping(value = "/web/greeting")
  public String greeting(Model model, @RequestParam String name) {
    model.addAttribute("name", name);
    model.addAttribute("counter", atomicLong.incrementAndGet());
    return "greeting";
  }
}
