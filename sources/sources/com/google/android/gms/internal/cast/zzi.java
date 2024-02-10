package com.google.android.gms.internal.cast;

import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.framework.Session;
import com.google.android.gms.cast.framework.SessionManagerListener;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public final class zzi implements SessionManagerListener {
    final /* synthetic */ zzk zza;

    public zzi(zzk zzk) {
        this.zza = zzk;
    }

    public final /* bridge */ /* synthetic */ void onSessionEnded(Session session, int i) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i);
    }

    public final /* synthetic */ void onSessionEnding(Session session) {
        this.zza.zzi = (CastSession) session;
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(Session session, int i) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i);
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(Session session, boolean z) {
        zzk.zza.d("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z));
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzb(zzk.zzh, z), 227);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzw();
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(Session session, String str) {
        zzk.zza.d("onSessionResuming with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        zzk zzk = this.zza;
        zzk.zzo(zzk, zzk.zzg, str);
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk2 = this.zza;
        this.zza.zzb.zzd(zzk2.zzc.zzc(zzk2.zzh), 226);
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(Session session, int i) {
        this.zza.zzi = (CastSession) session;
        zzk.zzn(this.zza, i);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(Session session, String str) {
        zzk.zza.d("onSessionStarted with sessionId = %s", str);
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        zzk zzk = this.zza;
        zzk.zzh.zzf = str;
        this.zza.zzb.zzd(zzk.zzc.zza(zzk.zzh), 222);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzw();
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(Session session) {
        zzk.zza.d("onSessionStarting", new Object[0]);
        this.zza.zzi = (CastSession) session;
        if (this.zza.zzh != null) {
            zzk.zza.w("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        this.zza.zzv();
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zzd(zzk.zzh), 221);
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(Session session, int i) {
        zzk.zza.d("onSessionSuspended with reason = %d", Integer.valueOf(i));
        this.zza.zzi = (CastSession) session;
        this.zza.zzu();
        Preconditions.checkNotNull(this.zza.zzh);
        zzk zzk = this.zza;
        this.zza.zzb.zzd(zzk.zzc.zze(zzk.zzh, i), 225);
        this.zza.zzh.zzc(this.zza.zzg);
        this.zza.zzt();
    }
}
