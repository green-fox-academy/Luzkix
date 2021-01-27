package com.example.todo;

import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.todo.configuration.TestNoSecurityConfig;
import com.example.todo.models.Role;
import com.example.todo.models.Todo;
import com.example.todo.models.TodoOwner;
import com.example.todo.repositories.TodoRepository;
import com.example.todo.services.NoMatchingResultException;
import com.example.todo.services.UserService;
import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@Import(TestNoSecurityConfig.class)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTodoServiceTests {
  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype());

  @Test
  public void createNewCorrectTodo_ReturnsCreatedTodo() throws Exception {
    String inputJson = "{\"title\":\"test\",\"content\":\"test content\",\"urgent\":true}";

    //mockuju uživatele, který má dodat Principal
    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("petr");

    //mockuju jen 1 repository metodu, která má vrátit konkrétního TodoOwnera (protože mám prázdnou dtb)
    UserService userService = Mockito.spy(UserService.class);
    Role role = new Role();
    TodoOwner ownerPetr = new TodoOwner("petr", "heslo", role);
    ownerPetr.setId(1l);
    Mockito.doReturn(ownerPetr).when(userService).findOwnerBasedOnUserName("petr");


    mockMvc.perform(post("/newTodo")
        .principal(mockPrincipal)
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.title", is("test")))
        .andExpect(jsonPath("$.content", is("test content")))
        .andExpect(jsonPath("$.urgent", is(true)));
  }

  @Test
  public void ilter_Urgent_ShouldReturnUrgentTodos()
      throws Exception, NoMatchingResultException {
    //preparation of input json
    String inputJson = "{\"method\":\"filter\",\"filterBy\":\"urgent\",\"urgent\":true}";

    //Preparation of data to be returned from Repo
    Role role = new Role();
    TodoOwner ownerPetr = new TodoOwner("petr", "heslo", role);
    TodoOwner ownerZdenek = new TodoOwner("zdenek", "heslo", role);
    Todo testTodoPetr = new Todo("todoPetr", "todo", true, LocalDate.parse("2021-06-20"), ownerPetr);
    Todo testTodoZdenek =
        new Todo("todoZdenek", "todo", true, LocalDate.parse("2021-01-31"), ownerZdenek);
    List<Todo> todos = new ArrayList<>();
    todos.addAll(List.of(testTodoPetr,testTodoZdenek));

    TodoRepository todoRepository = Mockito.spy(TodoRepository.class);
    Mockito.doReturn(todos).when(todoRepository).findByUrgentTrue();
    /*TodoRepository todoRepository = Mockito.mock(TodoRepository.class);
    Mockito.when(todoRepository.findByUrgentTrue()).thenReturn(todos);*/

    mockMvc.perform(get("/listTodos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType));
/*        .andExpect(jsonPath("$.filtredTodos[0].title", is("todoPetr")))
        .andExpect(jsonPath("$.filtredTodos[1].title", is("todoZdenek")))
        .andExpect(jsonPath("$.filtredTodos[0].content", is("todo")))
        .andExpect(jsonPath("$.filtredTodos[1].content", is("todo")))
        .andExpect(jsonPath("$.filtredTodos[0].urgent", is(true)))
        .andExpect(jsonPath("$.filtredTodos[1].urgent", is(true)));*/
  }

}
