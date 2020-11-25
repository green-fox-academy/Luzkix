package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import com.example.reddit.repository.VoteRepository;
import java.util.List;
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
  public void saveVote(Vote vote) {
    voteRepository.save(vote);
  }

  @Override
  public Vote returnVoteByPostAndUser(Post post, User loggedUser) {
    return voteRepository.returnVoteByPostAndUser(post,loggedUser);
  }

  @Override
  public List<Vote> returnAllVotesByUser(User loggedUser) {
    return voteRepository.returnAllVotesByUser(loggedUser);
  }
}
