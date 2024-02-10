package com.startapp.sdk.adsbase;

import android.app.Activity;
import android.content.Context;
import androidx.core.view.ViewCompat;
import com.startapp.d9;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.j3;
import com.startapp.k9;
import com.startapp.sdk.adsbase.adrules.AdRules;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataStyle;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class AdsCommonMetaData implements Serializable {
    public static transient Object a = new Object();
    public static final Integer b = 18;
    public static final Integer c = -1;
    public static final Set<String> d = new HashSet(Arrays.asList(new String[]{"BOLD"}));
    public static final Integer e = Integer.valueOf(ViewCompat.MEASURED_STATE_MASK);
    public static final Integer f = -14803426;
    public static final Integer g = -1;
    public static AdsCommonMetaData h = new AdsCommonMetaData();
    private static final long serialVersionUID = -4342481322424952690L;
    private String acMetadataUpdateVersion = "4.11.0";
    @d9(complex = true)
    private AdRules adRules = new AdRules();
    private boolean appPresence = true;
    private boolean autoInterstitialEnabled = true;
    private Integer backgroundGradientBottom = -14606047;
    private Integer backgroundGradientTop = -14606047;
    private int defaultActivitiesBetweenAds = 1;
    private int defaultSecondsBetweenAds = 0;
    private boolean disableInAppStore = false;
    private boolean disableReturnAd = false;
    private boolean disableSplashAd = false;
    private boolean disableTwoClicks = false;
    private boolean enableForceExternalBrowser = false;
    private boolean enableSmartRedirect = true;
    private boolean enforceForeground = false;
    private Long explicitLoadIntervalMillis;
    private int forceExternalBrowserDaysInterval = 7;
    private Integer fullpageOfferWallProbability = 100;
    private Integer fullpageOverlayProbability = 0;
    private Integer homeProbability3D = 80;
    private Integer itemDescriptionTextColor = MetaDataStyle.e;
    @d9(type = HashSet.class)
    private Set<String> itemDescriptionTextDecoration = MetaDataStyle.f;
    private Integer itemDescriptionTextSize = MetaDataStyle.d;
    private Integer itemGradientBottom = -8750199;
    private Integer itemGradientTop = -14014151;
    private Integer itemTitleTextColor = MetaDataStyle.b;
    @d9(type = HashSet.class)
    private Set<String> itemTitleTextDecoration = MetaDataStyle.c;
    private Integer itemTitleTextSize = MetaDataStyle.a;
    private Integer maxAds = 10;
    private Integer poweredByBackgroundColor = f;
    private Integer poweredByTextColor = g;
    private Integer probability3D = 0;
    private long returnAdMinBackgroundTime = 300;
    private long smartRedirectLoadedTimeout = 1000;
    private int smartRedirectTimeout = 5;
    @d9(type = HashMap.class, value = MetaDataStyle.class)
    private HashMap<String, MetaDataStyle> templates = new HashMap<>();
    private Integer titleBackgroundColor = -14803426;
    private String titleContent = "Recommended for you";
    private Integer titleLineColor = e;
    private Integer titleTextColor = c;
    @d9(type = HashSet.class)
    private Set<String> titleTextDecoration = d;
    private Integer titleTextSize = b;
    @d9(complex = true)
    private VideoConfig video = new VideoConfig();

    public static void a(Context context) {
        AdsCommonMetaData adsCommonMetaData = (AdsCommonMetaData) f2.a(context, "StartappAdsMetadata", AdsCommonMetaData.class);
        AdsCommonMetaData adsCommonMetaData2 = new AdsCommonMetaData();
        if (adsCommonMetaData != null) {
            boolean b2 = k9.b(adsCommonMetaData, adsCommonMetaData2);
            if (!(!"4.11.0".equals(adsCommonMetaData.acMetadataUpdateVersion)) && b2) {
                i3 i3Var = new i3(j3.e);
                i3Var.d = "metadata_null";
                i3Var.a();
            }
            AdRules adRules2 = adsCommonMetaData.adRules;
            adRules2.getClass();
            adRules2.a = new HashSet();
            h = adsCommonMetaData;
            return;
        }
        h = adsCommonMetaData2;
    }

    public static AdsCommonMetaData k() {
        return h;
    }

    public Integer A() {
        return this.titleBackgroundColor;
    }

    public String B() {
        return this.titleContent;
    }

    public Integer C() {
        return this.titleLineColor;
    }

    public Integer D() {
        return this.titleTextColor;
    }

    public Set<String> E() {
        return this.titleTextDecoration;
    }

    public Integer F() {
        return this.titleTextSize;
    }

    public VideoConfig G() {
        return this.video;
    }

    public boolean H() {
        return this.appPresence;
    }

    public boolean I() {
        return this.autoInterstitialEnabled;
    }

    public boolean J() {
        return this.disableInAppStore;
    }

    public boolean K() {
        return this.disableReturnAd;
    }

    public boolean L() {
        return this.disableSplashAd;
    }

    public boolean M() {
        return this.disableTwoClicks;
    }

    public boolean N() {
        return this.enableSmartRedirect;
    }

    public boolean O() {
        return this.enforceForeground;
    }

    public AdRules b() {
        return this.adRules;
    }

    public int c() {
        return this.backgroundGradientBottom.intValue();
    }

    public int d() {
        return this.backgroundGradientTop.intValue();
    }

    public int e() {
        return this.forceExternalBrowserDaysInterval;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdsCommonMetaData adsCommonMetaData = (AdsCommonMetaData) obj;
        if (this.returnAdMinBackgroundTime != adsCommonMetaData.returnAdMinBackgroundTime || this.disableReturnAd != adsCommonMetaData.disableReturnAd || this.disableSplashAd != adsCommonMetaData.disableSplashAd || this.smartRedirectTimeout != adsCommonMetaData.smartRedirectTimeout || this.smartRedirectLoadedTimeout != adsCommonMetaData.smartRedirectLoadedTimeout || this.enableSmartRedirect != adsCommonMetaData.enableSmartRedirect || this.autoInterstitialEnabled != adsCommonMetaData.autoInterstitialEnabled || this.defaultActivitiesBetweenAds != adsCommonMetaData.defaultActivitiesBetweenAds || this.defaultSecondsBetweenAds != adsCommonMetaData.defaultSecondsBetweenAds || this.disableTwoClicks != adsCommonMetaData.disableTwoClicks || this.appPresence != adsCommonMetaData.appPresence || this.disableInAppStore != adsCommonMetaData.disableInAppStore || this.forceExternalBrowserDaysInterval != adsCommonMetaData.forceExternalBrowserDaysInterval || this.enableForceExternalBrowser != adsCommonMetaData.enableForceExternalBrowser || this.enforceForeground != adsCommonMetaData.enforceForeground || !k9.a(this.acMetadataUpdateVersion, adsCommonMetaData.acMetadataUpdateVersion) || !k9.a(this.probability3D, adsCommonMetaData.probability3D) || !k9.a(this.homeProbability3D, adsCommonMetaData.homeProbability3D) || !k9.a(this.fullpageOfferWallProbability, adsCommonMetaData.fullpageOfferWallProbability) || !k9.a(this.fullpageOverlayProbability, adsCommonMetaData.fullpageOverlayProbability) || !k9.a(this.backgroundGradientTop, adsCommonMetaData.backgroundGradientTop) || !k9.a(this.backgroundGradientBottom, adsCommonMetaData.backgroundGradientBottom) || !k9.a(this.maxAds, adsCommonMetaData.maxAds) || !k9.a(this.explicitLoadIntervalMillis, adsCommonMetaData.explicitLoadIntervalMillis) || !k9.a(this.titleBackgroundColor, adsCommonMetaData.titleBackgroundColor) || !k9.a(this.titleContent, adsCommonMetaData.titleContent) || !k9.a(this.titleTextSize, adsCommonMetaData.titleTextSize) || !k9.a(this.titleTextColor, adsCommonMetaData.titleTextColor) || !k9.a(this.titleTextDecoration, adsCommonMetaData.titleTextDecoration) || !k9.a(this.titleLineColor, adsCommonMetaData.titleLineColor) || !k9.a(this.itemGradientTop, adsCommonMetaData.itemGradientTop) || !k9.a(this.itemGradientBottom, adsCommonMetaData.itemGradientBottom) || !k9.a(this.itemTitleTextSize, adsCommonMetaData.itemTitleTextSize) || !k9.a(this.itemTitleTextColor, adsCommonMetaData.itemTitleTextColor) || !k9.a(this.itemTitleTextDecoration, adsCommonMetaData.itemTitleTextDecoration) || !k9.a(this.itemDescriptionTextSize, adsCommonMetaData.itemDescriptionTextSize) || !k9.a(this.itemDescriptionTextColor, adsCommonMetaData.itemDescriptionTextColor) || !k9.a(this.itemDescriptionTextDecoration, adsCommonMetaData.itemDescriptionTextDecoration) || !k9.a(this.templates, adsCommonMetaData.templates) || !k9.a(this.adRules, adsCommonMetaData.adRules) || !k9.a(this.poweredByBackgroundColor, adsCommonMetaData.poweredByBackgroundColor) || !k9.a(this.poweredByTextColor, adsCommonMetaData.poweredByTextColor) || !k9.a(this.video, adsCommonMetaData.video)) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.defaultActivitiesBetweenAds;
    }

    public int g() {
        return this.defaultSecondsBetweenAds;
    }

    public Long h() {
        return this.explicitLoadIntervalMillis;
    }

    public int hashCode() {
        Object[] objArr = {this.acMetadataUpdateVersion, this.probability3D, this.homeProbability3D, this.fullpageOfferWallProbability, this.fullpageOverlayProbability, this.backgroundGradientTop, this.backgroundGradientBottom, this.maxAds, this.explicitLoadIntervalMillis, this.titleBackgroundColor, this.titleContent, this.titleTextSize, this.titleTextColor, this.titleTextDecoration, this.titleLineColor, this.itemGradientTop, this.itemGradientBottom, this.itemTitleTextSize, this.itemTitleTextColor, this.itemTitleTextDecoration, this.itemDescriptionTextSize, this.itemDescriptionTextColor, this.itemDescriptionTextDecoration, this.templates, this.adRules, this.poweredByBackgroundColor, this.poweredByTextColor, Long.valueOf(this.returnAdMinBackgroundTime), Boolean.valueOf(this.disableReturnAd), Boolean.valueOf(this.disableSplashAd), Integer.valueOf(this.smartRedirectTimeout), Long.valueOf(this.smartRedirectLoadedTimeout), Boolean.valueOf(this.enableSmartRedirect), Boolean.valueOf(this.autoInterstitialEnabled), Integer.valueOf(this.defaultActivitiesBetweenAds), Integer.valueOf(this.defaultSecondsBetweenAds), Boolean.valueOf(this.disableTwoClicks), Boolean.valueOf(this.appPresence), Boolean.valueOf(this.disableInAppStore), this.video, Integer.valueOf(this.forceExternalBrowserDaysInterval), Boolean.valueOf(this.enableForceExternalBrowser), Boolean.valueOf(this.enforceForeground)};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public int i() {
        return this.fullpageOfferWallProbability.intValue();
    }

    public int j() {
        return this.fullpageOverlayProbability.intValue();
    }

    public Integer l() {
        return this.itemDescriptionTextColor;
    }

    public Set<String> m() {
        return this.itemDescriptionTextDecoration;
    }

    public Integer n() {
        return this.itemDescriptionTextSize;
    }

    public int o() {
        return this.itemGradientBottom.intValue();
    }

    public int p() {
        return this.itemGradientTop.intValue();
    }

    public Integer q() {
        return this.itemTitleTextColor;
    }

    public Set<String> r() {
        return this.itemTitleTextDecoration;
    }

    public Integer s() {
        return this.itemTitleTextSize;
    }

    public int t() {
        return this.maxAds.intValue();
    }

    public Integer u() {
        return this.poweredByBackgroundColor;
    }

    public Integer v() {
        return this.poweredByTextColor;
    }

    public int w() {
        return this.probability3D.intValue();
    }

    public long x() {
        return TimeUnit.SECONDS.toMillis(this.returnAdMinBackgroundTime);
    }

    public long y() {
        return this.smartRedirectLoadedTimeout;
    }

    public long z() {
        return TimeUnit.SECONDS.toMillis((long) this.smartRedirectTimeout);
    }

    public MetaDataStyle a(String str) {
        return this.templates.get(str);
    }

    public boolean a() {
        return this.enableForceExternalBrowser;
    }

    public static void a(Context context, AdsCommonMetaData adsCommonMetaData) {
        synchronized (a) {
            adsCommonMetaData.acMetadataUpdateVersion = "4.11.0";
            h = adsCommonMetaData;
            f2.a(context, "StartappAdsMetadata", (Serializable) adsCommonMetaData);
        }
    }
}
