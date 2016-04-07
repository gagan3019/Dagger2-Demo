package com.demo.dagger2.subcomp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 7/4/16.
 */
@Module
public class SubCompDemoNetModule {

    @Provides
    @NetScope
    HttpClient provideHttpClient() {
        return new HttpClient();
    }
}
