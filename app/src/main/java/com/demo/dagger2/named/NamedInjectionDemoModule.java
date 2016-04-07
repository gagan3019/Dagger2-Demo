package com.demo.dagger2.named;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import static com.demo.dagger2.named.NamedInjectionDemoActivity.CURRENT_SCREEN_NAME;
import static com.demo.dagger2.named.NamedInjectionDemoActivity.LAST_SCREEN_NAME;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class NamedInjectionDemoModule {

    private String currentScreenName;
    private String lastScreenName;

    public NamedInjectionDemoModule(String currentScreenName, String lastScreenName) {
        this.currentScreenName = currentScreenName;
        this.lastScreenName = lastScreenName;
    }

    @Provides
    @NamedInjectionScope
    @Named(CURRENT_SCREEN_NAME)
    NIDScreenInfo provideCurrentScreenInfo() {
        return new NIDScreenInfo(this.currentScreenName);
    }

    @Provides
    @NamedInjectionScope
    @Named(LAST_SCREEN_NAME)
    NIDScreenInfo provideLastScreenInfo() {
        return new NIDScreenInfo(this.lastScreenName);
    }
}
