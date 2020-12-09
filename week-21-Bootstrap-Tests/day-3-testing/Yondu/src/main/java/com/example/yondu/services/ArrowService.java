package com.example.yondu.services;

import com.example.yondu.models.ArrowStats;
import com.example.yondu.models.ErrorMessage;
import org.springframework.stereotype.Service;

@Service
public class ArrowService {
  public ArrowStats calculateSpeed(float distance, float time) {
    ArrowStats stats = new ArrowStats();
    float speed = distance/time;
    stats.setDistance(distance);
    stats.setTime(time);
    stats.setSpeed(speed);
    return stats;
  }

  public ErrorMessage errorMessage(String errorMessage) {
    ErrorMessage error = new ErrorMessage();
    error.setError(errorMessage);
    return error;
  }
}
