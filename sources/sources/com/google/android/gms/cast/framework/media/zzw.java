package com.google.android.gms.cast.framework.media;

import com.google.android.gms.cast.framework.media.MediaQueue;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
final class zzw extends MediaQueue.Callback {
    final /* synthetic */ MediaQueueRecyclerViewAdapter zza;

    /* synthetic */ zzw(MediaQueueRecyclerViewAdapter mediaQueueRecyclerViewAdapter, zzv zzv) {
        this.zza = mediaQueueRecyclerViewAdapter;
    }

    public final void itemsInsertedInRange(int i, int i2) {
        this.zza.notifyItemRangeInserted(i, i2);
    }

    public final void itemsReloaded() {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsRemovedAtIndexes(int[] iArr) {
        int length = iArr.length;
        if (length <= 1) {
            for (int i = 0; i < length; i = 1) {
                this.zza.notifyItemRemoved(iArr[0]);
            }
            return;
        }
        this.zza.notifyDataSetChanged();
    }

    public final void itemsReorderedAtIndexes(List<Integer> list, int i) {
        this.zza.notifyDataSetChanged();
    }

    public final void itemsUpdatedAtIndexes(int[] iArr) {
        for (int notifyItemChanged : iArr) {
            this.zza.notifyItemChanged(notifyItemChanged);
        }
    }

    public final void mediaQueueChanged() {
    }

    public final void mediaQueueWillChange() {
    }
}
