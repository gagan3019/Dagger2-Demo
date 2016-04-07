package com.demo.dagger2.common.di;

import android.app.Application;
import android.content.Context;

import com.demo.dagger2.AppController;
import com.demo.dagger2.R;
import com.demo.dagger2.backend.login.BackEndSystem;
import com.demo.dagger2.common.Session;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 6/4/16.
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    Session provideSession() {
        return new Session();
    }

    @Named(AppController.APP_NAME)
    @Provides
    @Singleton
    String provideAppName() {
        return application.getString(R.string.app_name);
    }

}
