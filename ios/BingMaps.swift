//
//  BingMaps.swift
//  BingMaps
//
//  Created by Akarsh Srivastava on 18/02/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import MicrosoftMaps

class BingMaps: MSMapView {
  
  var mapElementLayer: MSMapElementLayer;
  @objc var onMapPinClicked: RCTDirectEventBlock?;
  @objc var onMapLoadingStatusChanged: RCTDirectEventBlock?;
  @objc var pins: NSArray = [] {
    didSet {
      self.setMapPins(pinData: pins);
    }
  }
  
  @objc var mapLocation:NSDictionary = [:] {
    didSet {
      self.setMapLocation(location: mapLocation);
    }
  }
  
  @objc var mapStyle: NSString = "" {
    didSet {
      var mapStyleSheet: MSMapStyleSheet!;
      MSMapStyleSheet.try(toParseJson: mapStyle as String, into: &mapStyleSheet);
      if mapStyleSheet != nil {
        self.setStyleSheet(mapStyleSheet);
      }
    }
  }
  
  
  override init(frame: CGRect) {
    mapElementLayer = MSMapElementLayer();
    super.init(frame: frame);
    self.credentialsKey = "Ap4QcVrvAUTkJKLM9RbTtRh1MD7Ioqt_QBxubQz3rIaVDskMgVZXQ2ux-NgfO30d";
    self.buildingsVisible = false;
    self.businessLandmarksVisible = false;
    self.transitFeaturesVisible = false;
    self.userInterfaceOptions.compassButtonVisible=false;
    self.userInterfaceOptions.copyrightDisplay = MSCopyrightDisplay.allowHiding;
    self.userInterfaceOptions.tiltButtonVisible = false;
    self.userInterfaceOptions.zoomButtonsVisible = false;
    
    self.layers.add(mapElementLayer);
    
    self.mapElementLayer.addUserDidTapHandler { (cgPoint, msGeopoint, pin) -> Bool in
      self.onPinClicked(geoPoint: msGeopoint, pin: pin)
      return true;
    }
    self.addLoadingStatusDidChangeHandler { (status) -> Bool in
      self.onMapLoadingStatus(status: status);
      return true;
    }
  }
  
  required init?(coder: NSCoder) {
    fatalError("init(coder:) has not been implemented")
  }
  
  func setMapLocation(location: NSDictionary) {
    let mapScene = MSMapScene(location: MSGeopoint(latitude: location.value(forKey: "lat") as! Double, longitude: location.value(forKey: "long") as! Double), zoomLevel: location.value(forKey: "zoom") as! Double);
    self.setScene(mapScene, with: MSMapAnimationKind.linear);
  }
  
  func setMapPins(pinData: NSArray){
    mapElementLayer.elements.clear();
    for pin in pinData {
      let mapPin = MSMapIcon();

      mapPin.location = MSGeopoint(latitude: (pin as! NSDictionary).value(forKey: "lat") as! CLLocationDegrees, longitude: (pin as! NSDictionary).value(forKey: "long") as! CLLocationDegrees);
      let svgString: String = (pin as! NSDictionary).value(forKey: "icon") as! String;
      let svgData = Data(svgString.utf8);
            
      let pinIcon: MSMapImage = MSMapImage.init(fromSvg: svgData);
      
      mapPin.image = pinIcon;
      mapElementLayer.elements.add(mapPin);
    }
    return;
  }
  
  func onMapLoadingStatus(status:MSMapLoadingStatus){
    if self.onMapLoadingStatusChanged != nil{
      self.onMapLoadingStatusChanged!(["status": status.rawValue]);
    }
  }
  
  func onPinClicked (geoPoint: MSGeopoint, pin: NSMutableSet){
    let lat = geoPoint.position.latitude;
    let long = geoPoint.position.longitude;
    let zoom = self.zoomLevel;
    let location: NSDictionary = ["lat": lat, "long":long, "zoom":zoom];

    if self.onMapPinClicked != nil {
      self.onMapPinClicked!(["location": location]);
    }
  }
}
