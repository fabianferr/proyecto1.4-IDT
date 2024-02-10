package com.google.android.gms.cast;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.stats.ConnectionTracker;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzai implements ServiceConnection {
    final /* synthetic */ String zza;
    final /* synthetic */ CastDevice zzb;
    final /* synthetic */ CastRemoteDisplayLocalService.Options zzc;
    final /* synthetic */ CastRemoteDisplayLocalService.NotificationSettings zzd;
    final /* synthetic */ Context zze;
    final /* synthetic */ CastRemoteDisplayLocalService.Callbacks zzf;

    zzai(String str, CastDevice castDevice, CastRemoteDisplayLocalService.Options options, CastRemoteDisplayLocalService.NotificationSettings notificationSettings, Context context, CastRemoteDisplayLocalService.Callbacks callbacks) {
        this.zza = str;
        this.zzb = castDevice;
        this.zzc = options;
        this.zzd = notificationSettings;
        this.zze = context;
        this.zzf = callbacks;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (!CastRemoteDisplayLocalService.zzt(((zzao) iBinder).zza, this.zza, this.zzb, this.zzc, this.zzd, this.zze, this, this.zzf)) {
            CastRemoteDisplayLocalService.zza.e("Connected but unable to get the service instance", new Object[0]);
            this.zzf.onRemoteDisplaySessionError(new Status(2200));
            CastRemoteDisplayLocalService.zzd.set(false);
            try {
                ConnectionTracker.getInstance().unbindService(this.zze, this);
            } catch (IllegalArgumentException unused) {
                CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new Object[0]);
            }
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        CastRemoteDisplayLocalService.zza.d("onServiceDisconnected", new Object[0]);
        this.zzf.onRemoteDisplaySessionError(new Status(2201, "Service Disconnected"));
        CastRemoteDisplayLocalService.zzd.set(false);
        try {
            ConnectionTracker.getInstance().unbindService(this.zze, this);
        } catch (IllegalArgumentException unused) {
            CastRemoteDisplayLocalService.zza.d("No need to unbind service, already unbound", new Object[0]);
        }
    }
}
