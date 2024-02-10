package com.startapp;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.startapp.sdk.adsbase.remoteconfig.ComponentInfoEventConfig;
import com.startapp.sdk.adsbase.remoteconfig.WvfMetadata;
import java.util.LinkedList;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class wa implements va {
    public final Context a;
    public final n4<Executor> b;
    public final n4<v2> c;
    public final i2<WvfMetadata> d;
    public final LinkedList<WebView> e = new LinkedList<>();
    public String f;
    public boolean g = true;
    public final MessageQueue.IdleHandler h = new a();
    public final Runnable i = new b();

    /* compiled from: Sta */
    public class a implements MessageQueue.IdleHandler {
        public a() {
        }

        public boolean queueIdle() {
            wa waVar = wa.this;
            waVar.getClass();
            try {
                WebView webView = new WebView(waVar.a);
                if (waVar.g) {
                    waVar.g = false;
                    WvfMetadata a2 = waVar.d.a();
                    int b = k9.b(a2 != null ? a2.c() : WvfMetadata.a);
                    if (b < 0) {
                        b = 0;
                    }
                    if (b == 1) {
                        try {
                            waVar.b.a().execute(new xa(waVar));
                        } catch (Throwable th) {
                            if (waVar.a(8)) {
                                i3.a(th);
                            }
                        }
                    } else if (b == 2) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            webView.setWebViewClient(new za(waVar));
                            webView.loadUrl("http://0.0.0.0");
                            return false;
                        }
                    }
                }
                try {
                    webView.setWebViewClient((WebViewClient) null);
                    waVar.e.addLast(webView);
                } catch (Throwable th2) {
                    if (waVar.a(4)) {
                        i3.a(th2);
                    }
                }
            } catch (Throwable th3) {
                if (waVar.a(2)) {
                    i3.a(th3);
                }
            }
            return false;
        }
    }

    /* compiled from: Sta */
    public class b implements Runnable {
        public b() {
        }

        public void run() {
            wa waVar = wa.this;
            waVar.getClass();
            try {
                MessageQueue myQueue = Looper.myQueue();
                if (myQueue != null) {
                    myQueue.addIdleHandler(waVar.h);
                }
            } catch (Throwable th) {
                if (waVar.a(512)) {
                    i3.a(th);
                }
            }
        }
    }

    public wa(Context context, n4<Executor> n4Var, n4<v2> n4Var2, i2<WvfMetadata> i2Var) {
        if (Build.VERSION.SDK_INT < 31 || context.isUiContext()) {
            this.a = context;
        } else {
            this.a = context.createWindowContext(((DisplayManager) context.getSystemService(DisplayManager.class)).getDisplay(0), 2, (Bundle) null);
        }
        this.b = n4Var;
        this.c = n4Var2;
        this.d = i2Var;
    }

    public boolean a(int i2) {
        WvfMetadata a2 = this.d.a();
        ComponentInfoEventConfig a3 = a2 != null ? a2.a() : null;
        return a3 != null && a3.a((long) i2);
    }

    public WebView b() {
        if (this.e.size() < 1) {
            return new WebView(this.a);
        }
        if (this.e.size() == 1) {
            c();
        }
        return this.e.removeFirst();
    }

    public void c() {
        try {
            this.c.a().execute(this.i);
        } catch (Throwable th) {
            if (a(256)) {
                i3.a(th);
            }
        }
    }

    public String a() {
        String d2 = k9.d(this.f);
        if (d2 != null) {
            return d2;
        }
        try {
            return k9.d(System.getProperty("http.agent"));
        } catch (Throwable th) {
            if (a(1)) {
                i3.a(th);
            }
            return null;
        }
    }
}
