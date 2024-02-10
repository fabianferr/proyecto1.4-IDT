package com.google.android.gms.internal.ads;

import android.os.HandlerThread;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzpw implements zzqk {
    private final zzftn zzb;
    private final zzftn zzc;

    public zzpw(int i, boolean z) {
        zzpu zzpu = new zzpu(i);
        zzpv zzpv = new zzpv(i);
        this.zzb = zzpu;
        this.zzc = zzpv;
    }

    static /* synthetic */ HandlerThread zza(int i) {
        return new HandlerThread(zzpy.zzs(i, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    static /* synthetic */ HandlerThread zzb(int i) {
        return new HandlerThread(zzpy.zzs(i, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004e  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzpy zzc(com.google.android.gms.internal.ads.zzqj r11) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "createCodec:"
            com.google.android.gms.internal.ads.zzqn r1 = r11.zza
            java.lang.String r1 = r1.zza
            r2 = 0
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x004a }
            r3.<init>(r0)     // Catch:{ Exception -> 0x004a }
            r3.append(r1)     // Catch:{ Exception -> 0x004a }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x004a }
            int r3 = com.google.android.gms.internal.ads.zzen.zza     // Catch:{ Exception -> 0x004a }
            android.os.Trace.beginSection(r0)     // Catch:{ Exception -> 0x004a }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r1)     // Catch:{ Exception -> 0x004a }
            com.google.android.gms.internal.ads.zzpy r1 = new com.google.android.gms.internal.ads.zzpy     // Catch:{ Exception -> 0x0048 }
            com.google.android.gms.internal.ads.zzftn r3 = r10.zzb     // Catch:{ Exception -> 0x0048 }
            com.google.android.gms.internal.ads.zzpu r3 = (com.google.android.gms.internal.ads.zzpu) r3     // Catch:{ Exception -> 0x0048 }
            int r3 = r3.zza     // Catch:{ Exception -> 0x0048 }
            android.os.HandlerThread r6 = zza(r3)     // Catch:{ Exception -> 0x0048 }
            com.google.android.gms.internal.ads.zzftn r3 = r10.zzc     // Catch:{ Exception -> 0x0048 }
            com.google.android.gms.internal.ads.zzpv r3 = (com.google.android.gms.internal.ads.zzpv) r3     // Catch:{ Exception -> 0x0048 }
            int r3 = r3.zza     // Catch:{ Exception -> 0x0048 }
            android.os.HandlerThread r7 = zzb(r3)     // Catch:{ Exception -> 0x0048 }
            r8 = 0
            r9 = 0
            r4 = r1
            r5 = r0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0048 }
            android.os.Trace.endSection()     // Catch:{ Exception -> 0x0045 }
            android.media.MediaFormat r3 = r11.zzb     // Catch:{ Exception -> 0x0045 }
            android.view.Surface r11 = r11.zzd     // Catch:{ Exception -> 0x0045 }
            r4 = 0
            com.google.android.gms.internal.ads.zzpy.zzh(r1, r3, r11, r2, r4)     // Catch:{ Exception -> 0x0045 }
            return r1
        L_0x0045:
            r11 = move-exception
            r2 = r1
            goto L_0x004c
        L_0x0048:
            r11 = move-exception
            goto L_0x004c
        L_0x004a:
            r11 = move-exception
            r0 = r2
        L_0x004c:
            if (r2 != 0) goto L_0x0054
            if (r0 == 0) goto L_0x0057
            r0.release()
            goto L_0x0057
        L_0x0054:
            r2.zzl()
        L_0x0057:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpw.zzc(com.google.android.gms.internal.ads.zzqj):com.google.android.gms.internal.ads.zzpy");
    }
}
