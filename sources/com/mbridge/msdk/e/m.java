package com.mbridge.msdk.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: MBridgeTrackManager */
public final class m {
    private static final ConcurrentHashMap<String, m> b = new ConcurrentHashMap<>();
    /* access modifiers changed from: private */
    public final k a;

    private m(String str, Context context, w wVar) {
        k kVar = new k(str, this);
        this.a = kVar;
        kVar.a(context);
        kVar.a(wVar);
    }

    public static m a(String str, Context context, w wVar) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ConcurrentHashMap<String, m> concurrentHashMap = b;
        m mVar = concurrentHashMap.get(str);
        if (!y.a((Object) mVar)) {
            return mVar;
        }
        m mVar2 = new m(str, context, wVar);
        concurrentHashMap.put(str, mVar2);
        return mVar2;
    }

    public final String b() {
        return this.a.b();
    }

    public final String c() {
        return this.a.c();
    }

    public static m[] d() {
        ConcurrentHashMap<String, m> concurrentHashMap = b;
        m[] mVarArr = new m[concurrentHashMap.size()];
        try {
            int i = 0;
            for (Map.Entry<String, m> value : concurrentHashMap.entrySet()) {
                mVarArr[i] = (m) value.getValue();
                i++;
            }
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "getAllTrackManager error", e);
            }
        }
        return mVarArr;
    }

    public final void e() {
        try {
            this.a.i().a(new Runnable() {
                public final void run() {
                    try {
                        t.a().c();
                        m.this.a.o().b();
                    } catch (Exception e) {
                        if (a.a) {
                            Log.e("TrackManager", "flush error", e);
                        }
                    }
                }
            });
        } catch (Exception e) {
            if (a.a) {
                Log.e("TrackManager", "flush error", e);
            }
        }
    }

    public final void a(JSONObject jSONObject) {
        this.a.a(jSONObject);
    }

    public final boolean a(String str) {
        return b(new e(str));
    }

    private boolean b(e eVar) {
        try {
            return c(eVar);
        } catch (Exception unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean c(e eVar) {
        if (y.a((Object) eVar) || TextUtils.isEmpty(eVar.a())) {
            return false;
        }
        return this.a.a(eVar);
    }

    public final void a(final e eVar) {
        if (!this.a.r()) {
            try {
                this.a.i().a(new Runnable() {
                    public final void run() {
                        if (m.this.c(eVar)) {
                            m.this.a.h().a(eVar);
                            eVar.c((long) m.this.a.d().f);
                            JSONObject d = eVar.d();
                            if (d != null) {
                                try {
                                    d.put("session_id", m.this.b());
                                    long[] f = m.this.f();
                                    d.put("track_time", f[0]);
                                    d.put("track_count", f[1]);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                eVar.a(d);
                            }
                            m.this.a.h().b(eVar);
                        }
                    }
                });
            } catch (Exception e) {
                if (a.a) {
                    Log.e("TrackManager", "trackEvent error", e);
                }
            }
        } else if (a.a) {
            Log.d("TrackManager", "SDK is shutdown, track event will not be processed");
        }
    }

    public final long[] f() {
        return this.a.h().a();
    }

    public final String a() {
        if (!(!this.a.r())) {
            return this.a.a();
        }
        if (a.a) {
            Log.e("TrackManager", "MBridgeTrackManager is already running");
        }
        return this.a.b();
    }
}
