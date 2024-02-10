package com.teragence.library;

import android.content.SharedPreferences;

public class o implements m {
    private final SharedPreferences a;

    public o(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public i a(i iVar) {
        this.a.edit().putBoolean("configSaved", true).putString("config.testId", iVar.c().toString()).putInt("config.testInterval", iVar.g()).putInt("config.packetCount", iVar.j()).putInt("config.packetSize", iVar.h()).putInt("config.packetInterval", iVar.i()).putInt("config.serverPort", iVar.f()).putInt("config.maxAge", iVar.a()).putBoolean("config.useFineLocation", iVar.l()).putString("config.serverAddress", iVar.k().getHostAddress()).putString("config.downloadServerAddress", iVar.e().getHostAddress()).putLong("config.downloadTestInterval", iVar.d()).putLong("configLoaded", iVar.n()).apply();
        return iVar;
    }

    public void a() {
        this.a.edit().clear().apply();
    }

    public i b() {
        if (this.a.getBoolean("configSaved", false)) {
            return new j(this.a);
        }
        throw new l("config not found");
    }
}
