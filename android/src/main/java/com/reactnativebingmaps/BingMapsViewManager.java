package com.reactnativebingmaps;

import android.app.Activity;

import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.microsoft.maps.CopyrightDisplay;

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

  @ReactProp(name = "buildingsVisible")
  public void setBuildingsVisible(BingMaps bingMaps, Boolean buildingsVisible) {
    bingMaps.setBuildingsVisible(buildingsVisible);
  }

  @ReactProp(name = "businessLandmarksVisible")
  public void setBusinessLandmarksVisible(BingMaps bingMaps, Boolean businessLandmarksVisible) {
    bingMaps.setBusinessLandmarksVisible(businessLandmarksVisible);
  }

  @ReactProp(name = "transitFeaturesVisible")
  public void setTransitFeaturesVisible(BingMaps bingMaps, Boolean transitFeaturesVisible) {
    bingMaps.setTransitFeaturesVisible(transitFeaturesVisible);
  }

  @ReactProp(name = "compassButtonVisible")
  public void setCompassButtonVisible(BingMaps bingMaps, Boolean compassButtonVisible) {
    bingMaps.getUserInterfaceOptions().setCompassButtonVisible(compassButtonVisible);
  }

  @ReactProp(name = "tiltButtonVisible")
  public void setTiltButtonVisible(BingMaps bingMaps, Boolean tiltButtonVisible) {
    bingMaps.getUserInterfaceOptions().setTiltButtonVisible(tiltButtonVisible);
  }
  @ReactProp(name = "zoomButtonsVisible")
  public void setZoomButtonsVisible(BingMaps bingMaps, Boolean zoomButtonsVisible) {
    bingMaps.getUserInterfaceOptions().setZoomButtonsVisible(zoomButtonsVisible);
  }
  @ReactProp(name = "copyrightDisplay")
  public void getUserInterfaceOptions(BingMaps bingMaps, String copyrightDisplay) {
    if(copyrightDisplay == "allowHiding"){
      bingMaps.getUserInterfaceOptions().setCopyrightDisplay(CopyrightDisplay.ALLOW_HIDING);
    } else if(copyrightDisplay == "always") {
      bingMaps.getUserInterfaceOptions().setCopyrightDisplay(CopyrightDisplay.ALWAYS);
    }
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
