package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfoz {
    final zzfpc zza;
    final boolean zzb;

    private zzfoz(zzfpc zzfpc) {
        this.zza = zzfpc;
        this.zzb = zzfpc != null;
    }

    public static zzfoz zzb(Context context, String str, String str2) {
        zzfpc zzfpc;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzfpc = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                zzfpc = queryLocalInterface instanceof zzfpc ? (zzfpc) queryLocalInterface : new zzfpa(instantiate);
            }
            try {
                zzfpc.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzfoz(zzfpc);
            } catch (RemoteException | zzfob | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzfoz(new zzfpd());
            }
        } catch (Exception e) {
            throw new zzfob(e);
        } catch (Exception e2) {
            throw new zzfob(e2);
        }
    }

    public static zzfoz zzc() {
        zzfpd zzfpd = new zzfpd();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfoz(zzfpd);
    }

    public final zzfoy zza(byte[] bArr) {
        return new zzfoy(this, bArr, (zzfox) null);
    }
}
