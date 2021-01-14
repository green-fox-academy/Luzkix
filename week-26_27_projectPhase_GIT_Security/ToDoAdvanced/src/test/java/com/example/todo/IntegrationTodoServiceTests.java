package com.example.todo;

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
import org.springframework.http.HttpHeaders;
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

    Principal mockPrincipal = Mockito.mock(Principal.class);
    Mockito.when(mockPrincipal.getName()).thenReturn("petr");

    mockMvc.perform(post("/newTodo")
        .principal(mockPrincipal)
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON)
        .contentType(MediaType.APPLICATION_JSON)
        .content(inputJson))

        .andDo(MockMvcResultHandlers.print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.title", is("test")))
        .andExpect(jsonPath("$.content", is("test content")))
        .andExpect(jsonPath("$.urgent", is(true)));
        //.andExpect(jsonPath("$.result[3]", is(20)));
  }

}
