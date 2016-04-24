# react-native-pushbots
React Native Pushbots for Android and iOS (soon)

## Installation

```bash
npm install react-native-pushbots --save
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


