package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzpy extends zzmq implements IInterface {
    zzpy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzpw zze(zzpu zzpu) throws RemoteException {
        Parcel zza = zza();
        zzms.zzc(zza, zzpu);
        Parcel zzu = zzu(1, zza);
        zzpw zzpw = (zzpw) zzms.zza(zzu, zzpw.CREATOR);
        zzu.recycle();
        return zzpw;
    }

    public final zzqf zzf(zzqd zzqd) throws RemoteException {
        Parcel zza = zza();
        zzms.zzc(zza, zzqd);
        Parcel zzu = zzu(3, zza);
        zzqf zzqf = (zzqf) zzms.zza(zzu, zzqf.CREATOR);
        zzu.recycle();
        return zzqf;
    }
}
