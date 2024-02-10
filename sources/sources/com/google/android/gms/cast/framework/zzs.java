package com.google.android.gms.cast.framework;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzs {
    private static final Logger zza = new Logger("DiscoveryManager");
    private final zzag zzb;

    zzs(zzag zzag) {
        this.zzb = zzag;
    }

    public final IObjectWrapper zza() {
        try {
            return this.zzb.zze();
        } catch (RemoteException e) {
            Class<zzag> cls = zzag.class;
            zza.d(e, "Unable to call %s on %s.", "getWrappedThis", "zzag");
            return null;
        }
    }
}
