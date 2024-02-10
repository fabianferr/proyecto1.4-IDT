package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } else if (i == 2) {
            IObjectWrapper zze = zze();
            parcel2.writeNoException();
            zzc.zze(parcel2, zze);
        } else if (i == 3) {
            List zzf = zzf();
            parcel2.writeNoException();
            parcel2.writeTypedList(zzf);
        } else if (i != 4) {
            return false;
        } else {
            int[] zzg = zzg();
            parcel2.writeNoException();
            parcel2.writeIntArray(zzg);
        }
        return true;
    }
}
