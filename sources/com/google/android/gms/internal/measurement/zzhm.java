package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.1.1 */
final class zzhm implements zzhj {
    private static zzhm zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzhm() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzhm(Context context) {
        this.zzb = context;
        zzhl zzhl = new zzhl(this, (Handler) null);
        this.zzc = zzhl;
        context.getContentResolver().registerContentObserver(zzgz.zza, true, zzhl);
    }

    static zzhm zza(Context context) {
        zzhm zzhm;
        synchronized (zzhm.class) {
            if (zza == null) {
                zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhm(context) : new zzhm();
            }
            zzhm = zza;
        }
        return zzhm;
    }

    static synchronized void zze() {
        Context context;
        synchronized (zzhm.class) {
            zzhm zzhm = zza;
            if (!(zzhm == null || (context = zzhm.zzb) == null || zzhm.zzc == null)) {
                context.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    @Nullable
    /* renamed from: zzc */
    public final String zzb(String str) {
        Context context = this.zzb;
        if (context != null && !zzha.zza(context)) {
            try {
                return (String) zzhh.zza(new zzhk(this, str));
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzd(String str) {
        return zzgz.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
