package com.example.frontend.controllers;

import com.example.frontend.models.AppendA;
import com.example.frontend.models.DoubleObject;
import com.example.frontend.models.Greeter;
import com.example.frontend.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  private MainService mainService;

  @Autowired
  public MainController(MainService mainService) {
    this.mainService = mainService;
  }

  @GetMapping("/")
  String homepage() {
    return "index";
  }

  //Var1
  @ResponseBody
  @GetMapping("/doubling")
  ResponseEntity<DoubleObject> doubling(@RequestParam(required = false) Integer input) {
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

  @ResponseBody
  @GetMapping("/greeter")
  ResponseEntity<Greeter> greeter(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String title) {
/*    //Variant1 - using only one service method
    Greeter greeter = new Greeter();
    Greeter greeterResponse = mainService.greetingV1(name, title, greeter);
    if (greeterResponse != null) {
      return ResponseEntity.ok().body(greeterResponse);
    } else return ResponseEntity.status(400).body(greeter);*/

    //Variant2 - using 2 sercvice methods (just to differentiate status codes):
    //  - checker method + return object method
    Greeter greeter = mainService.greetingV2(name, title);
    if (mainService.greetingNotNull(name, title)) {
      return ResponseEntity.ok().body(greeter);
    } else {
      return ResponseEntity.status(400).body(greeter);
    }
  }

  @ResponseBody
  @GetMapping("/appenda/{appendable}")
  ResponseEntity<AppendA> appendA(@PathVariable(required = false) String appendable) {

    if (appendable == null) {
      return ResponseEntity.status(400).build();
    }

    AppendA appended = mainService.appendA(appendable);
    return ResponseEntity.ok().body(appended);
  }


}

