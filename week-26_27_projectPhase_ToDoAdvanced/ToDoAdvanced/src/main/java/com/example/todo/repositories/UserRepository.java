package com.example.todo.repositories;

import com.example.todo.models.TodoOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<TodoOwner, Long> {

  TodoOwner findByUserName(String userName);
}
