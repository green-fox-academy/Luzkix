package com.example.frontend.services;

import com.example.frontend.models.AppendA;
import com.example.frontend.models.ArrayHandler;
import com.example.frontend.models.ArrayHandlerResult;
import com.example.frontend.models.DoUntil;
import com.example.frontend.models.DoUntilResult;
import com.example.frontend.models.ErrorObject;
import com.example.frontend.models.DoubleObject;
import com.example.frontend.models.Greeter;

public interface MainService {
  DoubleObject doubleValueV1(Integer valueToBeDoubled);
  DoubleObject doubleValueV2(Integer valueToBeDoubled);
  ErrorObject doubleError();
  ErrorObject setError(String errorMessage);
  Greeter greetingV1(String name, String title, Greeter greeter);
  boolean greetingNotNull(String name, String title);
  Greeter greetingV2(String name, String title);
  AppendA appendA(String appendable);

  DoUntilResult doUntilResult(String action, DoUntil input);

  ArrayHandlerResult arrayResult(ArrayHandler input);
}
