package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.h.d;
import com.mbridge.msdk.foundation.same.net.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* compiled from: CommonReportEvent */
public final class b implements Serializable {
    private final String a;
    private final String b;
    private final String c;
    private final Executor d;
    /* access modifiers changed from: private */
    public final d e;
    /* access modifiers changed from: private */
    public final o f;
    private final long g;
    private final boolean h;
    private final ConcurrentHashMap<String, Object> i;
    private final ConcurrentHashMap<String, String> j;
    /* access modifiers changed from: private */
    public final Context k;
    private final a l;
    private final String m;
    private final String n;
    private final String o;
    private final String p;
    private final boolean q;
    private final m r;
    private String s;
    private final CampaignEx t;
    private final long u;
    private boolean v = false;
    private String w;

    /* renamed from: com.mbridge.msdk.foundation.same.report.b$b  reason: collision with other inner class name */
    /* compiled from: CommonReportEvent */
    public interface C0142b {
        void a(b bVar);

        void a(b bVar, int i, String str);
    }

    public b(a aVar) {
        this.l = aVar;
        this.a = aVar.a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.g;
        this.i = aVar.e;
        this.j = aVar.f;
        this.e = aVar.h;
        this.f = aVar.k;
        this.g = aVar.i;
        this.h = aVar.j;
        this.k = aVar.l;
        this.m = aVar.m;
        this.n = aVar.n;
        this.o = aVar.o;
        this.p = aVar.p;
        this.q = aVar.q;
        this.r = aVar.r;
        this.t = aVar.s;
        this.u = aVar.t;
        this.v = aVar.u;
        this.w = aVar.v;
    }

    public final a a() {
        return this.l;
    }

    public static a a(String str, String str2) {
        return new a(str, str2, "", 1, 1);
    }

    public final Executor c() {
        return this.d;
    }

    public final Context d() {
        return this.k;
    }

    public final String e() {
        return this.m;
    }

    public final String f() {
        return this.w;
    }

    public final String g() {
        return this.n;
    }

    public final String h() {
        return this.p;
    }

    public final String i() {
        return this.a;
    }

    public final boolean j() {
        return this.v;
    }

    public final boolean k() {
        return this.q;
    }

    public final m l() {
        return this.r;
    }

    public final int hashCode() {
        return this.l.hashCode();
    }

    public final ConcurrentHashMap<String, String> m() {
        return this.j;
    }

    public final long n() {
        return this.g;
    }

    public final boolean o() {
        return this.h;
    }

    public final void a(String str) {
        this.s = str;
    }

    public final String p() {
        return this.s;
    }

    public final long q() {
        return this.u;
    }

    /* compiled from: CommonReportEvent */
    public static class a {
        /* access modifiers changed from: private */
        public String a;
        /* access modifiers changed from: private */
        public final String b;
        /* access modifiers changed from: private */
        public final String c;
        private final String d;
        /* access modifiers changed from: private */
        public final ConcurrentHashMap<String, Object> e;
        /* access modifiers changed from: private */
        public final ConcurrentHashMap<String, String> f;
        /* access modifiers changed from: private */
        public Executor g;
        /* access modifiers changed from: private */
        public d h;
        /* access modifiers changed from: private */
        public long i;
        /* access modifiers changed from: private */
        public boolean j = false;
        /* access modifiers changed from: private */
        public o k;
        /* access modifiers changed from: private */
        public Context l;
        /* access modifiers changed from: private */
        public String m = "";
        /* access modifiers changed from: private */
        public String n = "";
        /* access modifiers changed from: private */
        public String o = "";
        /* access modifiers changed from: private */
        public String p = "";
        /* access modifiers changed from: private */
        public boolean q = false;
        /* access modifiers changed from: private */
        public m r;
        /* access modifiers changed from: private */
        public CampaignEx s;
        /* access modifiers changed from: private */
        public long t;
        /* access modifiers changed from: private */
        public boolean u = false;
        /* access modifiers changed from: private */
        public String v = "";

        public a(String str, String str2, String str3, int i2, int i3) {
            this.a = str;
            this.b = str2;
            if (TextUtils.isEmpty(str3)) {
                this.c = UUID.randomUUID().toString();
            } else {
                this.c = str3;
            }
            this.t = System.currentTimeMillis();
            this.d = UUID.randomUUID().toString();
            this.e = new ConcurrentHashMap<>(v.a(i2));
            this.f = new ConcurrentHashMap<>(v.a(i3));
        }

        public final a a(String str) {
            this.a = str;
            return this;
        }

        public final a a(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry next : map.entrySet()) {
                    if (next != null && !TextUtils.isEmpty((CharSequence) next.getKey()) && !TextUtils.isEmpty((CharSequence) next.getValue())) {
                        if (((String) next.getKey()).equals("b")) {
                            aa.d("CommonReport", (String) next.getValue());
                        }
                        this.f.put(next.getKey(), next.getValue());
                    }
                }
            }
            return this;
        }

        public final a a(Executor executor) {
            this.g = executor;
            return this;
        }

        public final a a(long j2) {
            this.i = j2;
            this.j = true;
            return this;
        }

        public final a a(Context context) {
            this.l = context;
            return this;
        }

        public final a b(String str) {
            this.m = str;
            return this;
        }

        public final a c(String str) {
            this.v = str;
            return this;
        }

        public final a d(String str) {
            this.n = str;
            return this;
        }

        public final a e(String str) {
            this.p = str;
            return this;
        }

        public final a a(boolean z) {
            this.q = z;
            return this;
        }

        public final a b(long j2) {
            this.t = j2;
            return this;
        }

        public final a b(boolean z) {
            this.u = z;
            return this;
        }

        public final b a() {
            if (this.g == null) {
                this.g = Executors.newSingleThreadExecutor(new ThreadFactory() {
                    public final Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "mb-common-report-thread");
                    }
                });
            }
            if (this.l == null) {
                this.l = com.mbridge.msdk.foundation.controller.b.d().g();
            }
            if (this.h == null) {
                this.h = new e();
            }
            if (this.k == null) {
                if (ac.a().a("metrics", "e_t_l", ac.a().a("e_t_l", 0)) == 1) {
                    this.k = new j();
                } else {
                    this.k = new f();
                }
            }
            if (this.r == null) {
                this.r = new com.mbridge.msdk.foundation.same.net.b(30000, 1);
            }
            return new b(this);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                try {
                    a aVar = (a) obj;
                    if (!Objects.equals(this.c, aVar.c) || !Objects.equals(this.d, aVar.d)) {
                        return false;
                    }
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(new Object[]{this.c, this.d});
        }
    }

    public final void b() {
        this.d.execute(new Runnable((C0142b) null) {
            public final void run() {
                b bVar = this;
                if (bVar == null) {
                    aa.d("CommonReport", "reportEvent is null !!!");
                    return;
                }
                d a2 = bVar.e;
                if (a2 == null) {
                    aa.d("CommonReport", "decorate is null !!!");
                    return;
                }
                o b2 = this.f;
                if (b2 == null) {
                    aa.d("CommonReport", "report is null !!!");
                    return;
                }
                try {
                    d a3 = a2.a(this);
                    if (a3 == null) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("CommonReport", "requestParams is null !!!");
                        }
                        C0142b bVar2 = null;
                        if (bVar2 != null) {
                            bVar2.a(this, 0, "requestParams is null");
                            return;
                        }
                        return;
                    }
                    b2.a(this.k, null, this, a3);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b("CommonReport", "report error", e);
                    }
                    C0142b bVar3 = null;
                    if (bVar3 != null) {
                        bVar3.a(this, 0, e.getMessage());
                    }
                }
            }
        });
    }
}
