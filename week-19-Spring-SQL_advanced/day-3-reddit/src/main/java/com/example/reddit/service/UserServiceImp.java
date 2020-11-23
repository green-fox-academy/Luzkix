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
  public static User loggedUser;
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

  @Override
  public void saveUser(User user) {
    loggedUser=user;
    userRepository.save(user);
  }

  @Override
  public boolean saveEditedAccountOfUser(User updatedUser) {
    //updated email cant be email, which is already assigned to another user (different from loggedUser)
    User emailAlreadyUsed = userRepository.findByUserEmail(updatedUser.getUserEmail());
    if (emailAlreadyUsed != null && emailAlreadyUsed.getUserId() != loggedUser.getUserId()) {
      return false;
    } else {
      loggedUser=updatedUser;
      userRepository.save(updatedUser);
      return true;
    }
  }


}
