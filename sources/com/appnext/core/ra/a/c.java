package com.appnext.core.ra.a;

import android.content.Context;
import android.os.Bundle;
import com.appnext.core.ra.services.a;

public final class c {

    /* renamed from: com.appnext.core.ra.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] eg;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.appnext.core.ra.services.a$a[] r0 = com.appnext.core.ra.services.a.C0026a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                eg = r0
                com.appnext.core.ra.services.a$a r1 = com.appnext.core.ra.services.a.C0026a.SendRA     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = eg     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appnext.core.ra.services.a$a r1 = com.appnext.core.ra.services.a.C0026a.StoreRa     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = eg     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.appnext.core.ra.services.a$a r1 = com.appnext.core.ra.services.a.C0026a.DownloadingConfig     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.ra.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    public static b a(Context context, a.C0026a aVar, Bundle bundle) {
        int i = AnonymousClass1.eg[aVar.ordinal()];
        if (i == 1) {
            return new d(context, bundle);
        }
        if (i == 2) {
            return new e(context, bundle);
        }
        if (i != 3) {
            return null;
        }
        return new a(context, bundle);
    }
}
