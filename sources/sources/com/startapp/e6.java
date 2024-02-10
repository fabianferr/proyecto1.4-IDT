package com.startapp;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.view.WindowManager;

/* compiled from: Sta */
public final class e6 {
    public static eb a = new eb();

    public static void a(Context context) {
        eb ebVar = a;
        Context applicationContext = context.getApplicationContext();
        gc.a((Object) applicationContext, "Application Context cannot be null");
        if (!ebVar.a) {
            ebVar.a = true;
            lc a2 = lc.a();
            a2.c.getClass();
            mb mbVar = new mb();
            ic icVar = a2.b;
            Handler handler = new Handler();
            icVar.getClass();
            a2.d = new dc(handler, applicationContext, mbVar, a2);
            ob obVar = ob.d;
            if (applicationContext instanceof Application) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(obVar);
            }
            WindowManager windowManager = rb.a;
            rb.c = applicationContext.getResources().getDisplayMetrics().density;
            rb.a = (WindowManager) applicationContext.getSystemService("window");
            ac.b.a = applicationContext.getApplicationContext();
        }
    }
}
