package com.example.todo.repositories;

import com.example.todo.models.Todo;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TodoRepository extends JpaRepository <Todo, Long> {
  @Query("select c from Todo c where c.id > ?1 order by c.id asc")
  List<Todo> findHigherThanId(Long id);
  @Query("select c from Todo c where c.id < ?1 order by c.id desc")
  List<Todo> findLowerThanId(Long id);
  @Query("select c from Todo c where c.id = ?1")
  List<Todo> findEqualAsId(Long id);

  @Query("select c from Todo c where c.title like %?1% order by c.id asc")
  List<Todo> containsInTitle(String title);

  List<Todo> findByUrgentTrue();
  List<Todo> findByUrgentFalse();

  List<Todo> findByCompletedTrue();
  List<Todo> findByCompletedFalse();

  List<Todo> findByDueDateGreaterThan(LocalDate dueDate);
  List<Todo> findByDueDateLessThan(LocalDate dueDate);
  List<Todo> findByDueDateEquals(LocalDate dueDate);

}
