package com.google.android.gms.cast.framework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.internal.cast.zzaf;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class ReconnectionService extends Service {
    private static final Logger zza = new Logger("ReconnectionService");
    private zzaj zzb;

    public IBinder onBind(Intent intent) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zzf(intent);
            } catch (RemoteException e) {
                Class<zzaj> cls = zzaj.class;
                zza.d(e, "Unable to call %s on %s.", "onBind", "zzaj");
            }
        }
        return null;
    }

    public void onCreate() {
        CastContext sharedInstance = CastContext.getSharedInstance(this);
        zzaj zzc = zzaf.zzc(this, sharedInstance.getSessionManager().zzb(), sharedInstance.zzc().zza());
        this.zzb = zzc;
        if (zzc != null) {
            try {
                zzc.zzg();
            } catch (RemoteException e) {
                Class<zzaj> cls = zzaj.class;
                zza.d(e, "Unable to call %s on %s.", "onCreate", "zzaj");
            }
            super.onCreate();
        }
    }

    public void onDestroy() {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                zzaj.zzh();
            } catch (RemoteException e) {
                Class<zzaj> cls = zzaj.class;
                zza.d(e, "Unable to call %s on %s.", "onDestroy", "zzaj");
            }
            super.onDestroy();
        }
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        zzaj zzaj = this.zzb;
        if (zzaj != null) {
            try {
                return zzaj.zze(intent, i, i2);
            } catch (RemoteException e) {
                Class<zzaj> cls = zzaj.class;
                zza.d(e, "Unable to call %s on %s.", "onStartCommand", "zzaj");
            }
        }
        return 2;
    }
}
