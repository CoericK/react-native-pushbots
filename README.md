# react-native-pushbots
React Native Pushbots for Android and iOS (soon)

## Installation

```bash
npm install --save react-native-pushbots
```

### Configure native projects
#### [Android](https://github.com/CoericK/react-native-pushbots/tree/master/android/)

### How to use it
```javascript
import {Pushbots, PushbotsManager} from 'react-native-pushbots'

PushbotsManager.regID()
  .then(function(devicePushID){
    console.log(devicePushID)
  })
  .catch(function(err){
    console.log(err)
  })
```


### SDK Method Mappings

| RN Methods  | Android  | IOS  |
|---|---|---|
| **regID()** <br/> returns: Promise  |  regID |  X |
| **setAlias(String)** <br/> returns: void  |  setAlias |  X |
| **tag(String)** <br/> returns: void  |  tag |  X |
| **untag(String)** <br/> returns: void   |  untag |  X |
| **debug(Boolean)** <br/> returns: void   |  debug |  X |
| **toggleNotifications(Boolean)** <br/> returns: void   |  setNotificationEnabled |  X |


### Useful Links
- [Pushbots Android API Docs](https://pushbots.com/developer/docs/android-api-reference)
