package com.google.android.gms.cast.framework.media;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final /* synthetic */ class zzk implements Runnable {
    public final /* synthetic */ MediaNotificationService zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzk(MediaNotificationService mediaNotificationService, int i) {
        this.zza = mediaNotificationService;
        this.zzb = i;
    }

    public final void run() {
        this.zza.stopSelf(this.zzb);
    }
}
