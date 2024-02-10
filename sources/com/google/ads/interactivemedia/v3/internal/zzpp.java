package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Base64;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.nio.ByteBuffer;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzpp {
    private final Context zza;
    private final Executor zzb;
    private final zzoy zzc;
    private final zzpa zzd;
    private final zzpo zze;
    private final zzpo zzf;
    private Task zzg;
    private Task zzh;

    zzpp(Context context, Executor executor, zzoy zzoy, zzpa zzpa, zzpm zzpm, zzpn zzpn) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzoy;
        this.zzd = zzpa;
        this.zze = zzpm;
        this.zzf = zzpn;
    }

    public static zzpp zze(Context context, Executor executor, zzoy zzoy, zzpa zzpa) {
        zzpp zzpp = new zzpp(context, executor, zzoy, zzpa, new zzpm(), new zzpn());
        if (zzpp.zzd.zzd()) {
            zzpp.zzg = zzpp.zzh(new zzpj(zzpp));
        } else {
            zzpp.zzg = Tasks.forResult(zzpp.zze.zza());
        }
        zzpp.zzh = zzpp.zzh(new zzpk(zzpp));
        return zzpp;
    }

    private static zzbc zzg(Task task, zzbc zzbc) {
        if (!task.isSuccessful()) {
            return zzbc;
        }
        return (zzbc) task.getResult();
    }

    private final Task zzh(Callable callable) {
        return Tasks.call(this.zzb, callable).addOnFailureListener(this.zzb, (OnFailureListener) new zzpl(this));
    }

    public final zzbc zza() {
        return zzg(this.zzg, this.zze.zza());
    }

    public final zzbc zzb() {
        return zzg(this.zzh, this.zzf.zza());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbc zzc() throws Exception {
        Context context = this.zza;
        zzaf zza2 = zzbc.zza();
        AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        String id = advertisingIdInfo.getId();
        if (id != null && id.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")) {
            UUID fromString = UUID.fromString(id);
            byte[] bArr = new byte[16];
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.putLong(fromString.getMostSignificantBits());
            wrap.putLong(fromString.getLeastSignificantBits());
            id = Base64.encodeToString(bArr, 11);
        }
        if (id != null) {
            zza2.zzs(id);
            zza2.zzr(advertisingIdInfo.isLimitAdTrackingEnabled());
            zza2.zzab(6);
        }
        return (zzbc) zza2.zzak();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbc zzd() throws Exception {
        Context context = this.zza;
        return zzpg.zza(context, context.getPackageName(), Integer.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(Exception exc) {
        if (exc instanceof InterruptedException) {
            Thread.currentThread().interrupt();
        }
        this.zzc.zzc(2025, -1, exc);
    }
}
