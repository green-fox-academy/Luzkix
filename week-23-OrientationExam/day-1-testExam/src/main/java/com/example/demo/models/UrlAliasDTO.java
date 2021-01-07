package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UrlAliasDTO {
  private Long id;
  private String url;
  private String alias;
  private Long hitCount = 0l;
}
