package com.demo.dagger2.common.di;

import com.demo.dagger2.backend.login.BackEndSystem;
import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.backend.login.AsyncApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 6/4/16.
 */
@Module
public class BackEndSystemModule {

    @Provides
    @Singleton
    IApi provideLoginManager(BackEndSystem backEndSystem) {
        return new AsyncApi(backEndSystem);
    }

    @Provides
    @Singleton
    BackEndSystem provideBackendSystem() {
        return new BackEndSystem();
    }
}
