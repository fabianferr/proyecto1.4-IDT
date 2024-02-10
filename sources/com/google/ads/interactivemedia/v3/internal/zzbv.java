package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbv extends ContentObserver {
    private final Context zza;
    private final AudioManager zzb;
    private final zzbt zzc;
    private float zzd;
    private final zzcd zze;

    public zzbv(Handler handler, Context context, zzbt zzbt, zzcd zzcd) {
        super(handler);
        this.zza = context;
        this.zzb = (AudioManager) context.getSystemService("audio");
        this.zzc = zzbt;
        this.zze = zzcd;
    }

    private final float zzc() {
        int streamVolume = this.zzb.getStreamVolume(3);
        int streamMaxVolume = this.zzb.getStreamMaxVolume(3);
        float f = 0.0f;
        if (streamMaxVolume > 0 && streamVolume > 0) {
            float f2 = ((float) streamVolume) / ((float) streamMaxVolume);
            f = 1.0f;
            return f2 > 1.0f ? f : f2;
        }
    }

    private final void zzd() {
        this.zze.zzd(this.zzd);
    }

    public final void onChange(boolean z) {
        super.onChange(z);
        float zzc2 = zzc();
        if (zzc2 != this.zzd) {
            this.zzd = zzc2;
            zzd();
        }
    }

    public final void zza() {
        this.zzd = zzc();
        zzd();
        this.zza.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    public final void zzb() {
        this.zza.getContentResolver().unregisterContentObserver(this);
    }
}
