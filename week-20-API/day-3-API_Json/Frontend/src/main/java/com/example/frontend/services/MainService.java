package com.example.frontend.services;

import com.example.frontend.models.DoubleErrorObject;
import com.example.frontend.models.DoubleObject;
import org.springframework.stereotype.Service;

public interface MainService {
  DoubleObject doubleValueV1(Integer valueToBeDoubled);
  DoubleObject doubleValueV2(Integer valueToBeDoubled);
  DoubleErrorObject doubleError();

}
