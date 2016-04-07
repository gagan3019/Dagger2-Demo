package com.demo.dagger2.common;

import com.demo.dagger2.models.User;

/**
 * Created by gagandeep on 6/4/16.
 */
public final class Session {

    private User mLoggedInUser;

    public User getLoggedInUser() {
        return mLoggedInUser;
    }

    public void setLoggedInUser(User mLoggedInUser) {
        this.mLoggedInUser = mLoggedInUser;
    }
}
