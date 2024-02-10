package com.startapp;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.startapp.k9;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.AdsConstants;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.model.GetAdRequest;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: Sta */
public abstract class r0 extends com.startapp.sdk.adsbase.b {
    public Set<String> g = new HashSet();
    public Set<String> h = new HashSet();
    public GetAdRequest i;
    public int j = 0;
    public final boolean k;
    public n l;

    /* compiled from: Sta */
    public class a implements g2<Throwable, Void> {
        public a() {
        }

        public Object a(Object obj) {
            Throwable th = (Throwable) obj;
            r0.this.f = th != null ? th.getMessage() : null;
            return null;
        }
    }

    public r0(Context context, Ad ad, AdPreferences adPreferences, AdEventListener adEventListener, AdPreferences.Placement placement, boolean z) {
        super(context, ad, adPreferences, adEventListener, placement);
        this.k = z;
    }

    public boolean a(Object obj) {
        if (obj == null) {
            if (this.f == null) {
                this.f = "No response";
            }
            return false;
        } else if (!(obj instanceof z5.a)) {
            if (this.f == null) {
                this.f = "Unknown error";
            }
            return false;
        } else {
            z5.a aVar = (z5.a) obj;
            String str = aVar.b;
            try {
                ArrayList arrayList = new ArrayList();
                if (TextUtils.isEmpty(str)) {
                    if (this.f == null) {
                        GetAdRequest getAdRequest = this.i;
                        if (getAdRequest == null || !getAdRequest.b()) {
                            this.f = "Empty Ad";
                        } else {
                            this.f = "Video isn't available";
                        }
                    }
                    return false;
                }
                boolean H = AdsCommonMetaData.h.H();
                String a2 = k9.a(str, "@adId@", "@adId@");
                if (a2 != null && a2.length() > 0) {
                    this.l = new n(a2, aVar, this.k, H);
                }
                List<AppPresenceDetails> a3 = d0.a(str, this.j);
                boolean z = H && d0.a(this.a, a3, this.j, this.g, (List<AppPresenceDetails>) arrayList).booleanValue();
                n nVar = this.l;
                if (nVar != null) {
                    nVar.f = z;
                }
                if (z) {
                    new c0(this.a, arrayList).a();
                } else {
                    HtmlAd htmlAd = (HtmlAd) this.b;
                    htmlAd.a(a3);
                    htmlAd.setRequestUrl(aVar.a);
                    htmlAd.c(str);
                }
                n nVar2 = this.l;
                if (nVar2 != null) {
                    nVar2.g = k9.a();
                }
                if (!z) {
                    return true;
                }
                f();
                this.j++;
                return b();
            } catch (Throwable th) {
                i3.a(th);
                return false;
            }
        }
    }

    public void b(boolean z) {
        this.b.setState(z ? Ad.AdState.READY : Ad.AdState.UN_INITIALIZED);
    }

    public boolean b(GetAdRequest getAdRequest) {
        return getAdRequest != null;
    }

    public void c(boolean z) {
        Intent intent = new Intent("com.startapp.android.OnReceiveResponseBroadcastListener");
        intent.putExtra("adHashcode", this.b.hashCode());
        intent.putExtra("adResult", z);
        w4.a(this.a).a(intent);
        if (!z) {
            k.a(this.a, a(), this.b, false);
            f();
        } else if (this.k) {
            n nVar = this.l;
            if (nVar != null) {
                nVar.h = k9.a();
            }
            ComponentLocator.a(this.a).b.a().a(((HtmlAd) this.b).k(), new b());
        } else {
            k.b(this.a, a(), this.b, false);
            f();
        }
    }

    public Object e() {
        GetAdRequest d = d();
        this.i = d;
        if (!b(d)) {
            return null;
        }
        if (this.g.size() == 0) {
            this.g.add(this.a.getPackageName());
        }
        GetAdRequest getAdRequest = this.i;
        getAdRequest.F0 = this.g;
        getAdRequest.H0 = this.h;
        if (this.j > 0) {
            getAdRequest.J0 = false;
            if (MetaData.k.K().a(this.a)) {
                SimpleTokenUtils.e(this.a);
            }
        }
        a3 m = ComponentLocator.a(this.a).m();
        try {
            return m.a(AdsConstants.a(AdsConstants.AdApiType.HTML, this.e), this.i, new a());
        } catch (Throwable th) {
            if (!m.a(1)) {
                return null;
            }
            i3.a(th);
            return null;
        }
    }

    public final void f() {
        n nVar = this.l;
        if (nVar != null) {
            try {
                ComponentLocator.a(this.a).H.a().a(nVar);
            } catch (Throwable th) {
                i3.a(th);
            }
            this.l = null;
        }
    }

    /* compiled from: Sta */
    public class b implements k9.b {
        public b() {
        }

        public void a(boolean z, long j, long j2, boolean z2) {
            r0 r0Var = r0.this;
            k.b(r0Var.a, r0Var.a(), r0.this.b, false);
            r0 r0Var2 = r0.this;
            n nVar = r0Var2.l;
            if (nVar != null) {
                nVar.e = z;
                nVar.i = j;
                nVar.j = j2;
                nVar.l = z2;
                r0Var2.f();
            }
        }

        public void a(int i, String str) {
            r0.this.b.setErrorMessage(str);
            r0 r0Var = r0.this;
            k.a(r0Var.a, r0Var.a(), r0.this.b, false);
            r0 r0Var2 = r0.this;
            n nVar = r0Var2.l;
            if (nVar != null) {
                nVar.k = i;
                r0Var2.f();
            }
        }
    }
}
