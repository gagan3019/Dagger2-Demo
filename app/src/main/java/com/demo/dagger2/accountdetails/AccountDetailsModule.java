package com.demo.dagger2.accountdetails;

import com.demo.dagger2.accountdetails.AccountDetailsScreenContract.AccountDetailsScreenView;
import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.common.Session;
import com.demo.dagger2.common.di.ScreenScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gagandeep on 6/4/16.
 */
@Module
public class AccountDetailsModule {

    private AccountDetailsScreenView mView;

    public AccountDetailsModule(AccountDetailsScreenView mView) {
        this.mView = mView;
    }

    @Provides
    @ScreenScope
    AccountDetailsScreenContract.AccountDetailsScreenPresenter providePresenter(Session session, IApi api) {
        return new AccountDetailsPresenter(mView, api, session);
    }

}
