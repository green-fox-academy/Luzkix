package com.greenfoxacademy.springstart.controllers;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FizzBuzzController {
  AtomicLong atomicLong = new AtomicLong();

  @GetMapping(value = "/fizz")
  public String greeting(Model model, @RequestParam String name) {
    atomicLong.incrementAndGet();
    String counter = "";
    if(atomicLong.get() % 3 == 0 && atomicLong.get() % 5 == 0 && atomicLong.get() % 7 == 0) {
      counter += "<span style = 'color:red;font-size:72px'>FizzBuzzWoof</span>";
    } else if (atomicLong.get() % 3 == 0 && atomicLong.get() % 5 == 0) {
      counter += "<span style = 'color:blue;font-size:48px'>FizzBuzz</span>";
    } else if (atomicLong.get() % 3 == 0 && atomicLong.get() % 7 == 0) {
      counter += "<span style = 'color:blue;font-size:48px'>FizzWoof</span>";
    } else if (atomicLong.get() % 5 == 0 && atomicLong.get() % 7 == 0) {
      counter += "<span style = 'color:blue;font-size:48px'>BuzzWoof</span>";
    } else if (atomicLong.get() % 3 == 0) {
      counter += "<span style = 'color:green;font-size:24px'>Fizz</span>";
    } else if (atomicLong.get() % 5 == 0) {
      counter += "<span style = 'color:green;font-size:24px'>Buzz</span>";
    } else if (atomicLong.get() % 7 == 0) {
      counter += "<span style = 'color:green;font-size:24px'>Woof</span>";
    } else {
      counter += atomicLong.get();
    }

    model.addAttribute("name", name);
    model.addAttribute("counter", counter);
    return "fizzBuzz";
  }
}
