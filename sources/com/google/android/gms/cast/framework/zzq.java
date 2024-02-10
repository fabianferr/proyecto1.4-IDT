package com.google.android.gms.cast.framework;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzq extends com.google.android.gms.cast.zzq {
    final /* synthetic */ CastSession zza;

    /* synthetic */ zzq(CastSession castSession, zzp zzp) {
        this.zza = castSession;
    }

    public final void zza() {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                if (castSession.zzj != null) {
                    castSession.zzj.zzp();
                }
                this.zza.zze.zzh((Bundle) null);
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnected", "zzac");
            }
        }
    }

    public final void zzb(int i) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzi(new ConnectionResult(i));
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnectionFailed", "zzac");
            }
        }
    }

    public final void zzc(int i) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzj(i);
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                CastSession.zzb.d(e, "Unable to call %s on %s.", "onConnectionSuspended", "zzac");
            }
        }
    }

    public final void zzd(int i) {
        CastSession castSession = this.zza;
        if (castSession.zze != null) {
            try {
                castSession.zze.zzi(new ConnectionResult(i));
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                CastSession.zzb.d(e, "Unable to call %s on %s.", "onDisconnected", "zzac");
            }
        }
    }
}
