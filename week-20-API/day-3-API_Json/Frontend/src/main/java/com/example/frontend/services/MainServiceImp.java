package com.example.frontend.services;

import com.example.frontend.models.AppendA;
import com.example.frontend.models.DoUntil;
import com.example.frontend.models.DoUntilResult;
import com.example.frontend.models.ErrorObject;
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
  public ErrorObject doubleError() {
    return new ErrorObject();
  }

  @Override
  public ErrorObject setError(String errorMessage) {
    ErrorObject errorObject = new ErrorObject();
    errorObject.setError(errorMessage);
    return errorObject;
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

  @Override
  public AppendA appendA(String appendable) {
    AppendA append = new AppendA();
    append.setAppended(appendable + "a");
    return append;
  }

  @Override
  public DoUntilResult doUntilResult(String action, DoUntil input) {
    DoUntilResult result = new DoUntilResult();

    if (action.equals("sum")){
      Long calculatedNumber = 0L;
      for(int i=0; i< input.getUntil(); i++) {
        calculatedNumber = calculatedNumber+i+1;
      }
      result.setResult(calculatedNumber);
      return result;
    } else if (action.equals("factor")) {
      Long calculatedNumber = 1L;
      for (int i = 1; i < input.getUntil()+1; i++) {
        calculatedNumber = calculatedNumber * i;
      }
      result.setResult(calculatedNumber);
      return result;
    } else return null;
  }
}
