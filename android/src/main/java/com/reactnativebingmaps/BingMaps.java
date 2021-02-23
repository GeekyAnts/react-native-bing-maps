package com.reactnativebingmaps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.PictureDrawable;
import android.util.Log;
import android.widget.FrameLayout;

import com.caverock.androidsvg.SVG;
import com.caverock.androidsvg.SVGParseException;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.microsoft.maps.Geopoint;
import com.microsoft.maps.MapAnimationKind;
import com.microsoft.maps.MapElementLayer;
import com.microsoft.maps.MapElementTappedEventArgs;
import com.microsoft.maps.MapIcon;
import com.microsoft.maps.MapImage;
import com.microsoft.maps.MapLoadingStatus;
import com.microsoft.maps.MapScene;
import com.microsoft.maps.MapStyleSheet;
import com.microsoft.maps.MapView;
import com.microsoft.maps.OnMapElementTappedListener;
import com.microsoft.maps.OnMapLoadingStatusChangedListener;

public class BingMaps extends MapView {
  MapElementLayer mapElementLayer;
  MapStyleSheet mapStyleSheet;
  BingMaps that;

  public void setMapStyle(String styleJSON){
    mapStyleSheet = MapStyleSheet.fromJson(styleJSON);

    if (mapStyleSheet != null){
      this.setMapStyleSheet(mapStyleSheet);
    } else {
      Log.d("INVALID JSON", "RNBingMapsView: ");
    }
  }

  public void setPins(ReadableArray pins) {
    mapElementLayer.getElements().clear();
    for (int i =0 ; i < pins.size(); i++) {
      ReadableMap pin = pins.getMap(i);
      double latitude = pin.getDouble("lat");
      double longitude = pin.getDouble("long");
      String icon = pin.getString("icon");
      SVG svg = null;
      try {
        svg = SVG.getFromString(icon);
      } catch (SVGParseException e) {
        e.printStackTrace();
      }
      svg.setDocumentHeight(70);
      svg.setDocumentWidth(70);
      PictureDrawable drawable = new PictureDrawable(svg.renderToPicture());
      Bitmap pinBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      Canvas canvas = new Canvas(pinBitmap);
      canvas.drawPicture(drawable.getPicture());

      Geopoint pinLocation = new Geopoint(latitude, longitude);

      MapIcon pushPin = new MapIcon();
      MapImage mapImage = new MapImage(pinBitmap);

      pushPin.setLocation(pinLocation);
      pushPin.setImage(mapImage);

      mapElementLayer.getElements().add(pushPin);
    }
  }

  public void setMapLocation(ReadableMap location){
    double lat = location.getDouble("lat");
    double lon = location.getDouble("long");
    int zoomLevel = location.getInt("zoom");

    this.setScene(MapScene.createFromLocationAndZoomLevel(new Geopoint(lat, lon), zoomLevel), MapAnimationKind.LINEAR);
  }

  public BingMaps(Context context) {
    super(context);
  }

  public BingMaps(Context context, final ReactContext reactContext) {
    super(context);
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
    this.setLayoutParams(layoutParams);
    this.setBuildingsVisible(false);
    this.setBusinessLandmarksVisible(false);
    this.setTransitFeaturesVisible(false);
    this.getUserInterfaceOptions().setCompassButtonVisible(false);
    this.getUserInterfaceOptions().setTiltButtonVisible(false);
    this.getUserInterfaceOptions().setZoomButtonsVisible(false);
    that=this;
    mapElementLayer = new MapElementLayer();

//    this.addOnMapLoadingStatusChangedListener(new OnMapLoadingStatusChangedListener() {
//      @Override
//      public boolean onMapLoadingStatusChanging(MapLoadingStatus mapLoadingStatus) {
//        WritableMap event = Arguments.createMap();
//        int status = mapLoadingStatus.ordinal();
//        event.putInt("status", status);
//
//        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//          getId(),
//          "onMapLoadingStatusChanged",
//          event
//        );
//        return true;
//      }
//    });

//    mapElementLayer.addOnMapElementTappedListener(new OnMapElementTappedListener() {
//      @Override
//      public boolean onMapElementTapped(MapElementTappedEventArgs mapElementTappedEventArgs) {
//
//        double lat = mapElementTappedEventArgs.location.getPosition().getLatitude();
//        double lon = mapElementTappedEventArgs.location.getPosition().getLongitude();
//        double zoomLevel  = that.getZoomLevel();
//
//        WritableMap event = Arguments.createMap();
//        WritableMap location = Arguments.createMap();
//        location.putDouble("lat", lat);
//        location.putDouble("long", lon);
//        location.putDouble("zoom", zoomLevel);
//        event.putMap("location", location);
//
//        reactContext.getJSModule(RCTEventEmitter.class).receiveEvent(
//          getId(),
//          "onMapPinClicked",
//          event
//        );
//        return true;
//      }
//    });
    this.getLayers().add(mapElementLayer);

  }

}
