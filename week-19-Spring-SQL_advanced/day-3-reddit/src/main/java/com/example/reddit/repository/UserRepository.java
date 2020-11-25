package com.example.reddit.repository;

import com.example.reddit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository <User, Long> {

  @Query("SELECT c FROM User c WHERE LOWER(c.userEmail) = LOWER(?1) AND c.userPassword = ?2")
  User returnUserByEmailAndPssw (String email, String password);

  @Query("SELECT c FROM User c WHERE LOWER(c.userEmail) = LOWER(?1)")
  User findByUserEmail(String email);
}
