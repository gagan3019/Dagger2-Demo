package com.demo.dagger2.backend.login;

import android.os.Handler;

import com.demo.dagger2.models.AccountDetails;
import com.demo.dagger2.models.User;

/**
 * Created by gagandeep on 6/4/16.
 */
public class AsyncApi implements IApi {

    private BackEndSystem mBackEndSystem;
    private static final int TIME_OUT = 5000;

    public AsyncApi(BackEndSystem mBackEndSystem) {
        this.mBackEndSystem = mBackEndSystem;
    }

    @Override
    public void login(final String username, final String password, final LoginListener loginListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackEndSystem.Response loginResponse = mBackEndSystem.performLogin(username, password);
                if (!loginResponse.isSuccess) {
                    if (loginListener != null) {
                        loginListener.onLoginFailure(loginResponse.responseMessage);
                    }
                    return;
                } else {
                    if (loginListener != null) {
                        User loggedInUser = new User(loginResponse.userId, loginResponse.tokenId);
                        loginListener.onLoginSuccess(loggedInUser);
                    }
                }

            }
        }, TIME_OUT);
    }

    @Override
    public void logout(String userId, String token, LogoutListener logoutListener) {
        performLogout(userId, token, logoutListener);
    }

    @Override
    public void getBalance(final String tokenId, final AccountDetailsListener accountDetailsListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackEndSystem.AccontDetailsResponse response = mBackEndSystem.fetchBalance(tokenId);
                if (response.isSuccess) {
                    if (accountDetailsListener != null) {
                        AccountDetails accountDetails = new AccountDetails(response.accountBalance);
                        accountDetailsListener.onSuccess(accountDetails);
                    }
                } else {
                    if (accountDetailsListener != null) {
                        accountDetailsListener.onFailure(response.responseMessage);
                    }
                }
            }
        },TIME_OUT);
    }


    private void performLogout(final String userId, final String token, final LogoutListener logoutListener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                BackEndSystem.Response logoutResponse = mBackEndSystem.performLogout(userId, token);
                if (logoutListener != null && logoutResponse.isSuccess) {
                    logoutListener.onLogout();
                }
            }
        },TIME_OUT);
    }
}
