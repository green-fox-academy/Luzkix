package com.example.frontend;


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
public class MainControllerTests {

  @Autowired
  private MockMvc mockMvc;

  private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype());

  /*@MockBean
  private MainService mainService;*/


  @Test
  public void doubling_correctOutput() throws Exception{
    String input = "15";
    mockMvc.perform(get("/doubling").param("input",input))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.received", is(15)))
        .andExpect(jsonPath("$.result", is(30)));
  }

  @Test
  public void doubling_noImput() throws Exception {
    mockMvc.perform(get("/doubling"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.error",is("Please provide an input!")));
  }

  @Test
  public void doUntil__correctInput_Summing() throws Exception{
    mockMvc.perform(post("/dountil/sum")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"until\":\"5\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is(15)));
  }

  @Test
  public void doUntil__correctInput_Factorial() throws Exception{
    mockMvc.perform(post("/dountil/factor")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"until\":\"5\"}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is(120)));
  }

  @Test
  public void doUntil_wronInput_noNumberProvided() throws Exception{
    mockMvc.perform(post("/dountil/sum")
        .contentType(MediaType.APPLICATION_JSON))
        //.content("{\"until\":}"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Please provide a number!")));
  }

  @Test
  public void doUntil_wronInput_noAction() throws Exception{
    mockMvc.perform(post("/dountil")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"until\":\"5\"}"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Please provide a number!")));
  }

  @Test
  public void arrayHandler_noInput() throws Exception{
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON))
        //.content("{\"until\":\"5\"}"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.error", is("Please provide what to do with the numbers!")));
  }

  @Test
  public void arrayHandler_OK_sum() throws Exception{
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"what\":\"sum\",\"numbers\":[1,2,5,10]}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is(18)));
  }

  @Test
  public void arrayHandler_OK_multiply() throws Exception{
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"what\":\"multiply\",\"numbers\":[1,2,5,10]}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.result", is(100)));
  }

  @Test
  public void arrayHandler_OK_double() throws Exception{
    mockMvc.perform(post("/arrays")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"what\":\"double\",\"numbers\":[1,2,5,10]}"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(contentType))
        .andExpect(jsonPath("$.resultArray[0]", is(2)))
        .andExpect(jsonPath("$.resultArray[1]", is(4)))
        .andExpect(jsonPath("$.resultArray[2]", is(10)))
        .andExpect(jsonPath("$.resultArray[3]", is(20)));
  }

  




}
