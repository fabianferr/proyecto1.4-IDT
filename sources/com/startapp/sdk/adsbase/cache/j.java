package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;
import com.startapp.sdk.adsbase.cache.d;
import java.util.List;

/* compiled from: Sta */
public class j implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DiskAdCacheManager.b b;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        public void run() {
            DiskAdCacheManager.b bVar = j.this.b;
            List<DiskAdCacheManager.DiskCacheKey> list = this.a;
            a aVar = (a) bVar;
            aVar.getClass();
            if (list != null) {
                try {
                    for (DiskAdCacheManager.DiskCacheKey diskCacheKey : list) {
                        if (aVar.b.a(diskCacheKey.placement)) {
                            aVar.b.a(aVar.a, (StartAppAd) null, diskCacheKey.placement, diskCacheKey.adPreferences, (d.C0000d) null, true, diskCacheKey.a());
                        }
                    }
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
            d dVar = aVar.b;
            Context context = aVar.a;
            dVar.d = false;
            for (d.e eVar : dVar.e) {
                if (dVar.a(eVar.b)) {
                    dVar.a(context, eVar.a, eVar.b, eVar.c, new c(dVar, eVar), false, 0);
                }
            }
            dVar.e.clear();
        }
    }

    public j(Context context, DiskAdCacheManager.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public void run() {
        try {
            new Handler(Looper.getMainLooper()).post(new a(f2.d(this.a, DiskAdCacheManager.b())));
        } catch (Throwable th) {
            i3.a(th);
        }
    }
}
