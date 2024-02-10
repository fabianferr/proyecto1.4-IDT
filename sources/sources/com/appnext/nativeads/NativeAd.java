package com.appnext.nativeads;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.SettingsManager;
import com.appnext.core.d;
import com.appnext.core.f;
import com.appnext.core.g;
import com.appnext.core.i;
import com.appnext.core.j;
import com.appnext.core.n;
import com.appnext.core.p;
import com.appnext.core.result.ResultPageActivity;
import com.appnext.core.result.c;
import com.appnext.nativeads.MediaView;
import com.appnext.nativeads.NativeAdRequest;
import com.appnext.nativeads.NativeAdView;
import com.bykv.vk.openvk.preload.falconx.statistic.StatisticData;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAd {
    /* access modifiers changed from: private */
    public NativeAdListener adListener;
    /* access modifiers changed from: private */
    public NativeAdView.a adViewActions;
    /* access modifiers changed from: private */
    public boolean clicked = false;
    private List<View> clicksListView;
    /* access modifiers changed from: private */
    public NativeAdRequest.CreativeType creativeType;
    /* access modifiers changed from: private */
    public Handler handler;
    private String language;
    /* access modifiers changed from: private */
    public NativeAdData loadedAd;
    /* access modifiers changed from: private */
    public MediaView mediaView;
    /* access modifiers changed from: private */
    public NativeAdObject nativeAdObject;
    /* access modifiers changed from: private */
    public NativeAdView nativeAdView;
    private int privacyPolicyColor = 0;
    private int privacyPolicyPosition = 1;
    private int privacyPolicyVisibility = 0;
    /* access modifiers changed from: private */
    public boolean reportedImpression = false;
    /* access modifiers changed from: private */
    public boolean reportedVTA = false;
    /* access modifiers changed from: private */
    public p userAction;

    public NativeAd(Context context, String str) {
        this.nativeAdObject = createAd(context, str);
        a.aC().g(ScarConstants.TOKEN_ID_KEY, this.nativeAdObject.getTID());
        a.aC().a(context, str, (SettingsManager.ConfigCallback) null);
        this.clicksListView = new ArrayList();
        this.adViewActions = new NativeAdView.a() {
            public final void d(int i) {
                try {
                    if (!NativeAd.this.reportedImpression && i >= Integer.parseInt(a.aC().t("min_imp_precentage"))) {
                        int parseInt = Integer.parseInt(a.aC().t("postpone_impression_sec"));
                        if (!Boolean.parseBoolean(a.aC().t("repeat_viewable_criteria")) || parseInt <= 0) {
                            if (!NativeAd.this.reportedImpression) {
                                NativeAd.this.reportedImpression = true;
                                NativeAd.this.impression();
                            }
                        } else if (NativeAd.this.handler != null) {
                            NativeAd.this.handler.postDelayed(new Runnable() {
                                public final void run() {
                                    try {
                                        if (NativeAd.this.nativeAdView != null && !NativeAd.this.reportedImpression && NativeAd.this.nativeAdView.getVisiblePercent(NativeAd.this.nativeAdView) >= Integer.parseInt(a.aC().t("min_imp_precentage"))) {
                                            NativeAd.this.impression();
                                            NativeAd.this.reportedImpression = true;
                                        }
                                    } catch (Throwable th) {
                                        com.appnext.base.a.a("NativeAd$NativeAd", th);
                                    }
                                }
                            }, (long) (parseInt * 1000));
                        }
                    }
                    if (!NativeAd.this.reportedVTA && i >= Integer.parseInt(a.aC().t("min_vta_precentage"))) {
                        int parseInt2 = Integer.parseInt(a.aC().t("postpone_vta_sec"));
                        if (!Boolean.parseBoolean(a.aC().t("repeat_vta_viewable_criteria")) || parseInt2 <= 0) {
                            if (!NativeAd.this.reportedVTA && NativeAd.this.loadedAd != null) {
                                NativeAd.this.reportedVTA = true;
                                NativeAd.this.userAction.a(NativeAd.this.loadedAd, NativeAd.this.loadedAd.getImpressionURL(), (f.a) null);
                            }
                        } else if (NativeAd.this.handler != null) {
                            NativeAd.this.handler.postDelayed(new Runnable() {
                                public final void run() {
                                    try {
                                        if (NativeAd.this.nativeAdView != null && !NativeAd.this.reportedVTA && NativeAd.this.loadedAd != null && NativeAd.this.nativeAdView.getVisiblePercent(NativeAd.this.nativeAdView) >= Integer.parseInt(a.aC().t("min_vta_precentage"))) {
                                            NativeAd.this.userAction.a(NativeAd.this.loadedAd, NativeAd.this.loadedAd.getImpressionURL(), (f.a) null);
                                            NativeAd.this.reportedVTA = true;
                                        }
                                    } catch (Throwable th) {
                                        com.appnext.base.a.a("NativeAd$NativeAd", th);
                                    }
                                }
                            }, (long) (parseInt2 * 1000));
                        }
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("NativeAd$NativeAd", th);
                }
            }
        };
        this.handler = new Handler();
        this.userAction = new p(context, new p.a() {
            public final void report(String str) {
            }

            public final Ad c() {
                return NativeAd.this.nativeAdObject;
            }

            public final AppnextAd d() {
                return NativeAd.this.loadedAd;
            }

            public final SettingsManager e() {
                return a.aC();
            }
        });
    }

    public void getAdByPackage(NativeAdRequest nativeAdRequest, String str) {
        try {
            if (!g.g(this.nativeAdObject.getContext())) {
                NativeAdListener nativeAdListener = this.adListener;
                if (nativeAdListener != null) {
                    nativeAdListener.onError(this, new AppnextError(AppnextError.CONNECTION_ERROR));
                }
            } else if (this.handler != null) {
                final NativeAdRequest nativeAdRequest2 = new NativeAdRequest(nativeAdRequest);
                this.nativeAdObject.setPackageName(str);
                this.nativeAdObject.setCategories(nativeAdRequest2.getCategories());
                this.nativeAdObject.setSpecificCategories(nativeAdRequest2.getSpecificCategories());
                this.nativeAdObject.setPostback(nativeAdRequest2.getPostback());
                this.nativeAdObject.setMinVideoLength(nativeAdRequest2.getMinVideoLength());
                this.nativeAdObject.setMaxVideoLength(nativeAdRequest2.getMaxVideoLength());
                this.creativeType = nativeAdRequest2.getCreativeType();
                report("caching_" + nativeAdRequest2.getCachingPolicy());
                a.aC().a(this.nativeAdObject.getContext(), this.nativeAdObject.getPlacementID(), new SettingsManager.ConfigCallback() {
                    public final void loaded(HashMap<String, Object> hashMap) {
                        try {
                            NativeAd.this.load(nativeAdRequest2);
                        } catch (Throwable th) {
                            com.appnext.base.a.a("NativeAd$getAdByPackage", th);
                        }
                    }

                    public final void error(String str) {
                        try {
                            NativeAd.this.load(nativeAdRequest2);
                        } catch (Throwable th) {
                            com.appnext.base.a.a("NativeAd$getAdByPackage", th);
                        }
                    }
                });
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$getAdByPackage", th);
        }
    }

    public void loadAd(NativeAdRequest nativeAdRequest) {
        getAdByPackage(nativeAdRequest, (String) null);
    }

    /* access modifiers changed from: private */
    public void load(final NativeAdRequest nativeAdRequest) {
        b aE = b.aE();
        Context context = this.nativeAdObject.getContext();
        NativeAdObject nativeAdObject2 = this.nativeAdObject;
        aE.a(context, nativeAdObject2, nativeAdObject2.getPlacementID(), new d.a() {
            /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final <T> void a(T r7) {
                /*
                    r6 = this;
                    java.lang.String r7 = "NativeAd$load"
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    android.os.Handler r0 = r0.handler     // Catch:{ all -> 0x0109 }
                    if (r0 != 0) goto L_0x000b
                    return
                L_0x000b:
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    r1 = 0
                    r0.reportedImpression = r1     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    r0.reportedVTA = r1     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest r0 = r7     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoLength r0 = r0.getVideoLength()     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoLength r1 = com.appnext.nativeads.NativeAdRequest.VideoLength.DEFAULT     // Catch:{ all -> 0x0109 }
                    if (r0 != r1) goto L_0x0037
                    com.appnext.nativeads.NativeAdRequest r0 = r7     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.a r1 = com.appnext.nativeads.a.aC()     // Catch:{ all -> 0x0109 }
                    java.lang.String r2 = "default_video_length"
                    java.lang.String r1 = r1.t(r2)     // Catch:{ all -> 0x0109 }
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoLength r1 = com.appnext.nativeads.NativeAdRequest.VideoLength.fromInt(r1)     // Catch:{ all -> 0x0109 }
                    r0.setVideoLength(r1)     // Catch:{ all -> 0x0109 }
                L_0x0037:
                    com.appnext.nativeads.NativeAdRequest r0 = r7     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoQuality r0 = r0.getVideoQuality()     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoQuality r1 = com.appnext.nativeads.NativeAdRequest.VideoQuality.DEFAULT     // Catch:{ all -> 0x0109 }
                    if (r0 != r1) goto L_0x0058
                    com.appnext.nativeads.NativeAdRequest r0 = r7     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.a r1 = com.appnext.nativeads.a.aC()     // Catch:{ all -> 0x0109 }
                    java.lang.String r2 = "default_video_quality"
                    java.lang.String r1 = r1.t(r2)     // Catch:{ all -> 0x0109 }
                    int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$VideoQuality r1 = com.appnext.nativeads.NativeAdRequest.VideoQuality.fromInt(r1)     // Catch:{ all -> 0x0109 }
                    r0.setVideoQuality(r1)     // Catch:{ all -> 0x0109 }
                L_0x0058:
                    com.appnext.nativeads.b r0 = com.appnext.nativeads.b.aE()     // Catch:{ all -> 0x0073 }
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0073 }
                    com.appnext.nativeads.NativeAdObject r1 = r1.nativeAdObject     // Catch:{ all -> 0x0073 }
                    android.content.Context r1 = r1.getContext()     // Catch:{ all -> 0x0073 }
                    com.appnext.nativeads.NativeAd r2 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0073 }
                    com.appnext.nativeads.NativeAdObject r2 = r2.nativeAdObject     // Catch:{ all -> 0x0073 }
                    com.appnext.nativeads.NativeAdRequest r3 = r7     // Catch:{ all -> 0x0073 }
                    com.appnext.core.AppnextAd r0 = r0.a((android.content.Context) r1, (com.appnext.core.Ad) r2, (com.appnext.nativeads.NativeAdRequest) r3)     // Catch:{ all -> 0x0073 }
                    goto L_0x0078
                L_0x0073:
                    r0 = move-exception
                    com.appnext.base.a.a(r7, r0)     // Catch:{ all -> 0x0109 }
                    r0 = 0
                L_0x0078:
                    if (r0 != 0) goto L_0x009c
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdListener r0 = r0.adListener     // Catch:{ all -> 0x0109 }
                    if (r0 == 0) goto L_0x009b
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    java.lang.String r1 = "error_no_ads"
                    r0.report(r1)     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r0 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdListener r0 = r0.adListener     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.core.AppnextError r2 = new com.appnext.core.AppnextError     // Catch:{ all -> 0x0109 }
                    java.lang.String r3 = "No Ads"
                    r2.<init>(r3)     // Catch:{ all -> 0x0109 }
                    r0.onError(r1, r2)     // Catch:{ all -> 0x0109 }
                L_0x009b:
                    return
                L_0x009c:
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest r2 = r7     // Catch:{ all -> 0x0109 }
                    r1.setLoadedAd(r0, r2)     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.MediaView r1 = r1.mediaView     // Catch:{ all -> 0x0109 }
                    if (r1 == 0) goto L_0x00c4
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.MediaView r1 = r1.mediaView     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r2 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdData r3 = r2.loadedAd     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r4 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdRequest$CreativeType r5 = r4.creativeType     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.MediaView$MediaType r4 = r4.creativeToMediaType(r5)     // Catch:{ all -> 0x0109 }
                    r1.a(r2, r3, r4)     // Catch:{ all -> 0x0109 }
                L_0x00c4:
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdView r1 = r1.nativeAdView     // Catch:{ all -> 0x0109 }
                    if (r1 == 0) goto L_0x00e1
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdView r1 = r1.nativeAdView     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r2 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdData r3 = r2.loadedAd     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r4 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdView$a r4 = r4.adViewActions     // Catch:{ all -> 0x0109 }
                    r1.a(r2, r3, r4)     // Catch:{ all -> 0x0109 }
                L_0x00e1:
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdListener r1 = r1.adListener     // Catch:{ all -> 0x0109 }
                    if (r1 == 0) goto L_0x0108
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdListener r1 = r1.adListener     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r2 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.core.AppnextAdCreativeType r3 = r0.getCreativeType()     // Catch:{ all -> 0x0109 }
                    r1.onAdLoaded(r2, r3)     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r1 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAdListener r1 = r1.adListener     // Catch:{ all -> 0x0109 }
                    com.appnext.nativeads.NativeAd r2 = com.appnext.nativeads.NativeAd.this     // Catch:{ all -> 0x0109 }
                    com.appnext.core.AppnextAdCreativeType r0 = r0.getCreativeType()     // Catch:{ all -> 0x0109 }
                    r3 = 1
                    r1.onAdLoaded(r2, r0, r3, r3)     // Catch:{ all -> 0x0109 }
                L_0x0108:
                    return
                L_0x0109:
                    r0 = move-exception
                    com.appnext.base.a.a(r7, r0)
                    com.appnext.nativeads.NativeAd r7 = com.appnext.nativeads.NativeAd.this
                    java.lang.String r0 = "Internal error"
                    r7.onError(r0)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.appnext.nativeads.NativeAd.AnonymousClass4.a(java.lang.Object):void");
            }

            public final void error(String str) {
                NativeAd.this.onError(str);
            }
        }, nativeAdRequest);
    }

    /* access modifiers changed from: private */
    public void onError(String str) {
        try {
            if (this.adListener != null) {
                if (str != null) {
                    if (!str.equals(AppnextError.NO_ADS)) {
                        if (!str.equals(AppnextError.INTERNAL_ERROR)) {
                            report("error_" + str.toLowerCase().replace(" ", "_"));
                            this.adListener.onError(this, new AppnextError(str));
                            return;
                        }
                    }
                }
                report("error_no_ads");
                this.adListener.onError(this, new AppnextError(AppnextError.NO_ADS));
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$load", th);
        }
    }

    /* access modifiers changed from: protected */
    public void setLoadedAd(AppnextAd appnextAd, NativeAdRequest nativeAdRequest) {
        try {
            NativeAdData nativeAdData = new NativeAdData(appnextAd);
            this.loadedAd = nativeAdData;
            nativeAdData.setAppURL(this.loadedAd.getAppURL() + "&tem_id=" + this.nativeAdObject.getTemId(this.loadedAd));
            NativeAdData nativeAdData2 = this.loadedAd;
            nativeAdData2.setImpressionURL(this.loadedAd.getImpressionURL() + "&tem_id=" + this.nativeAdObject.getTemId(this.loadedAd));
            try {
                b.aE();
                String a2 = b.a(nativeAdRequest, (AppnextAd) this.loadedAd);
                if (!a2.equals("")) {
                    this.loadedAd.F(a2);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$setLoadedAd", th);
        }
    }

    /* access modifiers changed from: private */
    public MediaView.MediaType creativeToMediaType(NativeAdRequest.CreativeType creativeType2) {
        if (creativeType2 == NativeAdRequest.CreativeType.STATIC_ONLY) {
            return MediaView.MediaType.STATIC;
        }
        return MediaView.MediaType.VIDEO;
    }

    /* access modifiers changed from: protected */
    public NativeAdObject createAd(Context context, String str) {
        return new NativeAdObject(context, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.nativeAdObject;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoaded() {
        /*
            r1 = this;
            com.appnext.nativeads.NativeAdData r0 = r1.loadedAd
            if (r0 == 0) goto L_0x0010
            com.appnext.nativeads.NativeAdObject r0 = r1.nativeAdObject
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isAdLoaded()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.nativeads.NativeAd.isLoaded():boolean");
    }

    public void setAdListener(NativeAdListener nativeAdListener) {
        if (nativeAdListener != null) {
            this.adListener = nativeAdListener;
        }
    }

    public String getCategories() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getCategories();
    }

    public String getSpecificCategories() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getSpecificCategories();
    }

    public String getAdDescription() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getAdDescription();
    }

    public String getAdTitle() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getAdTitle();
    }

    public String getCTAText() {
        try {
            if (this.loadedAd == null) {
                return null;
            }
            boolean b = g.b(this.nativeAdObject.getContext(), this.loadedAd.getAdPackage());
            String str = "existing";
            if (!this.loadedAd.getButtonText().equals("")) {
                com.appnext.core.a.a n = com.appnext.core.a.a.n(this.nativeAdObject.getContext());
                String language2 = getLanguage();
                if (!b) {
                    str = "new";
                }
                return n.a(language2, str, this.loadedAd.getButtonText());
            } else if (b) {
                return com.appnext.core.a.a.n(this.nativeAdObject.getContext()).a(getLanguage(), str, a.aC().t("existing_button_text"));
            } else {
                return com.appnext.core.a.a.n(this.nativeAdObject.getContext()).a(getLanguage(), "new", a.aC().t("new_button_text"));
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$getCTAText", th);
            return "";
        }
    }

    public String getIconURL() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getImageURL();
    }

    public String getWideImageURL() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getWideImageURL();
    }

    public String getVideoUrl() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getSelectedVideo();
    }

    public String getBannerID() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getBannerID();
    }

    public String getCountry() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getCountry();
    }

    public String getSupportedVersion() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getSupportedVersion();
    }

    public String getStoreRating() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getStoreRating();
    }

    public String getStoreDownloads() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getStoreDownloads();
    }

    public String getAppSize() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getAppSize();
    }

    public String getAppPackageName() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return nativeAdData.getAdPackage();
    }

    public float getECPM() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return 0.0f;
        }
        return nativeAdData.getECPM();
    }

    public String getSessionID() {
        NativeAdData nativeAdData = this.loadedAd;
        return nativeAdData == null ? "" : nativeAdData.getSessionID();
    }

    public float getPPR() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return 0.0f;
        }
        return nativeAdData.getPPR();
    }

    public boolean isGPRD() {
        NativeAdData nativeAdData = this.loadedAd;
        return nativeAdData != null && nativeAdData.isGdpr();
    }

    public String getPPU() {
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData == null) {
            return null;
        }
        return g.e((AppnextAd) nativeAdData);
    }

    public void setMediaView(MediaView mediaView2) {
        this.mediaView = mediaView2;
        NativeAdData nativeAdData = this.loadedAd;
        if (nativeAdData != null && mediaView2 != null) {
            mediaView2.a(this, nativeAdData, creativeToMediaType(this.creativeType));
        }
    }

    public MediaView getMediaView() {
        return this.mediaView;
    }

    public void setNativeAdView(NativeAdView nativeAdView2) {
        NativeAdData nativeAdData;
        NativeAdView nativeAdView3 = this.nativeAdView;
        if (nativeAdView3 != null) {
            nativeAdView3.aD();
        }
        this.nativeAdView = nativeAdView2;
        if (nativeAdView2 != null && (nativeAdData = this.loadedAd) != null) {
            nativeAdView2.a(this, nativeAdData, this.adViewActions);
        }
    }

    public void setParams(String str, String str2) {
        a.aC().i(str, str2);
    }

    /* access modifiers changed from: private */
    public void impression() {
        try {
            if (this.loadedAd != null) {
                this.reportedImpression = true;
                report("impression_event");
                this.userAction.d(this.loadedAd);
                n.aa().a(new Runnable() {
                    public final void run() {
                        try {
                            if (NativeAd.this.getNativeAdView() != null) {
                                com.appnext.core.adswatched.a.l(NativeAd.this.getNativeAdView().getContext()).j(NativeAd.this.loadedAd.getBannerID(), NativeAd.this.nativeAdObject.getAUID());
                            }
                        } catch (Throwable unused) {
                        }
                    }
                });
                NativeAdListener nativeAdListener = this.adListener;
                if (nativeAdListener != null) {
                    nativeAdListener.adImpression(this);
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$impression", th);
        }
    }

    public NativeAdView getNativeAdView() {
        return this.nativeAdView;
    }

    public void registerClickableViews(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            fillListWithSubviews(arrayList, view);
            registerClickableViews((List<View>) arrayList);
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$registerClickableViews", th);
        }
    }

    public void registerClickableViews(List<View> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    a aVar = new a();
                    for (View next : list) {
                        if (!(next instanceof PrivacyIcon) && !(next instanceof com.appnext.a.a) && !(next instanceof MediaView.a)) {
                            this.clicksListView.add(next);
                            next.setOnClickListener(aVar);
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("List cannot be empty");
            } catch (Throwable th) {
                com.appnext.base.a.a("NativeAd$registerClickableViews", th);
            }
        } else {
            throw new IllegalArgumentException("List cannot be null");
        }
    }

    private void fillListWithSubviews(ArrayList<View> arrayList, View view) {
        try {
            if (!(view instanceof PrivacyIcon) && !(view instanceof com.appnext.a.a)) {
                arrayList.add(view);
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int i = 0; i < viewGroup.getChildCount(); i++) {
                        fillListWithSubviews(arrayList, viewGroup.getChildAt(i));
                    }
                }
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$fillListWithSubviews", th);
        }
    }

    public void downloadAndDisplayImage(Context context, ImageView imageView, String str) {
        j.Y().a(context, imageView, str, (j.a) null);
    }

    public String getLanguage() {
        return this.language;
    }

    public void setLanguage(String str) {
        this.language = str;
    }

    public void destroy() {
        try {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            for (View onClickListener : this.clicksListView) {
                onClickListener.setOnClickListener((View.OnClickListener) null);
            }
            List<View> list = this.clicksListView;
            if (list != null) {
                list.clear();
            }
            p pVar = this.userAction;
            if (pVar != null) {
                pVar.destroy();
            }
            NativeAdObject nativeAdObject2 = this.nativeAdObject;
            if (nativeAdObject2 != null) {
                nativeAdObject2.destroy();
            }
            MediaView mediaView2 = this.mediaView;
            if (mediaView2 != null) {
                mediaView2.destroy();
            }
            this.handler = null;
            this.adViewActions = null;
            this.mediaView = null;
            this.adListener = null;
            this.loadedAd = null;
            this.nativeAdView = null;
        } catch (Exception e) {
            com.appnext.base.a.a("NativeAd$destroy", e);
        }
    }

    private class a implements View.OnClickListener {
        private a() {
        }

        public final void onClick(View view) {
            try {
                if (NativeAd.this.loadedAd != null) {
                    NativeAd.this.report("click_event");
                    if (!NativeAd.this.reportedImpression) {
                        NativeAd.this.impression();
                    }
                    if (!NativeAd.this.loadedAd.getWebview().equals("0")) {
                        NativeAd.this.click();
                        return;
                    }
                    char c = 65535;
                    if (NativeAd.this.loadedAd.getRevenueType().equals("cpi")) {
                        String lowerCase = a.aC().t("cpiActiveFlow").toLowerCase();
                        switch (lowerCase.hashCode()) {
                            case 97:
                                if (lowerCase.equals("a")) {
                                    c = 0;
                                    break;
                                }
                                break;
                            case 98:
                                if (lowerCase.equals("b")) {
                                    c = 1;
                                    break;
                                }
                                break;
                            case 99:
                                if (lowerCase.equals("c")) {
                                    c = 2;
                                    break;
                                }
                                break;
                            case 100:
                                if (lowerCase.equals("d")) {
                                    c = 3;
                                    break;
                                }
                                break;
                        }
                        if (c != 0) {
                            if (c == 1) {
                                NativeAd.this.clicked = true;
                            } else if (c == 2) {
                                NativeAd.this.openResultPage(false);
                                return;
                            }
                            NativeAd.this.click();
                            return;
                        }
                        NativeAd.this.openResultPage(true);
                        return;
                    }
                    String lowerCase2 = a.aC().t("cpcActiveFlow").toLowerCase();
                    int hashCode = lowerCase2.hashCode();
                    if (hashCode != 97) {
                        if (hashCode == 98) {
                            if (lowerCase2.equals("b")) {
                                c = 1;
                            }
                        }
                    } else if (lowerCase2.equals("a")) {
                        c = 0;
                    }
                    if (c != 0) {
                        NativeAd.this.click();
                        return;
                    }
                    NativeAd.this.clicked = true;
                    NativeAd.this.click();
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("NativeAd$destroy", th);
            }
        }
    }

    /* access modifiers changed from: private */
    public void openResultPage(boolean z) {
        com.appnext.core.result.d.ay().a(new c() {
            public final com.appnext.core.result.a A() {
                return null;
            }

            public final JSONObject getConfigParams() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("vid", "2.7.0.473");
                String str = "";
                jSONObject.put(ScarConstants.TOKEN_ID_KEY, NativeAd.this.nativeAdObject == null ? str : NativeAd.this.nativeAdObject.getTID());
                if (NativeAd.this.nativeAdObject != null) {
                    str = NativeAd.this.nativeAdObject.getAUID();
                }
                jSONObject.put(JsonStorageKeyNames.AUID_ID_KEY, str);
                jSONObject.put("osid", StatisticData.ERROR_CODE_NOT_FOUND);
                jSONObject.put("tem_id", NativeAd.this.nativeAdObject.getTemId(NativeAd.this.loadedAd));
                jSONObject.put("id", getPlacementId());
                jSONObject.put("b_title", getButtonText(NativeAd.this.loadedAd));
                jSONObject.put("cat", NativeAd.this.loadedAd.getCategories());
                jSONObject.put("lockcat", NativeAd.this.loadedAd.getSpecificCategories());
                jSONObject.put("pview", a.aC().t("pview"));
                jSONObject.put("devn", g.V());
                jSONObject.put("dosv", Build.VERSION.SDK_INT);
                jSONObject.put("dds", "0");
                jSONObject.put("ads_type", "banner");
                jSONObject.put("country", NativeAd.this.loadedAd.getCountry());
                jSONObject.put("gdpr", i.a((AppnextAd) NativeAd.this.loadedAd, (SettingsManager) a.aC()));
                return jSONObject;
            }

            /* access modifiers changed from: protected */
            public final String getButtonText(AppnextAd appnextAd) {
                try {
                    String buttonText = new NativeAdData(appnextAd).getButtonText();
                    if (appnextAd == null || !buttonText.equals("")) {
                        return buttonText;
                    }
                    if (g.b(NativeAd.this.nativeAdObject.getContext(), appnextAd.getAdPackage())) {
                        return a.aC().t("existing_button_text");
                    }
                    return a.aC().t("new_button_text");
                } catch (Throwable th) {
                    com.appnext.base.a.a("NativeAd$getButtonText", th);
                    return "";
                }
            }

            public final AppnextAd getSelectedAd() {
                return NativeAd.this.loadedAd;
            }

            public final String getPlacementId() {
                return NativeAd.this.nativeAdObject.getPlacementID();
            }

            public final String v() {
                return NativeAd.this.nativeAdObject.getTemId(NativeAd.this.loadedAd);
            }

            public final String w() {
                return b.aE().k(NativeAd.this.nativeAdObject);
            }

            public final String x() {
                try {
                    ArrayList<AppnextAd> e = b.aE().e(NativeAd.this.nativeAdObject);
                    JSONArray jSONArray = new JSONArray();
                    Iterator<AppnextAd> it = e.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(new JSONObject(b.c(it.next())));
                    }
                    return new JSONObject().put("apps", jSONArray).toString();
                } catch (Throwable th) {
                    com.appnext.base.a.a("NativeAd$getFilteredAds", th);
                    return "";
                }
            }

            public final SettingsManager y() {
                return a.aC();
            }

            public final Ad z() {
                return NativeAd.this.nativeAdObject;
            }
        });
        Intent intent = new Intent(this.nativeAdObject.getContext(), ResultPageActivity.class);
        intent.putExtra("shouldClose", z);
        intent.setFlags(65536);
        this.nativeAdObject.getContext().startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void click() {
        try {
            p pVar = this.userAction;
            NativeAdData nativeAdData = this.loadedAd;
            pVar.a(nativeAdData, nativeAdData.getAppURL(), this.nativeAdObject.getPlacementID(), (f.a) null);
            NativeAdListener nativeAdListener = this.adListener;
            if (nativeAdListener != null) {
                nativeAdListener.onAdClicked(this);
            }
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$click", th);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        if (i == 0) {
            try {
                if (this.clicked) {
                    this.clicked = false;
                    openResultPage(false);
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("NativeAd$onWindowVisibilityChanged", th);
            }
        }
    }

    public void setPrivacyPolicyPosition(int i) {
        this.privacyPolicyPosition = i;
    }

    public int getPrivacyPolicyPosition() {
        return this.privacyPolicyPosition;
    }

    public void setPrivacyPolicyColor(int i) {
        this.privacyPolicyColor = i;
    }

    public int getPrivacyPolicyColor() {
        return this.privacyPolicyColor;
    }

    public void setPrivacyPolicyVisibility(int i) {
        this.privacyPolicyVisibility = i;
    }

    public int getPrivacyPolicyVisibility() {
        return this.privacyPolicyVisibility;
    }

    /* access modifiers changed from: private */
    public void report(String str) {
        try {
            Context context = this.nativeAdObject.getContext();
            String tid = this.nativeAdObject.getTID();
            String vid = this.nativeAdObject.getVID();
            String auid = this.nativeAdObject.getAUID();
            String placementID = this.nativeAdObject.getPlacementID();
            String sessionId = this.nativeAdObject.getSessionId();
            NativeAdData nativeAdData = this.loadedAd;
            String bannerID = nativeAdData != null ? nativeAdData.getBannerID() : "";
            NativeAdData nativeAdData2 = this.loadedAd;
            g.a(context, tid, vid, auid, placementID, sessionId, str, "pub_control", bannerID, nativeAdData2 != null ? nativeAdData2.getCampaignID() : "");
        } catch (Throwable th) {
            com.appnext.base.a.a("NativeAd$onWindowVisibilityChanged", th);
        }
    }

    public void i() {
        if ((Thread.currentThread().getStackTrace()[3].getClassName() + Thread.currentThread().getStackTrace()[3].getMethodName()).hashCode() == -133704518 && !this.reportedImpression) {
            impression();
        }
    }
}
