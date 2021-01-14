package com.example.todo;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.todo.configuration.TestNoSecurityConfig;
import java.security.Principal;
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

    //mocking of Principal, which delivers username
    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("petr");

    /*//!!!Not working: mocking of 1 particular method in case the database is not available/is empty:
    UserService userService = Mockito.spy(UserService.class);
    Role role = new Role();
    TodoOwner ownerPetr = new TodoOwner("petr", "heslo", role);
    ownerPetr.setId(1l);
    Mockito.doReturn(ownerPetr).when(userService).findOwnerBasedOnUserName("petr");
*/
    mockMvc.perform(post("/newTodo")
        .principal(mockPrincipal)
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.title", is("test")))
        .andExpect(jsonPath("$.content", is("test content")))
        .andExpect(jsonPath("$.urgent", is(true)))
        .andExpect(jsonPath("$.owner.login",is("petr")));
  }

  @Test
  public void filter_Urgent_ShouldReturnUrgentTodos()
      throws Exception {
    //preparation of input json
    String inputJson = "{\"method\":\"filter\",\"filterBy\":\"urgent\",\"urgent\":true}";

    mockMvc.perform(get("/listTodos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.filteredTodos.*", hasSize(5)));
  }

  @Test
  public void filterUrgent_urgentStatusNotFilled_ShouldReturn400andErrorDTO()
      throws Exception {
    //preparation of input json
    String inputJson = "{\"method\":\"filter\",\"filterBy\":\"urgent\"}";

    mockMvc.perform(get("/listTodos")
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isBadRequest())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Please provide the json for filtering Todos with correct data!")));
  }

  @Test
  public void updateTodoShouldReturnUpdatedTodo() throws Exception{
    //preparation of input json
    String inputJson = "{\"id\":\"1\",\"title\":\"new title\"}";

    //mocking of Principal, which delivers username
    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("zdenek");

    mockMvc.perform(put("/updateTodo")
        .principal(mockPrincipal)
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is(200))
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.id", is(1)))
        .andExpect(jsonPath("$.title", is("new title")));
  }

  @Test
  public void updateTodoWithWrongUserShouldReturn401AndErrorDTO() throws Exception{
    //preparation of input json
    String inputJson = "{\"id\":\"1\",\"title\":\"new title\"}";

    //mocking of Principal, which delivers username
    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("petr");

    mockMvc.perform(put("/updateTodo")
        .principal(mockPrincipal)
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))
        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().is(401))
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("You are not the Owner of the Todo you want to change - Todo was not updated")));
  }
}
