package com.startapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import com.iab.omid.library.startio.publisher.AdSessionStatePublisher;
import java.util.Collections;

/* compiled from: Sta */
public class ob implements Application.ActivityLifecycleCallbacks {
    public static ob d = new ob();
    public boolean a;
    public boolean b;
    public a c;

    /* compiled from: Sta */
    public interface a {
    }

    public final void a(boolean z) {
        if (this.b != z) {
            this.b = z;
            if (this.a) {
                a();
                if (this.c == null) {
                    return;
                }
                if (!z) {
                    w8.h.a();
                    return;
                }
                w8.h.getClass();
                Handler handler = w8.j;
                if (handler != null) {
                    handler.removeCallbacks(w8.l);
                    w8.j = null;
                }
            }
        }
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
        a(false);
    }

    public void onActivityStopped(Activity activity) {
        View b2;
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(runningAppProcessInfo);
        boolean z = true;
        boolean z2 = runningAppProcessInfo.importance != 100;
        boolean z3 = true;
        for (T t : Collections.unmodifiableCollection(db.c.b)) {
            if (t.c() && (b2 = t.b()) != null && b2.hasWindowFocus()) {
                z3 = false;
            }
        }
        if (!z2 || !z3) {
            z = false;
        }
        a(z);
    }

    public final void a() {
        boolean z = !this.b;
        for (T t : Collections.unmodifiableCollection(db.c.a)) {
            AdSessionStatePublisher adSessionStatePublisher = t.e;
            if (adSessionStatePublisher.a.get() != null) {
                fc.a.a(adSessionStatePublisher.c(), "setState", z ? "foregrounded" : "backgrounded");
            }
        }
    }
}
