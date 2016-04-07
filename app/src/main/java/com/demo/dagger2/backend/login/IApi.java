package com.demo.dagger2.backend.login;

import com.demo.dagger2.models.AccountDetails;
import com.demo.dagger2.models.User;

/**
 * Created by gagandeep on 6/4/16.
 */
public interface IApi {

    void login(String username, String password, LoginListener loginListener);

    void logout(String userId, String token,LogoutListener logoutListener);

    void getBalance(String tokenId,AccountDetailsListener accountDetailsListener);

    public interface LoginListener {
        void onLoginSuccess(User loggedInuser);

        void onLoginFailure(String errorMessage);
    }

    public interface LogoutListener {
        void onLogout();
    }

    public interface AccountDetailsListener {
        void onSuccess(AccountDetails accountDetails);

        void onFailure(String errorMessage);
    }


}
