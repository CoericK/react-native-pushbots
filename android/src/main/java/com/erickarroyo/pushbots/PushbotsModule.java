package com.erickarroyo.pushbots;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
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

    @ReactMethod
    public void regID(Promise promise){
        try{
            promise.resolve(Pushbots.sharedInstance().regID());
        }catch(Exception ex){
            promise.reject(ex);
        }
    }

    @ReactMethod
    public void setAlias(String alias){
        if(alias != null && !alias.isEmpty()){
            Pushbots.sharedInstance().setAlias(alias);
        }
    }

    @ReactMethod
    public void tag(String value){
        if(value != null && !value.isEmpty()){
            Pushbots.sharedInstance().tag(value);
        }
    }

    @ReactMethod
    public void untag(String value){
        if(value != null && !value.isEmpty()){
            Pushbots.sharedInstance().untag(value);
        }
    }

    @ReactMethod
    public void debug(Boolean value){
        if(value == null){
            value = false;
        }
        Pushbots.sharedInstance().debug(value);
    }

    @ReactMethod
    public void toggleNotifications(Boolean value){
        if(value == null){
            value = false;
        }
        Pushbots.sharedInstance().setNotificationEnabled(value);
    }

}
