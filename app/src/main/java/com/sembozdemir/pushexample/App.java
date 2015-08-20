package com.sembozdemir.pushexample;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by semih on 8/20/15.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, "YOUR APP ID", "YOUR CLIENT KEY");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
