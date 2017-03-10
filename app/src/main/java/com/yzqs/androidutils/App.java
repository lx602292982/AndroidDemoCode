package com.yzqs.androidutils;

import android.app.Application;
import android.content.Context;

import com.yzqs.utilslibrary.CrashUtils;
import com.yzqs.utilslibrary.Utils;


/**
 * Created by lixiang on 2017/3/9.
 */

public class App extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(getApplicationContext());
        CrashUtils.getInstance().init();
    }

    public static Context getContext() {
        return mContext;
    }
}
