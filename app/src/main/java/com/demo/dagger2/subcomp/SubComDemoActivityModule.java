package com.demo.dagger2.subcomp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class SubComDemoActivityModule {

    private String screenName;

    public SubComDemoActivityModule(String screenName) {
        this.screenName = screenName;
    }

    @Provides
    @ActivityScope
    String provideScreenName() {
        return this.screenName;
    }
}
