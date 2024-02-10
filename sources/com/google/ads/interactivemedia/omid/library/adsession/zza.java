package com.google.ads.interactivemedia.omid.library.adsession;

import android.view.View;
import com.google.ads.interactivemedia.v3.internal.zzbr;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zza {
    public abstract void zzb(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str);

    public abstract void zzc();

    public abstract void zzd(View view);

    public abstract void zze();

    public abstract void zzf();

    public static zza zza(zzb zzb, zzc zzc) {
        if (zzbr.zzb()) {
            return new zze(zzb, zzc);
        }
        throw new IllegalStateException("Method called before OM SDK activation");
    }
}
