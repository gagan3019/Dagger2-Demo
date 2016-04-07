package com.demo.dagger2.named;

import dagger.Component;

/**
 * Created by gagandeep on 7/4/16.
 */
@NamedInjectionScope
@Component(modules = NamedInjectionDemoModule.class)
public interface NamedInjectionDemoComponent {
    void inject(NamedInjectionDemoActivity activity);
}
