package com.example.reddit.service;

import com.example.reddit.model.Post;
import com.example.reddit.model.User;
import com.example.reddit.model.Vote;
import com.example.reddit.repository.PostRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.management.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImp implements PostService{

  private PostRepository postRepository;
  private VoteService voteService;
  @Autowired
  public PostServiceImp(PostRepository postRepository, VoteService voteService) {
    this.postRepository = postRepository;
    this.voteService = voteService;
  }

  @Override
  public List<Post> getAllPosts() {
    return postRepository.findAll();
  }

  @Override
  public void savePost(Post post) {
    postRepository.save(post);
  }

  @Override
  public void saveNewPost(Post post) {
    post.setOwner(UserServiceImp.loggedUser);
    post.setOwnerName(UserServiceImp.loggedUser.getUserName());
    postRepository.save(post);
  }

  @Override //nakonec fci nepoužívám, využívám List<Post> přímo na Userovi
  public List<Post> getMyPosts(User loggedUser) {
    return postRepository.getMyPosts(loggedUser);
  }

  @Override
  public Post getPostById(Long id) {
    return postRepository.getOne(id);
  }

  @Override
  public void likePost(Post likedPost, User loggedUser) {
    Vote votedPost = voteService.returnVoteByPostAndUser(likedPost, loggedUser);
    if (likedPost.getOwner().getUserId() == loggedUser.getUserId()){ //so the user cant like own posts
    } else if (votedPost == null) {
      likedPost.like();
      postRepository.save(likedPost);
      Vote newVote =new Vote();
      newVote.setUpvote(1);
      newVote.setVotedDateTime(LocalDateTime.now());
      newVote.setVotedPost(likedPost);
      newVote.setVoter(loggedUser);
      voteService.saveVote(newVote);
    } else if (votedPost.getUpvote() ==1) {
    } else if (votedPost.getUpvote() ==0) {
      likedPost.like();
      postRepository.save(likedPost);
      votedPost.setUpvote(1);
      voteService.saveVote(votedPost);
    } else if (votedPost.getUpvote() ==-1) {
      likedPost.like();
      postRepository.save(likedPost);
      votedPost.setUpvote(0);//Basically it returns voting from -1 to 0 state
      voteService.saveVote(votedPost);
    }
  }

  @Override
  public void dislikePost(Post dislikedPost, User loggedUser) {
    Vote votedPost = voteService.returnVoteByPostAndUser(dislikedPost, loggedUser);
    if (dislikedPost.getOwner().getUserId() == loggedUser.getUserId()){ //so the user cant dislike own posts
    } else if (votedPost == null) {
      dislikedPost.dislike();
      postRepository.save(dislikedPost);
      Vote newVote =new Vote();
      newVote.setUpvote(-1);
      newVote.setVotedDateTime(LocalDateTime.now());
      newVote.setVotedPost(dislikedPost);
      newVote.setVoter(loggedUser);
      voteService.saveVote(newVote);
    } else if (votedPost.getUpvote() == -1) {
    } else if (votedPost.getUpvote() ==0) {
      dislikedPost.dislike();
      postRepository.save(dislikedPost);
      votedPost.setUpvote(-1);
      voteService.saveVote(votedPost);
    } else if (votedPost.getUpvote() ==1) {
      dislikedPost.dislike();
      postRepository.save(dislikedPost);
      votedPost.setUpvote(0);//Basically it returns voting from -1 to 0 state
      voteService.saveVote(votedPost);
    }
  }

  @Override
  public List<List<String>> getMyLikes(User loggedUser) { //the method collects data in String form to be displayed in /myLikes endpoint
    List<Vote> myVotes = voteService.returnAllVotesByUser(loggedUser);
    List<List<String>> LikedPostsDetailsList = new ArrayList<>();

    for(Vote vote:myVotes ) {
      List<String> likedPostDetail = new ArrayList<>();

      String totalLikes = vote.getVotedPost().getLikes().toString();
      String postTitle = vote.getVotedPost().getTitle();
      String myLikeOrDislike = new String();
      if(vote.getUpvote()==1) {
        myLikeOrDislike = "Like";
      } else if(vote.getUpvote()==-1) {
        myLikeOrDislike = "Dislike";
      } else if (vote.getUpvote()==0) {
        myLikeOrDislike ="Like/Dislike revoked";
      }
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
      String votedDate = vote.getVotedDateTime().format(formatter);
      String postCreatedBy = vote.getVotedPost().getOwner().getUserName();

      likedPostDetail.addAll(
          Arrays.asList(totalLikes,postTitle,myLikeOrDislike,votedDate,postCreatedBy));
      LikedPostsDetailsList.add(likedPostDetail);
    }
    return LikedPostsDetailsList;
  }

  @Override
  public List<Post> getPaginatedPosts() {

  return null;
  }
}
