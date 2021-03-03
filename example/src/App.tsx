import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import BingMapsViewManager from 'react-native-bing-maps';
import { BING_MAPS_KEY } from '@env';

export default function App() {
  return (
    <View style={styles.container}>
      <BingMapsViewManager
        credentialsKey={BING_MAPS_KEY}
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
    height: 700,
    width: 500,
    marginVertical: 20,
  },
});
