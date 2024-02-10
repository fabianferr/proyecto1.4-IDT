package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzt extends zzb implements zzu {
    public zzt() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            IObjectWrapper zzb = zzb();
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb);
        } else if (i == 2) {
            zzd();
            parcel2.writeNoException();
        } else if (i == 3) {
            zzc();
            parcel2.writeNoException();
        } else if (i != 4) {
            return false;
        } else {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }
        return true;
    }
}
