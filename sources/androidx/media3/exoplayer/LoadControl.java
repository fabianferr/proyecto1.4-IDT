package androidx.media3.exoplayer;

import androidx.media3.common.MediaPeriodId;
import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface LoadControl {
    @Deprecated
    public static final MediaPeriodId EMPTY_MEDIA_PERIOD_ID = new MediaPeriodId(new Object());

    Allocator getAllocator();

    long getBackBufferDurationUs();

    void onPrepared();

    void onReleased();

    void onStopped();

    void onTracksSelected(Timeline timeline, MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    @Deprecated
    void onTracksSelected(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    boolean retainBackBufferFromKeyframe();

    boolean shouldContinueLoading(long j, long j2, float f);

    @Deprecated
    boolean shouldStartPlayback(long j, float f, boolean z, long j2);

    boolean shouldStartPlayback(Timeline timeline, MediaPeriodId mediaPeriodId, long j, float f, boolean z, long j2);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.exoplayer.LoadControl$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onTracksSelected(LoadControl _this, Timeline timeline, MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
            _this.onTracksSelected(rendererArr, trackGroupArray, exoTrackSelectionArr);
        }

        @Deprecated
        public static void $default$onTracksSelected(LoadControl _this, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
            _this.onTracksSelected(Timeline.EMPTY, LoadControl.EMPTY_MEDIA_PERIOD_ID, rendererArr, trackGroupArray, exoTrackSelectionArr);
        }

        public static boolean $default$shouldStartPlayback(LoadControl _this, Timeline timeline, MediaPeriodId mediaPeriodId, long j, float f, boolean z, long j2) {
            return _this.shouldStartPlayback(j, f, z, j2);
        }

        @Deprecated
        public static boolean $default$shouldStartPlayback(LoadControl _this, long j, float f, boolean z, long j2) {
            return _this.shouldStartPlayback(Timeline.EMPTY, LoadControl.EMPTY_MEDIA_PERIOD_ID, j, f, z, j2);
        }
    }
}
