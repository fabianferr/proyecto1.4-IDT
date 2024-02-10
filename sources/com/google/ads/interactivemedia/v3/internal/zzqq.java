package com.google.ads.interactivemedia.v3.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzqq extends zzmr implements zzqr {
    public zzqq() {
        super("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 2:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                zzms.zzb(parcel);
                break;
            case 3:
                break;
            case 4:
                parcel.createIntArray();
                zzms.zzb(parcel);
                break;
            case 5:
                parcel.createByteArray();
                zzms.zzb(parcel);
                break;
            case 6:
                parcel.readInt();
                zzms.zzb(parcel);
                break;
            case 7:
                parcel.readInt();
                zzms.zzb(parcel);
                break;
            case 8:
                IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                parcel.readString();
                parcel.readString();
                zzms.zzb(parcel);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
