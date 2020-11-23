package com.example.reddit.cotroller;

import com.example.reddit.model.Post;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import com.example.reddit.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("postsToBeDisplayed", postService.getAllPosts());

    return "homePage";
  }

  @GetMapping ("/addPost")
  String addPostForm (Model model) {
    if(userService.loggedUser() == null){
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("newPost",new Post());
    return "addPost";
  }

  @PostMapping("/addPost")
  String addPostSubmit (@ModelAttribute Post post) {
    postService.saveNewPost(post);
    return "redirect:/";
  }

  @GetMapping("myPosts")
  String myPosts (Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("postsToBeDisplayed", postService.getMyPosts(userService.loggedUser()));

    return "homePage";
  }

}
