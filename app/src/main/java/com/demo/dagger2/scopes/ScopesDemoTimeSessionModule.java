package com.demo.dagger2.scopes;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class ScopesDemoTimeSessionModule {

    private String time;

    public ScopesDemoTimeSessionModule(String time) {
        this.time = time;
    }

    @Provides
    @RefreshedSessionScope
    @Named(ScopesDemoActivity.CURRENT_TIME)
    String provideCurrentTime() {
        return this.time;
    }
}
