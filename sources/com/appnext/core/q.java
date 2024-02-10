package com.appnext.core;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.appnext.base.b.b;
import java.util.concurrent.TimeUnit;

public class q {
    /* access modifiers changed from: private */
    public static final long dH = TimeUnit.DAYS.toMillis(30);
    private static q dI;
    /* access modifiers changed from: private */
    public String dJ = "";

    private q() {
    }

    public static q ad() {
        if (dI == null) {
            synchronized (q.class) {
                if (dI == null) {
                    dI = new q();
                }
            }
        }
        return dI;
    }

    public final String j(final Context context) {
        try {
            if (!TextUtils.isEmpty(this.dJ)) {
                return this.dJ;
            }
            this.dJ = b.N().c("userAgent", "");
            n.aa().a(new Runnable() {
                public final void run() {
                    try {
                        long a = b.N().a("userAgentStoreDate", 0);
                        if (TextUtils.isEmpty(q.this.dJ) || System.currentTimeMillis() - q.dH < a) {
                            q.k(context);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
            return this.dJ;
        } catch (Throwable unused) {
            return this.dJ;
        }
    }

    /* access modifiers changed from: private */
    public static void k(Context context) {
        if (context != null) {
            try {
                b.N().d("userAgent", WebSettings.getDefaultUserAgent(context.getApplicationContext()));
                b.N().b("userAgentStoreDate", System.currentTimeMillis());
            } catch (Throwable unused) {
            }
        }
    }
}
