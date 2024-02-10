package com.google.android.exoplayer2.transformer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.transformer.FrameworkMuxer;
import com.google.android.exoplayer2.transformer.Muxer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

public final class Transformer {
    public static final int PROGRESS_STATE_AVAILABLE = 1;
    public static final int PROGRESS_STATE_NO_TRANSFORMATION = 4;
    public static final int PROGRESS_STATE_UNAVAILABLE = 2;
    public static final int PROGRESS_STATE_WAITING_FOR_AVAILABILITY = 0;
    /* access modifiers changed from: private */
    public final Clock clock;
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public final Looper looper;
    /* access modifiers changed from: private */
    public final MediaSourceFactory mediaSourceFactory;
    /* access modifiers changed from: private */
    public final Muxer.Factory muxerFactory;
    private MuxerWrapper muxerWrapper;
    /* access modifiers changed from: private */
    public SimpleExoPlayer player;
    /* access modifiers changed from: private */
    public int progressState;
    /* access modifiers changed from: private */
    public final Transformation transformation;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProgressState {
    }

    public interface Listener {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.google.android.exoplayer2.transformer.Transformer$Listener$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static void $default$onTransformationCompleted(Listener _this, MediaItem mediaItem) {
            }

            public static void $default$onTransformationError(Listener _this, MediaItem mediaItem, Exception exc) {
            }
        }

        void onTransformationCompleted(MediaItem mediaItem);

        void onTransformationError(MediaItem mediaItem, Exception exc);
    }

    public static final class Builder {
        private Clock clock;
        private Context context;
        private boolean flattenForSlowMotion;
        private Listener listener;
        private Looper looper;
        private MediaSourceFactory mediaSourceFactory;
        private Muxer.Factory muxerFactory;
        private String outputMimeType;
        private boolean removeAudio;
        private boolean removeVideo;

        public Builder() {
            this.muxerFactory = new FrameworkMuxer.Factory();
            this.outputMimeType = "video/mp4";
            this.listener = new Listener(this) {
                public /* synthetic */ void onTransformationCompleted(MediaItem mediaItem) {
                    Listener.CC.$default$onTransformationCompleted(this, mediaItem);
                }

                public /* synthetic */ void onTransformationError(MediaItem mediaItem, Exception exc) {
                    Listener.CC.$default$onTransformationError(this, mediaItem, exc);
                }
            };
            this.looper = Util.getCurrentOrMainLooper();
            this.clock = Clock.DEFAULT;
        }

        private Builder(Transformer transformer) {
            this.context = transformer.context;
            this.mediaSourceFactory = transformer.mediaSourceFactory;
            this.muxerFactory = transformer.muxerFactory;
            this.removeAudio = transformer.transformation.removeAudio;
            this.removeVideo = transformer.transformation.removeVideo;
            this.flattenForSlowMotion = transformer.transformation.flattenForSlowMotion;
            this.outputMimeType = transformer.transformation.outputMimeType;
            this.listener = transformer.listener;
            this.looper = transformer.looper;
            this.clock = transformer.clock;
        }

        public Builder setContext(Context context2) {
            this.context = context2.getApplicationContext();
            return this;
        }

        public Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory2) {
            this.mediaSourceFactory = mediaSourceFactory2;
            return this;
        }

        public Builder setRemoveAudio(boolean z) {
            this.removeAudio = z;
            return this;
        }

        public Builder setRemoveVideo(boolean z) {
            this.removeVideo = z;
            return this;
        }

        public Builder setFlattenForSlowMotion(boolean z) {
            this.flattenForSlowMotion = z;
            return this;
        }

        public Builder setOutputMimeType(String str) {
            this.outputMimeType = str;
            return this;
        }

        public Builder setListener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder setLooper(Looper looper2) {
            this.looper = looper2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setClock(Clock clock2) {
            this.clock = clock2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder setMuxerFactory(Muxer.Factory factory) {
            this.muxerFactory = factory;
            return this;
        }

        public Transformer build() {
            Assertions.checkStateNotNull(this.context);
            if (this.mediaSourceFactory == null) {
                DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
                if (this.flattenForSlowMotion) {
                    defaultExtractorsFactory.setMp4ExtractorFlags(4);
                }
                this.mediaSourceFactory = new DefaultMediaSourceFactory(this.context, (ExtractorsFactory) defaultExtractorsFactory);
            }
            boolean supportsOutputMimeType = this.muxerFactory.supportsOutputMimeType(this.outputMimeType);
            String valueOf = String.valueOf(this.outputMimeType);
            Assertions.checkState(supportsOutputMimeType, valueOf.length() != 0 ? "Unsupported output MIME type: ".concat(valueOf) : new String("Unsupported output MIME type: "));
            return new Transformer(this.context, this.mediaSourceFactory, this.muxerFactory, new Transformation(this.removeAudio, this.removeVideo, this.flattenForSlowMotion, this.outputMimeType), this.listener, this.looper, this.clock);
        }
    }

    private Transformer(Context context2, MediaSourceFactory mediaSourceFactory2, Muxer.Factory factory, Transformation transformation2, Listener listener2, Looper looper2, Clock clock2) {
        Assertions.checkState(!transformation2.removeAudio || !transformation2.removeVideo, "Audio and video cannot both be removed.");
        this.context = context2;
        this.mediaSourceFactory = mediaSourceFactory2;
        this.muxerFactory = factory;
        this.transformation = transformation2;
        this.listener = listener2;
        this.looper = looper2;
        this.clock = clock2;
        this.progressState = 4;
    }

    public Builder buildUpon() {
        return new Builder();
    }

    public void setListener(Listener listener2) {
        verifyApplicationThread();
        this.listener = listener2;
    }

    public void startTransformation(MediaItem mediaItem, String str) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(str, this.transformation.outputMimeType));
    }

    public void startTransformation(MediaItem mediaItem, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        startTransformation(mediaItem, this.muxerFactory.create(parcelFileDescriptor, this.transformation.outputMimeType));
    }

    private void startTransformation(MediaItem mediaItem, Muxer muxer) {
        verifyApplicationThread();
        if (this.player == null) {
            MuxerWrapper muxerWrapper2 = new MuxerWrapper(muxer);
            this.muxerWrapper = muxerWrapper2;
            DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(this.context);
            defaultTrackSelector.setParameters(new DefaultTrackSelector.ParametersBuilder(this.context).setForceHighestSupportedBitrate(true).build());
            SimpleExoPlayer build = new SimpleExoPlayer.Builder(this.context, (RenderersFactory) new TransformerRenderersFactory(muxerWrapper2, this.transformation)).setMediaSourceFactory(this.mediaSourceFactory).setTrackSelector(defaultTrackSelector).setLoadControl(new DefaultLoadControl.Builder().setBufferDurationsMs(50000, 50000, 250, 500).build()).setLooper(this.looper).setClock(this.clock).build();
            this.player = build;
            build.setMediaItem(mediaItem);
            this.player.addAnalyticsListener(new TransformerAnalyticsListener(mediaItem, muxerWrapper2));
            this.player.prepare();
            this.progressState = 0;
            return;
        }
        throw new IllegalStateException("There is already a transformation in progress.");
    }

    public Looper getApplicationLooper() {
        return this.looper;
    }

    public int getProgress(ProgressHolder progressHolder) {
        verifyApplicationThread();
        if (this.progressState == 1) {
            Player player2 = (Player) Assertions.checkNotNull(this.player);
            progressHolder.progress = Math.min((int) ((player2.getCurrentPosition() * 100) / player2.getDuration()), 99);
        }
        return this.progressState;
    }

    public void cancel() {
        releaseResources(true);
    }

    /* access modifiers changed from: private */
    public void releaseResources(boolean z) {
        verifyApplicationThread();
        SimpleExoPlayer simpleExoPlayer = this.player;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.player = null;
        }
        MuxerWrapper muxerWrapper2 = this.muxerWrapper;
        if (muxerWrapper2 != null) {
            muxerWrapper2.release(z);
            this.muxerWrapper = null;
        }
        this.progressState = 4;
    }

    private void verifyApplicationThread() {
        if (Looper.myLooper() != this.looper) {
            throw new IllegalStateException("Transformer is accessed on the wrong thread.");
        }
    }

    private static final class TransformerRenderersFactory implements RenderersFactory {
        private final TransformerMediaClock mediaClock = new TransformerMediaClock();
        private final MuxerWrapper muxerWrapper;
        private final Transformation transformation;

        public TransformerRenderersFactory(MuxerWrapper muxerWrapper2, Transformation transformation2) {
            this.muxerWrapper = muxerWrapper2;
            this.transformation = transformation2;
        }

        public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
            char c = 1;
            Renderer[] rendererArr = new Renderer[((this.transformation.removeAudio || this.transformation.removeVideo) ? 1 : 2)];
            if (!this.transformation.removeAudio) {
                rendererArr[0] = new TransformerAudioRenderer(this.muxerWrapper, this.mediaClock, this.transformation);
            } else {
                c = 0;
            }
            if (!this.transformation.removeVideo) {
                rendererArr[c] = new TransformerVideoRenderer(this.muxerWrapper, this.mediaClock, this.transformation);
            }
            return rendererArr;
        }
    }

    private final class TransformerAnalyticsListener implements AnalyticsListener {
        private final MediaItem mediaItem;
        private final MuxerWrapper muxerWrapper;

        public /* synthetic */ void onAudioAttributesChanged(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
            AnalyticsListener.CC.$default$onAudioAttributesChanged(this, eventTime, audioAttributes);
        }

        public /* synthetic */ void onAudioCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
            AnalyticsListener.CC.$default$onAudioCodecError(this, eventTime, exc);
        }

        public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            AnalyticsListener.CC.$default$onAudioDecoderInitialized(this, eventTime, str, j);
        }

        public /* synthetic */ void onAudioDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
            AnalyticsListener.CC.$default$onAudioDecoderInitialized(this, eventTime, str, j, j2);
        }

        public /* synthetic */ void onAudioDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            AnalyticsListener.CC.$default$onAudioDecoderReleased(this, eventTime, str);
        }

        public /* synthetic */ void onAudioDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onAudioDisabled(this, eventTime, decoderCounters);
        }

        public /* synthetic */ void onAudioEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onAudioEnabled(this, eventTime, decoderCounters);
        }

        public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            AnalyticsListener.CC.$default$onAudioInputFormatChanged(this, eventTime, format);
        }

        public /* synthetic */ void onAudioInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            AnalyticsListener.CC.$default$onAudioInputFormatChanged(this, eventTime, format, decoderReuseEvaluation);
        }

        public /* synthetic */ void onAudioPositionAdvancing(AnalyticsListener.EventTime eventTime, long j) {
            AnalyticsListener.CC.$default$onAudioPositionAdvancing(this, eventTime, j);
        }

        public /* synthetic */ void onAudioSessionIdChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onAudioSessionIdChanged(this, eventTime, i);
        }

        public /* synthetic */ void onAudioSinkError(AnalyticsListener.EventTime eventTime, Exception exc) {
            AnalyticsListener.CC.$default$onAudioSinkError(this, eventTime, exc);
        }

        public /* synthetic */ void onAudioUnderrun(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            AnalyticsListener.CC.$default$onAudioUnderrun(this, eventTime, i, j, j2);
        }

        public /* synthetic */ void onAvailableCommandsChanged(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
            AnalyticsListener.CC.$default$onAvailableCommandsChanged(this, eventTime, commands);
        }

        public /* synthetic */ void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
            AnalyticsListener.CC.$default$onBandwidthEstimate(this, eventTime, i, j, j2);
        }

        public /* synthetic */ void onDecoderDisabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onDecoderDisabled(this, eventTime, i, decoderCounters);
        }

        public /* synthetic */ void onDecoderEnabled(AnalyticsListener.EventTime eventTime, int i, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onDecoderEnabled(this, eventTime, i, decoderCounters);
        }

        public /* synthetic */ void onDecoderInitialized(AnalyticsListener.EventTime eventTime, int i, String str, long j) {
            AnalyticsListener.CC.$default$onDecoderInitialized(this, eventTime, i, str, j);
        }

        public /* synthetic */ void onDecoderInputFormatChanged(AnalyticsListener.EventTime eventTime, int i, Format format) {
            AnalyticsListener.CC.$default$onDecoderInputFormatChanged(this, eventTime, i, format);
        }

        public /* synthetic */ void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onDownstreamFormatChanged(this, eventTime, mediaLoadData);
        }

        public /* synthetic */ void onDrmKeysLoaded(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysLoaded(this, eventTime);
        }

        public /* synthetic */ void onDrmKeysRemoved(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysRemoved(this, eventTime);
        }

        public /* synthetic */ void onDrmKeysRestored(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmKeysRestored(this, eventTime);
        }

        public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmSessionAcquired(this, eventTime);
        }

        public /* synthetic */ void onDrmSessionAcquired(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onDrmSessionAcquired(this, eventTime, i);
        }

        public /* synthetic */ void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
            AnalyticsListener.CC.$default$onDrmSessionManagerError(this, eventTime, exc);
        }

        public /* synthetic */ void onDrmSessionReleased(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onDrmSessionReleased(this, eventTime);
        }

        public /* synthetic */ void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
            AnalyticsListener.CC.$default$onDroppedVideoFrames(this, eventTime, i, j);
        }

        public /* synthetic */ void onEvents(Player player, AnalyticsListener.Events events) {
            AnalyticsListener.CC.$default$onEvents(this, player, events);
        }

        public /* synthetic */ void onIsLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onIsLoadingChanged(this, eventTime, z);
        }

        public /* synthetic */ void onIsPlayingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onIsPlayingChanged(this, eventTime, z);
        }

        public /* synthetic */ void onLoadCanceled(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadCanceled(this, eventTime, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onLoadCompleted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadCompleted(this, eventTime, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
            AnalyticsListener.CC.$default$onLoadError(this, eventTime, loadEventInfo, mediaLoadData, iOException, z);
        }

        public /* synthetic */ void onLoadStarted(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onLoadStarted(this, eventTime, loadEventInfo, mediaLoadData);
        }

        public /* synthetic */ void onLoadingChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onLoadingChanged(this, eventTime, z);
        }

        public /* synthetic */ void onMaxSeekToPreviousPositionChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onMaxSeekToPreviousPositionChanged(this, eventTime, i);
        }

        public /* synthetic */ void onMediaItemTransition(AnalyticsListener.EventTime eventTime, MediaItem mediaItem2, int i) {
            AnalyticsListener.CC.$default$onMediaItemTransition(this, eventTime, mediaItem2, i);
        }

        public /* synthetic */ void onMediaMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
            AnalyticsListener.CC.$default$onMediaMetadataChanged(this, eventTime, mediaMetadata);
        }

        public /* synthetic */ void onMetadata(AnalyticsListener.EventTime eventTime, Metadata metadata) {
            AnalyticsListener.CC.$default$onMetadata(this, eventTime, metadata);
        }

        public /* synthetic */ void onPlayWhenReadyChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            AnalyticsListener.CC.$default$onPlayWhenReadyChanged(this, eventTime, z, i);
        }

        public /* synthetic */ void onPlaybackParametersChanged(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
            AnalyticsListener.CC.$default$onPlaybackParametersChanged(this, eventTime, playbackParameters);
        }

        public /* synthetic */ void onPlaybackSuppressionReasonChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onPlaybackSuppressionReasonChanged(this, eventTime, i);
        }

        public /* synthetic */ void onPlayerReleased(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onPlayerReleased(this, eventTime);
        }

        public /* synthetic */ void onPlayerStateChanged(AnalyticsListener.EventTime eventTime, boolean z, int i) {
            AnalyticsListener.CC.$default$onPlayerStateChanged(this, eventTime, z, i);
        }

        public /* synthetic */ void onPlaylistMetadataChanged(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
            AnalyticsListener.CC.$default$onPlaylistMetadataChanged(this, eventTime, mediaMetadata);
        }

        public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onPositionDiscontinuity(this, eventTime, i);
        }

        public /* synthetic */ void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            AnalyticsListener.CC.$default$onPositionDiscontinuity(this, eventTime, positionInfo, positionInfo2, i);
        }

        public /* synthetic */ void onRenderedFirstFrame(AnalyticsListener.EventTime eventTime, Object obj, long j) {
            AnalyticsListener.CC.$default$onRenderedFirstFrame(this, eventTime, obj, j);
        }

        public /* synthetic */ void onRepeatModeChanged(AnalyticsListener.EventTime eventTime, int i) {
            AnalyticsListener.CC.$default$onRepeatModeChanged(this, eventTime, i);
        }

        public /* synthetic */ void onSeekBackIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
            AnalyticsListener.CC.$default$onSeekBackIncrementChanged(this, eventTime, j);
        }

        public /* synthetic */ void onSeekForwardIncrementChanged(AnalyticsListener.EventTime eventTime, long j) {
            AnalyticsListener.CC.$default$onSeekForwardIncrementChanged(this, eventTime, j);
        }

        public /* synthetic */ void onSeekProcessed(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onSeekProcessed(this, eventTime);
        }

        public /* synthetic */ void onSeekStarted(AnalyticsListener.EventTime eventTime) {
            AnalyticsListener.CC.$default$onSeekStarted(this, eventTime);
        }

        public /* synthetic */ void onShuffleModeChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onShuffleModeChanged(this, eventTime, z);
        }

        public /* synthetic */ void onSkipSilenceEnabledChanged(AnalyticsListener.EventTime eventTime, boolean z) {
            AnalyticsListener.CC.$default$onSkipSilenceEnabledChanged(this, eventTime, z);
        }

        public /* synthetic */ void onStaticMetadataChanged(AnalyticsListener.EventTime eventTime, List list) {
            AnalyticsListener.CC.$default$onStaticMetadataChanged(this, eventTime, list);
        }

        public /* synthetic */ void onSurfaceSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2) {
            AnalyticsListener.CC.$default$onSurfaceSizeChanged(this, eventTime, i, i2);
        }

        public /* synthetic */ void onUpstreamDiscarded(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
            AnalyticsListener.CC.$default$onUpstreamDiscarded(this, eventTime, mediaLoadData);
        }

        public /* synthetic */ void onVideoCodecError(AnalyticsListener.EventTime eventTime, Exception exc) {
            AnalyticsListener.CC.$default$onVideoCodecError(this, eventTime, exc);
        }

        public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j) {
            AnalyticsListener.CC.$default$onVideoDecoderInitialized(this, eventTime, str, j);
        }

        public /* synthetic */ void onVideoDecoderInitialized(AnalyticsListener.EventTime eventTime, String str, long j, long j2) {
            AnalyticsListener.CC.$default$onVideoDecoderInitialized(this, eventTime, str, j, j2);
        }

        public /* synthetic */ void onVideoDecoderReleased(AnalyticsListener.EventTime eventTime, String str) {
            AnalyticsListener.CC.$default$onVideoDecoderReleased(this, eventTime, str);
        }

        public /* synthetic */ void onVideoDisabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onVideoDisabled(this, eventTime, decoderCounters);
        }

        public /* synthetic */ void onVideoEnabled(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
            AnalyticsListener.CC.$default$onVideoEnabled(this, eventTime, decoderCounters);
        }

        public /* synthetic */ void onVideoFrameProcessingOffset(AnalyticsListener.EventTime eventTime, long j, int i) {
            AnalyticsListener.CC.$default$onVideoFrameProcessingOffset(this, eventTime, j, i);
        }

        public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format) {
            AnalyticsListener.CC.$default$onVideoInputFormatChanged(this, eventTime, format);
        }

        public /* synthetic */ void onVideoInputFormatChanged(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            AnalyticsListener.CC.$default$onVideoInputFormatChanged(this, eventTime, format, decoderReuseEvaluation);
        }

        public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, int i, int i2, int i3, float f) {
            AnalyticsListener.CC.$default$onVideoSizeChanged(this, eventTime, i, i2, i3, f);
        }

        public /* synthetic */ void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
            AnalyticsListener.CC.$default$onVideoSizeChanged(this, eventTime, videoSize);
        }

        public /* synthetic */ void onVolumeChanged(AnalyticsListener.EventTime eventTime, float f) {
            AnalyticsListener.CC.$default$onVolumeChanged(this, eventTime, f);
        }

        public TransformerAnalyticsListener(MediaItem mediaItem2, MuxerWrapper muxerWrapper2) {
            this.mediaItem = mediaItem2;
            this.muxerWrapper = muxerWrapper2;
        }

        public void onPlaybackStateChanged(AnalyticsListener.EventTime eventTime, int i) {
            if (i == 4) {
                handleTransformationEnded((Exception) null);
            }
        }

        public void onTimelineChanged(AnalyticsListener.EventTime eventTime, int i) {
            if (Transformer.this.progressState == 0) {
                Timeline.Window window = new Timeline.Window();
                eventTime.timeline.getWindow(0, window);
                if (!window.isPlaceholder) {
                    long j = window.durationUs;
                    int unused = Transformer.this.progressState = (j <= 0 || j == -9223372036854775807L) ? 2 : 1;
                    ((SimpleExoPlayer) Assertions.checkNotNull(Transformer.this.player)).play();
                }
            }
        }

        public void onTracksChanged(AnalyticsListener.EventTime eventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            if (this.muxerWrapper.getTrackCount() == 0) {
                handleTransformationEnded(new IllegalStateException("The output does not contain any tracks. Check that at least one of the input sample formats is supported."));
            }
        }

        public void onPlayerError(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
            handleTransformationEnded(playbackException);
        }

        private void handleTransformationEnded(Exception exc) {
            try {
                Transformer.this.releaseResources(false);
            } catch (IllegalStateException e) {
                if (exc == null) {
                    exc = e;
                }
            }
            if (exc == null) {
                Transformer.this.listener.onTransformationCompleted(this.mediaItem);
            } else {
                Transformer.this.listener.onTransformationError(this.mediaItem, exc);
            }
        }
    }
}
