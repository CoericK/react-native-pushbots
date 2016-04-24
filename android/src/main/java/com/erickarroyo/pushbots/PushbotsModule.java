package com.erickarroyo.pushbots;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.pushbots.push.Pushbots;

public class PushbotsModule extends ReactContextBaseJavaModule {

    public static final String REACT_CLASS = "Pushbots";


    public PushbotsModule(ReactApplicationContext reactContext) {
        super(reactContext);
        Pushbots.sharedInstance().init(reactContext.getApplicationContext());
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }
}
