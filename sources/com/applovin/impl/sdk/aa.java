package com.applovin.impl.sdk;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.d.d;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.f.a;
import com.applovin.impl.sdk.f.o;
import com.applovin.impl.sdk.f.z;
import com.applovin.impl.sdk.utils.g;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.concurrent.atomic.AtomicBoolean;

public class aa {
    /* access modifiers changed from: private */
    public static WebView a;
    /* access modifiers changed from: private */
    public static String b;
    /* access modifiers changed from: private */
    public static final Object c = new Object();
    private static final AtomicBoolean d = new AtomicBoolean();

    static {
        if (b()) {
            b = (String) e.b(d.D, "", m.M());
            return;
        }
        b = "";
        e.a(d.D, null, m.M());
        e.a(d.E, null, m.M());
    }

    public static String a() {
        String str;
        synchronized (c) {
            str = b;
        }
        return str;
    }

    public static void a(m mVar) {
    }

    public static void b(final m mVar) {
        if (!b() && !d.getAndSet(true)) {
            if (g.b()) {
                mVar.S().a((a) new z(mVar, true, new Runnable() {
                    public void run() {
                        try {
                            synchronized (aa.c) {
                                String unused = aa.b = WebSettings.getDefaultUserAgent(m.M());
                                e.a(d.D, aa.b, m.M());
                                e.a(d.E, Build.VERSION.RELEASE, m.M());
                            }
                        } catch (Throwable th) {
                            if (u.a()) {
                                m.this.A().b("WebViewDataCollector", "Failed to collect user agent", th);
                            }
                        }
                    }
                }), o.a.BACKGROUND);
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            aa.a(m.this);
                            synchronized (aa.c) {
                                String unused = aa.b = aa.a.getSettings().getUserAgentString();
                                e.a(d.D, aa.b, m.M());
                                e.a(d.E, Build.VERSION.RELEASE, m.M());
                            }
                        } catch (Throwable th) {
                            if (u.a()) {
                                m.this.A().b("WebViewDataCollector", "Failed to collect user agent", th);
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean b() {
        boolean equals;
        synchronized (c) {
            equals = Build.VERSION.RELEASE.equals((String) e.b(d.E, "", m.M()));
        }
        return equals;
    }
}
