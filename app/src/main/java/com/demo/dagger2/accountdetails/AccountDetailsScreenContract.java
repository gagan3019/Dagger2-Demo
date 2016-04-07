package com.demo.dagger2.accountdetails;

import com.demo.dagger2.common.ui.IPresenter;
import com.demo.dagger2.common.ui.IView;
import com.demo.dagger2.models.AccountDetails;

/**
 * Created by gagandeep on 6/4/16.
 */
public final class AccountDetailsScreenContract {
    private AccountDetailsScreenContract() {
    }


    public interface AccountDetailsScreenView extends IView {
        void toggleProgress(boolean visible);

        void setAccountData(AccountDetails accountData);

        void setError(String errorMessage);
    }

    public interface AccountDetailsScreenPresenter extends IPresenter {
        void onAccountDataLoadRequest();
    }
}

