package com.mbridge.msdk.e;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: ReportManager */
final class r {
    /* access modifiers changed from: private */
    public final c a;
    private final int b;
    /* access modifiers changed from: private */
    public final int c;
    private final int d;
    /* access modifiers changed from: private */
    public final k e;
    /* access modifiers changed from: private */
    public final AtomicInteger f = new AtomicInteger(0);
    /* access modifiers changed from: private */
    public final AtomicInteger g = new AtomicInteger(0);
    private final Object h = new Object();
    private Handler i;
    private boolean j = true;
    /* access modifiers changed from: private */
    public long k = 0;
    private volatile boolean l = false;
    private volatile boolean m = false;

    public r(k kVar) {
        this.a = kVar.g();
        this.b = kVar.l();
        this.c = kVar.m();
        this.d = kVar.n();
        this.e = kVar;
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("report_timer");
        handlerThread.start();
        b bVar = new b(handlerThread.getLooper(), this);
        this.i = bVar;
        bVar.sendMessageDelayed(Message.obtain(bVar, 5), 5000);
        Handler handler = this.i;
        handler.sendMessageDelayed(Message.obtain(handler, 1), (long) this.c);
        this.j = false;
    }

    public final void b() {
        this.i.removeMessages(1);
        Handler handler = this.i;
        handler.sendMessage(Message.obtain(handler, 7));
    }

    public final void a(e eVar) {
        Handler handler = this.i;
        handler.sendMessage(Message.obtain(handler, 6, eVar));
    }

    public final void c() {
        synchronized (this.h) {
            if (!this.l) {
                this.l = true;
                this.a.c();
            }
            if (!this.m) {
                this.m = true;
                this.g.set(this.a.a());
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean d() {
        return this.g.get() >= this.b;
    }

    /* access modifiers changed from: package-private */
    public final boolean e() {
        return this.j;
    }

    /* compiled from: ReportManager */
    private static final class b extends Handler {
        private final r a;

        public b(Looper looper, r rVar) {
            super(looper);
            this.a = rVar;
        }

        public final void dispatchMessage(Message message) {
            super.dispatchMessage(message);
            int i = message.what;
            if (i == 2 || i == 3) {
                b();
                if (a.a) {
                    a("触发上报（report result）当前 Event 数量：");
                }
                a();
            } else if (i == 5) {
                if (a.a) {
                    a("触发删除 当前 Event 数量：");
                }
                r.c(this.a);
                sendMessageDelayed(Message.obtain(this, 5), 120000);
            } else if (i == 6) {
                this.a.g.incrementAndGet();
                e eVar = message.obj instanceof e ? (e) message.obj : null;
                boolean z = false;
                if (a.a && !y.a((Object) eVar)) {
                    a(String.format("收到 Event( %s )，当前 Event 数量：", new Object[]{eVar.a()}));
                }
                if (y.b((Object) eVar) && eVar.c() == 1) {
                    z = true;
                }
                if (z || this.a.d()) {
                    b();
                    if (a.a) {
                        a("触发上报（notice check）当前 Event 数量：");
                    }
                    if (y.a(this.a.e.e())) {
                        a();
                    } else if (a.a) {
                        Log.d("TrackManager", "当前网络不可用");
                    }
                }
            } else if (i != 7) {
                b();
                if (y.a(this.a.e.e())) {
                    if (a.a) {
                        a("触发上报（timer）当前 Event 数量：");
                    }
                    a();
                } else if (a.a) {
                    Log.d("TrackManager", "当前网络不可用");
                }
            } else {
                this.a.c();
                b();
                if (a.a) {
                    a("触发上报（flush）当前 Event 数量：");
                }
                a();
            }
        }

        private void a(String str) {
            Log.d("TrackManager", str + this.a.g.get() + " 数据库记录数：" + this.a.a.a());
        }

        private void a() {
            try {
                r.f(this.a);
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "report failed ", e);
                }
            }
        }

        private void b() {
            try {
                removeMessages(1);
                removeMessages(6);
                removeMessages(2);
                removeMessages(3);
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "removeMessages failed ", e);
                }
            }
            if (!this.a.e()) {
                try {
                    sendMessageDelayed(Message.obtain(this, 1), y.a(this.a.f.get(), this.a.k, (long) this.a.c));
                } catch (Exception e2) {
                    if (a.a) {
                        Log.e("TrackManager", "sendMessageDelayed failed ", e2);
                    }
                }
            }
        }
    }

    /* compiled from: ReportManager */
    private static final class a implements q {
        private final Handler a;
        private final r b;

        public a(Handler handler, r rVar) {
            this.a = handler;
            this.b = rVar;
        }

        public final void a(s sVar) {
            r.a(this.b, (List) sVar.a());
            this.b.f.set(0);
            long unused = this.b.k = 0;
            Handler handler = this.a;
            handler.sendMessage(Message.obtain(handler, 2));
            if (a.a) {
                Log.d("TrackManager", "report success " + sVar.a().size() + " 剩余事件数：" + this.b.g.get() + " 个，数据库记录数：" + this.b.a.a() + " 个");
            }
        }

        public final void a(s sVar, int i, String str) {
            r.b(this.b, sVar.a());
            long unused = this.b.k = System.currentTimeMillis();
            int k = this.b.f.getAndIncrement();
            if (k <= 10) {
                Handler handler = this.a;
                handler.sendMessageDelayed(Message.obtain(handler, 3), ((long) k) * 1000);
            }
            if (a.a) {
                Log.d("TrackManager", "report failed " + sVar.a().size() + " 剩余事件数：" + this.b.g.get() + " 个，数据库记录数：" + this.b.a.a() + " 个 连续失败次数： " + k);
            }
        }
    }

    static /* synthetic */ void c(r rVar) {
        int b2 = rVar.a.b();
        if (a.a) {
            Log.d("TrackManager", "删除无效数据的数量 = " + b2 + " 当前剩余事件数 = " + rVar.g.get() + " 数据库中剩余事件数 = " + rVar.a.a());
        }
    }

    static /* synthetic */ void f(r rVar) {
        boolean z;
        List<i> a2 = rVar.a.a(rVar.b);
        if (!y.a((List<?>) a2)) {
            rVar.a.a(a2);
            AtomicInteger atomicInteger = rVar.g;
            atomicInteger.set(atomicInteger.get() - a2.size());
            if (a.a) {
                Log.d("TrackManager", "report: 上报的数量 = " + a2.size() + " 当前剩余事件数 = " + rVar.g.get() + " 数据库中剩余事件数 = " + rVar.a.a());
            }
            try {
                z = rVar.e.p();
            } catch (IllegalStateException e2) {
                if (a.a) {
                    Log.e("TrackManager", "report environment check failed ", e2);
                }
                z = false;
            }
            if (z) {
                n q = rVar.e.q();
                q.a(new a(rVar.i, rVar));
                Map<String, String> hashMap = new HashMap<>();
                try {
                    hashMap = rVar.e.j().a(rVar.e.k(), a2, rVar.e.f());
                } catch (Exception e3) {
                    if (a.a) {
                        Log.e("TrackManager", "report decorate request params failed ", e3);
                    }
                }
                q.a(new s(a2), hashMap, y.b(a2));
            } else if (a.a) {
                Log.e("TrackManager", "report 失败，请检查 TrackConfig 配置是否正确");
            }
        } else if (a.a) {
            Log.d("TrackManager", "report: 没有可以上报的数据");
        }
    }

    static /* synthetic */ void a(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            rVar.a.b((List<i>) list);
        }
    }

    static /* synthetic */ void b(r rVar, List list) {
        if (!y.a((List<?>) list)) {
            Iterator it = list.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                i iVar = (i) it.next();
                if (!y.a((Object) iVar)) {
                    boolean z = !iVar.b() && iVar.d() >= rVar.d;
                    boolean z2 = !iVar.a() && iVar.g() < System.currentTimeMillis();
                    if (z || z2) {
                        iVar.b(-1);
                    } else {
                        iVar.a(iVar.d() + 1);
                        iVar.b(3);
                        i2++;
                    }
                }
            }
            rVar.a.c((List<i>) list);
            AtomicInteger atomicInteger = rVar.g;
            atomicInteger.set(atomicInteger.get() + i2);
        }
    }
}
