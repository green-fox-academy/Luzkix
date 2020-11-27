package com.example.frontend.controllers;

import com.example.frontend.models.DoubleObject;
import com.example.frontend.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  private MainService mainService;
  @Autowired
  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping ("/")
  String homepage(){
    return "index";
  }

  //Var1
  @ResponseBody
  @GetMapping ("/doubling")
    ResponseEntity<DoubleObject> doubling(@RequestParam(required = false)Integer input){
    DoubleObject doubled = mainService.doubleValueV1(input);
    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    return ResponseEntity.ok().headers(headers).body(doubled);
  }

  //Var2
  /*@ResponseBody
  @GetMapping ("/doubling")
  ResponseEntity<?> doubling(@RequestParam(required = false)Integer input){
    DoubleObject doubled = mainService.doubleValueV2(input);

    HttpHeaders headers = new HttpHeaders();
    headers.add("Content-Type", "application/json");
    headers.add("doublingAPI", "doubling input!!!");

    if(doubled == null){
      return ResponseEntity.ok().headers(headers).body(mainService.doubleError());
    } else {
      return ResponseEntity.ok().headers(headers).body(doubled);
    }
  }*/

}

