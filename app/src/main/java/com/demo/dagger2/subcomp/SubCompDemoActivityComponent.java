package com.demo.dagger2.subcomp;

import dagger.Component;

/**
 * Created by gagandeep on 7/4/16.
 */
@ActivityScope
@Component(modules = SubComDemoActivityModule.class)
public interface SubCompDemoActivityComponent {
    SubCompDemoNetComponent plus(SubCompDemoNetModule module);
}
