#import <Foundation/Foundation.h>
#import <React/RCTViewManager.h>

@interface RCT_EXTERN_MODULE(BingMapsViewManager, RCTViewManager)
    RCT_EXTERN_METHOD(setMapLocationFromManager:(nonnull NSNumber *)node location:(nonnull NSDictionary *)location);
    RCT_EXTERN_METHOD(setMapPinsFromManager:(nonnull NSNumber *)node pinData:(nonnull NSArray *)pinData);
    RCT_EXPORT_VIEW_PROPERTY(onMapPinClicked, RCTDirectEventBlock);
    RCT_EXPORT_VIEW_PROPERTY(onMapLoadingStatusChanged, RCTDirectEventBlock);
    RCT_EXPORT_VIEW_PROPERTY(pins, NSArray);
    RCT_EXPORT_VIEW_PROPERTY(mapLocation, NSDictionary);
    RCT_EXPORT_VIEW_PROPERTY(mapStyle, NSString);
    RCT_EXPORT_VIEW_PROPERTY(credentialsKey, NSString);
    RCT_EXPORT_VIEW_PROPERTY(buildingsVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(businessLandmarksVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(transitFeaturesVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(compassButtonVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(tiltButtonVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(zoomButtonsVisible, BOOL);
    RCT_EXPORT_VIEW_PROPERTY(copyrightDisplay, NSString);
@end
