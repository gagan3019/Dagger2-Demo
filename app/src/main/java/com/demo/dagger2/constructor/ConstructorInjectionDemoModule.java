package com.demo.dagger2.constructor;

import com.demo.dagger2.common.di.ScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class ConstructorInjectionDemoModule {

    private String screenName;

    public ConstructorInjectionDemoModule(String screenName) {
        this.screenName = screenName;
    }

    @Provides
    @ConstructorInjectionScope
    String provideScreenName() {
        return this.screenName;
    }
}
