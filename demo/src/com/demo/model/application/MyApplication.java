package com.demo.model.application;

import android.app.Application;

/**
 * Created by Administrator on 14-3-7.
 */
public class MyApplication extends Application {
    private static MyApplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
