package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImp implements VoteService {

  private VoteRepository voteRepository;
  @Autowired
  public VoteServiceImp(VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public void saveVote(User user, Post post) {

  }
}
