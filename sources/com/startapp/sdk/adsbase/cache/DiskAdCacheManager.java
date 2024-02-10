package com.startapp.sdk.adsbase.cache;

import android.app.Activity;
import android.content.Context;
import com.startapp.a2;
import com.startapp.c0;
import com.startapp.d0;
import com.startapp.k;
import com.startapp.k9;
import com.startapp.sdk.ads.interstitials.InterstitialAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.HtmlAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.apppresence.AppPresenceDetails;
import com.startapp.sdk.adsbase.d;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.u4;
import com.startapp.v4;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class DiskAdCacheManager {

    /* compiled from: Sta */
    public static class DiskCacheKey implements Serializable {
        private static final long serialVersionUID = 7401552775422045093L;
        public AdPreferences adPreferences;
        private int numberOfLoadedAd;
        public AdPreferences.Placement placement;

        public DiskCacheKey(AdPreferences.Placement placement2, AdPreferences adPreferences2) {
            this.placement = placement2;
            this.adPreferences = adPreferences2;
        }

        public int a() {
            return this.numberOfLoadedAd;
        }

        public void a(int i) {
            this.numberOfLoadedAd = i;
        }
    }

    /* compiled from: Sta */
    public static class DiskCachedAd implements Serializable {
        private static final long serialVersionUID = -9194311006094821018L;
        private d ad;
        private String html;

        public DiskCachedAd(d dVar) {
            a(dVar);
            c();
        }

        public d a() {
            return this.ad;
        }

        public String b() {
            return this.html;
        }

        public final void c() {
            d dVar = this.ad;
            if (dVar != null && (dVar instanceof HtmlAd)) {
                this.html = ((HtmlAd) dVar).k();
            }
        }

        public final void a(d dVar) {
            this.ad = dVar;
        }
    }

    /* compiled from: Sta */
    public interface a {
    }

    /* compiled from: Sta */
    public interface b {
    }

    /* compiled from: Sta */
    public interface c {
    }

    public static void a(Context context, AdEventListener adEventListener) {
        k.a(context, adEventListener, (Ad) null, true);
    }

    public static String b() {
        return "startapp_ads".concat(File.separator).concat("keys");
    }

    public static String a() {
        return "startapp_ads".concat(File.separator).concat("interstitials");
    }

    public static void a(Context context, DiskCachedAd diskCachedAd, a aVar, AdEventListener adEventListener) {
        d a2 = diskCachedAd.a();
        a2.setContext(context);
        Map<Activity, Integer> map = k9.a;
        boolean z = true;
        if (a2 instanceof InterstitialAd) {
            InterstitialAd interstitialAd = (InterstitialAd) a2;
            String b2 = diskCachedAd.b();
            if (b2 == null || b2.equals("")) {
                a(context, adEventListener);
                return;
            }
            if (AdsCommonMetaData.h.H()) {
                List<AppPresenceDetails> a3 = d0.a(b2, 0);
                ArrayList arrayList = new ArrayList();
                if (d0.a(context, a3, 0, (Set<String>) new HashSet(), (List<AppPresenceDetails>) arrayList).booleanValue()) {
                    new c0(context, arrayList).a();
                    z = false;
                }
            }
            if (!z) {
                a(context, adEventListener);
                return;
            }
            d dVar = d.h;
            dVar.b.put(interstitialAd.l(), b2);
            ((g) aVar).a.e = interstitialAd;
            ComponentLocator.a(context).b.a().a(b2, new a2(context, adEventListener, interstitialAd));
        } else if (a2 instanceof OfferWall3DAd) {
            OfferWall3DAd offerWall3DAd = (OfferWall3DAd) a2;
            List<AdDetails> g = offerWall3DAd.g();
            if (g == null) {
                a(context, adEventListener);
                return;
            }
            if (AdsCommonMetaData.h.H()) {
                g = d0.a(context, g, 0, (Set<String>) new HashSet(), true);
            }
            if (g.size() > 0) {
                ((g) aVar).a.e = offerWall3DAd;
                u4 a4 = v4.b.a(offerWall3DAd.h());
                a4.getClass();
                a4.b = new ArrayList();
                a4.c = "";
                for (AdDetails a5 : g) {
                    a4.a(a5);
                }
                k.b(context, adEventListener, offerWall3DAd, true);
                return;
            }
            a(context, adEventListener);
        } else {
            a(context, adEventListener);
        }
    }
}
