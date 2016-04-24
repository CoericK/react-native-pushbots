* In `android/settings.gradle`

```gradle
...
include ':react-native-pushbots'
project(':react-native-pushbots').projectDir = new File(settingsDir, '../node_modules/react-native-pushbots/android')
```

* In `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-pushbots')
}
```

* Register Module (in MainActivity.java)

```java
import com.erickarroyo.pushbots.PushbotsPackage;  // <--- import

public class MainActivity extends .... {
  
  ......

    @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                new MainReactPackage(),
                new PushbotsPackage() // <------ add this line to your MainActivity class
        );
    }
  }

  ......
}
```