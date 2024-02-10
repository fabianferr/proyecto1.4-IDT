package com.ironsource.environment;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.ConcurrentHashMap;

public class ContextProvider {
    private static volatile ContextProvider d;
    private Activity a;
    private Context b;
    private ConcurrentHashMap<String, a> c = new ConcurrentHashMap<>();

    public interface a {
        void onPause(Activity activity);

        void onResume(Activity activity);
    }

    private ContextProvider() {
    }

    public static ContextProvider getInstance() {
        if (d == null) {
            synchronized (ContextProvider.class) {
                if (d == null) {
                    d = new ContextProvider();
                }
            }
        }
        return d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.Context getApplicationContext() {
        /*
            r2 = this;
            android.content.Context r0 = r2.b
            if (r0 != 0) goto L_0x000c
            android.app.Activity r1 = r2.a
            if (r1 == 0) goto L_0x000c
            android.content.Context r0 = r1.getApplicationContext()
        L_0x000c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.environment.ContextProvider.getApplicationContext():android.content.Context");
    }

    public Activity getCurrentActiveActivity() {
        return this.a;
    }

    public void onPause(Activity activity) {
        if (activity != null) {
            for (a onPause : this.c.values()) {
                onPause.onPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        if (activity != null) {
            this.a = activity;
            for (a onResume : this.c.values()) {
                onResume.onResume(this.a);
            }
        }
    }

    public void registerLifeCycleListener(a aVar) {
        this.c.put(aVar.getClass().getSimpleName(), aVar);
    }

    public void updateActivity(Activity activity) {
        if (activity != null) {
            this.a = activity;
        }
    }

    public void updateAppContext(Context context) {
        if (context != null) {
            this.b = context;
        }
    }
}
