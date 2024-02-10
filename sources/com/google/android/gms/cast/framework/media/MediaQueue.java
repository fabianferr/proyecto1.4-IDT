package com.google.android.gms.cast.framework.media;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import android.util.SparseIntArray;
import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzdy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimerTask;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class MediaQueue {
    long zza;
    List zzb;
    final SparseIntArray zzc;
    LruCache zzd;
    final List zze;
    final Deque zzf;
    /* access modifiers changed from: private */
    public final Logger zzg = new Logger("MediaQueue");
    private final RemoteMediaClient zzh;
    private final int zzi;
    private final Handler zzj;
    private final TimerTask zzk;
    private PendingResult zzl;
    private PendingResult zzm;
    private final Set zzn = Collections.synchronizedSet(new HashSet());

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public static abstract class Callback {
        public void itemsInsertedInRange(int i, int i2) {
        }

        public void itemsReloaded() {
        }

        public void itemsRemovedAtIndexes(int[] iArr) {
        }

        public void itemsReorderedAtIndexes(List<Integer> list, int i) {
        }

        public void itemsUpdatedAtIndexes(int[] iArr) {
        }

        public void mediaQueueChanged() {
        }

        public void mediaQueueWillChange() {
        }
    }

    MediaQueue(RemoteMediaClient remoteMediaClient, int i, int i2) {
        this.zzh = remoteMediaClient;
        this.zzi = Math.max(20, 1);
        this.zzb = new ArrayList();
        this.zzc = new SparseIntArray();
        this.zze = new ArrayList();
        this.zzf = new ArrayDeque(20);
        this.zzj = new zzdy(Looper.getMainLooper());
        this.zzk = new zzq(this);
        remoteMediaClient.registerCallback(new zzs(this));
        zzt(20);
        this.zza = zzp();
        zzo();
    }

    static /* bridge */ /* synthetic */ void zze(MediaQueue mediaQueue, int i, int i2) {
        synchronized (mediaQueue.zzn) {
            for (Callback itemsInsertedInRange : mediaQueue.zzn) {
                itemsInsertedInRange.itemsInsertedInRange(i, i2);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzf(MediaQueue mediaQueue, int[] iArr) {
        synchronized (mediaQueue.zzn) {
            for (Callback itemsRemovedAtIndexes : mediaQueue.zzn) {
                itemsRemovedAtIndexes.itemsRemovedAtIndexes(iArr);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzg(MediaQueue mediaQueue, List list, int i) {
        synchronized (mediaQueue.zzn) {
            for (Callback itemsReorderedAtIndexes : mediaQueue.zzn) {
                itemsReorderedAtIndexes.itemsReorderedAtIndexes(list, i);
            }
        }
    }

    static /* bridge */ /* synthetic */ void zzj(MediaQueue mediaQueue) {
        if (!mediaQueue.zzf.isEmpty() && mediaQueue.zzl == null && mediaQueue.zza != 0) {
            PendingResult zzj2 = mediaQueue.zzh.zzj(CastUtils.zzf(mediaQueue.zzf));
            mediaQueue.zzl = zzj2;
            zzj2.setResultCallback(new zzp(mediaQueue));
            mediaQueue.zzf.clear();
        }
    }

    static /* bridge */ /* synthetic */ void zzk(MediaQueue mediaQueue) {
        mediaQueue.zzc.clear();
        for (int i = 0; i < mediaQueue.zzb.size(); i++) {
            mediaQueue.zzc.put(((Integer) mediaQueue.zzb.get(i)).intValue(), i);
        }
    }

    /* access modifiers changed from: private */
    public final long zzp() {
        MediaStatus mediaStatus = this.zzh.getMediaStatus();
        if (mediaStatus == null || mediaStatus.zzd()) {
            return 0;
        }
        return mediaStatus.zzb();
    }

    private final void zzq() {
        this.zzj.removeCallbacks(this.zzk);
    }

    private final void zzr() {
        PendingResult pendingResult = this.zzm;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzm = null;
        }
    }

    private final void zzs() {
        PendingResult pendingResult = this.zzl;
        if (pendingResult != null) {
            pendingResult.cancel();
            this.zzl = null;
        }
    }

    private final void zzt(int i) {
        this.zzd = new zzr(this, i);
    }

    /* access modifiers changed from: private */
    public final void zzu() {
        synchronized (this.zzn) {
            for (Callback mediaQueueChanged : this.zzn) {
                mediaQueueChanged.mediaQueueChanged();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        synchronized (this.zzn) {
            for (Callback itemsReloaded : this.zzn) {
                itemsReloaded.itemsReloaded();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzw(int[] iArr) {
        synchronized (this.zzn) {
            for (Callback itemsUpdatedAtIndexes : this.zzn) {
                itemsUpdatedAtIndexes.itemsUpdatedAtIndexes(iArr);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzx() {
        synchronized (this.zzn) {
            for (Callback mediaQueueWillChange : this.zzn) {
                mediaQueueWillChange.mediaQueueWillChange();
            }
        }
    }

    private final void zzy() {
        zzq();
        this.zzj.postDelayed(this.zzk, 500);
    }

    public PendingResult<RemoteMediaClient.MediaChannelResult> fetchMoreItemsRelativeToIndex(int i, int i2, int i3) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza == 0) {
            return RemoteMediaClient.zzf(2100, "No active media session");
        }
        int itemIdAtIndex = itemIdAtIndex(i);
        if (itemIdAtIndex == 0) {
            return RemoteMediaClient.zzf(2001, "index out of bound");
        }
        return this.zzh.zzh(itemIdAtIndex, i2, i3);
    }

    public MediaQueueItem getItemAtIndex(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return getItemAtIndex(i, true);
    }

    public int getItemCount() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzb.size();
    }

    public int[] getItemIds() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return CastUtils.zzf(this.zzb);
    }

    public int indexOfItemWithId(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        return this.zzc.get(i, -1);
    }

    public int itemIdAtIndex(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i < 0 || i >= this.zzb.size()) {
            return 0;
        }
        return ((Integer) this.zzb.get(i)).intValue();
    }

    public void registerCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.add(callback);
    }

    public void setCacheCapacity(int i) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        LruCache lruCache = this.zzd;
        ArrayList arrayList = new ArrayList();
        zzt(i);
        int size = lruCache.size();
        for (Map.Entry entry : lruCache.snapshot().entrySet()) {
            if (size > i) {
                int i2 = this.zzc.get(((Integer) entry.getKey()).intValue(), -1);
                if (i2 != -1) {
                    arrayList.add(Integer.valueOf(i2));
                }
            } else {
                this.zzd.put((Integer) entry.getKey(), (MediaQueueItem) entry.getValue());
            }
            size--;
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList);
            zzx();
            zzw(CastUtils.zzf(arrayList));
            zzu();
        }
    }

    public void unregisterCallback(Callback callback) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        this.zzn.remove(callback);
    }

    public final void zzl() {
        zzx();
        this.zzb.clear();
        this.zzc.clear();
        this.zzd.evictAll();
        this.zze.clear();
        zzq();
        this.zzf.clear();
        zzr();
        zzs();
        zzv();
        zzu();
    }

    /* access modifiers changed from: package-private */
    public final void zzm(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue item ids, statusCode=%s, statusMessage=%s", new Object[]{Integer.valueOf(statusCode), status.getStatusMessage()}), new Object[0]);
        }
        this.zzm = null;
        if (!this.zzf.isEmpty()) {
            zzy();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzn(RemoteMediaClient.MediaChannelResult mediaChannelResult) {
        Status status = mediaChannelResult.getStatus();
        int statusCode = status.getStatusCode();
        if (statusCode != 0) {
            this.zzg.w(String.format("Error fetching queue items, statusCode=%s, statusMessage=%s", new Object[]{Integer.valueOf(statusCode), status.getStatusMessage()}), new Object[0]);
        }
        this.zzl = null;
        if (!this.zzf.isEmpty()) {
            zzy();
        }
    }

    public final void zzo() {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (this.zza != 0 && this.zzm == null) {
            zzr();
            zzs();
            PendingResult zzi2 = this.zzh.zzi();
            this.zzm = zzi2;
            zzi2.setResultCallback(new zzo(this));
        }
    }

    public MediaQueueItem getItemAtIndex(int i, boolean z) {
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (i < 0 || i >= this.zzb.size()) {
            return null;
        }
        int intValue = ((Integer) this.zzb.get(i)).intValue();
        LruCache lruCache = this.zzd;
        Integer valueOf = Integer.valueOf(intValue);
        MediaQueueItem mediaQueueItem = (MediaQueueItem) lruCache.get(valueOf);
        if (mediaQueueItem == null && z && !this.zzf.contains(valueOf)) {
            while (this.zzf.size() >= this.zzi) {
                this.zzf.removeFirst();
            }
            this.zzf.add(Integer.valueOf(intValue));
            zzy();
        }
        return mediaQueueItem;
    }
}
