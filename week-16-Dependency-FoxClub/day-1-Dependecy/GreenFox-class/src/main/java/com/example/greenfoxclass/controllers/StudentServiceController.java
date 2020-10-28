package com.example.greenfoxclass.controllers;

import com.example.greenfoxclass.services.StudentService;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentServiceController {
  @Autowired
  StudentService studentService;


  @GetMapping("/gfa")
  public String mainPage(Model model){
    model.addAttribute("counter", studentService.count());
    return "gfa";
  }

  @GetMapping("/gfa/list")
  public String listAllStudents(Model model){
    model.addAttribute("students", studentService.findAll());
    return "gfa_list";
  }

  @GetMapping("/gfa/add")
  public String addNewStudent() {
    return "gfa_add";
  }

  @PostMapping("/gfa/add")
  public String addNewStudent(Model model, @RequestParam String name) {
    studentService.save(name);
    model.addAttribute("studentConfirmation", "Student <strong>'" + name
        + "'</strong> was successfully added to the database!");
    model.addAttribute("checkStudDTB", "You can also check the students database...");
    return "gfa_add";
  }

  @GetMapping("/gfa/check")
  public String checkStudent() {
    return "gfa_check";
  }

  @PostMapping("/gfa/check")
  public String checkStudent(Model model, @RequestParam String name) {
    if(studentService.findAll().stream()
        .map(a -> a.toLowerCase())
        .collect(Collectors.toList())
        .contains(name.toLowerCase())) {
      model.addAttribute("studentCheck", "Student <strong>'" + name
          + "' IS </strong> already in the database!");
    } else {
      model.addAttribute("studentCheck", "Student <strong>'" + name
          + "'</strong> is <strong> NOT </strong> in the database!");
    }
    model.addAttribute("checkStudDTB", "You can also check the students database...");
    return "gfa_check";
  }
}
