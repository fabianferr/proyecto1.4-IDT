package com.bytedance.sdk.component.e.a.b.c;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.component.e.a.a.b;
import com.bytedance.sdk.component.e.a.a.d;
import com.bytedance.sdk.component.e.a.d.a;
import com.bytedance.sdk.component.e.a.e.e;
import com.bytedance.sdk.component.e.a.f;
import com.bytedance.sdk.component.e.a.i;
import com.facebook.internal.security.CertificateUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdPriorityLogThread */
public class c extends HandlerThread implements Handler.Callback {
    private static int q = 10;
    private static int r = 200;
    protected d a;
    private volatile boolean b = true;
    private final Object c = new Object();
    private com.bytedance.sdk.component.e.a.b.c d;
    private final PriorityBlockingQueue<a> e;
    /* access modifiers changed from: private */
    public volatile int f;
    private volatile long g = 0;
    private volatile long h = 0;
    private final AtomicInteger i = new AtomicInteger(0);
    private final long j = 5000;
    private final long k = 5000000000L;
    /* access modifiers changed from: private */
    public final AtomicInteger l = new AtomicInteger(0);
    private volatile Handler m;
    private final List<a> n = new ArrayList();
    private final AtomicInteger o = new AtomicInteger(0);
    private final AtomicInteger p = new AtomicInteger(0);
    private final int s = 1;
    private final int t = 2;
    private final int u = 3;

    public static void a(int i2) {
        q = i2;
        com.bytedance.sdk.component.e.a.c.c.b("PADLT", "config size=" + i2);
    }

    public static void b(int i2) {
        r = i2;
        com.bytedance.sdk.component.e.a.c.c.b("PADLT", "applog_interval=" + i2);
    }

    public c(PriorityBlockingQueue<a> priorityBlockingQueue) {
        super("csj_log");
        this.e = priorityBlockingQueue;
        this.a = new b();
    }

    public void a(boolean z) {
        this.b = z;
    }

    public boolean a() {
        return this.b;
    }

    public boolean handleMessage(Message message) {
        int i2 = message.what;
        if (i2 == 1) {
            com.bytedance.sdk.component.e.a.c.c.a("HANDLER_MESSAGE_INIT");
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.i(), 1);
            a(true);
            d();
        } else if (i2 == 2 || i2 == 3) {
            com.bytedance.sdk.component.e.a.c.c.a("-----------------server busy handleMessage---------------- ");
            b();
        } else if (i2 == 11) {
            try {
                com.bytedance.sdk.component.e.a.c.c.a("opt upload");
                ArrayList arrayList = new ArrayList(this.n);
                this.n.clear();
                a((List<a>) arrayList, false, "timeout_dispatch");
                i();
            } catch (Throwable th) {
                com.bytedance.sdk.component.e.a.c.c.d("error:" + th.getMessage());
            }
        }
        return true;
    }

    private void b() {
        com.bytedance.sdk.component.e.a.c.c.a("sendServerBusyOrRoutineErrorRetryMessage");
        c();
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.I(), 1);
        c(1);
    }

    private void c() {
        if (!isAlive()) {
            com.bytedance.sdk.component.e.a.c.c.a("th dead");
            com.bytedance.sdk.component.e.a.b.d.a.d();
        } else if (!a()) {
            com.bytedance.sdk.component.e.a.c.c.a("monitor  mLogThread ");
            c(6);
        }
    }

    /* access modifiers changed from: protected */
    public void onLooperPrepared() {
        super.onLooperPrepared();
        this.m = new Handler(getLooper(), this);
        com.bytedance.sdk.component.e.a.b.d.a.a(this.m);
        this.m.sendEmptyMessage(1);
        com.bytedance.sdk.component.e.a.c.c.a("onLooperPrepared");
    }

    public boolean a(int i2, boolean z) {
        f m2 = i.e().m();
        if (m2 != null && m2.a(i.e().d())) {
            return this.a.a(i2, z);
        }
        com.bytedance.sdk.component.e.a.c.c.d("AdThread NET IS NOT AVAILABLE!!!");
        return false;
    }

    public void a(a aVar, boolean z) {
        if (aVar != null) {
            com.bytedance.sdk.component.e.a.c.c.a("ignore result : " + z + CertificateUtil.DELIMITER + this.b + " adType: " + aVar.d());
            if (!z) {
                this.e.add(aVar);
                e(2);
            } else if (this.m != null) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(aVar);
                a((List<a>) arrayList, true, "ignore_result_dispatch");
            } else {
                com.bytedance.sdk.component.e.a.c.c.d("handler is null，ignore is true");
            }
        }
    }

    public void c(int i2) {
        try {
            boolean a2 = a(i2, com.bytedance.sdk.component.e.a.b.d.a.b);
            com.bytedance.sdk.component.e.a.c.c.c("notify flush : " + a2 + " " + i2);
            if (i2 == 6 || a2) {
                com.bytedance.sdk.component.e.a.d.b bVar = new com.bytedance.sdk.component.e.a.d.b();
                bVar.a(i2);
                this.e.add(bVar);
                e(3);
            }
        } catch (Throwable th) {
            com.bytedance.sdk.component.e.a.c.c.d(th.getMessage());
        }
    }

    private void a(a aVar, int i2) {
        this.i.set(0);
        com.bytedance.sdk.component.e.a.c.c.a("handleThreadMessage()");
        if (i2 == 0) {
            this.f = ((com.bytedance.sdk.component.e.a.d.b) aVar).j();
            if (this.f != 6) {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.N(), 1);
                b(aVar);
                return;
            }
            return;
        }
        com.bytedance.sdk.component.e.a.d.b bVar = (com.bytedance.sdk.component.e.a.d.b) aVar;
        if (bVar.j() == 1) {
            this.f = 1;
            b(aVar);
        } else if (bVar.j() == 2) {
            com.bytedance.sdk.component.e.a.c.c.a("before size:" + i2);
            f();
            com.bytedance.sdk.component.e.a.c.c.a("after size :" + i2);
            this.f = 2;
            b(aVar);
        }
    }

    private void d() {
        while (a()) {
            try {
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.h(), 1);
                a poll = this.e.poll(60000, TimeUnit.MILLISECONDS);
                int size = this.e.size();
                com.bytedance.sdk.component.e.a.c.c.a("poll size:" + size);
                if (poll instanceof com.bytedance.sdk.component.e.a.d.b) {
                    a(poll, size);
                } else if (poll == null) {
                    int incrementAndGet = this.i.incrementAndGet();
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.O(), 1);
                    if (d(incrementAndGet)) {
                        e();
                        return;
                    } else if (incrementAndGet < 4) {
                        com.bytedance.sdk.component.e.a.c.c.a("timeoutCount:" + incrementAndGet);
                        this.f = 1;
                        b((a) null);
                    }
                } else {
                    a(poll);
                    b(poll);
                }
            } catch (Throwable th) {
                com.bytedance.sdk.component.e.a.c.c.d("run exception:" + th.getMessage());
                com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            }
        }
    }

    private boolean d(int i2) {
        return i2 >= 4 && this.l.get() == 0 && !com.bytedance.sdk.component.e.a.b.d.a.b && !com.bytedance.sdk.component.e.a.b.d.a.c;
    }

    private void e() {
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.v(), 1);
        a(false);
        com.bytedance.sdk.component.e.a.b.d.a.c();
        com.bytedance.sdk.component.e.a.c.c.c("exit log thread");
    }

    private void f() {
        if (this.e.size() >= 100) {
            for (int i2 = 0; i2 < 100; i2++) {
                a poll = this.e.poll();
                if (poll instanceof com.bytedance.sdk.component.e.a.d.b) {
                    com.bytedance.sdk.component.e.a.c.c.a("ignore tm");
                } else if (poll != null) {
                    a(poll);
                } else {
                    com.bytedance.sdk.component.e.a.c.c.d("event == null");
                }
            }
        }
    }

    private void a(a aVar) {
        this.i.set(0);
        if (com.bytedance.sdk.component.e.a.b.d.a.b) {
            this.f = 5;
        } else if (com.bytedance.sdk.component.e.a.b.d.a.c) {
            this.f = 7;
        } else {
            this.f = 4;
        }
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.U(), 1);
        this.a.a(aVar, this.f);
        com.bytedance.sdk.component.e.a.c.a.g(aVar);
    }

    private boolean g() {
        return com.bytedance.sdk.component.e.a.b.d.a.b && (this.f == 4 || this.f == 7 || this.f == 6 || this.f == 5 || this.f == 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(com.bytedance.sdk.component.e.a.d.a r8) {
        /*
            r7 = this;
            boolean r0 = r7.g()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "upload cancel:"
            r0.<init>(r3)
            int r3 = r7.f
            java.lang.String r3 = com.bytedance.sdk.component.e.a.c.a.a((int) r3)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            com.bytedance.sdk.component.e.a.c.c.c(r0)
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r0 = r0.l()
            com.bytedance.sdk.component.e.a.c.b.a(r0, r1)
            java.util.concurrent.PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> r0 = r7.e
            int r0 = r0.size()
            if (r0 != 0) goto L_0x0051
            android.os.Handler r0 = r7.m
            r3 = 2
            boolean r0 = r0.hasMessages(r3)
            if (r0 != 0) goto L_0x004e
            com.bytedance.sdk.component.e.a.b.d r0 = com.bytedance.sdk.component.e.a.b.d.a
            r0.b = r2
            r3 = 0
            r7.h = r3
            r7.g = r3
            java.util.concurrent.atomic.AtomicInteger r0 = r7.o
            r0.set(r2)
            java.util.concurrent.atomic.AtomicInteger r0 = r7.p
            r0.set(r2)
            goto L_0x0052
        L_0x004e:
            r7.a((boolean) r2)
        L_0x0051:
            return
        L_0x0052:
            int r0 = r7.f
            com.bytedance.sdk.component.e.a.b.d r3 = com.bytedance.sdk.component.e.a.b.d.a
            boolean r3 = r3.b
            boolean r0 = r7.a((int) r0, (boolean) r3)
            int r3 = r7.f
            com.bytedance.sdk.component.e.a.c.a.a((boolean) r0, (int) r3, (com.bytedance.sdk.component.e.a.d.a) r8)
            com.bytedance.sdk.component.e.a.b.a.a r3 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r3 = r3.m()
            com.bytedance.sdk.component.e.a.c.b.a(r3, r1)
            if (r0 == 0) goto L_0x00a2
            com.bytedance.sdk.component.e.a.a.d r3 = r7.a
            int r4 = r7.f
            r5 = -1
            r6 = 0
            java.util.List r3 = r3.a(r4, r5, r6)
            if (r3 == 0) goto L_0x0099
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "upload size="
            r4.<init>(r5)
            int r5 = r3.size()
            r4.append(r5)
            java.lang.String r5 = "  times="
            r4.append(r5)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.bytedance.sdk.component.e.a.c.c.c(r4)
            r7.a((java.util.List<com.bytedance.sdk.component.e.a.d.a>) r3)
            goto L_0x00a5
        L_0x0099:
            java.lang.String r3 = "no need upload"
            com.bytedance.sdk.component.e.a.c.c.b(r3)
            r7.h()
            goto L_0x00a5
        L_0x00a2:
            r7.h()
        L_0x00a5:
            int r2 = r2 + 1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = "times="
            r3.<init>(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.bytedance.sdk.component.e.a.c.c.b(r3)
            if (r0 == 0) goto L_0x00bd
            r0 = 6
            if (r2 <= r0) goto L_0x0052
        L_0x00bd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.c.c.b(com.bytedance.sdk.component.e.a.d.a):void");
    }

    private void h() {
        try {
            if (this.e.size() == 0 && this.m.hasMessages(11) && a()) {
                a(false);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d(e2.getMessage());
        }
    }

    private void a(List<a> list, String str) {
        a(str);
        a(list, false, str);
        i();
    }

    private void a(List<a> list) {
        if (list.size() != 0) {
            com.bytedance.sdk.component.e.a.c.a.a(list, this.e.size());
            if (list.size() > 1 || com.bytedance.sdk.component.e.a.c.a.b()) {
                com.bytedance.sdk.component.e.a.c.c.b("PADLT", "Batch report（ local or stats ）");
                a(list, "batchRead");
                return;
            }
            a aVar = list.get(0);
            if (aVar == null) {
                com.bytedance.sdk.component.e.a.c.c.a("upload adLogEvent is null");
            } else if (aVar.e() == 1) {
                a(list, "highPriority");
                com.bytedance.sdk.component.e.a.c.c.b("PADLT", "Single high priority （ applog ）");
            } else if (aVar.d() == 0 && aVar.e() == 2) {
                if (aVar.b() == 3) {
                    a(list, "version_v3");
                } else {
                    b(list);
                }
            } else if (aVar.d() == 1) {
                com.bytedance.sdk.component.e.a.c.c.b("PADLT", "Stats batch report （ stats ）");
                a(list, "stats");
            } else if (aVar.d() == 3) {
                a(list, "adType_v3");
            } else if (aVar.d() == 2) {
                com.bytedance.sdk.component.e.a.c.c.b("PADLT", "Single high priority （ stats ）");
                a(list, "other");
            } else {
                com.bytedance.sdk.component.e.a.c.c.a("upload adLogEvent adType error");
            }
        } else {
            h();
            com.bytedance.sdk.component.e.a.c.c.a("upload list is empty");
        }
    }

    private void b(List<a> list) {
        this.n.addAll(list);
        com.bytedance.sdk.component.e.a.c.c.b("PADLT", "a batch applog generation cur=" + this.n.size());
        f m2 = i.e().m();
        if (!(m2 == null || m2.m() == null)) {
            q = m2.m().b();
        }
        if (this.n.size() >= q) {
            if (this.m.hasMessages(11)) {
                this.m.removeMessages(11);
            }
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            a((List<a>) arrayList, false, "max_size_dispatch");
            i();
            com.bytedance.sdk.component.e.a.c.c.b("PADLT", "batch applog report ( size ) " + q);
        } else if (this.e.size() == 0) {
            a(false);
            if (this.m.hasMessages(11)) {
                this.m.removeMessages(11);
            }
            if (this.m.hasMessages(1)) {
                this.m.removeMessages(1);
            }
            long j2 = (long) r;
            if (!(m2 == null || m2.m() == null)) {
                j2 = m2.m().a();
            }
            this.m.sendEmptyMessageDelayed(11, j2);
            com.bytedance.sdk.component.e.a.c.c.b("PADLT", "batch applog report delay ( time )" + j2);
        } else {
            com.bytedance.sdk.component.e.a.c.c.a("uploadBatchOptimize nothing：" + this.e.size() + "  " + this.b);
        }
    }

    private void a(String str) {
        if (this.m.hasMessages(11)) {
            this.m.removeMessages(11);
        }
        if (this.n.size() != 0) {
            ArrayList arrayList = new ArrayList(this.n);
            this.n.clear();
            a((List<a>) arrayList, false, "before_" + str);
            i();
            com.bytedance.sdk.component.e.a.c.c.c("PADLT", "applog batch reporting size = " + arrayList.size());
            return;
        }
        com.bytedance.sdk.component.e.a.c.c.a("ensureUploadOptBatch empty：" + str);
    }

    private void a(List<a> list, boolean z, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.component.e.a.c.a.a(list, this.f, str);
        com.bytedance.sdk.component.e.a.b.c f2 = i.e().f();
        this.d = f2;
        if (f2 != null) {
            b(list, z, currentTimeMillis);
        } else {
            a(list, z, currentTimeMillis);
        }
    }

    private void a(List<a> list, boolean z, long j2) {
        f m2 = i.e().m();
        if (m2 != null) {
            Executor f2 = m2.f();
            if (list.get(0).e() == 1) {
                f2 = m2.e();
            }
            if (f2 != null) {
                this.l.incrementAndGet();
                final List<a> list2 = list;
                final boolean z2 = z;
                final long j3 = j2;
                f2.execute(new e("csj_log_upload") {
                    public void run() {
                        c cVar = c.this;
                        cVar.a((List<a>) list2, z2, j3, cVar.f);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(List<a> list, boolean z, long j2, int i2) {
        b a2;
        try {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.ad(), 1);
            if (list.get(0).d() == 0) {
                a2 = i.c().a(list);
                a(a2, list);
                if (a2 != null) {
                    com.bytedance.sdk.component.e.a.c.a.a(list, a2.d);
                }
            } else {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                for (a g2 : list) {
                    jSONArray.put(g2.g());
                }
                jSONObject.put("stats_list", jSONArray);
                a2 = i.c().a(jSONObject);
            }
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d("json exception:" + e2.getMessage());
        } catch (Throwable th) {
            com.bytedance.sdk.component.e.a.c.c.d("inner exception:" + th.getMessage());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            this.l.decrementAndGet();
            return;
        }
        b bVar = a2;
        this.l.decrementAndGet();
        a(z, bVar, list, j2);
    }

    private void b(List<a> list, final boolean z, final long j2) {
        this.l.incrementAndGet();
        com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.ad(), 1);
        try {
            this.d.a(list, new com.bytedance.sdk.component.e.a.b.b() {
                public void a(List<a> list) {
                    try {
                        c.this.l.decrementAndGet();
                        if (list != null && list.size() != 0) {
                            int size = list.size();
                            for (int i = 0; i < size; i++) {
                                a aVar = list.get(i);
                                if (aVar != null) {
                                    c.this.a(z, aVar.a(), aVar.b(), j2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e2) {
            com.bytedance.sdk.component.e.a.c.c.d("outer exception：" + e2.getMessage());
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.K(), 1);
            this.l.decrementAndGet();
        }
    }

    private void e(int i2) {
        if (a()) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.a(), 1);
        } else if (this.m != null) {
            com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.c(), 1);
            if (!this.m.hasMessages(1)) {
                if (i2 == 1) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.f(), 1);
                } else if (i2 == 2) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.d(), 1);
                } else if (i2 == 3) {
                    com.bytedance.sdk.component.e.a.c.b.a(com.bytedance.sdk.component.e.a.b.d.d.e(), 1);
                }
                this.m.sendEmptyMessage(1);
            }
        }
    }

    private void a(b bVar, List<a> list) {
        if (bVar != null && bVar.a) {
            List<com.bytedance.sdk.component.e.a.e> a2 = com.bytedance.sdk.component.e.a.b.a();
            if (list != null && a2 != null && a2.size() != 0) {
                for (a next : list) {
                    if (next.e() == 1) {
                        String a3 = com.bytedance.sdk.component.e.a.c.a.a(next);
                        String e2 = com.bytedance.sdk.component.e.a.c.a.e(next);
                        for (com.bytedance.sdk.component.e.a.e next2 : a2) {
                            if (next2 != null) {
                                next2.a(a3, e2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x008b A[Catch:{ InterruptedException -> 0x00d5, all -> 0x00d3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i() {
        /*
            r10 = this;
            java.lang.String r0 = "afterUpload delta:"
            java.lang.String r1 = "wait exception:"
            android.os.Handler r2 = r10.m
            r3 = 11
            boolean r2 = r2.hasMessages(r3)
            r3 = 1
            if (r2 == 0) goto L_0x0013
            r10.h()
            goto L_0x0016
        L_0x0013:
            r10.e(r3)
        L_0x0016:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "afterUpload message:"
            r2.<init>(r4)
            int r4 = r10.f
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            com.bytedance.sdk.component.e.a.c.c.a(r2)
            com.bytedance.sdk.component.e.a.b.a.a r2 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r2 = r2.b()
            com.bytedance.sdk.component.e.a.c.b.a(r2, r3)
            int r2 = r10.f
            r4 = 2
            if (r2 != r4) goto L_0x00ed
            com.bytedance.sdk.component.e.a.b.a.a r2 = com.bytedance.sdk.component.e.a.b.d.d
            java.util.concurrent.atomic.AtomicLong r2 = r2.g()
            com.bytedance.sdk.component.e.a.c.b.a(r2, r3)
            java.lang.Object r2 = r10.c
            monitor-enter(r2)
            long r5 = java.lang.System.nanoTime()     // Catch:{ InterruptedException -> 0x00d5 }
            java.lang.Object r7 = r10.c     // Catch:{ InterruptedException -> 0x00d5 }
            r8 = 5000(0x1388, double:2.4703E-320)
            r7.wait(r8)     // Catch:{ InterruptedException -> 0x00d5 }
            long r7 = java.lang.System.nanoTime()     // Catch:{ InterruptedException -> 0x00d5 }
            long r7 = r7 - r5
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ InterruptedException -> 0x00d5 }
            r9.<init>(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            r9.append(r7)     // Catch:{ InterruptedException -> 0x00d5 }
            java.lang.String r0 = " start:"
            r9.append(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            r9.append(r5)     // Catch:{ InterruptedException -> 0x00d5 }
            java.lang.String r0 = " condition:"
            r9.append(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.b.d r0 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00d5 }
            boolean r0 = r0.b     // Catch:{ InterruptedException -> 0x00d5 }
            if (r0 != 0) goto L_0x0077
            com.bytedance.sdk.component.e.a.b.d r0 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00d5 }
            boolean r0 = r0.c     // Catch:{ InterruptedException -> 0x00d5 }
            if (r0 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r0 = 0
            goto L_0x0078
        L_0x0077:
            r0 = 1
        L_0x0078:
            r9.append(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            java.lang.String r0 = r9.toString()     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.c.c.a(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            r5 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x00c3
            long r5 = r5 - r7
            r7 = 50000000(0x2faf080, double:2.47032823E-316)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 >= 0) goto L_0x0094
            goto L_0x00c3
        L_0x0094:
            com.bytedance.sdk.component.e.a.b.d r0 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00d5 }
            boolean r0 = r0.b     // Catch:{ InterruptedException -> 0x00d5 }
            if (r0 != 0) goto L_0x00b3
            com.bytedance.sdk.component.e.a.b.d r0 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ InterruptedException -> 0x00d5 }
            boolean r0 = r0.c     // Catch:{ InterruptedException -> 0x00d5 }
            if (r0 == 0) goto L_0x00a1
            goto L_0x00b3
        L_0x00a1:
            java.lang.String r0 = "afterUpload meet notifyRunOnce again"
            com.bytedance.sdk.component.e.a.c.c.c(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00d5 }
            java.util.concurrent.atomic.AtomicLong r0 = r0.J()     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.c.b.a(r0, r3)     // Catch:{ InterruptedException -> 0x00d5 }
            r10.c(r4)     // Catch:{ InterruptedException -> 0x00d5 }
            goto L_0x00e9
        L_0x00b3:
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00d5 }
            java.util.concurrent.atomic.AtomicLong r0 = r0.k()     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.c.b.a(r0, r3)     // Catch:{ InterruptedException -> 0x00d5 }
            java.lang.String r0 = "afterUpload wait serverBusy"
            com.bytedance.sdk.component.e.a.c.c.d(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00d3 }
            return
        L_0x00c3:
            java.lang.String r0 = "afterUpload wait timeout"
            com.bytedance.sdk.component.e.a.c.c.d(r0)     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.b.a.a r0 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ InterruptedException -> 0x00d5 }
            java.util.concurrent.atomic.AtomicLong r0 = r0.j()     // Catch:{ InterruptedException -> 0x00d5 }
            com.bytedance.sdk.component.e.a.c.b.a(r0, r3)     // Catch:{ InterruptedException -> 0x00d5 }
            monitor-exit(r2)     // Catch:{ all -> 0x00d3 }
            return
        L_0x00d3:
            r0 = move-exception
            goto L_0x00eb
        L_0x00d5:
            r0 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r3.<init>(r1)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00d3 }
            r3.append(r0)     // Catch:{ all -> 0x00d3 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x00d3 }
            com.bytedance.sdk.component.e.a.c.c.d(r0)     // Catch:{ all -> 0x00d3 }
        L_0x00e9:
            monitor-exit(r2)     // Catch:{ all -> 0x00d3 }
            goto L_0x00ed
        L_0x00eb:
            monitor-exit(r2)     // Catch:{ all -> 0x00d3 }
            throw r0
        L_0x00ed:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.c.c.i():void");
    }

    /* access modifiers changed from: private */
    public void a(boolean z, b bVar, List<a> list, long j2) {
        if (!z && bVar != null) {
            int i2 = bVar.b;
            int i3 = -2;
            if (bVar.e) {
                i2 = -1;
            } else if (i2 < 0) {
                i2 = -2;
            }
            if (i2 == 510 || i2 == 511) {
                i2 = -2;
            }
            if (bVar.a || ((i2 < 500 || i2 >= 509) && i2 <= 513)) {
                i3 = i2;
            }
            if (list != null) {
                com.bytedance.sdk.component.e.a.c.c.a("preprocessResult code is " + i3 + " sz:" + list.size() + "  count:" + this.l.get());
            }
            a(i3, list, j2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0129, code lost:
        com.bytedance.sdk.component.e.a.c.c.b("upload thread reuse or close: " + r5.b + " queue:" + r5.e.size() + " " + r5.f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0154, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r6, java.util.List<com.bytedance.sdk.component.e.a.d.a> r7, long r8) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.c
            monitor-enter(r0)
            if (r7 == 0) goto L_0x0155
            android.os.Handler r1 = r5.m     // Catch:{ all -> 0x0157 }
            if (r1 != 0) goto L_0x000b
            goto L_0x0155
        L_0x000b:
            com.bytedance.sdk.component.e.a.c.a.a((int) r6, (java.util.List<com.bytedance.sdk.component.e.a.d.a>) r7, (long) r8)     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.a.d r8 = r5.a     // Catch:{ all -> 0x0157 }
            r8.a((int) r6, (java.util.List<com.bytedance.sdk.component.e.a.d.a>) r7)     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.i r8 = com.bytedance.sdk.component.e.a.i.e()     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.f r8 = r8.m()     // Catch:{ all -> 0x0157 }
            if (r8 == 0) goto L_0x0026
            com.bytedance.sdk.component.e.a.h r8 = r8.m()     // Catch:{ all -> 0x0157 }
            if (r8 == 0) goto L_0x0026
            r8.a(r6, r7)     // Catch:{ all -> 0x0157 }
        L_0x0026:
            r7 = -2
            r8 = 1
            r9 = 3
            r1 = 0
            r2 = 2
            if (r6 == r7) goto L_0x00d9
            r7 = -1
            if (r6 == r7) goto L_0x0089
            if (r6 == 0) goto L_0x00d9
            r7 = 200(0xc8, float:2.8E-43)
            if (r6 == r7) goto L_0x0089
            r7 = 509(0x1fd, float:7.13E-43)
            if (r6 == r7) goto L_0x003c
            goto L_0x011a
        L_0x003c:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.b = r8     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.c = r1     // Catch:{ all -> 0x0157 }
            java.lang.String r6 = "-----------------  server busy start---------------- "
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x0058
            java.lang.String r6 = "already server busy message"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return
        L_0x0058:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0157 }
            long r3 = r5.g     // Catch:{ all -> 0x0157 }
            long r6 = r6 - r3
            r3 = 30000(0x7530, double:1.4822E-319)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 >= 0) goto L_0x006c
            java.lang.String r6 = "already server busy，too short"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return
        L_0x006c:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0157 }
            r5.g = r6     // Catch:{ all -> 0x0157 }
            java.lang.String r6 = "-----------------  server busy send---------------- "
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x0084
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            r6.removeMessages(r9)     // Catch:{ all -> 0x0157 }
        L_0x0084:
            r5.a((int) r2, (long) r3)     // Catch:{ all -> 0x0157 }
            goto L_0x011a
        L_0x0089:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.b     // Catch:{ all -> 0x0157 }
            if (r6 != 0) goto L_0x0095
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.c     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x011a
        L_0x0095:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.b = r1     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.c = r1     // Catch:{ all -> 0x0157 }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x00aa
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            r6.removeMessages(r2)     // Catch:{ all -> 0x0157 }
        L_0x00aa:
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x00b7
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            r6.removeMessages(r9)     // Catch:{ all -> 0x0157 }
        L_0x00b7:
            r6 = 0
            r5.h = r6     // Catch:{ all -> 0x0157 }
            r5.g = r6     // Catch:{ all -> 0x0157 }
            java.util.concurrent.atomic.AtomicInteger r6 = r5.o     // Catch:{ all -> 0x0157 }
            r6.set(r1)     // Catch:{ all -> 0x0157 }
            java.util.concurrent.atomic.AtomicInteger r6 = r5.p     // Catch:{ all -> 0x0157 }
            r6.set(r1)     // Catch:{ all -> 0x0157 }
            java.lang.String r6 = "--dispatchResult flush--"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.b.a.a r6 = com.bytedance.sdk.component.e.a.b.d.d     // Catch:{ all -> 0x0157 }
            java.util.concurrent.atomic.AtomicLong r6 = r6.L()     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.c.b.a(r6, r8)     // Catch:{ all -> 0x0157 }
            r5.c(r2)     // Catch:{ all -> 0x0157 }
            goto L_0x011a
        L_0x00d9:
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.b = r1     // Catch:{ all -> 0x0157 }
            com.bytedance.sdk.component.e.a.b.d r6 = com.bytedance.sdk.component.e.a.b.d.a     // Catch:{ all -> 0x0157 }
            r6.c = r8     // Catch:{ all -> 0x0157 }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r9)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x00f0
            java.lang.String r6 = "already routine error message"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return
        L_0x00f0:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0157 }
            long r3 = r5.h     // Catch:{ all -> 0x0157 }
            long r6 = r6 - r3
            r3 = 15000(0x3a98, double:7.411E-320)
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 >= 0) goto L_0x0104
            java.lang.String r6 = "already routine error,too short"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return
        L_0x0104:
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0157 }
            r5.h = r6     // Catch:{ all -> 0x0157 }
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            boolean r6 = r6.hasMessages(r2)     // Catch:{ all -> 0x0157 }
            if (r6 == 0) goto L_0x0117
            android.os.Handler r6 = r5.m     // Catch:{ all -> 0x0157 }
            r6.removeMessages(r2)     // Catch:{ all -> 0x0157 }
        L_0x0117:
            r5.a((int) r9, (long) r3)     // Catch:{ all -> 0x0157 }
        L_0x011a:
            int r6 = r5.f     // Catch:{ all -> 0x0157 }
            if (r6 != r2) goto L_0x0128
            java.lang.String r6 = "send notify"
            com.bytedance.sdk.component.e.a.c.c.a(r6)     // Catch:{ all -> 0x0157 }
            java.lang.Object r6 = r5.c     // Catch:{ all -> 0x0157 }
            r6.notify()     // Catch:{ all -> 0x0157 }
        L_0x0128:
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "upload thread reuse or close: "
            r6.<init>(r7)
            boolean r7 = r5.b
            r6.append(r7)
            java.lang.String r7 = " queue:"
            r6.append(r7)
            java.util.concurrent.PriorityBlockingQueue<com.bytedance.sdk.component.e.a.d.a> r7 = r5.e
            int r7 = r7.size()
            r6.append(r7)
            java.lang.String r7 = " "
            r6.append(r7)
            int r7 = r5.f
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            com.bytedance.sdk.component.e.a.c.c.b(r6)
            return
        L_0x0155:
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            return
        L_0x0157:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0157 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.e.a.b.c.c.a(int, java.util.List, long):void");
    }

    public void a(int i2, long j2) {
        if (this.m == null) {
            com.bytedance.sdk.component.e.a.c.c.d("mHandler == null");
            return;
        }
        Message obtain = Message.obtain();
        obtain.what = i2;
        if (i2 == 2) {
            int incrementAndGet = this.o.incrementAndGet();
            long j3 = ((long) (((incrementAndGet - 1) % 4) + 1)) * j2;
            com.bytedance.sdk.component.e.a.c.c.a("sendMonitorMessage:" + i2 + "  busy:" + incrementAndGet + "  l:" + j3);
            this.m.sendMessageDelayed(obtain, j3);
        } else if (i2 == 3) {
            int incrementAndGet2 = this.p.incrementAndGet();
            com.bytedance.sdk.component.e.a.c.c.a("sendMonitorMessage:" + i2 + "  error:" + incrementAndGet2);
            this.m.sendMessageDelayed(obtain, ((long) (((incrementAndGet2 + -1) % 4) + 1)) * j2);
        } else {
            com.bytedance.sdk.component.e.a.c.c.d("sendMonitorMessage error state");
        }
    }
}
