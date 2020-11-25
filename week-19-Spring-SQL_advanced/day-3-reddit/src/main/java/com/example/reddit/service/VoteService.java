package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import java.util.List;

public interface VoteService {
  void saveVote (Vote vote);
  Vote returnVoteByPostAndUser(Post post, User loggedUser);

  List<Vote> returnAllVotesByUser(User loggedUser);
}
