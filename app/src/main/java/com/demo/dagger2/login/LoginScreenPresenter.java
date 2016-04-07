package com.demo.dagger2.login;

import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.common.Session;
import com.demo.dagger2.login.LoginScreenContract.LoginScreenView;
import com.demo.dagger2.models.User;

import timber.log.Timber;

/**
 * Created by gagandeep on 6/4/16.
 */
public class LoginScreenPresenter implements LoginScreenContract.LoginScreenPresenter {

    private IApi mLoginManager;
    private LoginScreenView mView;
    private Session mSession;

    public LoginScreenPresenter(IApi loginManager, LoginScreenView mView, Session mSession) {
        this.mLoginManager = loginManager;
        this.mView = mView;
        this.mSession = mSession;
    }

    @Override
    public void onLoginCheck() {
        User loggedInUser = mSession.getLoggedInUser();
        if (loggedInUser != null) {
            mView.navigateToAccountDetailScreen();
        }
    }

    @Override
    public void onLoginClicked(String username, String password) {
        Timber.d("Submitting credentials for login");
        mView.toggleProgress(true);
        mLoginManager.login(username, password, new IApi.LoginListener() {
            @Override
            public void onLoginSuccess(User loggedInuser) {
                mView.toggleProgress(false);
                mView.onLoginSuccess(loggedInuser);
                mSession.setLoggedInUser(loggedInuser);
            }

            @Override
            public void onLoginFailure(String errorMessage) {
                mView.toggleProgress(false);
                mView.onLoginFailure(errorMessage);
            }
        });
    }
}
