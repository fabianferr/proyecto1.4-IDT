package com.applovin.impl.adview.activity;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.utils.Utils;
import com.applovin.sdk.AppLovinSdkUtils;

public class b {
    private final Activity a;
    private final int b;
    private final int c;
    private final boolean d;
    private final boolean e;

    public b(Activity activity) {
        this.a = activity;
        int rotation = Utils.getRotation(activity);
        this.c = rotation;
        boolean isTablet = AppLovinSdkUtils.isTablet(activity);
        this.d = isTablet;
        this.b = a(rotation, isTablet);
        this.e = isTablet && 2 == a((Context) activity);
    }

    private int a(int i, boolean z) {
        if (!z || !this.e) {
            if (i == 0) {
                return 1;
            }
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 9;
            }
            return i == 3 ? 8 : -1;
        } else if (i == 0) {
            return 0;
        } else {
            if (i == 1) {
                return 9;
            }
            if (i == 2) {
                return 8;
            }
            return i == 3 ? 1 : -1;
        }
    }

    private static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private void a(int i) {
        try {
            this.a.setRequestedOrientation(i);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0044, code lost:
        if (r6 == 2) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0053, code lost:
        if (r6 == 1) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r6 != 3) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        if (r6 != 1) goto L_0x0024;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.applovin.impl.sdk.ad.e.b r6) {
        /*
            r5 = this;
            com.applovin.impl.sdk.ad.e$b r0 = com.applovin.impl.sdk.ad.e.b.ACTIVITY_PORTRAIT
            r1 = 3
            r2 = 2
            r3 = 1
            if (r6 != r0) goto L_0x002e
            boolean r6 = r5.d
            r0 = 9
            if (r6 == 0) goto L_0x001e
            boolean r6 = r5.e
            if (r6 == 0) goto L_0x001e
            int r6 = r5.c
            if (r6 == r3) goto L_0x0018
            if (r6 == r1) goto L_0x0018
            goto L_0x0024
        L_0x0018:
            if (r6 != r3) goto L_0x0024
        L_0x001a:
            r5.a((int) r0)
            goto L_0x0056
        L_0x001e:
            int r6 = r5.c
            if (r6 == 0) goto L_0x0028
            if (r6 == r2) goto L_0x0028
        L_0x0024:
            r5.a((int) r3)
            goto L_0x0056
        L_0x0028:
            if (r6 != 0) goto L_0x002b
            goto L_0x0024
        L_0x002b:
            r3 = 9
            goto L_0x0024
        L_0x002e:
            com.applovin.impl.sdk.ad.e$b r0 = com.applovin.impl.sdk.ad.e.b.ACTIVITY_LANDSCAPE
            if (r6 != r0) goto L_0x0056
            boolean r6 = r5.d
            r0 = 8
            r4 = 0
            if (r6 == 0) goto L_0x0049
            boolean r6 = r5.e
            if (r6 == 0) goto L_0x0049
            int r6 = r5.c
            if (r6 == 0) goto L_0x0044
            if (r6 == r2) goto L_0x0044
            goto L_0x004f
        L_0x0044:
            if (r6 != r2) goto L_0x0047
            goto L_0x001a
        L_0x0047:
            r0 = 0
            goto L_0x001a
        L_0x0049:
            int r6 = r5.c
            if (r6 == r3) goto L_0x0053
            if (r6 == r1) goto L_0x0053
        L_0x004f:
            r5.a((int) r4)
            goto L_0x0056
        L_0x0053:
            if (r6 != r3) goto L_0x001a
            goto L_0x0047
        L_0x0056:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.adview.activity.b.a(com.applovin.impl.sdk.ad.e$b):void");
    }

    public void a(e eVar) {
        int i;
        if (!eVar.F() || (i = this.b) == -1) {
            a(eVar.p());
        } else {
            a(i);
        }
    }
}
