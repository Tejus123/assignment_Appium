# Project Title

Sample script for amazon kindle item verficartion

## Getting Started

Before executing the script we have to set up for appium in our local machine ,then add all required  jar to project
 

### Prerequisites

Appium Desktop - https://github.com/appium/appium-desktop/releases/latest
Android Studio (Allows you to install SDK and Emulators) - https://developer.android.com/studio/index.html
XCode - https://developer.apple.com/xcode/


### Installing

Install All required software like appium ,sdk,appium studio and  then set up below paths.
Supported System PropertiesAnd
pathToAppFile - The location of the .ipa/.apk file to use in testing
device.id - The device ID of a real device to run tests against (If it is an iOS device, this must be registered in your iOS developer account)
enableDebugMode - Will set the Appium timeout to 1 hour so that the server doesn't close down while you are trying to debug your tests

## Running the tests

Before running the script make sure below settings to be done :
Android Configuration settings
General Settings
Starting Node server 
Then execute our script in test package using testNG.

In Kindle test scenario validate kindle devices are available for buy or not .

```

### Frame work Implementation
 develop Hybrid framework combination of Page object model and data driven .
 
created 3 packages for pages ,flows and test .

In pages package defined all page method and locators ,
In flow packages have  created classes for  combination of pages 

### Reports 
we can see test results in testng out put folder .