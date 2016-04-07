package com.demo.dagger2.login;

import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.common.Session;
import com.demo.dagger2.common.di.ScreenScope;
import com.demo.dagger2.login.LoginScreenContract.LoginScreenView;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 6/4/16.
 */
@Module
public class LoginModule {
    private LoginScreenView mView;

    public LoginModule(LoginScreenView mView) {
        this.mView = mView;
    }

    @Provides
    @ScreenScope
    LoginScreenContract.LoginScreenPresenter provideLoginScreenPresenter(IApi loginManager, Session session) {
        return new LoginScreenPresenter(loginManager, mView, session);
    }
}
