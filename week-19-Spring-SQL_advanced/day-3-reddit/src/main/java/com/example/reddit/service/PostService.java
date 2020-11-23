package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import java.util.List;

public interface PostService {
  List<Post> getAllPosts();
  void savePost(Post post);
  void saveNewPost(Post post);

  List<Post> getMyPosts(User loggedUser);
}
