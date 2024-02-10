package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzv extends zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            zzc.zzb(parcel);
            zzc(readString, readString2);
            parcel2.writeNoException();
        } else if (i == 2) {
            zzc.zzb(parcel);
            zzd(parcel.readString(), (LaunchOptions) zzc.zza(parcel, LaunchOptions.CREATOR));
            parcel2.writeNoException();
        } else if (i == 3) {
            String readString3 = parcel.readString();
            zzc.zzb(parcel);
            zze(readString3);
            parcel2.writeNoException();
        } else if (i == 4) {
            int readInt = parcel.readInt();
            zzc.zzb(parcel);
            zzb(readInt);
            parcel2.writeNoException();
        } else if (i != 5) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
