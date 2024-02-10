package com.mbridge.msdk.e;

import java.io.Serializable;

/* compiled from: EventTable */
public final class i implements Serializable {
    static String a = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_count INTEGER)";
    static String b = "DROP TABLE IF EXISTS %s";
    private final e c;
    private int d;
    private int e;
    private final String f;
    private long g;
    private boolean h = false;
    private boolean i = false;

    public i(e eVar) {
        this.c = eVar;
        this.f = eVar.e();
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final boolean a() {
        return this.h;
    }

    public final void b(boolean z) {
        this.i = z;
    }

    public final boolean b() {
        return this.i;
    }

    public final e c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final void a(int i2) {
        this.d = i2;
    }

    public final int e() {
        return this.e;
    }

    public final void b(int i2) {
        this.e = i2;
    }

    public final String f() {
        return this.f;
    }

    public final long g() {
        return this.g;
    }

    public final void a(long j) {
        this.g = j;
    }
}
