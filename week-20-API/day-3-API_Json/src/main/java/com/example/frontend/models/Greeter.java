package com.example.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Greeter {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String welcome_message;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String error;
}
