package com.appnext.base;

import android.content.Context;
import com.appnext.base.b.a;
import com.appnext.base.b.b;
import com.appnext.core.n;

public class Appnext {
    private static final Appnext bN = new Appnext();
    /* access modifiers changed from: private */
    public Context bM = null;
    private boolean bO = false;

    private Appnext() {
    }

    public static void init(Context context) {
        Appnext appnext = bN;
        if (context != null) {
            try {
                if (!appnext.bO || appnext.bM == null) {
                    appnext.bO = true;
                    a.init(context);
                    appnext.bM = context.getApplicationContext();
                    n.aa().a(new Runnable() {
                        public final void run() {
                            try {
                                b.N().init(Appnext.this.bM);
                                a.init(Appnext.this.bM);
                            } catch (Throwable unused) {
                            }
                        }
                    });
                    return;
                }
                appnext.bM = context.getApplicationContext();
            } catch (Throwable th) {
                a.a("Appnext$libInit", th);
            }
        }
    }
}
