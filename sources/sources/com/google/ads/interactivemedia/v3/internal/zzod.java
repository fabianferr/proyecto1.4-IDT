package com.google.ads.interactivemedia.v3.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzod extends zzmq implements zzof {
    zzod(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.signalsdk.ISignalSdkService");
    }

    public final void zze(zzog zzog, zzoa zzoa) throws RemoteException {
        Parcel zza = zza();
        zzms.zzc(zza, zzog);
        zzms.zzd(zza, zzoa);
        zzw(2, zza);
    }

    public final void zzf(Bundle bundle, zzoc zzoc) throws RemoteException {
        Parcel zza = zza();
        zzms.zzc(zza, bundle);
        zzms.zzd(zza, zzoc);
        zzw(1, zza);
    }
}
