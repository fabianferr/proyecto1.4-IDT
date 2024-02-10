package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;

/* compiled from: Sta */
public class i implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ DiskAdCacheManager.c b;

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ((b) i.this.b).a.c = false;
        }
    }

    public i(Context context, DiskAdCacheManager.c cVar) {
        this.a = context;
        this.b = cVar;
    }

    public void run() {
        try {
            f2.a(this.a, "startapp_ads");
            new Handler(Looper.getMainLooper()).post(new a());
        } catch (Throwable th) {
            i3.a(th);
        }
    }
}
