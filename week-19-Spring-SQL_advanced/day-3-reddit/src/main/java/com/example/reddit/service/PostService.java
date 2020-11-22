package com.example.reddit.service;

import com.example.reddit.model.Post;
import java.util.List;

public interface PostService {
  List<Post> getAllPosts();
  void savePost(Post post);
}
