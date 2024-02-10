package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import com.startapp.k;
import com.startapp.k9;
import com.startapp.p0;
import com.startapp.sdk.adsbase.adinformation.AdInformationOverrides;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.NotDisplayedReason;
import com.startapp.sdk.adsbase.cache.CacheMetaData;
import com.startapp.sdk.adsbase.consent.ConsentData;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.c;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.t7;
import java.io.Serializable;
import java.util.Map;

/* compiled from: Sta */
public abstract class Ad implements Serializable {
    public static boolean b = false;
    private static final long serialVersionUID = -9152265423662238762L;
    public transient Context a;
    public ActivityExtra activityExtra;
    public Long adCacheTtl = null;
    private AdInformationOverrides adInfoOverride;
    public boolean belowMinCPM = false;
    public ConsentData consentData;
    public String errorMessage;
    public Serializable extraData = null;
    private Long lastLoadTime = null;
    private NotDisplayedReason notDisplayedReason;
    public AdPreferences.Placement placement;
    private String requestUrl;
    private AdState state = AdState.UN_INITIALIZED;
    private AdType type;
    private boolean videoCancelCallBack;

    /* compiled from: Sta */
    public enum AdState {
        UN_INITIALIZED,
        PROCESSING,
        READY
    }

    /* compiled from: Sta */
    public enum AdType {
        INTERSTITIAL,
        RICH_TEXT,
        VIDEO,
        REWARDED_VIDEO,
        NON_VIDEO,
        VIDEO_NO_VAST
    }

    /* compiled from: Sta */
    public class a implements AdEventListener {
        public final /* synthetic */ AdEventListener a;

        public a(AdEventListener adEventListener) {
            this.a = adEventListener;
        }

        public void onFailedToReceiveAd(Ad ad) {
            k.a(Ad.this.a, this.a, ad, false);
            String errorMessage = ad != null ? ad.getErrorMessage() : null;
            String str = "";
            if (errorMessage == null) {
                errorMessage = str;
            } else if (errorMessage.contains("204")) {
                errorMessage = "NO FILL";
            }
            Context context = Ad.this.a;
            StringBuilder a2 = p0.a("Failed to load ");
            if (ad != null) {
                str = k9.a(ad);
            }
            a2.append(str);
            a2.append(" ad: ");
            a2.append(errorMessage);
            k9.a(context, 6, a2.toString(), true);
        }

        public void onReceiveAd(Ad ad) {
            Ad.a(Ad.this, Long.valueOf(System.currentTimeMillis()));
            k.b(Ad.this.a, this.a, ad, false);
            ConsentData consentData = ad.getConsentData();
            if (consentData != null) {
                ComponentLocator.a(Ad.this.a).g().a(consentData.f(), consentData.e(), consentData.a(), false, true);
            }
            Context context = Ad.this.a;
            StringBuilder a2 = p0.a("Loaded ");
            a2.append(k9.a(ad));
            a2.append(" ad with creative ID - ");
            a2.append(ad.getAdId());
            k9.a(context, 4, a2.toString(), true);
        }
    }

    /* compiled from: Sta */
    public class b implements c {
        public final /* synthetic */ AdPreferences a;
        public final /* synthetic */ AdEventListener b;

        public b(AdPreferences adPreferences, AdEventListener adEventListener) {
            this.a = adPreferences;
            this.b = adEventListener;
        }

        public void a(MetaDataRequest.RequestReason requestReason, boolean z) {
            Ad.this.a(this.a, this.b);
        }

        public void a(MetaDataRequest.RequestReason requestReason) {
            Ad.this.a(this.a, this.b);
        }
    }

    public Ad(Context context, AdPreferences.Placement placement2) {
        this.a = context;
        this.placement = placement2;
        Map<Activity, Integer> map = k9.a;
        this.adInfoOverride = AdInformationOverrides.a();
    }

    public void a(NotDisplayedReason notDisplayedReason2) {
        this.notDisplayedReason = notDisplayedReason2;
    }

    public abstract void a(AdPreferences adPreferences, AdEventListener adEventListener);

    public Long b() {
        return this.lastLoadTime;
    }

    public Long c() {
        long e = e();
        Long l = this.adCacheTtl;
        if (l != null) {
            e = Math.min(l.longValue(), e);
        }
        return Long.valueOf(e);
    }

    public boolean d() {
        if (this.lastLoadTime != null && System.currentTimeMillis() - this.lastLoadTime.longValue() > c().longValue()) {
            return true;
        }
        return false;
    }

    public long e() {
        return CacheMetaData.a.a().a();
    }

    public AdPreferences.Placement f() {
        return this.placement;
    }

    public abstract String getAdId();

    public AdInformationOverrides getAdInfoOverride() {
        return this.adInfoOverride;
    }

    public abstract String getBidToken();

    public final ConsentData getConsentData() {
        return this.consentData;
    }

    public Context getContext() {
        return this.a;
    }

    public String getDParam() {
        return null;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public Serializable getExtraData() {
        return this.extraData;
    }

    public NotDisplayedReason getNotDisplayedReason() {
        return this.notDisplayedReason;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public AdState getState() {
        return this.state;
    }

    public AdType getType() {
        return this.type;
    }

    public boolean isBelowMinCPM() {
        return this.belowMinCPM;
    }

    public boolean isReady() {
        return this.state == AdState.READY && !d();
    }

    @Deprecated
    public void load() {
        load(new AdPreferences(), (AdEventListener) null);
    }

    public void setActivityExtra(ActivityExtra activityExtra2) {
        this.activityExtra = activityExtra2;
    }

    public void setAdInfoOverride(AdInformationOverrides adInformationOverrides) {
        this.adInfoOverride = adInformationOverrides;
    }

    public void setContext(Context context) {
        this.a = context;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }

    public void setExtraData(Serializable serializable) {
        this.extraData = serializable;
    }

    public void setRequestUrl(String str) {
        this.requestUrl = str;
    }

    public void setState(AdState adState) {
        this.state = adState;
    }

    public static void a(Ad ad, Long l) {
        ad.lastLoadTime = l;
    }

    @Deprecated
    public void load(AdEventListener adEventListener) {
        load(new AdPreferences(), adEventListener);
    }

    public boolean a() {
        return this.videoCancelCallBack;
    }

    @Deprecated
    public void load(AdPreferences adPreferences) {
        load(adPreferences, (AdEventListener) null);
    }

    public void a(boolean z) {
        this.videoCancelCallBack = z;
    }

    @Deprecated
    public void load(AdPreferences adPreferences, AdEventListener adEventListener) {
        load(adPreferences, adEventListener, true);
    }

    public boolean load(AdPreferences adPreferences, AdEventListener adEventListener, boolean z) {
        String str;
        boolean z2;
        a aVar = new a(adEventListener);
        if (!b) {
            SimpleTokenUtils.f(this.a);
            b = true;
        }
        if (this.state != AdState.UN_INITIALIZED) {
            str = "load() was already called.";
            z2 = true;
        } else {
            str = "";
            z2 = false;
        }
        if (!k9.g(this.a)) {
            str = "network not available.";
            z2 = true;
        }
        if (!MetaData.k.b()) {
            str = "serving ads disabled";
            z2 = true;
        }
        if (z2) {
            setErrorMessage("Ad wasn't loaded: ".concat(str));
            k.a(this.a, aVar, this, false);
            return false;
        }
        setState(AdState.PROCESSING);
        b bVar = new b(adPreferences, aVar);
        if (adPreferences.getType() != null) {
            this.type = adPreferences.getType();
        }
        if (adPreferences.getPlacementId() == null) {
            adPreferences.setPlacementId(a.a(this.a, (Object) this));
        }
        MetaData metaData = MetaData.k;
        Context context = this.a;
        t7 t7Var = t7.d;
        metaData.a(context, adPreferences, t7.d.c, z, bVar, false);
        return true;
    }
}
