package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.1.0 */
public final class zzdp implements zzdo {
    private static final zzdp zza = new zzdp((Object) null);
    private final Object zzb;

    private zzdp(Object obj) {
        this.zzb = obj;
    }

    public static zzdo zza(Object obj) {
        if (obj != null) {
            return new zzdp(obj);
        }
        throw new NullPointerException("instance cannot be null");
    }

    public final Object zzb() {
        return this.zzb;
    }
}
