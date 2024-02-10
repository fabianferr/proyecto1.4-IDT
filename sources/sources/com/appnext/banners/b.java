package com.appnext.banners;

import android.content.Context;
import android.util.Pair;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.a;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.core.h;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

final class b extends d {
    private static b bC;
    private final int r = 200;

    /* access modifiers changed from: protected */
    public final void a(Context context, Ad ad, a aVar) {
    }

    /* access modifiers changed from: protected */
    public final void a(Ad ad, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public final <T> void a(String str, Ad ad, T t) {
    }

    public static synchronized b J() {
        b bVar;
        synchronized (b.class) {
            if (bC == null) {
                bC = new b();
            }
            bVar = bC;
        }
        return bVar;
    }

    private b() {
    }

    /* access modifiers changed from: protected */
    public final String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        StringBuilder sb = new StringBuilder("&auid=");
        sb.append(ad != null ? ad.getAUID() : "1000");
        return sb.toString();
    }

    public final void a(Context context, Ad ad, String str, d.a aVar, BannerAdRequest bannerAdRequest) {
        ((BannerAd) ad).setAdRequest(new BannerAdRequest(bannerAdRequest));
        super.a(context, ad, str, aVar);
    }

    /* access modifiers changed from: protected */
    public final int a(Context context, h hVar) {
        try {
            BannerAdData bannerAdData = new BannerAdData((AppnextAd) hVar);
            int a = a(context, bannerAdData);
            if (a != 0) {
                return a;
            }
            if (bannerAdData.getCampaignGoal().equals("new") && g.b(context, bannerAdData.getAdPackage())) {
                return 2;
            }
            if (!bannerAdData.getCampaignGoal().equals("existing") || g.b(context, bannerAdData.getAdPackage())) {
                return 0;
            }
            return 1;
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdsManager$radFilter", th);
            return 1;
        }
    }

    /* access modifiers changed from: protected */
    public final SettingsManager c(Ad ad) {
        return d.K();
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, ArrayList<?> arrayList, String str, ArrayList<String> arrayList2) {
        if (arrayList == null) {
            return null;
        }
        Iterator<?> it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd appnextAd = (AppnextAd) it.next();
            try {
                if (a(ad, appnextAd, str)) {
                    appnextAd.getBannerID();
                    ad.getPlacementID();
                    if (!arrayList2.contains(appnextAd.getBannerID())) {
                        return appnextAd;
                    }
                } else {
                    continue;
                }
            } catch (Throwable th) {
                com.appnext.base.a.a("BannerAdsManager$getFirst", th);
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, ArrayList<?> arrayList, String str) {
        return a(context, ad, arrayList, str, (ArrayList<String>) new ArrayList());
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, String str) {
        ArrayList<?> ads;
        try {
            if (j(ad) == null || (ads = j(ad).getAds()) == null) {
                return null;
            }
            return a(context, ad, ads, str);
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdsManager$getFirst", th);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x003c A[Catch:{ all -> 0x005a }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004b A[Catch:{ all -> 0x005a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(com.appnext.core.Ad r4, com.appnext.core.AppnextAd r5, java.lang.String r6) {
        /*
            r0 = 0
            boolean r4 = r4 instanceof com.appnext.banners.MediumRectangleAd     // Catch:{ all -> 0x005a }
            r1 = 1
            if (r4 == 0) goto L_0x0059
            int r4 = r6.hashCode()     // Catch:{ all -> 0x005a }
            r2 = -892481938(0xffffffffcacdce6e, float:-6743863.0)
            r3 = 2
            if (r4 == r2) goto L_0x002f
            r2 = 96673(0x179a1, float:1.35468E-40)
            if (r4 == r2) goto L_0x0025
            r2 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r4 == r2) goto L_0x001b
            goto L_0x0039
        L_0x001b:
            java.lang.String r4 = "video"
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0039
            r4 = 2
            goto L_0x003a
        L_0x0025:
            java.lang.String r4 = "all"
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0039
            r4 = 0
            goto L_0x003a
        L_0x002f:
            java.lang.String r4 = "static"
            boolean r4 = r6.equals(r4)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0039
            r4 = 1
            goto L_0x003a
        L_0x0039:
            r4 = -1
        L_0x003a:
            if (r4 == 0) goto L_0x004b
            if (r4 == r1) goto L_0x0046
            if (r4 == r3) goto L_0x0041
            return r0
        L_0x0041:
            boolean r4 = hasVideo(r5)     // Catch:{ all -> 0x005a }
            return r4
        L_0x0046:
            boolean r4 = b(r5)     // Catch:{ all -> 0x005a }
            return r4
        L_0x004b:
            boolean r4 = b(r5)     // Catch:{ all -> 0x005a }
            if (r4 != 0) goto L_0x0059
            boolean r4 = hasVideo(r5)     // Catch:{ all -> 0x005a }
            if (r4 == 0) goto L_0x0058
            goto L_0x0059
        L_0x0058:
            return r0
        L_0x0059:
            return r1
        L_0x005a:
            r4 = move-exception
            java.lang.String r5 = "BannerAdsManager$checkCreative"
            com.appnext.base.a.a(r5, r4)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.b.a(com.appnext.core.Ad, com.appnext.core.AppnextAd, java.lang.String):boolean");
    }

    public final ArrayList<AppnextAd> e(Ad ad) {
        return j(ad).getAds();
    }

    private static int a(Context context, BannerAdData bannerAdData) {
        try {
            if (!bannerAdData.getCptList().equals("") && !bannerAdData.getCptList().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jSONArray = new JSONArray(bannerAdData.getCptList());
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (g.b(context, jSONArray.getString(i))) {
                        return 0;
                    }
                }
                return 3;
            }
        } catch (JSONException e) {
            com.appnext.base.a.a("BannerAdsManager$checkCreative", e);
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdsManager$checkCreative", th);
            return 3;
        }
        return 0;
    }

    static boolean hasVideo(AppnextAd appnextAd) {
        try {
            return !appnextAd.getVideoUrl().equals("") || !appnextAd.getVideoUrlHigh().equals("") || !appnextAd.getVideoUrl30Sec().equals("") || !appnextAd.getVideoUrlHigh30Sec().equals("");
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean b(AppnextAd appnextAd) {
        try {
            return !appnextAd.getWideImageURL().equals("");
        } catch (Throwable th) {
            com.appnext.base.a.a("BannerAdsManager$hasWideImage", th);
            return false;
        }
    }
}
