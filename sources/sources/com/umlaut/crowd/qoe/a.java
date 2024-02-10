package com.umlaut.crowd.qoe;

import android.content.Context;
import android.content.SharedPreferences;
import com.umlaut.crowd.CCS;
import com.umlaut.crowd.internal.l;
import java.util.HashSet;
import java.util.Set;

public class a {
    private static final int A = 10;
    private static final int B = 86400000;
    private static final boolean C = false;
    private static final boolean D = false;
    private static final boolean E = false;
    private static final int F = 3000;
    private static final boolean G = false;
    private static final long H = 0;
    private static final String c = "P3INS_PFK_QOE_MANAGER_MUTE_LENGTH";
    private static final String d = "P3INS_PFK_QOE_MANAGER_LAST_MUTE";
    private static final String e = "P3INS_PFK_QOE_MANAGER_VOICE_ENABLED";
    private static final String f = "P3INS_PFK_QOE_MANAGER_APP_ENABLED";
    private static final String g = "P3INS_PFK_QOE_MANAGER_SMS_ENABLED";
    private static final String h = "P3INS_PFK_QOE_MANAGER_SMS_THRESHOLD";
    private static final String i = "P3INS_PFK_QOE_MANAGER_VOICE_DROPPED_THRESHOLD";
    private static final String j = "P3INS_PFK_QOE_MANAGER_VOICE_CALL_THRESHOLD";
    private static final String k = "P3INS_PFK_QOE_MANAGER_MESSAGE_LIMIT";
    private static final String l = "P3INS_PFK_QOE_MANAGER_MESSAGE_LIMIT_TIMESPAN";
    private static final String m = "P3INS_PFK_QOE_MANAGER_MESSAGE_TIMESTAMPS";
    private static final String n = "P3INS_PFK_QOE_MANAGER_APPS_MIN_FOREGROUND_TIME";
    private static final String o = "P3INS_PFK_QOE_MANAGER_APPS_CLOSED_COUNTER";
    private static final String p = "P3INS_PFK_QOE_MANAGER_CALL_COUNTER";
    private static final String q = "P3INS_PFK_QOE_MANAGER_SMS_COUNTER";
    private static final String r = "P3INS_PFK_QOE_MANAGER_CALL_DROPPED_COUNTER";
    private static final String s = "P3INS_PFK_QOE_MANAGER_APP_TRIGGER_CONNECTION_TYPE";
    private static final String t = "P3INS_PFK_QOE_MANAGER_PERIODIC_MESSAGE_LIMIT";
    private static final String u = "P3INS_PFK_QOE_MANAGER_PERIODIC_MESSAGE_LAST_TIMESTAMP";
    private static final String v = "p3insqoepreferences";
    private static final int w = 1;
    private static final int x = 10;
    private static final int y = 3;
    private static final int z = 3600000;
    private SharedPreferences a;
    private int b = 10;

    protected a(Context context) {
        this.a = context.getSharedPreferences(v, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(Set<String> set) {
        this.a.edit().putStringSet(m, set).commit();
    }

    /* access modifiers changed from: package-private */
    public void b(long j2) {
        this.a.edit().putLong(d, j2).commit();
    }

    /* access modifiers changed from: package-private */
    public void c(long j2) {
        this.a.edit().putLong(c, j2).commit();
    }

    /* access modifiers changed from: package-private */
    public void d(boolean z2) {
        this.a.edit().putBoolean(e, z2).commit();
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.a.getInt(r, 0);
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        this.a.edit().putInt(k, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.a.getInt(k, this.b);
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        this.a.edit().putInt(h, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        this.a.edit().putInt(j, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void j(int i2) {
        this.a.edit().putInt(i, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return this.a.getBoolean(f, false);
    }

    /* access modifiers changed from: package-private */
    public long l() {
        return this.a.getLong(d, -m());
    }

    /* access modifiers changed from: package-private */
    public long m() {
        return this.a.getLong(c, CCS.a);
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.a.getBoolean(g, false);
    }

    /* access modifiers changed from: package-private */
    public int o() {
        return this.a.getInt(h, 3);
    }

    /* access modifiers changed from: package-private */
    public int p() {
        return this.a.getInt(j, 10);
    }

    /* access modifiers changed from: package-private */
    public int q() {
        return this.a.getInt(i, 1);
    }

    /* access modifiers changed from: package-private */
    public boolean r() {
        return this.a.getBoolean(e, false);
    }

    /* access modifiers changed from: package-private */
    public int s() {
        return this.a.getInt(q, 0);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        this.a.edit().putInt(o, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        this.a.edit().putBoolean(f, z2).commit();
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        this.a.edit().putBoolean(g, z2).commit();
    }

    /* access modifiers changed from: package-private */
    public int d() {
        return this.a.getInt(p, 0);
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        this.b = i2;
    }

    /* access modifiers changed from: package-private */
    public long f() {
        return this.a.getLong(u, 0);
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        this.a.edit().putInt(l, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return this.a.getInt(l, B);
    }

    /* access modifiers changed from: package-private */
    public Set<String> i() {
        return this.a.getStringSet(m, new HashSet());
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.a.getBoolean(t, false);
    }

    /* access modifiers changed from: package-private */
    public void k(int i2) {
        this.a.edit().putInt(q, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void a(String str, int i2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putInt("P3INS_PFK_QOE_MANAGER_APPS_CLOSED_COUNTER_" + str, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public int b() {
        return this.a.getInt(o, 0);
    }

    /* access modifiers changed from: package-private */
    public void c(int i2) {
        this.a.edit().putInt(p, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void d(int i2) {
        this.a.edit().putInt(r, i2).commit();
    }

    /* access modifiers changed from: package-private */
    public void a(l lVar) {
        this.a.edit().putString(s, lVar.toString()).commit();
    }

    /* access modifiers changed from: package-private */
    public int b(String str) {
        SharedPreferences sharedPreferences = this.a;
        return sharedPreferences.getInt("P3INS_PFK_QOE_MANAGER_APPS_CLOSED_COUNTER_" + str, 0);
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return this.a.getInt(n, 3000);
    }

    /* access modifiers changed from: package-private */
    public l a() {
        return a(this.a.getString(s, l.All.toString()));
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        this.a.edit().putInt(n, i2).commit();
    }

    private l a(String str) {
        l lVar = l.All;
        if (str.equals(lVar.toString())) {
            return lVar;
        }
        l lVar2 = l.Bluetooth;
        if (str.equals(lVar2.toString())) {
            return lVar2;
        }
        l lVar3 = l.Ethernet;
        if (str.equals(lVar3.toString())) {
            return lVar3;
        }
        l lVar4 = l.Mobile;
        if (str.equals(lVar4.toString())) {
            return lVar4;
        }
        l lVar5 = l.WiFi;
        if (str.equals(lVar5.toString())) {
            return lVar5;
        }
        l lVar6 = l.WiMAX;
        return str.equals(lVar6.toString()) ? lVar6 : lVar;
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        this.a.edit().putBoolean(t, z2).commit();
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        this.a.edit().putLong(u, j2).commit();
    }
}
