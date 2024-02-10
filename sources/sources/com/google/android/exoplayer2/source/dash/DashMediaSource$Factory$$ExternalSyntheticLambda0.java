package com.google.android.exoplayer2.source.dash;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.dash.DashMediaSource;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DashMediaSource$Factory$$ExternalSyntheticLambda0 implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager f$0;

    public /* synthetic */ DashMediaSource$Factory$$ExternalSyntheticLambda0(DrmSessionManager drmSessionManager) {
        this.f$0 = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return DashMediaSource.Factory.lambda$setDrmSessionManager$0(this.f$0, mediaItem);
    }
}
