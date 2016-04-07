package com.demo.dagger2.constructor;

import com.demo.dagger2.common.di.ScreenScope;

import javax.inject.Inject;

/**
 * Constructor Injection Demo Screen Info
 */
@ConstructorInjectionScope
public class CIDScreenInfo {

    public String screenName;

    @Inject
    public CIDScreenInfo(String screenName) {
        this.screenName = screenName;
    }
}
