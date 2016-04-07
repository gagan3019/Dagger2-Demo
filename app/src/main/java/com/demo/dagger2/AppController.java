package com.demo.dagger2;

import android.app.Application;
import android.content.Context;

import com.demo.dagger2.common.di.AppComponent;
import com.demo.dagger2.common.di.AppModule;
import com.demo.dagger2.common.di.DaggerAppComponent;

import timber.log.Timber;

/**
 * Created by gagandeep on 6/4/16.
 */
public class AppController extends Application {

    public static final String APP_NAME = "APP_NAME";

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
        initAppComponent();
    }

    private void initAppComponent() {
        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    public static AppController get(Context context) {
        return (AppController) context.getApplicationContext();
    }


}
