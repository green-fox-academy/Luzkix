package com.example.reddit.model;

import com.fasterxml.jackson.annotation.JsonInclude;
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
import lombok.Setter;

@Entity
@Table(name="posts")
@Getter
@Setter
@AllArgsConstructor
public class Post implements Comparable<Post>{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long postId;
  private String title;
  private String postDesc;
  private Long likes = 0l;
  @ManyToOne
  @JoinColumn(name="postOwner_ID")
  private User owner;
  private String ownerName;
  private LocalDateTime creationDate;
  /*@OneToMany(mappedBy = "votedPost")
  private List<Vote> votes = new ArrayList<>();*/

  public Post () {
    creationDate = LocalDateTime.now();
  }

  public Post (String title, String postDesc) {
    this.title = title;
    this.postDesc = postDesc;
    creationDate = LocalDateTime.now();
  }

  public void like () {
    this.likes++;
  }

  public void dislike () {
    this.likes--;
  }

  @Override
  public int compareTo(Post other) {
    return (int) (other.likes - likes);
  }
}
