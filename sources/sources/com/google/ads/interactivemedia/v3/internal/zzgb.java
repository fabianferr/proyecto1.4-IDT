package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import com.google.ads.interactivemedia.v3.impl.data.NetworkRequestData;
import com.google.ads.interactivemedia.v3.impl.data.zzbc;
import com.google.ads.interactivemedia.v3.impl.data.zzbj;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzgb implements zzga {
    private final zzok zza;
    private final zzbc zzb;

    zzgb(Context context, zzbc zzbc) {
        this.zza = new zzor(context);
        this.zzb = zzbc;
    }

    public final zzbj zza(NetworkRequestData networkRequestData) {
        Task task;
        try {
            int i = networkRequestData.requestType() == NetworkRequestData.RequestType.GET ? 0 : 1;
            zzok zzok = this.zza;
            String url = networkRequestData.url();
            String content = networkRequestData.content();
            if (this.zzb.isLimitedAdTracking()) {
                task = Tasks.forException(new zzol(8));
            } else {
                task = ((zzor) zzok).doRead(TaskApiCall.builder().setFeatures(zzqt.zzb).setAutoResolveMissingFeatures(false).run(new zzom((zzor) zzok, url, i, content)).build());
            }
            return zzbj.forResponse(networkRequestData.id(), (String) Tasks.await(task, (long) (networkRequestData.connectionTimeoutMs() + networkRequestData.readTimeoutMs()), TimeUnit.MILLISECONDS));
        } catch (InterruptedException | TimeoutException unused) {
            return zzbj.forError(networkRequestData.id(), 101);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof zzol) {
                return zzbj.forError(networkRequestData.id(), ((zzol) cause).zza());
            } else if (cause instanceof ApiException) {
                return zzbj.forError(networkRequestData.id(), 102);
            } else {
                return zzbj.forError(networkRequestData.id(), 100);
            }
        }
    }
}
