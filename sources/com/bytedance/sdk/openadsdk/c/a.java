package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.PAGLoadListener;
import com.bytedance.sdk.openadsdk.api.PAGRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.bytedance.sdk.openadsdk.api.factory.IADLoader;
import com.bytedance.sdk.openadsdk.api.factory.IADTypeLoaderFactory;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenAdLoadListener;
import com.bytedance.sdk.openadsdk.api.open.PAGAppOpenRequest;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.bytedance.sdk.openadsdk.apiImpl.d.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.n;
import java.lang.reflect.Method;

/* compiled from: ADNFactory */
public class a implements IADTypeLoaderFactory {
    public IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener> createOpenAdLoader() {
        return new IADLoader<PAGAppOpenRequest, PAGAppOpenAdLoadListener>() {
            /* access modifiers changed from: private */
            public int b;

            /* renamed from: a */
            public void loadAd(String str, PAGAppOpenRequest pAGAppOpenRequest, PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener) {
                if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(str, (PAGRequest) pAGAppOpenRequest, (PAGLoadListener) pAGAppOpenAdLoadListener)) {
                    AdSlot.Builder builder = new AdSlot.Builder();
                    com.bytedance.sdk.openadsdk.apiImpl.a.a(builder, pAGAppOpenRequest);
                    if (!TextUtils.isEmpty(pAGAppOpenRequest.getAdString())) {
                        builder.withBid(pAGAppOpenRequest.getAdString());
                    }
                    AdSlot build = builder.setCodeId(str).setRequestExtraMap(pAGAppOpenRequest.getExtraInfo()).build();
                    if (pAGAppOpenRequest != null) {
                        this.b = pAGAppOpenRequest.getTimeout();
                    }
                    com.bytedance.sdk.openadsdk.apiImpl.c.a aVar = new com.bytedance.sdk.openadsdk.apiImpl.c.a(pAGAppOpenAdLoadListener);
                    final PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener2 = pAGAppOpenAdLoadListener;
                    final com.bytedance.sdk.openadsdk.apiImpl.c.a aVar2 = aVar;
                    final AdSlot adSlot = build;
                    com.bytedance.sdk.openadsdk.apiImpl.a.a((h) new h("loadSplashAd") {
                        public void run() {
                            Method a2;
                            try {
                                if (!o.d().p() && ac.s()) {
                                    PAGAppOpenAdLoadListener pAGAppOpenAdLoadListener = pAGAppOpenAdLoadListener2;
                                    if (pAGAppOpenAdLoadListener != null) {
                                        pAGAppOpenAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                                    }
                                } else if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(aVar2) && (a2 = w.a("com.bytedance.sdk.openadsdk.TTC2Proxy", "load", Context.class, AdSlot.class, PAGAppOpenAdLoadListener.class, Integer.TYPE)) != null) {
                                    a2.invoke((Object) null, new Object[]{o.a(), adSlot, aVar2, Integer.valueOf(AnonymousClass1.this.b)});
                                }
                            } catch (Throwable th) {
                                l.c("ADNFactory", "open component maybe not exist, please check", th);
                            }
                        }
                    }, (PAGLoadListener) aVar, build);
                }
            }
        };
    }

    public IADLoader<PAGBannerRequest, PAGBannerAdLoadListener> createBannerAdLoader() {
        return new IADLoader<PAGBannerRequest, PAGBannerAdLoadListener>() {
            /* renamed from: a */
            public void loadAd(String str, PAGBannerRequest pAGBannerRequest, PAGBannerAdLoadListener pAGBannerAdLoadListener) {
                if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(str, (PAGRequest) pAGBannerRequest, (PAGLoadListener) pAGBannerAdLoadListener)) {
                    AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                    com.bytedance.sdk.openadsdk.apiImpl.a.a(codeId, pAGBannerRequest);
                    if (!TextUtils.isEmpty(pAGBannerRequest.getAdString())) {
                        codeId.withBid(pAGBannerRequest.getAdString());
                    }
                    PAGBannerSize adSize = pAGBannerRequest != null ? pAGBannerRequest.getAdSize() : null;
                    if (adSize != null) {
                        codeId.setExpressViewAcceptedSize((float) adSize.getWidth(), (float) adSize.getHeight());
                    }
                    AdSlot build = codeId.setRequestExtraMap(pAGBannerRequest.getExtraInfo()).build();
                    com.bytedance.sdk.openadsdk.apiImpl.a.a aVar = new com.bytedance.sdk.openadsdk.apiImpl.a.a(pAGBannerAdLoadListener);
                    final PAGBannerAdLoadListener pAGBannerAdLoadListener2 = pAGBannerAdLoadListener;
                    final com.bytedance.sdk.openadsdk.apiImpl.a.a aVar2 = aVar;
                    final AdSlot adSlot = build;
                    com.bytedance.sdk.openadsdk.apiImpl.a.a((h) new h("loadBannerExpressAd") {
                        public void run() {
                            if (!o.d().p() && ac.s()) {
                                PAGBannerAdLoadListener pAGBannerAdLoadListener = pAGBannerAdLoadListener2;
                                if (pAGBannerAdLoadListener != null) {
                                    pAGBannerAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                                }
                            } else if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(aVar2)) {
                                adSlot.setNativeAdType(1);
                                adSlot.setDurationSlotType(1);
                                e.a(o.a()).a(adSlot, 1, aVar2, 5000);
                            }
                        }
                    }, (PAGLoadListener) aVar, build);
                }
            }
        };
    }

    public IADLoader<PAGNativeRequest, PAGNativeAdLoadListener> createNativeAdLoader() {
        return new IADLoader<PAGNativeRequest, PAGNativeAdLoadListener>() {
            /* renamed from: a */
            public void loadAd(String str, PAGNativeRequest pAGNativeRequest, PAGNativeAdLoadListener pAGNativeAdLoadListener) {
                if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(str, (PAGRequest) pAGNativeRequest, (PAGLoadListener) pAGNativeAdLoadListener)) {
                    com.bytedance.sdk.openadsdk.apiImpl.feed.e eVar = new com.bytedance.sdk.openadsdk.apiImpl.feed.e(pAGNativeAdLoadListener);
                    AdSlot.Builder withBid = new AdSlot.Builder().setCodeId(str).withBid(pAGNativeRequest != null ? pAGNativeRequest.getAdString() : null);
                    com.bytedance.sdk.openadsdk.apiImpl.a.a(withBid, pAGNativeRequest);
                    AdSlot build = withBid.setRequestExtraMap(pAGNativeRequest.getExtraInfo()).build();
                    final PAGNativeAdLoadListener pAGNativeAdLoadListener2 = pAGNativeAdLoadListener;
                    final com.bytedance.sdk.openadsdk.apiImpl.feed.e eVar2 = eVar;
                    final AdSlot adSlot = build;
                    com.bytedance.sdk.openadsdk.apiImpl.a.a((h) new h("loadFeedAd") {
                        public void run() {
                            if (!o.d().p() && ac.s()) {
                                PAGNativeAdLoadListener pAGNativeAdLoadListener = pAGNativeAdLoadListener2;
                                if (pAGNativeAdLoadListener != null) {
                                    pAGNativeAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                                }
                            } else if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(eVar2)) {
                                try {
                                    Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC5Proxy", "loadFeed", Context.class, AdSlot.class, PAGNativeAdLoadListener.class);
                                    if (a2 != null) {
                                        a2.invoke((Object) null, new Object[]{o.a(), adSlot, eVar2});
                                    }
                                } catch (Throwable th) {
                                    l.b("ADNFactory", "feed component maybe not exist, pls check1", th);
                                }
                            }
                        }
                    }, (PAGLoadListener) eVar, build);
                }
            }
        };
    }

    public IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener> createRewardAdLoader() {
        return new IADLoader<PAGRewardedRequest, PAGRewardedAdLoadListener>() {
            /* renamed from: a */
            public void loadAd(String str, PAGRewardedRequest pAGRewardedRequest, PAGRewardedAdLoadListener pAGRewardedAdLoadListener) {
                if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(str, (PAGRequest) pAGRewardedRequest, (PAGLoadListener) pAGRewardedAdLoadListener)) {
                    if (n.a(n.a, "load_reward_ad")) {
                        AdSlot.Builder codeId = new AdSlot.Builder().setCodeId(str);
                        if (!TextUtils.isEmpty(pAGRewardedRequest.getAdString())) {
                            codeId.withBid(pAGRewardedRequest.getAdString());
                        }
                        com.bytedance.sdk.openadsdk.apiImpl.a.a(codeId, pAGRewardedRequest);
                        AdSlot build = codeId.setRequestExtraMap(pAGRewardedRequest.getExtraInfo()).build();
                        b bVar = new b(pAGRewardedAdLoadListener);
                        final PAGRewardedAdLoadListener pAGRewardedAdLoadListener2 = pAGRewardedAdLoadListener;
                        final b bVar2 = bVar;
                        final AdSlot adSlot = build;
                        com.bytedance.sdk.openadsdk.apiImpl.a.a((h) new h("loadRewardVideoAd") {
                            public void run() {
                                if (!o.d().p() && ac.s()) {
                                    PAGRewardedAdLoadListener pAGRewardedAdLoadListener = pAGRewardedAdLoadListener2;
                                    if (pAGRewardedAdLoadListener != null) {
                                        pAGRewardedAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                                    }
                                } else if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(bVar2)) {
                                    try {
                                        Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadReward", Context.class, AdSlot.class, PAGRewardedAdLoadListener.class);
                                        if (a2 != null) {
                                            a2.invoke((Object) null, new Object[]{o.a(), adSlot, bVar2});
                                        }
                                    } catch (Throwable th) {
                                        l.b("ADNFactory", "reward component maybe not exist, pls check1", th);
                                    }
                                }
                            }
                        }, (PAGLoadListener) bVar, build);
                    } else if (pAGRewardedAdLoadListener != null) {
                        pAGRewardedAdLoadListener.onError(-17, "Insufficient running memory");
                    }
                }
            }
        };
    }

    public IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener> createInterstitialAdLoader() {
        return new IADLoader<PAGInterstitialRequest, PAGInterstitialAdLoadListener>() {
            /* renamed from: a */
            public void loadAd(String str, PAGInterstitialRequest pAGInterstitialRequest, PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener) {
                if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(str, (PAGRequest) pAGInterstitialRequest, (PAGLoadListener) pAGInterstitialAdLoadListener)) {
                    if (n.a(n.a, "load_interstitial_ad")) {
                        AdSlot.Builder codeId = new AdSlot.Builder().setRequestExtraMap(pAGInterstitialRequest.getExtraInfo()).setCodeId(str);
                        com.bytedance.sdk.openadsdk.apiImpl.a.a(codeId, pAGInterstitialRequest);
                        if (!TextUtils.isEmpty(pAGInterstitialRequest.getAdString())) {
                            codeId.withBid(pAGInterstitialRequest.getAdString());
                        }
                        AdSlot build = codeId.build();
                        com.bytedance.sdk.openadsdk.apiImpl.b.a aVar = new com.bytedance.sdk.openadsdk.apiImpl.b.a(pAGInterstitialAdLoadListener);
                        final PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener2 = pAGInterstitialAdLoadListener;
                        final com.bytedance.sdk.openadsdk.apiImpl.b.a aVar2 = aVar;
                        final AdSlot adSlot = build;
                        com.bytedance.sdk.openadsdk.apiImpl.a.a((h) new h("loadInterstitialAd") {
                            public void run() {
                                if (!o.d().p() && ac.s()) {
                                    PAGInterstitialAdLoadListener pAGInterstitialAdLoadListener = pAGInterstitialAdLoadListener2;
                                    if (pAGInterstitialAdLoadListener != null) {
                                        pAGInterstitialAdLoadListener.onError(-18, "Blind mode does not allow requesting ads");
                                    }
                                } else if (!com.bytedance.sdk.openadsdk.apiImpl.a.a(aVar2)) {
                                    try {
                                        Method a2 = w.a("com.bytedance.sdk.openadsdk.TTC3Proxy", "loadFull", Context.class, AdSlot.class, PAGInterstitialAdLoadListener.class);
                                        if (a2 != null) {
                                            a2.invoke((Object) null, new Object[]{o.a(), adSlot, aVar2});
                                        }
                                    } catch (Throwable th) {
                                        l.b("ADNFactory", "reward component maybe not exist, pls check2", th);
                                    }
                                }
                            }
                        }, (PAGLoadListener) aVar, build);
                    } else if (pAGInterstitialAdLoadListener != null) {
                        pAGInterstitialAdLoadListener.onError(-17, "Insufficient running memory");
                    }
                }
            }
        };
    }
}
