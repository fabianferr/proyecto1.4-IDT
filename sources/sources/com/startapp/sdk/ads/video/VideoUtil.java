package com.startapp.sdk.ads.video;

import android.content.Context;
import com.startapp.fa;
import com.startapp.h2;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.t8;
import com.startapp.z5;

/* compiled from: Sta */
public class VideoUtil {

    /* compiled from: Sta */
    public enum VideoEligibility {
        ELIGIBLE(""),
        INELIGIBLE_NO_STORAGE("Not enough storage for video"),
        INELIGIBLE_MISSING_ACTIVITY("OverlayActivity not declared in AndroidManifest.xml"),
        INELIGIBLE_ERRORS_THRESHOLD_REACHED("Video errors threshold reached.");
        
        private String desctiption;

        /* access modifiers changed from: public */
        VideoEligibility(String str) {
            this.desctiption = str;
        }

        public String a() {
            return this.desctiption;
        }
    }

    public static void a(Context context, fa faVar) {
        if (context != null && faVar != null) {
            for (String next : faVar.a) {
                if (next != null && next.length() > 0) {
                    t8.a(context, next, (h2<String, z5.a, Throwable, Void>) null);
                }
            }
        }
    }

    public static void b(Context context) {
        e e = ComponentLocator.a(context).e();
        int i = e.getInt("videoErrorsCount", 0);
        e.a a = e.edit();
        int i2 = i + 1;
        a.a("videoErrorsCount", Integer.valueOf(i2));
        a.a.putInt("videoErrorsCount", i2);
        a.apply();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:36:0x0075 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Context r9, java.net.URL r10, java.lang.String r11) {
        /*
            java.lang.String r0 = ".temp"
            r1 = 0
            java.lang.String r2 = a((android.content.Context) r9, (java.lang.String) r11)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            java.io.File r3 = new java.io.File     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            boolean r4 = r3.exists()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            if (r4 != 0) goto L_0x006c
            java.io.InputStream r10 = r10.openStream()     // Catch:{ Exception -> 0x0072, all -> 0x006e }
            java.io.DataInputStream r4 = new java.io.DataInputStream     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
            r4.<init>(r10)     // Catch:{ Exception -> 0x0073, all -> 0x0068 }
            r5 = 4096(0x1000, float:5.74E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r6.<init>()     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r6.append(r11)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r6.append(r0)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
            r7 = 0
            java.io.FileOutputStream r6 = r9.openFileOutput(r6, r7)     // Catch:{ Exception -> 0x0066, all -> 0x0064 }
        L_0x0033:
            int r8 = r4.read(r5)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            if (r8 <= 0) goto L_0x003d
            r6.write(r5, r7, r8)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            goto L_0x0033
        L_0x003d:
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r7.<init>()     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r7.append(r11)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r7.append(r0)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            java.lang.String r7 = a((android.content.Context) r9, (java.lang.String) r7)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r5.<init>(r7)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r5.renameTo(r3)     // Catch:{ Exception -> 0x0075, all -> 0x0062 }
            r10.close()     // Catch:{ Exception -> 0x0060 }
            r4.close()     // Catch:{ Exception -> 0x0060 }
            r1 = r2
            goto L_0x0096
        L_0x0060:
            r1 = r2
            goto L_0x0099
        L_0x0062:
            r9 = move-exception
            goto L_0x009d
        L_0x0064:
            r9 = move-exception
            goto L_0x009e
        L_0x0066:
            r6 = r1
            goto L_0x0075
        L_0x0068:
            r9 = move-exception
            r4 = r1
            r6 = r4
            goto L_0x009b
        L_0x006c:
            throw r1     // Catch:{ Exception -> 0x006d }
        L_0x006d:
            return r2
        L_0x006e:
            r9 = move-exception
            r4 = r1
            r6 = r4
            goto L_0x009c
        L_0x0072:
            r10 = r1
        L_0x0073:
            r4 = r1
            r6 = r4
        L_0x0075:
            java.io.File r2 = new java.io.File     // Catch:{ all -> 0x009a }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x009a }
            r3.<init>()     // Catch:{ all -> 0x009a }
            r3.append(r11)     // Catch:{ all -> 0x009a }
            r3.append(r0)     // Catch:{ all -> 0x009a }
            java.lang.String r11 = r3.toString()     // Catch:{ all -> 0x009a }
            java.lang.String r9 = a((android.content.Context) r9, (java.lang.String) r11)     // Catch:{ all -> 0x009a }
            r2.<init>(r9)     // Catch:{ all -> 0x009a }
            r2.delete()     // Catch:{ all -> 0x009a }
            r10.close()     // Catch:{ Exception -> 0x0099 }
            r4.close()     // Catch:{ Exception -> 0x0099 }
        L_0x0096:
            r6.close()     // Catch:{ Exception -> 0x0099 }
        L_0x0099:
            return r1
        L_0x009a:
            r9 = move-exception
        L_0x009b:
            r1 = r10
        L_0x009c:
            r10 = r1
        L_0x009d:
            r1 = r6
        L_0x009e:
            r10.close()     // Catch:{ Exception -> 0x00a7 }
            r4.close()     // Catch:{ Exception -> 0x00a7 }
            r1.close()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            goto L_0x00a9
        L_0x00a8:
            throw r9
        L_0x00a9:
            goto L_0x00a8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.VideoUtil.a(android.content.Context, java.net.URL, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.startapp.sdk.ads.video.VideoUtil.VideoEligibility a(android.content.Context r10) {
        /*
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.ELIGIBLE
            com.startapp.sdk.adsbase.AdsCommonMetaData r1 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r1 = r1.G()
            int r1 = r1.o()
            r2 = 1
            r3 = 0
            if (r1 >= 0) goto L_0x0011
            goto L_0x002e
        L_0x0011:
            com.startapp.sdk.components.ComponentLocator r1 = com.startapp.sdk.components.ComponentLocator.a((android.content.Context) r10)
            com.startapp.sdk.adsbase.e r1 = r1.e()
            java.lang.String r4 = "videoErrorsCount"
            int r1 = r1.getInt(r4, r3)
            com.startapp.sdk.adsbase.AdsCommonMetaData r4 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r4 = r4.G()
            int r4 = r4.o()
            if (r1 < r4) goto L_0x002e
            r1 = 1
            goto L_0x002f
        L_0x002e:
            r1 = 0
        L_0x002f:
            if (r1 == 0) goto L_0x0033
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_ERRORS_THRESHOLD_REACHED
        L_0x0033:
            java.lang.Class<com.startapp.sdk.ads.interstitials.OverlayActivity> r1 = com.startapp.sdk.ads.interstitials.OverlayActivity.class
            boolean r1 = com.startapp.k9.a((android.content.Context) r10, (java.lang.Class<? extends android.app.Activity>) r1)
            if (r1 != 0) goto L_0x003d
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_MISSING_ACTIVITY
        L_0x003d:
            java.io.File r10 = r10.getFilesDir()
            java.util.Map<android.app.Activity, java.lang.Integer> r1 = com.startapp.k9.a
            int r1 = com.startapp.a0.a
            if (r10 == 0) goto L_0x0053
            boolean r1 = r10.isDirectory()     // Catch:{ all -> 0x0053 }
            if (r1 != 0) goto L_0x004e
            goto L_0x0053
        L_0x004e:
            long r4 = r10.getFreeSpace()     // Catch:{ all -> 0x0053 }
            goto L_0x0055
        L_0x0053:
            r4 = -1
        L_0x0055:
            r6 = 0
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 >= 0) goto L_0x005c
            goto L_0x0070
        L_0x005c:
            com.startapp.sdk.adsbase.AdsCommonMetaData r10 = com.startapp.sdk.adsbase.AdsCommonMetaData.h
            com.startapp.sdk.adsbase.VideoConfig r10 = r10.G()
            long r6 = r10.f()
            r8 = 1024(0x400, double:5.06E-321)
            long r4 = r4 / r8
            long r6 = r6 * r8
            int r10 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r10 <= 0) goto L_0x0070
            goto L_0x0071
        L_0x0070:
            r2 = 0
        L_0x0071:
            if (r2 != 0) goto L_0x0075
            com.startapp.sdk.ads.video.VideoUtil$VideoEligibility r0 = com.startapp.sdk.ads.video.VideoUtil.VideoEligibility.INELIGIBLE_NO_STORAGE
        L_0x0075:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.sdk.ads.video.VideoUtil.a(android.content.Context):com.startapp.sdk.ads.video.VideoUtil$VideoEligibility");
    }

    public static String a(Context context, String str) {
        return context.getFilesDir() + "/" + str;
    }
}
