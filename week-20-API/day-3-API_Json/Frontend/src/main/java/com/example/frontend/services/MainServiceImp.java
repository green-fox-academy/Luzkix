package com.example.frontend.services;

import com.example.frontend.models.DoubleErrorObject;
import com.example.frontend.models.DoubleObject;
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
  public DoubleErrorObject doubleError() {
    return new DoubleErrorObject();
  }
}
