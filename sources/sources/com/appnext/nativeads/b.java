package com.appnext.nativeads;

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
import com.appnext.nativeads.NativeAdRequest;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;

public class b extends d {
    private static b fp;
    private final int r = 200;

    /* access modifiers changed from: protected */
    public final void a(Ad ad, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public final <T> void a(String str, Ad ad, T t) {
    }

    public static synchronized b aE() {
        b bVar;
        synchronized (b.class) {
            if (fp == null) {
                fp = new b();
            }
            bVar = fp;
        }
        return bVar;
    }

    public final void a(Context context, Ad ad, String str, d.a aVar, NativeAdRequest nativeAdRequest) {
        ((NativeAdObject) ad).setAdRequest(new NativeAdRequest(nativeAdRequest));
        super.a(context, ad, str, aVar, true);
    }

    /* access modifiers changed from: protected */
    public final String a(Context context, Ad ad, String str, ArrayList<Pair<String, String>> arrayList) {
        Integer num;
        Integer num2;
        try {
            StringBuilder sb = new StringBuilder("&auid=");
            sb.append(ad != null ? ad.getAUID() : "1000");
            sb.append("&creative=");
            sb.append(ad != null ? Integer.valueOf(((NativeAdRequest) ((NativeAdObject) ad).getAdRequest()).getCreativeType().ordinal()) : NativeAdRequest.CreativeType.ALL);
            sb.append("&vidmin=");
            if (ad == null) {
                num = "";
            } else {
                num = Integer.valueOf(ad.getMinVideoLength());
            }
            sb.append(num);
            sb.append("&vidmax=");
            if (ad == null) {
                num2 = "";
            } else {
                num2 = Integer.valueOf(ad.getMaxVideoLength());
            }
            sb.append(num2);
            return sb.toString();
        } catch (Throwable th) {
            a.a("NativeAdsManager$urlSuffix", th);
            return "";
        }
    }

    static String a(NativeAdRequest nativeAdRequest, AppnextAd appnextAd) {
        String videoUrl;
        String str = "";
        if (nativeAdRequest.getVideoQuality() == NativeAdRequest.VideoQuality.HIGH && nativeAdRequest.getVideoLength() == NativeAdRequest.VideoLength.LONG) {
            videoUrl = appnextAd.getVideoUrlHigh30Sec();
            try {
                if (videoUrl.equals(str)) {
                    return appnextAd.getVideoUrl30Sec();
                }
            } catch (Throwable th) {
                th = th;
                str = videoUrl;
                a.a("NativeAdsManager$getVideoUrl", th);
                return str;
            }
        } else {
            try {
                if (nativeAdRequest.getVideoQuality() == NativeAdRequest.VideoQuality.LOW && nativeAdRequest.getVideoLength() == NativeAdRequest.VideoLength.LONG) {
                    videoUrl = appnextAd.getVideoUrl30Sec();
                    if (videoUrl.equals(str)) {
                        return appnextAd.getVideoUrlHigh30Sec();
                    }
                } else if (nativeAdRequest.getVideoQuality() == NativeAdRequest.VideoQuality.HIGH && nativeAdRequest.getVideoLength() == NativeAdRequest.VideoLength.SHORT) {
                    videoUrl = appnextAd.getVideoUrlHigh();
                    if (videoUrl.equals(str)) {
                        return appnextAd.getVideoUrl();
                    }
                } else {
                    if (nativeAdRequest.getVideoQuality() == NativeAdRequest.VideoQuality.LOW && nativeAdRequest.getVideoLength() == NativeAdRequest.VideoLength.SHORT) {
                        videoUrl = appnextAd.getVideoUrl();
                        if (videoUrl.equals(str)) {
                            str = appnextAd.getVideoUrlHigh();
                        }
                    }
                    return str;
                }
            } catch (Throwable th2) {
                th = th2;
                a.a("NativeAdsManager$getVideoUrl", th);
                return str;
            }
        }
        str = videoUrl;
        return str;
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
            a.a("NativeAdsManager$extractFileNameFromPath", th);
            return substring;
        }
    }

    /* access modifiers changed from: protected */
    public final int a(Context context, h hVar) {
        try {
            NativeAdData nativeAdData = new NativeAdData((AppnextAd) hVar);
            int a = a(context, nativeAdData);
            if (a != 0) {
                return a;
            }
            boolean z = true;
            if (nativeAdData.getCampaignGoal().equals("new") && g.b(context, nativeAdData.getAdPackage())) {
                return 1;
            }
            if (nativeAdData.getCampaignGoal().equals("existing") && !g.b(context, nativeAdData.getAdPackage())) {
                return 2;
            }
            if (!b((AppnextAd) hVar)) {
                AppnextAd appnextAd = (AppnextAd) hVar;
                if (appnextAd.getVideoUrl().equals("") && appnextAd.getVideoUrlHigh().equals("") && appnextAd.getVideoUrl30Sec().equals("") && appnextAd.getVideoUrlHigh30Sec().equals("")) {
                    z = false;
                }
                if (z) {
                    return 0;
                }
                return 3;
            }
            return 0;
        } catch (Throwable th) {
            a.a("NativeAdsManager$adFilter", th);
            return 3;
        }
    }

    /* access modifiers changed from: protected */
    public SettingsManager c(Ad ad) {
        return a.aC();
    }

    public final ArrayList<AppnextAd> a(String str, NativeAdRequest nativeAdRequest, ArrayList<AppnextAd> arrayList) {
        ArrayList<AppnextAd> arrayList2 = new ArrayList<>();
        Iterator<AppnextAd> it = arrayList.iterator();
        while (it.hasNext()) {
            AppnextAd next = it.next();
            if (a(next, nativeAdRequest)) {
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, ArrayList<AppnextAd> arrayList, NativeAdRequest nativeAdRequest) {
        try {
            Iterator<AppnextAd> it = arrayList.iterator();
            while (it.hasNext()) {
                AppnextAd next = it.next();
                if (a(next, nativeAdRequest)) {
                    next.getBannerID();
                    ad.getAUID();
                    return next;
                }
            }
            return null;
        } catch (Throwable th) {
            a.a("NativeAdsManager$getFirst", th);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final AppnextAd a(Context context, Ad ad, NativeAdRequest nativeAdRequest) {
        ArrayList<?> ads;
        if (j(ad) == null || (ads = j(ad).getAds()) == null) {
            return null;
        }
        return a(context, ad, (ArrayList<AppnextAd>) ads, nativeAdRequest);
    }

    private boolean a(AppnextAd appnextAd, NativeAdRequest nativeAdRequest) {
        if (nativeAdRequest.getCreativeType() == NativeAdRequest.CreativeType.ALL) {
            return b(appnextAd) || !a(nativeAdRequest, appnextAd).equals("");
        }
        if (nativeAdRequest.getCreativeType() == NativeAdRequest.CreativeType.STATIC_ONLY) {
            return b(appnextAd);
        }
        return nativeAdRequest.getCreativeType() == NativeAdRequest.CreativeType.VIDEO_ONLY && !a(nativeAdRequest, appnextAd).equals("");
    }

    private static int a(Context context, NativeAdData nativeAdData) {
        try {
            if (!nativeAdData.getCptList().equals("") && !nativeAdData.getCptList().equals(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI)) {
                JSONArray jSONArray = new JSONArray(nativeAdData.getCptList());
                for (int i = 0; i < jSONArray.length(); i++) {
                    if (g.b(context, jSONArray.getString(i))) {
                        return 0;
                    }
                }
                return 3;
            }
        } catch (JSONException e) {
            a.a("NativeAdsManager$checkCPT", e);
        } catch (Throwable th) {
            a.a("NativeAdsManager$checkCPT", th);
            return 3;
        }
        return 0;
    }

    public final ArrayList<AppnextAd> e(Ad ad) {
        return j(ad).getAds();
    }

    static boolean b(AppnextAd appnextAd) {
        return !appnextAd.getWideImageURL().equals("");
    }

    /* access modifiers changed from: protected */
    public final boolean a(Ad ad) {
        return super.a(ad);
    }

    /* access modifiers changed from: protected */
    public final void a(Context context, Ad ad, com.appnext.core.a aVar) throws Exception {
        try {
            File[] listFiles = new File(context.getFilesDir().getAbsolutePath() + "/data/appnext/videos/").listFiles();
            if (listFiles != null) {
                if (listFiles.length != 0) {
                    Arrays.sort(listFiles, new Comparator<File>() {
                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            return Long.valueOf(((File) obj).lastModified()).compareTo(Long.valueOf(((File) obj2).lastModified()));
                        }
                    });
                    int parseInt = Integer.parseInt(a.aC().t("num_saved_videos")) - 1;
                    if (listFiles.length > parseInt) {
                        for (int i = 0; i < listFiles.length - parseInt; i++) {
                            listFiles[i].delete();
                        }
                    }
                }
            }
        } catch (Throwable th) {
            a.a("NativeAdsManager$customAdLoad", th);
            return;
        }
        NativeAdRequest nativeAdRequest = (NativeAdRequest) ((NativeAdObject) ad).getAdRequest();
        if (nativeAdRequest.getVideoLength() == NativeAdRequest.VideoLength.DEFAULT) {
            ((NativeAdRequest) ((NativeAdObject) ad).getAdRequest()).setVideoLength(NativeAdRequest.VideoLength.fromInt(Integer.parseInt(a.aC().t("default_video_length"))));
        }
        if (nativeAdRequest.getVideoQuality() == NativeAdRequest.VideoQuality.DEFAULT) {
            nativeAdRequest.setVideoQuality(NativeAdRequest.VideoQuality.fromInt(Integer.parseInt(a.aC().t("default_video_quality"))));
        }
        AppnextAd a = aE().a(context, ad, nativeAdRequest);
        if (a != null && nativeAdRequest.getCreativeType() != NativeAdRequest.CreativeType.STATIC_ONLY) {
            if (nativeAdRequest.getCachingPolicy() == NativeAdRequest.CachingPolicy.ALL || nativeAdRequest.getCachingPolicy() == NativeAdRequest.CachingPolicy.VIDEO_ONLY) {
                String a2 = a(nativeAdRequest, a);
                if (!a2.equals("")) {
                    String b = b(a2);
                    String str = context.getFilesDir().getAbsolutePath() + "/data/appnext/videos/";
                    File file = new File(str + b);
                    if (file.exists()) {
                        file.setLastModified(System.currentTimeMillis());
                        file.getPath();
                        return;
                    }
                    new File(str).mkdirs();
                    URL url = new URL(a2);
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
                            return;
                        }
                    }
                }
            }
        }
    }
}
