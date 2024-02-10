package com.teragence.library;

import android.content.SharedPreferences;

public class g0 implements e0 {
    private final SharedPreferences a;

    public g0(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public d a(d dVar) {
        this.a.edit().putLong("registeredDeviceId", dVar.c()).putLong("deviceMaxAge", dVar.a()).putLong("deviceRegistered", dVar.d()).apply();
        return b();
    }

    public void a() {
        this.a.edit().clear().apply();
    }

    public d b() {
        long j = this.a.getLong("registeredDeviceId", Long.MIN_VALUE);
        if (j != Long.MIN_VALUE) {
            return new a(j, this.a.getLong("deviceMaxAge", 172800000), this.a.getLong("deviceRegistered", 0));
        }
        throw new l("device not found");
    }
}
