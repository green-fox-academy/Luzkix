package com.example.frontend.services;

import com.example.frontend.models.Error;
import com.example.frontend.models.DoubleObject;
import com.example.frontend.models.Greeter;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImp implements MainService {

  @Override
  public DoubleObject doubleValueV1(Integer valueToBeDoubled) {
    DoubleObject doubled = new DoubleObject();
    if(valueToBeDoubled == null) {
      doubled.setError("Please provide an input!");
      return doubled;
    } else {
      Integer doubledValue = valueToBeDoubled*2;
      doubled.setReceived(valueToBeDoubled);
      doubled.setResult(doubledValue);
      return doubled;
    }
  }

  @Override
  public DoubleObject doubleValueV2(Integer valueToBeDoubled) {
    DoubleObject doubled = new DoubleObject();
    try{
      Integer doubledValue = valueToBeDoubled*2;
      doubled.setReceived(valueToBeDoubled);
      doubled.setResult(doubledValue);
      return doubled;
    }catch (NullPointerException e) {
      return null;
    }
  }

  @Override
  public Error doubleError() {
    return new Error();
  }

  @Override
  public Greeter greetingV1(String name, String title, Greeter greeter) {
    if(name == null && title == null) {
      greeter.setError("Please provide a name and a title!");
      return null;
    } else if (name == null) {
      greeter.setError("Please provide a name!");
      return null;
    } else if (title == null) {
      greeter.setError("Please provide a title!");
      return null;
    } else {
      String welcomeMessage = "Oh, hi there " + name + ", my dear " + title + "!";
      greeter.setWelcome_message(welcomeMessage);
      return greeter;
    }
  }

  @Override
  public boolean greetingNotNull(String name, String title) {
    return name != null && title != null;
  }

  @Override
  public Greeter greetingV2(String name, String title) {
    Greeter greeter = new Greeter();
    if(name == null && title == null) {
      greeter.setError("Please provide a name and a title!");
      return greeter;
    } else if (name == null) {
      greeter.setError("Please provide a name!");
      return greeter;
    } else if (title == null) {
      greeter.setError("Please provide a title!");
      return greeter;
    } else {
      String welcomeMessage = "Oh, hi there " + name + ", my dear " + title + "!";
      greeter.setWelcome_message(welcomeMessage);
      return greeter;
    }
  }
}
