package BlogPost;

public class BlogPostApp {
  public static void main(String[] args) {
    BlogPost blog1 = new BlogPost();
    blog1.setTitle("Lorem Ipsum");
    blog1.setAuthorName("John Doe");
    blog1.setPublicationDate("2000.05.04.");
    blog1.setText("Lorem ipsum dolor sit amet");

    BlogPost blog2 = new BlogPost();
    blog2.setTitle("Wait but why");
    blog2.setAuthorName("Tim Urban");
    blog2.setPublicationDate("2010.10.10.");
    blog2.setText("A popular long-form, stick-figure-illustrated blog about almost everything.");

    BlogPost blog3 = new BlogPost();
    blog3.setTitle("One Engineer Is Trying to Get IBM to Reckon With Trump");
    blog3.setAuthorName("William Turton");
    blog3.setPublicationDate("2017.03.28.");
    blog3.setText("Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.");

    System.out.println(blog3);
    System.out.println(blog1);
  }
}
