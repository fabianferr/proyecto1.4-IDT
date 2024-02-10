package com.google.android.gms.cast.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.zzbu;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzag extends zza implements IInterface {
    zzag(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void zze() throws RemoteException {
        zzd(17, zza());
    }

    public final void zzf() throws RemoteException {
        zzd(1, zza());
    }

    public final void zzg(String str, String str2, zzbu zzbu) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, zzbu);
        zzd(14, zza);
    }

    public final void zzh(String str, LaunchOptions launchOptions) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, launchOptions);
        zzd(13, zza);
    }

    public final void zzi() throws RemoteException {
        zzd(4, zza());
    }

    public final void zzj(zzai zzai) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzai);
        zzd(18, zza);
    }

    public final void zzk(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(11, zza);
    }

    public final void zzl() throws RemoteException {
        zzd(6, zza());
    }

    public final void zzm(String str, String str2, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzd(9, zza);
    }

    public final void zzn(boolean z, double d, boolean z2) throws RemoteException {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeDouble(d);
        zza.writeInt(z2 ? 1 : 0);
        zzd(8, zza);
    }

    public final void zzo(double d, double d2, boolean z) throws RemoteException {
        Parcel zza = zza();
        zza.writeDouble(d);
        zza.writeDouble(d2);
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zzd(7, zza);
    }

    public final void zzp(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(5, zza);
    }

    public final void zzq() throws RemoteException {
        zzd(19, zza());
    }

    public final void zzr(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(12, zza);
    }
}
