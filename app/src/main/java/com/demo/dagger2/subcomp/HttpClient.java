package com.demo.dagger2.subcomp;

import timber.log.Timber;

/**
 * Created by gagandeep on 7/4/16.
 */
public class HttpClient {

    public void sendScreenNameOnNetwork(String screenName) {
        Timber.d("Screenname, "+screenName+", sent on network");
    }
}
