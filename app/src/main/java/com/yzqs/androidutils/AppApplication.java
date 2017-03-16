package com.yzqs.androidutils;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.LogLevel;
import com.orhanobut.logger.Logger;
import com.yzqs.utilslibrary.CrashUtils;
import com.yzqs.utilslibrary.Utils;

/**
 * Created by lixiang on 2017/3/9.
 */

public class AppApplication extends Application {
    public static AppApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        Utils.init(getBaseContext());
        CrashUtils.getInstance().init();
        Logger.init("AppApplication").setLogLevel(LogLevel.FULL);
    }

    public static Context getContext() {
        return mContext;
    }
}
