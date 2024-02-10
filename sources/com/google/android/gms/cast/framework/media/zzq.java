package com.google.android.gms.cast.framework.media;

import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzq extends TimerTask {
    final /* synthetic */ MediaQueue zza;

    zzq(MediaQueue mediaQueue) {
        this.zza = mediaQueue;
    }

    public final void run() {
        MediaQueue.zzj(this.zza);
    }
}
