package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.util.List;

public final class RtspMediaSource extends BaseMediaSource {
    public static final long DEFAULT_TIMEOUT_MS = 8000;
    private final MediaItem mediaItem;
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    private long timelineDurationUs = -9223372036854775807L;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder = true;
    private boolean timelineIsSeekable;
    private final Uri uri;
    private final String userAgent;

    public void maybeThrowSourceInfoRefreshError() {
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
    }

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.rtsp");
    }

    public static final class Factory implements MediaSourceFactory {
        private boolean forceUseRtpTcp;
        private long timeoutMs = 8000;
        private String userAgent = ExoPlayerLibraryInfo.VERSION_SLASHY;

        public /* synthetic */ MediaSource createMediaSource(Uri uri) {
            return MediaSourceFactory.CC.$default$createMediaSource(this, uri);
        }

        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        @Deprecated
        public Factory setDrmHttpDataSourceFactory(HttpDataSource.Factory factory) {
            return this;
        }

        @Deprecated
        public Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
            return this;
        }

        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        @Deprecated
        public Factory setDrmUserAgent(String str) {
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public /* synthetic */ MediaSourceFactory setStreamKeys(List list) {
            return MediaSourceFactory.CC.$default$setStreamKeys(this, list);
        }

        public Factory setForceUseRtpTcp(boolean z) {
            this.forceUseRtpTcp = z;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setTimeoutMs(long j) {
            Assertions.checkArgument(j > 0);
            this.timeoutMs = j;
            return this;
        }

        public RtspMediaSource createMediaSource(MediaItem mediaItem) {
            RtpDataChannel.Factory factory;
            Assertions.checkNotNull(mediaItem.playbackProperties);
            if (this.forceUseRtpTcp) {
                factory = new TransferRtpDataChannelFactory(this.timeoutMs);
            } else {
                factory = new UdpDataSourceRtpDataChannelFactory(this.timeoutMs);
            }
            return new RtspMediaSource(mediaItem, factory, this.userAgent);
        }
    }

    public static final class RtspPlaybackException extends IOException {
        public RtspPlaybackException(String str) {
            super(str);
        }

        public RtspPlaybackException(Throwable th) {
            super(th);
        }

        public RtspPlaybackException(String str, Throwable th) {
            super(str, th);
        }
    }

    RtspMediaSource(MediaItem mediaItem2, RtpDataChannel.Factory factory, String str) {
        this.mediaItem = mediaItem2;
        this.rtpDataChannelFactory = factory;
        this.userAgent = str;
        this.uri = ((MediaItem.PlaybackProperties) Assertions.checkNotNull(mediaItem2.playbackProperties)).uri;
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        notifySourceInfoRefreshed();
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new RtspMediaPeriod(allocator, this.rtpDataChannelFactory, this.uri, new RtspMediaSource$$ExternalSyntheticLambda0(this), this.userAgent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createPeriod$0$com-google-android-exoplayer2-source-rtsp-RtspMediaSource  reason: not valid java name */
    public /* synthetic */ void m2077lambda$createPeriod$0$comgoogleandroidexoplayer2sourcertspRtspMediaSource(RtspSessionTiming rtspSessionTiming) {
        this.timelineDurationUs = C.msToUs(rtspSessionTiming.getDurationMs());
        this.timelineIsSeekable = !rtspSessionTiming.isLive();
        this.timelineIsLive = rtspSessionTiming.isLive();
        this.timelineIsPlaceholder = false;
        notifySourceInfoRefreshed();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).release();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [com.google.android.exoplayer2.source.rtsp.RtspMediaSource$1] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void notifySourceInfoRefreshed() {
        /*
            r9 = this;
            com.google.android.exoplayer2.source.SinglePeriodTimeline r8 = new com.google.android.exoplayer2.source.SinglePeriodTimeline
            long r1 = r9.timelineDurationUs
            boolean r3 = r9.timelineIsSeekable
            r4 = 0
            boolean r5 = r9.timelineIsLive
            r6 = 0
            com.google.android.exoplayer2.MediaItem r7 = r9.mediaItem
            r0 = r8
            r0.<init>((long) r1, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.Object) r6, (com.google.android.exoplayer2.MediaItem) r7)
            boolean r0 = r9.timelineIsPlaceholder
            if (r0 == 0) goto L_0x001a
            com.google.android.exoplayer2.source.rtsp.RtspMediaSource$1 r0 = new com.google.android.exoplayer2.source.rtsp.RtspMediaSource$1
            r0.<init>(r9, r8)
            r8 = r0
        L_0x001a:
            r9.refreshSourceInfo(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaSource.notifySourceInfoRefreshed():void");
    }
}
