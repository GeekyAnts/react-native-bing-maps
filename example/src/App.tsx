import * as React from 'react';
import { Dimensions } from 'react-native';

const { width, height } = Dimensions.get('window');

import { StyleSheet, View } from 'react-native';
import BingMapsViewManager from 'react-native-bing-maps';
import { BING_MAPS_KEY } from '@env';

export default function App() {
  return (
    <View style={styles.container}>
      <BingMapsViewManager
        credentialsKey={BING_MAPS_KEY}
        buildingsVisible={true}
        businessLandmarksVisible={true}
        compassButtonVisible={true}
        transitFeaturesVisible={true}
        tiltButtonVisible={true}
        zoomButtonsVisible={true}
        copyrightDisplay="always"
        mapLocation={{ lat: 12.9010875, long: 77.6095084, zoom: 15 }}
        style={styles.box}
      />
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    height: height,
    width: width,
    marginVertical: 20,
  },
});
