package com.example.todos.controllers;

import com.example.todos.models.Assignee;
import com.example.todos.repositories.AssigneeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping("/assignees")
public class AssigneeController {
  private AssigneeRepository assigneeRepo;

  @Autowired
  public AssigneeController(AssigneeRepository assigneeRepo) {
    this.assigneeRepo = assigneeRepo;
  }

  @GetMapping("/assignees")
  public String showAllAssigness (Model model) {
    List<Assignee> assignees = assigneeRepo.findAll();
    if (assignees.isEmpty()) {
      model.addAttribute("emptyList", true);
    } else {
      model.addAttribute("assignees", assignees);
    }
   //model.addAttribute("assignees", assigneeRepo.findAll());
    return "assignees";
  }

  @GetMapping ("/addAssignee")
  public String addAssigneeForm (Model model) {
    model.addAttribute("newAssignee", new Assignee());
    return "addAssignee";
  }

  @PostMapping("/addAssignee")
  public String addAssigneeSubmit (@ModelAttribute Assignee assignee) {
    for (Assignee a : assigneeRepo.findAll()) {
      if (a.getEmail().toLowerCase().equals(assignee.getEmail().toLowerCase())) {
        return "redirect:assignees/";}
    }
    assigneeRepo.save(assignee);
    return "redirect:assignees/";
  }

  @GetMapping ("/{id}/deleteAssignee")
  public String deleteAssignee (@PathVariable Long id) {
    assigneeRepo.deleteById(id);
    return "redirect:/assignees";
  }

  @GetMapping ("/{id}/editAssignee")
  public String editAssigneeForm (@PathVariable Long id, Model model) {
    model.addAttribute("editedAssignee", assigneeRepo.getOne(id));
    return "editAssignee";
  }

  @PostMapping ("/{id}/editAssignee")
  public String editAssigneeSubmit (@PathVariable Long id, @ModelAttribute Assignee updatedAssignee) {
    updatedAssignee.setId(id);
    assigneeRepo.save(updatedAssignee);
    return "redirect:/assignees";
  }

}
