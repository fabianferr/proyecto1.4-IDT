package com.google.android.gms.cast.framework;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.internal.cast.zzb;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public abstract class zzab extends zzb implements zzac {
    public static zzac zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.cast.framework.ICastSession");
        return queryLocalInterface instanceof zzac ? (zzac) queryLocalInterface : new zzaa(iBinder);
    }
}
