package com.demo.dagger2.login;

import com.demo.dagger2.common.di.AppComponent;
import com.demo.dagger2.common.di.ScreenScope;

import dagger.Component;

/**
 * Created by gagandeep on 6/4/16.
 */
@ScreenScope
@Component(dependencies = AppComponent.class,modules = LoginModule.class)
public interface LoginComponent {
    void inject(LoginActivity loginActivity);
}
