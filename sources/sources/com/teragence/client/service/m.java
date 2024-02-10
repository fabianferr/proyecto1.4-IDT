package com.teragence.client.service;

import android.content.SharedPreferences;
import com.umlaut.crowd.CCS;

public class m implements g {
    private final SharedPreferences a;

    public m(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public void a(boolean z) {
        if (z) {
            this.a.edit().putLong(ServiceStateConstants.PREF_RUNNING_START_TIME, System.currentTimeMillis()).apply();
        }
        this.a.edit().putBoolean(ServiceStateConstants.PREF_IS_RUNNING, z).apply();
    }

    public boolean a() {
        if (this.a.getBoolean(ServiceStateConstants.PREF_IS_RUNNING, false)) {
            long j = this.a.getLong(ServiceStateConstants.PREF_RUNNING_START_TIME, 0);
            return j > 0 && System.currentTimeMillis() - j < CCS.a;
        }
    }
}
