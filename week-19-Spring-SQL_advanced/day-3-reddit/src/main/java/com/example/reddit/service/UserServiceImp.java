package com.example.reddit.service;

import com.example.reddit.model.User;
import com.example.reddit.repository.UserRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
public class UserServiceImp implements UserService {
  private User loggedUser;
  private UserRepository userRepository;
  @Autowired
  public UserServiceImp(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public boolean tryToLogInTheUser(String userEmail, String userPassword) {
    //checks user in dtb - if not foud, return false, else return true and change loggedUser field.
    User matchedUser = userRepository.returnUserByEmailAndPssw(userEmail, userPassword);
    if(matchedUser == null) {
      return  false;
    } else {
      loggedUser = matchedUser;
      return true;
    }
  }

  @Override
  public User loggedUser() {
    return loggedUser;
  }

  @Override
  public boolean tryAddNewUser(String name, String email, String password) {
    //checks whether is already in dtb by email. If so, return False, else create a new user + loggedUser=newUser + return True
    if(userRepository.findByUserEmail(email)!=null) {
      return false;
    } else {
      User newUser = new User (name, email, password);
      userRepository.save(newUser);
      loggedUser=newUser;
      return true;
    }
  }

  @Override
  public void logout() {
    loggedUser = null;
  }
}
