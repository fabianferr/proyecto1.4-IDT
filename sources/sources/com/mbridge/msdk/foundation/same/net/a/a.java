package com.mbridge.msdk.foundation.same.net.a;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;
import org.java_websocket.WebSocketImpl;

/* compiled from: CronetEngineManager */
public final class a {
    private CronetEngine a;
    private CronetEngine.Builder b;
    private final ArrayList<String> c;
    private final ExecutorService d;

    /* renamed from: com.mbridge.msdk.foundation.same.net.a.a$a  reason: collision with other inner class name */
    /* compiled from: CronetEngineManager */
    private static final class C0141a {
        /* access modifiers changed from: private */
        public static final a a = new a();
    }

    private a() {
        this.c = new ArrayList<>();
        this.d = Executors.newCachedThreadPool();
        if (this.b == null) {
            this.b = d();
        }
        this.a = this.b.build();
    }

    public static a a() {
        return C0141a.a;
    }

    public final CronetEngine b() {
        if (b.d().g() == null) {
            return null;
        }
        CronetEngine cronetEngine = this.a;
        if (cronetEngine != null) {
            return cronetEngine;
        }
        if (this.b == null) {
            this.b = d();
        }
        CronetEngine build = this.b.build();
        this.a = build;
        return build;
    }

    private CronetEngine.Builder d() {
        if (this.b == null) {
            this.b = new CronetEngine.Builder(b.d().g());
            this.b.setStoragePath(e.b(c.MBRIDGE_OTHER)).enableHttpCache(2, 5242880).enableHttp2(true).enableQuic(true);
        }
        return this.b;
    }

    public final void a(String str) {
        try {
            if (!TextUtils.isEmpty(str) && !this.c.contains(str)) {
                this.c.add(str);
                if (this.b == null) {
                    this.b = d();
                }
                CronetEngine.Builder builder = this.b;
                if (builder != null) {
                    builder.addQuicHint(str, WebSocketImpl.DEFAULT_WSS_PORT, WebSocketImpl.DEFAULT_WSS_PORT);
                }
            }
        } catch (Throwable th) {
            aa.d("CronetEngineManager", th.getMessage());
        }
    }

    public final ExecutorService c() {
        return this.d;
    }
}
