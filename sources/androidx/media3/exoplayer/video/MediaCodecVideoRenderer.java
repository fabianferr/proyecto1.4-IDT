package androidx.media3.exoplayer.video;

import android.content.Context;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import android.view.Display;
import android.view.Surface;
import androidx.emoji2.text.ConcurrencyHelpers$$ExternalSyntheticLambda1;
import androidx.media3.common.ColorInfo;
import androidx.media3.common.DebugViewProvider;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.FrameInfo;
import androidx.media3.common.SurfaceInfo;
import androidx.media3.common.VideoFrameProcessingException;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.Scopes;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public class MediaCodecVideoRenderer extends MediaCodecRenderer {
    private static final int HEVC_MAX_INPUT_SIZE_THRESHOLD = 2097152;
    private static final float INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR = 1.5f;
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int[] STANDARD_LONG_EDGE_VIDEO_PX = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private static final String TAG = "MediaCodecVideoRenderer";
    private static final long TUNNELING_EOS_PRESENTATION_TIME_US = Long.MAX_VALUE;
    private static boolean deviceNeedsSetOutputSurfaceWorkaround;
    private static boolean evaluatedDeviceNeedsSetOutputSurfaceWorkaround;
    private final long allowedJoiningTimeMs;
    private int buffersInCodecCount;
    private boolean codecHandlesHdr10PlusOutOfBandMetadata;
    private CodecMaxValues codecMaxValues;
    private boolean codecNeedsSetOutputSurfaceWorkaround;
    private int consecutiveDroppedFrameCount;
    /* access modifiers changed from: private */
    public final Context context;
    private VideoSize decodedVideoSize;
    private final boolean deviceNeedsNoPostProcessWorkaround;
    private Surface displaySurface;
    private long droppedFrameAccumulationStartTimeMs;
    private int droppedFrames;
    private final VideoRendererEventListener.EventDispatcher eventDispatcher;
    private VideoFrameMetadataListener frameMetadataListener;
    private final VideoFrameReleaseHelper frameReleaseHelper;
    private boolean haveReportedFirstFrameRenderedForCurrentSurface;
    /* access modifiers changed from: private */
    public long initialPositionUs;
    private long joiningDeadlineMs;
    private long lastBufferPresentationTimeUs;
    private long lastFrameReleaseTimeNs;
    /* access modifiers changed from: private */
    public long lastRenderRealtimeUs;
    private final int maxDroppedFramesToNotify;
    private boolean mayRenderFirstFrameAfterEnableIfNotStarted;
    private PlaceholderSurface placeholderSurface;
    private boolean renderedFirstFrameAfterEnable;
    private boolean renderedFirstFrameAfterReset;
    private VideoSize reportedVideoSize;
    private int scalingMode;
    private long totalVideoFrameProcessingOffsetUs;
    private boolean tunneling;
    private int tunnelingAudioSessionId;
    OnFrameRenderedListenerV23 tunnelingOnFrameRenderedListener;
    private int videoFrameProcessingOffsetCount;
    private final VideoFrameProcessorManager videoFrameProcessorManager;

    private static boolean isBufferLate(long j) {
        return j < -30000;
    }

    private static boolean isBufferVeryLate(long j) {
        return j < -500000;
    }

    public String getName() {
        return TAG;
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector) {
        this(context2, mediaCodecSelector, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j) {
        this(context2, mediaCodecSelector, j, (Handler) null, (VideoRendererEventListener) null, 0);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, false, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, MediaCodecAdapter.Factory.DEFAULT, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i) {
        this(context2, factory, mediaCodecSelector, j, z, handler, videoRendererEventListener, i, 30.0f);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaCodecVideoRenderer(Context context2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, long j, boolean z, Handler handler, VideoRendererEventListener videoRendererEventListener, int i, float f) {
        super(2, factory, mediaCodecSelector, z, f);
        this.allowedJoiningTimeMs = j;
        this.maxDroppedFramesToNotify = i;
        Context applicationContext = context2.getApplicationContext();
        this.context = applicationContext;
        VideoFrameReleaseHelper videoFrameReleaseHelper = new VideoFrameReleaseHelper(applicationContext);
        this.frameReleaseHelper = videoFrameReleaseHelper;
        Handler handler2 = handler;
        VideoRendererEventListener videoRendererEventListener2 = videoRendererEventListener;
        this.eventDispatcher = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.videoFrameProcessorManager = new VideoFrameProcessorManager(videoFrameReleaseHelper, this);
        this.deviceNeedsNoPostProcessWorkaround = deviceNeedsNoPostProcessWorkaround();
        this.joiningDeadlineMs = -9223372036854775807L;
        this.scalingMode = 1;
        this.decodedVideoSize = VideoSize.UNKNOWN;
        this.tunnelingAudioSessionId = 0;
        clearReportedVideoSize();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int supportsFormat(androidx.media3.exoplayer.mediacodec.MediaCodecSelector r11, androidx.media3.common.Format r12) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            r10 = this;
            java.lang.String r0 = r12.sampleMimeType
            boolean r0 = androidx.media3.common.MimeTypes.isVideo(r0)
            r1 = 0
            if (r0 != 0) goto L_0x000e
            int r11 = androidx.media3.exoplayer.RendererCapabilities.CC.create(r1)
            return r11
        L_0x000e:
            androidx.media3.common.DrmInitData r0 = r12.drmInitData
            r2 = 1
            if (r0 == 0) goto L_0x0015
            r0 = 1
            goto L_0x0016
        L_0x0015:
            r0 = 0
        L_0x0016:
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r0, r1)
            if (r0 == 0) goto L_0x002a
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x002a
            android.content.Context r3 = r10.context
            java.util.List r3 = getDecoderInfos(r3, r11, r12, r1, r1)
        L_0x002a:
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0035
            int r11 = androidx.media3.exoplayer.RendererCapabilities.CC.create(r2)
            return r11
        L_0x0035:
            boolean r4 = supportsFormatDrm(r12)
            if (r4 != 0) goto L_0x0041
            r11 = 2
            int r11 = androidx.media3.exoplayer.RendererCapabilities.CC.create(r11)
            return r11
        L_0x0041:
            java.lang.Object r4 = r3.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r4 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r4
            boolean r5 = r4.isFormatSupported(r12)
            if (r5 != 0) goto L_0x0067
            r6 = 1
        L_0x004e:
            int r7 = r3.size()
            if (r6 >= r7) goto L_0x0067
            java.lang.Object r7 = r3.get(r6)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r7 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r7
            boolean r8 = r7.isFormatSupported(r12)
            if (r8 == 0) goto L_0x0064
            r4 = r7
            r3 = 0
            r5 = 1
            goto L_0x0068
        L_0x0064:
            int r6 = r6 + 1
            goto L_0x004e
        L_0x0067:
            r3 = 1
        L_0x0068:
            if (r5 == 0) goto L_0x006c
            r6 = 4
            goto L_0x006d
        L_0x006c:
            r6 = 3
        L_0x006d:
            boolean r7 = r4.isSeamlessAdaptationSupported(r12)
            if (r7 == 0) goto L_0x0076
            r7 = 16
            goto L_0x0078
        L_0x0076:
            r7 = 8
        L_0x0078:
            boolean r4 = r4.hardwareAccelerated
            if (r4 == 0) goto L_0x007f
            r4 = 64
            goto L_0x0080
        L_0x007f:
            r4 = 0
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3 = 128(0x80, float:1.794E-43)
            goto L_0x0086
        L_0x0085:
            r3 = 0
        L_0x0086:
            int r8 = androidx.media3.common.util.Util.SDK_INT
            r9 = 26
            if (r8 < r9) goto L_0x00a0
            java.lang.String r8 = "video/dolby-vision"
            java.lang.String r9 = r12.sampleMimeType
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x00a0
            android.content.Context r8 = r10.context
            boolean r8 = androidx.media3.exoplayer.video.MediaCodecVideoRenderer.Api26.doesDisplaySupportDolbyVision(r8)
            if (r8 != 0) goto L_0x00a0
            r3 = 256(0x100, float:3.59E-43)
        L_0x00a0:
            if (r5 == 0) goto L_0x00c6
            android.content.Context r5 = r10.context
            java.util.List r11 = getDecoderInfos(r5, r11, r12, r0, r2)
            boolean r0 = r11.isEmpty()
            if (r0 != 0) goto L_0x00c6
            java.util.List r11 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.getDecoderInfosSortedByFormatSupport(r11, r12)
            java.lang.Object r11 = r11.get(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r11 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r11
            boolean r0 = r11.isFormatSupported(r12)
            if (r0 == 0) goto L_0x00c6
            boolean r11 = r11.isSeamlessAdaptationSupported(r12)
            if (r11 == 0) goto L_0x00c6
            r1 = 32
        L_0x00c6:
            int r11 = androidx.media3.exoplayer.RendererCapabilities.CC.create(r6, r7, r1, r4, r3)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.supportsFormat(androidx.media3.exoplayer.mediacodec.MediaCodecSelector, androidx.media3.common.Format):int");
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> getDecoderInfos(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.getDecoderInfosSortedByFormatSupport(getDecoderInfos(this.context, mediaCodecSelector, format, z, this.tunneling), format);
    }

    private static List<MediaCodecInfo> getDecoderInfos(Context context2, MediaCodecSelector mediaCodecSelector, Format format, boolean z, boolean z2) throws MediaCodecUtil.DecoderQueryException {
        if (format.sampleMimeType == null) {
            return ImmutableList.of();
        }
        if (Util.SDK_INT >= 26 && "video/dolby-vision".equals(format.sampleMimeType) && !Api26.doesDisplaySupportDolbyVision(context2)) {
            List<MediaCodecInfo> alternativeDecoderInfos = MediaCodecUtil.getAlternativeDecoderInfos(mediaCodecSelector, format, z, z2);
            if (!alternativeDecoderInfos.isEmpty()) {
                return alternativeDecoderInfos;
            }
        }
        return MediaCodecUtil.getDecoderInfosSoftMatch(mediaCodecSelector, format, z, z2);
    }

    private static final class Api26 {
        private Api26() {
        }

        public static boolean doesDisplaySupportDolbyVision(Context context) {
            DisplayManager displayManager = (DisplayManager) context.getSystemService(ServerProtocol.DIALOG_PARAM_DISPLAY);
            Display display = displayManager != null ? displayManager.getDisplay(0) : null;
            if (display == null || !display.isHdr()) {
                return false;
            }
            for (int i : display.getHdrCapabilities().getSupportedHdrTypes()) {
                if (i == 1) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onEnabled(boolean z, boolean z2) throws ExoPlaybackException {
        super.onEnabled(z, z2);
        boolean z3 = getConfiguration().tunneling;
        Assertions.checkState(!z3 || this.tunnelingAudioSessionId != 0);
        if (this.tunneling != z3) {
            this.tunneling = z3;
            releaseCodec();
        }
        this.eventDispatcher.enabled(this.decoderCounters);
        this.mayRenderFirstFrameAfterEnableIfNotStarted = z2;
        this.renderedFirstFrameAfterEnable = false;
    }

    /* access modifiers changed from: protected */
    public void onPositionReset(long j, boolean z) throws ExoPlaybackException {
        super.onPositionReset(j, z);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.flush();
        }
        clearRenderedFirstFrame();
        this.frameReleaseHelper.onPositionReset();
        this.lastBufferPresentationTimeUs = -9223372036854775807L;
        this.initialPositionUs = -9223372036854775807L;
        this.consecutiveDroppedFrameCount = 0;
        if (z) {
            setJoiningDeadlineMs();
        } else {
            this.joiningDeadlineMs = -9223372036854775807L;
        }
    }

    public boolean isEnded() {
        boolean isEnded = super.isEnded();
        return this.videoFrameProcessorManager.isEnabled() ? isEnded & this.videoFrameProcessorManager.releasedLastFrame() : isEnded;
    }

    public boolean isReady() {
        PlaceholderSurface placeholderSurface2;
        if (super.isReady() && ((!this.videoFrameProcessorManager.isEnabled() || this.videoFrameProcessorManager.isReady()) && (this.renderedFirstFrameAfterReset || (((placeholderSurface2 = this.placeholderSurface) != null && this.displaySurface == placeholderSurface2) || getCodec() == null || this.tunneling)))) {
            this.joiningDeadlineMs = -9223372036854775807L;
            return true;
        } else if (this.joiningDeadlineMs == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.joiningDeadlineMs) {
                return true;
            }
            this.joiningDeadlineMs = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
        super.onStarted();
        this.droppedFrames = 0;
        this.droppedFrameAccumulationStartTimeMs = SystemClock.elapsedRealtime();
        this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
        this.totalVideoFrameProcessingOffsetUs = 0;
        this.videoFrameProcessingOffsetCount = 0;
        this.frameReleaseHelper.onStarted();
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
        this.joiningDeadlineMs = -9223372036854775807L;
        maybeNotifyDroppedFrames();
        maybeNotifyVideoFrameProcessingOffset();
        this.frameReleaseHelper.onStopped();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public void onDisabled() {
        clearReportedVideoSize();
        clearRenderedFirstFrame();
        this.haveReportedFirstFrameRenderedForCurrentSurface = false;
        this.tunnelingOnFrameRenderedListener = null;
        try {
            super.onDisabled();
        } finally {
            this.eventDispatcher.disabled(this.decoderCounters);
            this.eventDispatcher.videoSizeChanged(VideoSize.UNKNOWN);
        }
    }

    /* access modifiers changed from: protected */
    public void onReset() {
        try {
            super.onReset();
        } finally {
            if (this.videoFrameProcessorManager.isEnabled()) {
                this.videoFrameProcessorManager.reset();
            }
            if (this.placeholderSurface != null) {
                releasePlaceholderSurface();
            }
        }
    }

    public void handleMessage(int i, Object obj) throws ExoPlaybackException {
        Surface surface;
        if (i == 1) {
            setOutput(obj);
        } else if (i == 7) {
            this.frameMetadataListener = (VideoFrameMetadataListener) obj;
        } else if (i == 10) {
            int intValue = ((Integer) obj).intValue();
            if (this.tunnelingAudioSessionId != intValue) {
                this.tunnelingAudioSessionId = intValue;
                if (this.tunneling) {
                    releaseCodec();
                }
            }
        } else if (i == 4) {
            this.scalingMode = ((Integer) obj).intValue();
            MediaCodecAdapter codec = getCodec();
            if (codec != null) {
                codec.setVideoScalingMode(this.scalingMode);
            }
        } else if (i == 5) {
            this.frameReleaseHelper.setChangeFrameRateStrategy(((Integer) obj).intValue());
        } else if (i == 13) {
            this.videoFrameProcessorManager.setVideoEffects((List) Assertions.checkNotNull(obj));
        } else if (i != 14) {
            super.handleMessage(i, obj);
        } else {
            Size size = (Size) Assertions.checkNotNull(obj);
            if (size.getWidth() != 0 && size.getHeight() != 0 && (surface = this.displaySurface) != null) {
                this.videoFrameProcessorManager.setOutputSurfaceInfo(surface, size);
            }
        }
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setOutput(java.lang.Object r5) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r4 = this;
            boolean r0 = r5 instanceof android.view.Surface
            if (r0 == 0) goto L_0x0007
            android.view.Surface r5 = (android.view.Surface) r5
            goto L_0x0008
        L_0x0007:
            r5 = 0
        L_0x0008:
            if (r5 != 0) goto L_0x0026
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r0 == 0) goto L_0x0010
            r5 = r0
            goto L_0x0026
        L_0x0010:
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = r4.getCodecInfo()
            if (r0 == 0) goto L_0x0026
            boolean r1 = r4.shouldUsePlaceholderSurface(r0)
            if (r1 == 0) goto L_0x0026
            android.content.Context r5 = r4.context
            boolean r0 = r0.secure
            androidx.media3.exoplayer.video.PlaceholderSurface r5 = androidx.media3.exoplayer.video.PlaceholderSurface.newInstanceV17(r5, r0)
            r4.placeholderSurface = r5
        L_0x0026:
            android.view.Surface r0 = r4.displaySurface
            if (r0 == r5) goto L_0x0092
            r4.displaySurface = r5
            androidx.media3.exoplayer.video.VideoFrameReleaseHelper r0 = r4.frameReleaseHelper
            r0.onSurfaceChanged(r5)
            r0 = 0
            r4.haveReportedFirstFrameRenderedForCurrentSurface = r0
            int r0 = r4.getState()
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r1 = r4.getCodec()
            if (r1 == 0) goto L_0x005c
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer$VideoFrameProcessorManager r2 = r4.videoFrameProcessorManager
            boolean r2 = r2.isEnabled()
            if (r2 != 0) goto L_0x005c
            int r2 = androidx.media3.common.util.Util.SDK_INT
            r3 = 23
            if (r2 < r3) goto L_0x0056
            if (r5 == 0) goto L_0x0056
            boolean r2 = r4.codecNeedsSetOutputSurfaceWorkaround
            if (r2 != 0) goto L_0x0056
            r4.setOutputSurfaceV23(r1, r5)
            goto L_0x005c
        L_0x0056:
            r4.releaseCodec()
            r4.maybeInitCodecOrBypass()
        L_0x005c:
            if (r5 == 0) goto L_0x007e
            androidx.media3.exoplayer.video.PlaceholderSurface r1 = r4.placeholderSurface
            if (r5 == r1) goto L_0x007e
            r4.maybeRenotifyVideoSizeChanged()
            r4.clearRenderedFirstFrame()
            r1 = 2
            if (r0 != r1) goto L_0x006e
            r4.setJoiningDeadlineMs()
        L_0x006e:
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer$VideoFrameProcessorManager r0 = r4.videoFrameProcessorManager
            boolean r0 = r0.isEnabled()
            if (r0 == 0) goto L_0x009e
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer$VideoFrameProcessorManager r0 = r4.videoFrameProcessorManager
            androidx.media3.common.util.Size r1 = androidx.media3.common.util.Size.UNKNOWN
            r0.setOutputSurfaceInfo(r5, r1)
            goto L_0x009e
        L_0x007e:
            r4.clearReportedVideoSize()
            r4.clearRenderedFirstFrame()
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer$VideoFrameProcessorManager r5 = r4.videoFrameProcessorManager
            boolean r5 = r5.isEnabled()
            if (r5 == 0) goto L_0x009e
            androidx.media3.exoplayer.video.MediaCodecVideoRenderer$VideoFrameProcessorManager r5 = r4.videoFrameProcessorManager
            r5.clearOutputSurfaceInfo()
            goto L_0x009e
        L_0x0092:
            if (r5 == 0) goto L_0x009e
            androidx.media3.exoplayer.video.PlaceholderSurface r0 = r4.placeholderSurface
            if (r5 == r0) goto L_0x009e
            r4.maybeRenotifyVideoSizeChanged()
            r4.maybeRenotifyRenderedFirstFrame()
        L_0x009e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.setOutput(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean shouldInitCodec(MediaCodecInfo mediaCodecInfo) {
        return this.displaySurface != null || shouldUsePlaceholderSurface(mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public boolean getCodecNeedsEosPropagation() {
        return this.tunneling && Util.SDK_INT < 23;
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration getMediaCodecConfiguration(MediaCodecInfo mediaCodecInfo, Format format, MediaCrypto mediaCrypto, float f) {
        Surface surface;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (!(placeholderSurface2 == null || placeholderSurface2.secure == mediaCodecInfo.secure)) {
            releasePlaceholderSurface();
        }
        String str = mediaCodecInfo.codecMimeType;
        CodecMaxValues codecMaxValues2 = getCodecMaxValues(mediaCodecInfo, format, getStreamFormats());
        this.codecMaxValues = codecMaxValues2;
        MediaFormat mediaFormat = getMediaFormat(format, str, codecMaxValues2, f, this.deviceNeedsNoPostProcessWorkaround, this.tunneling ? this.tunnelingAudioSessionId : 0);
        if (this.displaySurface == null) {
            if (shouldUsePlaceholderSurface(mediaCodecInfo)) {
                if (this.placeholderSurface == null) {
                    this.placeholderSurface = PlaceholderSurface.newInstanceV17(this.context, mediaCodecInfo.secure);
                }
                this.displaySurface = this.placeholderSurface;
            } else {
                throw new IllegalStateException();
            }
        }
        if (this.videoFrameProcessorManager.isEnabled()) {
            mediaFormat = this.videoFrameProcessorManager.amendMediaFormatKeys(mediaFormat);
        }
        if (this.videoFrameProcessorManager.isEnabled()) {
            surface = this.videoFrameProcessorManager.getInputSurface();
        } else {
            surface = this.displaySurface;
        }
        return MediaCodecAdapter.Configuration.createForVideoDecoding(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation canReuseCodec(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        int i;
        DecoderReuseEvaluation canReuseCodec = mediaCodecInfo.canReuseCodec(format, format2);
        int i2 = canReuseCodec.discardReasons;
        if (format2.width > this.codecMaxValues.width || format2.height > this.codecMaxValues.height) {
            i2 |= 256;
        }
        if (getMaxInputSize(mediaCodecInfo, format2) > this.codecMaxValues.inputSize) {
            i2 |= 64;
        }
        int i3 = i2;
        String str = mediaCodecInfo.name;
        if (i3 != 0) {
            i = 0;
        } else {
            i = canReuseCodec.result;
        }
        return new DecoderReuseEvaluation(str, format, format2, i, i3);
    }

    public void render(long j, long j2) throws ExoPlaybackException {
        super.render(j, j2);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.releaseProcessedFrames(j, j2);
        }
    }

    /* access modifiers changed from: protected */
    public void resetCodecStateForFlush() {
        super.resetCodecStateForFlush();
        this.buffersInCodecCount = 0;
    }

    public void setPlaybackSpeed(float f, float f2) throws ExoPlaybackException {
        super.setPlaybackSpeed(f, f2);
        this.frameReleaseHelper.onPlaybackSpeed(f);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007a, code lost:
        if (r3.equals("video/av01") == false) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        r10 = ((java.lang.Integer) r10.first).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getCodecMaxInputSize(androidx.media3.exoplayer.mediacodec.MediaCodecInfo r9, androidx.media3.common.Format r10) {
        /*
            int r0 = r10.width
            int r1 = r10.height
            r2 = -1
            if (r0 == r2) goto L_0x00e9
            if (r1 != r2) goto L_0x000b
            goto L_0x00e9
        L_0x000b:
            java.lang.String r3 = r10.sampleMimeType
            java.lang.String r4 = "video/dolby-vision"
            boolean r4 = r4.equals(r3)
            java.lang.String r5 = "video/avc"
            java.lang.String r6 = "video/hevc"
            r7 = 1
            r8 = 2
            if (r4 == 0) goto L_0x0034
            android.util.Pair r10 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.getCodecProfileAndLevel(r10)
            if (r10 == 0) goto L_0x0033
            java.lang.Object r10 = r10.first
            java.lang.Integer r10 = (java.lang.Integer) r10
            int r10 = r10.intValue()
            r3 = 512(0x200, float:7.175E-43)
            if (r10 == r3) goto L_0x0031
            if (r10 == r7) goto L_0x0031
            if (r10 != r8) goto L_0x0033
        L_0x0031:
            r3 = r5
            goto L_0x0034
        L_0x0033:
            r3 = r6
        L_0x0034:
            r3.hashCode()
            int r10 = r3.hashCode()
            r4 = 4
            switch(r10) {
                case -1664118616: goto L_0x007d;
                case -1662735862: goto L_0x0074;
                case -1662541442: goto L_0x006b;
                case 1187890754: goto L_0x0060;
                case 1331836730: goto L_0x0057;
                case 1599127256: goto L_0x004c;
                case 1599127257: goto L_0x0041;
                default: goto L_0x003f;
            }
        L_0x003f:
            r7 = -1
            goto L_0x0087
        L_0x0041:
            java.lang.String r10 = "video/x-vnd.on2.vp9"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x004a
            goto L_0x003f
        L_0x004a:
            r7 = 6
            goto L_0x0087
        L_0x004c:
            java.lang.String r10 = "video/x-vnd.on2.vp8"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0055
            goto L_0x003f
        L_0x0055:
            r7 = 5
            goto L_0x0087
        L_0x0057:
            boolean r10 = r3.equals(r5)
            if (r10 != 0) goto L_0x005e
            goto L_0x003f
        L_0x005e:
            r7 = 4
            goto L_0x0087
        L_0x0060:
            java.lang.String r10 = "video/mp4v-es"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0069
            goto L_0x003f
        L_0x0069:
            r7 = 3
            goto L_0x0087
        L_0x006b:
            boolean r10 = r3.equals(r6)
            if (r10 != 0) goto L_0x0072
            goto L_0x003f
        L_0x0072:
            r7 = 2
            goto L_0x0087
        L_0x0074:
            java.lang.String r10 = "video/av01"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0087
            goto L_0x003f
        L_0x007d:
            java.lang.String r10 = "video/3gpp"
            boolean r10 = r3.equals(r10)
            if (r10 != 0) goto L_0x0086
            goto L_0x003f
        L_0x0086:
            r7 = 0
        L_0x0087:
            switch(r7) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00e2;
                case 2: goto L_0x00d5;
                case 3: goto L_0x00e2;
                case 4: goto L_0x0092;
                case 5: goto L_0x00e2;
                case 6: goto L_0x008b;
                default: goto L_0x008a;
            }
        L_0x008a:
            return r2
        L_0x008b:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r4)
            return r9
        L_0x0092:
            java.lang.String r10 = "BRAVIA 4K 2015"
            java.lang.String r3 = androidx.media3.common.util.Util.MODEL
            boolean r10 = r10.equals(r3)
            if (r10 != 0) goto L_0x00d4
            java.lang.String r10 = "Amazon"
            java.lang.String r3 = androidx.media3.common.util.Util.MANUFACTURER
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x00bf
            java.lang.String r10 = "KFSOWI"
            java.lang.String r3 = androidx.media3.common.util.Util.MODEL
            boolean r10 = r10.equals(r3)
            if (r10 != 0) goto L_0x00d4
            java.lang.String r10 = "AFTS"
            java.lang.String r3 = androidx.media3.common.util.Util.MODEL
            boolean r10 = r10.equals(r3)
            if (r10 == 0) goto L_0x00bf
            boolean r9 = r9.secure
            if (r9 == 0) goto L_0x00bf
            goto L_0x00d4
        L_0x00bf:
            r9 = 16
            int r10 = androidx.media3.common.util.Util.ceilDivide((int) r0, (int) r9)
            int r0 = androidx.media3.common.util.Util.ceilDivide((int) r1, (int) r9)
            int r10 = r10 * r0
            int r10 = r10 * 16
            int r10 = r10 * 16
            int r9 = getMaxSampleSize(r10, r8)
            return r9
        L_0x00d4:
            return r2
        L_0x00d5:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r8)
            r10 = 2097152(0x200000, float:2.938736E-39)
            int r9 = java.lang.Math.max(r10, r9)
            return r9
        L_0x00e2:
            int r0 = r0 * r1
            int r9 = getMaxSampleSize(r0, r8)
            return r9
        L_0x00e9:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.getCodecMaxInputSize(androidx.media3.exoplayer.mediacodec.MediaCodecInfo, androidx.media3.common.Format):int");
    }

    /* access modifiers changed from: protected */
    public float getCodecOperatingRateV23(float f, Format format, Format[] formatArr) {
        float f2 = -1.0f;
        for (Format format2 : formatArr) {
            float f3 = format2.frameRate;
            if (f3 != -1.0f) {
                f2 = Math.max(f2, f3);
            }
        }
        if (f2 == -1.0f) {
            return -1.0f;
        }
        return f2 * f;
    }

    /* access modifiers changed from: protected */
    public void onReadyToInitializeCodec(Format format) throws ExoPlaybackException {
        if (!this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.maybeEnable(format, getOutputStreamOffsetUs());
        }
    }

    /* access modifiers changed from: protected */
    public void onCodecInitialized(String str, MediaCodecAdapter.Configuration configuration, long j, long j2) {
        this.eventDispatcher.decoderInitialized(str, j, j2);
        this.codecNeedsSetOutputSurfaceWorkaround = codecNeedsSetOutputSurfaceWorkaround(str);
        this.codecHandlesHdr10PlusOutOfBandMetadata = ((MediaCodecInfo) Assertions.checkNotNull(getCodecInfo())).isHdr10PlusOutOfBandMetadataSupported();
        if (Util.SDK_INT >= 23 && this.tunneling) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23((MediaCodecAdapter) Assertions.checkNotNull(getCodec()));
        }
        this.videoFrameProcessorManager.onCodecInitialized(str);
    }

    /* access modifiers changed from: protected */
    public void onCodecReleased(String str) {
        this.eventDispatcher.decoderReleased(str);
    }

    /* access modifiers changed from: protected */
    public void onCodecError(Exception exc) {
        Log.e(TAG, "Video codec error", exc);
        this.eventDispatcher.videoCodecError(exc);
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation onInputFormatChanged(FormatHolder formatHolder) throws ExoPlaybackException {
        DecoderReuseEvaluation onInputFormatChanged = super.onInputFormatChanged(formatHolder);
        this.eventDispatcher.inputFormatChanged(formatHolder.format, onInputFormatChanged);
        return onInputFormatChanged;
    }

    /* access modifiers changed from: protected */
    public void onQueueInputBuffer(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (!this.tunneling) {
            this.buffersInCodecCount++;
        }
        if (Util.SDK_INT < 23 && this.tunneling) {
            onProcessedTunneledBuffer(decoderInputBuffer.timeUs);
        }
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(Format format, MediaFormat mediaFormat) {
        int i;
        int i2;
        int i3;
        int i4;
        MediaCodecAdapter codec = getCodec();
        if (codec != null) {
            codec.setVideoScalingMode(this.scalingMode);
        }
        int i5 = 0;
        if (this.tunneling) {
            i = format.width;
            i2 = format.height;
        } else {
            Assertions.checkNotNull(mediaFormat);
            boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
            if (z) {
                i3 = (mediaFormat.getInteger(KEY_CROP_RIGHT) - mediaFormat.getInteger(KEY_CROP_LEFT)) + 1;
            } else {
                i3 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
            }
            if (z) {
                i4 = (mediaFormat.getInteger(KEY_CROP_BOTTOM) - mediaFormat.getInteger(KEY_CROP_TOP)) + 1;
            } else {
                i4 = mediaFormat.getInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
            }
            int i6 = i3;
            i2 = i4;
            i = i6;
        }
        float f = format.pixelWidthHeightRatio;
        if (codecAppliesRotation()) {
            if (format.rotationDegrees == 90 || format.rotationDegrees == 270) {
                f = 1.0f / f;
                int i7 = i2;
                i2 = i;
                i = i7;
            }
        } else if (!this.videoFrameProcessorManager.isEnabled()) {
            i5 = format.rotationDegrees;
        }
        this.decodedVideoSize = new VideoSize(i, i2, i5, f);
        this.frameReleaseHelper.onFormatChanged(format.frameRate);
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.setInputFormat(format.buildUpon().setWidth(i).setHeight(i2).setRotationDegrees(i5).setPixelWidthHeightRatio(f).build());
        }
    }

    /* access modifiers changed from: protected */
    public void handleInputBufferSupplementalData(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
        if (this.codecHandlesHdr10PlusOutOfBandMetadata) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.checkNotNull(decoderInputBuffer.supplementalData);
            if (byteBuffer.remaining() >= 7) {
                byte b = byteBuffer.get();
                short s = byteBuffer.getShort();
                short s2 = byteBuffer.getShort();
                byte b2 = byteBuffer.get();
                byte b3 = byteBuffer.get();
                byteBuffer.position(0);
                if (b != -75 || s != 60 || s2 != 1 || b2 != 4) {
                    return;
                }
                if (b3 == 0 || b3 == 1) {
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    byteBuffer.position(0);
                    setHdr10PlusInfoV29(getCodec(), bArr);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean processOutputBuffer(long j, long j2, MediaCodecAdapter mediaCodecAdapter, ByteBuffer byteBuffer, int i, int i2, int i3, long j3, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        long j4 = j;
        MediaCodecAdapter mediaCodecAdapter2 = mediaCodecAdapter;
        int i4 = i;
        long j5 = j3;
        boolean z3 = z2;
        Format format2 = format;
        Assertions.checkNotNull(mediaCodecAdapter);
        if (this.initialPositionUs == -9223372036854775807L) {
            this.initialPositionUs = j4;
        }
        if (j5 != this.lastBufferPresentationTimeUs) {
            if (!this.videoFrameProcessorManager.isEnabled()) {
                this.frameReleaseHelper.onNextFrame(j5);
            }
            this.lastBufferPresentationTimeUs = j5;
        }
        long outputStreamOffsetUs = j5 - getOutputStreamOffsetUs();
        if (!z || z3) {
            boolean z4 = false;
            boolean z5 = getState() == 2;
            long j6 = outputStreamOffsetUs;
            long calculateEarlyTimeUs = calculateEarlyTimeUs(j, j2, SystemClock.elapsedRealtime() * 1000, j3, z5);
            if (this.displaySurface != this.placeholderSurface) {
                long j7 = j6;
                long j8 = j;
                if (shouldForceRender(j8, calculateEarlyTimeUs)) {
                    if (!this.videoFrameProcessorManager.isEnabled()) {
                        Format format3 = format;
                        z4 = true;
                    } else if (!this.videoFrameProcessorManager.maybeRegisterFrame(format, j7, z3)) {
                        return false;
                    }
                    renderOutputBufferNow(mediaCodecAdapter, format, i, j7, z4);
                    updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
                    return true;
                }
                Format format4 = format;
                if (z5 && j8 != this.initialPositionUs) {
                    long nanoTime = System.nanoTime();
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime((calculateEarlyTimeUs * 1000) + nanoTime);
                    if (!this.videoFrameProcessorManager.isEnabled()) {
                        calculateEarlyTimeUs = (adjustReleaseTime - nanoTime) / 1000;
                    }
                    boolean z6 = this.joiningDeadlineMs != -9223372036854775807L;
                    long j9 = adjustReleaseTime;
                    long j10 = j7;
                    if (shouldDropBuffersToKeyframe(calculateEarlyTimeUs, j2, z2) && maybeDropBuffersToKeyframe(j8, z6)) {
                        return false;
                    }
                    if (shouldDropOutputBuffer(calculateEarlyTimeUs, j2, z2)) {
                        if (z6) {
                            skipOutputBuffer(mediaCodecAdapter2, i4, j10);
                        } else {
                            dropOutputBuffer(mediaCodecAdapter2, i4, j10);
                        }
                        updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
                        return true;
                    }
                    long j11 = j10;
                    if (this.videoFrameProcessorManager.isEnabled()) {
                        this.videoFrameProcessorManager.releaseProcessedFrames(j8, j2);
                        if (!this.videoFrameProcessorManager.maybeRegisterFrame(format4, j11, z3)) {
                            return false;
                        }
                        renderOutputBufferNow(mediaCodecAdapter, format, i, j11, false);
                        return true;
                    } else if (Util.SDK_INT < 21) {
                        long j12 = j9;
                        if (calculateEarlyTimeUs < 30000) {
                            if (calculateEarlyTimeUs > 11000) {
                                try {
                                    Thread.sleep((calculateEarlyTimeUs - 10000) / 1000);
                                } catch (InterruptedException unused) {
                                    Thread.currentThread().interrupt();
                                    return false;
                                }
                            }
                            notifyFrameMetadataListener(j11, j12, format);
                            renderOutputBuffer(mediaCodecAdapter2, i4, j11);
                            updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
                            return true;
                        }
                    } else if (calculateEarlyTimeUs < 50000) {
                        long j13 = j9;
                        if (j13 == this.lastFrameReleaseTimeNs) {
                            skipOutputBuffer(mediaCodecAdapter2, i4, j11);
                        } else {
                            notifyFrameMetadataListener(j11, j13, format);
                            renderOutputBufferV21(mediaCodecAdapter, i, j11, j13);
                        }
                        updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
                        this.lastFrameReleaseTimeNs = j13;
                        return true;
                    }
                }
                return false;
            } else if (!isBufferLate(calculateEarlyTimeUs)) {
                return false;
            } else {
                skipOutputBuffer(mediaCodecAdapter2, i4, j6);
                updateVideoFrameProcessingOffsetCounters(calculateEarlyTimeUs);
                return true;
            }
        } else {
            skipOutputBuffer(mediaCodecAdapter2, i4, outputStreamOffsetUs);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public boolean shouldForceRender(long j, long j2) {
        boolean z = getState() == 2;
        boolean z2 = this.renderedFirstFrameAfterEnable ? !this.renderedFirstFrameAfterReset : !(!z && !this.mayRenderFirstFrameAfterEnableIfNotStarted);
        long elapsedRealtime = (SystemClock.elapsedRealtime() * 1000) - this.lastRenderRealtimeUs;
        if (this.joiningDeadlineMs == -9223372036854775807L && j >= getOutputStreamOffsetUs()) {
            if (z2) {
                return true;
            }
            if (!z || !shouldForceRenderOutputBuffer(j2, elapsedRealtime)) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public long calculateEarlyTimeUs(long j, long j2, long j3, long j4, boolean z) {
        double playbackSpeed = (double) getPlaybackSpeed();
        double d = (double) (j4 - j);
        Double.isNaN(d);
        Double.isNaN(playbackSpeed);
        long j5 = (long) (d / playbackSpeed);
        return z ? j5 - (j3 - j2) : j5;
    }

    /* access modifiers changed from: private */
    public void notifyFrameMetadataListener(long j, long j2, Format format) {
        VideoFrameMetadataListener videoFrameMetadataListener = this.frameMetadataListener;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.onVideoFrameAboutToBeRendered(j, j2, format, getCodecOutputMediaFormat());
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedTunneledBuffer(long j) throws ExoPlaybackException {
        updateOutputFormatForTime(j);
        maybeNotifyVideoSizeChanged(this.decodedVideoSize);
        this.decoderCounters.renderedOutputBufferCount++;
        maybeNotifyRenderedFirstFrame();
        onProcessedOutputBuffer(j);
    }

    /* access modifiers changed from: private */
    public void onProcessedTunneledEndOfStream() {
        setPendingOutputEndOfStream();
    }

    /* access modifiers changed from: protected */
    public void onProcessedOutputBuffer(long j) {
        super.onProcessedOutputBuffer(j);
        if (!this.tunneling) {
            this.buffersInCodecCount--;
        }
    }

    /* access modifiers changed from: protected */
    public void onProcessedStreamChange() {
        super.onProcessedStreamChange();
        clearRenderedFirstFrame();
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropOutputBuffer(long j, long j2, boolean z) {
        return isBufferLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldDropBuffersToKeyframe(long j, long j2, boolean z) {
        return isBufferVeryLate(j) && !z;
    }

    /* access modifiers changed from: protected */
    public boolean shouldForceRenderOutputBuffer(long j, long j2) {
        return isBufferLate(j) && j2 > 100000;
    }

    /* access modifiers changed from: protected */
    public void skipOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("skipVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        this.decoderCounters.skippedOutputBufferCount++;
    }

    /* access modifiers changed from: protected */
    public void dropOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("dropVideoBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, false);
        TraceUtil.endSection();
        updateDroppedBufferCounters(0, 1);
    }

    /* access modifiers changed from: protected */
    public boolean maybeDropBuffersToKeyframe(long j, boolean z) throws ExoPlaybackException {
        int skipSource = skipSource(j);
        if (skipSource == 0) {
            return false;
        }
        if (z) {
            this.decoderCounters.skippedInputBufferCount += skipSource;
            this.decoderCounters.skippedOutputBufferCount += this.buffersInCodecCount;
        } else {
            this.decoderCounters.droppedToKeyframeCount++;
            updateDroppedBufferCounters(skipSource, this.buffersInCodecCount);
        }
        flushOrReinitializeCodec();
        if (this.videoFrameProcessorManager.isEnabled()) {
            this.videoFrameProcessorManager.flush();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void updateDroppedBufferCounters(int i, int i2) {
        this.decoderCounters.droppedInputBufferCount += i;
        int i3 = i + i2;
        this.decoderCounters.droppedBufferCount += i3;
        this.droppedFrames += i3;
        this.consecutiveDroppedFrameCount += i3;
        this.decoderCounters.maxConsecutiveDroppedBufferCount = Math.max(this.consecutiveDroppedFrameCount, this.decoderCounters.maxConsecutiveDroppedBufferCount);
        int i4 = this.maxDroppedFramesToNotify;
        if (i4 > 0 && this.droppedFrames >= i4) {
            maybeNotifyDroppedFrames();
        }
    }

    /* access modifiers changed from: protected */
    public void updateVideoFrameProcessingOffsetCounters(long j) {
        this.decoderCounters.addVideoFrameProcessingOffset(j);
        this.totalVideoFrameProcessingOffsetUs += j;
        this.videoFrameProcessingOffsetCount++;
    }

    /* access modifiers changed from: protected */
    public Pair<ColorInfo, ColorInfo> experimentalGetVideoFrameProcessorColorConfiguration(ColorInfo colorInfo) {
        if (!ColorInfo.isTransferHdr(colorInfo)) {
            return Pair.create(ColorInfo.SDR_BT709_LIMITED, ColorInfo.SDR_BT709_LIMITED);
        }
        if (colorInfo.colorTransfer == 7) {
            return Pair.create(colorInfo, colorInfo.buildUpon().setColorTransfer(6).build());
        }
        return Pair.create(colorInfo, colorInfo);
    }

    private void renderOutputBufferNow(MediaCodecAdapter mediaCodecAdapter, Format format, int i, long j, boolean z) {
        long j2;
        if (this.videoFrameProcessorManager.isEnabled()) {
            j2 = this.videoFrameProcessorManager.getCorrectedFramePresentationTimeUs(j, getOutputStreamOffsetUs()) * 1000;
        } else {
            j2 = System.nanoTime();
        }
        if (z) {
            notifyFrameMetadataListener(j, j2, format);
        }
        if (Util.SDK_INT >= 21) {
            renderOutputBufferV21(mediaCodecAdapter, i, j, j2);
        } else {
            renderOutputBuffer(mediaCodecAdapter, i, j);
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBuffer(MediaCodecAdapter mediaCodecAdapter, int i, long j) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, true);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (!this.videoFrameProcessorManager.isEnabled()) {
            this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    /* access modifiers changed from: protected */
    public void renderOutputBufferV21(MediaCodecAdapter mediaCodecAdapter, int i, long j, long j2) {
        TraceUtil.beginSection("releaseOutputBuffer");
        mediaCodecAdapter.releaseOutputBuffer(i, j2);
        TraceUtil.endSection();
        this.decoderCounters.renderedOutputBufferCount++;
        this.consecutiveDroppedFrameCount = 0;
        if (!this.videoFrameProcessorManager.isEnabled()) {
            this.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            maybeNotifyVideoSizeChanged(this.decodedVideoSize);
            maybeNotifyRenderedFirstFrame();
        }
    }

    private boolean shouldUsePlaceholderSurface(MediaCodecInfo mediaCodecInfo) {
        return Util.SDK_INT >= 23 && !this.tunneling && !codecNeedsSetOutputSurfaceWorkaround(mediaCodecInfo.name) && (!mediaCodecInfo.secure || PlaceholderSurface.isSecureSupported(this.context));
    }

    private void releasePlaceholderSurface() {
        Surface surface = this.displaySurface;
        PlaceholderSurface placeholderSurface2 = this.placeholderSurface;
        if (surface == placeholderSurface2) {
            this.displaySurface = null;
        }
        placeholderSurface2.release();
        this.placeholderSurface = null;
    }

    private void setJoiningDeadlineMs() {
        this.joiningDeadlineMs = this.allowedJoiningTimeMs > 0 ? SystemClock.elapsedRealtime() + this.allowedJoiningTimeMs : -9223372036854775807L;
    }

    private void clearRenderedFirstFrame() {
        MediaCodecAdapter codec;
        this.renderedFirstFrameAfterReset = false;
        if (Util.SDK_INT >= 23 && this.tunneling && (codec = getCodec()) != null) {
            this.tunnelingOnFrameRenderedListener = new OnFrameRenderedListenerV23(codec);
        }
    }

    /* access modifiers changed from: package-private */
    public void maybeNotifyRenderedFirstFrame() {
        this.renderedFirstFrameAfterEnable = true;
        if (!this.renderedFirstFrameAfterReset) {
            this.renderedFirstFrameAfterReset = true;
            this.eventDispatcher.renderedFirstFrame(this.displaySurface);
            this.haveReportedFirstFrameRenderedForCurrentSurface = true;
        }
    }

    private void maybeRenotifyRenderedFirstFrame() {
        if (this.haveReportedFirstFrameRenderedForCurrentSurface) {
            this.eventDispatcher.renderedFirstFrame(this.displaySurface);
        }
    }

    private void clearReportedVideoSize() {
        this.reportedVideoSize = null;
    }

    /* access modifiers changed from: private */
    public void maybeNotifyVideoSizeChanged(VideoSize videoSize) {
        if (!videoSize.equals(VideoSize.UNKNOWN) && !videoSize.equals(this.reportedVideoSize)) {
            this.reportedVideoSize = videoSize;
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeRenotifyVideoSizeChanged() {
        VideoSize videoSize = this.reportedVideoSize;
        if (videoSize != null) {
            this.eventDispatcher.videoSizeChanged(videoSize);
        }
    }

    private void maybeNotifyDroppedFrames() {
        if (this.droppedFrames > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.eventDispatcher.droppedFrames(this.droppedFrames, elapsedRealtime - this.droppedFrameAccumulationStartTimeMs);
            this.droppedFrames = 0;
            this.droppedFrameAccumulationStartTimeMs = elapsedRealtime;
        }
    }

    private void maybeNotifyVideoFrameProcessingOffset() {
        int i = this.videoFrameProcessingOffsetCount;
        if (i != 0) {
            this.eventDispatcher.reportVideoFrameProcessingOffset(this.totalVideoFrameProcessingOffsetUs, i);
            this.totalVideoFrameProcessingOffsetUs = 0;
            this.videoFrameProcessingOffsetCount = 0;
        }
    }

    private static void setHdr10PlusInfoV29(MediaCodecAdapter mediaCodecAdapter, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("hdr10-plus-info", bArr);
        mediaCodecAdapter.setParameters(bundle);
    }

    /* access modifiers changed from: protected */
    public void setOutputSurfaceV23(MediaCodecAdapter mediaCodecAdapter, Surface surface) {
        mediaCodecAdapter.setOutputSurface(surface);
    }

    private static void configureTunnelingV21(MediaFormat mediaFormat, int i) {
        mediaFormat.setFeatureEnabled("tunneled-playback", true);
        mediaFormat.setInteger("audio-session-id", i);
    }

    /* access modifiers changed from: protected */
    public MediaFormat getMediaFormat(Format format, String str, CodecMaxValues codecMaxValues2, float f, boolean z, int i) {
        Pair<Integer, Integer> codecProfileAndLevel;
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, format.width);
        mediaFormat.setInteger(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, format.height);
        MediaFormatUtil.setCsdBuffers(mediaFormat, format.initializationData);
        MediaFormatUtil.maybeSetFloat(mediaFormat, "frame-rate", format.frameRate);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "rotation-degrees", format.rotationDegrees);
        MediaFormatUtil.maybeSetColorInfo(mediaFormat, format.colorInfo);
        if ("video/dolby-vision".equals(format.sampleMimeType) && (codecProfileAndLevel = MediaCodecUtil.getCodecProfileAndLevel(format)) != null) {
            MediaFormatUtil.maybeSetInteger(mediaFormat, Scopes.PROFILE, ((Integer) codecProfileAndLevel.first).intValue());
        }
        mediaFormat.setInteger("max-width", codecMaxValues2.width);
        mediaFormat.setInteger("max-height", codecMaxValues2.height);
        MediaFormatUtil.maybeSetInteger(mediaFormat, "max-input-size", codecMaxValues2.inputSize);
        if (Util.SDK_INT >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f != -1.0f) {
                mediaFormat.setFloat("operating-rate", f);
            }
        }
        if (z) {
            mediaFormat.setInteger("no-post-process", 1);
            mediaFormat.setInteger("auto-frc", 0);
        }
        if (i != 0) {
            configureTunnelingV21(mediaFormat, i);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    public CodecMaxValues getCodecMaxValues(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int codecMaxInputSize;
        int i = format.width;
        int i2 = format.height;
        int maxInputSize = getMaxInputSize(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            if (!(maxInputSize == -1 || (codecMaxInputSize = getCodecMaxInputSize(mediaCodecInfo, format)) == -1)) {
                maxInputSize = Math.min((int) (((float) maxInputSize) * INITIAL_FORMAT_MAX_INPUT_SIZE_SCALE_FACTOR), codecMaxInputSize);
            }
            return new CodecMaxValues(i, i2, maxInputSize);
        }
        int length = formatArr.length;
        boolean z = false;
        for (int i3 = 0; i3 < length; i3++) {
            Format format2 = formatArr[i3];
            if (format.colorInfo != null && format2.colorInfo == null) {
                format2 = format2.buildUpon().setColorInfo(format.colorInfo).build();
            }
            if (mediaCodecInfo.canReuseCodec(format, format2).result != 0) {
                z |= format2.width == -1 || format2.height == -1;
                i = Math.max(i, format2.width);
                i2 = Math.max(i2, format2.height);
                maxInputSize = Math.max(maxInputSize, getMaxInputSize(mediaCodecInfo, format2));
            }
        }
        if (z) {
            Log.w(TAG, "Resolutions unknown. Codec max resolution: " + i + "x" + i2);
            Point codecMaxSize = getCodecMaxSize(mediaCodecInfo, format);
            if (codecMaxSize != null) {
                i = Math.max(i, codecMaxSize.x);
                i2 = Math.max(i2, codecMaxSize.y);
                maxInputSize = Math.max(maxInputSize, getCodecMaxInputSize(mediaCodecInfo, format.buildUpon().setWidth(i).setHeight(i2).build()));
                Log.w(TAG, "Codec max resolution adjusted to: " + i + "x" + i2);
            }
        }
        return new CodecMaxValues(i, i2, maxInputSize);
    }

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException createDecoderException(Throwable th, MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecVideoDecoderException(th, mediaCodecInfo, this.displaySurface);
    }

    private static final class VideoFrameProcessorManager {
        private static final long EARLY_THRESHOLD_US = 50000;
        private boolean canEnableFrameProcessing = true;
        private Pair<Long, Format> currentFrameFormat;
        private Pair<Surface, Size> currentSurfaceAndSize;
        private final VideoFrameReleaseHelper frameReleaseHelper;
        private Handler handler;
        private long initialStreamOffsetUs = -9223372036854775807L;
        /* access modifiers changed from: private */
        public Format inputFormat;
        /* access modifiers changed from: private */
        public long lastCodecBufferPresentationTimestampUs = -9223372036854775807L;
        private final ArrayDeque<Pair<Long, Format>> pendingFrameFormats = new ArrayDeque<>();
        /* access modifiers changed from: private */
        public boolean pendingOutputSizeChange;
        /* access modifiers changed from: private */
        public long pendingOutputSizeChangeNotificationTimeUs = -9223372036854775807L;
        /* access modifiers changed from: private */
        public VideoSize processedFrameSize = VideoSize.UNKNOWN;
        /* access modifiers changed from: private */
        public final ArrayDeque<Long> processedFramesTimestampsUs = new ArrayDeque<>();
        /* access modifiers changed from: private */
        public boolean processedLastFrame;
        /* access modifiers changed from: private */
        public boolean registeredLastFrame;
        private boolean releasedLastFrame;
        /* access modifiers changed from: private */
        public final MediaCodecVideoRenderer renderer;
        private CopyOnWriteArrayList<Effect> videoEffects;
        private VideoFrameProcessor videoFrameProcessor;
        private int videoFrameProcessorMaxPendingFrameCount = -1;

        public VideoFrameProcessorManager(VideoFrameReleaseHelper videoFrameReleaseHelper, MediaCodecVideoRenderer mediaCodecVideoRenderer) {
            this.frameReleaseHelper = videoFrameReleaseHelper;
            this.renderer = mediaCodecVideoRenderer;
        }

        public void setVideoEffects(List<Effect> list) {
            CopyOnWriteArrayList<Effect> copyOnWriteArrayList = this.videoEffects;
            if (copyOnWriteArrayList == null) {
                this.videoEffects = new CopyOnWriteArrayList<>(list);
                return;
            }
            copyOnWriteArrayList.clear();
            this.videoEffects.addAll(list);
        }

        public boolean isEnabled() {
            return this.videoFrameProcessor != null;
        }

        public boolean isReady() {
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            return pair == null || !((Size) pair.second).equals(Size.UNKNOWN);
        }

        public boolean releasedLastFrame() {
            return this.releasedLastFrame;
        }

        public void flush() {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            this.videoFrameProcessor.flush();
            this.processedFramesTimestampsUs.clear();
            this.handler.removeCallbacksAndMessages((Object) null);
            if (this.registeredLastFrame) {
                this.registeredLastFrame = false;
                this.processedLastFrame = false;
                this.releasedLastFrame = false;
            }
        }

        public boolean maybeEnable(final Format format, long j) throws ExoPlaybackException {
            Assertions.checkState(!isEnabled());
            if (!this.canEnableFrameProcessing) {
                return false;
            }
            if (this.videoEffects == null) {
                this.canEnableFrameProcessing = false;
                return false;
            }
            this.handler = Util.createHandlerForCurrentLooper();
            Pair<ColorInfo, ColorInfo> experimentalGetVideoFrameProcessorColorConfiguration = this.renderer.experimentalGetVideoFrameProcessorColorConfiguration(format.colorInfo);
            try {
                if (!MediaCodecVideoRenderer.codecAppliesRotation() && format.rotationDegrees != 0) {
                    this.videoEffects.add(0, VideoFrameProcessorAccessor.createRotationEffect((float) format.rotationDegrees));
                }
                Handler handler2 = this.handler;
                Objects.requireNonNull(handler2);
                VideoFrameProcessor create = VideoFrameProcessorAccessor.getFrameProcessorFactory().create(this.renderer.context, (List) Assertions.checkNotNull(this.videoEffects), DebugViewProvider.NONE, (ColorInfo) experimentalGetVideoFrameProcessorColorConfiguration.first, (ColorInfo) experimentalGetVideoFrameProcessorColorConfiguration.second, false, new ConcurrencyHelpers$$ExternalSyntheticLambda1(handler2), new VideoFrameProcessor.Listener() {
                    public void onOutputSizeChanged(int i, int i2) {
                        Assertions.checkStateNotNull(VideoFrameProcessorManager.this.inputFormat);
                        VideoSize unused = VideoFrameProcessorManager.this.processedFrameSize = new VideoSize(i, i2, 0, 1.0f);
                        boolean unused2 = VideoFrameProcessorManager.this.pendingOutputSizeChange = true;
                    }

                    public void onOutputFrameAvailableForRendering(long j) {
                        if (VideoFrameProcessorManager.this.registeredLastFrame) {
                            Assertions.checkState(VideoFrameProcessorManager.this.lastCodecBufferPresentationTimestampUs != -9223372036854775807L);
                        }
                        VideoFrameProcessorManager.this.processedFramesTimestampsUs.add(Long.valueOf(j));
                        if (VideoFrameProcessorManager.this.registeredLastFrame && j >= VideoFrameProcessorManager.this.lastCodecBufferPresentationTimestampUs) {
                            boolean unused = VideoFrameProcessorManager.this.processedLastFrame = true;
                        }
                        if (VideoFrameProcessorManager.this.pendingOutputSizeChange) {
                            boolean unused2 = VideoFrameProcessorManager.this.pendingOutputSizeChange = false;
                            long unused3 = VideoFrameProcessorManager.this.pendingOutputSizeChangeNotificationTimeUs = j;
                        }
                    }

                    public void onError(VideoFrameProcessingException videoFrameProcessingException) {
                        VideoFrameProcessorManager.this.renderer.setPendingPlaybackException(VideoFrameProcessorManager.this.renderer.createRendererException(videoFrameProcessingException, format, 7001));
                    }

                    public void onEnded() {
                        throw new IllegalStateException();
                    }
                });
                this.videoFrameProcessor = create;
                create.registerInputStream(1);
                this.initialStreamOffsetUs = j;
                Pair<Surface, Size> pair = this.currentSurfaceAndSize;
                if (pair != null) {
                    Size size = (Size) pair.second;
                    this.videoFrameProcessor.setOutputSurfaceInfo(new SurfaceInfo((Surface) this.currentSurfaceAndSize.first, size.getWidth(), size.getHeight()));
                }
                setInputFormat(format);
                return true;
            } catch (Exception e) {
                throw this.renderer.createRendererException(e, format, 7000);
            }
        }

        public long getCorrectedFramePresentationTimeUs(long j, long j2) {
            Assertions.checkState(this.initialStreamOffsetUs != -9223372036854775807L);
            return (j + j2) - this.initialStreamOffsetUs;
        }

        public Surface getInputSurface() {
            return ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).getInputSurface();
        }

        public void setOutputSurfaceInfo(Surface surface, Size size) {
            Pair<Surface, Size> pair = this.currentSurfaceAndSize;
            if (pair == null || !((Surface) pair.first).equals(surface) || !((Size) this.currentSurfaceAndSize.second).equals(size)) {
                this.currentSurfaceAndSize = Pair.create(surface, size);
                if (isEnabled()) {
                    ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setOutputSurfaceInfo(new SurfaceInfo(surface, size.getWidth(), size.getHeight()));
                }
            }
        }

        public void clearOutputSurfaceInfo() {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setOutputSurfaceInfo((SurfaceInfo) null);
            this.currentSurfaceAndSize = null;
        }

        public void setInputFormat(Format format) {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).setInputFrameInfo(new FrameInfo.Builder(format.width, format.height).setPixelWidthHeightRatio(format.pixelWidthHeightRatio).build());
            this.inputFormat = format;
            if (this.registeredLastFrame) {
                this.registeredLastFrame = false;
                this.processedLastFrame = false;
                this.releasedLastFrame = false;
            }
        }

        public MediaFormat amendMediaFormatKeys(MediaFormat mediaFormat) {
            if (Util.SDK_INT >= 29 && this.renderer.context.getApplicationContext().getApplicationInfo().targetSdkVersion >= 29) {
                mediaFormat.setInteger("allow-frame-drop", 0);
            }
            return mediaFormat;
        }

        public void onCodecInitialized(String str) {
            this.videoFrameProcessorMaxPendingFrameCount = Util.getMaxPendingFramesCountForMediaCodecDecoders(this.renderer.context, str, false);
        }

        public boolean maybeRegisterFrame(Format format, long j, boolean z) {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            Assertions.checkState(this.videoFrameProcessorMaxPendingFrameCount != -1);
            if (this.videoFrameProcessor.getPendingInputFrameCount() >= this.videoFrameProcessorMaxPendingFrameCount) {
                return false;
            }
            this.videoFrameProcessor.registerInputFrame();
            Pair<Long, Format> pair = this.currentFrameFormat;
            if (pair == null) {
                this.currentFrameFormat = Pair.create(Long.valueOf(j), format);
            } else if (!Util.areEqual(format, pair.second)) {
                this.pendingFrameFormats.add(Pair.create(Long.valueOf(j), format));
            }
            if (z) {
                this.registeredLastFrame = true;
                this.lastCodecBufferPresentationTimestampUs = j;
            }
            return true;
        }

        public void releaseProcessedFrames(long j, long j2) {
            long j3 = j;
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            while (!this.processedFramesTimestampsUs.isEmpty()) {
                boolean z = false;
                boolean z2 = this.renderer.getState() == 2;
                long longValue = ((Long) Assertions.checkNotNull(this.processedFramesTimestampsUs.peek())).longValue();
                long j4 = longValue + this.initialStreamOffsetUs;
                long j5 = j4;
                long access$1400 = this.renderer.calculateEarlyTimeUs(j, j2, SystemClock.elapsedRealtime() * 1000, j4, z2);
                if (this.processedLastFrame && this.processedFramesTimestampsUs.size() == 1) {
                    z = true;
                }
                if (this.renderer.shouldForceRender(j3, access$1400)) {
                    releaseProcessedFrameInternal(-1, z);
                    return;
                } else if (z2 && j3 != this.renderer.initialPositionUs && access$1400 <= EARLY_THRESHOLD_US) {
                    long j6 = j5;
                    this.frameReleaseHelper.onNextFrame(j6);
                    long adjustReleaseTime = this.frameReleaseHelper.adjustReleaseTime(System.nanoTime() + (access$1400 * 1000));
                    if (this.renderer.shouldDropOutputBuffer((adjustReleaseTime - System.nanoTime()) / 1000, j2, z)) {
                        releaseProcessedFrameInternal(-2, z);
                    } else {
                        if (!this.pendingFrameFormats.isEmpty() && j6 > ((Long) this.pendingFrameFormats.peek().first).longValue()) {
                            this.currentFrameFormat = this.pendingFrameFormats.remove();
                        }
                        long j7 = adjustReleaseTime;
                        this.renderer.notifyFrameMetadataListener(longValue, j7, (Format) this.currentFrameFormat.second);
                        if (this.pendingOutputSizeChangeNotificationTimeUs >= j6) {
                            this.pendingOutputSizeChangeNotificationTimeUs = -9223372036854775807L;
                            this.renderer.maybeNotifyVideoSizeChanged(this.processedFrameSize);
                        }
                        releaseProcessedFrameInternal(j7, z);
                    }
                } else {
                    return;
                }
            }
        }

        public void reset() {
            ((VideoFrameProcessor) Assertions.checkNotNull(this.videoFrameProcessor)).release();
            this.videoFrameProcessor = null;
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.removeCallbacksAndMessages((Object) null);
            }
            CopyOnWriteArrayList<Effect> copyOnWriteArrayList = this.videoEffects;
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.clear();
            }
            this.processedFramesTimestampsUs.clear();
            this.canEnableFrameProcessing = true;
        }

        private void releaseProcessedFrameInternal(long j, boolean z) {
            Assertions.checkStateNotNull(this.videoFrameProcessor);
            this.videoFrameProcessor.renderOutputFrame(j);
            this.processedFramesTimestampsUs.remove();
            long unused = this.renderer.lastRenderRealtimeUs = SystemClock.elapsedRealtime() * 1000;
            if (j != -2) {
                this.renderer.maybeNotifyRenderedFirstFrame();
            }
            if (z) {
                this.releasedLastFrame = true;
            }
        }

        private static final class VideoFrameProcessorAccessor {
            private static Method buildScaleAndRotateTransformationMethod;
            private static Method buildVideoFrameProcessorFactoryMethod;
            private static Constructor<?> scaleAndRotateTransformationBuilderConstructor;
            private static Method setRotationMethod;
            private static Constructor<?> videoFrameProcessorFactoryBuilderConstructor;

            private VideoFrameProcessorAccessor() {
            }

            public static Effect createRotationEffect(float f) throws Exception {
                prepare();
                Object newInstance = scaleAndRotateTransformationBuilderConstructor.newInstance(new Object[0]);
                setRotationMethod.invoke(newInstance, new Object[]{Float.valueOf(f)});
                return (Effect) Assertions.checkNotNull(buildScaleAndRotateTransformationMethod.invoke(newInstance, new Object[0]));
            }

            public static VideoFrameProcessor.Factory getFrameProcessorFactory() throws Exception {
                prepare();
                return (VideoFrameProcessor.Factory) Assertions.checkNotNull(buildVideoFrameProcessorFactoryMethod.invoke(videoFrameProcessorFactoryBuilderConstructor.newInstance(new Object[0]), new Object[0]));
            }

            @EnsuresNonNull({"scaleAndRotateTransformationBuilderConstructor", "setRotationMethod", "buildScaleAndRotateTransformationMethod", "videoFrameProcessorFactoryBuilderConstructor", "buildVideoFrameProcessorFactoryMethod"})
            private static void prepare() throws Exception {
                if (scaleAndRotateTransformationBuilderConstructor == null || setRotationMethod == null || buildScaleAndRotateTransformationMethod == null) {
                    Class<?> cls = Class.forName("androidx.media3.effect.ScaleAndRotateTransformation$Builder");
                    scaleAndRotateTransformationBuilderConstructor = cls.getConstructor(new Class[0]);
                    setRotationMethod = cls.getMethod("setRotationDegrees", new Class[]{Float.TYPE});
                    buildScaleAndRotateTransformationMethod = cls.getMethod("build", new Class[0]);
                }
                if (videoFrameProcessorFactoryBuilderConstructor == null || buildVideoFrameProcessorFactoryMethod == null) {
                    Class<?> cls2 = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    videoFrameProcessorFactoryBuilderConstructor = cls2.getConstructor(new Class[0]);
                    buildVideoFrameProcessorFactoryMethod = cls2.getMethod("build", new Class[0]);
                }
            }
        }
    }

    private static Point getCodecMaxSize(MediaCodecInfo mediaCodecInfo, Format format) {
        boolean z = format.height > format.width;
        int i = z ? format.height : format.width;
        int i2 = z ? format.width : format.height;
        float f = ((float) i2) / ((float) i);
        for (int i3 : STANDARD_LONG_EDGE_VIDEO_PX) {
            int i4 = (int) (((float) i3) * f);
            if (i3 <= i || i4 <= i2) {
                break;
            }
            if (Util.SDK_INT >= 21) {
                int i5 = z ? i4 : i3;
                if (!z) {
                    i3 = i4;
                }
                Point alignVideoSizeV21 = mediaCodecInfo.alignVideoSizeV21(i5, i3);
                if (mediaCodecInfo.isVideoSizeAndRateSupportedV21(alignVideoSizeV21.x, alignVideoSizeV21.y, (double) format.frameRate)) {
                    return alignVideoSizeV21;
                }
            } else {
                try {
                    int ceilDivide = Util.ceilDivide(i3, 16) * 16;
                    int ceilDivide2 = Util.ceilDivide(i4, 16) * 16;
                    if (ceilDivide * ceilDivide2 <= MediaCodecUtil.maxH264DecodableFrameSize()) {
                        int i6 = z ? ceilDivide2 : ceilDivide;
                        if (!z) {
                            ceilDivide = ceilDivide2;
                        }
                        return new Point(i6, ceilDivide);
                    }
                } catch (MediaCodecUtil.DecoderQueryException unused) {
                }
            }
        }
        return null;
    }

    protected static int getMaxInputSize(MediaCodecInfo mediaCodecInfo, Format format) {
        if (format.maxInputSize == -1) {
            return getCodecMaxInputSize(mediaCodecInfo, format);
        }
        int size = format.initializationData.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += format.initializationData.get(i2).length;
        }
        return format.maxInputSize + i;
    }

    /* access modifiers changed from: private */
    public static boolean codecAppliesRotation() {
        return Util.SDK_INT >= 21;
    }

    private static boolean deviceNeedsNoPostProcessWorkaround() {
        return "NVIDIA".equals(Util.MANUFACTURER);
    }

    /* access modifiers changed from: protected */
    public boolean codecNeedsSetOutputSurfaceWorkaround(String str) {
        if (str.startsWith("OMX.google")) {
            return false;
        }
        synchronized (MediaCodecVideoRenderer.class) {
            if (!evaluatedDeviceNeedsSetOutputSurfaceWorkaround) {
                deviceNeedsSetOutputSurfaceWorkaround = evaluateDeviceNeedsSetOutputSurfaceWorkaround();
                evaluatedDeviceNeedsSetOutputSurfaceWorkaround = true;
            }
        }
        return deviceNeedsSetOutputSurfaceWorkaround;
    }

    /* access modifiers changed from: protected */
    public Surface getSurface() {
        return this.displaySurface;
    }

    protected static final class CodecMaxValues {
        public final int height;
        public final int inputSize;
        public final int width;

        public CodecMaxValues(int i, int i2, int i3) {
            this.width = i;
            this.height = i2;
            this.inputSize = i3;
        }
    }

    private static int getMaxSampleSize(int i, int i2) {
        return (i * 3) / (i2 * 2);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:469:0x084c, code lost:
        if (r0.equals("PGN528") == false) goto L_0x0115;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:494:0x08b4, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean evaluateDeviceNeedsSetOutputSurfaceWorkaround() {
        /*
            int r0 = androidx.media3.common.util.Util.SDK_INT
            r1 = 7
            r2 = 6
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = -1
            r8 = 0
            r9 = 1
            r10 = 28
            if (r0 > r10) goto L_0x007a
            java.lang.String r0 = androidx.media3.common.util.Util.DEVICE
            r0.hashCode()
            int r11 = r0.hashCode()
            switch(r11) {
                case -1339091551: goto L_0x006b;
                case -1220081023: goto L_0x0060;
                case -1220066608: goto L_0x0055;
                case -1012436106: goto L_0x004a;
                case -760312546: goto L_0x003f;
                case -64886864: goto L_0x0034;
                case 3415681: goto L_0x0029;
                case 825323514: goto L_0x001e;
                default: goto L_0x001b;
            }
        L_0x001b:
            r0 = -1
            goto L_0x0075
        L_0x001e:
            java.lang.String r11 = "machuca"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0027
            goto L_0x001b
        L_0x0027:
            r0 = 7
            goto L_0x0075
        L_0x0029:
            java.lang.String r11 = "once"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0032
            goto L_0x001b
        L_0x0032:
            r0 = 6
            goto L_0x0075
        L_0x0034:
            java.lang.String r11 = "magnolia"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x003d
            goto L_0x001b
        L_0x003d:
            r0 = 5
            goto L_0x0075
        L_0x003f:
            java.lang.String r11 = "aquaman"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0048
            goto L_0x001b
        L_0x0048:
            r0 = 4
            goto L_0x0075
        L_0x004a:
            java.lang.String r11 = "oneday"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0053
            goto L_0x001b
        L_0x0053:
            r0 = 3
            goto L_0x0075
        L_0x0055:
            java.lang.String r11 = "dangalUHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x005e
            goto L_0x001b
        L_0x005e:
            r0 = 2
            goto L_0x0075
        L_0x0060:
            java.lang.String r11 = "dangalFHD"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0069
            goto L_0x001b
        L_0x0069:
            r0 = 1
            goto L_0x0075
        L_0x006b:
            java.lang.String r11 = "dangal"
            boolean r0 = r0.equals(r11)
            if (r0 != 0) goto L_0x0074
            goto L_0x001b
        L_0x0074:
            r0 = 0
        L_0x0075:
            switch(r0) {
                case 0: goto L_0x0079;
                case 1: goto L_0x0079;
                case 2: goto L_0x0079;
                case 3: goto L_0x0079;
                case 4: goto L_0x0079;
                case 5: goto L_0x0079;
                case 6: goto L_0x0079;
                case 7: goto L_0x0079;
                default: goto L_0x0078;
            }
        L_0x0078:
            goto L_0x007a
        L_0x0079:
            return r9
        L_0x007a:
            int r0 = androidx.media3.common.util.Util.SDK_INT
            r11 = 27
            if (r0 > r11) goto L_0x008b
            java.lang.String r0 = "HWEML"
            java.lang.String r12 = androidx.media3.common.util.Util.DEVICE
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x008b
            return r9
        L_0x008b:
            java.lang.String r0 = androidx.media3.common.util.Util.MODEL
            r0.hashCode()
            int r12 = r0.hashCode()
            r13 = 8
            switch(r12) {
                case -349662828: goto L_0x00f6;
                case -321033677: goto L_0x00eb;
                case 2006354: goto L_0x00e0;
                case 2006367: goto L_0x00d5;
                case 2006371: goto L_0x00ca;
                case 1785421873: goto L_0x00bf;
                case 1785421876: goto L_0x00b4;
                case 1798172390: goto L_0x00a9;
                case 2119412532: goto L_0x009c;
                default: goto L_0x0099;
            }
        L_0x0099:
            r0 = -1
            goto L_0x0100
        L_0x009c:
            java.lang.String r12 = "AFTEUFF014"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00a5
            goto L_0x0099
        L_0x00a5:
            r0 = 8
            goto L_0x0100
        L_0x00a9:
            java.lang.String r12 = "AFTSO001"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00b2
            goto L_0x0099
        L_0x00b2:
            r0 = 7
            goto L_0x0100
        L_0x00b4:
            java.lang.String r12 = "AFTEU014"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00bd
            goto L_0x0099
        L_0x00bd:
            r0 = 6
            goto L_0x0100
        L_0x00bf:
            java.lang.String r12 = "AFTEU011"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00c8
            goto L_0x0099
        L_0x00c8:
            r0 = 5
            goto L_0x0100
        L_0x00ca:
            java.lang.String r12 = "AFTR"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00d3
            goto L_0x0099
        L_0x00d3:
            r0 = 4
            goto L_0x0100
        L_0x00d5:
            java.lang.String r12 = "AFTN"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00de
            goto L_0x0099
        L_0x00de:
            r0 = 3
            goto L_0x0100
        L_0x00e0:
            java.lang.String r12 = "AFTA"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00e9
            goto L_0x0099
        L_0x00e9:
            r0 = 2
            goto L_0x0100
        L_0x00eb:
            java.lang.String r12 = "AFTKMST12"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00f4
            goto L_0x0099
        L_0x00f4:
            r0 = 1
            goto L_0x0100
        L_0x00f6:
            java.lang.String r12 = "AFTJMST12"
            boolean r0 = r0.equals(r12)
            if (r0 != 0) goto L_0x00ff
            goto L_0x0099
        L_0x00ff:
            r0 = 0
        L_0x0100:
            switch(r0) {
                case 0: goto L_0x08b6;
                case 1: goto L_0x08b6;
                case 2: goto L_0x08b6;
                case 3: goto L_0x08b6;
                case 4: goto L_0x08b6;
                case 5: goto L_0x08b6;
                case 6: goto L_0x08b6;
                case 7: goto L_0x08b6;
                case 8: goto L_0x08b6;
                default: goto L_0x0103;
            }
        L_0x0103:
            int r0 = androidx.media3.common.util.Util.SDK_INT
            r12 = 26
            if (r0 > r12) goto L_0x08b5
            java.lang.String r0 = androidx.media3.common.util.Util.DEVICE
            r0.hashCode()
            int r14 = r0.hashCode()
            switch(r14) {
                case -2144781245: goto L_0x0898;
                case -2144781185: goto L_0x088c;
                case -2144781160: goto L_0x0880;
                case -2097309513: goto L_0x0874;
                case -2022874474: goto L_0x0868;
                case -1978993182: goto L_0x085c;
                case -1978990237: goto L_0x0850;
                case -1936688988: goto L_0x0846;
                case -1936688066: goto L_0x0839;
                case -1936688065: goto L_0x082b;
                case -1931988508: goto L_0x081d;
                case -1885099851: goto L_0x080f;
                case -1696512866: goto L_0x0801;
                case -1680025915: goto L_0x07f3;
                case -1615810839: goto L_0x07e5;
                case -1600724499: goto L_0x07d7;
                case -1554255044: goto L_0x07c9;
                case -1481772737: goto L_0x07bb;
                case -1481772730: goto L_0x07ad;
                case -1481772729: goto L_0x079f;
                case -1320080169: goto L_0x0791;
                case -1217592143: goto L_0x0783;
                case -1180384755: goto L_0x0775;
                case -1139198265: goto L_0x0767;
                case -1052835013: goto L_0x0759;
                case -993250464: goto L_0x074b;
                case -993250458: goto L_0x073d;
                case -965403638: goto L_0x072f;
                case -958336948: goto L_0x0721;
                case -879245230: goto L_0x0713;
                case -842500323: goto L_0x0705;
                case -821392978: goto L_0x06f7;
                case -797483286: goto L_0x06e9;
                case -794946968: goto L_0x06db;
                case -788334647: goto L_0x06cd;
                case -782144577: goto L_0x06bf;
                case -575125681: goto L_0x06b1;
                case -521118391: goto L_0x06a3;
                case -430914369: goto L_0x0695;
                case -290434366: goto L_0x0687;
                case -282781963: goto L_0x0679;
                case -277133239: goto L_0x066b;
                case -173639913: goto L_0x065d;
                case -56598463: goto L_0x064f;
                case 2126: goto L_0x0641;
                case 2564: goto L_0x0633;
                case 2715: goto L_0x0625;
                case 2719: goto L_0x0617;
                case 3091: goto L_0x0609;
                case 3483: goto L_0x05fb;
                case 73405: goto L_0x05ed;
                case 75537: goto L_0x05df;
                case 75739: goto L_0x05d1;
                case 76779: goto L_0x05c3;
                case 78669: goto L_0x05b5;
                case 79305: goto L_0x05a7;
                case 80618: goto L_0x0599;
                case 88274: goto L_0x058b;
                case 98846: goto L_0x057d;
                case 98848: goto L_0x056f;
                case 99329: goto L_0x0561;
                case 101481: goto L_0x0553;
                case 1513190: goto L_0x0545;
                case 1514184: goto L_0x0537;
                case 1514185: goto L_0x0529;
                case 2133089: goto L_0x051b;
                case 2133091: goto L_0x050d;
                case 2133120: goto L_0x04ff;
                case 2133151: goto L_0x04f1;
                case 2133182: goto L_0x04e3;
                case 2133184: goto L_0x04d5;
                case 2436959: goto L_0x04c7;
                case 2463773: goto L_0x04b9;
                case 2464648: goto L_0x04ab;
                case 2689555: goto L_0x049d;
                case 3154429: goto L_0x048f;
                case 3284551: goto L_0x0481;
                case 3351335: goto L_0x0473;
                case 3386211: goto L_0x0465;
                case 41325051: goto L_0x0457;
                case 51349633: goto L_0x0449;
                case 51350594: goto L_0x043b;
                case 55178625: goto L_0x042d;
                case 61542055: goto L_0x041f;
                case 65355429: goto L_0x0411;
                case 66214468: goto L_0x0403;
                case 66214470: goto L_0x03f5;
                case 66214473: goto L_0x03e7;
                case 66215429: goto L_0x03d9;
                case 66215431: goto L_0x03cb;
                case 66215433: goto L_0x03bd;
                case 66216390: goto L_0x03af;
                case 76402249: goto L_0x03a1;
                case 76404105: goto L_0x0393;
                case 76404911: goto L_0x0385;
                case 80963634: goto L_0x0377;
                case 82882791: goto L_0x0369;
                case 98715550: goto L_0x035b;
                case 101370885: goto L_0x034d;
                case 102844228: goto L_0x033f;
                case 165221241: goto L_0x0331;
                case 182191441: goto L_0x0323;
                case 245388979: goto L_0x0315;
                case 287431619: goto L_0x0307;
                case 307593612: goto L_0x02f9;
                case 308517133: goto L_0x02eb;
                case 316215098: goto L_0x02dd;
                case 316215116: goto L_0x02cf;
                case 316246811: goto L_0x02c1;
                case 316246818: goto L_0x02b3;
                case 407160593: goto L_0x02a5;
                case 507412548: goto L_0x0297;
                case 793982701: goto L_0x0289;
                case 794038622: goto L_0x027b;
                case 794040393: goto L_0x026d;
                case 835649806: goto L_0x025f;
                case 917340916: goto L_0x0251;
                case 958008161: goto L_0x0243;
                case 1060579533: goto L_0x0235;
                case 1150207623: goto L_0x0227;
                case 1176899427: goto L_0x0219;
                case 1280332038: goto L_0x020b;
                case 1306947716: goto L_0x01fd;
                case 1349174697: goto L_0x01ef;
                case 1522194893: goto L_0x01e1;
                case 1691543273: goto L_0x01d3;
                case 1691544261: goto L_0x01c5;
                case 1709443163: goto L_0x01b7;
                case 1865889110: goto L_0x01a9;
                case 1906253259: goto L_0x019b;
                case 1977196784: goto L_0x018d;
                case 2006372676: goto L_0x0180;
                case 2019281702: goto L_0x0173;
                case 2029784656: goto L_0x0166;
                case 2030379515: goto L_0x0159;
                case 2033393791: goto L_0x014c;
                case 2047190025: goto L_0x013f;
                case 2047252157: goto L_0x0132;
                case 2048319463: goto L_0x0125;
                case 2048855701: goto L_0x0118;
                default: goto L_0x0115;
            }
        L_0x0115:
            r1 = -1
            goto L_0x08a3
        L_0x0118:
            java.lang.String r1 = "HWWAS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0121
            goto L_0x0115
        L_0x0121:
            r1 = 139(0x8b, float:1.95E-43)
            goto L_0x08a3
        L_0x0125:
            java.lang.String r1 = "HWVNS-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012e
            goto L_0x0115
        L_0x012e:
            r1 = 138(0x8a, float:1.93E-43)
            goto L_0x08a3
        L_0x0132:
            java.lang.String r1 = "ELUGA_Prim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x013b
            goto L_0x0115
        L_0x013b:
            r1 = 137(0x89, float:1.92E-43)
            goto L_0x08a3
        L_0x013f:
            java.lang.String r1 = "ELUGA_Note"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0148
            goto L_0x0115
        L_0x0148:
            r1 = 136(0x88, float:1.9E-43)
            goto L_0x08a3
        L_0x014c:
            java.lang.String r1 = "ASUS_X00AD_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0155
            goto L_0x0115
        L_0x0155:
            r1 = 135(0x87, float:1.89E-43)
            goto L_0x08a3
        L_0x0159:
            java.lang.String r1 = "HWCAM-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0162
            goto L_0x0115
        L_0x0162:
            r1 = 134(0x86, float:1.88E-43)
            goto L_0x08a3
        L_0x0166:
            java.lang.String r1 = "HWBLN-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x016f
            goto L_0x0115
        L_0x016f:
            r1 = 133(0x85, float:1.86E-43)
            goto L_0x08a3
        L_0x0173:
            java.lang.String r1 = "DM-01K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x017c
            goto L_0x0115
        L_0x017c:
            r1 = 132(0x84, float:1.85E-43)
            goto L_0x08a3
        L_0x0180:
            java.lang.String r1 = "BRAVIA_ATV3_4K"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0189
            goto L_0x0115
        L_0x0189:
            r1 = 131(0x83, float:1.84E-43)
            goto L_0x08a3
        L_0x018d:
            java.lang.String r1 = "Infinix-X572"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0197
            goto L_0x0115
        L_0x0197:
            r1 = 130(0x82, float:1.82E-43)
            goto L_0x08a3
        L_0x019b:
            java.lang.String r1 = "PB2-670M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01a5
            goto L_0x0115
        L_0x01a5:
            r1 = 129(0x81, float:1.81E-43)
            goto L_0x08a3
        L_0x01a9:
            java.lang.String r1 = "santoni"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01b3
            goto L_0x0115
        L_0x01b3:
            r1 = 128(0x80, float:1.794E-43)
            goto L_0x08a3
        L_0x01b7:
            java.lang.String r1 = "iball8735_9806"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01c1
            goto L_0x0115
        L_0x01c1:
            r1 = 127(0x7f, float:1.78E-43)
            goto L_0x08a3
        L_0x01c5:
            java.lang.String r1 = "CPH1715"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01cf
            goto L_0x0115
        L_0x01cf:
            r1 = 126(0x7e, float:1.77E-43)
            goto L_0x08a3
        L_0x01d3:
            java.lang.String r1 = "CPH1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01dd
            goto L_0x0115
        L_0x01dd:
            r1 = 125(0x7d, float:1.75E-43)
            goto L_0x08a3
        L_0x01e1:
            java.lang.String r1 = "woods_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01eb
            goto L_0x0115
        L_0x01eb:
            r1 = 124(0x7c, float:1.74E-43)
            goto L_0x08a3
        L_0x01ef:
            java.lang.String r1 = "htc_e56ml_dtul"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x01f9
            goto L_0x0115
        L_0x01f9:
            r1 = 123(0x7b, float:1.72E-43)
            goto L_0x08a3
        L_0x01fd:
            java.lang.String r1 = "EverStar_S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0207
            goto L_0x0115
        L_0x0207:
            r1 = 122(0x7a, float:1.71E-43)
            goto L_0x08a3
        L_0x020b:
            java.lang.String r1 = "hwALE-H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0215
            goto L_0x0115
        L_0x0215:
            r1 = 121(0x79, float:1.7E-43)
            goto L_0x08a3
        L_0x0219:
            java.lang.String r1 = "itel_S41"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0223
            goto L_0x0115
        L_0x0223:
            r1 = 120(0x78, float:1.68E-43)
            goto L_0x08a3
        L_0x0227:
            java.lang.String r1 = "LS-5017"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0231
            goto L_0x0115
        L_0x0231:
            r1 = 119(0x77, float:1.67E-43)
            goto L_0x08a3
        L_0x0235:
            java.lang.String r1 = "panell_d"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x023f
            goto L_0x0115
        L_0x023f:
            r1 = 118(0x76, float:1.65E-43)
            goto L_0x08a3
        L_0x0243:
            java.lang.String r1 = "j2xlteins"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x024d
            goto L_0x0115
        L_0x024d:
            r1 = 117(0x75, float:1.64E-43)
            goto L_0x08a3
        L_0x0251:
            java.lang.String r1 = "A7000plus"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x025b
            goto L_0x0115
        L_0x025b:
            r1 = 116(0x74, float:1.63E-43)
            goto L_0x08a3
        L_0x025f:
            java.lang.String r1 = "manning"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0269
            goto L_0x0115
        L_0x0269:
            r1 = 115(0x73, float:1.61E-43)
            goto L_0x08a3
        L_0x026d:
            java.lang.String r1 = "GIONEE_WBL7519"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0277
            goto L_0x0115
        L_0x0277:
            r1 = 114(0x72, float:1.6E-43)
            goto L_0x08a3
        L_0x027b:
            java.lang.String r1 = "GIONEE_WBL7365"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0285
            goto L_0x0115
        L_0x0285:
            r1 = 113(0x71, float:1.58E-43)
            goto L_0x08a3
        L_0x0289:
            java.lang.String r1 = "GIONEE_WBL5708"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0293
            goto L_0x0115
        L_0x0293:
            r1 = 112(0x70, float:1.57E-43)
            goto L_0x08a3
        L_0x0297:
            java.lang.String r1 = "QM16XE_U"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02a1
            goto L_0x0115
        L_0x02a1:
            r1 = 111(0x6f, float:1.56E-43)
            goto L_0x08a3
        L_0x02a5:
            java.lang.String r1 = "Pixi5-10_4G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02af
            goto L_0x0115
        L_0x02af:
            r1 = 110(0x6e, float:1.54E-43)
            goto L_0x08a3
        L_0x02b3:
            java.lang.String r1 = "TB3-850M"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02bd
            goto L_0x0115
        L_0x02bd:
            r1 = 109(0x6d, float:1.53E-43)
            goto L_0x08a3
        L_0x02c1:
            java.lang.String r1 = "TB3-850F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02cb
            goto L_0x0115
        L_0x02cb:
            r1 = 108(0x6c, float:1.51E-43)
            goto L_0x08a3
        L_0x02cf:
            java.lang.String r1 = "TB3-730X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02d9
            goto L_0x0115
        L_0x02d9:
            r1 = 107(0x6b, float:1.5E-43)
            goto L_0x08a3
        L_0x02dd:
            java.lang.String r1 = "TB3-730F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02e7
            goto L_0x0115
        L_0x02e7:
            r1 = 106(0x6a, float:1.49E-43)
            goto L_0x08a3
        L_0x02eb:
            java.lang.String r1 = "A7020a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x02f5
            goto L_0x0115
        L_0x02f5:
            r1 = 105(0x69, float:1.47E-43)
            goto L_0x08a3
        L_0x02f9:
            java.lang.String r1 = "A7010a48"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0303
            goto L_0x0115
        L_0x0303:
            r1 = 104(0x68, float:1.46E-43)
            goto L_0x08a3
        L_0x0307:
            java.lang.String r1 = "griffin"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0311
            goto L_0x0115
        L_0x0311:
            r1 = 103(0x67, float:1.44E-43)
            goto L_0x08a3
        L_0x0315:
            java.lang.String r1 = "marino_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x031f
            goto L_0x0115
        L_0x031f:
            r1 = 102(0x66, float:1.43E-43)
            goto L_0x08a3
        L_0x0323:
            java.lang.String r1 = "CPY83_I00"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x032d
            goto L_0x0115
        L_0x032d:
            r1 = 101(0x65, float:1.42E-43)
            goto L_0x08a3
        L_0x0331:
            java.lang.String r1 = "A2016a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x033b
            goto L_0x0115
        L_0x033b:
            r1 = 100
            goto L_0x08a3
        L_0x033f:
            java.lang.String r1 = "le_x6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0349
            goto L_0x0115
        L_0x0349:
            r1 = 99
            goto L_0x08a3
        L_0x034d:
            java.lang.String r1 = "l5460"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0357
            goto L_0x0115
        L_0x0357:
            r1 = 98
            goto L_0x08a3
        L_0x035b:
            java.lang.String r1 = "i9031"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0365
            goto L_0x0115
        L_0x0365:
            r1 = 97
            goto L_0x08a3
        L_0x0369:
            java.lang.String r1 = "X3_HK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0373
            goto L_0x0115
        L_0x0373:
            r1 = 96
            goto L_0x08a3
        L_0x0377:
            java.lang.String r1 = "V23GB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0381
            goto L_0x0115
        L_0x0381:
            r1 = 95
            goto L_0x08a3
        L_0x0385:
            java.lang.String r1 = "Q4310"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x038f
            goto L_0x0115
        L_0x038f:
            r1 = 94
            goto L_0x08a3
        L_0x0393:
            java.lang.String r1 = "Q4260"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x039d
            goto L_0x0115
        L_0x039d:
            r1 = 93
            goto L_0x08a3
        L_0x03a1:
            java.lang.String r1 = "PRO7S"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ab
            goto L_0x0115
        L_0x03ab:
            r1 = 92
            goto L_0x08a3
        L_0x03af:
            java.lang.String r1 = "F3311"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03b9
            goto L_0x0115
        L_0x03b9:
            r1 = 91
            goto L_0x08a3
        L_0x03bd:
            java.lang.String r1 = "F3215"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03c7
            goto L_0x0115
        L_0x03c7:
            r1 = 90
            goto L_0x08a3
        L_0x03cb:
            java.lang.String r1 = "F3213"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03d5
            goto L_0x0115
        L_0x03d5:
            r1 = 89
            goto L_0x08a3
        L_0x03d9:
            java.lang.String r1 = "F3211"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03e3
            goto L_0x0115
        L_0x03e3:
            r1 = 88
            goto L_0x08a3
        L_0x03e7:
            java.lang.String r1 = "F3116"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03f1
            goto L_0x0115
        L_0x03f1:
            r1 = 87
            goto L_0x08a3
        L_0x03f5:
            java.lang.String r1 = "F3113"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x03ff
            goto L_0x0115
        L_0x03ff:
            r1 = 86
            goto L_0x08a3
        L_0x0403:
            java.lang.String r1 = "F3111"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x040d
            goto L_0x0115
        L_0x040d:
            r1 = 85
            goto L_0x08a3
        L_0x0411:
            java.lang.String r1 = "E5643"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x041b
            goto L_0x0115
        L_0x041b:
            r1 = 84
            goto L_0x08a3
        L_0x041f:
            java.lang.String r1 = "A1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0429
            goto L_0x0115
        L_0x0429:
            r1 = 83
            goto L_0x08a3
        L_0x042d:
            java.lang.String r1 = "Aura_Note_2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0437
            goto L_0x0115
        L_0x0437:
            r1 = 82
            goto L_0x08a3
        L_0x043b:
            java.lang.String r1 = "602LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0445
            goto L_0x0115
        L_0x0445:
            r1 = 81
            goto L_0x08a3
        L_0x0449:
            java.lang.String r1 = "601LV"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0453
            goto L_0x0115
        L_0x0453:
            r1 = 80
            goto L_0x08a3
        L_0x0457:
            java.lang.String r1 = "MEIZU_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0461
            goto L_0x0115
        L_0x0461:
            r1 = 79
            goto L_0x08a3
        L_0x0465:
            java.lang.String r1 = "p212"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x046f
            goto L_0x0115
        L_0x046f:
            r1 = 78
            goto L_0x08a3
        L_0x0473:
            java.lang.String r1 = "mido"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x047d
            goto L_0x0115
        L_0x047d:
            r1 = 77
            goto L_0x08a3
        L_0x0481:
            java.lang.String r1 = "kate"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x048b
            goto L_0x0115
        L_0x048b:
            r1 = 76
            goto L_0x08a3
        L_0x048f:
            java.lang.String r1 = "fugu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0499
            goto L_0x0115
        L_0x0499:
            r1 = 75
            goto L_0x08a3
        L_0x049d:
            java.lang.String r1 = "XE2X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04a7
            goto L_0x0115
        L_0x04a7:
            r1 = 74
            goto L_0x08a3
        L_0x04ab:
            java.lang.String r1 = "Q427"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04b5
            goto L_0x0115
        L_0x04b5:
            r1 = 73
            goto L_0x08a3
        L_0x04b9:
            java.lang.String r1 = "Q350"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04c3
            goto L_0x0115
        L_0x04c3:
            r1 = 72
            goto L_0x08a3
        L_0x04c7:
            java.lang.String r1 = "P681"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04d1
            goto L_0x0115
        L_0x04d1:
            r1 = 71
            goto L_0x08a3
        L_0x04d5:
            java.lang.String r1 = "F04J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04df
            goto L_0x0115
        L_0x04df:
            r1 = 70
            goto L_0x08a3
        L_0x04e3:
            java.lang.String r1 = "F04H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04ed
            goto L_0x0115
        L_0x04ed:
            r1 = 69
            goto L_0x08a3
        L_0x04f1:
            java.lang.String r1 = "F03H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x04fb
            goto L_0x0115
        L_0x04fb:
            r1 = 68
            goto L_0x08a3
        L_0x04ff:
            java.lang.String r1 = "F02H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0509
            goto L_0x0115
        L_0x0509:
            r1 = 67
            goto L_0x08a3
        L_0x050d:
            java.lang.String r1 = "F01J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0517
            goto L_0x0115
        L_0x0517:
            r1 = 66
            goto L_0x08a3
        L_0x051b:
            java.lang.String r1 = "F01H"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0525
            goto L_0x0115
        L_0x0525:
            r1 = 65
            goto L_0x08a3
        L_0x0529:
            java.lang.String r1 = "1714"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0533
            goto L_0x0115
        L_0x0533:
            r1 = 64
            goto L_0x08a3
        L_0x0537:
            java.lang.String r1 = "1713"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0541
            goto L_0x0115
        L_0x0541:
            r1 = 63
            goto L_0x08a3
        L_0x0545:
            java.lang.String r1 = "1601"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x054f
            goto L_0x0115
        L_0x054f:
            r1 = 62
            goto L_0x08a3
        L_0x0553:
            java.lang.String r1 = "flo"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x055d
            goto L_0x0115
        L_0x055d:
            r1 = 61
            goto L_0x08a3
        L_0x0561:
            java.lang.String r1 = "deb"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x056b
            goto L_0x0115
        L_0x056b:
            r1 = 60
            goto L_0x08a3
        L_0x056f:
            java.lang.String r1 = "cv3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0579
            goto L_0x0115
        L_0x0579:
            r1 = 59
            goto L_0x08a3
        L_0x057d:
            java.lang.String r1 = "cv1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0587
            goto L_0x0115
        L_0x0587:
            r1 = 58
            goto L_0x08a3
        L_0x058b:
            java.lang.String r1 = "Z80"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0595
            goto L_0x0115
        L_0x0595:
            r1 = 57
            goto L_0x08a3
        L_0x0599:
            java.lang.String r1 = "QX1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05a3
            goto L_0x0115
        L_0x05a3:
            r1 = 56
            goto L_0x08a3
        L_0x05a7:
            java.lang.String r1 = "PLE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05b1
            goto L_0x0115
        L_0x05b1:
            r1 = 55
            goto L_0x08a3
        L_0x05b5:
            java.lang.String r1 = "P85"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05bf
            goto L_0x0115
        L_0x05bf:
            r1 = 54
            goto L_0x08a3
        L_0x05c3:
            java.lang.String r1 = "MX6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05cd
            goto L_0x0115
        L_0x05cd:
            r1 = 53
            goto L_0x08a3
        L_0x05d1:
            java.lang.String r1 = "M5c"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05db
            goto L_0x0115
        L_0x05db:
            r1 = 52
            goto L_0x08a3
        L_0x05df:
            java.lang.String r1 = "M04"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05e9
            goto L_0x0115
        L_0x05e9:
            r1 = 51
            goto L_0x08a3
        L_0x05ed:
            java.lang.String r1 = "JGZ"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x05f7
            goto L_0x0115
        L_0x05f7:
            r1 = 50
            goto L_0x08a3
        L_0x05fb:
            java.lang.String r1 = "mh"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0605
            goto L_0x0115
        L_0x0605:
            r1 = 49
            goto L_0x08a3
        L_0x0609:
            java.lang.String r1 = "b5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0613
            goto L_0x0115
        L_0x0613:
            r1 = 48
            goto L_0x08a3
        L_0x0617:
            java.lang.String r1 = "V5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0621
            goto L_0x0115
        L_0x0621:
            r1 = 47
            goto L_0x08a3
        L_0x0625:
            java.lang.String r1 = "V1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x062f
            goto L_0x0115
        L_0x062f:
            r1 = 46
            goto L_0x08a3
        L_0x0633:
            java.lang.String r1 = "Q5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x063d
            goto L_0x0115
        L_0x063d:
            r1 = 45
            goto L_0x08a3
        L_0x0641:
            java.lang.String r1 = "C1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x064b
            goto L_0x0115
        L_0x064b:
            r1 = 44
            goto L_0x08a3
        L_0x064f:
            java.lang.String r1 = "woods_fn"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0659
            goto L_0x0115
        L_0x0659:
            r1 = 43
            goto L_0x08a3
        L_0x065d:
            java.lang.String r1 = "ELUGA_A3_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0667
            goto L_0x0115
        L_0x0667:
            r1 = 42
            goto L_0x08a3
        L_0x066b:
            java.lang.String r1 = "Z12_PRO"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0675
            goto L_0x0115
        L_0x0675:
            r1 = 41
            goto L_0x08a3
        L_0x0679:
            java.lang.String r1 = "BLACK-1X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0683
            goto L_0x0115
        L_0x0683:
            r1 = 40
            goto L_0x08a3
        L_0x0687:
            java.lang.String r1 = "taido_row"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0691
            goto L_0x0115
        L_0x0691:
            r1 = 39
            goto L_0x08a3
        L_0x0695:
            java.lang.String r1 = "Pixi4-7_3G"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x069f
            goto L_0x0115
        L_0x069f:
            r1 = 38
            goto L_0x08a3
        L_0x06a3:
            java.lang.String r1 = "GIONEE_GBL7360"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06ad
            goto L_0x0115
        L_0x06ad:
            r1 = 37
            goto L_0x08a3
        L_0x06b1:
            java.lang.String r1 = "GiONEE_CBL7513"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06bb
            goto L_0x0115
        L_0x06bb:
            r1 = 36
            goto L_0x08a3
        L_0x06bf:
            java.lang.String r1 = "OnePlus5T"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06c9
            goto L_0x0115
        L_0x06c9:
            r1 = 35
            goto L_0x08a3
        L_0x06cd:
            java.lang.String r1 = "whyred"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06d7
            goto L_0x0115
        L_0x06d7:
            r1 = 34
            goto L_0x08a3
        L_0x06db:
            java.lang.String r1 = "watson"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06e5
            goto L_0x0115
        L_0x06e5:
            r1 = 33
            goto L_0x08a3
        L_0x06e9:
            java.lang.String r1 = "SVP-DTV15"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x06f3
            goto L_0x0115
        L_0x06f3:
            r1 = 32
            goto L_0x08a3
        L_0x06f7:
            java.lang.String r1 = "A7000-a"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0701
            goto L_0x0115
        L_0x0701:
            r1 = 31
            goto L_0x08a3
        L_0x0705:
            java.lang.String r1 = "nicklaus_f"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x070f
            goto L_0x0115
        L_0x070f:
            r1 = 30
            goto L_0x08a3
        L_0x0713:
            java.lang.String r1 = "tcl_eu"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x071d
            goto L_0x0115
        L_0x071d:
            r1 = 29
            goto L_0x08a3
        L_0x0721:
            java.lang.String r1 = "ELUGA_Ray_X"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x072b
            goto L_0x0115
        L_0x072b:
            r1 = 28
            goto L_0x08a3
        L_0x072f:
            java.lang.String r1 = "s905x018"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0739
            goto L_0x0115
        L_0x0739:
            r1 = 27
            goto L_0x08a3
        L_0x073d:
            java.lang.String r1 = "A10-70L"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0747
            goto L_0x0115
        L_0x0747:
            r1 = 26
            goto L_0x08a3
        L_0x074b:
            java.lang.String r1 = "A10-70F"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0755
            goto L_0x0115
        L_0x0755:
            r1 = 25
            goto L_0x08a3
        L_0x0759:
            java.lang.String r1 = "namath"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0763
            goto L_0x0115
        L_0x0763:
            r1 = 24
            goto L_0x08a3
        L_0x0767:
            java.lang.String r1 = "Slate_Pro"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0771
            goto L_0x0115
        L_0x0771:
            r1 = 23
            goto L_0x08a3
        L_0x0775:
            java.lang.String r1 = "iris60"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x077f
            goto L_0x0115
        L_0x077f:
            r1 = 22
            goto L_0x08a3
        L_0x0783:
            java.lang.String r1 = "BRAVIA_ATV2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x078d
            goto L_0x0115
        L_0x078d:
            r1 = 21
            goto L_0x08a3
        L_0x0791:
            java.lang.String r1 = "GiONEE_GBL7319"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x079b
            goto L_0x0115
        L_0x079b:
            r1 = 20
            goto L_0x08a3
        L_0x079f:
            java.lang.String r1 = "panell_dt"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07a9
            goto L_0x0115
        L_0x07a9:
            r1 = 19
            goto L_0x08a3
        L_0x07ad:
            java.lang.String r1 = "panell_ds"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07b7
            goto L_0x0115
        L_0x07b7:
            r1 = 18
            goto L_0x08a3
        L_0x07bb:
            java.lang.String r1 = "panell_dl"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07c5
            goto L_0x0115
        L_0x07c5:
            r1 = 17
            goto L_0x08a3
        L_0x07c9:
            java.lang.String r1 = "vernee_M5"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07d3
            goto L_0x0115
        L_0x07d3:
            r1 = 16
            goto L_0x08a3
        L_0x07d7:
            java.lang.String r1 = "pacificrim"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07e1
            goto L_0x0115
        L_0x07e1:
            r1 = 15
            goto L_0x08a3
        L_0x07e5:
            java.lang.String r1 = "Phantom6"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07ef
            goto L_0x0115
        L_0x07ef:
            r1 = 14
            goto L_0x08a3
        L_0x07f3:
            java.lang.String r1 = "ComioS1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x07fd
            goto L_0x0115
        L_0x07fd:
            r1 = 13
            goto L_0x08a3
        L_0x0801:
            java.lang.String r1 = "XT1663"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x080b
            goto L_0x0115
        L_0x080b:
            r1 = 12
            goto L_0x08a3
        L_0x080f:
            java.lang.String r1 = "RAIJIN"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0819
            goto L_0x0115
        L_0x0819:
            r1 = 11
            goto L_0x08a3
        L_0x081d:
            java.lang.String r1 = "AquaPowerM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0827
            goto L_0x0115
        L_0x0827:
            r1 = 10
            goto L_0x08a3
        L_0x082b:
            java.lang.String r1 = "PGN611"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0835
            goto L_0x0115
        L_0x0835:
            r1 = 9
            goto L_0x08a3
        L_0x0839:
            java.lang.String r1 = "PGN610"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0843
            goto L_0x0115
        L_0x0843:
            r1 = 8
            goto L_0x08a3
        L_0x0846:
            java.lang.String r2 = "PGN528"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x08a3
            goto L_0x0115
        L_0x0850:
            java.lang.String r1 = "NX573J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x085a
            goto L_0x0115
        L_0x085a:
            r1 = 6
            goto L_0x08a3
        L_0x085c:
            java.lang.String r1 = "NX541J"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0866
            goto L_0x0115
        L_0x0866:
            r1 = 5
            goto L_0x08a3
        L_0x0868:
            java.lang.String r1 = "CP8676_I02"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0872
            goto L_0x0115
        L_0x0872:
            r1 = 4
            goto L_0x08a3
        L_0x0874:
            java.lang.String r1 = "K50a40"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x087e
            goto L_0x0115
        L_0x087e:
            r1 = 3
            goto L_0x08a3
        L_0x0880:
            java.lang.String r1 = "GIONEE_SWW1631"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x088a
            goto L_0x0115
        L_0x088a:
            r1 = 2
            goto L_0x08a3
        L_0x088c:
            java.lang.String r1 = "GIONEE_SWW1627"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0896
            goto L_0x0115
        L_0x0896:
            r1 = 1
            goto L_0x08a3
        L_0x0898:
            java.lang.String r1 = "GIONEE_SWW1609"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x08a2
            goto L_0x0115
        L_0x08a2:
            r1 = 0
        L_0x08a3:
            switch(r1) {
                case 0: goto L_0x08b4;
                case 1: goto L_0x08b4;
                case 2: goto L_0x08b4;
                case 3: goto L_0x08b4;
                case 4: goto L_0x08b4;
                case 5: goto L_0x08b4;
                case 6: goto L_0x08b4;
                case 7: goto L_0x08b4;
                case 8: goto L_0x08b4;
                case 9: goto L_0x08b4;
                case 10: goto L_0x08b4;
                case 11: goto L_0x08b4;
                case 12: goto L_0x08b4;
                case 13: goto L_0x08b4;
                case 14: goto L_0x08b4;
                case 15: goto L_0x08b4;
                case 16: goto L_0x08b4;
                case 17: goto L_0x08b4;
                case 18: goto L_0x08b4;
                case 19: goto L_0x08b4;
                case 20: goto L_0x08b4;
                case 21: goto L_0x08b4;
                case 22: goto L_0x08b4;
                case 23: goto L_0x08b4;
                case 24: goto L_0x08b4;
                case 25: goto L_0x08b4;
                case 26: goto L_0x08b4;
                case 27: goto L_0x08b4;
                case 28: goto L_0x08b4;
                case 29: goto L_0x08b4;
                case 30: goto L_0x08b4;
                case 31: goto L_0x08b4;
                case 32: goto L_0x08b4;
                case 33: goto L_0x08b4;
                case 34: goto L_0x08b4;
                case 35: goto L_0x08b4;
                case 36: goto L_0x08b4;
                case 37: goto L_0x08b4;
                case 38: goto L_0x08b4;
                case 39: goto L_0x08b4;
                case 40: goto L_0x08b4;
                case 41: goto L_0x08b4;
                case 42: goto L_0x08b4;
                case 43: goto L_0x08b4;
                case 44: goto L_0x08b4;
                case 45: goto L_0x08b4;
                case 46: goto L_0x08b4;
                case 47: goto L_0x08b4;
                case 48: goto L_0x08b4;
                case 49: goto L_0x08b4;
                case 50: goto L_0x08b4;
                case 51: goto L_0x08b4;
                case 52: goto L_0x08b4;
                case 53: goto L_0x08b4;
                case 54: goto L_0x08b4;
                case 55: goto L_0x08b4;
                case 56: goto L_0x08b4;
                case 57: goto L_0x08b4;
                case 58: goto L_0x08b4;
                case 59: goto L_0x08b4;
                case 60: goto L_0x08b4;
                case 61: goto L_0x08b4;
                case 62: goto L_0x08b4;
                case 63: goto L_0x08b4;
                case 64: goto L_0x08b4;
                case 65: goto L_0x08b4;
                case 66: goto L_0x08b4;
                case 67: goto L_0x08b4;
                case 68: goto L_0x08b4;
                case 69: goto L_0x08b4;
                case 70: goto L_0x08b4;
                case 71: goto L_0x08b4;
                case 72: goto L_0x08b4;
                case 73: goto L_0x08b4;
                case 74: goto L_0x08b4;
                case 75: goto L_0x08b4;
                case 76: goto L_0x08b4;
                case 77: goto L_0x08b4;
                case 78: goto L_0x08b4;
                case 79: goto L_0x08b4;
                case 80: goto L_0x08b4;
                case 81: goto L_0x08b4;
                case 82: goto L_0x08b4;
                case 83: goto L_0x08b4;
                case 84: goto L_0x08b4;
                case 85: goto L_0x08b4;
                case 86: goto L_0x08b4;
                case 87: goto L_0x08b4;
                case 88: goto L_0x08b4;
                case 89: goto L_0x08b4;
                case 90: goto L_0x08b4;
                case 91: goto L_0x08b4;
                case 92: goto L_0x08b4;
                case 93: goto L_0x08b4;
                case 94: goto L_0x08b4;
                case 95: goto L_0x08b4;
                case 96: goto L_0x08b4;
                case 97: goto L_0x08b4;
                case 98: goto L_0x08b4;
                case 99: goto L_0x08b4;
                case 100: goto L_0x08b4;
                case 101: goto L_0x08b4;
                case 102: goto L_0x08b4;
                case 103: goto L_0x08b4;
                case 104: goto L_0x08b4;
                case 105: goto L_0x08b4;
                case 106: goto L_0x08b4;
                case 107: goto L_0x08b4;
                case 108: goto L_0x08b4;
                case 109: goto L_0x08b4;
                case 110: goto L_0x08b4;
                case 111: goto L_0x08b4;
                case 112: goto L_0x08b4;
                case 113: goto L_0x08b4;
                case 114: goto L_0x08b4;
                case 115: goto L_0x08b4;
                case 116: goto L_0x08b4;
                case 117: goto L_0x08b4;
                case 118: goto L_0x08b4;
                case 119: goto L_0x08b4;
                case 120: goto L_0x08b4;
                case 121: goto L_0x08b4;
                case 122: goto L_0x08b4;
                case 123: goto L_0x08b4;
                case 124: goto L_0x08b4;
                case 125: goto L_0x08b4;
                case 126: goto L_0x08b4;
                case 127: goto L_0x08b4;
                case 128: goto L_0x08b4;
                case 129: goto L_0x08b4;
                case 130: goto L_0x08b4;
                case 131: goto L_0x08b4;
                case 132: goto L_0x08b4;
                case 133: goto L_0x08b4;
                case 134: goto L_0x08b4;
                case 135: goto L_0x08b4;
                case 136: goto L_0x08b4;
                case 137: goto L_0x08b4;
                case 138: goto L_0x08b4;
                case 139: goto L_0x08b4;
                default: goto L_0x08a6;
            }
        L_0x08a6:
            java.lang.String r0 = androidx.media3.common.util.Util.MODEL
            r0.hashCode()
            java.lang.String r1 = "JSN-L21"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x08b4
            goto L_0x08b5
        L_0x08b4:
            return r9
        L_0x08b5:
            return r8
        L_0x08b6:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.MediaCodecVideoRenderer.evaluateDeviceNeedsSetOutputSurfaceWorkaround():boolean");
    }

    private final class OnFrameRenderedListenerV23 implements MediaCodecAdapter.OnFrameRenderedListener, Handler.Callback {
        private static final int HANDLE_FRAME_RENDERED = 0;
        private final Handler handler;

        public OnFrameRenderedListenerV23(MediaCodecAdapter mediaCodecAdapter) {
            Handler createHandlerForCurrentLooper = Util.createHandlerForCurrentLooper(this);
            this.handler = createHandlerForCurrentLooper;
            mediaCodecAdapter.setOnFrameRenderedListener(this, createHandlerForCurrentLooper);
        }

        public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long j, long j2) {
            if (Util.SDK_INT < 30) {
                this.handler.sendMessageAtFrontOfQueue(Message.obtain(this.handler, 0, (int) (j >> 32), (int) j));
                return;
            }
            handleFrameRendered(j);
        }

        public boolean handleMessage(Message message) {
            if (message.what != 0) {
                return false;
            }
            handleFrameRendered(Util.toLong(message.arg1, message.arg2));
            return true;
        }

        private void handleFrameRendered(long j) {
            if (this == MediaCodecVideoRenderer.this.tunnelingOnFrameRenderedListener && MediaCodecVideoRenderer.this.getCodec() != null) {
                if (j == Long.MAX_VALUE) {
                    MediaCodecVideoRenderer.this.onProcessedTunneledEndOfStream();
                    return;
                }
                try {
                    MediaCodecVideoRenderer.this.onProcessedTunneledBuffer(j);
                } catch (ExoPlaybackException e) {
                    MediaCodecVideoRenderer.this.setPendingPlaybackException(e);
                }
            }
        }
    }
}
