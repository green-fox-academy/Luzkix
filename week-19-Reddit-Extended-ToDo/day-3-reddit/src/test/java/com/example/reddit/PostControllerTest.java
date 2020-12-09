package com.example.reddit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import com.example.reddit.model.Post;
import com.example.reddit.service.PostService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void addPostSubmit_callsPostServiceMethod(){
/*    //Arrange
    PostService postService = Mockito.mock(PostService.class);
    PostDTO post = new PostDTOBuilder();

        Post("Hello","World");

    //Act
    when(postService.saveNewPost(any(post))).thenReturn(added)

    mockMvc.perform()*/
  }
}
