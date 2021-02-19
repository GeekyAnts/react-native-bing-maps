//
//  BingMapsViewManager.swift
//  BingMaps
//
//  Created by Akarsh Srivastava on 19/02/21.
//  Copyright © 2021 Facebook. All rights reserved.
//

import Foundation
import MicrosoftMaps
import MapKit

@objc(BingMapsViewManager)
class BingMapsViewManager: RCTViewManager {
  
  override static func requiresMainQueueSetup() -> Bool {
    return true;
  }
  
  override func view() -> UIView! {
    return BingMaps(frame: self.accessibilityFrame);
  }
  
  @objc func setMapPinsFromManager(_ node: NSNumber, pinData: NSArray) {
    DispatchQueue.main.async {
      let component = self.bridge.uiManager.view(
        forReactTag: node
      ) as! BingMaps;
      component.setMapPins(pinData: pinData);
    }
  }
  
  
  @objc func setMapLocationFromManager(_ node: NSNumber, location: NSDictionary) {
    DispatchQueue.main.async {
      let component = self.bridge.uiManager.view(
        forReactTag: node
        ) as! BingMaps;
      component.setMapLocation(location: location);
    }
  }
  
}
