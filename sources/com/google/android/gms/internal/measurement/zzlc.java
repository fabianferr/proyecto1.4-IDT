package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.1.1 */
final class zzlc implements zzlj {
    private final zzlj[] zza;

    zzlc(zzlj... zzljArr) {
        this.zza = zzljArr;
    }

    public final zzli zzb(Class cls) {
        zzlj[] zzljArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzlj zzlj = zzljArr[i];
            if (zzlj.zzc(cls)) {
                return zzlj.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(String.valueOf(cls.getName())));
    }

    public final boolean zzc(Class cls) {
        zzlj[] zzljArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzljArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
