package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.internal.zzao;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzar extends zzbk {
    final /* synthetic */ int zza;
    final /* synthetic */ int zzb;
    final /* synthetic */ JSONObject zzc;
    final /* synthetic */ RemoteMediaClient zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzar(RemoteMediaClient remoteMediaClient, int i, int i2, JSONObject jSONObject) {
        super(remoteMediaClient, false);
        this.zzd = remoteMediaClient;
        this.zza = i;
        this.zzb = i2;
        this.zzc = jSONObject;
    }

    /* access modifiers changed from: protected */
    public final void zza() throws zzao {
        MediaQueueItem queueItem;
        RemoteMediaClient remoteMediaClient = this.zzd;
        int i = this.zza;
        Preconditions.checkMainThread("Must be called from the main thread.");
        int indexOfItemWithId = remoteMediaClient.getMediaQueue().indexOfItemWithId(i);
        if (indexOfItemWithId == -1) {
            MediaStatus mediaStatus = (MediaStatus) Preconditions.checkNotNull(remoteMediaClient.getMediaStatus());
            indexOfItemWithId = 0;
            while (true) {
                if (indexOfItemWithId < mediaStatus.getQueueItemCount()) {
                    if (((MediaQueueItem) Preconditions.checkNotNull(mediaStatus.getQueueItem(indexOfItemWithId))).getItemId() == i) {
                        break;
                    }
                    indexOfItemWithId++;
                } else {
                    indexOfItemWithId = -1;
                    break;
                }
            }
        }
        int i2 = this.zzb;
        if (i2 < 0) {
            setResult(new zzbj(this, new Status(2001, String.format(Locale.ROOT, "Invalid request: Invalid newIndex %d.", new Object[]{Integer.valueOf(this.zzb)}))));
        } else if (indexOfItemWithId == i2) {
            setResult(new zzbj(this, new Status(0)));
        } else {
            if (i2 > indexOfItemWithId) {
                i2++;
            }
            RemoteMediaClient remoteMediaClient2 = this.zzd;
            Preconditions.checkMainThread("Must be called from the main thread.");
            int itemIdAtIndex = remoteMediaClient2.getMediaQueue().itemIdAtIndex(i2);
            if (itemIdAtIndex == 0) {
                MediaStatus mediaStatus2 = remoteMediaClient2.getMediaStatus();
                if (mediaStatus2 == null || (queueItem = mediaStatus2.getQueueItem(i2)) == null) {
                    itemIdAtIndex = 0;
                } else {
                    itemIdAtIndex = queueItem.getItemId();
                }
            }
            this.zzd.zze.zzz(zzb(), new int[]{this.zza}, itemIdAtIndex, this.zzc);
        }
    }
}
