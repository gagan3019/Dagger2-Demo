package com.demo.dagger2.scopes;

import dagger.Component;

/**
 * Created by gagandeep on 7/4/16.
 */
@RefreshedSessionScope
@Component(dependencies = ScopesDemoScreenComponent.class,modules = ScopesDemoTimeSessionModule.class)
public interface ScopesDemoTimeComponent {
    void inject(ScopesDemoActivity activity);
}
