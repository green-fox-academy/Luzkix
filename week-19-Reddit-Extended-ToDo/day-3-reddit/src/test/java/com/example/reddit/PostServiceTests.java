package com.example.reddit;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;


import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.repository.PostRepository;
import com.example.reddit.service.PostServiceImp;
import com.example.reddit.service.UserServiceImp;
import com.example.reddit.service.VoteService;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PostServiceTests {

  @Test
  public void getAllPostsShouldReturnAllPostsFromDtb() {
    //arrange
    PostRepository postRepository = Mockito.mock(PostRepository.class); //postServiceImp dependency
    VoteService voteService = Mockito.mock(VoteService.class); //postServiceImp dependency

    PostServiceImp postService =
        new PostServiceImp(postRepository, voteService); //Initiating PostSImp

    List<Post> fakePosts = Arrays.asList( //vytváření fake listu
        new Post("Hello", "World"),
        new Post("Ahoj", "Svet")
    );
    Mockito.when(postRepository.findAll()).thenReturn(fakePosts); //findAll() vrací fakePosts

    //Act
    List<Post> posts = postService.getAllPosts(); //zde spustím testovanou metodu

    //Assert
    Assert.assertEquals(2, posts.size());
    Assert.assertEquals("Hello", posts.get(0).getTitle());
    Assert.assertEquals("Svet", posts.get(1).getPostDesc());
    verify(postRepository, times(1)).findAll();//že se findAll spustila jen 1x
    verifyNoMoreInteractions(postRepository);//že neprobíhají jiné interakce než s postRepository
  }

  @Test
  public void getPostByIdReturnsPostBasedOnId() {
    PostRepository postRepository = Mockito.mock(PostRepository.class);
    VoteService voteService = Mockito.mock(VoteService.class);
    PostServiceImp postService = new PostServiceImp(postRepository, voteService);
    List<Post> fakePosts = Arrays.asList( //vytváření fake listu
        new Post("Hello", "World"),
        new Post("Ahoj", "Svet")
    );
    Long id = 1L;
    Mockito.when(postRepository.getOne(id)).thenReturn(fakePosts.get(0));

    Post returnedPost = postService.getPostById(id);

    Assert.assertEquals("Hello", returnedPost.getTitle());
    Assert.assertEquals("World", returnedPost.getPostDesc());
    verify(postRepository, times(1)).getOne(id);
    verifyNoMoreInteractions(postRepository);
  }

  @Test
  public void saveNewPost_setOwnerAndOwnerName() {
    //arrange
    UserServiceImp userServiceImp = Mockito.mock(UserServiceImp.class);
    // not used// PostRepository postRepository = Mockito.mock(PostRepository.class);
    // not used// VoteService voteService = Mockito.mock(VoteService.class);
    /// not used// PostServiceImp postService = new PostServiceImp(postRepository, voteService);

    User loggedUser = new User("Zdenek","luzkix@seznam.cz", "heslo");
    userServiceImp.loggedUser = loggedUser;
    Post post = new Post("Hello", "World");
    Mockito.when(userServiceImp.loggedUser()).thenReturn(loggedUser);

    //action
    post.setOwner(userServiceImp.loggedUser());
    post.setOwnerName(userServiceImp.loggedUser().getUserName());

    //assert
    Assert.assertEquals(loggedUser, post.getOwner());
    Assert.assertEquals("Zdenek", post.getOwnerName());
    verify(userServiceImp, times(2)).loggedUser();
    verifyNoMoreInteractions(userServiceImp);
  }


}
