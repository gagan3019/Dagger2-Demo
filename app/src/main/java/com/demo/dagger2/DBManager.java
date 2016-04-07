package com.demo.dagger2;

/**
 * Created by gagandeep on 5/4/16.
 */
public class DBManager {

    public boolean login(String username, String password) {
        if ("root".equalsIgnoreCase(username) && "root".equalsIgnoreCase(password)) {
            return true;
        }
        return false;
    }
}
