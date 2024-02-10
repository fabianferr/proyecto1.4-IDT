package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzqo {
    final zzqr zza;
    final boolean zzb;

    private zzqo(zzqr zzqr) {
        this.zza = zzqr;
        this.zzb = zzqr != null;
    }

    public static zzqo zzb(Context context, String str, String str2) {
        zzqr zzqr;
        try {
            IBinder instantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
            if (instantiate == null) {
                zzqr = null;
            } else {
                IInterface queryLocalInterface = instantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                zzqr = queryLocalInterface instanceof zzqr ? (zzqr) queryLocalInterface : new zzqp(instantiate);
            }
            try {
                zzqr.zze(ObjectWrapper.wrap(context), str, (String) null);
                Log.i("GASS", "GassClearcutLogger Initialized.");
                return new zzqo(zzqr);
            } catch (RemoteException | zzps | NullPointerException | SecurityException unused) {
                Log.d("GASS", "Cannot dynamite load clearcut");
                return new zzqo(new zzqs());
            }
        } catch (Exception e) {
            throw new zzps(e);
        } catch (Exception e2) {
            throw new zzps(e2);
        }
    }

    public static zzqo zzc() {
        zzqs zzqs = new zzqs();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzqo(zzqs);
    }

    public final zzqn zza(byte[] bArr) {
        return new zzqn(this, bArr, (zzqm) null);
    }
}
