package com.demo.dagger2.subcomp;

import dagger.Subcomponent;

/**
 * Created by gagandeep on 7/4/16.
 */
@NetScope
@Subcomponent(modules = SubCompDemoNetModule.class)
public interface SubCompDemoNetComponent {
    void inject(SubComponentDemoActivity activity);
}
