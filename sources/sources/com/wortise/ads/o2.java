package com.wortise.ads;

import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/o2;", "", "Landroid/content/Context;", "context", "Lcom/wortise/ads/device/Dimensions;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceScreen.kt */
public final class o2 {
    public static final o2 a = new o2();

    private o2() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0015  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.wortise.ads.device.Dimensions a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0011 }
            r2 = 30
            if (r1 <= r2) goto L_0x0012
            android.view.Display r1 = r4.getDisplay()     // Catch:{ all -> 0x0011 }
            goto L_0x0013
        L_0x0011:
        L_0x0012:
            r1 = r0
        L_0x0013:
            if (r1 != 0) goto L_0x002d
            java.lang.String r1 = "window"
            java.lang.Object r4 = r4.getSystemService(r1)     // Catch:{ all -> 0x002b }
            boolean r1 = r4 instanceof android.view.WindowManager     // Catch:{ all -> 0x002b }
            if (r1 != 0) goto L_0x0021
            r4 = r0
        L_0x0021:
            android.view.WindowManager r4 = (android.view.WindowManager) r4     // Catch:{ all -> 0x002b }
            if (r4 != 0) goto L_0x0026
            goto L_0x002c
        L_0x0026:
            android.view.Display r1 = r4.getDefaultDisplay()     // Catch:{ all -> 0x002b }
            goto L_0x002d
        L_0x002b:
        L_0x002c:
            r1 = r0
        L_0x002d:
            if (r1 != 0) goto L_0x0030
            goto L_0x0041
        L_0x0030:
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            r1.getRealMetrics(r4)
            com.wortise.ads.device.Dimensions r0 = new com.wortise.ads.device.Dimensions
            int r1 = r4.widthPixels
            int r4 = r4.heightPixels
            r0.<init>(r1, r4)
        L_0x0041:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.o2.a(android.content.Context):com.wortise.ads.device.Dimensions");
    }
}
