package com.example.groot;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GuardianControllerTests {
  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype());

  @Test
  public void grootMessage_paramsAreSet_expectedOK() throws Exception {
    String message = "ahoj";
    mockMvc.perform(get("/groot").param("message",message))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.received",is("ahoj")))
        .andExpect(jsonPath("$.translated",is("I am Groot!")));

  }

  @Test
  public void grootMessage_paramsNotSet_expectedBadRequest() throws Exception {
    mockMvc.perform(get("/groot"))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error",is("I am Groot!")));
  }



}
