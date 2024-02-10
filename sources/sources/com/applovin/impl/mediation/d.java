package com.applovin.impl.mediation;

import android.content.Context;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.c.b;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.impl.sdk.utils.j;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

public class d {
    /* access modifiers changed from: private */
    public final m a;
    private final Map<String, b> b = CollectionUtils.map(4);
    private final Object c = new Object();
    private final Map<String, com.applovin.impl.mediation.a.a> d = CollectionUtils.map(4);
    private final Object e = new Object();

    private static class a implements a.C0011a {
        /* access modifiers changed from: private */
        public final m a;
        /* access modifiers changed from: private */
        public final WeakReference<Context> b;
        /* access modifiers changed from: private */
        public final d c;
        /* access modifiers changed from: private */
        public final b d;
        /* access modifiers changed from: private */
        public final MaxAdFormat e;
        /* access modifiers changed from: private */
        public final Map<String, Object> f;
        /* access modifiers changed from: private */
        public final Map<String, Object> g;
        private final int h;

        private a(Map<String, Object> map, Map<String, Object> map2, b bVar, MaxAdFormat maxAdFormat, d dVar, m mVar, Context context) {
            this.a = mVar;
            this.b = new WeakReference<>(context);
            this.c = dVar;
            this.d = bVar;
            this.e = maxAdFormat;
            this.g = map2;
            this.f = map;
            this.h = CollectionUtils.getBoolean(map2, AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES) ? -1 : (!maxAdFormat.isAdViewAd() || !CollectionUtils.getBoolean(map2, "auto_refresh_stopped")) ? ((Integer) mVar.a(com.applovin.impl.sdk.d.a.M)).intValue() : Math.min(2, ((Integer) mVar.a(com.applovin.impl.sdk.d.a.M)).intValue());
        }

        public void onAdClicked(MaxAd maxAd) {
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
            throw new IllegalStateException("Wrong callback invoked for ad: " + maxAd);
        }

        public void onAdLoadFailed(final String str, MaxError maxError) {
            if (!this.a.a(com.applovin.impl.sdk.d.a.N, this.e) || this.d.c >= this.h) {
                int unused = this.d.c = 0;
                this.d.b.set(false);
                if (this.d.d != null) {
                    ((MaxErrorImpl) maxError).setLoadTag(this.d.a);
                    j.a((MaxAdListener) this.d.d, str, maxError);
                    a.C0011a unused2 = this.d.d = null;
                    return;
                }
                return;
            }
            b.e(this.d);
            final int pow = (int) Math.pow(2.0d, (double) this.d.c);
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() {
                public void run() {
                    a.this.g.put("retry_delay_sec", Integer.valueOf(pow));
                    a.this.g.put("retry_attempt", Integer.valueOf(a.this.d.c));
                    Context context = (Context) a.this.b.get();
                    if (context == null) {
                        context = a.this.a.L();
                    }
                    a.this.c.a(str, a.this.e, a.this.f, a.this.g, context, a.this);
                }
            }, TimeUnit.SECONDS.toMillis((long) pow));
        }

        public void onAdLoaded(MaxAd maxAd) {
            com.applovin.impl.mediation.a.a aVar = (com.applovin.impl.mediation.a.a) maxAd;
            aVar.a(this.d.a);
            int unused = this.d.c = 0;
            if (this.d.d != null) {
                aVar.g().e().a(this.d.d);
                this.d.d.onAdLoaded(aVar);
                if (aVar.d().endsWith("load")) {
                    this.d.d.onAdRevenuePaid(aVar);
                }
                a.C0011a unused2 = this.d.d = null;
                if ((this.a.b(com.applovin.impl.sdk.d.a.L).contains(maxAd.getAdUnitId()) || this.a.a(com.applovin.impl.sdk.d.a.K, maxAd.getFormat())) && !this.a.J().a() && !this.a.J().b()) {
                    Context context = (Context) this.b.get();
                    if (context == null) {
                        context = this.a.L();
                    }
                    this.c.a(maxAd.getAdUnitId(), maxAd.getFormat(), this.f, this.g, context, this);
                    return;
                }
            } else {
                this.c.a(aVar);
            }
            this.d.b.set(false);
        }

        public void onAdRequestStarted(String str) {
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
        }
    }

    private static class b {
        /* access modifiers changed from: private */
        public final String a;
        /* access modifiers changed from: private */
        public final AtomicBoolean b;
        /* access modifiers changed from: private */
        public int c;
        /* access modifiers changed from: private */
        public volatile a.C0011a d;

        private b(String str) {
            this.b = new AtomicBoolean();
            this.a = str;
        }

        static /* synthetic */ int e(b bVar) {
            int i = bVar.c;
            bVar.c = i + 1;
            return i;
        }
    }

    public d(m mVar) {
        this.a = mVar;
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.a.a aVar) {
        synchronized (this.e) {
            if (this.d.containsKey(aVar.getAdUnitId()) && u.a()) {
                u.i("AppLovinSdk", "Ad in cache already: " + aVar.getAdUnitId());
            }
            this.d.put(aVar.getAdUnitId(), aVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        final String str2 = str;
        final MaxAdFormat maxAdFormat2 = maxAdFormat;
        final Map<String, Object> map3 = map;
        final Map<String, Object> map4 = map2;
        final Context context2 = context;
        final a.C0011a aVar2 = aVar;
        this.a.S().a((com.applovin.impl.sdk.f.a) new com.applovin.impl.mediation.c.b(maxAdFormat, map, context, this.a, new b.a() {
            public void a(JSONArray jSONArray) {
                d.this.a.S().a((com.applovin.impl.sdk.f.a) new c(str2, maxAdFormat2, map3, map4, jSONArray, context2, d.this.a, aVar2));
            }
        }), com.applovin.impl.mediation.d.c.a(maxAdFormat));
    }

    private com.applovin.impl.mediation.a.a b(String str) {
        com.applovin.impl.mediation.a.a aVar;
        synchronized (this.e) {
            aVar = this.d.get(str);
            this.d.remove(str);
        }
        return aVar;
    }

    private b b(String str, String str2) {
        b bVar;
        synchronized (this.c) {
            String c2 = c(str, str2);
            bVar = this.b.get(c2);
            if (bVar == null) {
                bVar = new b(str2);
                this.b.put(c2, bVar);
            }
        }
        return bVar;
    }

    private String c(String str, String str2) {
        String str3;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str2 != null) {
            str3 = "-" + str2;
        } else {
            str3 = "";
        }
        sb.append(str3);
        return sb.toString();
    }

    public void a(String str, String str2) {
        synchronized (this.c) {
            this.b.remove(c(str, str2));
        }
    }

    public void a(String str, String str2, MaxAdFormat maxAdFormat, Map<String, Object> map, Map<String, Object> map2, Context context, a.C0011a aVar) {
        a.C0011a aVar2 = aVar;
        com.applovin.impl.mediation.a.a b2 = (this.a.J().b() || Utils.isDspDemoApp(this.a.L())) ? null : b(str);
        String str3 = str2;
        if (b2 != null) {
            b2.a(str2);
            b2.g().e().a(aVar2);
            aVar2.onAdLoaded(b2);
            if (b2.d().endsWith("load")) {
                aVar2.onAdRevenuePaid(b2);
            }
        }
        b b3 = b(str, str2);
        if (b3.b.compareAndSet(false, true)) {
            if (b2 == null) {
                a.C0011a unused = b3.d = aVar2;
            }
            a(str, maxAdFormat, map, map2, context, new a(map, map2, b3, maxAdFormat, this, this.a, context));
            return;
        }
        if (!(b3.d == null || b3.d == aVar2 || !u.a())) {
            StringBuilder sb = new StringBuilder("Attempting to load ad for same ad unit id (");
            String str4 = str;
            sb.append(str);
            sb.append(") while another ad load is already in progress!");
            u.h("MediationAdLoadManager", sb.toString());
        }
        a.C0011a unused2 = b3.d = aVar2;
    }

    public boolean a(String str) {
        boolean z;
        synchronized (this.e) {
            z = this.d.get(str) != null;
        }
        return z;
    }
}
