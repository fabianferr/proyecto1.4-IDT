package com.bytedance.sdk.openadsdk.b;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.q;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: OpenAppSuccEvent */
public class l {
    private static volatile l a;
    private HandlerThread b;
    private final Handler c;
    private final Executor d = Executors.newCachedThreadPool();
    private b e = b.a();
    private Map<String, Object> f;

    public static l a() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public l a(Map<String, Object> map) {
        this.f = map;
        return a();
    }

    private l() {
        if (this.b == null) {
            HandlerThread handlerThread = new HandlerThread("OpenAppSuccEvent_HandlerThread", 10);
            this.b = handlerThread;
            handlerThread.start();
        }
        this.c = new Handler(this.b.getLooper(), new Handler.Callback() {
            public boolean handleMessage(Message message) {
                if (message.what != 100) {
                    return true;
                }
                a aVar = (message.obj == null || !(message.obj instanceof a)) ? null : (a) message.obj;
                if (aVar == null) {
                    return true;
                }
                l.this.b(aVar);
                return true;
            }
        });
    }

    public void a(q qVar, String str) {
        Message obtainMessage = this.c.obtainMessage();
        obtainMessage.what = 100;
        obtainMessage.obj = a.a(qVar, str, this.f);
        obtainMessage.sendToTarget();
        m.a().e();
    }

    private void a(a aVar) {
        if (aVar != null) {
            aVar.b();
            if (aVar.a() * this.e.a > this.e.b) {
                c(aVar.a(false));
                return;
            }
            Message obtainMessage = this.c.obtainMessage();
            obtainMessage.what = 100;
            obtainMessage.obj = aVar;
            this.c.sendMessageDelayed(obtainMessage, (long) this.e.a);
        }
    }

    /* access modifiers changed from: private */
    public void b(a aVar) {
        if (aVar != null) {
            boolean f2 = m.a().f();
            boolean a2 = m.a().a(true);
            if (f2 || !a2) {
                if (aVar.e == null) {
                    aVar.e = new HashMap();
                }
                aVar.e.put("is_background", Boolean.valueOf(f2));
                aVar.e.put("has_focus", Boolean.valueOf(a2));
                c(aVar.a(true));
                return;
            }
            a(aVar);
        }
    }

    private void c(a aVar) {
        if (aVar != null) {
            this.d.execute(aVar);
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class a implements Serializable, Runnable {
        public final AtomicInteger a = new AtomicInteger(0);
        public final AtomicBoolean b = new AtomicBoolean(false);
        public q c;
        public String d;
        public Map<String, Object> e;

        public static a a(q qVar, String str, Map<String, Object> map) {
            return new a(qVar, str, map);
        }

        public a(q qVar, String str, Map<String, Object> map) {
            this.c = qVar;
            this.d = str;
            this.e = map;
        }

        public a a(boolean z) {
            this.b.set(z);
            return this;
        }

        public int a() {
            return this.a.get();
        }

        public void b() {
            this.a.incrementAndGet();
        }

        public void run() {
            if (this.c == null || TextUtils.isEmpty(this.d)) {
                com.bytedance.sdk.component.utils.l.b("materialMeta or eventTag is null, pls check");
                return;
            }
            String str = this.b.get() ? "dpl_success" : "dpl_failed";
            if (this.e == null) {
                this.e = new HashMap();
            }
            q qVar = this.c;
            if (qVar != null && qVar.be() == 0) {
                Map<String, Object> map = this.e;
                q qVar2 = this.c;
                map.put("auto_click", Boolean.valueOf(qVar2 != null && !qVar2.c()));
            }
            this.e.put("lifeCycleInit", Boolean.valueOf(m.a().c()));
            String d2 = m.a().d();
            if (!this.b.get()) {
                this.e.put("activity_trace", d2);
            }
            c.a(this.c, this.d, str, this.e);
        }
    }

    /* compiled from: OpenAppSuccEvent */
    private static class b {
        public int a = 300;
        public int b = 6000;

        private b() {
        }

        public static b a() {
            return new b();
        }
    }
}
