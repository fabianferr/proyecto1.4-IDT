package com.startapp.sdk.ads.video;

import android.content.Context;
import android.util.Base64;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.ads.video.j;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

/* compiled from: Sta */
public class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ j.b b;
    public final /* synthetic */ d.a c;
    public final /* synthetic */ h d;

    public e(h hVar, String str, j.b bVar, d.a aVar) {
        this.d = hVar;
        this.a = str;
        this.b = bVar;
        this.c = aVar;
    }

    public void run() {
        String str;
        h hVar = this.d;
        Context context = hVar.b;
        String str2 = this.a;
        j.b bVar = this.b;
        d.a aVar = this.c;
        if (hVar.a == null) {
            LinkedList<CachedVideoAd> linkedList = (LinkedList) f2.a(context, "CachedAds", LinkedList.class);
            hVar.a = linkedList;
            if (linkedList == null) {
                hVar.a = new LinkedList<>();
            }
            if (hVar.a(AdsCommonMetaData.h.G().b())) {
                f2.b(context, "CachedAds", hVar.a);
            }
        }
        try {
            URL url = new URL(str2);
            String str3 = url.getHost() + url.getPath().replace("/", "_");
            try {
                String substring = str3.substring(0, str3.lastIndexOf(46));
                str = Base64.encodeToString(MessageDigest.getInstance(SameMD5.TAG).digest(substring.getBytes()), 0).replaceAll("[^a-zA-Z0-9]+", "_") + str3.substring(str3.lastIndexOf(46));
            } catch (NoSuchAlgorithmException e) {
                i3.a((Throwable) e);
                str = str3;
            }
            new j(context, url, str, new f(hVar, bVar, new CachedVideoAd(str), context), new g(hVar, aVar)).a();
        } catch (MalformedURLException e2) {
            if (bVar != null) {
                bVar.a((String) null);
            }
            i3.a((Throwable) e2);
        }
    }
}
