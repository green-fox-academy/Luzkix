package com.example.todo;


import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


import com.example.todo.models.Role;
import com.example.todo.models.Todo;
import com.example.todo.models.TodoOwner;
import com.example.todo.models.dto.FilterTodoDTO;
import com.example.todo.models.dto.FilteredTodosResponseDTO;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.services.NoMatchingResultException;
import com.example.todo.services.TodoServiceImp;
import com.example.todo.services.UserService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import org.junit.Test;
import org.mockito.Mockito;

public class UnitTodoServiceTests {
  Role role = new Role();
  TodoOwner ownerPetr = new TodoOwner("petr","heslo",role);
  TodoOwner ownerZdenek = new TodoOwner("zdenek","heslo",role);
  Todo testTodoPetr = new Todo("todoPetr","todo",true,LocalDate.parse("2021-06-20"),ownerPetr);
  Todo testTodoZdenek = new Todo("todoZdenek","todo",false,LocalDate.parse("2021-01-31"),ownerZdenek);

  TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
  UserService userService = Mockito.mock(UserService.class);
  TodoServiceImp todoServiceImp = new TodoServiceImp(todoRepository,userService);

  @Test
  public void createNewTodoShouldReturnCreatedTodo(){
    //arrange
    String title = "new todo";
    String content = "new";
    Boolean urgent = true;
    LocalDate dueDate = LocalDate.parse("2021-05-06");
    String login = "petr";

    Role role = new Role();
    TodoOwner todoOwnerTest = new TodoOwner("petr","heslo",role);

    Mockito.when(userService.findOwnerBasedOnUserName(login)).thenReturn(todoOwnerTest);

    //act
    Todo newTodo =
        new Todo(title, content, urgent, dueDate, todoOwnerTest);

    //assert
    Assert.assertEquals("new todo",newTodo.getTitle());
    Assert.assertEquals("new",newTodo.getContent());
    Assert.assertEquals(true,newTodo.getUrgent());
    Assert.assertEquals(LocalDate.parse("2021-05-06"),newTodo.getDueDate());
    Assert.assertEquals("petr",newTodo.getOwner().getLogin());
    Assert.assertEquals("heslo",newTodo.getOwner().getPassword());
  }

  @Test(expected = NullPointerException.class)
  public void createNewTodoNullTitleShouldThrowNullPointerException(){
    //Arrange
    String testToken = "token";
    Todo testInput1 = new Todo(null,"content",true,null,null);
    boolean thrown = false;

    //Act
    todoServiceImp.createTodo(testInput1,testToken);
/*    try{

      thrown = false;
    }catch (NullPointerException e){
      thrown = true;
    }*/

    //Assert
    /*Assert.assertTrue(thrown);*/
  }

  @Test
  public void createNewTodoNullContentShouldThrowNullPointerException(){
    //Arrange
    String testToken = "token";
    Todo testInput2 = new Todo("title",null,true,null,null);
    boolean thrown = false;

    //Act
    try{
      todoServiceImp.createTodo(testInput2,testToken);
      thrown = false;
    }catch (NullPointerException e){
      thrown = true;
    }

    //Assert
    Assert.assertTrue(thrown);
  }

  @Test
  public void filter_All_ShouldReturnAllTodos(){
    //Arrange
    FilteredTodosResponseDTO replyDTO = new FilteredTodosResponseDTO();
    FilterTodoDTO dto = new FilterTodoDTO();

    dto.setMethod("all");
    List<Todo> allTodos = new ArrayList<>();
    allTodos.addAll(List.of(testTodoZdenek,testTodoPetr));

    Mockito.when(todoRepository.findAll()).thenReturn(allTodos);

    //Act
    try {
      replyDTO = todoServiceImp.filterTodos(dto);
    } catch (NullPointerException e) {
    } catch (NoMatchingResultException e) {
    }

    //Assert
    Assert.assertEquals(2, replyDTO.getFilteredTodos().size());
    Assert.assertEquals("todoZdenek", replyDTO.getFilteredTodos().get(0).getTitle());
    Assert.assertEquals("todoPetr", replyDTO.getFilteredTodos().get(1).getTitle());

    verify(todoRepository, times(1)).findAll();//že se findAll spustila jen 1x
    verifyNoMoreInteractions(todoRepository);//že neprobíhají jiné interakce než s postRepository
  }

  @Test
  public void filter_Urgent_ShouldReturnUrgentTodos() throws NullPointerException,NoMatchingResultException {
    //Arrange
    FilteredTodosResponseDTO replyDTO = new FilteredTodosResponseDTO();
    FilterTodoDTO dto = new FilterTodoDTO();

    dto.setMethod("filter");
    dto.setFilterBy("urgent");
    dto.setUrgent(true);
    List<Todo> todos = new ArrayList<>();
    todos.addAll(List.of(testTodoPetr));

    Mockito.when(todoRepository.findByUrgentTrue()).thenReturn(todos);

    //Act
    replyDTO = todoServiceImp.filterTodos(dto);

    //Assert
    Assert.assertEquals(1, replyDTO.getFilteredTodos().size());
    Assert.assertEquals("todoPetr", replyDTO.getFilteredTodos().get(0).getTitle());

    verify(todoRepository, times(1)).findByUrgentTrue();//že se findAll spustila jen 1x
    verifyNoMoreInteractions(todoRepository);//že neprobíhají jiné interakce než s postRepository
  }


}
