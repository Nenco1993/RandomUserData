package com.example.neven.randomuserdata;

import android.app.Application;
import com.example.neven.randomuserdata.dagger.components.AppComponent;
import com.example.neven.randomuserdata.dagger.components.DaggerAppComponent;

/**
 * Created by Neven on 6.4.2017..
 */
public class MyApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
