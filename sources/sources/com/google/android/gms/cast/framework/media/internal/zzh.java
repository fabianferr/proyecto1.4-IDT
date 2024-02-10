package com.google.android.gms.cast.framework.media.internal;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzh extends zzb implements zzi {
    public static zzi zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTask");
        return queryLocalInterface instanceof zzi ? (zzi) queryLocalInterface : new zzg(iBinder);
    }
}
