package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.cast.internal.zzw;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzdc extends zzdp {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaPlayer zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzdc(RemoteMediaPlayer remoteMediaPlayer, GoogleApiClient googleApiClient, int i, int i2, JSONObject jSONObject) {
        super(remoteMediaPlayer, googleApiClient);
        this.zzd = remoteMediaPlayer;
        this.zza = i;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) throws zzao {
        int zza2 = RemoteMediaPlayer.zza(this.zzd, this.zza);
        if (zza2 == -1) {
            setResult(new zzdo(this, new Status(0)));
            return;
        }
        int i = this.zzb;
        if (i < 0) {
            setResult(new zzdo(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(this.zzb)}))));
        } else if (zza2 == i) {
            setResult(new zzdo(this, new Status(0)));
        } else {
            MediaStatus mediaStatus = this.zzd.getMediaStatus();
            if (mediaStatus == null) {
                setResult(new zzdo(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid MediaStatus", new Object[0]))));
                return;
            }
            int i2 = this.zzb;
            if (i2 > zza2) {
                i2++;
            }
            MediaQueueItem queueItem = mediaStatus.getQueueItem(i2);
            this.zzd.zzb.zzz(zzb(), new int[]{this.zza}, queueItem != null ? queueItem.getItemId() : 0, this.zzc);
        }
    }
}
