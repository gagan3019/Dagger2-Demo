package com.demo.dagger2.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.demo.dagger2.AppController;
import com.demo.dagger2.R;
import com.demo.dagger2.accountdetails.AccountDetailsActivity;
import com.demo.dagger2.common.ui.BaseActivity;
import com.demo.dagger2.models.User;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.OnClick;
import timber.log.Timber;

/**
 * Created by gagandeep on 6/4/16.
 */
public class LoginActivity extends BaseActivity implements LoginScreenContract.LoginScreenView {

    @Inject
    LoginScreenContract.LoginScreenPresenter mPresenter;


    @Bind(R.id.username)
    EditText mUsernameField;

    @Bind(R.id.password)
    EditText mPasswordField;

    @Bind(R.id.login_progress)
    View mProgressView;

    @Bind(R.id.sign_in_button)
    View mLoginButton;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");
    }

    @Override
    public void initComponent() {
        LoginComponent loginComponent = DaggerLoginComponent.builder().appComponent(AppController.get
                (getApplicationContext()).getAppComponent()).loginModule(new LoginModule(this)).build();
        loginComponent.inject(this);
        Timber.d("Init login screen dagger");
    }

    @OnClick(R.id.sign_in_button)
    void onLoginButtonClicked() {
        String errorMessage = validateCredentials();

        if (errorMessage != null) {
            Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
            return;
        }

        String userName = mUsernameField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        mPresenter.onLoginClicked(userName, password);
    }

    @Override
    public void onLoginSuccess(User loggedInUser) {
        Toast.makeText(LoginActivity.this, loggedInUser.toString(), Toast.LENGTH_SHORT).show();
        Timber.d("User Logged in Success : "+loggedInUser);
        navigateToAccountDetailScreen();
    }

    @Override
    public void onLoginFailure(String errorMessage) {
        Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
        Timber.d("user Login Fail : "+errorMessage);
    }

    @Override
    public void toggleProgress(boolean visible) {
        mProgressView.setVisibility(visible?View.VISIBLE:View.GONE);
        mLoginButton.setEnabled(!visible);
    }

    @Override
    public void navigateToAccountDetailScreen() {
        Intent intent = new Intent(getApplicationContext(), AccountDetailsActivity.class);
        startActivity(intent);
        finish();
    }

    private String validateCredentials() {
        String userName = mUsernameField.getText().toString().trim();
        String password = mPasswordField.getText().toString().trim();

        if ("".equals(userName)) {
            return "Username required";
        }

        if ("".equals(password)) {
            return "Password required";
        }

        return null;
    }


}
