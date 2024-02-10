package com.appnext.ads.fullscreen;

import android.content.Context;
import android.net.Uri;
import android.util.Pair;
import com.appnext.base.a;
import com.appnext.core.Ad;
import com.appnext.core.AppnextAd;
import com.appnext.core.SettingsManager;
import com.appnext.core.d;
import com.appnext.core.g;
import com.appnext.core.h;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import okhttp3.HttpUrl;
import org.json.JSONArray;

public final class b extends d {
    private static b q;
    private final int r = 30;
    private HashMap<Ad, String> s = new HashMap<>();

    public static synchronized b f() {
        b bVar;
        synchronized (b.class) {
            if (q == null) {
                q = new b();
            }
            bVar = q;
        }
        return bVar;
    }

    private b() {
    }

    /* access modifiers changed from: protected */
    public final String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        Integer num;
        try {
            StringBuilder sb = new StringBuilder("&auid=");
            sb.append(ad != null ? ad.getAUID() : "700");
            sb.append("&vidmin=");
            sb.append(ad == null ? "" : Integer.valueOf(ad.getMinVideoLength()));
            sb.append("&vidmax=");
            if (ad == null) {
                num = "";
            } else {
                num = Integer.valueOf(ad.getMaxVideoLength());
            }
            sb.append(num);
            return sb.toString();
        } catch (Throwable th) {
            a.a("FullscreenAdsManager$urlSuffix", th);
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public final int a(Context context, h hVar) {
        int i;
        AppnextAd appnextAd = (AppnextAd) hVar;
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        if (!fullscreenAd.getCampaignGoal().equals("new") || !g.b(context, fullscreenAd.getAdPackage())) {
            i = (!fullscreenAd.getCampaignGoal().equals("existing") || g.b(context, fullscreenAd.getAdPackage())) ? 0 : 2;
        } else {
            i = 1;
        }
        int a = a(context, appnextAd);
        if (i == 0 && a == 0) {
            return 0;
        }
        return i != 0 ? i : a;
    }

    /* access modifiers changed from: protected */
    public final boolean a(Ad ad) {
        return super.a(ad) && d(ad);
    }

    private void a(Context context, Ad ad, AppnextAd appnextAd) throws Exception {
        String str;
        try {
            String videoUrl = getVideoUrl(appnextAd, ((Video) ad).getVideoLength());
            String b = b(videoUrl);
            if (Video.getCacheVideo()) {
                str = context.getFilesDir().getAbsolutePath() + "/data/appnext/videos/";
            } else {
                str = context.getFilesDir().getAbsolutePath() + "/data/appnext/videos/tmp/vid" + ((Video) ad).rnd + "/";
            }
            File file = new File(str + b);
            if (file.exists()) {
                file.setLastModified(System.currentTimeMillis());
                file.getPath();
                this.s.put(ad, file.getAbsolutePath());
            } else if (!Video.isStreamingModeEnabled()) {
                new File(str).mkdirs();
                URL url = new URL(videoUrl);
                url.openConnection().connect();
                BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream(), 1024);
                FileOutputStream fileOutputStream = new FileOutputStream(str + b + ".tmp");
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read != -1) {
                        fileOutputStream.write(bArr, 0, read);
                    } else {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                        bufferedInputStream.close();
                        File file2 = new File(str + b + ".tmp");
                        StringBuilder sb = new StringBuilder();
                        sb.append(str);
                        sb.append(b);
                        file2.renameTo(new File(sb.toString()));
                        file2.delete();
                        this.s.put(ad, file.getAbsolutePath());
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            a.a("FullscreenAdsManager$downloadAssets", th);
        }
    }

    /* access modifiers changed from: protected */
    public final void a(Ad ad, String str, String str2) {
        if (ad != null) {
            g.a(getContext(), ad.getTID(), ad.getVID(), ad.getAUID(), str2, str, "caching_error", "sdk", "", "");
        } else {
            g.a(getContext(), "300", "2.7.0.473", "700", str2, str, "caching_error", "sdk", "", "");
        }
    }

    /* access modifiers changed from: protected */
    public final <T> void a(String str, Ad ad, T t) {
        g.a(getContext(), ad.getTID(), ad.getVID(), ad.getAUID(), str, ((Video) ad).getSessionId(), "cache_ready", "sdk", "", "");
    }

    protected static String getVideoUrl(AppnextAd appnextAd, String str) {
        String str2;
        if (str.equals("30")) {
            str2 = appnextAd.getVideoUrlHigh30Sec();
            if (str2.equals("")) {
                str2 = appnextAd.getVideoUrlHigh();
            }
        } else {
            str2 = appnextAd.getVideoUrlHigh();
            if (str2.equals("")) {
                str2 = appnextAd.getVideoUrlHigh30Sec();
            }
        }
        if (appnextAd != null) {
            appnextAd.getBannerID();
        }
        return str2;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, String str, Ad ad) {
        super.a(context, str, ad);
        if (this.s.containsKey(ad)) {
            this.s.remove(ad);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean b(Ad ad) {
        try {
            if (!h(ad) || j(ad).O().longValue() + 0 + 300000 < System.currentTimeMillis() || !d(ad)) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            a.a("FullscreenAdsManager$isReadyToShow", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final SettingsManager c(Ad ad) {
        return ad instanceof RewardedVideo ? f.o() : c.h();
    }

    private boolean d(Ad ad) {
        try {
            if (Video.isStreamingModeEnabled()) {
                return true;
            }
            if (!this.s.containsKey(ad)) {
                return false;
            }
            return new File(this.s.get(ad)).exists();
        } catch (Throwable th) {
            a.a("FullscreenAdsManager$isVideoLoaded", th);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad) {
        return a(context, ad, "");
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, String str) {
        ArrayList<?> ads;
        if (j(ad) == null || (ads = j(ad).getAds()) == null) {
            return null;
        }
        return a(context, ad, (ArrayList<AppnextAd>) ads, str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002c A[Catch:{ all -> 0x003d }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0006 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.appnext.core.AppnextAd a(android.content.Context r3, com.appnext.core.Ad r4, java.util.ArrayList<com.appnext.core.AppnextAd> r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r3 = ""
            java.util.Iterator r5 = r5.iterator()     // Catch:{ all -> 0x003d }
        L_0x0006:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0043
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x003d }
            com.appnext.core.AppnextAd r0 = (com.appnext.core.AppnextAd) r0     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r0.getVideoUrlHigh()     // Catch:{ all -> 0x003d }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0029
            java.lang.String r1 = r0.getVideoUrlHigh30Sec()     // Catch:{ all -> 0x003d }
            boolean r1 = r1.equals(r3)     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0027
            goto L_0x0029
        L_0x0027:
            r1 = 0
            goto L_0x002a
        L_0x0029:
            r1 = 1
        L_0x002a:
            if (r1 == 0) goto L_0x0006
            r0.getBannerID()     // Catch:{ all -> 0x003d }
            r4.getPlacementID()     // Catch:{ all -> 0x003d }
            java.lang.String r1 = r0.getBannerID()     // Catch:{ all -> 0x003d }
            boolean r1 = r1.equals(r6)     // Catch:{ all -> 0x003d }
            if (r1 != 0) goto L_0x0006
            return r0
        L_0x003d:
            r3 = move-exception
            java.lang.String r4 = "FullscreenAdsManager$getFirst"
            com.appnext.base.a.a(r4, r3)
        L_0x0043:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.fullscreen.b.a(android.content.Context, com.appnext.core.Ad, java.util.ArrayList, java.lang.String):com.appnext.core.AppnextAd");
    }

    /* access modifiers changed from: protected */
    public final ArrayList<AppnextAd> e(Ad ad) {
        return j(ad).getAds();
    }

    private static int a(Context context, AppnextAd appnextAd) {
        FullscreenAd fullscreenAd = new FullscreenAd(appnextAd);
        if (!fullscreenAd.getCptList().equals("") && !fullscreenAd.getCptList().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
            try {
                JSONArray jSONArray = new JSONArray(fullscreenAd.getCptList());
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (g.b(context, jSONArray.getString(i))) {
                        return 0;
                    }
                }
                return 3;
            } catch (Throwable th) {
                a.a("FullscreenAdsManager$checkCPT", th);
            }
        }
        return 0;
    }

    protected static String b(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (substring.contains("?")) {
            substring = substring.substring(0, substring.indexOf("?"));
        }
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("rnd");
            if (queryParameter == null || queryParameter.equals("")) {
                return substring;
            }
            return substring.substring(0, substring.lastIndexOf(46)) + "_" + queryParameter + substring.substring(substring.lastIndexOf(46));
        } catch (Throwable th) {
            a.a("FullscreenAdsManager$extractFileNameFromPath", th);
            return substring;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0070 */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b9  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.content.Context r4, com.appnext.core.Ad r5, com.appnext.core.a r6) throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006a }
            r6.<init>()     // Catch:{ all -> 0x006a }
            java.io.File r0 = r4.getFilesDir()     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r0.getAbsolutePath()     // Catch:{ all -> 0x006a }
            r6.append(r0)     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "/data/appnext/videos/"
            r6.append(r0)     // Catch:{ all -> 0x006a }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x006a }
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x006a }
            r0.<init>(r6)     // Catch:{ all -> 0x006a }
            java.io.File[] r6 = r0.listFiles()     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x0070
            int r0 = r6.length     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0028
            goto L_0x0070
        L_0x0028:
            com.appnext.ads.fullscreen.b$1 r0 = new com.appnext.ads.fullscreen.b$1     // Catch:{ all -> 0x006a }
            r0.<init>()     // Catch:{ all -> 0x006a }
            java.util.Arrays.sort(r6, r0)     // Catch:{ all -> 0x006a }
            boolean r0 = com.appnext.ads.fullscreen.Video.getCacheVideo()     // Catch:{ all -> 0x006a }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            boolean r0 = r5 instanceof com.appnext.ads.fullscreen.FullScreenVideo     // Catch:{ all -> 0x006a }
            java.lang.String r2 = "num_saved_videos"
            if (r0 == 0) goto L_0x004a
            com.appnext.ads.fullscreen.c r0 = com.appnext.ads.fullscreen.c.h()     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r0.t(r2)     // Catch:{ all -> 0x006a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x006a }
            goto L_0x0056
        L_0x004a:
            com.appnext.ads.fullscreen.f r0 = com.appnext.ads.fullscreen.f.o()     // Catch:{ all -> 0x006a }
            java.lang.String r0 = r0.t(r2)     // Catch:{ all -> 0x006a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x006a }
        L_0x0056:
            int r0 = r0 + -1
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r2 = r6.length     // Catch:{ all -> 0x006a }
            if (r2 > r0) goto L_0x005e
            goto L_0x0070
        L_0x005e:
            int r2 = r6.length     // Catch:{ all -> 0x006a }
            int r2 = r2 - r0
            if (r1 >= r2) goto L_0x0070
            r2 = r6[r1]     // Catch:{ all -> 0x006a }
            r2.delete()     // Catch:{ all -> 0x006a }
            int r1 = r1 + 1
            goto L_0x005e
        L_0x006a:
            r6 = move-exception
            java.lang.String r0 = "FullscreenAdsManager$deleteFiles"
            com.appnext.base.a.a(r0, r6)     // Catch:{ all -> 0x0070 }
        L_0x0070:
            com.appnext.core.AppnextAd r6 = r3.a((android.content.Context) r4, (com.appnext.core.Ad) r5)     // Catch:{ all -> 0x00b0 }
            if (r6 != 0) goto L_0x0077
            return
        L_0x0077:
            r3.a((android.content.Context) r4, (com.appnext.core.Ad) r5, (com.appnext.core.AppnextAd) r6)     // Catch:{ all -> 0x00ae }
            boolean r0 = r5 instanceof com.appnext.ads.fullscreen.RewardedVideo     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x00ad
            r0 = r5
            com.appnext.ads.fullscreen.RewardedVideo r0 = (com.appnext.ads.fullscreen.RewardedVideo) r0     // Catch:{ all -> 0x00ae }
            java.lang.String r0 = r0.getMode()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "default"
            boolean r1 = r0.equals(r1)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x0097
            com.appnext.ads.fullscreen.f r0 = com.appnext.ads.fullscreen.f.o()     // Catch:{ all -> 0x00ae }
            java.lang.String r1 = "default_mode"
            java.lang.String r0 = r0.t(r1)     // Catch:{ all -> 0x00ae }
        L_0x0097:
            java.lang.String r1 = "multi"
            boolean r0 = r0.equals(r1)     // Catch:{ all -> 0x00ae }
            if (r0 == 0) goto L_0x00ad
            java.lang.String r0 = r6.getBannerID()     // Catch:{ all -> 0x00ae }
            com.appnext.core.AppnextAd r6 = r3.a((android.content.Context) r4, (com.appnext.core.Ad) r5, (java.lang.String) r0)     // Catch:{ all -> 0x00ae }
            if (r6 != 0) goto L_0x00aa
            return
        L_0x00aa:
            r3.a((android.content.Context) r4, (com.appnext.core.Ad) r5, (com.appnext.core.AppnextAd) r6)     // Catch:{ all -> 0x00ae }
        L_0x00ad:
            return
        L_0x00ae:
            r0 = move-exception
            goto L_0x00b2
        L_0x00b0:
            r0 = move-exception
            r6 = 0
        L_0x00b2:
            java.lang.String r1 = "FullscreenAdsManager$customAdLoad"
            com.appnext.base.a.a(r1, r0)
            if (r6 == 0) goto L_0x00c0
            java.lang.String r6 = r6.getBannerID()
            r3.a((android.content.Context) r4, (java.lang.String) r6, (com.appnext.core.Ad) r5)
        L_0x00c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.ads.fullscreen.b.a(android.content.Context, com.appnext.core.Ad, com.appnext.core.a):void");
    }
}
