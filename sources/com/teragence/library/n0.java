package com.teragence.library;

import com.teragence.client.i;

public class n0 implements m0 {
    private final m0 a;

    public n0(m0 m0Var) {
        this.a = m0Var;
    }

    public void a() {
        i.a("LoggableSettingsRep", "clear() called");
        this.a.a();
    }

    public void a(int i) {
        i.a("LoggableSettingsRep", "saveLastTestInterval() called with: newInterval = [" + i + "]");
        this.a.a(i);
    }

    public void a(String str) {
        i.a("LoggableSettingsRep", "saveLastVersion() called with: version = [" + str + "]");
        this.a.a(str);
    }

    public void a(String str, long j) {
        i.a("LoggableSettingsRep", "saveLastDownloadTestTime() called with: timeMillis = [" + j + "]");
        this.a.a(str, j);
    }

    public long b(String str) {
        i.a("LoggableSettingsRep", "loadLastDownloadTestTime() called");
        return this.a.b(str);
    }

    public String b() {
        String b = this.a.b();
        i.a("LoggableSettingsRep", "loadLastVersion() called: " + b);
        return b;
    }

    public int c() {
        i.a("LoggableSettingsRep", "loadLastTestInterval() called");
        return this.a.c();
    }

    public boolean d() {
        i.a("LoggableSettingsRep", "loadAllowAnyConnection() called");
        return this.a.d();
    }
}
