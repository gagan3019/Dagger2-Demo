package com.demo.dagger2.scopes;

import com.demo.dagger2.common.di.ScreenScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class ScopesDemoScreenModule {

    private String screenName;

    public ScopesDemoScreenModule(String screenName) {
        this.screenName = screenName;
    }

    @Provides
    @ActivityScope
    @Named(ScopesDemoActivity.SCREEN_NAME)
    String provideScreenName() {
        return this.screenName;
    }
}
