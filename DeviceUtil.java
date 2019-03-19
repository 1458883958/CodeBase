package com.cardplus.mobile.cardplus.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.io.File;

/**
 * 创建时间： 2018/12/24 11:52
 * 描述：    获取手机信息/APP版本工具类
 */
public class DeviceUtil {

    public static String getIMEI(Context context) {
        //IMEI（imei）
        TelephonyManager tm = (TelephonyManager) context.
                getSystemService(Context.TELEPHONY_SERVICE);
        @SuppressLint("MissingPermission")
        String imei = tm.getDeviceId();
        if (!TextUtils.isEmpty(imei)) {
            return imei;
        }
        return null;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        return android.os.Build.MODEL;
    }


    /**
     * 获取版本名
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本号
     *
     * @param context
     * @return
     */
    public static int getVersionCode(Context context) {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }


    /**
     * 获取缓存文件
     *
     * @param context    Context
     * @param uniqueName bitmap/object等
     * @return File
     */
    public static File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            //SD卡存在且不可被移除时，调用getExternalCacheDir()获取缓存地址
            //  cachePath = /sdcard/Android/data/<application package>/cache
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            // cachePath = /data/data/<application package>/cache
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

}
