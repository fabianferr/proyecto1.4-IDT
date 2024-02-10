package com.google.android.gms.cast;

import com.google.android.gms.cast.Cast;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public interface zzr extends HasApiKey {
    double zza();

    int zzb();

    int zzc();

    ApplicationMetadata zzd();

    Task zze();

    Task zzf();

    Task zzg(String str);

    Task zzh(String str, String str2);

    Task zzi(String str, Cast.MessageReceivedCallback messageReceivedCallback);

    String zzj();

    void zzk(zzq zzq);

    boolean zzl();

    boolean zzm();
}
