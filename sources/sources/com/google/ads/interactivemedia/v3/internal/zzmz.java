package com.google.ads.interactivemedia.v3.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmz extends zzmq implements IInterface {
    zzmz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
    }

    public final IBinder zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, byte[] bArr) throws RemoteException {
        Parcel zza = zza();
        zzms.zzd(zza, iObjectWrapper);
        zzms.zzd(zza, iObjectWrapper2);
        zza.writeByteArray(bArr);
        Parcel zzu = zzu(3, zza);
        IBinder readStrongBinder = zzu.readStrongBinder();
        zzu.recycle();
        return readStrongBinder;
    }
}
