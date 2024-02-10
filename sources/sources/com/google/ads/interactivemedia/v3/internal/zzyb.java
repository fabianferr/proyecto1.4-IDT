package com.google.ads.interactivemedia.v3.internal;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzyb implements zzyz {
    final /* synthetic */ Class zza;

    zzyb(zzyl zzyl, Class cls) {
        this.zza = cls;
    }

    public final Object zza() {
        try {
            return zzzk.zzc.zza(this.zza);
        } catch (Exception e) {
            String valueOf = String.valueOf(this.zza);
            throw new RuntimeException("Unable to create instance of " + valueOf + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e);
        }
    }
}
