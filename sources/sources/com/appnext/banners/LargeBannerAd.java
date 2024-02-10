package com.appnext.banners;

import android.content.Context;
import com.appnext.core.Ad;
import com.appnext.core.callbacks.OnECPMLoaded;

public class LargeBannerAd extends BannerAd {
    public String getAUID() {
        return "1010";
    }

    public /* bridge */ /* synthetic */ void getECPM(OnECPMLoaded onECPMLoaded) {
        super.getECPM(onECPMLoaded);
    }

    public /* bridge */ /* synthetic */ String getTID() {
        return super.getTID();
    }

    public /* bridge */ /* synthetic */ String getVID() {
        return super.getVID();
    }

    public /* bridge */ /* synthetic */ boolean isAdLoaded() {
        return super.isAdLoaded();
    }

    public /* bridge */ /* synthetic */ void loadAd() {
        super.loadAd();
    }

    public /* bridge */ /* synthetic */ void showAd() {
        super.showAd();
    }

    public LargeBannerAd(Context context, String str) {
        super(context, str);
    }

    protected LargeBannerAd(Ad ad) {
        super(ad);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r9.equals("a") != false) goto L_0x0050;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0087, code lost:
        if (r9.equals("a") != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x008d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0090 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getTemId(com.appnext.banners.BannerAdData r9) {
        /*
            r8 = this;
            java.lang.String r0 = "110"
            java.lang.String r9 = r9.getRevenueType()     // Catch:{ all -> 0x0093 }
            java.lang.String r1 = "cpi"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x0093 }
            r1 = 0
            java.lang.String r2 = "b"
            java.lang.String r3 = "a"
            r4 = -1
            r5 = 1
            if (r9 == 0) goto L_0x0060
            com.appnext.banners.d r9 = com.appnext.banners.d.K()     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "LARGE_BANNER_cpiActiveFlow"
            java.lang.String r9 = r9.t(r6)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ all -> 0x0093 }
            int r6 = r9.hashCode()     // Catch:{ all -> 0x0093 }
            r7 = 2
            switch(r6) {
                case 97: goto L_0x0048;
                case 98: goto L_0x0040;
                case 99: goto L_0x0036;
                case 100: goto L_0x002c;
                default: goto L_0x002b;
            }     // Catch:{ all -> 0x0093 }
        L_0x002b:
            goto L_0x004f
        L_0x002c:
            java.lang.String r1 = "d"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x004f
            r1 = 3
            goto L_0x0050
        L_0x0036:
            java.lang.String r1 = "c"
            boolean r9 = r9.equals(r1)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x004f
            r1 = 2
            goto L_0x0050
        L_0x0040:
            boolean r9 = r9.equals(r2)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x004f
            r1 = 1
            goto L_0x0050
        L_0x0048:
            boolean r9 = r9.equals(r3)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x004f
            goto L_0x0050
        L_0x004f:
            r1 = -1
        L_0x0050:
            if (r1 == 0) goto L_0x005d
            if (r1 == r5) goto L_0x005a
            if (r1 == r7) goto L_0x0057
            return r0
        L_0x0057:
            java.lang.String r9 = "107"
            return r9
        L_0x005a:
            java.lang.String r9 = "104"
            return r9
        L_0x005d:
            java.lang.String r9 = "101"
            return r9
        L_0x0060:
            com.appnext.banners.d r9 = com.appnext.banners.d.K()     // Catch:{ all -> 0x0093 }
            java.lang.String r6 = "LARGE_BANNER_cpcActiveFlow"
            java.lang.String r9 = r9.t(r6)     // Catch:{ all -> 0x0093 }
            java.lang.String r9 = r9.toLowerCase()     // Catch:{ all -> 0x0093 }
            int r6 = r9.hashCode()     // Catch:{ all -> 0x0093 }
            r7 = 97
            if (r6 == r7) goto L_0x0083
            r1 = 98
            if (r6 == r1) goto L_0x007b
            goto L_0x008a
        L_0x007b:
            boolean r9 = r9.equals(r2)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x008a
            r1 = 1
            goto L_0x008b
        L_0x0083:
            boolean r9 = r9.equals(r3)     // Catch:{ all -> 0x0093 }
            if (r9 == 0) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r1 = -1
        L_0x008b:
            if (r1 == 0) goto L_0x0090
            java.lang.String r9 = "204"
            return r9
        L_0x0090:
            java.lang.String r9 = "201"
            return r9
        L_0x0093:
            r9 = move-exception
            java.lang.String r1 = "LargeBannerAd$getTemId"
            com.appnext.base.a.a(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.banners.LargeBannerAd.getTemId(com.appnext.banners.BannerAdData):java.lang.String");
    }
}
