package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.sdk.adsbase.cache.CachedVideoAd;
import com.startapp.sdk.adsbase.cache.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class h {
    public LinkedList<CachedVideoAd> a = new LinkedList<>();
    public final Context b;
    public final Executor c;
    public final d d;

    public h(Context context, Executor executor, d dVar) {
        this.b = context;
        this.c = executor;
        this.d = dVar;
    }

    public boolean a(int i) {
        ArrayList arrayList;
        boolean z;
        Iterator it = this.a.iterator();
        boolean z2 = false;
        while (it.hasNext() && this.a.size() > i) {
            CachedVideoAd cachedVideoAd = (CachedVideoAd) it.next();
            d dVar = this.d;
            String a2 = cachedVideoAd.a();
            synchronized (dVar) {
                arrayList = new ArrayList(dVar.a.values());
            }
            Iterator it2 = arrayList.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = false;
                    break;
                }
                com.startapp.sdk.adsbase.d dVar2 = ((com.startapp.sdk.adsbase.cache.h) it2.next()).e;
                if (dVar2 instanceof VideoEnabledAd) {
                    VideoEnabledAd videoEnabledAd = (VideoEnabledAd) dVar2;
                    if (!(videoEnabledAd.x() == null || videoEnabledAd.x().c() == null || !videoEnabledAd.x().c().equals(a2))) {
                        z = true;
                        break;
                    }
                }
            }
            if (!z) {
                it.remove();
                if (cachedVideoAd.a() != null) {
                    new File(cachedVideoAd.a()).delete();
                }
                z2 = true;
            }
        }
        return z2;
    }
}
