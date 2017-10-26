package com.codetest.karma.myapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by karma on 25/10/2017.
 */

public class NetworkUtil {
    private ConnectivityManager connMgr;

    public NetworkUtil(Context context) {
        this.connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    public boolean isNetworkOnline() {
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo == null)
            return false;
        return networkInfo.isConnected();
    }
}
