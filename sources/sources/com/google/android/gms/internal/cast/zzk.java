package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzk {
    /* access modifiers changed from: private */
    public static final Logger zza = new Logger("ApplicationAnalytics");
    /* access modifiers changed from: private */
    public final zzf zzb;
    /* access modifiers changed from: private */
    public final zzm zzc;
    private final zzh zzd = new zzh(this);
    private final Runnable zze = new zzg(this);
    private final Handler zzf = new zzdy(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public final SharedPreferences zzg;
    /* access modifiers changed from: private */
    public zzl zzh;
    /* access modifiers changed from: private */
    public CastSession zzi;
    private boolean zzj;
    /* access modifiers changed from: private */
    public boolean zzk;

    public zzk(SharedPreferences sharedPreferences, zzf zzf2, Bundle bundle, String str) {
        this.zzg = sharedPreferences;
        this.zzb = zzf2;
        this.zzc = new zzm(bundle, str);
    }

    public static /* synthetic */ void zzg(zzk zzk2) {
        zzl zzl = zzk2.zzh;
        if (zzl != null) {
            zzk2.zzb.zzd(zzk2.zzc.zza(zzl), 223);
        }
        zzk2.zzw();
    }

    static /* bridge */ /* synthetic */ void zzn(zzk zzk2, int i) {
        zza.d("log session ended with error = %d", Integer.valueOf(i));
        zzk2.zzu();
        zzk2.zzb.zzd(zzk2.zzc.zze(zzk2.zzh, i), 228);
        zzk2.zzt();
        if (!zzk2.zzk) {
            zzk2.zzh = null;
        }
    }

    static /* bridge */ /* synthetic */ void zzo(zzk zzk2, SharedPreferences sharedPreferences, String str) {
        boolean z = false;
        if (zzk2.zzz(str)) {
            zza.d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzk2.zzh);
            return;
        }
        zzk2.zzh = zzl.zzb(sharedPreferences);
        if (zzk2.zzz(str)) {
            zza.d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzk2.zzh);
            zzl.zza = zzk2.zzh.zzd + 1;
            return;
        }
        zza.d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzl zza2 = zzl.zza(zzk2.zzj);
        zzk2.zzh = zza2;
        zzl zzl = (zzl) Preconditions.checkNotNull(zza2);
        CastSession castSession = zzk2.zzi;
        if (castSession != null && castSession.zzj()) {
            z = true;
        }
        zzl.zzj = z;
        ((zzl) Preconditions.checkNotNull(zzk2.zzh)).zzb = zzs();
        ((zzl) Preconditions.checkNotNull(zzk2.zzh)).zzf = str;
    }

    static /* bridge */ /* synthetic */ void zzr(zzk zzk2, boolean z) {
        Logger logger = zza;
        Object[] objArr = new Object[1];
        objArr[0] = true != z ? "foreground" : "background";
        logger.d("update app visibility to %s", objArr);
        zzk2.zzj = z;
        zzl zzl = zzk2.zzh;
        if (zzl != null) {
            zzl.zzi = z;
        }
    }

    @Pure
    private static String zzs() {
        return ((CastContext) Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    /* access modifiers changed from: private */
    public final void zzt() {
        this.zzf.removeCallbacks(this.zze);
    }

    /* access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzu() {
        if (zzy()) {
            CastSession castSession = this.zzi;
            CastDevice castDevice = castSession != null ? castSession.getCastDevice() : null;
            if (castDevice != null && !TextUtils.equals(this.zzh.zzc, castDevice.zzc())) {
                zzx(castDevice);
            }
            Preconditions.checkNotNull(this.zzh);
            return;
        }
        zza.w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
        zzv();
    }

    /* access modifiers changed from: private */
    @EnsuresNonNull({"analyticsSession"})
    public final void zzv() {
        CastDevice castDevice;
        int i = 0;
        zza.d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzl zza2 = zzl.zza(this.zzj);
        this.zzh = zza2;
        zzl zzl = (zzl) Preconditions.checkNotNull(zza2);
        CastSession castSession = this.zzi;
        zzl.zzj = castSession != null && castSession.zzj();
        ((zzl) Preconditions.checkNotNull(this.zzh)).zzb = zzs();
        CastSession castSession2 = this.zzi;
        if (castSession2 == null) {
            castDevice = null;
        } else {
            castDevice = castSession2.getCastDevice();
        }
        if (castDevice != null) {
            zzx(castDevice);
        }
        zzl zzl2 = (zzl) Preconditions.checkNotNull(this.zzh);
        CastSession castSession3 = this.zzi;
        if (castSession3 != null) {
            i = castSession3.zzk();
        }
        zzl2.zzk = i;
        Preconditions.checkNotNull(this.zzh);
    }

    /* access modifiers changed from: private */
    public final void zzw() {
        ((Handler) Preconditions.checkNotNull(this.zzf)).postDelayed((Runnable) Preconditions.checkNotNull(this.zze), 300000);
    }

    private final void zzx(CastDevice castDevice) {
        zzl zzl = this.zzh;
        if (zzl != null) {
            zzl.zzc = castDevice.zzc();
            zzl.zzg = castDevice.zza();
            zzl.zzh = castDevice.getModelName();
        }
    }

    @EnsuresNonNullIf(expression = {"analyticsSession"}, result = true)
    private final boolean zzy() {
        String str;
        if (this.zzh == null) {
            zza.d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzs = zzs();
        if (zzs == null || (str = this.zzh.zzb) == null || !TextUtils.equals(str, zzs)) {
            zza.d("The analytics session doesn't match the application ID %s", zzs);
            return false;
        }
        Preconditions.checkNotNull(this.zzh);
        return true;
    }

    private final boolean zzz(String str) {
        String str2;
        if (!zzy()) {
            return false;
        }
        Preconditions.checkNotNull(this.zzh);
        if (str != null && (str2 = this.zzh.zzf) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        zza.d("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }

    public final zzh zzc() {
        return this.zzd;
    }
}
