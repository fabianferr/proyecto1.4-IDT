package com.startapp;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.startapp.sdk.adsbase.remoteconfig.ComponentInfoEventConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* compiled from: Sta */
public class k7 {
    public static final boolean l = MetaData.k.Z();
    public final Handler a = new Handler(Looper.getMainLooper());
    public final Context b;
    public final AdPreferences.Placement c;
    public final String[] d;
    public final TrackingParams e;
    public long f;
    public long g;
    public boolean h;
    public boolean i;
    public final AtomicInteger j = new AtomicInteger();
    public WeakReference<a> k = new WeakReference<>((Object) null);

    /* compiled from: Sta */
    public interface a {
        void onSent(String str);
    }

    public k7(Context context, AdPreferences.Placement placement, String[] strArr, TrackingParams trackingParams, long j2) {
        this.b = h0.b(context);
        this.c = placement;
        this.d = strArr;
        this.e = trackingParams;
        this.f = j2;
    }

    public void a(a aVar) {
        this.k = new WeakReference<>(aVar);
    }

    public void b() {
        if (this.h && this.i) {
            this.a.removeCallbacksAndMessages((Object) null);
            this.f -= System.currentTimeMillis() - this.g;
            this.i = false;
        }
    }

    public void c() {
        if (a()) {
            return;
        }
        if (l) {
            long j2 = this.f;
            if (!this.i) {
                this.i = true;
                if (!this.h) {
                    this.h = true;
                }
                this.g = System.currentTimeMillis();
                this.a.postDelayed(new j7(this), j2);
                return;
            }
            return;
        }
        b((String) null, (JSONObject) null);
    }

    public void a(String str, JSONObject jSONObject) {
        b(str, jSONObject);
        this.h = false;
        this.a.removeCallbacksAndMessages((Object) null);
        this.i = false;
        this.g = 0;
    }

    public void b(String str, JSONObject jSONObject) {
        int i2 = 0;
        int i3 = 1;
        if (this.j.compareAndSet(0, 1)) {
            String str2 = null;
            if (str == null) {
                Context context = this.b;
                String[] strArr = this.d;
                TrackingParams trackingParams = this.e;
                if (!(context == null || strArr == null)) {
                    h3.a(context, (List<String>) Arrays.asList(strArr), trackingParams);
                }
                a aVar = (a) this.k.get();
                if (aVar != null) {
                    String[] strArr2 = this.d;
                    if (strArr2 != null && strArr2.length > 0) {
                        str2 = com.startapp.sdk.adsbase.a.a(strArr2[0], (String) null);
                    }
                    aVar.onSent(str2);
                }
                try {
                    e0 d2 = ComponentLocator.a(this.b).d();
                    AdPreferences.Placement placement = this.c;
                    Map<AdPreferences.Placement, Integer> map = d2.c;
                    Integer num = map.get(placement);
                    if (num != null) {
                        i2 = num.intValue();
                    }
                    map.put(placement, Integer.valueOf(i2 + 1));
                } catch (Throwable th) {
                    i3.a(th);
                }
            } else {
                Context context2 = this.b;
                String[] strArr3 = this.d;
                TrackingParams trackingParams2 = this.e;
                if (trackingParams2 != null) {
                    str2 = trackingParams2.a();
                }
                com.startapp.sdk.adsbase.a.a(context2, strArr3, str2, 0, str, jSONObject);
            }
        } else {
            int incrementAndGet = this.j.incrementAndGet();
            AnalyticsConfig analyticsConfig = MetaData.k.analytics;
            if (analyticsConfig != null) {
                if (str != null) {
                    i3 = 2;
                }
                ComponentInfoEventConfig i4 = analyticsConfig.i();
                if (i4 != null && i4.a((long) i3)) {
                    i3 i3Var = new i3(j3.d);
                    i3Var.d = "SI.repImp";
                    i3Var.i = "reason=" + str;
                    i3Var.e = String.valueOf(incrementAndGet);
                    i3Var.a();
                }
            }
        }
    }

    public boolean a() {
        return this.j.get() != 0;
    }
}
