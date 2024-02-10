package com.mbridge.msdk.playercommon.exoplayer2.audio;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.media3.exoplayer.dash.DashMediaSource;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.reflect.Method;

final class AudioTrackPositionTracker {
    private static final long FORCE_RESET_WORKAROUND_TIMEOUT_MS = 200;
    private static final long MAX_AUDIO_TIMESTAMP_OFFSET_US = 5000000;
    private static final long MAX_LATENCY_US = 5000000;
    private static final int MAX_PLAYHEAD_OFFSET_COUNT = 10;
    private static final int MIN_LATENCY_SAMPLE_INTERVAL_US = 500000;
    private static final int MIN_PLAYHEAD_OFFSET_SAMPLE_INTERVAL_US = 30000;
    private static final int PLAYSTATE_PAUSED = 2;
    private static final int PLAYSTATE_PLAYING = 3;
    private static final int PLAYSTATE_STOPPED = 1;
    private AudioTimestampPoller audioTimestampPoller;
    private AudioTrack audioTrack;
    private int bufferSize;
    private long bufferSizeUs;
    private long endPlaybackHeadPosition;
    private long forceResetWorkaroundTimeMs;
    private Method getLatencyMethod;
    private boolean hasData;
    private boolean isOutputPcm;
    private long lastLatencySampleTimeUs;
    private long lastPlayheadSampleTimeUs;
    private long lastRawPlaybackHeadPosition;
    private long latencyUs;
    private final Listener listener;
    private boolean needsPassthroughWorkarounds;
    private int nextPlayheadOffsetIndex;
    private int outputPcmFrameSize;
    private int outputSampleRate;
    private long passthroughWorkaroundPauseOffset;
    private int playheadOffsetCount;
    private final long[] playheadOffsets;
    private long rawPlaybackHeadWrapCount;
    private long smoothedPlayheadOffsetUs;
    private long stopPlaybackHeadPosition;
    private long stopTimestampUs;

    public interface Listener {
        void onInvalidLatency(long j);

        void onPositionFramesMismatch(long j, long j2, long j3, long j4);

        void onSystemTimeUsMismatch(long j, long j2, long j3, long j4);

        void onUnderrun(int i, long j);
    }

    private @interface PlayState {
    }

    public AudioTrackPositionTracker(Listener listener2) {
        this.listener = (Listener) Assertions.checkNotNull(listener2);
        if (Util.SDK_INT >= 18) {
            try {
                Class[] clsArr = null;
                this.getLatencyMethod = AudioTrack.class.getMethod("getLatency", (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.playheadOffsets = new long[10];
    }

    public final void setAudioTrack(AudioTrack audioTrack2, int i, int i2, int i3) {
        this.audioTrack = audioTrack2;
        this.outputPcmFrameSize = i2;
        this.bufferSize = i3;
        this.audioTimestampPoller = new AudioTimestampPoller(audioTrack2);
        this.outputSampleRate = audioTrack2.getSampleRate();
        this.needsPassthroughWorkarounds = needsPassthroughWorkarounds(i);
        boolean isEncodingPcm = Util.isEncodingPcm(i);
        this.isOutputPcm = isEncodingPcm;
        this.bufferSizeUs = isEncodingPcm ? framesToDurationUs((long) (i3 / i2)) : -9223372036854775807L;
        this.lastRawPlaybackHeadPosition = 0;
        this.rawPlaybackHeadWrapCount = 0;
        this.passthroughWorkaroundPauseOffset = 0;
        this.hasData = false;
        this.stopTimestampUs = -9223372036854775807L;
        this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        this.latencyUs = 0;
    }

    public final long getCurrentPositionUs(boolean z) {
        long j;
        if (this.audioTrack.getPlayState() == 3) {
            maybeSampleSyncParams();
        }
        long nanoTime = System.nanoTime() / 1000;
        if (this.audioTimestampPoller.hasTimestamp()) {
            long framesToDurationUs = framesToDurationUs(this.audioTimestampPoller.getTimestampPositionFrames());
            if (!this.audioTimestampPoller.isTimestampAdvancing()) {
                return framesToDurationUs;
            }
            return framesToDurationUs + (nanoTime - this.audioTimestampPoller.getTimestampSystemTimeUs());
        }
        if (this.playheadOffsetCount == 0) {
            j = getPlaybackHeadPositionUs();
        } else {
            j = nanoTime + this.smoothedPlayheadOffsetUs;
        }
        return !z ? j - this.latencyUs : j;
    }

    public final void start() {
        this.audioTimestampPoller.reset();
    }

    public final boolean isPlaying() {
        return this.audioTrack.getPlayState() == 3;
    }

    public final boolean mayHandleBuffer(long j) {
        Listener listener2;
        int playState = this.audioTrack.getPlayState();
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2) {
                this.hasData = false;
                return false;
            } else if (playState == 1 && getPlaybackHeadPosition() == 0) {
                return false;
            }
        }
        boolean z = this.hasData;
        boolean hasPendingData = hasPendingData(j);
        this.hasData = hasPendingData;
        if (z && !hasPendingData && playState != 1 && (listener2 = this.listener) != null) {
            listener2.onUnderrun(this.bufferSize, C.usToMs(this.bufferSizeUs));
        }
        return true;
    }

    public final int getAvailableBufferSize(long j) {
        return this.bufferSize - ((int) (j - (getPlaybackHeadPosition() * ((long) this.outputPcmFrameSize))));
    }

    public final boolean isStalled(long j) {
        return this.forceResetWorkaroundTimeMs != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.forceResetWorkaroundTimeMs >= FORCE_RESET_WORKAROUND_TIMEOUT_MS;
    }

    public final void handleEndOfStream(long j) {
        this.stopPlaybackHeadPosition = getPlaybackHeadPosition();
        this.stopTimestampUs = SystemClock.elapsedRealtime() * 1000;
        this.endPlaybackHeadPosition = j;
    }

    public final boolean hasPendingData(long j) {
        return j > getPlaybackHeadPosition() || forceHasPendingData();
    }

    public final boolean pause() {
        resetSyncParams();
        if (this.stopTimestampUs != -9223372036854775807L) {
            return false;
        }
        this.audioTimestampPoller.reset();
        return true;
    }

    public final void reset() {
        resetSyncParams();
        this.audioTrack = null;
        this.audioTimestampPoller = null;
    }

    private void maybeSampleSyncParams() {
        long playbackHeadPositionUs = getPlaybackHeadPositionUs();
        if (playbackHeadPositionUs != 0) {
            long nanoTime = System.nanoTime() / 1000;
            if (nanoTime - this.lastPlayheadSampleTimeUs >= 30000) {
                long[] jArr = this.playheadOffsets;
                int i = this.nextPlayheadOffsetIndex;
                jArr[i] = playbackHeadPositionUs - nanoTime;
                this.nextPlayheadOffsetIndex = (i + 1) % 10;
                int i2 = this.playheadOffsetCount;
                if (i2 < 10) {
                    this.playheadOffsetCount = i2 + 1;
                }
                this.lastPlayheadSampleTimeUs = nanoTime;
                this.smoothedPlayheadOffsetUs = 0;
                int i3 = 0;
                while (true) {
                    int i4 = this.playheadOffsetCount;
                    if (i3 >= i4) {
                        break;
                    }
                    this.smoothedPlayheadOffsetUs += this.playheadOffsets[i3] / ((long) i4);
                    i3++;
                }
            }
            if (!this.needsPassthroughWorkarounds) {
                maybePollAndCheckTimestamp(nanoTime, playbackHeadPositionUs);
                maybeUpdateLatency(nanoTime);
            }
        }
    }

    private void maybePollAndCheckTimestamp(long j, long j2) {
        if (this.audioTimestampPoller.maybePollTimestamp(j)) {
            long timestampSystemTimeUs = this.audioTimestampPoller.getTimestampSystemTimeUs();
            long timestampPositionFrames = this.audioTimestampPoller.getTimestampPositionFrames();
            if (Math.abs(timestampSystemTimeUs - j) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                this.listener.onSystemTimeUsMismatch(timestampPositionFrames, timestampSystemTimeUs, j, j2);
                this.audioTimestampPoller.rejectTimestamp();
            } else if (Math.abs(framesToDurationUs(timestampPositionFrames) - j2) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                this.listener.onPositionFramesMismatch(timestampPositionFrames, timestampSystemTimeUs, j, j2);
                this.audioTimestampPoller.rejectTimestamp();
            } else {
                this.audioTimestampPoller.acceptTimestamp();
            }
        }
    }

    private void maybeUpdateLatency(long j) {
        Method method;
        if (this.isOutputPcm && (method = this.getLatencyMethod) != null && j - this.lastLatencySampleTimeUs >= 500000) {
            try {
                Object[] objArr = null;
                long intValue = (((long) ((Integer) method.invoke(this.audioTrack, (Object[]) null)).intValue()) * 1000) - this.bufferSizeUs;
                this.latencyUs = intValue;
                long max = Math.max(intValue, 0);
                this.latencyUs = max;
                if (max > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                    this.listener.onInvalidLatency(max);
                    this.latencyUs = 0;
                }
            } catch (Exception unused) {
                this.getLatencyMethod = null;
            }
            this.lastLatencySampleTimeUs = j;
        }
    }

    private long framesToDurationUs(long j) {
        return (j * 1000000) / ((long) this.outputSampleRate);
    }

    private void resetSyncParams() {
        this.smoothedPlayheadOffsetUs = 0;
        this.playheadOffsetCount = 0;
        this.nextPlayheadOffsetIndex = 0;
        this.lastPlayheadSampleTimeUs = 0;
    }

    private boolean forceHasPendingData() {
        return this.needsPassthroughWorkarounds && this.audioTrack.getPlayState() == 2 && getPlaybackHeadPosition() == 0;
    }

    private static boolean needsPassthroughWorkarounds(int i) {
        return Util.SDK_INT < 23 && (i == 5 || i == 6);
    }

    private long getPlaybackHeadPositionUs() {
        return framesToDurationUs(getPlaybackHeadPosition());
    }

    private long getPlaybackHeadPosition() {
        if (this.stopTimestampUs != -9223372036854775807L) {
            return Math.min(this.endPlaybackHeadPosition, this.stopPlaybackHeadPosition + ((((SystemClock.elapsedRealtime() * 1000) - this.stopTimestampUs) * ((long) this.outputSampleRate)) / 1000000));
        }
        int playState = this.audioTrack.getPlayState();
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) this.audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.needsPassthroughWorkarounds) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.passthroughWorkaroundPauseOffset = this.lastRawPlaybackHeadPosition;
            }
            playbackHeadPosition += this.passthroughWorkaroundPauseOffset;
        }
        if (Util.SDK_INT <= 28) {
            if (playbackHeadPosition == 0 && this.lastRawPlaybackHeadPosition > 0 && playState == 3) {
                if (this.forceResetWorkaroundTimeMs == -9223372036854775807L) {
                    this.forceResetWorkaroundTimeMs = SystemClock.elapsedRealtime();
                }
                return this.lastRawPlaybackHeadPosition;
            }
            this.forceResetWorkaroundTimeMs = -9223372036854775807L;
        }
        if (this.lastRawPlaybackHeadPosition > playbackHeadPosition) {
            this.rawPlaybackHeadWrapCount++;
        }
        this.lastRawPlaybackHeadPosition = playbackHeadPosition;
        return playbackHeadPosition + (this.rawPlaybackHeadWrapCount << 32);
    }
}
