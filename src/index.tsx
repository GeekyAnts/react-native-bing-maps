import { requireNativeComponent, ViewStyle } from 'react-native';

type BingMapsProps = {
  color: string;
  style: ViewStyle;
};


export const BingMapsViewManager = requireNativeComponent<BingMapsProps>(
  'BingMapsView'
);

export default BingMapsViewManager;
