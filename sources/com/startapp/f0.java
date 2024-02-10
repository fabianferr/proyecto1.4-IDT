package com.startapp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.remoteconfig.AppSessionConfig;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.components.x;
import com.startapp.sdk.triggeredlinks.AppEventsMetadata;
import com.startapp.sdk.triggeredlinks.TriggeredLinksMetadata;
import java.util.Map;

/* compiled from: Sta */
public class f0 extends x1 {
    public final g0 a;
    public int b;
    public boolean c;
    public boolean d;

    public f0(g0 g0Var) {
        this.a = g0Var;
    }

    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            int i = this.b + 1;
            this.b = i;
            if (i == 1 && !this.c) {
                Map<String, String> map = null;
                if (!this.d) {
                    this.d = true;
                    StartAppSDKInternal startAppSDKInternal = (StartAppSDKInternal) this.a;
                    StartAppSDKInternal.h(startAppSDKInternal.h);
                    z8 z8Var = startAppSDKInternal.C;
                    if (z8Var != null) {
                        TriggeredLinksMetadata a2 = z8Var.a();
                        AppEventsMetadata a3 = a2 != null ? a2.a() : null;
                        Map<String, String> c2 = a3 != null ? a3.c() : null;
                        if (c2 != null) {
                            z8Var.a(a2, c2, "Launch");
                        }
                    }
                }
                StartAppSDKInternal startAppSDKInternal2 = (StartAppSDKInternal) this.a;
                Application application = startAppSDKInternal2.h;
                if (application != null) {
                    k8 w = ComponentLocator.a((Context) application).w();
                    w.b.execute(new i8(w));
                    e0 d2 = ComponentLocator.a((Context) startAppSDKInternal2.h).d();
                    ((x) d2.a).getClass();
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    long j = d2.e;
                    AppSessionConfig a4 = d2.b.a();
                    if (elapsedRealtime > Math.max(0, a4 != null ? a4.a() : 600000) + j || d2.d <= 0) {
                        d2.d = elapsedRealtime;
                        d2.c.clear();
                    }
                }
                StartAppSDKInternal.h(startAppSDKInternal2.h);
                z8 z8Var2 = startAppSDKInternal2.C;
                if (z8Var2 != null) {
                    TriggeredLinksMetadata a5 = z8Var2.a();
                    AppEventsMetadata a6 = a5 != null ? a5.a() : null;
                    if (a6 != null) {
                        map = a6.a();
                    }
                    if (map != null) {
                        z8Var2.a(a5, map, "Active");
                    }
                }
            }
        }
    }

    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            this.b--;
            boolean isChangingConfigurations = activity.isChangingConfigurations();
            this.c = isChangingConfigurations;
            if (this.b == 0 && !isChangingConfigurations) {
                StartAppSDKInternal startAppSDKInternal = (StartAppSDKInternal) this.a;
                Application application = startAppSDKInternal.h;
                if (application != null) {
                    k8 w = ComponentLocator.a((Context) application).w();
                    w.b.execute(new j8(w));
                    e0 d2 = ComponentLocator.a((Context) startAppSDKInternal.h).d();
                    ((x) d2.a).getClass();
                    d2.e = SystemClock.elapsedRealtime();
                }
                StartAppSDKInternal.h(startAppSDKInternal.h);
                z8 z8Var = startAppSDKInternal.C;
                if (z8Var != null) {
                    TriggeredLinksMetadata a2 = z8Var.a();
                    Map<String, String> map = null;
                    AppEventsMetadata a3 = a2 != null ? a2.a() : null;
                    if (a3 != null) {
                        map = a3.b();
                    }
                    if (map != null) {
                        z8Var.a(a2, map, "Inactive");
                    }
                }
                Application application2 = startAppSDKInternal.h;
                if (application2 != null) {
                    try {
                        ComponentLocator.a((Context) application2).q().c();
                    } catch (Throwable th) {
                        i3.a(th);
                    }
                }
            }
        }
    }
}
