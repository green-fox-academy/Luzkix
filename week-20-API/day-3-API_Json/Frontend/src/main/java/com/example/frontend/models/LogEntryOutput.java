package com.example.frontend.models;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LogEntryOutput {
  private List<LogEntry> entries = new ArrayList<>();
  private int entry_count = 0;
}
