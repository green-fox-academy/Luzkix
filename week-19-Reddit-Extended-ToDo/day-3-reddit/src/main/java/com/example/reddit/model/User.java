package com.example.reddit.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long userId;
  private String userName;
  private String userEmail;
  private String userPassword;
  private LocalDate userCreationDate;
/*  @OneToMany(mappedBy = "owner"*//*, cascade = CascadeType.PERSIST, fetch = FetchType.EAGER*//*) //owner v Post by se pak neměl odmazat když Smažu usera
  private List<Post> ownPosts = new ArrayList<>();
  @OneToMany(mappedBy = "voter")
  private List<Vote> ownVotes = new ArrayList<>();*/

  public User(String userName, String userEmail, String userPassword) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.userPassword = userPassword;
    this.userCreationDate = LocalDate.now();
  }


}
