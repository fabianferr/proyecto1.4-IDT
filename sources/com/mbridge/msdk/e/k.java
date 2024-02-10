package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.e.w;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: Global */
class k {
    private static x a = null;
    private static String o = "";
    private final String b;
    private final m c;
    private Context d;
    private w e;
    private JSONObject f;
    private List<String> g;
    private List<String> h;
    private volatile c i;
    private volatile l j;
    private volatile d k;
    private volatile j l;
    private volatile r m;
    private volatile boolean n = true;
    private n p;

    k(String str, m mVar) {
        this.b = str;
        this.c = mVar;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        if (!y.a((Object) this.d) && !y.a((Object) this.e)) {
            try {
                o().a();
                this.n = false;
                if (TextUtils.isEmpty(o)) {
                    o = UUID.randomUUID().toString();
                }
                if (!y.a((Object) a)) {
                    try {
                        a.a(b(), this.b, this.c);
                        t.a().b();
                    } catch (Exception e2) {
                        if (a.a) {
                            Log.e("TrackManager", "track manager start exception", e2);
                        }
                    }
                }
                return o;
            } catch (Exception e3) {
                if (a.a) {
                    Log.e("TrackManager", "start error", e3);
                }
                this.n = true;
            }
        }
        return "";
    }

    /* access modifiers changed from: package-private */
    public final String b() {
        if (!TextUtils.isEmpty(o)) {
            return o;
        }
        String uuid = UUID.randomUUID().toString();
        o = uuid;
        return uuid;
    }

    /* access modifiers changed from: package-private */
    public final String c() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context) {
        this.d = context;
    }

    /* access modifiers changed from: package-private */
    public final void a(w wVar) {
        this.e = wVar;
    }

    /* access modifiers changed from: package-private */
    public final w d() {
        w wVar = this.e;
        if (wVar != null) {
            return wVar;
        }
        w a2 = new w.a().a();
        this.e = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public final Context e() {
        return this.d;
    }

    /* access modifiers changed from: package-private */
    public final void a(JSONObject jSONObject) {
        this.f = jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final JSONObject f() {
        JSONObject jSONObject = this.f;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        this.f = jSONObject2;
        return jSONObject2;
    }

    /* access modifiers changed from: package-private */
    public final c g() {
        String str;
        if (y.a((Object) this.i)) {
            synchronized (k.class) {
                if (y.a((Object) this.i)) {
                    Context context = this.d;
                    if (TextUtils.isEmpty(this.b)) {
                        str = String.format("track_manager_%s.db", new Object[]{"default"});
                    } else {
                        str = String.format("track_manager_%s.db", new Object[]{this.b});
                    }
                    this.i = new c(new b(context, str, "event_table"), "event_table");
                }
            }
        }
        return this.i;
    }

    /* access modifiers changed from: package-private */
    public final l h() {
        if (y.a((Object) this.j)) {
            synchronized (k.class) {
                if (y.a((Object) this.j)) {
                    this.j = new p(new g(g(), o(), i()));
                }
            }
        }
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final j i() {
        if (y.a((Object) this.l)) {
            synchronized (k.class) {
                if (y.a((Object) this.l)) {
                    this.l = new j();
                }
            }
        }
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final d j() {
        if (y.a((Object) this.k)) {
            this.k = d().h;
        }
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final m k() {
        return this.c;
    }

    /* access modifiers changed from: package-private */
    public final int l() {
        if (d().a < 0) {
            return 50;
        }
        return d().a;
    }

    /* access modifiers changed from: package-private */
    public final int m() {
        return Math.max(d().b, 0);
    }

    /* access modifiers changed from: package-private */
    public final int n() {
        return Math.max(d().e, 0);
    }

    /* access modifiers changed from: package-private */
    public final r o() {
        if (y.a((Object) this.m)) {
            synchronized (k.class) {
                if (y.a((Object) this.m)) {
                    this.m = new r(this);
                }
            }
        }
        return this.m;
    }

    /* access modifiers changed from: package-private */
    public final boolean a(e eVar) {
        if (y.a((Object) eVar)) {
            return false;
        }
        f fVar = d().j;
        if (y.b((Object) fVar)) {
            try {
                return fVar.a(eVar);
            } catch (Exception e2) {
                if (a.a) {
                    Log.e("TrackManager", "event filter apply exception", e2);
                }
            }
        }
        String a2 = eVar.a();
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        List<String> list = this.h;
        if (list != null) {
            try {
                return !list.contains(a2);
            } catch (Exception e3) {
                if (a.a) {
                    Log.e("TrackManager", "disallowTrackEventNames contains exception", e3);
                }
            }
        }
        List<String> list2 = this.g;
        if (list2 != null) {
            try {
                return list2.contains(a2);
            } catch (Exception e4) {
                if (a.a) {
                    Log.e("TrackManager", "allowTrackEventNames contains exception", e4);
                }
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean p() throws IllegalStateException {
        if (y.a((Object) d())) {
            throw new IllegalStateException("config can not be null");
        } else if (y.a((Object) j())) {
            throw new IllegalStateException("decorate can not be null");
        } else if (y.a((Object) d().i)) {
            throw new IllegalStateException("responseHandler can not be null");
        } else if (y.a((Object) d().g) || y.a((Object) d().g.c())) {
            throw new IllegalStateException("networkStackConfig or stack can not be null");
        } else if (!TextUtils.isEmpty(d().g.b())) {
            return true;
        } else {
            throw new IllegalStateException("report url is null");
        }
    }

    /* access modifiers changed from: package-private */
    public final n q() {
        if (y.a((Object) this.p)) {
            synchronized (k.class) {
                if (y.a((Object) this.p)) {
                    this.p = new n(d().d <= 0 ? 2 : d().d, d().g, d().i, d().c);
                }
            }
        }
        return this.p;
    }

    /* access modifiers changed from: package-private */
    public final boolean r() {
        return this.n;
    }
}
