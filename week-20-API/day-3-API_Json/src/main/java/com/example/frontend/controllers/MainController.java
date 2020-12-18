package com.example.frontend.controllers;

import com.example.frontend.models.AppendA;
import com.example.frontend.models.ArrayHandler;
import com.example.frontend.models.ArrayHandlerResult;
import com.example.frontend.models.DoUntil;
import com.example.frontend.models.DoUntilResult;
import com.example.frontend.models.DoubleObject;
import com.example.frontend.models.ErrorObject;
import com.example.frontend.models.Greeter;
import com.example.frontend.models.LogEntry;
import com.example.frontend.models.LogEntryOutput;
import com.example.frontend.repository.LogRepository;
import com.example.frontend.services.MainService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  private MainService mainService;
  private LogRepository logRepository;

  @Autowired
  public MainController(MainService mainService, LogRepository logRepository) {
    this.mainService = mainService;
    this.logRepository=logRepository;
  }

  @GetMapping("/")
  String homepage() {
    return "index";
  }

  //Var1
  @ResponseBody
  @GetMapping("/doubling")
  ResponseEntity<DoubleObject> doubling(@RequestParam(required = false) Integer input) {
    LogEntry logEntry = new LogEntry("/doubling", "input="+input);
    logRepository.save(logEntry);

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

    LogEntry logEntry = new LogEntry("/doubling", "input="+input);
    logRepository.save(logEntry);

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
    LogEntry logEntry = new LogEntry("/greeter", "name="+name+"&title="+title);
    logRepository.save(logEntry);

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
    LogEntry logEntry = new LogEntry("/appenda/"+appendable, "");
    logRepository.save(logEntry);

    if (appendable == null) {
      return ResponseEntity.status(400).build();
    }

    AppendA appended = mainService.appendA(appendable);
    return ResponseEntity.ok().body(appended);
  }

  @ResponseBody
  @PostMapping ("/dountil/{action}")
  ResponseEntity<?> doUntil(@PathVariable(required = false) String action, @RequestBody (required = false) DoUntil input) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonText;
    try {
      jsonText = mapper.writeValueAsString(input);
    } catch (JsonProcessingException e) {
      jsonText = "null json object";
    }

    LogEntry logEntry = new LogEntry("/dountil/"+action, jsonText);
    logRepository.save(logEntry);

    try {
      DoUntilResult result = mainService.doUntilResult(action, input);
      return ResponseEntity.ok().body(result);
    }catch (NullPointerException e) {
      ErrorObject error = mainService.setError("Please provide a number!");
      return ResponseEntity.status(400).body(error);
    }
    /*DoUntilResult result = mainService.doUntilResult(action, input);

    if (action == null || input.getUntil() == null || result == null) {
      ErrorObject error = mainService.setError("Please provide a number!");
      return ResponseEntity.status(400).body(error);
    }
    return ResponseEntity.ok().body(result);*/
  }

  @ResponseBody
  @PostMapping ("/arrays")
  ResponseEntity<?> arrayHandler(@RequestBody(required = false) ArrayHandler input) {
    ObjectMapper mapper = new ObjectMapper();
    String jsonText;
    try {
      jsonText = mapper.writeValueAsString(input);
    } catch (JsonProcessingException e) {
      jsonText = "null json object";
    }

    LogEntry logEntry = new LogEntry("/arrays", jsonText);
    logRepository.save(logEntry);

    try {
      ArrayHandlerResult result = mainService.arrayResult(input);
      return ResponseEntity.ok().body(result);
    } catch (NullPointerException e) {
      ErrorObject error = mainService.setError("Please provide what to do with the numbers!");
      return ResponseEntity.status(400).body(error);
    }


    /*if (input == null || result == null) {
      ErrorObject error = mainService.setError("Please provide what to do with the numbers!");
      return ResponseEntity.status(400).body(error);
    } else return ResponseEntity.ok().body(result);*/
  }

  @ResponseBody
  @GetMapping("/log")
  ResponseEntity<?> getLogs(@RequestParam(required = false) Integer count, @RequestParam(required = false) Integer page) {


    List<LogEntry> logs = logRepository.findAll();
    List<LogEntry> logsFiltered = new ArrayList<>();

    if(logs.isEmpty() || logs == null) {
      ErrorObject error=mainService.setError("No logs yet");
      return ResponseEntity.status(400).body(error);
    } else if (count == null && page == null){
      LogEntryOutput output = new LogEntryOutput();
      output.setEntries(logs);
      output.setEntry_count(logs.size());
      return ResponseEntity.ok().body(output);
    } else if (page != null && page > 0) {
      if (logs.size() < 10) {
        logsFiltered = logs;
      }else if(page*10 <= logs.size()) {
        for(int i = page*10 - 10; i < page*10; i++) {
          logsFiltered.add(logs.get(i));
        }
      } else {
        for (int i = logs.size()-logs.size()%10; i < logs.size(); i++) {
          logsFiltered.add(logs.get(i));
        }
      }
      LogEntryOutput output = new LogEntryOutput();
      output.setEntries(logsFiltered);
      output.setEntry_count(logs.size());
      return ResponseEntity.ok().body(output);
    } else if (count != null && count > 0) {
      if (count >= logs.size()) {
        logsFiltered = logs;
      } else {
        for (int i = logs.size()-1; i > logs.size() - count-1; i--) {
          logsFiltered.add(logs.get(i));
        }
      }
      LogEntryOutput output = new LogEntryOutput();
      output.setEntries(logsFiltered);
      output.setEntry_count(logs.size());
      return ResponseEntity.ok().body(output);
    } else {
      ErrorObject error=mainService.setError("Unknown error, probably wrong parameters defined");
      return ResponseEntity.status(400).body(error);
    }
  }





}

