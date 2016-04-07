package com.demo.dagger2.login;

import com.demo.dagger2.common.ui.IPresenter;
import com.demo.dagger2.common.ui.IView;
import com.demo.dagger2.models.User;

/**
 * Created by gagandeep on 6/4/16.
 */
public final class LoginScreenContract {
    private LoginScreenContract() {
    }

    public interface LoginScreenView extends IView {
        void onLoginSuccess(User loggedInUser);

        void onLoginFailure(String errorMessage);

        void toggleProgress(boolean visible);

        void navigateToAccountDetailScreen();
    }

    public interface LoginScreenPresenter extends IPresenter {
        void onLoginCheck();
        void onLoginClicked(String username,String password);
    }


}