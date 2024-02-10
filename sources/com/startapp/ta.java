package com.startapp;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.startapp.sdk.ads.banner.BannerOptions;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* compiled from: Sta */
public class ta {
    public final Handler a;
    public final WeakReference<View> b;
    public final BannerOptions c;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        public void run() {
            if (this.a.onUpdate(ta.a(ta.this))) {
                ta.this.a.postDelayed(this, 100);
            }
        }
    }

    /* compiled from: Sta */
    public interface b {
        boolean onUpdate(boolean z);
    }

    public ta(View view, BannerOptions bannerOptions, b bVar) {
        Handler handler = new Handler(Looper.getMainLooper());
        this.a = handler;
        this.b = new WeakReference<>(view);
        this.c = bannerOptions;
        handler.postDelayed(new a(bVar), 100);
    }

    public void a() {
        this.a.removeCallbacksAndMessages((Object) null);
    }

    public static boolean a(ta taVar) {
        return ra.a((View) taVar.b.get(), taVar.c, (AtomicReference<JSONObject>) new AtomicReference()) == null;
    }
}
