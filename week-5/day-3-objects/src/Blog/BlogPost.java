package Blog;

import java.util.Objects;

public class BlogPost {
  private String authorName;
  private String title;
  private String text;
  private String publicationDate;

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(String publicationDate) {
    this.publicationDate = publicationDate;
  }

  @Override
  public String toString() {
    return this.authorName + " wrote this blog: " + this.title + ". The blog was published on " + this.publicationDate;
  }

}
