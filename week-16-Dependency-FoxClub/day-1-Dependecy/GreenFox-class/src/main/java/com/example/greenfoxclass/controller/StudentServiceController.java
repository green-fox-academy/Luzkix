package com.example.greenfoxclass.controller;

import com.example.greenfoxclass.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
