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

* In `manifest/AndroidManifest.xml`

** Add thefollowing permessions and change com.example.sampleapp with your app identifier.


```xml
    <!-- GCM connects to Google Services. -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <!-- GCM requires a Google account. -->
    <uses-permission android:name="android.permission.GET_ACCOUNTS" />
    <uses-permission android:name="android.permission.WAKE_LOCK" />
    <permission android:name="com.example.sampleapp.permission.C2D_MESSAGE" android:protectionLevel="signature" />
    <uses-permission android:name="com.example.sampleapp.permission.C2D_MESSAGE" />
    <!-- This app has permission to register and receive dataf message. -->
    <uses-permission android:name="com.google.android.c2dm.permission.RECEIVE" />
```


** The following intent-filter in your main activity and change co.example.sampleapp with your app identifier: 

```xml
    <intent-filter>
        <action android:name="com.example.sampleapp.MESSAGE" />
        <category android:name="android.intent.category.DEFAULT" />
    </intent-filter>
```


** Add the following activity, reciever and service before the end of your application tag, and in all of the above code change com.example.sampleapp with your app identifier.

```xml
<receiver
	android:name="com.pushbots.google.gcm.GCMBroadcastReceiver"
android:permission="com.google.android.c2dm.permission.SEND" >
    <intent-filter>
        <!-- Receives the actual messages. -->
        <action android:name="com.google.android.c2dm.intent.RECEIVE" />
        <!-- Receives the registration id. -->
        <action android:name="com.google.android.c2dm.intent.REGISTRATION" />
        <category android:name="com.example.sampleapp" />
    </intent-filter>
</receiver>
<receiver android:name="com.pushbots.push.DefaultPushHandler" />
<service android:name="com.pushbots.push.GCMIntentService" />
```

* Go to Res folder -> Values --> Right click and new Resource File and name it `pushbots.xml` with this content. Change your app ID and Sender ID.
** Follow this guide for more reference [Guide on Pushbots.com] (https://pushbots.com/developer/docs/android-configuration)
```xml
    <?xml version="1.0" encoding="utf-8"?>
    <resources>
        <!-- Pushbots Application ID  -->
        <string name="pb_appid">548ef5901d0ab1</string>
        <!-- Project Number in Google console -->
        <string name="pb_senderid">48849973</string>
        <!-- Pushbots Log Level  log Tag "PB2" -->
        <string name="pb_logLevel">DEBUG</string>
    </resources>
```


