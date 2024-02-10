package com.google.android.gms.cast.framework;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.Cast;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.cast.framework.media.NotificationOptions;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.framework.media.internal.zzv;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzaq;
import com.google.android.gms.cast.zzbb;
import com.google.android.gms.cast.zzbc;
import com.google.android.gms.cast.zzbh;
import com.google.android.gms.cast.zzbt;
import com.google.android.gms.cast.zzr;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzaf;
import com.google.android.gms.internal.cast.zzbf;
import com.google.android.gms.internal.cast.zzbr;
import com.google.android.gms.tasks.Task;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class CastSession extends Session {
    public static final /* synthetic */ int zza = 0;
    /* access modifiers changed from: private */
    public static final Logger zzb = new Logger("CastSession");
    private final Context zzc;
    /* access modifiers changed from: private */
    public final Set zzd = new HashSet();
    /* access modifiers changed from: private */
    public final zzac zze;
    private final CastOptions zzf;
    private final zzbf zzg;
    private final zzv zzh;
    /* access modifiers changed from: private */
    public zzr zzi;
    /* access modifiers changed from: private */
    public RemoteMediaClient zzj;
    private CastDevice zzk;
    private Cast.ApplicationConnectionResult zzl;
    private final zzi zzm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CastSession(Context context, String str, String str2, CastOptions castOptions, zzbf zzbf, zzv zzv) {
        super(context, str, str2);
        zzi zzi2 = zzi.zza;
        this.zzc = context.getApplicationContext();
        this.zzf = castOptions;
        this.zzg = zzbf;
        this.zzh = zzv;
        this.zzm = zzi2;
        this.zze = zzaf.zzb(context, castOptions, zzl(), new zzm(this, (zzl) null));
    }

    static /* bridge */ /* synthetic */ void zzg(CastSession castSession, int i) {
        castSession.zzh.zzi(i);
        zzr zzr = castSession.zzi;
        if (zzr != null) {
            zzr.zzf();
            castSession.zzi = null;
        }
        castSession.zzk = null;
        RemoteMediaClient remoteMediaClient = castSession.zzj;
        if (remoteMediaClient != null) {
            remoteMediaClient.zzr((zzr) null);
            castSession.zzj = null;
        }
        castSession.zzl = null;
    }

    static /* bridge */ /* synthetic */ void zzh(CastSession castSession, String str, Task task) {
        if (castSession.zze != null) {
            try {
                if (task.isSuccessful()) {
                    Cast.ApplicationConnectionResult applicationConnectionResult = (Cast.ApplicationConnectionResult) task.getResult();
                    castSession.zzl = applicationConnectionResult;
                    if (applicationConnectionResult.getStatus() != null && applicationConnectionResult.getStatus().isSuccess()) {
                        zzb.d("%s() -> success result", str);
                        RemoteMediaClient remoteMediaClient = new RemoteMediaClient(new zzaq((String) null));
                        castSession.zzj = remoteMediaClient;
                        remoteMediaClient.zzr(castSession.zzi);
                        castSession.zzj.zzp();
                        castSession.zzh.zzh(castSession.zzj, castSession.getCastDevice());
                        castSession.zze.zzf((ApplicationMetadata) Preconditions.checkNotNull(applicationConnectionResult.getApplicationMetadata()), applicationConnectionResult.getApplicationStatus(), (String) Preconditions.checkNotNull(applicationConnectionResult.getSessionId()), applicationConnectionResult.getWasLaunched());
                        return;
                    } else if (applicationConnectionResult.getStatus() != null) {
                        zzb.d("%s() -> failure result", str);
                        castSession.zze.zzg(applicationConnectionResult.getStatus().getStatusCode());
                        return;
                    }
                } else {
                    Exception exception = task.getException();
                    if (exception instanceof ApiException) {
                        castSession.zze.zzg(((ApiException) exception).getStatusCode());
                        return;
                    }
                }
                castSession.zze.zzg(2476);
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                zzb.d(e, "Unable to call %s on %s.", "methods", "zzac");
            }
        }
    }

    private final void zzm(Bundle bundle) {
        CastMediaOptions castMediaOptions;
        NotificationOptions notificationOptions;
        CastDevice fromBundle = CastDevice.getFromBundle(bundle);
        this.zzk = fromBundle;
        if (fromBundle != null) {
            zzr zzr = this.zzi;
            if (zzr != null) {
                zzr.zzf();
                this.zzi = null;
            }
            boolean z = true;
            zzb.d("Acquiring a connection to Google Play Services for %s", this.zzk);
            CastDevice castDevice = (CastDevice) Preconditions.checkNotNull(this.zzk);
            Bundle bundle2 = new Bundle();
            CastOptions castOptions = this.zzf;
            if (castOptions == null) {
                castMediaOptions = null;
            } else {
                castMediaOptions = castOptions.getCastMediaOptions();
            }
            if (castMediaOptions == null) {
                notificationOptions = null;
            } else {
                notificationOptions = castMediaOptions.getNotificationOptions();
            }
            boolean z2 = castMediaOptions != null && castMediaOptions.zza();
            if (notificationOptions == null) {
                z = false;
            }
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_FRAMEWORK_NOTIFICATION_ENABLED", z);
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_REMOTE_CONTROL_NOTIFICATION_ENABLED", z2);
            bundle2.putBoolean("com.google.android.gms.cast.EXTRA_CAST_ALWAYS_FOLLOW_SESSION_ENABLED", this.zzg.zzs());
            Cast.CastOptions.Builder builder = new Cast.CastOptions.Builder(castDevice, new zzo(this, (zzn) null));
            builder.zzc(bundle2);
            zzr zza2 = Cast.zza(this.zzc, builder.build());
            zza2.zzk(new zzq(this, (zzp) null));
            this.zzi = zza2;
            zza2.zze();
        } else if (isResuming()) {
            notifyFailedToResumeSession(2153);
        } else {
            notifyFailedToStartSession(2151);
        }
    }

    public void addCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.add(listener);
        }
    }

    /* access modifiers changed from: protected */
    public void end(boolean z) {
        zzac zzac = this.zze;
        if (zzac != null) {
            try {
                zzac.zze(z, 0);
            } catch (RemoteException e) {
                Class<zzac> cls = zzac.class;
                zzb.d(e, "Unable to call %s on %s.", "disconnectFromDevice", "zzac");
            }
            notifySessionEnded(0);
        }
    }

    public int getActiveInputState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null || !zzr.zzl()) {
            return -1;
        }
        return zzr.zzb();
    }

    public Cast.ApplicationConnectionResult getApplicationConnectionResult() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzl;
    }

    public ApplicationMetadata getApplicationMetadata() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null || !zzr.zzl()) {
            return null;
        }
        return zzr.zzd();
    }

    public String getApplicationStatus() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null || !zzr.zzl()) {
            return null;
        }
        return zzr.zzj();
    }

    @Pure
    public CastDevice getCastDevice() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzk;
    }

    public RemoteMediaClient getRemoteMediaClient() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzj;
    }

    public long getSessionRemainingTimeMs() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        RemoteMediaClient remoteMediaClient = this.zzj;
        if (remoteMediaClient == null) {
            return 0;
        }
        return remoteMediaClient.getStreamDuration() - this.zzj.getApproximateStreamPosition();
    }

    public int getStandbyState() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null || !zzr.zzl()) {
            return -1;
        }
        return zzr.zzc();
    }

    public double getVolume() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null || !zzr.zzl()) {
            return 0.0d;
        }
        return zzr.zza();
    }

    public boolean isMute() throws IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        return zzr != null && zzr.zzl() && zzr.zzm();
    }

    /* access modifiers changed from: protected */
    public void onResuming(Bundle bundle) {
        this.zzk = CastDevice.getFromBundle(bundle);
    }

    /* access modifiers changed from: protected */
    public void onStarting(Bundle bundle) {
        this.zzk = CastDevice.getFromBundle(bundle);
    }

    public void removeCastListener(Cast.Listener listener) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (listener != null) {
            this.zzd.remove(listener);
        }
    }

    public void removeMessageReceivedCallbacks(String str) throws IOException, IllegalArgumentException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr != null) {
            zzr.zzg(str);
        }
    }

    public void requestStatus() throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr != null) {
            ((zzbt) zzr).doWrite(TaskApiCall.builder().run(zzbb.zza).setMethodKey(8404).build());
        }
    }

    /* access modifiers changed from: protected */
    public void resume(Bundle bundle) {
        zzm(bundle);
    }

    public PendingResult<Status> sendMessage(String str, String str2) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr == null) {
            return PendingResults.immediatePendingResult(new Status(17));
        }
        return zzbr.zza(zzr.zzh(str, str2), zzg.zza, zzh.zza);
    }

    public void setMessageReceivedCallbacks(String str, Cast.MessageReceivedCallback messageReceivedCallback) throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr != null && zzr.zzl()) {
            zzr.zzi(str, messageReceivedCallback);
        }
    }

    public void setMute(boolean z) throws IOException, IllegalStateException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr != null && zzr.zzl()) {
            zzbt zzbt = (zzbt) zzr;
            zzbt.doWrite(TaskApiCall.builder().run(new zzbc(zzbt, z)).setMethodKey(8412).build());
        }
    }

    public void setVolume(double d) throws IOException {
        Preconditions.checkMainThread("Must be called from the main thread.");
        zzr zzr = this.zzi;
        if (zzr != null && zzr.zzl()) {
            if (Double.isInfinite(d) || Double.isNaN(d)) {
                throw new IllegalArgumentException("Volume cannot be " + d);
            }
            zzbt zzbt = (zzbt) zzr;
            zzbt.doWrite(TaskApiCall.builder().run(new zzbh(zzbt, d)).setMethodKey(8411).build());
        }
    }

    /* access modifiers changed from: protected */
    public void start(Bundle bundle) {
        zzm(bundle);
    }

    public final zzv zzd() {
        return this.zzh;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        r0 = r5.zzk;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(android.os.Bundle r6) {
        /*
            r5 = this;
            com.google.android.gms.cast.CastDevice r6 = com.google.android.gms.cast.CastDevice.getFromBundle(r6)
            if (r6 == 0) goto L_0x006e
            com.google.android.gms.cast.CastDevice r0 = r5.zzk
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L_0x006e
            java.lang.String r0 = r6.getFriendlyName()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x002e
            com.google.android.gms.cast.CastDevice r0 = r5.zzk
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = r0.getFriendlyName()
            java.lang.String r3 = r6.getFriendlyName()
            boolean r0 = android.text.TextUtils.equals(r0, r3)
            if (r0 != 0) goto L_0x002e
        L_0x002c:
            r0 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            r5.zzk = r6
            com.google.android.gms.cast.internal.Logger r3 = zzb
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r1] = r6
            if (r2 == r0) goto L_0x003d
            java.lang.String r6 = "unchanged"
            goto L_0x003f
        L_0x003d:
            java.lang.String r6 = "changed"
        L_0x003f:
            r4[r2] = r6
            java.lang.String r6 = "update to device (%s) with name %s"
            r3.d(r6, r4)
            if (r0 == 0) goto L_0x006e
            com.google.android.gms.cast.CastDevice r6 = r5.zzk
            if (r6 == 0) goto L_0x006e
            com.google.android.gms.cast.framework.media.internal.zzv r0 = r5.zzh
            if (r0 == 0) goto L_0x0053
            r0.zzk(r6)
        L_0x0053:
            java.util.HashSet r6 = new java.util.HashSet
            java.util.Set r0 = r5.zzd
            r6.<init>(r0)
            java.util.Iterator r6 = r6.iterator()
        L_0x005e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x006e
            java.lang.Object r0 = r6.next()
            com.google.android.gms.cast.Cast$Listener r0 = (com.google.android.gms.cast.Cast.Listener) r0
            r0.onDeviceNameChanged()
            goto L_0x005e
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.CastSession.zzi(android.os.Bundle):void");
    }

    public final boolean zzj() {
        return this.zzg.zzs();
    }
}
