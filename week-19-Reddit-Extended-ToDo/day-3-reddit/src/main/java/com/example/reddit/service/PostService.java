package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import java.util.List;

public interface PostService {
  List<Post> getAllPosts();
  void savePost(Post post);
  void saveNewPost(Post post);
  List<Post> getMyPosts(User loggedUser);

  Post getPostById(Long id);

  void likePost(Post likedPost, User loggedUser);

  void dislikePost(Post likedPost, User loggedUser);

  List<List<String>> getMyLikes(User loggedUser);

  List<Post> getPaginatedPosts();
}
