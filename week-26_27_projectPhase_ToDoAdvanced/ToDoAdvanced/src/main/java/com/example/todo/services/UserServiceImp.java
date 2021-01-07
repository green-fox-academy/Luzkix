package com.example.todo.services;

import com.example.todo.models.TodoOwner;
import com.example.todo.models.dto.UserRegistrationDTO;
import com.example.todo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
  UserRepository userRepository;
  PasswordEncoder passwordEncoder;
  @Autowired
  public UserServiceImp(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

/*  @Override
  public List<Todo> findTodosByUserName(String userName) {
    TodoOwner user = userRepository.findByUserName(userName);
    return user.getTodos();
  }*/

  @Override
  public TodoOwner findOwnerById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public TodoOwner findOwnerBasedOnUserName(String userName) {
    TodoOwner user = userRepository.findByUserName(userName);
    return user;
  }

  @Override
  public void createNewOwner(UserRegistrationDTO input)
      throws UsernameAlreadyExistException, NullPointerException, ShortPasswordException {
    if(input.getUserName() == null || input.getPassword() == null){
      throw new NullPointerException();
    }
    if(findOwnerBasedOnUserName(input.getUserName()) != null){
      throw new UsernameAlreadyExistException("User with name " + input.getUserName() + " already exist!");
    }
    if(input.getPassword().length()<8){
      throw new ShortPasswordException(input.getPassword() + " has less than 8 characters!");
    }
    String encodedPsw = passwordEncoder.encode(input.getPassword());
    TodoOwner newOwner = new TodoOwner(input.getUserName(),encodedPsw);
    userRepository.save(newOwner);
  }

  @Override
  public TodoOwner loginUser(UserRegistrationDTO input) throws WrongLoginException, NullPointerException {
    TodoOwner user = findOwnerBasedOnUserName(input.getUserName());

    if(input.getUserName() == null || input.getPassword() == null){
      throw new NullPointerException();
    }
    if(user == null){
      throw new WrongLoginException ();
    }
    if(!passwordEncoder.matches(input.getPassword(),user.getPassword())){
      throw new WrongLoginException ();
    }
    if(passwordEncoder.matches(input.getPassword(),user.getPassword())){
      return user;
    } else return null;
  }
}
