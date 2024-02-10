package com.appnext.ads.interstitial;

import android.content.Context;
import android.util.Pair;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.b;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.core.h;
import com.appnext.core.webview.AppnextWebView;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

public final class a extends d {
    private static a aJ;
    private String aq;

    /* access modifiers changed from: protected */
    public final void a(Ad ad, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public final <T> void a(String str, Ad ad, T t) {
    }

    public static synchronized a C() {
        a aVar;
        synchronized (a.class) {
            if (aJ == null) {
                aJ = new a();
            }
            aVar = aJ;
        }
        return aVar;
    }

    private a() {
    }

    public final void a(Context context, Ad ad, String str, d.a aVar, String str2) {
        try {
            this.aq = str2;
            super.a(context, ad, str, aVar);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        Integer num;
        String str2;
        try {
            StringBuilder sb = new StringBuilder("&auid=");
            sb.append(ad != null ? ad.getAUID() : "600");
            sb.append("&vidmin=");
            sb.append(ad == null ? "" : Integer.valueOf(ad.getMinVideoLength()));
            sb.append("&vidmax=");
            if (ad == null) {
                num = "";
            } else {
                num = Integer.valueOf(ad.getMaxVideoLength());
            }
            sb.append(num);
            if (this.aq.equals("static")) {
                str2 = "&creative=0";
            } else {
                str2 = "";
            }
            sb.append(str2);
            return sb.toString();
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialAdsManager$urlSuffix", th);
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, Ad ad, com.appnext.core.a aVar) throws Exception {
        try {
            AppnextWebView.q(context).a(((Interstitial) ad).getPageUrl(), (AppnextWebView.c) null);
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialAdsManager$customAdLoad", th);
        }
    }

    /* access modifiers changed from: protected */
    public final int a(Context context, h hVar) {
        int i;
        try {
            InterstitialAd interstitialAd = new InterstitialAd((AppnextAd) hVar);
            if (!interstitialAd.getCampaignGoal().equals("new") || !g.b(context, interstitialAd.getAdPackage())) {
                i = (!interstitialAd.getCampaignGoal().equals("existing") || g.b(context, interstitialAd.getAdPackage())) ? 0 : 2;
            } else {
                i = 1;
            }
            int a = a(context, (AppnextAd) hVar);
            if (i == 0 && a == 0) {
                return 0;
            }
            return i != 0 ? i : a;
        } catch (Throwable th) {
            com.appnext.base.a.a("InterstitialAdsManager$adFilter", th);
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    public final SettingsManager c(Ad ad) {
        return c.E();
    }

    /* access modifiers changed from: protected */
    public final boolean f(Ad ad) {
        return h(ad) && j(ad).getAds() != null && j(ad).getAds().size() > 0 && j(ad).O().longValue() + 300000 > System.currentTimeMillis();
    }

    /* access modifiers changed from: protected */
    public final ArrayList<AppnextAd> b(Context context, Ad ad, String str) {
        ArrayList<?> ads;
        AppnextAd a;
        if (j(ad) == null || (ads = j(ad).getAds()) == null || (a = a(context, (ArrayList<AppnextAd>) ads, str, ad)) == null) {
            return null;
        }
        ads.remove(a);
        ads.add(0, a);
        return ads;
    }

    /* access modifiers changed from: protected */
    public final String a(ArrayList<AppnextAd> arrayList) {
        return super.a(arrayList);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, String str, Ad ad) {
        super.a(context, str, ad);
    }

    private static boolean hasVideo(AppnextAd appnextAd) {
        return !appnextAd.getVideoUrl().equals("") || !appnextAd.getVideoUrlHigh().equals("") || !appnextAd.getVideoUrl30Sec().equals("") || !appnextAd.getVideoUrlHigh30Sec().equals("");
    }

    private static boolean b(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals("");
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, ArrayList<AppnextAd> arrayList, String str, Ad ad) {
        Iterator<AppnextAd> it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd next = it.next();
            if (a(next, str, ad)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x003a A[Catch:{ all -> 0x006c }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0059 A[Catch:{ all -> 0x006c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(com.appnext.core.AppnextAd r6, java.lang.String r7, com.appnext.core.Ad r8) {
        /*
            r5 = this;
            r0 = 0
            int r1 = r7.hashCode()     // Catch:{ all -> 0x006c }
            r2 = -892481938(0xffffffffcacdce6e, float:-6743863.0)
            r3 = 2
            r4 = 1
            if (r1 == r2) goto L_0x002c
            r2 = 112202875(0x6b0147b, float:6.6233935E-35)
            if (r1 == r2) goto L_0x0021
            r2 = 835260319(0x31c90f9f, float:5.851646E-9)
            if (r1 == r2) goto L_0x0017
            goto L_0x0037
        L_0x0017:
            java.lang.String r1 = "managed"
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0037
            r7 = 0
            goto L_0x0038
        L_0x0021:
            java.lang.String r1 = "video"
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0037
            r7 = 1
            goto L_0x0038
        L_0x002c:
            java.lang.String r1 = "static"
            boolean r7 = r7.equals(r1)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0037
            r7 = 2
            goto L_0x0038
        L_0x0037:
            r7 = -1
        L_0x0038:
            if (r7 == 0) goto L_0x0059
            if (r7 == r4) goto L_0x004c
            if (r7 == r3) goto L_0x003f
            goto L_0x0072
        L_0x003f:
            boolean r7 = b(r6)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0072
            r6.getBannerID()     // Catch:{ all -> 0x006c }
            r8.getPlacementID()     // Catch:{ all -> 0x006c }
            return r4
        L_0x004c:
            boolean r7 = hasVideo(r6)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0072
            r6.getBannerID()     // Catch:{ all -> 0x006c }
            r8.getPlacementID()     // Catch:{ all -> 0x006c }
            return r4
        L_0x0059:
            boolean r7 = b(r6)     // Catch:{ all -> 0x006c }
            if (r7 != 0) goto L_0x0065
            boolean r7 = hasVideo(r6)     // Catch:{ all -> 0x006c }
            if (r7 == 0) goto L_0x0072
        L_0x0065:
            r6.getBannerID()     // Catch:{ all -> 0x006c }
            r8.getPlacementID()     // Catch:{ all -> 0x006c }
            return r4
        L_0x006c:
            r6 = move-exception
            java.lang.String r7 = "InterstitialAdsManager$isMatchToCreativeAndNotShown"
            com.appnext.base.a.a(r7, r6)
        L_0x0072:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.interstitial.a.a(com.appnext.core.AppnextAd, java.lang.String, com.appnext.core.Ad):boolean");
    }

    private static int a(Context context, AppnextAd appnextAd) {
        try {
            InterstitialAd interstitialAd = new InterstitialAd(appnextAd);
            if (!interstitialAd.getCptList().equals("")) {
                if (!interstitialAd.getCptList().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                    JSONArray jSONArray = new JSONArray(interstitialAd.getCptList());
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (g.b(context, jSONArray.getString(i))) {
                            return 0;
                        }
                    }
                    return 3;
                }
            }
            return 0;
        } catch (JSONException e) {
            com.appnext.base.a.a("InterstitialAdsManager$checkCPT", e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final void g(Ad ad) {
        if (ad != null) {
            try {
                Q().remove(new b(ad));
            } catch (Throwable th) {
                com.appnext.base.a.a("InterstitialAdsManager$CleanContainer", th);
            }
        }
    }
}
