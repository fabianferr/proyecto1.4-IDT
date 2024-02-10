package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgx {
    private final Context zza;
    private final boolean zzb;
    private final long zzc;
    private final zzgu zzd;
    private final zzgp zze;

    public zzgx(Context context, zzgu zzgu, zzhc zzhc) {
        this.zza = context;
        this.zzb = !zzgu.zza;
        long j = zzgu.zzb;
        this.zzc = j <= 0 ? 150 : j;
        this.zzd = zzgu;
        this.zze = new zzgp(context, zzgu.zzf, zzhc);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.ads.interactivemedia.v3.impl.data.zzbc zza(com.google.ads.interactivemedia.v3.api.BaseRequest r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.content.Context r2 = r11.zza     // Catch:{ Exception | NoClassDefFoundError -> 0x0017 }
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r2 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r2)     // Catch:{ Exception | NoClassDefFoundError -> 0x0017 }
            java.lang.String r3 = r2.getId()     // Catch:{ Exception | NoClassDefFoundError -> 0x0017 }
            boolean r2 = r2.isLimitAdTrackingEnabled()     // Catch:{ Exception | NoClassDefFoundError -> 0x0017 }
            java.lang.String r4 = "adid"
            r7 = r2
            r5 = r3
        L_0x0015:
            r6 = r4
            goto L_0x003e
        L_0x0017:
            r3 = r0
            r2 = 0
        L_0x0019:
            android.content.Context r4 = r11.zza     // Catch:{ SettingNotFoundException -> 0x0036 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ SettingNotFoundException -> 0x0036 }
            java.lang.String r5 = "advertising_id"
            java.lang.String r5 = android.provider.Settings.Secure.getString(r4, r5)     // Catch:{ SettingNotFoundException -> 0x0036 }
            java.lang.String r6 = "limit_ad_tracking"
            int r2 = android.provider.Settings.Secure.getInt(r4, r6)     // Catch:{ SettingNotFoundException -> 0x0036 }
            r3 = 1
            if (r2 != r3) goto L_0x0030
            r2 = 1
            goto L_0x0031
        L_0x0030:
            r2 = 0
        L_0x0031:
            java.lang.String r4 = "afai"
            r7 = r2
            goto L_0x0015
        L_0x0035:
            r3 = r5
        L_0x0036:
            java.lang.String r4 = "Failed to get advertising ID."
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r4)
            r6 = r0
            r7 = r2
            r5 = r3
        L_0x003e:
            boolean r2 = r11.zzb
            if (r2 == 0) goto L_0x0070
            android.content.Context r2 = r11.zza     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            com.google.android.gms.appset.AppSetIdClient r2 = com.google.android.gms.appset.AppSet.getClient(r2)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            com.google.android.gms.tasks.Task r2 = r2.getAppSetIdInfo()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            long r3 = r11.zzc     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r3, r8)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            com.google.android.gms.appset.AppSetIdInfo r2 = (com.google.android.gms.appset.AppSetIdInfo) r2     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            java.lang.String r3 = r2.getId()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0068, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0061 }
            int r1 = r2.getScope()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x0069, Exception | NoClassDefFoundError | NoSuchMethodError -> 0x0062 }
            r9 = r1
            r8 = r3
            goto L_0x0072
        L_0x0061:
            r3 = r0
        L_0x0062:
            java.lang.String r2 = "Unable to contact the App Set SDK."
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r2)
            goto L_0x006e
        L_0x0068:
            r3 = r0
        L_0x0069:
            java.lang.String r2 = "Timeout getting AppSet ID."
            com.google.ads.interactivemedia.v3.internal.zzhd.zzd(r2)
        L_0x006e:
            r8 = r3
            goto L_0x0071
        L_0x0070:
            r8 = r0
        L_0x0071:
            r9 = 0
        L_0x0072:
            com.google.ads.interactivemedia.v3.internal.zzgv r12 = r12.zza()
            com.google.ads.interactivemedia.v3.internal.zzgu r1 = r11.zzd
            boolean r12 = r12.zza(r1, r7)
            if (r12 == 0) goto L_0x0084
            com.google.ads.interactivemedia.v3.internal.zzgp r12 = r11.zze
            java.lang.String r0 = r12.zza()
        L_0x0084:
            r10 = r0
            com.google.ads.interactivemedia.v3.impl.data.zzbc r12 = com.google.ads.interactivemedia.v3.impl.data.zzbc.create(r5, r6, r7, r8, r9, r10)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzgx.zza(com.google.ads.interactivemedia.v3.api.BaseRequest):com.google.ads.interactivemedia.v3.impl.data.zzbc");
    }
}
