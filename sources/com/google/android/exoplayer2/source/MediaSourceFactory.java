package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import java.util.List;

public interface MediaSourceFactory {
    @Deprecated
    MediaSource createMediaSource(Uri uri);

    MediaSource createMediaSource(MediaItem mediaItem);

    int[] getSupportedTypes();

    @Deprecated
    MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory);

    @Deprecated
    MediaSourceFactory setDrmSessionManager(DrmSessionManager drmSessionManager);

    MediaSourceFactory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider);

    @Deprecated
    MediaSourceFactory setDrmUserAgent(String str);

    MediaSourceFactory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy);

    @Deprecated
    MediaSourceFactory setStreamKeys(List<StreamKey> list);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.source.MediaSourceFactory$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Deprecated
        public static MediaSourceFactory $default$setStreamKeys(MediaSourceFactory _this, List list) {
            return _this;
        }

        @Deprecated
        public static MediaSource $default$createMediaSource(MediaSourceFactory _this, Uri uri) {
            return _this.createMediaSource(MediaItem.fromUri(uri));
        }
    }
}
