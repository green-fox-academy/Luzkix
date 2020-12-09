package com.example.reddit.cotroller;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.service.PostService;
import com.example.reddit.service.UserService;
import com.example.reddit.service.VoteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    List<Post> postsToBeDisplayed = postService.getPaginatedPosts();

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
    model.addAttribute("postsToBeDisplayed",postService.getMyPosts(userService.loggedUser()));
    model.addAttribute("myposts", true);
    return "homePage";
  }

  @GetMapping("/like/{id}")
  String likePost (@PathVariable Long id, Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());

    Post likedPost = postService.getPostById(id);
    User loggedUser = userService.loggedUser();
    postService.likePost(likedPost, loggedUser);

    return "redirect:/";
  }

  @GetMapping("/dislike/{id}")
  String dislikePost (@PathVariable Long id, Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());

    Post dislikedPost = postService.getPostById(id);
    User loggedUser = userService.loggedUser();
    postService.dislikePost(dislikedPost, loggedUser);

    return "redirect:/";
  }

  @GetMapping("/myLikes")
  String myLikes (Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    List<List<String>> postsToBeDisplayed = postService.getMyLikes(userService.loggedUser());

    model.addAttribute("postsToBeDisplayed", postsToBeDisplayed);

    return "myLikes";
  }

  @GetMapping("/post/{id}")
  String postDetail (@PathVariable Long id, Model model){
    if(userService.loggedUser() == null) {
      return "login";
    }
    model.addAttribute("loggedUser", userService.loggedUser().getUserName());
    model.addAttribute("viewPost", postService.getPostById(id));

    return "viewPost";
  }

}
