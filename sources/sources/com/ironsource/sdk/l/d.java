package com.ironsource.sdk.l;

import android.os.Handler;
import com.ironsource.environment.thread.a;
import com.ironsource.sdk.h.c;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class d {
    private static d d;
    public c a = new c(a.a());
    public final String b;
    private final JSONObject c;
    private Thread e;

    private d(String str, a aVar, JSONObject jSONObject) {
        this.b = str;
        this.c = jSONObject;
        IronSourceStorageUtils.deleteFolder(c());
        IronSourceStorageUtils.makeDir(c());
    }

    public static synchronized d a(String str, a aVar, JSONObject jSONObject) {
        d dVar;
        synchronized (d.class) {
            if (d == null) {
                d = new d(str, aVar, jSONObject);
            }
            dVar = d;
        }
        return dVar;
    }

    private static Thread a(a aVar, Handler handler) {
        return new Thread(new g(aVar, handler));
    }

    private String c() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.b, "temp");
    }

    public Thread a(c cVar, String str, int i, int i2, Handler handler) {
        if (i <= 0) {
            i = this.c.optInt("connectionTimeout", 5);
        }
        if (i2 <= 0) {
            i2 = this.c.optInt("readTimeout", 5);
        }
        return a(new a(cVar, str, (int) TimeUnit.SECONDS.toMillis((long) i), (int) TimeUnit.SECONDS.toMillis((long) i2), c()), handler);
    }

    public final synchronized void a() {
        d = null;
        c cVar = this.a;
        if (cVar != null) {
            cVar.a = null;
            this.a = null;
        }
    }

    public final void a(c cVar, String str) {
        c cVar2 = cVar;
        String str2 = str;
        Thread a2 = a(new a(cVar2, str2, (int) TimeUnit.SECONDS.toMillis((long) this.c.optInt("connectionTimeout", 5)), (int) TimeUnit.SECONDS.toMillis((long) this.c.optInt("readTimeout", 5)), c()), (Handler) this.a);
        this.e = a2;
        a2.start();
    }

    public final boolean b() {
        Thread thread = this.e;
        return thread != null && thread.isAlive();
    }
}
