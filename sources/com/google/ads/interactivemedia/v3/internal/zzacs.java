package com.google.ads.interactivemedia.v3.internal;

import java.sql.Date;
import java.sql.Timestamp;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzacs {
    public static final boolean zza;
    public static final zzzs zzb;
    public static final zzzs zzc;
    public static final zzxj zzd;
    public static final zzxj zze;
    public static final zzxj zzf;

    static {
        boolean z;
        zzxj zzxj;
        try {
            Class.forName("java.sql.Date");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        zza = z;
        if (z) {
            zzb = new zzacq(Date.class);
            zzc = new zzacr(Timestamp.class);
            zzd = zzacj.zza;
            zze = zzacm.zza;
            zzxj = zzacp.zza;
        } else {
            zzxj = null;
            zzb = null;
            zzc = null;
            zzd = null;
            zze = null;
        }
        zzf = zzxj;
    }
}
