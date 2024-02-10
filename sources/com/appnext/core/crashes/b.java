package com.appnext.core.crashes;

import android.content.Context;
import com.appnext.core.n;

public class b {
    private static b dU;
    /* access modifiers changed from: private */
    public Context aM;

    private b(Context context) {
        this.aM = context;
    }

    public static b m(Context context) {
        if (dU == null) {
            synchronized (b.class) {
                if (dU == null) {
                    dU = new b(context);
                }
            }
        }
        return dU;
    }

    public final void l(final String str, final String str2) {
        Context context = this.aM;
        if (context == null) {
            try {
                n.aa().a(new Runnable() {
                    public final void run() {
                        try {
                            new a(b.this.aM, str, str2).af();
                        } catch (Throwable th) {
                            Class<b> cls = b.class;
                            th.getMessage();
                        }
                    }
                });
            } catch (Throwable unused) {
            }
        } else {
            CrashesReportWorkManagerService.a(context, str, str2);
        }
    }
}
