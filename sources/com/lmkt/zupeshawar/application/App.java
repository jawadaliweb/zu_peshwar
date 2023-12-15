package com.lmkt.zupeshawar.application;

import android.app.Application;
import com.lmkt.zupeshawar.Utilities.ToastUtil;
import com.lmkt.zupeshawar.networkManager.Urls;

public class App extends Application {
    private static App INSTANCE;

    public static synchronized App getInstance() {
        App app;
        synchronized (App.class) {
            app = INSTANCE;
        }
        return app;
    }

    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        ToastUtil.newInstance(this);
        Urls.SetURL(Urls.Environment.Test);
    }
}
