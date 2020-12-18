package com.example.frontend.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ArrayHandlerResult {
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer result;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private int[] resultArray;
}
