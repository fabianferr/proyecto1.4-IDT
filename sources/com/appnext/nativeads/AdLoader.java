package com.appnext.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.appnext.base.Appnext;
import com.appnext.base.a;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.SettingsManager;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.nativeads.NativeAdRequest;
import java.util.ArrayList;
import java.util.HashMap;

public class AdLoader {
    /* access modifiers changed from: private */
    public int count;
    /* access modifiers changed from: private */
    public NativeAdListener eO;
    /* access modifiers changed from: private */
    public NativeAdRequest eP;
    /* access modifiers changed from: private */
    public NativeAdObject nativeAdObject;

    private AdLoader(Context context, String str) {
        this.nativeAdObject = new NativeAdObject(context, str);
    }

    public static void load(Context context, String str, NativeAdRequest nativeAdRequest, NativeAdListener nativeAdListener, int i) {
        try {
            getAdsByPackage(context, str, (String) null, nativeAdRequest, nativeAdListener, i);
        } catch (Throwable th) {
            a.a("AdLoader$load", th);
        }
    }

    public static void getAdsByPackage(Context context, String str, final String str2, NativeAdRequest nativeAdRequest, NativeAdListener nativeAdListener, int i) {
        try {
            if (g.g(context)) {
                Appnext.init(context);
                if (nativeAdRequest != null && nativeAdListener != null && i > 0) {
                    AdLoader adLoader = new AdLoader(context, str);
                    adLoader.eP = new NativeAdRequest(nativeAdRequest);
                    adLoader.count = i;
                    adLoader.eO = nativeAdListener;
                    a.aC().a(context, str, new SettingsManager.ConfigCallback() {
                        public final void loaded(HashMap<String, Object> hashMap) {
                            try {
                                AdLoader.this.E(str2);
                            } catch (Throwable unused) {
                            }
                        }

                        public final void error(String str) {
                            try {
                                AdLoader.this.E(str2);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                }
            } else if (nativeAdListener != null) {
                nativeAdListener.onError((NativeAd) null, new AppnextError(AppnextError.CONNECTION_ERROR));
            }
        } catch (Throwable th) {
            a.a("AdLoader$getAdsByPackage", th);
        }
    }

    /* access modifiers changed from: private */
    public void E(String str) {
        try {
            this.nativeAdObject.setCategories(this.eP.getCategories());
            this.nativeAdObject.setSpecificCategories(this.eP.getSpecificCategories());
            this.nativeAdObject.setPostback(this.eP.getPostback());
            if (!TextUtils.isEmpty(str)) {
                this.nativeAdObject.setPackageName(str);
            }
            this.nativeAdObject.setMinVideoLength(this.eP.getMinVideoLength());
            this.nativeAdObject.setMaxVideoLength(this.eP.getMaxVideoLength());
            b aE = b.aE();
            Context context = this.nativeAdObject.getContext();
            NativeAdObject nativeAdObject2 = this.nativeAdObject;
            aE.a(context, nativeAdObject2, nativeAdObject2.getPlacementID(), new d.a() {
                public final <T> void a(T t) {
                    if (t == null) {
                        try {
                            if (AdLoader.this.eO != null) {
                                AdLoader.this.eO.onError((NativeAd) null, new AppnextError(AppnextError.NO_ADS));
                            }
                        } catch (Throwable th) {
                            a.a("AdLoader$load", th);
                        }
                    } else if (AdLoader.this.eP != null) {
                        if (AdLoader.this.eP.getVideoLength() == NativeAdRequest.VideoLength.DEFAULT) {
                            AdLoader.this.eP.setVideoLength(NativeAdRequest.VideoLength.fromInt(Integer.parseInt(a.aC().t("default_video_length"))));
                        }
                        if (AdLoader.this.eP.getVideoQuality() == NativeAdRequest.VideoQuality.DEFAULT) {
                            AdLoader.this.eP.setVideoQuality(NativeAdRequest.VideoQuality.fromInt(Integer.parseInt(a.aC().t("default_video_quality"))));
                        }
                        ArrayList<AppnextAd> a = b.aE().a(AdLoader.this.nativeAdObject.getPlacementID(), AdLoader.this.eP, (ArrayList<AppnextAd>) (ArrayList) t);
                        if (a.size() != 0) {
                            int min = Math.min(a.size(), AdLoader.this.count);
                            for (int i = 0; i < min; i++) {
                                NativeAd nativeAd = new NativeAd(AdLoader.this.nativeAdObject.getContext(), AdLoader.this.nativeAdObject.getPlacementID());
                                AppnextAd appnextAd = a.get(i);
                                nativeAd.setLoadedAd(new NativeAdData(appnextAd), AdLoader.this.eP);
                                nativeAd.setAdListener(AdLoader.this.eO);
                                if (AdLoader.this.eO != null) {
                                    AdLoader.this.eO.onAdLoaded(nativeAd, appnextAd.getCreativeType());
                                    AdLoader.this.eO.onAdLoaded(nativeAd, appnextAd.getCreativeType(), i + 1, min);
                                }
                            }
                        } else if (AdLoader.this.eO != null) {
                            AdLoader.this.eO.onError((NativeAd) null, new AppnextError(AppnextError.NO_ADS));
                        }
                    } else if (AdLoader.this.eO != null) {
                        AdLoader.this.eO.onError((NativeAd) null, new AppnextError(AppnextError.NO_ADS));
                    }
                }

                public final void error(String str) {
                    if (str != null) {
                        try {
                            if (!str.equals(AppnextError.NO_ADS)) {
                                if (!str.equals(AppnextError.INTERNAL_ERROR)) {
                                    AdLoader.this.eO.onError((NativeAd) null, new AppnextError(str));
                                    AdLoader.this.destroy();
                                }
                            }
                        } catch (Throwable th) {
                            a.a("AdLoader$load", th);
                            return;
                        }
                    }
                    AdLoader.this.eO.onError((NativeAd) null, new AppnextError(AppnextError.NO_ADS));
                    AdLoader.this.destroy();
                }
            }, this.eP);
        } catch (Throwable th) {
            a.a("AdLoader$load", th);
        }
    }

    /* access modifiers changed from: private */
    public void destroy() {
        try {
            this.eO = null;
            this.eP = null;
            NativeAdObject nativeAdObject2 = this.nativeAdObject;
            if (nativeAdObject2 != null) {
                nativeAdObject2.destroy();
                this.nativeAdObject = null;
            }
        } catch (Throwable th) {
            a.a("AdLoader$load", th);
        }
    }
}
