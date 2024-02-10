package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzph implements BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {
    protected final zzpt zza;
    private final String zzb;
    private final String zzc;
    private final LinkedBlockingQueue zzd;
    private final HandlerThread zze;
    private final zzoy zzf;
    private final long zzg = System.currentTimeMillis();
    private final int zzh;

    public zzph(Context context, int i, int i2, String str, String str2, String str3, zzoy zzoy) {
        this.zzb = str;
        this.zzh = i2;
        this.zzc = str2;
        this.zzf = zzoy;
        HandlerThread handlerThread = new HandlerThread("GassDGClient");
        this.zze = handlerThread;
        handlerThread.start();
        zzpt zzpt = new zzpt(context, handlerThread.getLooper(), this, this, 19621000);
        this.zza = zzpt;
        this.zzd = new LinkedBlockingQueue();
        zzpt.checkAvailabilityAndConnect();
    }

    static zzqf zza() {
        return new zzqf((byte[]) null, 1);
    }

    private final void zze(int i, long j, Exception exc) {
        this.zzf.zzc(i, System.currentTimeMillis() - j, exc);
    }

    public final void onConnected(Bundle bundle) {
        zzpy zzd2 = zzd();
        if (zzd2 != null) {
            try {
                zzqf zzf2 = zzd2.zzf(new zzqd(1, this.zzh, this.zzb, this.zzc));
                zze(IronSourceConstants.errorCode_internal, this.zzg, (Exception) null);
                this.zzd.put(zzf2);
            } catch (Throwable th) {
                zzc();
                this.zze.quit();
                throw th;
            }
            zzc();
            this.zze.quit();
        }
    }

    public final void onConnectionFailed(ConnectionResult connectionResult) {
        try {
            zze(4012, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final void onConnectionSuspended(int i) {
        try {
            zze(4011, this.zzg, (Exception) null);
            this.zzd.put(zza());
        } catch (InterruptedException unused) {
        }
    }

    public final zzqf zzb(int i) {
        zzqf zzqf;
        try {
            zzqf = (zzqf) this.zzd.poll(50000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            zze(2009, this.zzg, e);
            zzqf = null;
        }
        zze(3004, this.zzg, (Exception) null);
        if (zzqf != null) {
            if (zzqf.zzc == 7) {
                zzoy.zzg(3);
            } else {
                zzoy.zzg(2);
            }
        }
        return zzqf == null ? zza() : zzqf;
    }

    public final void zzc() {
        zzpt zzpt = this.zza;
        if (zzpt == null) {
            return;
        }
        if (zzpt.isConnected() || this.zza.isConnecting()) {
            this.zza.disconnect();
        }
    }

    /* access modifiers changed from: protected */
    public final zzpy zzd() {
        try {
            return this.zza.zzp();
        } catch (DeadObjectException | IllegalStateException unused) {
            return null;
        }
    }
}
