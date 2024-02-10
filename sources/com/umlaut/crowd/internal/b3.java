package com.umlaut.crowd.internal;

import android.app.AppOpsManager;
import android.app.usage.UsageEvents;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.os.Process;

class b3 implements r3 {
    private static final String e = "usagestats";
    private static final int f = 2000;
    private final Context a;
    private UsageStatsManager b;
    private long c;
    private v8 d;

    public b3(Context context) {
        this.a = context;
    }

    public boolean a() {
        return ((AppOpsManager) this.a.getSystemService("appops")).checkOpNoThrow("android:get_usage_stats", Process.myUid(), this.a.getPackageName()) == 0;
    }

    public v8 b() {
        if (this.b == null) {
            this.b = (UsageStatsManager) this.a.getSystemService(e);
            this.c = System.currentTimeMillis() - 10000;
        }
        long currentTimeMillis = System.currentTimeMillis();
        UsageEvents queryEvents = this.b.queryEvents(this.c - 2000, currentTimeMillis);
        v8 v8Var = null;
        while (queryEvents.hasNextEvent()) {
            UsageEvents.Event event = new UsageEvents.Event();
            queryEvents.getNextEvent(event);
            if (event.getEventType() == 1) {
                v8Var = new v8();
                String packageName = event.getPackageName();
                v8Var.a = packageName;
                v8Var.b = m.a(packageName, this.a);
            }
        }
        if (v8Var != null) {
            this.d = v8Var;
        }
        this.c = currentTimeMillis;
        return this.d;
    }

    public c3 c() {
        return c3.Lollipop;
    }

    public void d() {
        this.d = null;
    }
}
