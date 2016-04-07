package com.demo.dagger2.constructor;

import dagger.Component;

/**
 * Created by gagandeep on 7/4/16.
 */
@ConstructorInjectionScope
@Component(modules = ConstructorInjectionDemoModule.class)
public interface ConstructorInjectionDemoComponent {
    CIDScreenInfo screenInfo();
}
