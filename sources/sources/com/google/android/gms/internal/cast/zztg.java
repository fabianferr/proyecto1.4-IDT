package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zztg implements zztn {
    private final zztn[] zza;

    zztg(zztn... zztnArr) {
        this.zza = zztnArr;
    }

    public final zztm zzb(Class cls) {
        zztn[] zztnArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zztn zztn = zztnArr[i];
            if (zztn.zzc(cls)) {
                return zztn.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zztn[] zztnArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zztnArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
