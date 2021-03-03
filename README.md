# **React Native Bing Maps**

A React Native wrapper for Microsoft Bing Maps.

[![Example Screenshot](https://github.com/GeekyAnts/react-native-bing-maps/blob/master/example/Screenshot.png?raw=true 'Example Screenshot')](https://github.com/GeekyAnts/react-native-bing-maps/blob/master/example/Screenshot.png?raw=true 'Example Screenshot')

## TOC

- [Installation](#installation)
- [Linking](#linking)
- [Usage](#usage)
- [Props](#props)
- [Types](#types)

## Installation

Using npm:

```shell
npm install --save react-native-bing-maps
```

Using yarn:

```shell
yarn add react-native-bing-maps
```

## Linking

Automatic linking is supported for all platforms (even windows on React native >= 0.63!)

Previous versions need to do manual linking. No support is offered for these previous react-native versions. Upgrade to modern versions of react-native. Use `upgrade-helper` tool on the internet if needed.

### Bing Maps Key

Bing Maps Key. Must be obtained to use the Bing Maps SDK. The Bing Maps Key will need to be set through the API to use the Bing Maps native control and to make API requests to Bing Maps services. Visit the [Bing Maps Dev Center Help page](https://docs.microsoft.com/en-us/bingmaps/getting-started/bing-maps-dev-center-help/getting-a-bing-maps-key 'Bing Maps Dev Center Help page') for detailed steps on obtaining one.

### Android credentials setup

In order to use Bing Maps on android you need to add the credential key to gradle.

1. create a `secrets.gradle` file in `android/app/` folder with the following contents

```groovy
ext.credentialsKey = "you_bing_maps_key_here"
```

2. apply this key in your `android/app/build.gradle` file by adding

```groovy
apply from: 'secrets.gradle'
```

at the top.

3. now add the key to the builds by adding

```groovy
buildTypes.each {
        it.buildConfigField "String", "CREDENTIALS_KEY", "\"$credentialsKey\""
    }
```

in the `android` field next to `defaultConfig`. This will apply the same key to all build types.

##### OR

for separate creadential key for build types you can add it respective build type config

## Usage

```ts
import * as React from 'react';

import { StyleSheet, View } from 'react-native';
import BingMapsView from 'react-native-bing-maps';

export default function App() {
  return (
    <View style={styles.container}>
      <BingMapsView
        credentialsKey="your_bing_maps_api_key"
        mapLocation={{ lat: 12.9010875, long: 77.6095084, zoom: 15 }}
        style={styles.box}
      />
    </View>
  );
}
```

## Props

- [credentialsKey](#credentialsKey)
- [mapLocation](#mapLocation)
- [pins](#pins)
- [mapStyle](#mapStyle)
- [style](#style)
- [onMapPinClicked](#onMapPinClicked)
- [onMapLoadingStatusChanged](#onMapLoadingStatusChanged)

#### credentialsKey [iOS]: string (Required)

Bing Map key accquired from above steps.

#### mapLocation?: MapLocation

describes the currect location of the map. The MapLocation type is described [here](#maplocation)

#### pins?: MapPin[]

Array of pins to be displayed on the map. The MapPin type is described [here](#mappin).

#### mapStyle?: string

string in JSON format to change the appearance of the map. Refer [How to change Appearance](https://docs.microsoft.com/en-us/bingmaps/sdk-native/map-control-concepts/change-map-appearance 'How to change Appearance') of map for detailed info. Or you can use [map stylesheet generator](https://www.microsoft.com/en-in/p/map-style-sheet-editor/9nbhtcjt72ft?rtc=1&activetab=pivot:overviewtab 'map stylesheet generator') to generate the JSON.

#### style?: ViewStyle

Style to be applied to the parent view of Bing Map view.

#### onMapPinClicked?: (e: NativeSyntheticEvent) => void

Event returns `lat` and `long` of the pin clicked on map.

#### onMapLoadingStatusChanged?: (e: NativeSyntheticEvent) => void

Event returns the loading status of the map.

## Types

- [BingMapsProps](#BingMapsProps)
- [MapLocation](#MapLocation)
- [MapPin](#MapPin)

#### BingMapsProps

```ts
type BingMapsProps = {
  credentialsKey: string;
  pins?: MapPin[];
  mapLocation?: MapLocation;
  mapStyle?: string;
  style?: ViewStyle;
  onMapPinClicked?: (e: NativeSyntheticEvent<EventTarget>) => void;
  onMapLoadingStatusChanged?: (e: NativeSyntheticEvent<EventTarget>) => void;
};
```

#### MapLocation

```ts
MapLocation {
  lat: number;
  long: number;
  zoom: number;
}
```

Where `zoom` is a number between 1 and 19. For more info on zoom levels visit Microsoft's docs on [Understanding Scale and Resolutions](https://docs.microsoft.com/en-us/bingmaps/articles/understanding-scale-and-resolution 'Understanding Scale and Resolutions')

#### MapPin

```ts
MapPin {
  lat: number;
  long: number;
  icon: string;
}
```

where `icon` is the SVG string for the pin icon you want to display;

## License

MIT
