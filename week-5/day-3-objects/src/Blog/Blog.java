package Blog;

import java.util.ArrayList;
import java.util.List;

public class Blog {
  List<BlogPost> blog;

  public Blog () {
    this.blog = new ArrayList<>();
  }

  public void addBlogPost (BlogPost blogPost) {
    this.blog.add(blogPost);
    System.out.println("The blogpost '" + blogPost.getTitle() + "' was added to the blog!");
  }

  public void deleteBlogPost (int index) {
    System.out.println("You just removed this blogpost from the blog: '" + blog.get(index).getTitle() + "'");
    this.blog.remove(index);
  }

  public void updateBlogPost (int index, BlogPost blogPost) {
    System.out.println("BlogPost '" + this.blog.get(index).getTitle() + "' was replaced for new blogpost '" + blogPost.getTitle() + "'");
    this.blog.set(index, blogPost);
  }

  @Override
  public String toString() {
    String tempText = "The blog contains " +blog.size() + " following blogposts:";
    for (int i = 0; i < blog.size(); i++) {
      String blogName = " " + blog.get(i).getTitle() + ",";
      tempText += blogName;
    }
    return tempText;
  }

}
