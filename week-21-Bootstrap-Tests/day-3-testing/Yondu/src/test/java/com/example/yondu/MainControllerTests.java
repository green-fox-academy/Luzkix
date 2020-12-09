package com.example.yondu;

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


  @Test
  public void calculateSpeed_statusOK_correctResult() throws Exception{
    String distance = "100.0";
    String time = "10.0";
    mockMvc.perform(get("/yondu").param("distance",distance).param("time",time))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.distance", is(100.0)))
        .andExpect(jsonPath("$.time", is(10.0)))
        .andExpect(jsonPath("$.speed", is(10.0)));
  }

  @Test
  public void calculateSpeed_BadRequest_nullDistance() throws Exception{
    //String distance = "100.0";
    String time = "10.0";
    mockMvc.perform(get("/yondu").param("time",time))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Distance or Time not set! Calculating speed is impossible!")));
  }

  @Test
  public void calculateSpeed_BadRequest_nullTime() throws Exception{
    String distance = "100.0";
    //String time = "10.0";
    mockMvc.perform(get("/yondu").param("distance",distance))
        .andExpect(status().isBadRequest())
        .andExpect(jsonPath("$.error", is("Distance or Time not set! Calculating speed is impossible!")));
  }

}
