package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda1;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackPositionTracker;
import androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class DefaultAudioSink implements AudioSink {
    private static final int AUDIO_TRACK_RETRY_DURATION_MS = 100;
    private static final int AUDIO_TRACK_SMALLER_BUFFER_RETRY_SIZE = 1000000;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final boolean DEFAULT_SKIP_SILENCE = false;
    private static final int ERROR_NATIVE_DEAD_OBJECT = -32;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    public static final int OFFLOAD_MODE_DISABLED = 0;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_DISABLED = 3;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_NOT_REQUIRED = 2;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_REQUIRED = 1;
    public static final int OUTPUT_MODE_OFFLOAD = 1;
    public static final int OUTPUT_MODE_PASSTHROUGH = 2;
    public static final int OUTPUT_MODE_PCM = 0;
    private static final String TAG = "DefaultAudioSink";
    public static boolean failOnSpuriousAudioTimestamp = false;
    private static int pendingReleaseCount;
    private static ExecutorService releaseExecutor;
    private static final Object releaseExecutorLock = new Object();
    private MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private AudioCapabilities audioCapabilities;
    private AudioCapabilitiesReceiver audioCapabilitiesReceiver;
    private final ExoPlayer.AudioOffloadListener audioOffloadListener;
    private AudioProcessingPipeline audioProcessingPipeline;
    private final androidx.media3.common.audio.AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    /* access modifiers changed from: private */
    public AudioTrack audioTrack;
    private final AudioTrackBufferSizeProvider audioTrackBufferSizeProvider;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private final Context context;
    private final boolean enableFloatOutput;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private final PendingExceptionHolder<AudioSink.InitializationException> initializationExceptionPendingExceptionHolder;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private boolean isWaitingForOffloadEndOfStreamHandled;
    /* access modifiers changed from: private */
    public long lastFeedElapsedRealtimeMs;
    private long lastTunnelingAvSyncPresentationTimeUs;
    /* access modifiers changed from: private */
    public AudioSink.Listener listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private boolean offloadDisabledUntilNextConfiguration;
    private final int offloadMode;
    private StreamEventCallbackV29 offloadStreamEventCallbackV29;
    private ByteBuffer outputBuffer;
    private Configuration pendingConfiguration;
    private Looper playbackLooper;
    private PlaybackParameters playbackParameters;
    private PlayerId playerId;
    /* access modifiers changed from: private */
    public boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    private final boolean preferAudioTrackPlaybackParams;
    private AudioDeviceInfoApi23 preferredDevice;
    private final ConditionVariable releasingConditionVariable;
    private boolean skipSilenceEnabled;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final ImmutableList<AudioProcessor> toFloatPcmAvailableAudioProcessors;
    private final ImmutableList<AudioProcessor> toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private final PendingExceptionHolder<AudioSink.WriteException> writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    @Deprecated
    public interface AudioProcessorChain extends androidx.media3.common.audio.AudioProcessorChain {
    }

    public interface AudioTrackBufferSizeProvider {
        public static final AudioTrackBufferSizeProvider DEFAULT = new DefaultAudioTrackBufferSizeProvider.Builder().build();

        int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, int i6, double d);
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    public /* synthetic */ void setOutputStreamOffsetUs(long j) {
        AudioSink.CC.$default$setOutputStreamOffsetUs(this, j);
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor2, SonicAudioProcessor sonicAudioProcessor2) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.audioProcessors = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor2;
            this.sonicAudioProcessor = sonicAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor2;
        }

        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.sonicAudioProcessor.setSpeed(playbackParameters.speed);
            this.sonicAudioProcessor.setPitch(playbackParameters.pitch);
            return playbackParameters;
        }

        public boolean applySkipSilenceEnabled(boolean z) {
            this.silenceSkippingAudioProcessor.setEnabled(z);
            return z;
        }

        public long getMediaDuration(long j) {
            return this.sonicAudioProcessor.getMediaDuration(j);
        }

        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public AudioCapabilities audioCapabilities;
        ExoPlayer.AudioOffloadListener audioOffloadListener;
        /* access modifiers changed from: private */
        public androidx.media3.common.audio.AudioProcessorChain audioProcessorChain;
        AudioTrackBufferSizeProvider audioTrackBufferSizeProvider;
        /* access modifiers changed from: private */
        public final Context context;
        /* access modifiers changed from: private */
        public boolean enableAudioTrackPlaybackParams;
        /* access modifiers changed from: private */
        public boolean enableFloatOutput;
        /* access modifiers changed from: private */
        public int offloadMode;

        @Deprecated
        public Builder() {
            this.context = null;
            this.audioCapabilities = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
            this.offloadMode = 0;
            this.audioTrackBufferSizeProvider = AudioTrackBufferSizeProvider.DEFAULT;
        }

        public Builder(Context context2) {
            this.context = context2;
            this.audioCapabilities = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
            this.offloadMode = 0;
            this.audioTrackBufferSizeProvider = AudioTrackBufferSizeProvider.DEFAULT;
        }

        @Deprecated
        public Builder setAudioCapabilities(AudioCapabilities audioCapabilities2) {
            Assertions.checkNotNull(audioCapabilities2);
            this.audioCapabilities = audioCapabilities2;
            return this;
        }

        public Builder setAudioProcessors(AudioProcessor[] audioProcessorArr) {
            Assertions.checkNotNull(audioProcessorArr);
            return setAudioProcessorChain(new DefaultAudioProcessorChain(audioProcessorArr));
        }

        public Builder setAudioProcessorChain(androidx.media3.common.audio.AudioProcessorChain audioProcessorChain2) {
            Assertions.checkNotNull(audioProcessorChain2);
            this.audioProcessorChain = audioProcessorChain2;
            return this;
        }

        public Builder setEnableFloatOutput(boolean z) {
            this.enableFloatOutput = z;
            return this;
        }

        public Builder setEnableAudioTrackPlaybackParams(boolean z) {
            this.enableAudioTrackPlaybackParams = z;
            return this;
        }

        public Builder setOffloadMode(int i) {
            this.offloadMode = i;
            return this;
        }

        public Builder setAudioTrackBufferSizeProvider(AudioTrackBufferSizeProvider audioTrackBufferSizeProvider2) {
            this.audioTrackBufferSizeProvider = audioTrackBufferSizeProvider2;
            return this;
        }

        public Builder setExperimentalAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener2) {
            this.audioOffloadListener = audioOffloadListener2;
            return this;
        }

        public DefaultAudioSink build() {
            if (this.audioProcessorChain == null) {
                this.audioProcessorChain = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this);
        }
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private DefaultAudioSink(Builder builder) {
        Context access$100 = builder.context;
        this.context = access$100;
        this.audioCapabilities = access$100 != null ? AudioCapabilities.getCapabilities(access$100) : builder.audioCapabilities;
        this.audioProcessorChain = builder.audioProcessorChain;
        boolean z = true;
        this.enableFloatOutput = Util.SDK_INT >= 21 && builder.enableFloatOutput;
        this.preferAudioTrackPlaybackParams = (Util.SDK_INT < 23 || !builder.enableAudioTrackPlaybackParams) ? false : z;
        this.offloadMode = Util.SDK_INT >= 29 ? builder.offloadMode : 0;
        this.audioTrackBufferSizeProvider = builder.audioTrackBufferSizeProvider;
        ConditionVariable conditionVariable = new ConditionVariable(Clock.DEFAULT);
        this.releasingConditionVariable = conditionVariable;
        conditionVariable.open();
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor2 = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor2;
        TrimmingAudioProcessor trimmingAudioProcessor2 = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor2;
        this.toIntPcmAvailableAudioProcessors = ImmutableList.of(new ToInt16PcmAudioProcessor(), channelMappingAudioProcessor2, trimmingAudioProcessor2);
        this.toFloatPcmAvailableAudioProcessors = ImmutableList.of(new ToFloatPcmAudioProcessor());
        this.volume = 1.0f;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        this.mediaPositionParameters = new MediaPositionParameters(PlaybackParameters.DEFAULT, 0, 0);
        this.playbackParameters = PlaybackParameters.DEFAULT;
        this.skipSilenceEnabled = false;
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
        this.audioOffloadListener = builder.audioOffloadListener;
    }

    public void setListener(AudioSink.Listener listener2) {
        this.listener = listener2;
    }

    public void setPlayerId(PlayerId playerId2) {
        this.playerId = playerId2;
    }

    public boolean supportsFormat(Format format) {
        return getFormatSupport(format) != 0;
    }

    public int getFormatSupport(Format format) {
        if (!"audio/raw".equals(format.sampleMimeType)) {
            return ((this.offloadDisabledUntilNextConfiguration || !useOffloadedPlayback(format, this.audioAttributes)) && !getAudioCapabilities().isPassthroughPlaybackSupported(format)) ? 0 : 2;
        }
        if (!Util.isEncodingLinearPcm(format.pcmEncoding)) {
            Log.w(TAG, "Invalid PCM encoding: " + format.pcmEncoding);
            return 0;
        } else if (format.pcmEncoding == 2 || (this.enableFloatOutput && format.pcmEncoding == 4)) {
            return 2;
        } else {
            return 1;
        }
    }

    public long getCurrentPositionUs(boolean z) {
        if (!isAudioTrackInitialized() || this.startMediaTimeUsNeedsInit) {
            return Long.MIN_VALUE;
        }
        return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z), this.configuration.framesToDurationUs(getWrittenFrames()))));
    }

    public void configure(Format format, int i, int[] iArr) throws AudioSink.ConfigurationException {
        boolean z;
        AudioProcessingPipeline audioProcessingPipeline2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int[] iArr2;
        Format format2 = format;
        if ("audio/raw".equals(format2.sampleMimeType)) {
            Assertions.checkArgument(Util.isEncodingLinearPcm(format2.pcmEncoding));
            i7 = Util.getPcmFrameSize(format2.pcmEncoding, format2.channelCount);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (shouldUseFloatOutput(format2.pcmEncoding)) {
                builder.addAll((Iterable) this.toFloatPcmAvailableAudioProcessors);
            } else {
                builder.addAll((Iterable) this.toIntPcmAvailableAudioProcessors);
                builder.add((Object[]) this.audioProcessorChain.getAudioProcessors());
            }
            AudioProcessingPipeline audioProcessingPipeline3 = new AudioProcessingPipeline(builder.build());
            if (audioProcessingPipeline3.equals(this.audioProcessingPipeline)) {
                audioProcessingPipeline3 = this.audioProcessingPipeline;
            }
            this.trimmingAudioProcessor.setTrimFrameCount(format2.encoderDelay, format2.encoderPadding);
            if (Util.SDK_INT < 21 && format2.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i13 = 0; i13 < 6; i13++) {
                    iArr2[i13] = i13;
                }
            } else {
                iArr2 = iArr;
            }
            this.channelMappingAudioProcessor.setChannelMap(iArr2);
            try {
                AudioProcessor.AudioFormat configure = audioProcessingPipeline3.configure(new AudioProcessor.AudioFormat(format2.sampleRate, format2.channelCount, format2.pcmEncoding));
                int i14 = configure.encoding;
                int i15 = configure.sampleRate;
                int audioTrackChannelConfig = Util.getAudioTrackChannelConfig(configure.channelCount);
                i4 = Util.getPcmFrameSize(i14, configure.channelCount);
                audioProcessingPipeline2 = audioProcessingPipeline3;
                i3 = i15;
                i5 = audioTrackChannelConfig;
                z = this.preferAudioTrackPlaybackParams;
                i2 = 0;
                i6 = i14;
            } catch (AudioProcessor.UnhandledAudioFormatException e) {
                throw new AudioSink.ConfigurationException((Throwable) e, format2);
            }
        } else {
            AudioProcessingPipeline audioProcessingPipeline4 = new AudioProcessingPipeline(ImmutableList.of());
            int i16 = format2.sampleRate;
            if (useOffloadedPlayback(format2, this.audioAttributes)) {
                audioProcessingPipeline2 = audioProcessingPipeline4;
                i3 = i16;
                i6 = MimeTypes.getEncoding((String) Assertions.checkNotNull(format2.sampleMimeType), format2.codecs);
                i5 = Util.getAudioTrackChannelConfig(format2.channelCount);
                i7 = -1;
                i4 = -1;
                i2 = 1;
                z = true;
            } else {
                Pair<Integer, Integer> encodingAndChannelConfigForPassthrough = getAudioCapabilities().getEncodingAndChannelConfigForPassthrough(format2);
                if (encodingAndChannelConfigForPassthrough != null) {
                    int intValue = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                    audioProcessingPipeline2 = audioProcessingPipeline4;
                    i3 = i16;
                    i5 = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                    i6 = intValue;
                    z = this.preferAudioTrackPlaybackParams;
                    i7 = -1;
                    i4 = -1;
                    i2 = 2;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format2, format2);
                }
            }
        }
        if (i6 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i2 + ") for: " + format2, format2);
        } else if (i5 != 0) {
            if (i != 0) {
                i12 = i;
                i11 = i6;
                i10 = i5;
                i8 = i4;
                i9 = i3;
            } else {
                i11 = i6;
                i10 = i5;
                i8 = i4;
                i9 = i3;
                i12 = this.audioTrackBufferSizeProvider.getBufferSizeInBytes(getAudioTrackMinBufferSize(i3, i5, i6), i6, i2, i4 != -1 ? i4 : 1, i3, format2.bitrate, z ? 8.0d : 1.0d);
            }
            this.offloadDisabledUntilNextConfiguration = false;
            Configuration configuration2 = new Configuration(format, i7, i2, i8, i9, i10, i11, i12, audioProcessingPipeline2, z);
            if (isAudioTrackInitialized()) {
                this.pendingConfiguration = configuration2;
            } else {
                this.configuration = configuration2;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i2 + ") for: " + format2, format2);
        }
    }

    private void setupAudioProcessors() {
        AudioProcessingPipeline audioProcessingPipeline2 = this.configuration.audioProcessingPipeline;
        this.audioProcessingPipeline = audioProcessingPipeline2;
        audioProcessingPipeline2.flush();
    }

    private boolean initializeAudioTrack() throws AudioSink.InitializationException {
        PlayerId playerId2;
        if (!this.releasingConditionVariable.isOpen()) {
            return false;
        }
        AudioTrack buildAudioTrackWithRetry = buildAudioTrackWithRetry();
        this.audioTrack = buildAudioTrackWithRetry;
        if (isOffloadedPlayback(buildAudioTrackWithRetry)) {
            registerStreamEventCallbackV29(this.audioTrack);
            if (this.offloadMode != 3) {
                this.audioTrack.setOffloadDelayPadding(this.configuration.inputFormat.encoderDelay, this.configuration.inputFormat.encoderPadding);
            }
        }
        if (Util.SDK_INT >= 31 && (playerId2 = this.playerId) != null) {
            Api31.setLogSessionIdOnAudioTrack(this.audioTrack, playerId2);
        }
        this.audioSessionId = this.audioTrack.getAudioSessionId();
        this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.configuration.outputMode == 2, this.configuration.outputEncoding, this.configuration.outputPcmFrameSize, this.configuration.bufferSize);
        setVolumeInternal();
        if (this.auxEffectInfo.effectId != 0) {
            this.audioTrack.attachAuxEffect(this.auxEffectInfo.effectId);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
        if (this.preferredDevice != null && Util.SDK_INT >= 23) {
            Api23.setPreferredDeviceOnAudioTrack(this.audioTrack, this.preferredDevice);
        }
        this.startMediaTimeUsNeedsInit = true;
        return true;
    }

    public void play() {
        this.playing = true;
        if (isAudioTrackInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = j;
        int i2 = i;
        ByteBuffer byteBuffer3 = this.inputBuffer;
        Assertions.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
                if (isOffloadedPlayback(this.audioTrack) && this.offloadMode != 3) {
                    if (this.audioTrack.getPlayState() == 3) {
                        this.audioTrack.setOffloadEndOfStream();
                    }
                    this.audioTrack.setOffloadDelayPadding(this.configuration.inputFormat.encoderDelay, this.configuration.inputFormat.encoderPadding);
                    this.isWaitingForOffloadEndOfStreamHandled = true;
                }
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j2);
        }
        if (!isAudioTrackInitialized()) {
            try {
                if (!initializeAudioTrack()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e) {
                AudioSink.InitializationException initializationException = e;
                if (!initializationException.isRecoverable) {
                    this.initializationExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.initializationExceptionPendingExceptionHolder.clear();
        if (this.startMediaTimeUsNeedsInit) {
            this.startMediaTimeUs = Math.max(0, j2);
            this.startMediaTimeUsNeedsSync = false;
            this.startMediaTimeUsNeedsInit = false;
            if (useAudioTrackPlaybackParams()) {
                setAudioTrackPlaybackParametersV23();
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j2);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            Assertions.checkArgument(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.configuration.outputMode != 0 && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample2 = getFramesPerEncodedSample(this.configuration.outputEncoding, byteBuffer2);
                this.framesPerEncodedSample = framesPerEncodedSample2;
                if (framesPerEncodedSample2 == 0) {
                    return true;
                }
            }
            if (this.afterDrainParameters != null) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                applyAudioProcessorPlaybackParametersAndSkipSilence(j2);
                this.afterDrainParameters = null;
            }
            long inputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(inputFramesToDurationUs - j2) > 200000) {
                AudioSink.Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j2, inputFramesToDurationUs));
                }
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j3 = j2 - inputFramesToDurationUs;
                this.startMediaTimeUs += j3;
                this.startMediaTimeUsNeedsSync = false;
                applyAudioProcessorPlaybackParametersAndSkipSilence(j2);
                AudioSink.Listener listener3 = this.listener;
                if (!(listener3 == null || j3 == 0)) {
                    listener3.onPositionDiscontinuity();
                }
            }
            if (this.configuration.outputMode == 0) {
                this.submittedPcmBytes += (long) byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += ((long) this.framesPerEncodedSample) * ((long) i2);
            }
            this.inputBuffer = byteBuffer2;
            this.inputBufferAccessUnitCount = i2;
        }
        processBuffers(j2);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        } else if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        } else {
            Log.w(TAG, "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    private AudioTrack buildAudioTrackWithRetry() throws AudioSink.InitializationException {
        try {
            return buildAudioTrack((Configuration) Assertions.checkNotNull(this.configuration));
        } catch (AudioSink.InitializationException e) {
            if (this.configuration.bufferSize > 1000000) {
                Configuration copyWithBufferSize = this.configuration.copyWithBufferSize(1000000);
                try {
                    AudioTrack buildAudioTrack = buildAudioTrack(copyWithBufferSize);
                    this.configuration = copyWithBufferSize;
                    return buildAudioTrack;
                } catch (AudioSink.InitializationException e2) {
                    e.addSuppressed(e2);
                    maybeDisableOffload();
                    throw e;
                }
            }
            maybeDisableOffload();
            throw e;
        }
    }

    private AudioTrack buildAudioTrack(Configuration configuration2) throws AudioSink.InitializationException {
        try {
            AudioTrack buildAudioTrack = configuration2.buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
            ExoPlayer.AudioOffloadListener audioOffloadListener2 = this.audioOffloadListener;
            if (audioOffloadListener2 != null) {
                audioOffloadListener2.onExperimentalOffloadedPlayback(isOffloadedPlayback(buildAudioTrack));
            }
            return buildAudioTrack;
        } catch (AudioSink.InitializationException e) {
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioSinkError(e);
            }
            throw e;
        }
    }

    private void registerStreamEventCallbackV29(AudioTrack audioTrack2) {
        if (this.offloadStreamEventCallbackV29 == null) {
            this.offloadStreamEventCallbackV29 = new StreamEventCallbackV29();
        }
        this.offloadStreamEventCallbackV29.register(audioTrack2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = r2.inputBuffer;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0.hasRemaining() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r2.audioProcessingPipeline.queueInput(r2.inputBuffer);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processBuffers(long r3) throws androidx.media3.exoplayer.audio.AudioSink.WriteException {
        /*
            r2 = this;
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.audioProcessingPipeline
            boolean r0 = r0.isOperational()
            if (r0 != 0) goto L_0x0013
            java.nio.ByteBuffer r0 = r2.inputBuffer
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            java.nio.ByteBuffer r0 = androidx.media3.common.audio.AudioProcessor.EMPTY_BUFFER
        L_0x000f:
            r2.writeBuffer(r0, r3)
            return
        L_0x0013:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.audioProcessingPipeline
            boolean r0 = r0.isEnded()
            if (r0 != 0) goto L_0x0044
        L_0x001b:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.audioProcessingPipeline
            java.nio.ByteBuffer r0 = r0.getOutput()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0031
            r2.writeBuffer(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x001b
            return
        L_0x0031:
            java.nio.ByteBuffer r0 = r2.inputBuffer
            if (r0 == 0) goto L_0x0044
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x003c
            goto L_0x0044
        L_0x003c:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.audioProcessingPipeline
            java.nio.ByteBuffer r1 = r2.inputBuffer
            r0.queueInput(r1)
            goto L_0x0013
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.processBuffers(long):void");
    }

    private boolean drainToEndOfStream() throws AudioSink.WriteException {
        if (!this.audioProcessingPipeline.isOperational()) {
            ByteBuffer byteBuffer = this.outputBuffer;
            if (byteBuffer == null) {
                return true;
            }
            writeBuffer(byteBuffer, Long.MIN_VALUE);
            if (this.outputBuffer == null) {
                return true;
            }
            return false;
        }
        this.audioProcessingPipeline.queueEndOfStream();
        processBuffers(Long.MIN_VALUE);
        if (!this.audioProcessingPipeline.isEnded()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.outputBuffer;
        if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
            return true;
        }
        return false;
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j) throws AudioSink.WriteException {
        int i;
        AudioSink.Listener listener2;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.outputBuffer;
            boolean z = true;
            if (byteBuffer2 != null) {
                Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.outputBuffer = byteBuffer;
                if (Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < remaining) {
                        this.preV21OutputBuffer = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                    byteBuffer.position(position);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    i = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize));
                    if (i > 0) {
                        this.preV21OutputBufferOffset += i;
                        byteBuffer.position(byteBuffer.position() + i);
                    }
                } else {
                    i = 0;
                }
            } else if (this.tunneling) {
                Assertions.checkState(j != -9223372036854775807L);
                if (j == Long.MIN_VALUE) {
                    j = this.lastTunnelingAvSyncPresentationTimeUs;
                } else {
                    this.lastTunnelingAvSyncPresentationTimeUs = j;
                }
                i = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j);
            } else {
                i = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (i < 0) {
                if (!isAudioTrackDeadObject(i) || this.writtenEncodedFrames <= 0) {
                    z = false;
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(i, this.configuration.inputFormat, z);
                AudioSink.Listener listener3 = this.listener;
                if (listener3 != null) {
                    listener3.onAudioSinkError(writeException);
                }
                if (!writeException.isRecoverable) {
                    this.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(writeException);
                } else {
                    this.audioCapabilities = AudioCapabilities.DEFAULT_AUDIO_CAPABILITIES;
                    throw writeException;
                }
            } else {
                this.writeExceptionPendingExceptionHolder.clear();
                if (isOffloadedPlayback(this.audioTrack)) {
                    if (this.writtenEncodedFrames > 0) {
                        this.isWaitingForOffloadEndOfStreamHandled = false;
                    }
                    if (this.playing && (listener2 = this.listener) != null && i < remaining2 && !this.isWaitingForOffloadEndOfStreamHandled) {
                        listener2.onOffloadBufferFull();
                    }
                }
                if (this.configuration.outputMode == 0) {
                    this.writtenPcmBytes += (long) i;
                }
                if (i == remaining2) {
                    if (this.configuration.outputMode != 0) {
                        if (byteBuffer != this.inputBuffer) {
                            z = false;
                        }
                        Assertions.checkState(z);
                        this.writtenEncodedFrames += ((long) this.framesPerEncodedSample) * ((long) this.inputBufferAccessUnitCount);
                    }
                    this.outputBuffer = null;
                }
            }
        }
    }

    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isAudioTrackInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    private void maybeDisableOffload() {
        if (this.configuration.outputModeIsOffload()) {
            this.offloadDisabledUntilNextConfiguration = true;
        }
    }

    private static boolean isAudioTrackDeadObject(int i) {
        return (Util.SDK_INT >= 24 && i == -6) || i == ERROR_NATIVE_DEAD_OBJECT;
    }

    public boolean isEnded() {
        return !isAudioTrackInitialized() || (this.handledEndOfStream && !hasPendingData());
    }

    public boolean hasPendingData() {
        return isAudioTrackInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters2) {
        this.playbackParameters = new PlaybackParameters(Util.constrainValue(playbackParameters2.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters2.pitch, 0.1f, 8.0f));
        if (useAudioTrackPlaybackParams()) {
            setAudioTrackPlaybackParametersV23();
        } else {
            setAudioProcessorPlaybackParameters(playbackParameters2);
        }
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public void setSkipSilenceEnabled(boolean z) {
        this.skipSilenceEnabled = z;
        setAudioProcessorPlaybackParameters(useAudioTrackPlaybackParams() ? PlaybackParameters.DEFAULT : this.playbackParameters);
    }

    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!this.audioAttributes.equals(audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            if (!this.tunneling) {
                flush();
            }
        }
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public void setAudioSessionId(int i) {
        if (this.audioSessionId != i) {
            this.audioSessionId = i;
            this.externalAudioSessionIdProvided = i != 0;
            flush();
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo2) {
        if (!this.auxEffectInfo.equals(auxEffectInfo2)) {
            int i = auxEffectInfo2.effectId;
            float f = auxEffectInfo2.sendLevel;
            if (this.audioTrack != null) {
                if (this.auxEffectInfo.effectId != i) {
                    this.audioTrack.attachAuxEffect(i);
                }
                if (i != 0) {
                    this.audioTrack.setAuxEffectSendLevel(f);
                }
            }
            this.auxEffectInfo = auxEffectInfo2;
        }
    }

    public void setPreferredDevice(AudioDeviceInfo audioDeviceInfo) {
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = audioDeviceInfo == null ? null : new AudioDeviceInfoApi23(audioDeviceInfo);
        this.preferredDevice = audioDeviceInfoApi23;
        AudioTrack audioTrack2 = this.audioTrack;
        if (audioTrack2 != null) {
            Api23.setPreferredDeviceOnAudioTrack(audioTrack2, audioDeviceInfoApi23);
        }
    }

    public void enableTunnelingV21() {
        Assertions.checkState(Util.SDK_INT >= 21);
        Assertions.checkState(this.externalAudioSessionIdProvided);
        if (!this.tunneling) {
            this.tunneling = true;
            flush();
        }
    }

    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            flush();
        }
    }

    public void setVolume(float f) {
        if (this.volume != f) {
            this.volume = f;
            setVolumeInternal();
        }
    }

    private void setVolumeInternal() {
        if (isAudioTrackInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    public void pause() {
        this.playing = false;
        if (isAudioTrackInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    public void flush() {
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            if (isOffloadedPlayback(this.audioTrack)) {
                ((StreamEventCallbackV29) Assertions.checkNotNull(this.offloadStreamEventCallbackV29)).unregister(this.audioTrack);
            }
            if (Util.SDK_INT < 21 && !this.externalAudioSessionIdProvided) {
                this.audioSessionId = 0;
            }
            Configuration configuration2 = this.pendingConfiguration;
            if (configuration2 != null) {
                this.configuration = configuration2;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            releaseAudioTrackAsync(this.audioTrack, this.releasingConditionVariable);
            this.audioTrack = null;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        if (Util.SDK_INT < 25) {
            flush();
            return;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            this.audioTrack.flush();
            this.audioTrackPositionTracker.reset();
            this.audioTrackPositionTracker.setAudioTrack(this.audioTrack, this.configuration.outputMode == 2, this.configuration.outputEncoding, this.configuration.outputPcmFrameSize, this.configuration.bufferSize);
            this.startMediaTimeUsNeedsInit = true;
        }
    }

    public void reset() {
        flush();
        UnmodifiableIterator<AudioProcessor> it = this.toIntPcmAvailableAudioProcessors.iterator();
        while (it.hasNext()) {
            it.next().reset();
        }
        UnmodifiableIterator<AudioProcessor> it2 = this.toFloatPcmAvailableAudioProcessors.iterator();
        while (it2.hasNext()) {
            it2.next().reset();
        }
        AudioProcessingPipeline audioProcessingPipeline2 = this.audioProcessingPipeline;
        if (audioProcessingPipeline2 != null) {
            audioProcessingPipeline2.reset();
        }
        this.playing = false;
        this.offloadDisabledUntilNextConfiguration = false;
    }

    public void release() {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = this.audioCapabilitiesReceiver;
        if (audioCapabilitiesReceiver2 != null) {
            audioCapabilitiesReceiver2.unregister();
        }
    }

    public void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities2) {
        Assertions.checkState(this.playbackLooper == Looper.myLooper());
        if (!audioCapabilities2.equals(getAudioCapabilities())) {
            this.audioCapabilities = audioCapabilities2;
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioCapabilitiesChanged();
            }
        }
    }

    private void resetSinkStateForFlush() {
        this.submittedPcmBytes = 0;
        this.submittedEncodedFrames = 0;
        this.writtenPcmBytes = 0;
        this.writtenEncodedFrames = 0;
        this.isWaitingForOffloadEndOfStreamHandled = false;
        this.framesPerEncodedSample = 0;
        this.mediaPositionParameters = new MediaPositionParameters(this.playbackParameters, 0, 0);
        this.startMediaTimeUs = 0;
        this.afterDrainParameters = null;
        this.mediaPositionParametersCheckpoints.clear();
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = false;
        this.handledEndOfStream = false;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.trimmingAudioProcessor.resetTrimmedFrameCount();
        setupAudioProcessors();
    }

    private void setAudioTrackPlaybackParametersV23() {
        if (isAudioTrackInitialized()) {
            try {
                this.audioTrack.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(this.playbackParameters.speed).setPitch(this.playbackParameters.pitch).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e) {
                Log.w(TAG, "Failed to set playback params", e);
            }
            PlaybackParameters playbackParameters2 = new PlaybackParameters(this.audioTrack.getPlaybackParams().getSpeed(), this.audioTrack.getPlaybackParams().getPitch());
            this.playbackParameters = playbackParameters2;
            this.audioTrackPositionTracker.setAudioTrackPlaybackSpeed(playbackParameters2.speed);
        }
    }

    private void setAudioProcessorPlaybackParameters(PlaybackParameters playbackParameters2) {
        MediaPositionParameters mediaPositionParameters2 = new MediaPositionParameters(playbackParameters2, -9223372036854775807L, -9223372036854775807L);
        if (isAudioTrackInitialized()) {
            this.afterDrainParameters = mediaPositionParameters2;
        } else {
            this.mediaPositionParameters = mediaPositionParameters2;
        }
    }

    private void applyAudioProcessorPlaybackParametersAndSkipSilence(long j) {
        PlaybackParameters playbackParameters2;
        if (!useAudioTrackPlaybackParams()) {
            if (shouldApplyAudioProcessorPlaybackParameters()) {
                playbackParameters2 = this.audioProcessorChain.applyPlaybackParameters(this.playbackParameters);
            } else {
                playbackParameters2 = PlaybackParameters.DEFAULT;
            }
            this.playbackParameters = playbackParameters2;
        } else {
            playbackParameters2 = PlaybackParameters.DEFAULT;
        }
        PlaybackParameters playbackParameters3 = playbackParameters2;
        this.skipSilenceEnabled = shouldApplyAudioProcessorPlaybackParameters() ? this.audioProcessorChain.applySkipSilenceEnabled(this.skipSilenceEnabled) : false;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(playbackParameters3, Math.max(0, j), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors();
        AudioSink.Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onSkipSilenceEnabledChanged(this.skipSilenceEnabled);
        }
    }

    private boolean shouldApplyAudioProcessorPlaybackParameters() {
        return !this.tunneling && this.configuration.outputMode == 0 && !shouldUseFloatOutput(this.configuration.inputFormat.pcmEncoding);
    }

    private boolean useAudioTrackPlaybackParams() {
        Configuration configuration2 = this.configuration;
        return configuration2 != null && configuration2.enableAudioTrackPlaybackParams && Util.SDK_INT >= 23;
    }

    private boolean shouldUseFloatOutput(int i) {
        return this.enableFloatOutput && Util.isEncodingHighResolutionPcm(i);
    }

    private long applyMediaPositionParameters(long j) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && j >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        long j2 = j - this.mediaPositionParameters.audioTrackPositionUs;
        if (this.mediaPositionParameters.playbackParameters.equals(PlaybackParameters.DEFAULT)) {
            return this.mediaPositionParameters.mediaTimeUs + j2;
        }
        if (this.mediaPositionParametersCheckpoints.isEmpty()) {
            return this.mediaPositionParameters.mediaTimeUs + this.audioProcessorChain.getMediaDuration(j2);
        }
        MediaPositionParameters first = this.mediaPositionParametersCheckpoints.getFirst();
        return first.mediaTimeUs - Util.getMediaDurationForPlayoutDuration(first.audioTrackPositionUs - j, this.mediaPositionParameters.playbackParameters.speed);
    }

    private long applySkipping(long j) {
        return j + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private boolean isAudioTrackInitialized() {
        return this.audioTrack != null;
    }

    /* access modifiers changed from: private */
    public long getSubmittedFrames() {
        if (this.configuration.outputMode == 0) {
            return this.submittedPcmBytes / ((long) this.configuration.inputPcmFrameSize);
        }
        return this.submittedEncodedFrames;
    }

    /* access modifiers changed from: private */
    public long getWrittenFrames() {
        if (this.configuration.outputMode == 0) {
            return this.writtenPcmBytes / ((long) this.configuration.outputPcmFrameSize);
        }
        return this.writtenEncodedFrames;
    }

    private boolean useOffloadedPlayback(Format format, AudioAttributes audioAttributes2) {
        int encoding;
        int audioTrackChannelConfig;
        int offloadedPlaybackSupport;
        if (Util.SDK_INT < 29 || this.offloadMode == 0 || (encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount)) == 0 || (offloadedPlaybackSupport = getOffloadedPlaybackSupport(getAudioFormat(format.sampleRate, audioTrackChannelConfig, encoding), audioAttributes2.getAudioAttributesV21().audioAttributes)) == 0) {
            return false;
        }
        if (offloadedPlaybackSupport == 1) {
            boolean z = (format.encoderDelay == 0 && format.encoderPadding == 0) ? false : true;
            boolean z2 = this.offloadMode == 1;
            if (!z || !z2) {
                return true;
            }
            return false;
        } else if (offloadedPlaybackSupport == 2) {
            return true;
        } else {
            throw new IllegalStateException();
        }
    }

    private AudioCapabilities getAudioCapabilities() {
        if (this.audioCapabilitiesReceiver == null && this.context != null) {
            this.playbackLooper = Looper.myLooper();
            AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = new AudioCapabilitiesReceiver(this.context, new DefaultAudioSink$$ExternalSyntheticLambda1(this));
            this.audioCapabilitiesReceiver = audioCapabilitiesReceiver2;
            this.audioCapabilities = audioCapabilitiesReceiver2.register();
        }
        return this.audioCapabilities;
    }

    private int getOffloadedPlaybackSupport(AudioFormat audioFormat, android.media.AudioAttributes audioAttributes2) {
        if (Util.SDK_INT >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes2);
        }
        if (!AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes2)) {
            return 0;
        }
        return (Util.SDK_INT != 30 || !Util.MODEL.startsWith("Pixel")) ? 1 : 2;
    }

    private static boolean isOffloadedPlayback(AudioTrack audioTrack2) {
        return Util.SDK_INT >= 29 && audioTrack2.isOffloadedPlayback();
    }

    private static int getFramesPerEncodedSample(int i, ByteBuffer byteBuffer) {
        switch (i) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case 8:
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            case 9:
                int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(Util.getBigEndianInt(byteBuffer, byteBuffer.position()));
                if (parseMpegAudioFrameSampleCount != -1) {
                    return parseMpegAudioFrameSampleCount;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                if (findTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
            case 20:
                return OpusUtil.parseOggPacketAudioSampleCount(byteBuffer);
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i);
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i) {
        return audioTrack2.write(byteBuffer, i, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i, long j) {
        if (Util.SDK_INT >= 26) {
            return audioTrack2.write(byteBuffer, i, 1, j * 1000);
        }
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i);
            this.avSyncHeader.putLong(8, j * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack2.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack2, byteBuffer, i);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack2, float f) {
        audioTrack2.setVolume(f);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack2, float f) {
        audioTrack2.setStereoVolume(f, f);
    }

    private void playPendingData() {
        if (!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    private static void releaseAudioTrackAsync(AudioTrack audioTrack2, ConditionVariable conditionVariable) {
        conditionVariable.close();
        synchronized (releaseExecutorLock) {
            if (releaseExecutor == null) {
                releaseExecutor = Util.newSingleThreadExecutor("ExoPlayer:AudioTrackReleaseThread");
            }
            pendingReleaseCount++;
            releaseExecutor.execute(new DefaultAudioSink$$ExternalSyntheticLambda0(audioTrack2, conditionVariable));
        }
    }

    static /* synthetic */ void lambda$releaseAudioTrackAsync$0(AudioTrack audioTrack2, ConditionVariable conditionVariable) {
        try {
            audioTrack2.flush();
            audioTrack2.release();
            conditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i = pendingReleaseCount - 1;
                pendingReleaseCount = i;
                if (i == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
            }
        } catch (Throwable th) {
            conditionVariable.open();
            synchronized (releaseExecutorLock) {
                int i2 = pendingReleaseCount - 1;
                pendingReleaseCount = i2;
                if (i2 == 0) {
                    releaseExecutor.shutdown();
                    releaseExecutor = null;
                }
                throw th;
            }
        }
    }

    private final class StreamEventCallbackV29 {
        private final AudioTrack.StreamEventCallback callback;
        private final Handler handler = new Handler(Looper.myLooper());

        public StreamEventCallbackV29() {
            this.callback = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i) {
                    if (audioTrack.equals(DefaultAudioSink.this.audioTrack) && DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.audioTrack) && DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }
            };
        }

        public void register(AudioTrack audioTrack) {
            Handler handler2 = this.handler;
            Objects.requireNonNull(handler2);
            audioTrack.registerStreamEventCallback(new ConcurrencyHelpers$$ExternalSyntheticLambda1(handler2), this.callback);
        }

        public void unregister(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.callback);
            this.handler.removeCallbacksAndMessages((Object) null);
        }
    }

    private static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;

        private MediaPositionParameters(PlaybackParameters playbackParameters2, long j, long j2) {
            this.playbackParameters = playbackParameters2;
            this.mediaTimeUs = j;
            this.audioTrackPositionUs = j2;
        }
    }

    /* access modifiers changed from: private */
    public static AudioFormat getAudioFormat(int i, int i2, int i3) {
        return new AudioFormat.Builder().setSampleRate(i).setChannelMask(i2).setEncoding(i3).build();
    }

    private static int getAudioTrackMinBufferSize(int i, int i2, int i3) {
        int minBufferSize = AudioTrack.getMinBufferSize(i, i2, i3);
        Assertions.checkState(minBufferSize != -2);
        return minBufferSize;
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.getSubmittedFrames() + ", " + DefaultAudioSink.this.getWrittenFrames();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void onInvalidLatency(long j) {
            Log.w(DefaultAudioSink.TAG, "Ignoring impossibly large audio latency: " + j);
        }

        public void onPositionAdvancing(long j) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onPositionAdvancing(j);
            }
        }

        public void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    private static final class Configuration {
        public final AudioProcessingPipeline audioProcessingPipeline;
        public final int bufferSize;
        public final boolean enableAudioTrackPlaybackParams;
        public final Format inputFormat;
        public final int inputPcmFrameSize;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputMode;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;

        public Configuration(Format format, int i, int i2, int i3, int i4, int i5, int i6, int i7, AudioProcessingPipeline audioProcessingPipeline2, boolean z) {
            this.inputFormat = format;
            this.inputPcmFrameSize = i;
            this.outputMode = i2;
            this.outputPcmFrameSize = i3;
            this.outputSampleRate = i4;
            this.outputChannelConfig = i5;
            this.outputEncoding = i6;
            this.bufferSize = i7;
            this.audioProcessingPipeline = audioProcessingPipeline2;
            this.enableAudioTrackPlaybackParams = z;
        }

        public Configuration copyWithBufferSize(int i) {
            return new Configuration(this.inputFormat, this.inputPcmFrameSize, this.outputMode, this.outputPcmFrameSize, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, i, this.audioProcessingPipeline, this.enableAudioTrackPlaybackParams);
        }

        public boolean canReuseAudioTrack(Configuration configuration) {
            return configuration.outputMode == this.outputMode && configuration.outputEncoding == this.outputEncoding && configuration.outputSampleRate == this.outputSampleRate && configuration.outputChannelConfig == this.outputChannelConfig && configuration.outputPcmFrameSize == this.outputPcmFrameSize && configuration.enableAudioTrackPlaybackParams == this.enableAudioTrackPlaybackParams;
        }

        public long inputFramesToDurationUs(long j) {
            return Util.sampleCountToDurationUs(j, this.inputFormat.sampleRate);
        }

        public long framesToDurationUs(long j) {
            return Util.sampleCountToDurationUs(j, this.outputSampleRate);
        }

        public AudioTrack buildAudioTrack(boolean z, AudioAttributes audioAttributes, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack createAudioTrack = createAudioTrack(z, audioAttributes, i);
                int state = createAudioTrack.getState();
                if (state == 1) {
                    return createAudioTrack;
                }
                try {
                    createAudioTrack.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), e);
            }
        }

        private AudioTrack createAudioTrack(boolean z, AudioAttributes audioAttributes, int i) {
            if (Util.SDK_INT >= 29) {
                return createAudioTrackV29(z, audioAttributes, i);
            }
            if (Util.SDK_INT >= 21) {
                return createAudioTrackV21(z, audioAttributes, i);
            }
            return createAudioTrackV9(audioAttributes, i);
        }

        private AudioTrack createAudioTrackV29(boolean z, AudioAttributes audioAttributes, int i) {
            AudioFormat access$1600 = DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            android.media.AudioAttributes audioTrackAttributesV21 = getAudioTrackAttributesV21(audioAttributes, z);
            boolean z2 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributesV21).setAudioFormat(access$1600).setTransferMode(1).setBufferSizeInBytes(this.bufferSize).setSessionId(i);
            if (this.outputMode != 1) {
                z2 = false;
            }
            return sessionId.setOffloadedPlayback(z2).build();
        }

        private AudioTrack createAudioTrackV21(boolean z, AudioAttributes audioAttributes, int i) {
            return new AudioTrack(getAudioTrackAttributesV21(audioAttributes, z), DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding), this.bufferSize, 1, i);
        }

        private AudioTrack createAudioTrackV9(AudioAttributes audioAttributes, int i) {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            if (i == 0) {
                return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            }
            return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i);
        }

        private static android.media.AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean z) {
            if (z) {
                return getAudioTrackTunnelingAttributesV21();
            }
            return audioAttributes.getAudioAttributesV21().audioAttributes;
        }

        private static android.media.AudioAttributes getAudioTrackTunnelingAttributesV21() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public boolean outputModeIsOffload() {
            return this.outputMode == 1;
        }
    }

    private static final class PendingExceptionHolder<T extends Exception> {
        private T pendingException;
        private long throwDeadlineMs;
        private final long throwDelayMs;

        public PendingExceptionHolder(long j) {
            this.throwDelayMs = j;
        }

        public void throwExceptionIfDeadlineIsReached(T t) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = t;
                this.throwDeadlineMs = this.throwDelayMs + elapsedRealtime;
            }
            if (elapsedRealtime >= this.throwDeadlineMs) {
                T t2 = this.pendingException;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.pendingException;
                clear();
                throw t3;
            }
        }

        public void clear() {
            this.pendingException = null;
        }
    }

    private static final class AudioDeviceInfoApi23 {
        public final AudioDeviceInfo audioDeviceInfo;

        public AudioDeviceInfoApi23(AudioDeviceInfo audioDeviceInfo2) {
            this.audioDeviceInfo = audioDeviceInfo2;
        }
    }

    private static final class Api23 {
        private Api23() {
        }

        public static void setPreferredDeviceOnAudioTrack(AudioTrack audioTrack, AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            audioTrack.setPreferredDevice(audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.audioDeviceInfo);
        }
    }

    private static final class Api31 {
        private Api31() {
        }

        public static void setLogSessionIdOnAudioTrack(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId logSessionId = playerId.getLogSessionId();
            if (!logSessionId.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(logSessionId);
            }
        }
    }
}
