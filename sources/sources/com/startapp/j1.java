package com.startapp;

import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.cache.e;
import com.startapp.sdk.adsbase.cache.h;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;

/* compiled from: Sta */
public abstract class j1 {
    public h a;
    public Handler b = null;
    public Long c = null;
    public boolean d = false;

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j1.this.c();
        }
    }

    public j1(h hVar) {
        this.a = hVar;
    }

    public abstract boolean a();

    public abstract long b();

    public void c() {
        this.c = null;
        this.d = false;
        h hVar = this.a;
        if (hVar.m < MetaData.k.M()) {
            hVar.m++;
            hVar.a((StartAppAd) null, (AdEventListener) null, true, false);
            return;
        }
        h.b bVar = hVar.p;
        if (bVar != null) {
            ((e) bVar).a(hVar);
        }
    }

    public void d() {
        if (!this.d) {
            if (this.c == null) {
                this.c = Long.valueOf(System.currentTimeMillis());
            }
            if (a()) {
                if (this.b == null) {
                    Looper myLooper = Looper.myLooper();
                    if (myLooper == null) {
                        myLooper = Looper.getMainLooper();
                    }
                    this.b = new Handler(myLooper);
                }
                long b2 = b();
                if (b2 >= 0) {
                    this.d = true;
                    this.b.postDelayed(new a(), b2);
                }
            }
        }
    }

    public void e() {
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
        this.c = null;
        this.d = false;
    }
}
