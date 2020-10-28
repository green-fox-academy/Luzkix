package com.example.greenfoxclass.controller;

import com.example.greenfoxclass.service.StudentService;
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
  public String mainPage(){
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
    model.addAttribute("studentConfirmation", "Student <strong>'" + name + "'</strong> was successfully added to the database!");
    model.addAttribute("checkStudDTB", "You can also check the students database...");
    return "gfa_add";
  }
}
