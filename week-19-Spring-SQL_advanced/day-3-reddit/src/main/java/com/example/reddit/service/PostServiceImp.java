package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

  private PostRepository postRepository;
  @Autowired
  public PostServiceImp(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  @Override
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  @Override
  public void savePost(Post post) {
    postRepository.save(post);
  }

  @Override
  public void saveNewPost(Post post) {
    post.setOwner(UserServiceImp.loggedUser);
    postRepository.save(post);
  }

  @Override
  public List<Post> getMyPosts(User loggedUser) {
    return postRepository.getMyPosts(loggedUser);
  }
}
