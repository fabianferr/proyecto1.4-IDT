package com.applovin.impl.sdk.b;

import android.view.View;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.security.CertificateUtil;
import com.iab.omid.library.applovin.adsession.AdEvents;
import com.iab.omid.library.applovin.adsession.AdSession;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.ErrorType;
import java.util.Collections;
import java.util.List;

public abstract class b {
    protected final AppLovinAdBase a;
    protected final m b;
    protected final u c;
    protected final String d;
    protected boolean e;
    protected AdSession f;
    protected AdEvents g;

    public b(AppLovinAdBase appLovinAdBase) {
        this.a = appLovinAdBase;
        this.b = appLovinAdBase.getSdk();
        this.c = appLovinAdBase.getSdk().A();
        String str = "AdEventTracker:" + appLovinAdBase.getAdIdNumber();
        if (StringUtils.isValidString(appLovinAdBase.getDspName())) {
            str = str + CertificateUtil.DELIMITER + appLovinAdBase.getDspName();
        }
        this.d = str;
    }

    /* access modifiers changed from: protected */
    public abstract AdSessionConfiguration a();

    /* access modifiers changed from: protected */
    public abstract AdSessionContext a(WebView webView);

    public void a(View view) {
        a(view, (List<d>) Collections.emptyList());
    }

    public void a(final View view, final List<d> list) {
        a("update main view: " + view, (Runnable) new Runnable() {
            public void run() {
                b.this.f.registerAdView(view);
                b.this.f.removeAllFriendlyObstructions();
                for (d dVar : list) {
                    if (dVar.a() != null) {
                        try {
                            b.this.f.addFriendlyObstruction(dVar.a(), dVar.b(), dVar.c());
                        } catch (Throwable th) {
                            if (u.a()) {
                                u uVar = b.this.c;
                                String str = b.this.d;
                                uVar.b(str, "Failed to add friendly obstruction (" + dVar + ")", th);
                            }
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(AdSession adSession) {
    }

    public void a(final String str) {
        a("track error", (Runnable) new Runnable() {
            public void run() {
                b.this.f.error(ErrorType.VIDEO, str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void a(final String str, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    if (b.this.e) {
                        if (u.a()) {
                            u uVar = b.this.c;
                            String str = b.this.d;
                            uVar.b(str, "Running operation: " + str);
                        }
                        runnable.run();
                    } else if (u.a()) {
                        u uVar2 = b.this.c;
                        String str2 = b.this.d;
                        uVar2.e(str2, "Failed to run operation: " + str);
                    }
                } catch (Throwable th) {
                    if (u.a()) {
                        u uVar3 = b.this.c;
                        String str3 = b.this.d;
                        uVar3.b(str3, "Failed to run operation: " + str, th);
                    }
                }
            }
        });
    }

    public void b() {
        b((WebView) null);
    }

    public void b(final WebView webView) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() {
            public void run() {
                AdSessionContext a2;
                if (!b.this.a.isOpenMeasurementEnabled()) {
                    if (u.a()) {
                        b.this.c.c(b.this.d, "Skip starting session - Open Measurement disabled");
                    }
                } else if (b.this.f == null) {
                    if (u.a()) {
                        b.this.c.b(b.this.d, "Starting session");
                    }
                    AdSessionConfiguration a3 = b.this.a();
                    if (a3 != null && (a2 = b.this.a(webView)) != null) {
                        try {
                            b.this.f = AdSession.createAdSession(a3, a2);
                            try {
                                b bVar = b.this;
                                bVar.g = AdEvents.createAdEvents(bVar.f);
                                b bVar2 = b.this;
                                bVar2.a(bVar2.f);
                                b.this.f.start();
                                b.this.e = true;
                                if (u.a()) {
                                    b.this.c.b(b.this.d, "Session started");
                                }
                            } catch (Throwable th) {
                                if (u.a()) {
                                    b.this.c.b(b.this.d, "Failed to create ad events", th);
                                }
                            }
                        } catch (Throwable th2) {
                            if (u.a()) {
                                b.this.c.b(b.this.d, "Failed to create session", th2);
                            }
                        }
                    }
                } else if (u.a()) {
                    u uVar = b.this.c;
                    String str = b.this.d;
                    uVar.d(str, "Attempting to start session again for ad: " + b.this.a);
                }
            }
        });
    }

    public void c() {
        a("track loaded", (Runnable) new Runnable() {
            public void run() {
                b.this.g.loaded();
            }
        });
    }

    public void d() {
        a("track impression event", (Runnable) new Runnable() {
            public void run() {
                b.this.g.impressionOccurred();
            }
        });
    }

    public void e() {
        a("stop session", (Runnable) new Runnable() {
            public void run() {
                b.this.e = false;
                b.this.f.finish();
                b.this.f = null;
            }
        });
    }
}
