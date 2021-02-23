import {
  NativeSyntheticEvent,
  requireNativeComponent,
  ViewStyle,
} from 'react-native';
import type { MapLocation, MapPin } from './types';

type BingMapsProps = {
  onMapPinClicked?: (e: NativeSyntheticEvent<EventTarget>) => void;
  onMapLoadingStatusChanged?: (e: NativeSyntheticEvent<EventTarget>) => void;
  pins?: MapPin[];
  mapLocation?: MapLocation;
  mapStyle?: string;
  style?: ViewStyle;
  credentialsKey: string;
};

export const BingMapsViewManager = requireNativeComponent<BingMapsProps>(
  'BingMapsView'
);

export default BingMapsViewManager;
