package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.concurrent.Executor;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzmv extends RemoteCreator {
    private static final zzmv zza = new zzmv();

    private zzmv() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    public static zzmy zza(Context context, Executor executor, zzm zzm) {
        zzmy zzmy = null;
        if (zzm.zzh() && GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 12800000) == 0) {
            zzmy = zza.zzb(context, executor, zzm);
        }
        return zzmy == null ? new zzmu(context, executor, zzm) : zzmy;
    }

    private final zzmy zzb(Context context, Executor executor, zzm zzm) {
        try {
            IBinder zze = ((zzmz) getRemoteCreatorInstance(context)).zze(ObjectWrapper.wrap(context), ObjectWrapper.wrap(executor), zzm.zzav());
            if (zze == null) {
                return null;
            }
            IInterface queryLocalInterface = zze.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
            return queryLocalInterface instanceof zzmy ? (zzmy) queryLocalInterface : new zzmw(zze);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException | IllegalArgumentException | LinkageError unused) {
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        return queryLocalInterface instanceof zzmz ? (zzmz) queryLocalInterface : new zzmz(iBinder);
    }
}
