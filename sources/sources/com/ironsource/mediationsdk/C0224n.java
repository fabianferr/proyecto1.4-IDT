package com.ironsource.mediationsdk;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.ironsource.environment.thread.IronSourceThreadManager;

/* renamed from: com.ironsource.mediationsdk.n  reason: case insensitive filesystem */
public class C0224n {
    private long a;
    private long b;
    private long c;

    /* renamed from: com.ironsource.mediationsdk.n$a */
    interface a {
        void a();

        void a(String str);
    }

    public static ISBannerSize a() {
        return new ISBannerSize("LEADERBOARD", 728, 90);
    }

    public static ISBannerSize a(String str, int i, int i2) {
        return new ISBannerSize(str, i, i2);
    }

    public static void a(final IronSourceBannerLayout ironSourceBannerLayout, final View view, final FrameLayout.LayoutParams layoutParams) {
        if (ironSourceBannerLayout != null && view != null && layoutParams != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new Runnable() {
                public final void run() {
                    IronSourceBannerLayout.this.removeAllViews();
                    ViewParent parent = view.getParent();
                    if (parent instanceof ViewGroup) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    IronSourceBannerLayout.this.addView(view, 0, layoutParams);
                }
            });
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d A[Catch:{ Exception -> 0x00be }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(java.util.Map<java.lang.String, java.lang.Object> r7, com.ironsource.mediationsdk.ISBannerSize r8) {
        /*
            java.lang.String r0 = "ext1"
            if (r8 == 0) goto L_0x00c8
            java.lang.String r1 = r8.getDescription()     // Catch:{ Exception -> 0x00be }
            int r2 = r1.hashCode()     // Catch:{ Exception -> 0x00be }
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r2) {
                case -387072689: goto L_0x003c;
                case 72205083: goto L_0x0032;
                case 79011241: goto L_0x0028;
                case 1951953708: goto L_0x001e;
                case 1999208305: goto L_0x0014;
                default: goto L_0x0013;
            }     // Catch:{ Exception -> 0x00be }
        L_0x0013:
            goto L_0x0046
        L_0x0014:
            java.lang.String r2 = "CUSTOM"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0046
            r1 = 4
            goto L_0x0047
        L_0x001e:
            java.lang.String r2 = "BANNER"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0046
            r1 = 0
            goto L_0x0047
        L_0x0028:
            java.lang.String r2 = "SMART"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0046
            r1 = 3
            goto L_0x0047
        L_0x0032:
            java.lang.String r2 = "LARGE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0046
            r1 = 1
            goto L_0x0047
        L_0x003c:
            java.lang.String r2 = "RECTANGLE"
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x0046
            r1 = 2
            goto L_0x0047
        L_0x0046:
            r1 = -1
        L_0x0047:
            java.lang.String r2 = "bannerAdSize"
            if (r1 == 0) goto L_0x0092
            if (r1 == r6) goto L_0x008d
            if (r1 == r5) goto L_0x0088
            if (r1 == r4) goto L_0x007f
            if (r1 == r3) goto L_0x0054
            goto L_0x0097
        L_0x0054:
            r1 = 6
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00be }
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = "custom_banner_size"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r2.<init>()     // Catch:{ Exception -> 0x00be }
            int r3 = r8.getWidth()     // Catch:{ Exception -> 0x00be }
            r2.append(r3)     // Catch:{ Exception -> 0x00be }
            java.lang.String r3 = "x"
            r2.append(r3)     // Catch:{ Exception -> 0x00be }
            int r3 = r8.getHeight()     // Catch:{ Exception -> 0x00be }
            r2.append(r3)     // Catch:{ Exception -> 0x00be }
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x00be }
            r7.put(r1, r2)     // Catch:{ Exception -> 0x00be }
            goto L_0x0097
        L_0x007f:
            r1 = 5
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x00be }
        L_0x0084:
            r7.put(r2, r1)     // Catch:{ Exception -> 0x00be }
            goto L_0x0097
        L_0x0088:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r4)     // Catch:{ Exception -> 0x00be }
            goto L_0x0084
        L_0x008d:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00be }
            goto L_0x0084
        L_0x0092:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00be }
            goto L_0x0084
        L_0x0097:
            boolean r8 = r8.isAdaptive()     // Catch:{ Exception -> 0x00be }
            if (r8 == 0) goto L_0x00bd
            java.lang.String r8 = "Adaptive=true"
            boolean r1 = r7.containsKey(r0)     // Catch:{ Exception -> 0x00be }
            if (r1 == 0) goto L_0x00ba
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00be }
            r8.<init>()     // Catch:{ Exception -> 0x00be }
            java.lang.Object r1 = r7.get(r0)     // Catch:{ Exception -> 0x00be }
            r8.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r1 = " , Adaptive=true"
            r8.append(r1)     // Catch:{ Exception -> 0x00be }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00be }
        L_0x00ba:
            r7.put(r0, r8)     // Catch:{ Exception -> 0x00be }
        L_0x00bd:
            return
        L_0x00be:
            r7 = move-exception
            com.ironsource.mediationsdk.logger.IronLog r8 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.String r7 = android.util.Log.getStackTraceString(r7)
            r8.error(r7)
        L_0x00c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.C0224n.a(java.util.Map, com.ironsource.mediationsdk.ISBannerSize):void");
    }

    static boolean a(IronSourceBannerLayout ironSourceBannerLayout) {
        return ironSourceBannerLayout != null && !ironSourceBannerLayout.isDestroyed();
    }

    public static void b(IronSourceBannerLayout ironSourceBannerLayout) {
        if (ironSourceBannerLayout != null) {
            ironSourceBannerLayout.a();
        }
    }

    public void a(long j) {
        this.a = System.currentTimeMillis() + j;
    }

    public long b() {
        return Math.max(0, this.a - System.currentTimeMillis());
    }

    public void b(long j) {
        this.b = j;
        this.c = 0;
    }

    public void c() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void c(long j) {
        this.c = j;
        this.a += j - this.b;
    }
}
