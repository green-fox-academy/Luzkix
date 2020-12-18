package com.example.frontend.models;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="Logs")
public class LogEntry {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDateTime createdAt;
  private String endpoint;
  private String data;

  public LogEntry(){
    this.createdAt=LocalDateTime.now();
  }

  public LogEntry(String endpoint, String data) {
    this.createdAt=LocalDateTime.now();
    this.endpoint=endpoint;
    this.data=data;
  }
}
