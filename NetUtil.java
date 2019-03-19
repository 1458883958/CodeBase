package com.cardplus.mobile.cardplus.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * 创建时间： 2018/12/26 13:52
 * 描述：    判断网络是否链接
 */
@SuppressWarnings("unused")
public class NetUtil {
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager manager = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null)
            return info.isAvailable();
        else
            return false;
    }
}
