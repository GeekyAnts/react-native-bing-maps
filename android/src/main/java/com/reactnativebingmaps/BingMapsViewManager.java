package com.reactnativebingmaps;

import android.app.Activity;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import java.util.Map;

public class BingMapsViewManager extends SimpleViewManager<BingMaps> {
  @Override
  public String getName() {
    return "BingMapsView";
  }

//    private static final Geopoint location = new Geopoint(12.9063622, 77.6049138);  // your pin lat-long coordinates

  @ReactProp(name = "pins")
  public void setPins(BingMaps bingMaps, ReadableArray pins) {
    bingMaps.setPins(pins);
  }

  @ReactProp(name = "mapLocation")
  public void setmapLocation(BingMaps bingMaps, ReadableMap location) {
    bingMaps.setMapLocation(location);
  }

  @ReactProp(name = "mapStyle")
  public void setmapStyle(BingMaps bingMaps, String styleJSON) {
    bingMaps.setMapStyle(styleJSON);
  }

  @Override
  @Nullable
  public Map getExportedCustomBubblingEventTypeConstants(){
    return MapBuilder.builder().put("onMapPinClicked", MapBuilder.of("phasedRegistrationNames",MapBuilder.of("bubbled", "onMapPinClicked"))).put("onMapLoadingStatusChanged", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onMapLoadingStatusChanged"))).build();
  }

  @Override
  protected BingMaps createViewInstance(ThemedReactContext reactContext) {
    Activity activity = reactContext.getCurrentActivity();
    return new BingMaps(activity, reactContext);
  }
}
