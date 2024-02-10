package com.ironsource.mediationsdk.events;

import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.c;

public class d {
    private String a;
    private String b;
    private com.ironsource.mediationsdk.model.d c;

    public d(String str, String str2, com.ironsource.mediationsdk.model.d dVar) {
        this.a = str;
        this.b = str2;
        this.c = dVar;
    }

    static a a(String str, int i) {
        if ("ironbeast".equals(str)) {
            return new f(i);
        }
        if ("outcome".equals(str)) {
            return new g(i);
        }
        if (i == 2) {
            return new f(i);
        }
        if (i == 3) {
            return new g(i);
        }
        IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
        IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
        logger.log(ironSourceTag, "EventsFormatterFactory failed to instantiate a formatter (type: " + str + ", adUnit: " + i + ")", 2);
        return null;
    }

    public String a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public boolean c() {
        return this.c.i.c > 0;
    }

    public long d() {
        return this.c.i.g;
    }

    public int e() {
        return this.c.h;
    }

    public long f() {
        return this.c.c;
    }

    public int g() {
        return this.c.g;
    }

    public c h() {
        return this.c.i;
    }

    public com.ironsource.mediationsdk.model.d i() {
        return this.c;
    }

    public boolean j() {
        return this.c.k;
    }

    public long k() {
        return this.c.l;
    }
}
