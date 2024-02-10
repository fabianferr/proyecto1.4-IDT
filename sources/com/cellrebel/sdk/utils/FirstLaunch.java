package com.cellrebel.sdk.utils;

import android.content.SharedPreferences;
import com.cellrebel.sdk.workers.TrackingManager;

public class FirstLaunch {
    private static volatile FirstLaunch c;
    private SharedPreferences a;
    private boolean b;

    private FirstLaunch() {
        if (c == null) {
            this.a = TrackingManager.getContext().getSharedPreferences("options", 0);
            this.b = a();
            a(true);
            return;
        }
        throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
    }

    public void a(boolean z) {
        this.a.edit().putBoolean("was_launched_before", z).apply();
    }

    public boolean a() {
        return this.a.getBoolean("was_launched_before", false);
    }
}
