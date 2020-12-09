package com.example.reddit.repository;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VoteRepository extends JpaRepository<Vote, Long> {
  @Query("SELECT c FROM Vote c WHERE c.votedPost = ?1 AND c.voter = ?2")
  Vote returnVoteByPostAndUser(Post post, User loggedUser);

  @Query("SELECT c from Vote c WHERE c.voter = ?1")
  List<Vote> returnAllVotesByUser(User loggedUser);
}
