package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.zzar;
import com.google.android.gms.cast.zzr;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.internal.ws.WebSocketProtocol;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzbf implements zzar {
    final /* synthetic */ RemoteMediaClient zza;
    private zzr zzb;
    private final AtomicLong zzc = new AtomicLong((CastUtils.zza() & WebSocketProtocol.PAYLOAD_SHORT_MAX) * 10000);

    public zzbf(RemoteMediaClient remoteMediaClient) {
        this.zza = remoteMediaClient;
    }

    public final long zza() {
        return this.zzc.getAndIncrement();
    }

    public final void zzb(String str, String str2, long j, String str3) {
        zzr zzr = this.zzb;
        if (zzr != null) {
            zzr.zzh(str, str2).addOnFailureListener(new zzbe(this, j));
            return;
        }
        throw new IllegalStateException("Device is not connected");
    }

    public final void zzc(zzr zzr) {
        this.zzb = zzr;
    }
}
