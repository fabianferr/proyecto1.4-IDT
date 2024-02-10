package com.startapp;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.startapp.sdk.adsbase.remoteconfig.ComponentInfoEventConfig;
import com.startapp.sdk.adsbase.remoteconfig.WvfMetadata;

/* compiled from: Sta */
public class bb implements va {
    public final Context a;
    public final i2<WvfMetadata> b;
    public WebView c;
    public String d;
    public boolean e;

    /* compiled from: Sta */
    public class a implements Runnable {

        /* renamed from: com.startapp.bb$a$a  reason: collision with other inner class name */
        /* compiled from: Sta */
        public class C0160a implements MessageQueue.IdleHandler {
            public C0160a() {
            }

            public boolean queueIdle() {
                bb bbVar = bb.this;
                if (bbVar.c != null) {
                    return false;
                }
                try {
                    WebView webView = new WebView(bbVar.a);
                    if (bbVar.d == null) {
                        bbVar.d = webView.getSettings().getUserAgentString();
                    }
                    bbVar.c = webView;
                    return false;
                } catch (Throwable unused) {
                    return false;
                }
            }
        }

        public a() {
        }

        public void run() {
            try {
                MessageQueue myQueue = Looper.myQueue();
                if (myQueue != null) {
                    myQueue.addIdleHandler(new C0160a());
                }
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }

    public bb(Context context, i2<WvfMetadata> i2Var) {
        if (Build.VERSION.SDK_INT < 31 || context.isUiContext()) {
            this.a = context;
        } else {
            this.a = context.createWindowContext(((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0), 2, (Bundle) null);
        }
        this.b = i2Var;
    }

    public boolean a(int i) {
        WvfMetadata a2 = this.b.a();
        ComponentInfoEventConfig a3 = a2 != null ? a2.a() : null;
        return a3 != null && a3.a((long) i);
    }

    public WebView b() {
        WebView webView = this.c;
        if (webView == null) {
            webView = new WebView(this.a);
            if (this.d == null) {
                this.d = webView.getSettings().getUserAgentString();
            }
        } else {
            this.c = null;
            com.startapp.sdk.adsbase.a.a((Runnable) new a());
        }
        return webView;
    }

    public void c() {
        com.startapp.sdk.adsbase.a.a((Runnable) new a());
    }

    public String a() {
        int i;
        String str = this.d;
        long j = 0;
        if (str == null || str.length() < 1) {
            WvfMetadata a2 = this.b.a();
            int b2 = k9.b(a2 != null ? a2.c() : WvfMetadata.a);
            i = 0;
            if (b2 < 0) {
                b2 = 0;
            }
            if (b2 == 1) {
                try {
                    long currentTimeMillis = System.currentTimeMillis();
                    str = WebSettings.getDefaultUserAgent(this.a);
                    j = System.currentTimeMillis() - currentTimeMillis;
                    i = 2;
                } catch (Throwable th) {
                    if (a(8)) {
                        i3.a(th);
                    }
                }
            }
            if (str == null || str.length() < 1) {
                try {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    str = System.getProperty("http.agent");
                    j = System.currentTimeMillis() - currentTimeMillis2;
                    i = 4;
                } catch (Throwable th2) {
                    if (a(16)) {
                        i3.a(th2);
                    }
                }
            }
        } else {
            i = 1;
        }
        if (!this.e) {
            this.e = true;
            if (a(i)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "WVF.gua";
                i3Var.i = String.valueOf(i);
                i3Var.e = str + ", " + j + " ms";
                i3Var.a();
            }
        }
        return str;
    }
}
