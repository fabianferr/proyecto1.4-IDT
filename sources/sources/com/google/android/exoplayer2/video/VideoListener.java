package com.google.android.exoplayer2.video;

import com.android.tools.r8.annotations.SynthesizedClassV2;

@Deprecated
public interface VideoListener {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.video.VideoListener$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onRenderedFirstFrame(VideoListener _this) {
        }

        public static void $default$onSurfaceSizeChanged(VideoListener _this, int i, int i2) {
        }

        @Deprecated
        public static void $default$onVideoSizeChanged(VideoListener _this, int i, int i2, int i3, float f) {
        }

        public static void $default$onVideoSizeChanged(VideoListener _this, VideoSize videoSize) {
        }
    }

    void onRenderedFirstFrame();

    void onSurfaceSizeChanged(int i, int i2);

    @Deprecated
    void onVideoSizeChanged(int i, int i2, int i3, float f);

    void onVideoSizeChanged(VideoSize videoSize);
}
