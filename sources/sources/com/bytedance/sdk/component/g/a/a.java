package com.bytedance.sdk.component.g.a;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bytedance.sdk.component.utils.x;

/* compiled from: HandlerPool */
public class a {
    private final d<b> a;
    private Handler b;

    /* renamed from: com.bytedance.sdk.component.g.a.a$a  reason: collision with other inner class name */
    /* compiled from: HandlerPool */
    private static class C0057a {
        /* access modifiers changed from: private */
        public static final a a = new a();
    }

    private a() {
        this.a = d.a(2);
    }

    public static a a() {
        return C0057a.a;
    }

    public Handler b() {
        if (this.b == null) {
            synchronized (a.class) {
                if (this.b == null) {
                    this.b = a("csj_io_handler");
                }
            }
        }
        return this.b;
    }

    /* access modifiers changed from: private */
    public void a(final Handler handler, final Handler handler2) {
        if (Build.VERSION.SDK_INT < 23) {
            return;
        }
        if (handler.getLooper().getQueue().isIdle()) {
            handler.removeCallbacksAndMessages((Object) null);
            handler.getLooper().quit();
            return;
        }
        handler2.postDelayed(new Runnable() {
            public void run() {
                a.this.a(handler, handler2);
            }
        }, 1000);
    }

    public x a(x.a aVar, final String str) {
        b a2 = this.a.a();
        if (a2 == null) {
            return b(aVar, str);
        }
        a2.a(aVar);
        a2.post(new Runnable() {
            public void run() {
                Thread.currentThread().setName(str);
            }
        });
        return a2;
    }

    public x a(String str) {
        return a((x.a) null, str);
    }

    private b b(x.a aVar, String str) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        return new b(handlerThread, aVar);
    }

    public boolean a(x xVar) {
        if (!(xVar instanceof b)) {
            return false;
        }
        b bVar = (b) xVar;
        if (this.a.a(bVar)) {
            return true;
        }
        bVar.b();
        return true;
    }
}
