package com.google.android.gms.internal.cast;

import android.app.Service;
import android.content.Context;
import android.os.AsyncTask;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.cast.framework.CastOptions;
import com.google.android.gms.cast.framework.ModuleUnavailableException;
import com.google.android.gms.cast.framework.media.internal.zzi;
import com.google.android.gms.cast.framework.media.internal.zzk;
import com.google.android.gms.cast.framework.zzac;
import com.google.android.gms.cast.framework.zzaj;
import com.google.android.gms.cast.framework.zzam;
import com.google.android.gms.cast.framework.zzau;
import com.google.android.gms.cast.framework.zzw;
import com.google.android.gms.cast.framework.zzz;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzaf {
    private static final Logger zza = new Logger("CastDynamiteModule");

    public static zzz zza(Context context, CastOptions castOptions, zzal zzal, Map map) throws ModuleUnavailableException, RemoteException {
        return zzf(context).zze(ObjectWrapper.wrap(context.getApplicationContext()), castOptions, zzal, map);
    }

    public static zzac zzb(Context context, CastOptions castOptions, IObjectWrapper iObjectWrapper, zzw zzw) {
        if (iObjectWrapper == null) {
            return null;
        }
        try {
            return zzf(context).zzf(castOptions, iObjectWrapper, zzw);
        } catch (RemoteException | ModuleUnavailableException e) {
            Class<zzaj> cls = zzaj.class;
            zza.d(e, "Unable to call %s on %s.", "newCastSessionImpl", "zzaj");
            return null;
        }
    }

    public static zzaj zzc(Service service, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        if (!(iObjectWrapper == null || iObjectWrapper2 == null)) {
            try {
                return zzf(service.getApplicationContext()).zzg(ObjectWrapper.wrap(service), iObjectWrapper, iObjectWrapper2);
            } catch (RemoteException | ModuleUnavailableException e) {
                Class<zzaj> cls = zzaj.class;
                zza.d(e, "Unable to call %s on %s.", "newReconnectionServiceImpl", "zzaj");
            }
        }
        return null;
    }

    public static zzam zzd(Context context, String str, String str2, zzau zzau) {
        try {
            return zzf(context).zzh(str, str2, zzau);
        } catch (RemoteException | ModuleUnavailableException e) {
            Class<zzaj> cls = zzaj.class;
            zza.d(e, "Unable to call %s on %s.", "newSessionImpl", "zzaj");
            return null;
        }
    }

    public static zzi zze(Context context, AsyncTask asyncTask, zzk zzk, int i, int i2, boolean z, long j, int i3, int i4, int i5) {
        try {
            return zzf(context.getApplicationContext()).zzi(ObjectWrapper.wrap(asyncTask), zzk, i, i2, false, 2097152, 5, 333, 10000);
        } catch (RemoteException | ModuleUnavailableException e) {
            Class<zzaj> cls = zzaj.class;
            zza.d(e, "Unable to call %s on %s.", "newFetchBitmapTaskImpl", "zzaj");
            return null;
        }
    }

    private static zzaj zzf(Context context) throws ModuleUnavailableException {
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, "com.google.android.gms.cast.framework.dynamite").instantiate("com.google.android.gms.cast.framework.internal.CastDynamiteModuleImpl");
            if (instantiate == null) {
                return null;
            }
            IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
            if (queryLocalInterface instanceof zzaj) {
                return (zzaj) queryLocalInterface;
            }
            return new zzai(instantiate);
        } catch (DynamiteModule.LoadingException e) {
            throw new ModuleUnavailableException(e);
        }
    }
}
