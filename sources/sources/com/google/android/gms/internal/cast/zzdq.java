package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public abstract class zzdq extends zzb implements zzdr {
    public zzdq() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzc.zzb(parcel);
            zzb(parcel.readInt(), parcel.readInt(), (Surface) zzc.zza(parcel, Surface.CREATOR));
        } else if (i == 2) {
            int readInt = parcel.readInt();
            zzc.zzb(parcel);
            zzd(readInt);
        } else if (i == 3) {
            zzf();
        } else if (i == 4) {
            zzc();
        } else if (i != 5) {
            return false;
        } else {
            boolean zzf = zzc.zzf(parcel);
            zzc.zzb(parcel);
            zze(zzf);
        }
        parcel2.writeNoException();
        return true;
    }
}
