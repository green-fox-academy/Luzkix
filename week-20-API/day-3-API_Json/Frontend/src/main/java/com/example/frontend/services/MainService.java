package com.example.frontend.services;

import com.example.frontend.models.AppendA;
import com.example.frontend.models.Error;
import com.example.frontend.models.DoubleObject;
import com.example.frontend.models.Greeter;

public interface MainService {
  DoubleObject doubleValueV1(Integer valueToBeDoubled);
  DoubleObject doubleValueV2(Integer valueToBeDoubled);
  Error doubleError();
  Greeter greetingV1(String name, String title, Greeter greeter);
  boolean greetingNotNull(String name, String title);
  Greeter greetingV2(String name, String title);

  AppendA appendA(String appendable);
}
