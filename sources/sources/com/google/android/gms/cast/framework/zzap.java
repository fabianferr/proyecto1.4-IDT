package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzap extends zzb implements zzaq {
    public zzap() {
        super("com.google.android.gms.cast.framework.ISessionManagerListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                IObjectWrapper zzb = zzb();
                parcel2.writeNoException();
                zzc.zze(parcel2, zzb);
                return true;
            case 2:
                IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzc.zzb(parcel);
                zzj(asInterface);
                parcel2.writeNoException();
                return true;
            case 3:
                IObjectWrapper asInterface2 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString = parcel.readString();
                zzc.zzb(parcel);
                zzi(asInterface2, readString);
                parcel2.writeNoException();
                return true;
            case 4:
                IObjectWrapper asInterface3 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt = parcel.readInt();
                zzc.zzb(parcel);
                zzh(asInterface3, readInt);
                parcel2.writeNoException();
                return true;
            case 5:
                IObjectWrapper asInterface4 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                zzc.zzb(parcel);
                zzd(asInterface4);
                parcel2.writeNoException();
                return true;
            case 6:
                IObjectWrapper asInterface5 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt2 = parcel.readInt();
                zzc.zzb(parcel);
                zzc(asInterface5, readInt2);
                parcel2.writeNoException();
                return true;
            case 7:
                IObjectWrapper asInterface6 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                String readString2 = parcel.readString();
                zzc.zzb(parcel);
                zzg(asInterface6, readString2);
                parcel2.writeNoException();
                return true;
            case 8:
                IObjectWrapper asInterface7 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                boolean zzf = zzc.zzf(parcel);
                zzc.zzb(parcel);
                zzf(asInterface7, zzf);
                parcel2.writeNoException();
                return true;
            case 9:
                IObjectWrapper asInterface8 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt3 = parcel.readInt();
                zzc.zzb(parcel);
                zze(asInterface8, readInt3);
                parcel2.writeNoException();
                return true;
            case 10:
                IObjectWrapper asInterface9 = IObjectWrapper.Stub.asInterface(parcel.readStrongBinder());
                int readInt4 = parcel.readInt();
                zzc.zzb(parcel);
                zzk(asInterface9, readInt4);
                parcel2.writeNoException();
                return true;
            case 11:
                parcel2.writeNoException();
                parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
                return true;
            default:
                return false;
        }
    }
}
