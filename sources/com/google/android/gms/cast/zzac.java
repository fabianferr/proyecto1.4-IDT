package com.google.android.gms.cast;

import android.hardware.display.DisplayManager;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.cast.CastRemoteDisplayLocalService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.cast.zzdn;
import com.google.android.gms.internal.cast.zzds;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzac extends zzaf {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzdn zzb;
    final /* synthetic */ CastRemoteDisplayClient zzc;
    final /* synthetic */ zzal zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzac(CastRemoteDisplayClient castRemoteDisplayClient, TaskCompletionSource taskCompletionSource, zzdn zzdn, zzal zzal) {
        super((zzae) null);
        this.zzc = castRemoteDisplayClient;
        this.zza = taskCompletionSource;
        this.zzb = zzdn;
        this.zzd = zzal;
    }

    public final void zzb(int i, int i2, Surface surface) throws RemoteException {
        this.zzc.zzc.d("onConnected", new Object[0]);
        DisplayManager displayManager = (DisplayManager) this.zzc.getApplicationContext().getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
        if (displayManager == null) {
            this.zzc.zzc.e("Unable to get the display manager", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        CastRemoteDisplayClient.zzd(this.zzc);
        this.zzc.zzd = displayManager.createVirtualDisplay("private_display", i, i2, (Math.min(i, i2) * 320) / 1080, surface, 2);
        CastRemoteDisplayClient castRemoteDisplayClient = this.zzc;
        if (castRemoteDisplayClient.zzd == null) {
            castRemoteDisplayClient.zzc.e("Unable to create virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display = castRemoteDisplayClient.zzd.getDisplay();
        if (display == null) {
            this.zzc.zzc.e("Virtual display does not have a display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        try {
            ((zzds) this.zzb.getService()).zzf(this, display.getDisplayId());
        } catch (RemoteException | IllegalStateException unused) {
            this.zzc.zzc.e("Unable to provision the route's new virtual Display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
        }
    }

    public final void zzc() {
        this.zzc.zzc.d("onConnectedWithDisplay", new Object[0]);
        CastRemoteDisplayClient castRemoteDisplayClient = this.zzc;
        if (castRemoteDisplayClient.zzd == null) {
            castRemoteDisplayClient.zzc.e("There is no virtual display", new Object[0]);
            TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
            return;
        }
        Display display = castRemoteDisplayClient.zzd.getDisplay();
        if (display != null) {
            TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, display, this.zza);
            return;
        }
        this.zzc.zzc.e("Virtual display no longer has a display", new Object[0]);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    public final void zzd(int i) throws RemoteException {
        this.zzc.zzc.d("onError: %d", Integer.valueOf(i));
        CastRemoteDisplayClient.zzd(this.zzc);
        TaskUtil.setResultOrApiException(Status.RESULT_INTERNAL_ERROR, null, this.zza);
    }

    public final void zze(boolean z) {
        this.zzc.zzc.d("onRemoteDisplayMuteStateChanged: %b", Boolean.valueOf(z));
        zzal zzal = this.zzd;
        if (zzal != null) {
            CastRemoteDisplayLocalService castRemoteDisplayLocalService = zzal.zza;
            castRemoteDisplayLocalService.zzv("onRemoteDisplayMuteStateChanged: " + z);
            CastRemoteDisplayLocalService.Callbacks callbacks = (CastRemoteDisplayLocalService.Callbacks) zzal.zza.zzg.get();
            if (callbacks != null) {
                callbacks.onRemoteDisplayMuteStateChanged(z);
            }
        }
    }
}
