import {
  NativeSyntheticEvent,
  requireNativeComponent,
  ViewStyle,
} from 'react-native';
import type { MapLocation, MapPin } from './types';

type BingMapsProps = {
  credentialsKey: string;
  pins?: MapPin[];
  mapLocation?: MapLocation;
  mapStyle?: string;
  style?: ViewStyle;
  buildingsVisible?: boolean;
  businessLandmarksVisible?: boolean;
  transitFeaturesVisible?: boolean;
  compassButtonVisible?: boolean;
  tiltButtonVisible?: boolean;
  zoomButtonsVisible?: boolean;
  copyrightDisplay?: 'allowHiding' | 'always';
  onMapPinClicked?: (e: NativeSyntheticEvent<EventTarget>) => void;
  onMapLoadingStatusChanged?: (e: NativeSyntheticEvent<EventTarget>) => void;
};

export const BingMapsViewManager = requireNativeComponent<BingMapsProps>(
  'BingMapsView'
);

export default BingMapsViewManager;
