require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-bing-maps"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "10.0" }
  s.source       = { :git => "https://github.com/Akarsh08/react-native-bing-maps.git", :tag => "#{s.version}" }

  
  
  s.source_files = "ios/**/*.{h,m,mm,swift}"
  
  
  s.dependency "React-Core"
  s.dependency 'MicrosoftMapsSDK', '~> 1.1.4'
end
