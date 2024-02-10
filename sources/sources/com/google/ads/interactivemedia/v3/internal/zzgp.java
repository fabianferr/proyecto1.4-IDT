package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.interactivemedia.v3.impl.data.zzbe;
import com.google.ads.interactivemedia.v3.impl.data.zzbf;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzgp {
    private final zzok zza;
    private final zzhc zzb;
    private final int zzc;

    public zzgp(Context context, int i, zzhc zzhc) {
        this.zza = new zzor(context);
        this.zzb = zzhc;
        this.zzc = i;
    }

    public final String zza() {
        if (this.zzc > 0) {
            try {
                Bundle bundle = new Bundle();
                zzok zzok = this.zza;
                return (String) Tasks.await(((zzor) zzok).doRead(TaskApiCall.builder().setAutoResolveMissingFeatures(false).setFeatures(zzqt.zza).run(new zzon((zzor) zzok, bundle)).build()), (long) this.zzc, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                this.zzb.zzb(zzbe.ADS_IDENTITY_TOKEN_LOADER, zzbf.GET_ADSIDENTITY_TOKEN, e);
                return "";
            }
        } else {
            zzhd.zzc("AdsIdentityTokenLoader: invalid parameter for gksTimeoutMs");
            return "";
        }
    }
}
