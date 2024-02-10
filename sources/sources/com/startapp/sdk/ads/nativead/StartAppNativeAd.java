package com.startapp.sdk.ads.nativead;

import android.content.Context;
import com.startapp.e;
import com.startapp.f;
import com.startapp.k;
import com.startapp.p0;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adrules.AdRulesResult;
import com.startapp.sdk.adsbase.adrules.AdaptMetaData;
import com.startapp.sdk.adsbase.model.AdDetails;
import com.startapp.sdk.adsbase.model.AdPreferences;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Sta */
public class StartAppNativeAd extends Ad {
    private static final long serialVersionUID = -5904557568580515558L;
    private boolean belowMinCpm;
    private List<NativeAdDetails> listNativeAds = Collections.emptyList();
    /* access modifiers changed from: private */
    public final AtomicBoolean loading = new AtomicBoolean();
    private NativeAdPreferences preferences;

    /* compiled from: Sta */
    public enum CampaignAction {
        LAUNCH_APP,
        OPEN_MARKET
    }

    /* compiled from: Sta */
    public class a implements Runnable {
        public int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AdEventListener c;

        public a(int i, AdEventListener adEventListener) {
            this.b = i;
            this.c = adEventListener;
        }

        public void run() {
            int i = this.a + 1;
            this.a = i;
            if (i == this.b) {
                StartAppNativeAd.this.a(this.c);
            }
        }
    }

    /* compiled from: Sta */
    public class b implements AdEventListener {
        public final /* synthetic */ NativeAd a;
        public final /* synthetic */ NativeAdPreferences b;
        public final /* synthetic */ AdEventListener c;

        public b(NativeAd nativeAd, NativeAdPreferences nativeAdPreferences, AdEventListener adEventListener) {
            this.a = nativeAd;
            this.b = nativeAdPreferences;
            this.c = adEventListener;
        }

        public void onFailedToReceiveAd(Ad ad) {
            if (ad != null) {
                StartAppNativeAd.this.setErrorMessage(ad.getErrorMessage());
            }
            StartAppNativeAd startAppNativeAd = StartAppNativeAd.this;
            k.a(startAppNativeAd.a, this.c, startAppNativeAd, false);
            StartAppNativeAd.this.loading.set(false);
        }

        public void onReceiveAd(Ad ad) {
            StartAppNativeAd.this.a(this.a, this.b, this.c);
        }
    }

    public StartAppNativeAd(Context context) {
        super(context, AdPreferences.Placement.INAPP_NATIVE);
    }

    public static String getPrivacyImageUrl() {
        return AdInformationMetaData.a.d();
    }

    public static String getPrivacyURL() {
        if (AdInformationMetaData.a.b() == null) {
            return "";
        }
        String b2 = AdInformationMetaData.a.b();
        if (b2.contains("http://") || b2.contains("https://")) {
            return AdInformationMetaData.a.b();
        }
        StringBuilder a2 = p0.a("https://");
        a2.append(AdInformationMetaData.a.b());
        return a2.toString();
    }

    public void a(AdPreferences adPreferences, AdEventListener adEventListener) {
    }

    public final AdDetails g() {
        NativeAdDetails nativeAdDetails;
        if (this.listNativeAds.size() <= 0 || (nativeAdDetails = this.listNativeAds.get(0)) == null) {
            return null;
        }
        return nativeAdDetails.a;
    }

    public String getAdId() {
        AdDetails g = g();
        if (g != null) {
            return g.a();
        }
        return null;
    }

    public String getBidToken() {
        AdDetails g = g();
        if (g != null) {
            return g.d();
        }
        return null;
    }

    public ArrayList<NativeAdDetails> getNativeAds() {
        return getNativeAds((String) null);
    }

    public int getNumberOfAds() {
        return this.listNativeAds.size();
    }

    public boolean isBelowMinCPM() {
        return this.belowMinCpm;
    }

    @Deprecated
    public boolean loadAd() {
        return loadAd((AdEventListener) null);
    }

    public void setPreferences(NativeAdPreferences nativeAdPreferences) {
        this.preferences = nativeAdPreferences != null ? new NativeAdPreferences(nativeAdPreferences) : null;
    }

    public void a(NativeAd nativeAd, NativeAdPreferences nativeAdPreferences, AdEventListener adEventListener) {
        int size;
        this.belowMinCpm = nativeAd.isBelowMinCPM();
        List<AdDetails> g = nativeAd.g();
        if (g == null || (size = g.size()) <= 0) {
            a(adEventListener);
            return;
        }
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new NativeAdDetails(g.get(i)));
        }
        this.listNativeAds = Collections.unmodifiableList(arrayList);
        if (nativeAdPreferences.isAutoBitmapDownload()) {
            a aVar = new a(size, adEventListener);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((NativeAdDetails) it.next()).loadImages(this.a, aVar);
            }
            return;
        }
        a(adEventListener);
    }

    public ArrayList<NativeAdDetails> getNativeAds(String str) {
        ArrayList<NativeAdDetails> arrayList = new ArrayList<>();
        AdRulesResult a2 = AdaptMetaData.a.a().a(AdPreferences.Placement.INAPP_NATIVE, str);
        if (a2.b()) {
            for (NativeAdDetails next : this.listNativeAds) {
                next.f = str;
                arrayList.add(next);
            }
            f.d.a(new e(AdPreferences.Placement.INAPP_NATIVE, str));
        } else {
            ArrayList arrayList2 = new ArrayList();
            for (NativeAdDetails nativeAdDetails : this.listNativeAds) {
                arrayList2.add(nativeAdDetails.a);
            }
            com.startapp.sdk.adsbase.a.a(com.startapp.sdk.adsbase.a.a((List<AdDetails>) arrayList2), str, 0, a2.a());
        }
        return arrayList;
    }

    public boolean loadAd(AdEventListener adEventListener) {
        if (!this.loading.compareAndSet(false, true)) {
            setErrorMessage("Ad is currently being loaded");
            return false;
        }
        this.belowMinCpm = false;
        this.listNativeAds = Collections.emptyList();
        NativeAdPreferences nativeAdPreferences = this.preferences;
        if (nativeAdPreferences == null) {
            nativeAdPreferences = new NativeAdPreferences();
            this.preferences = nativeAdPreferences;
        }
        if (nativeAdPreferences.getPlacementId() == null) {
            nativeAdPreferences.setPlacementId(com.startapp.sdk.adsbase.a.a(this.a, (Object) this));
        }
        NativeAd nativeAd = new NativeAd(this.a, nativeAdPreferences);
        return nativeAd.load(nativeAdPreferences, new b(nativeAd, nativeAdPreferences, adEventListener), true);
    }

    @Deprecated
    public boolean loadAd(NativeAdPreferences nativeAdPreferences) {
        setPreferences(nativeAdPreferences);
        return loadAd((AdEventListener) null);
    }

    @Deprecated
    public boolean loadAd(NativeAdPreferences nativeAdPreferences, AdEventListener adEventListener) {
        setPreferences(nativeAdPreferences);
        return loadAd(adEventListener);
    }

    public final void a(AdEventListener adEventListener) {
        setErrorMessage((String) null);
        k.b(this.a, adEventListener, this, false);
        this.loading.set(false);
    }
}
