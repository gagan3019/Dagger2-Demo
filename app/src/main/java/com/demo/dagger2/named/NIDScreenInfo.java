package com.demo.dagger2.named;

import com.demo.dagger2.common.di.ScreenScope;

import javax.inject.Inject;

/**
 * Created by gagandeep on 7/4/16.
 */
public class NIDScreenInfo {

    public String screenName;

    public NIDScreenInfo(String screenName) {
        this.screenName = screenName;
    }
}
