package com.demo.dagger2.models;

/**
 * Created by gagandeep on 6/4/16.
 */
public class User {
    public String userId;
    public String loginToken;

    public User(String userId, String loginToken) {
        this.userId = userId;
        this.loginToken = loginToken;
    }

    @Override
    public String toString() {
        return this.userId;
    }
}
