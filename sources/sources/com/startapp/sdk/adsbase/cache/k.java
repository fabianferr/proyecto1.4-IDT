package com.startapp.sdk.adsbase.cache;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.f2;
import com.startapp.i3;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.DiskAdCacheManager;

/* compiled from: Sta */
public class k implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;
    public final /* synthetic */ AdEventListener c;
    public final /* synthetic */ DiskAdCacheManager.a d;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ DiskAdCacheManager.DiskCachedAd a;

        public a(DiskAdCacheManager.DiskCachedAd diskCachedAd) {
            this.a = diskCachedAd;
        }

        public void run() {
            try {
                DiskAdCacheManager.DiskCachedAd diskCachedAd = this.a;
                if (diskCachedAd == null) {
                    k kVar = k.this;
                    DiskAdCacheManager.a(kVar.a, kVar.c);
                    return;
                }
                if (diskCachedAd.a() != null) {
                    if (this.a.a().isReady()) {
                        if (this.a.a().d()) {
                            k kVar2 = k.this;
                            DiskAdCacheManager.a(kVar2.a, kVar2.c);
                            return;
                        }
                        k kVar3 = k.this;
                        DiskAdCacheManager.a(kVar3.a, this.a, kVar3.d, kVar3.c);
                        return;
                    }
                }
                k kVar4 = k.this;
                DiskAdCacheManager.a(kVar4.a, kVar4.c);
            } catch (Throwable th) {
                i3.a(th);
                k kVar5 = k.this;
                DiskAdCacheManager.a(kVar5.a, kVar5.c);
            }
        }
    }

    public k(Context context, String str, AdEventListener adEventListener, DiskAdCacheManager.a aVar) {
        this.a = context;
        this.b = str;
        this.c = adEventListener;
        this.d = aVar;
    }

    public void run() {
        Object obj;
        try {
            Context context = this.a;
            String a2 = DiskAdCacheManager.a();
            String str = this.b;
            obj = null;
            if (str != null) {
                obj = f2.a(f2.b(context, a2), str);
            }
        } catch (Throwable th) {
            i3.a(th);
            DiskAdCacheManager.a(this.a, this.c);
            return;
        }
        new Handler(Looper.getMainLooper()).post(new a((DiskAdCacheManager.DiskCachedAd) obj));
    }
}
