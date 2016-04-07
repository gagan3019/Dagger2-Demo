package com.demo.dagger2.common.di;

import com.demo.dagger2.AppController;
import com.demo.dagger2.backend.login.BackEndSystem;
import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.common.Session;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by gagandeep on 6/4/16.
 */
@Singleton
@Component(modules = {AppModule.class,BackEndSystemModule.class})
public interface AppComponent {

    IApi loginManager();

    Session session();

    BackEndSystem backEndSystem();

    @Named(AppController.APP_NAME)
    String appName();
}
