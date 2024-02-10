package com.appnext.nativeads.designed_native_ads;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.appnext.core.AppnextAd;
import com.appnext.core.AppnextError;
import com.appnext.core.d;
import com.appnext.nativeads.NativeAdRequest;
import com.appnext.nativeads.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    /* access modifiers changed from: private */
    public WeakReference<C0027a> fv;
    /* access modifiers changed from: private */
    public List<DesignNativeAd> fw;

    /* renamed from: com.appnext.nativeads.designed_native_ads.a$a  reason: collision with other inner class name */
    public interface C0027a {
        void d(List<DesignNativeAd> list);

        void onError(AppnextError appnextError);
    }

    public final void a(C0027a aVar) {
        this.fv = new WeakReference<>(aVar);
    }

    public final void a(Context context, String str, DesignNativeAdsRequest designNativeAdsRequest, final int i) {
        final DesignNativeAdObject designNativeAdObject = new DesignNativeAdObject(context, str);
        if (designNativeAdsRequest != null) {
            designNativeAdObject.setCategories(designNativeAdsRequest.getCategories());
            designNativeAdObject.setSpecificCategories(designNativeAdsRequest.getSpecificCategories());
            designNativeAdObject.setPostback(designNativeAdsRequest.getPostBack());
        }
        b aF = b.aF();
        AnonymousClass1 r4 = new d.a() {
            public final <T> void a(T t) {
                C0027a aVar;
                try {
                    if (a.this.fv != null && (aVar = (C0027a) a.this.fv.get()) != null) {
                        if (t == null) {
                            aVar.onError(new AppnextError(AppnextError.NO_ADS));
                            return;
                        }
                        ArrayList<AppnextAd> a = b.aE().a(designNativeAdObject.getPlacementID(), new NativeAdRequest(), (ArrayList<AppnextAd>) (ArrayList) t);
                        if (a.size() == 0) {
                            aVar.onError(new AppnextError(AppnextError.NO_ADS));
                        } else if (aVar != null) {
                            int size = a.size();
                            int i = i;
                            if (size > i) {
                                a.subList(i, a.size()).clear();
                            }
                            a.this.fw = new ArrayList();
                            for (AppnextAd next : a) {
                                String imageURL = next.getImageURL();
                                if (!TextUtils.isEmpty(imageURL)) {
                                    a.this.fw.add(new DesignNativeAd(next, imageURL));
                                }
                            }
                            a.this.fw.size();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public final void run() {
                                    C0027a aVar;
                                    if (a.this.fv != null && (aVar = (C0027a) a.this.fv.get()) != null) {
                                        aVar.d(a.this.fw);
                                    }
                                }
                            });
                        }
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignNativeAdsController$loadAds", th);
                }
            }

            public final void error(String str) {
                C0027a aVar;
                try {
                    if (a.this.fv != null && (aVar = (C0027a) a.this.fv.get()) != null) {
                        if (str != null) {
                            if (!str.equals(AppnextError.NO_ADS)) {
                                if (!str.equals(AppnextError.INTERNAL_ERROR)) {
                                    aVar.onError(new AppnextError(str));
                                    return;
                                }
                            }
                        }
                        aVar.onError(new AppnextError(AppnextError.NO_ADS));
                    }
                } catch (Throwable th) {
                    com.appnext.base.a.a("DesignNativeAdsController$loadAds", th);
                }
            }
        };
        NativeAdRequest nativeAdRequest = new NativeAdRequest();
        if (designNativeAdsRequest != null) {
            nativeAdRequest.setCategories(designNativeAdsRequest.getCategories());
            nativeAdRequest.setSpecificCategories(designNativeAdsRequest.getSpecificCategories());
            nativeAdRequest.setPostback(designNativeAdsRequest.getPostBack());
        }
        aF.a(context, designNativeAdObject, str, r4, nativeAdRequest);
    }
}
