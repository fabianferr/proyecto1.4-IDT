package com.google.android.gms.cast.framework.media;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.MediaMetadata;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public interface zzd extends IInterface {
    WebImage zze(MediaMetadata mediaMetadata, int i) throws RemoteException;

    WebImage zzf(MediaMetadata mediaMetadata, ImageHints imageHints) throws RemoteException;

    IObjectWrapper zzg() throws RemoteException;
}
