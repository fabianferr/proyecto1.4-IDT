package com.bytedance.sdk.openadsdk.multipro.aidl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.IBinderPool;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.d;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.e;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.f;
import com.bytedance.sdk.openadsdk.multipro.aidl.a.g;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.bytedance.sdk.openadsdk.utils.aa;
import com.bytedance.sdk.openadsdk.utils.ac;

/* compiled from: BinderPool */
public class a {
    private static final a b = new a();
    /* access modifiers changed from: private */
    public IBinderPool a;
    /* access modifiers changed from: private */
    public b c;
    /* access modifiers changed from: private */
    public long d = 0;
    private final ServiceConnection e = new ServiceConnection() {
        public void onServiceDisconnected(ComponentName componentName) {
            l.c("TTAD.BinderPool", "BinderPool......onServiceDisconnected");
        }

        public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
            aa.a(new h("onServiceConnected") {
                public void run() {
                    IBinderPool unused = a.this.a = IBinderPool.Stub.asInterface(iBinder);
                    try {
                        a.this.a.asBinder().linkToDeath(a.this.f, 0);
                    } catch (RemoteException e) {
                        l.c("TTAD.BinderPool", "onServiceConnected throws :", e);
                    }
                    l.b("TTAD.BinderPool", "onServiceConnected - binderService consume time ：" + (System.currentTimeMillis() - a.this.d));
                    if (a.this.c != null) {
                        a.this.c.onServiceConnected();
                    }
                }
            }, 5);
        }
    };
    /* access modifiers changed from: private */
    public final IBinder.DeathRecipient f = new IBinder.DeathRecipient() {
        public void binderDied() {
            aa.a(new h("binderDied") {
                public void run() {
                    l.d("TTAD.BinderPool", "binder died.");
                    a.this.a.asBinder().unlinkToDeath(a.this.f, 0);
                    IBinderPool unused = a.this.a = null;
                    a.this.d();
                }
            }, 5);
        }
    };

    private a() {
        d();
    }

    public static a a() {
        return b;
    }

    public void b() {
        try {
            Context a2 = o.a();
            a2.startService(new Intent(a2, BinderPoolService.class));
        } catch (Exception unused) {
        }
    }

    public void c() {
        try {
            Context a2 = o.a();
            a2.bindService(new Intent(a2, BinderPoolService.class), this.e, 1);
            this.d = System.currentTimeMillis();
        } catch (Throwable unused) {
        }
    }

    public void a(b bVar) {
        this.c = bVar;
        if (this.a != null) {
            aa.a(new h("onServiceConnected2") {
                public void run() {
                    if (a.this.c != null) {
                        a.this.c.onServiceConnected();
                    }
                }
            }, 5);
        }
    }

    public IBinder a(int i) {
        try {
            if (b.c()) {
                try {
                    IBinderPool iBinderPool = this.a;
                    if (iBinderPool != null) {
                        return iBinderPool.queryBinder(i);
                    }
                    return null;
                } catch (RemoteException e2) {
                    l.e("TTAD.BinderPool", e2.getMessage());
                    ac.h("queryBinder error");
                    return null;
                }
            } else if (i == 0) {
                return g.a();
            } else {
                if (i == 1) {
                    return e.a();
                }
                if (i == 5) {
                    return f.b();
                }
                if (i == 6) {
                    return d.a();
                }
                if (i != 7) {
                    return null;
                }
                return com.bytedance.sdk.openadsdk.multipro.aidl.a.b.a();
            }
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public void d() {
        if (b.c()) {
            l.c("TTAD.BinderPool", "BinderPool......connectBinderPoolService");
            c();
        }
    }
}
