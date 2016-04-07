package com.demo.dagger2.accountdetails;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.demo.dagger2.AppController;
import com.demo.dagger2.R;
import com.demo.dagger2.common.ui.BaseActivity;
import com.demo.dagger2.models.AccountDetails;

import javax.inject.Inject;

import butterknife.Bind;

/**
 * Created by gagandeep on 6/4/16.
 */
public class AccountDetailsActivity extends BaseActivity implements AccountDetailsScreenContract
        .AccountDetailsScreenView {

    @Inject
    AccountDetailsScreenContract.AccountDetailsScreenPresenter mPresenter;

    @Bind(R.id.tv_account_balance)
    TextView mBalanceView;

    @Bind(R.id.tv_error_message)
    TextView mErrorMessgaeView;

    @Bind(R.id.main_view)
    View mMainView;

    @Bind(R.id.progress)
    View mProgressView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);
        getSupportActionBar().setTitle("Account Details");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onAccountDataLoadRequest();
    }

    @Override
    public void initComponent() {
        AccountDetailsComponent component = DaggerAccountDetailsComponent.builder().appComponent(AppController
                .get(getApplicationContext()).getAppComponent()).accountDetailsModule(new AccountDetailsModule(this)).build();
        component.inject(this);
    }

    @Override
    public void toggleProgress(boolean visible) {
        mProgressView.setVisibility(visible?View.VISIBLE:View.GONE);
        if (visible) {
            mMainView.setVisibility(View.GONE);
            mErrorMessgaeView.setVisibility(View.GONE);
        }
    }

    @Override
    public void setAccountData(AccountDetails accountData) {
        mBalanceView.setText(accountData.accountBalance);
        mMainView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setError(String errorMessage) {
        mErrorMessgaeView.setVisibility(View.VISIBLE);
        mErrorMessgaeView.setText(errorMessage);
    }
}
