package com.demo.dagger2.accountdetails;

import com.demo.dagger2.backend.login.IApi;
import com.demo.dagger2.common.Session;
import com.demo.dagger2.models.AccountDetails;

/**
 * Created by gagandeep on 6/4/16.
 */
public class AccountDetailsPresenter implements AccountDetailsScreenContract.AccountDetailsScreenPresenter {

    private AccountDetailsScreenContract.AccountDetailsScreenView mView;
    private IApi mApi;
    private Session mSession;

    public AccountDetailsPresenter(AccountDetailsScreenContract.AccountDetailsScreenView mView, IApi mApi, Session mSession) {
        this.mView = mView;
        this.mApi = mApi;
        this.mSession = mSession;
    }

    @Override
    public void onAccountDataLoadRequest() {
        mView.toggleProgress(true);
        String tokenId = mSession.getLoggedInUser().loginToken;
        mApi.getBalance(tokenId, new IApi.AccountDetailsListener() {
            @Override
            public void onSuccess(AccountDetails accountDetails) {
                mView.toggleProgress(false);
                mView.setAccountData(accountDetails);
            }

            @Override
            public void onFailure(String errorMessage) {
                mView.toggleProgress(false);
                mView.setError(errorMessage);
            }
        });


    }
}
