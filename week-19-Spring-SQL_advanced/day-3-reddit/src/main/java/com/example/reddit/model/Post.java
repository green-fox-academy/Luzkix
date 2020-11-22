package com.example.reddit.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@AllArgsConstructor
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;
  private String title;
  private String postDesc;
  private Long likes;
  @ManyToOne
  @JoinColumn(name="postOwner_ID")
  private User owner;
  @OneToMany(mappedBy = "votedPost")
  private List<Vote> votes = new ArrayList<>();

  private LocalDate creationDate;

  public Post () {
    creationDate = LocalDate.now();
  }

}
