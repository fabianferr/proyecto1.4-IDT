package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.app.Application;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.View;
import com.google.ads.interactivemedia.v3.impl.data.zza;
import com.google.ads.interactivemedia.v3.impl.data.zzat;
import com.google.ads.interactivemedia.v3.impl.data.zzau;
import com.google.ads.interactivemedia.v3.impl.data.zzb;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzdj implements zzfh {
    /* access modifiers changed from: private */
    public final zzfm zza;
    /* access modifiers changed from: private */
    public final String zzb;
    private final View zzc;
    private zzdi zzd = null;
    /* access modifiers changed from: private */
    public Activity zze = null;
    private boolean zzf = false;
    private final zzhw zzg;

    public zzdj(String str, zzfm zzfm, View view) {
        zzhw zzhw = new zzhw();
        this.zzb = str;
        this.zza = zzfm;
        this.zzc = view;
        this.zzg = zzhw;
    }

    private final DisplayMetrics zzl() {
        return this.zzc.getContext().getResources().getDisplayMetrics();
    }

    private static zzau zzm(zzau zzau, float f) {
        zzat builder = zzau.builder();
        builder.left((int) Math.ceil((double) (((float) zzau.left()) / f)));
        builder.top((int) Math.ceil((double) (((float) zzau.top()) / f)));
        builder.height((int) Math.ceil((double) (((float) zzau.height()) / f)));
        builder.width((int) Math.ceil((double) (((float) zzau.width()) / f)));
        return builder.build();
    }

    public final zzb zzc(String str, String str2, String str3) {
        double d;
        zzau zzm = zzm(zzau.builder().locationOnScreenOfView(this.zzc).build(), zzl().density);
        Rect rect = new Rect();
        boolean globalVisibleRect = this.zzc.getGlobalVisibleRect(rect);
        IBinder windowToken = this.zzc.getWindowToken();
        boolean z = false;
        if (!globalVisibleRect || windowToken == null || !this.zzc.isShown()) {
            rect.set(0, 0, 0, 0);
        }
        zzat builder = zzau.builder();
        builder.left(rect.left);
        builder.top(rect.top);
        builder.height(rect.height());
        builder.width(rect.width());
        zzau zzm2 = zzm(builder.build(), zzl().density);
        if (!this.zzc.getGlobalVisibleRect(new Rect()) || !this.zzc.isShown()) {
            z = true;
        }
        AudioManager audioManager = (AudioManager) this.zzc.getContext().getSystemService("audio");
        if (audioManager != null) {
            double streamVolume = (double) audioManager.getStreamVolume(3);
            double streamMaxVolume = (double) audioManager.getStreamMaxVolume(3);
            Double.isNaN(streamVolume);
            Double.isNaN(streamMaxVolume);
            d = streamVolume / streamMaxVolume;
        } else {
            d = 0.0d;
        }
        long currentTimeMillis = System.currentTimeMillis();
        zza builder2 = zzb.builder();
        builder2.queryId(str);
        builder2.eventId(str2);
        builder2.appState(str3);
        builder2.nativeTime(currentTimeMillis);
        builder2.nativeVolume(d);
        builder2.nativeViewHidden(z);
        builder2.nativeViewBounds(zzm);
        builder2.nativeViewVisibleBounds(zzm2);
        return builder2.build();
    }

    public final void zzf() {
        this.zza.zzd(this, this.zzb);
    }

    public final void zzg() {
        this.zza.zzn(this.zzb);
    }

    public final void zzh(String str, String str2) {
        this.zza.zzp(new zzff(zzfd.activityMonitor, zzfe.viewability, this.zzb, zzc(str, str2, "")));
    }

    public final void zzi() {
        Application zza2;
        if (this.zzf && (zza2 = zzgq.zza(this.zzc.getContext())) != null) {
            zzdi zzdi = new zzdi(this);
            this.zzd = zzdi;
            zza2.registerActivityLifecycleCallbacks(zzdi);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzj(boolean z) {
        this.zzf = z;
    }

    public final void zzk() {
        zzdi zzdi;
        Application zza2 = zzgq.zza(this.zzc.getContext());
        if (zza2 != null && (zzdi = this.zzd) != null) {
            zza2.unregisterActivityLifecycleCallbacks(zzdi);
        }
    }
}
