package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzerd implements zzeve {
    private final zzfzq zza;
    private final Context zzb;

    public zzerd(zzfzq zzfzq, Context context) {
        this.zza = zzfzq;
        this.zzb = context;
    }

    public final int zza() {
        return 13;
    }

    public final zzfzp zzb() {
        return this.zza.zzb(new zzerc(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzere zzc() throws Exception {
        int i;
        int i2;
        AudioManager audioManager = (AudioManager) this.zzb.getSystemService("audio");
        int mode = audioManager.getMode();
        boolean isMusicActive = audioManager.isMusicActive();
        boolean isSpeakerphoneOn = audioManager.isSpeakerphoneOn();
        int streamVolume = audioManager.getStreamVolume(3);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zziD)).booleanValue()) {
            i2 = zzt.zzq().zzi(audioManager);
            i = audioManager.getStreamMaxVolume(3);
        } else {
            i2 = -1;
            i = -1;
        }
        return new zzere(mode, isMusicActive, isSpeakerphoneOn, streamVolume, i2, i, audioManager.getRingerMode(), audioManager.getStreamVolume(2), zzt.zzr().zza(), zzt.zzr().zze());
    }
}
