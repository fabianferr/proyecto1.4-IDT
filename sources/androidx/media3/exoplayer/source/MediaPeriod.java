package androidx.media3.exoplayer.source;

import androidx.media3.common.StreamKey;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.exoplayer.source.SequenceableLoader;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public interface MediaPeriod extends SequenceableLoader {

    public interface Callback extends SequenceableLoader.Callback<MediaPeriod> {
        void onPrepared(MediaPeriod mediaPeriod);
    }

    boolean continueLoading(long j);

    void discardBuffer(long j, boolean z);

    long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters);

    long getBufferedPositionUs();

    long getNextLoadPositionUs();

    List<StreamKey> getStreamKeys(List<ExoTrackSelection> list);

    TrackGroupArray getTrackGroups();

    boolean isLoading();

    void maybeThrowPrepareError() throws IOException;

    void prepare(Callback callback, long j);

    long readDiscontinuity();

    void reevaluateBuffer(long j);

    long seekToUs(long j);

    long selectTracks(ExoTrackSelection[] exoTrackSelectionArr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.exoplayer.source.MediaPeriod$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static List $default$getStreamKeys(MediaPeriod _this, List list) {
            return Collections.emptyList();
        }
    }
}
