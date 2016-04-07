package com.demo.dagger2.scopes;

import com.demo.dagger2.AppController;
import com.demo.dagger2.common.di.AppComponent;

import javax.inject.Named;

import dagger.Component;

/**
 * Created by gagandeep on 7/4/16.
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = {ScopesDemoScreenModule.class})
public interface ScopesDemoScreenComponent {
    //void inject(ScopesDemoActivity activity);

    @Named(ScopesDemoActivity.SCREEN_NAME)
    String screenName();

    @Named(AppController.APP_NAME)
    String appName();
}
