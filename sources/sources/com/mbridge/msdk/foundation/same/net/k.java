package com.mbridge.msdk.foundation.same.net;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.same.net.stack.b;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue */
public class k {
    private static final String a = "k";
    private final Context b;
    /* access modifiers changed from: private */
    public final c c;
    private final Set<j> d = new HashSet();
    private ExecutorService e;
    private final AtomicInteger f = new AtomicInteger();
    /* access modifiers changed from: private */
    public b g;

    public k(Context context) {
        a();
        this.b = context.getApplicationContext();
        this.c = new d(new Handler(Looper.getMainLooper()));
    }

    public k(Context context, b bVar) {
        this.g = bVar;
        a();
        this.b = context.getApplicationContext();
        this.c = new d(new Handler(Looper.getMainLooper()));
    }

    private void a() {
        ac a2 = ac.a();
        if (a2.a("c_v_r_q_t", true)) {
            try {
                this.e = new ThreadPoolExecutor(a2.a("v_r_q_c_s", 10), a2.a("v_r_q_m_s", 25), (long) a2.a("v_r_q_c_t", 15), TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } catch (Exception unused) {
                this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
            }
        } else {
            this.e = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public final void a(final j jVar) {
        jVar.a(this);
        synchronized (this) {
            this.d.add(jVar);
        }
        jVar.a(this.f.incrementAndGet());
        String str = a;
        aa.b(str, "add-to-queue request=" + jVar.b());
        this.e.execute(new Runnable() {
            public final void run() {
                if (k.this.g == null) {
                    new i(k.this.c).a(jVar);
                } else {
                    new i(k.this.c, k.this.g).a(jVar);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public final void b(j jVar) {
        synchronized (this) {
            this.d.remove(jVar);
        }
    }
}
