package com.demo.dagger2.backend.login;

import android.os.Handler;

import com.demo.dagger2.models.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by gagandeep on 6/4/16.
 */
public class BackEndSystem {

    private static final String[][] CREDENTIALS = {{"dagger", "dagger"}, {"android", "android"}};
    private Map<String, String> LOGGED_IN_USERS = new HashMap<>();

    private static final String[][] ACCOUNT_BALANCE = {{"dagger", "2000"}, {"android", "3000"}};


    public Response performLogin(String username, String password) {
        Response response = new Response();
        if (username == null || password == null) {
            response.isSuccess = false;
            response.responseMessage = "Invalid Credentials";
            return response;
        }

        for (String[] credential : CREDENTIALS) {
            if (credential[0].equals(username) && credential[1].equals(password)) {
                String tokenId = generateLoginToken();
                markUserLoggedIn(credential[0], tokenId);
                response.isSuccess = true;
                response.responseMessage = "Login Success";
                response.userId = credential[0];
                response.tokenId = tokenId;
                return response;
            } else {
                response.isSuccess = false;
                response.responseMessage = "Username password did not match";
            }
        }
        return response;
    }

    public Response performLogout(final String userId, String token) {
        Response response = new Response();
        markUserLoggedOut(token);
        response.isSuccess = true;
        response.responseMessage = "Logout Success";
        return response;
    }

    public AccontDetailsResponse fetchBalance(String tokenId) {
        AccontDetailsResponse response = new AccontDetailsResponse();
        String userId = getLoggedInUserId(tokenId);

        if (userId == null) {
            response.isSuccess = false;
            response.responseMessage = "User is not logged in, Invalid Token";
            return response;
        }

        for (String[] account : ACCOUNT_BALANCE) {
            if (account[0].equals(userId)) {
                response.isSuccess = true;
                response.responseMessage = "Success";
                response.accountBalance = account[1];
                return response;
            }
        }

        response.isSuccess = false;
        response.responseMessage = "No Such user exists in database";
        return response;
    }

    private String generateLoginToken() {
        return String.valueOf(System.currentTimeMillis());
    }

    private void markUserLoggedIn(String userId, String token) {
        LOGGED_IN_USERS.put(token, userId);
    }

    private void markUserLoggedOut(String userid) {
        LOGGED_IN_USERS.remove(userid);
    }

    private String getLoggedInUserId(String tokenId) {
        return LOGGED_IN_USERS.get(tokenId);
    }

    public static class AccontDetailsResponse {
        public boolean isSuccess;
        public String responseMessage;
        public String accountBalance;
    }

    public static class Response {
        public boolean isSuccess;
        public String responseMessage;
        public String userId;
        public String tokenId;
    }

}
