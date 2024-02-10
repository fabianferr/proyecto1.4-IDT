package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProgressiveMediaSource$Factory$$ExternalSyntheticLambda1 implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager f$0;

    public /* synthetic */ ProgressiveMediaSource$Factory$$ExternalSyntheticLambda1(DrmSessionManager drmSessionManager) {
        this.f$0 = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return ProgressiveMediaSource.Factory.lambda$setDrmSessionManager$2(this.f$0, mediaItem);
    }
}
