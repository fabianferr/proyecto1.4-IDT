package com.google.android.exoplayer2.source.smoothstreaming;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SsMediaSource$Factory$$ExternalSyntheticLambda0 implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager f$0;

    public /* synthetic */ SsMediaSource$Factory$$ExternalSyntheticLambda0(DrmSessionManager drmSessionManager) {
        this.f$0 = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return SsMediaSource.Factory.lambda$setDrmSessionManager$0(this.f$0, mediaItem);
    }
}
