package com.teragence.library;

import android.content.SharedPreferences;
import com.teragence.client.b;

public class r0 implements p0 {
    private final SharedPreferences a;

    public r0(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public void a(b bVar) {
        this.a.edit().putLong("receivedCount", this.a.getLong("receivedCount", 0) + ((long) bVar.a)).putLong("receivedSize", this.a.getLong("receivedSize", 0) + ((long) bVar.b)).apply();
    }

    public void b(b bVar) {
        this.a.edit().putLong("transmittedCount", this.a.getLong("transmittedCount", 0) + ((long) bVar.a)).putLong("transmittedSize", this.a.getLong("transmittedSize", 0) + ((long) bVar.b)).apply();
    }
}
