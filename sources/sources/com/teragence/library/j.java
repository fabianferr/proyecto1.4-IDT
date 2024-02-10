package com.teragence.library;

import android.content.SharedPreferences;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

public class j implements i {
    private final SharedPreferences a;

    public j(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public int a() {
        return this.a.getInt("config.maxAge", 0);
    }

    public boolean b() {
        return System.currentTimeMillis() - n() > ((long) a()) || System.currentTimeMillis() < n();
    }

    public UUID c() {
        return UUID.fromString(this.a.getString("config.testId", ""));
    }

    public long d() {
        return this.a.getLong("config.downloadTestInterval", 0);
    }

    public InetAddress e() {
        try {
            return InetAddress.getByName(this.a.getString("config.downloadServerAddress", ""));
        } catch (UnknownHostException unused) {
            throw new RuntimeException();
        }
    }

    public int f() {
        return this.a.getInt("config.serverPort", 0);
    }

    public int g() {
        return this.a.getInt("config.testInterval", 0);
    }

    public int h() {
        return this.a.getInt("config.packetSize", 0);
    }

    public int i() {
        return this.a.getInt("config.packetInterval", 0);
    }

    public int j() {
        return this.a.getInt("config.packetCount", 0);
    }

    public InetAddress k() {
        try {
            return InetAddress.getByName(this.a.getString("config.serverAddress", ""));
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean l() {
        return this.a.getBoolean("config.useFineLocation", false);
    }

    public int m() {
        return j() * i();
    }

    public long n() {
        return this.a.getLong("configLoaded", 0);
    }

    public int o() {
        return j() * i() * 2;
    }
}
