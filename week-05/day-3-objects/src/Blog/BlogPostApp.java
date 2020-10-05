package Blog;

public class BlogPostApp {
  public static void main(String[] args) {
    BlogPost blogPost1 = new BlogPost();
    blogPost1.setTitle("Lorem Ipsum");
    blogPost1.setAuthorName("John Doe");
    blogPost1.setPublicationDate("2000.05.04.");
    blogPost1.setText("Lorem ipsum dolor sit amet");

    BlogPost blogPost2 = new BlogPost();
    blogPost2.setTitle("Wait but why");
    blogPost2.setAuthorName("Tim Urban");
    blogPost2.setPublicationDate("2010.10.10.");
    blogPost2.setText("A popular long-form, stick-figure-illustrated blog about almost everything.");

    BlogPost blogPost3 = new BlogPost();
    blogPost3.setTitle("One Engineer Is Trying to Get IBM to Reckon With Trump");
    blogPost3.setAuthorName("William Turton");
    blogPost3.setPublicationDate("2017.03.28.");
    blogPost3.setText("Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.");

    BlogPost blogPost4 = new BlogPost();
    blogPost4.setTitle("Blog4 - test");
    blogPost4.setAuthorName("William Turton");
    blogPost4.setPublicationDate("2017.03.28.");
    blogPost4.setText("Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.");

    BlogPost blogPost5 = new BlogPost();
    blogPost5.setTitle("Blog5 - test");
    blogPost5.setAuthorName("Tim Urban");
    blogPost5.setPublicationDate("2010.10.10.");
    blogPost5.setText("A popular long-form, stick-figure-illustrated blog about almost everything.");

    System.out.println(blogPost3);

    Blog blog1 = new Blog();
    blog1.addBlogPost(blogPost1);
    blog1.addBlogPost(blogPost2);

    System.out.println(blog1);

    blog1.deleteBlogPost(0);
    System.out.println(blog1);

    blog1.addBlogPost(blogPost2);
    blog1.addBlogPost(blogPost3);
    blog1.addBlogPost(blogPost4);
    blog1.addBlogPost(blogPost5);
    System.out.println(blog1);

    blog1.updateBlogPost(2, blogPost1);
    System.out.println(blog1);

  }
}
