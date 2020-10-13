package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRESTController {
  AtomicLong atomicLong = new AtomicLong();

  @GetMapping ({"/greeting", "/ahoj"}) //mohu zadat více linků
  public Greeting greeting (@RequestParam String name) {
    return new Greeting(atomicLong.incrementAndGet(),"Hello, " + name);
  }

}
