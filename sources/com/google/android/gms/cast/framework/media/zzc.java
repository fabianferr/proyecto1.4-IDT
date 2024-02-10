package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.cast.zzb;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzc extends zzb implements zzd {
    public zzc() {
        super("com.google.android.gms.cast.framework.media.IImagePicker");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            int readInt = parcel.readInt();
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            WebImage zze = zze((MediaMetadata) com.google.android.gms.internal.cast.zzc.zza(parcel, MediaMetadata.CREATOR), readInt);
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zzd(parcel2, zze);
        } else if (i == 2) {
            IObjectWrapper zzg = zzg();
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zze(parcel2, zzg);
        } else if (i == 3) {
            parcel2.writeNoException();
            parcel2.writeInt(GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        } else if (i != 4) {
            return false;
        } else {
            com.google.android.gms.internal.cast.zzc.zzb(parcel);
            WebImage zzf = zzf((MediaMetadata) com.google.android.gms.internal.cast.zzc.zza(parcel, MediaMetadata.CREATOR), (ImageHints) com.google.android.gms.internal.cast.zzc.zza(parcel, ImageHints.CREATOR));
            parcel2.writeNoException();
            com.google.android.gms.internal.cast.zzc.zzd(parcel2, zzf);
        }
        return true;
    }
}
