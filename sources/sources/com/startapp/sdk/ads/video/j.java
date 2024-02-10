package com.startapp.sdk.ads.video;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.startapp.sdk.ads.video.d;
import com.startapp.sdk.adsbase.AdsCommonMetaData;
import java.net.URL;

/* compiled from: Sta */
public class j {
    public Context a;
    public URL b;
    public String c;
    public b d;
    public d.a e;

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        public void run() {
            b bVar = j.this.d;
            if (bVar != null) {
                bVar.a(this.a);
            }
        }
    }

    /* compiled from: Sta */
    public interface b {
        void a(String str);
    }

    public j(Context context, URL url, String str, b bVar, d.a aVar) {
        this.a = context;
        this.b = url;
        this.c = str;
        this.d = bVar;
        this.e = aVar;
    }

    public void a() {
        String str;
        try {
            str = AdsCommonMetaData.h.G().p() ? d.b.a.a(this.a, this.b, this.c, this.e) : VideoUtil.a(this.a, this.b, this.c);
        } catch (Exception unused) {
            str = null;
        }
        new Handler(Looper.getMainLooper()).post(new a(str));
    }
}
