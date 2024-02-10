package com.google.android.gms.internal.atv_ads_framework;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.pm.PackageInfoCompat;

/* compiled from: com.google.android.tv:tv-ads@@1.0.0-alpha02 */
public final class zzd {
    public static final zza zza(Context context) {
        zza zza = zza.UNKNOWN;
        if (context.getPackageManager().hasSystemFeature("com.google.android.tv.custom_launcher")) {
            return zza.CUSTOM;
        }
        if (context.getPackageManager().hasSystemFeature("com.google.android.feature.AMATI_EXPERIENCE")) {
            return zza.LAUNCHER_X;
        }
        return !context.getPackageManager().hasSystemFeature("android.software.leanback") ? zza : zza.TV_LAUNCHER;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a3, code lost:
        if (r1 != 2) goto L_0x00c8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0057 A[EDGE_INSN: B:62:0x0057->B:18:0x0057 ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.google.android.gms.internal.atv_ads_framework.zzae zzb(android.content.Context r13) {
        /*
            com.google.android.gms.internal.atv_ads_framework.zzad r0 = new com.google.android.gms.internal.atv_ads_framework.zzad
            r0.<init>()
            java.lang.String r1 = android.os.Build.FINGERPRINT
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 3
            r4 = 0
            if (r2 != 0) goto L_0x0026
            r2 = 58
            com.google.android.gms.internal.atv_ads_framework.zzr r2 = com.google.android.gms.internal.atv_ads_framework.zzr.zzb(r2)
            java.util.List r1 = r2.zzc(r1)
            int r2 = r1.size()
            if (r2 != r3) goto L_0x0026
            java.lang.Object r1 = r1.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            goto L_0x0028
        L_0x0026:
            java.lang.String r1 = ""
        L_0x0028:
            int r2 = r1.length()
            r5 = 0
        L_0x002d:
            if (r5 >= r2) goto L_0x0057
            char r6 = r1.charAt(r5)
            boolean r6 = com.google.android.gms.internal.atv_ads_framework.zzf.zza(r6)
            if (r6 == 0) goto L_0x0054
            char[] r1 = r1.toCharArray()
        L_0x003d:
            if (r5 >= r2) goto L_0x004f
            char r6 = r1[r5]
            boolean r7 = com.google.android.gms.internal.atv_ads_framework.zzf.zza(r6)
            if (r7 == 0) goto L_0x004c
            r6 = r6 ^ 32
            char r6 = (char) r6
            r1[r5] = r6
        L_0x004c:
            int r5 = r5 + 1
            goto L_0x003d
        L_0x004f:
            java.lang.String r1 = java.lang.String.valueOf(r1)
            goto L_0x0057
        L_0x0054:
            int r5 = r5 + 1
            goto L_0x002d
        L_0x0057:
            boolean r2 = r1.isEmpty()
            if (r2 != 0) goto L_0x0066
            com.google.android.gms.internal.atv_ads_framework.zzb r2 = com.google.android.gms.internal.atv_ads_framework.zzb.BUILD_FINGERPRINT_PREFIX
            java.lang.String r2 = r2.zza()
            r0.zza(r2, r1)
        L_0x0066:
            com.google.android.gms.internal.atv_ads_framework.zza r1 = zza(r13)
            com.google.android.gms.internal.atv_ads_framework.zzb r2 = com.google.android.gms.internal.atv_ads_framework.zzb.LAUNCHER_TYPE
            java.lang.String r2 = r2.zza()
            java.lang.String r5 = r1.zza()
            r0.zza(r2, r5)
            android.content.pm.PackageManager r2 = r13.getPackageManager()
            java.lang.String r5 = "com.google.android.tv.operator_tier"
            boolean r2 = r2.hasSystemFeature(r5)
            if (r2 == 0) goto L_0x008e
            com.google.android.gms.internal.atv_ads_framework.zzb r2 = com.google.android.gms.internal.atv_ads_framework.zzb.OPERATOR_TIER
            java.lang.String r2 = r2.zza()
            java.lang.String r5 = "1"
            r0.zza(r2, r5)
        L_0x008e:
            com.google.android.gms.internal.atv_ads_framework.zzb r2 = com.google.android.gms.internal.atv_ads_framework.zzb.SDK_VERSION
            java.lang.String r2 = r2.zza()
            java.lang.String r5 = "1.0.0-alpha02"
            r0.zza(r2, r5)
            int r1 = r1.ordinal()
            r2 = 2
            r5 = 1
            if (r1 == 0) goto L_0x00b2
            if (r1 == r5) goto L_0x00a6
            if (r1 == r2) goto L_0x00bd
            goto L_0x00c8
        L_0x00a6:
            com.google.android.gms.internal.atv_ads_framework.zzb r1 = com.google.android.gms.internal.atv_ads_framework.zzb.LAUNCHERX_VERSION_CODE
            java.lang.String r1 = r1.zza()
            java.lang.String r6 = "com.google.android.apps.tv.launcherx"
            zzc(r0, r13, r6, r1)
            goto L_0x00c8
        L_0x00b2:
            com.google.android.gms.internal.atv_ads_framework.zzb r1 = com.google.android.gms.internal.atv_ads_framework.zzb.TVLAUNCHER_VERSION_CODE
            java.lang.String r1 = r1.zza()
            java.lang.String r6 = "com.google.android.tvlauncher"
            zzc(r0, r13, r6, r1)
        L_0x00bd:
            com.google.android.gms.internal.atv_ads_framework.zzb r1 = com.google.android.gms.internal.atv_ads_framework.zzb.TVRECOMMENDATIONS_VERSION_CODE
            java.lang.String r1 = r1.zza()
            java.lang.String r6 = "com.google.android.tvrecommendations"
            zzc(r0, r13, r6, r1)
        L_0x00c8:
            com.google.android.gms.internal.atv_ads_framework.zzad r1 = new com.google.android.gms.internal.atv_ads_framework.zzad
            r1.<init>()
            android.net.Uri r6 = android.net.Uri.EMPTY
            com.google.android.gms.internal.atv_ads_framework.zza r7 = zza(r13)
            int r7 = r7.ordinal()
            if (r7 == 0) goto L_0x00ec
            if (r7 == r5) goto L_0x00e9
            if (r7 == r2) goto L_0x00ec
            if (r7 == r3) goto L_0x00e1
        L_0x00df:
            r8 = r6
            goto L_0x00ef
        L_0x00e1:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "Android TV ads library should be called from an Android TV app"
            r13.<init>(r0)
            throw r13
        L_0x00e9:
            android.net.Uri r6 = com.google.android.gms.internal.atv_ads_framework.zzc.zza
            goto L_0x00df
        L_0x00ec:
            android.net.Uri r6 = com.google.android.gms.internal.atv_ads_framework.zzc.zzb
            goto L_0x00df
        L_0x00ef:
            android.content.pm.PackageManager r2 = r13.getPackageManager()
            java.lang.String r3 = r8.getAuthority()
            com.google.android.gms.internal.atv_ads_framework.zzt.zza(r3)
            android.content.pm.ProviderInfo r2 = r2.resolveContentProvider(r3, r4)
            if (r2 != 0) goto L_0x0105
            com.google.android.gms.internal.atv_ads_framework.zzae r13 = r1.zzc()
            goto L_0x0133
        L_0x0105:
            android.content.ContentResolver r7 = r13.getContentResolver()
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            android.database.Cursor r13 = r7.query(r8, r9, r10, r11, r12)
            com.google.android.gms.internal.atv_ads_framework.zzt.zza(r13)
        L_0x0114:
            boolean r2 = r13.moveToNext()     // Catch:{ all -> 0x013f }
            if (r2 == 0) goto L_0x012c
            java.lang.String r2 = r13.getString(r4)     // Catch:{ all -> 0x013f }
            com.google.android.gms.internal.atv_ads_framework.zzt.zza(r2)     // Catch:{ all -> 0x013f }
            java.lang.String r3 = r13.getString(r5)     // Catch:{ all -> 0x013f }
            com.google.android.gms.internal.atv_ads_framework.zzt.zza(r3)     // Catch:{ all -> 0x013f }
            r1.zza(r2, r3)     // Catch:{ all -> 0x013f }
            goto L_0x0114
        L_0x012c:
            r13.close()
            com.google.android.gms.internal.atv_ads_framework.zzae r13 = r1.zzc()
        L_0x0133:
            com.google.android.gms.internal.atv_ads_framework.zzaf r13 = r13.entrySet()
            r0.zzb(r13)
            com.google.android.gms.internal.atv_ads_framework.zzae r13 = r0.zzc()
            return r13
        L_0x013f:
            r0 = move-exception
            r13.close()     // Catch:{ all -> 0x0144 }
            goto L_0x015a
        L_0x0144:
            r13 = move-exception
            java.lang.Class<java.lang.Throwable> r1 = java.lang.Throwable.class
            java.lang.String r2 = "addSuppressed"
            java.lang.Class[] r3 = new java.lang.Class[r5]     // Catch:{ Exception -> 0x015a }
            java.lang.Class<java.lang.Throwable> r6 = java.lang.Throwable.class
            r3[r4] = r6     // Catch:{ Exception -> 0x015a }
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r2, r3)     // Catch:{ Exception -> 0x015a }
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x015a }
            r2[r4] = r13     // Catch:{ Exception -> 0x015a }
            r1.invoke(r0, r2)     // Catch:{ Exception -> 0x015a }
        L_0x015a:
            goto L_0x015c
        L_0x015b:
            throw r0
        L_0x015c:
            goto L_0x015b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.atv_ads_framework.zzd.zzb(android.content.Context):com.google.android.gms.internal.atv_ads_framework.zzae");
    }

    private static void zzc(zzad zzad, Context context, String str, String str2) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                zzad.zza(str2, Long.toString(PackageInfoCompat.getLongVersionCode(packageInfo)));
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
