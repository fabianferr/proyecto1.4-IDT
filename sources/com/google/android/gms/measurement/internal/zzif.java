package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
public final /* synthetic */ class zzif implements Runnable {
    public final /* synthetic */ zzig zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ Exception zzc;
    public final /* synthetic */ byte[] zzd;
    public final /* synthetic */ Map zze;

    public /* synthetic */ zzif(zzig zzig, int i, Exception exc, byte[] bArr, Map map) {
        this.zza = zzig;
        this.zzb = i;
        this.zzc = exc;
        this.zzd = bArr;
        this.zze = map;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
