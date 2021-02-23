package com.reactnativebingmaps;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class BingMapsModule extends ReactContextBaseJavaModule {
  private final ReactApplicationContext reactContext;

  public BingMapsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "BingMapsView";
  }
}
