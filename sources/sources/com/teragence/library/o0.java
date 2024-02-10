package com.teragence.library;

import android.content.SharedPreferences;

public class o0 implements m0 {
    private final SharedPreferences a;

    public o0(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
    }

    public void a() {
        this.a.edit().clear().apply();
    }

    public void a(int i) {
        this.a.edit().putInt("lastTestInterval", i).apply();
    }

    public void a(String str) {
        this.a.edit().putString("settingsLastVersion", str).apply();
    }

    public void a(String str, long j) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putLong(str + "lastDownloadTest", j).apply();
    }

    public long b(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences.getLong(str + "lastDownloadTest", 0);
    }

    public String b() {
        return this.a.getString("settingsLastVersion", "");
    }

    public int c() {
        return this.a.getInt("lastTestInterval", 0);
    }

    public boolean d() {
        return this.a.getBoolean("allowAnyConnection", false);
    }
}
