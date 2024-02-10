package com.google.android.gms.internal.ads;

import androidx.media3.extractor.avi.AviExtractor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzabi implements zzaay {
    public final String zza;

    private zzabi(String str) {
        this.zza = str;
    }

    public static zzabi zzb(zzef zzef) {
        return new zzabi(zzef.zzx(zzef.zza(), zzfsk.zzc));
    }

    public final int zza() {
        return AviExtractor.FOURCC_strn;
    }
}
