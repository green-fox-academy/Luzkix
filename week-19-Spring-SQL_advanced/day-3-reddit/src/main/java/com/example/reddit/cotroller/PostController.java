package com.example.reddit.cotroller;

import com.example.reddit.repository.VoteRepository;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import com.example.reddit.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

  private PostService postService;
  private VoteService voteService;
  private UserService userService;
  @Autowired

  public PostController(PostService postService, VoteService voteService, UserService userService) {
    this.postService = postService;
    this.voteService = voteService;
    this.userService = userService;
  }

  @GetMapping({"","/"})
  String displayHomePage (Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }

    return "homePage";
  }

}
