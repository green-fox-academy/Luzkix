package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;

public interface VoteService {
  void saveVote (User user, Post post);
}
