package com.example.reddit.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Votes")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Vote {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long voteId;
  private boolean upvote;
  private LocalDateTime votedDateTime;
  @ManyToOne
  @JoinColumn(name="voter_ID")
  private User voter;
  @ManyToOne
  @JoinColumn(name="post_ID")
  private Post votedPost;
}
