package com.example.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class DoubleObject {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer received;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer result;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String error;
}
