package com.example.demo.controllers;

import com.example.demo.models.SecretCodeDTO;
import com.example.demo.models.UrlAlias;
import com.example.demo.models.UrlAliasDTO;
import com.example.demo.services.AllServices;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
  AllServices allServices;

  public MainController(AllServices allServices) {
    this.allServices = allServices;
  }

  @GetMapping("/")
  String homepage(Model model,
                  @RequestParam(required = false) Boolean success,
                  @RequestParam(required = false) String successText,
                  @RequestParam(required = false) Boolean errorSavingAlias,
                  @RequestParam(required = false) String url,
                  @RequestParam(required = false) String alias) {

    if(success != null){model.addAttribute("success", success);}
    if(successText != null){model.addAttribute("successText",successText);}
    if(errorSavingAlias != null){model.addAttribute("errorSavingAlias",errorSavingAlias);}
    if(url != null || alias != null){model.addAttribute("newAlias", new UrlAlias(url,alias));}
    else {model.addAttribute("newAlias", new UrlAlias());}

    return "homepage";
  }

  @PostMapping("/save-link")
  String saveAlias(@ModelAttribute UrlAlias alias, RedirectAttributes ra) {
    UrlAlias newAlias = allServices.tryToSaveNewAlias(alias);

    if(newAlias == null) {// == error
      ra.addAttribute("errorSavingAlias", true);
      ra.addAttribute("url", alias.getUrl());
      ra.addAttribute("alias",alias.getAlias());
      return "redirect:/";
    }
    ra.addAttribute("success", true);
    ra.addAttribute("successText","Your URL is to <strong>"+alias.getUrl()+
        "</strong> and your code is <strong>"+newAlias.getSecretCode()+"</strong>.");
    return "redirect:/";
  }

  @GetMapping("/a/{alias}")
  String checkAliasExistence(@PathVariable(required = false) String alias){
  Boolean aliasExists = allServices.checkExistenceOfAlias(alias);
  if(aliasExists){return "redirect:/";}
  else throw new ResponseStatusException(HttpStatus.valueOf(404), alias + " not Found");
  }

  @ResponseBody
  @GetMapping("/api/links")
  ResponseEntity<?> returnLinks(){
    List<UrlAliasDTO> responseDTO = allServices.returnLinks();
    return ResponseEntity.ok().body(responseDTO);
  }

  @ResponseBody
  @DeleteMapping("/api/links/{id}")
  ResponseEntity deleteAlias(@PathVariable Long id,
                             @RequestBody SecretCodeDTO secretCode){
    UrlAlias aliasToBeDeleted = allServices.getAliasById(id);
    if(aliasToBeDeleted == null) {
      return ResponseEntity.status(HttpStatus.valueOf(404)).build();
    }else if(!aliasToBeDeleted.getSecretCode().equals(secretCode.getSecretCode())) {
      return ResponseEntity.status(HttpStatus.valueOf(403)).build();
    }else {
      allServices.deleteAlias(aliasToBeDeleted);
      return ResponseEntity.status(HttpStatus.valueOf(204)).build();
    }

  }


}
