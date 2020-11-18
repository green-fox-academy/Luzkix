package com.example.todos.repositories;

import com.example.todos.models.Todo;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

  @Query("SELECT c FROM Todo c WHERE c.title LIKE %?1% OR c.content LIKE %?1% OR c.description LIKE %?1%" )
  List<Todo>findTodoByString(String text);

  @Query("SELECT c FROM Todo c WHERE c.creationDate = ?1 OR c.dueDate = ?1" )
  List<Todo>findTodoByDate(LocalDate date);
}
