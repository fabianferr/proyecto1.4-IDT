package com.mbridge.msdk.foundation.same.e;

import android.content.Context;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.ac;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: CommonTaskLoader */
public final class b {
    ThreadPoolExecutor a;
    HashMap<Long, a> b;
    WeakReference<Context> c;

    public b(Context context, int i) {
        if (ac.a().a("c_t_l_t_p", true)) {
            this.a = c.a();
        } else {
            if (i == 0) {
                this.a = new ThreadPoolExecutor(1, 5, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.a = new ThreadPoolExecutor(i, (i * 2) + 1, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.a.allowCoreThreadTimeOut(true);
        }
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    public b(Context context) {
        if (ac.a().a("c_t_l_t_p", true)) {
            this.a = c.a();
        } else {
            if (ac.a().a("c_t_p_t_l", true)) {
                int availableProcessors = (Runtime.getRuntime().availableProcessors() * 2) + 1;
                this.a = new ThreadPoolExecutor(availableProcessors, availableProcessors, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            } else {
                this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
            }
            this.a.allowCoreThreadTimeOut(true);
        }
        this.b = new HashMap<>();
        this.c = new WeakReference<>(context);
    }

    private synchronized void b(final a aVar, final a.C0139a aVar2) {
        this.b.put(Long.valueOf(a.b), aVar);
        aVar.d = new a.C0139a() {
            public final void a(a.b bVar) {
                if (bVar == a.b.CANCEL) {
                    b.this.b.remove(Long.valueOf(a.b));
                } else if (bVar == a.b.FINISH) {
                    b.this.b.remove(Long.valueOf(a.b));
                } else if (bVar == a.b.RUNNING && ((Context) b.this.c.get()) == null) {
                    b.this.a();
                }
                a.C0139a aVar = aVar2;
                if (aVar != null) {
                    aVar.a(bVar);
                }
            }
        };
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Set r0 = r0.entrySet()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
        L_0x000b:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            if (r1 == 0) goto L_0x0021
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            com.mbridge.msdk.foundation.same.e.a r1 = (com.mbridge.msdk.foundation.same.e.a) r1     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r1.d()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x000b
        L_0x0021:
            java.util.HashMap<java.lang.Long, com.mbridge.msdk.foundation.same.e.a> r0 = r2.b     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            r0.clear()     // Catch:{ Exception -> 0x002a, all -> 0x0027 }
            goto L_0x002a
        L_0x0027:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x002a:
            monitor-exit(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.same.e.b.a():void");
    }

    public final void a(a aVar) {
        b(aVar, (a.C0139a) null);
        this.a.execute(aVar);
    }

    public final void a(a aVar, a.C0139a aVar2) {
        b(aVar, aVar2);
        this.a.execute(aVar);
    }
}
