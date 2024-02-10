package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.TransferListener;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.rtsp.RtpDataChannel;
import androidx.media3.exoplayer.rtsp.RtspMediaPeriod;
import androidx.media3.exoplayer.source.BaseMediaSource;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.MediaSourceFactory;
import androidx.media3.exoplayer.upstream.Allocator;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import androidx.media3.exoplayer.upstream.LoadErrorHandlingPolicy;
import java.io.IOException;
import javax.net.SocketFactory;

public final class RtspMediaSource extends BaseMediaSource {
    public static final long DEFAULT_TIMEOUT_MS = 8000;
    private final boolean debugLoggingEnabled;
    private final MediaItem mediaItem;
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    private final SocketFactory socketFactory;
    /* access modifiers changed from: private */
    public long timelineDurationUs = -9223372036854775807L;
    /* access modifiers changed from: private */
    public boolean timelineIsLive;
    /* access modifiers changed from: private */
    public boolean timelineIsPlaceholder = true;
    /* access modifiers changed from: private */
    public boolean timelineIsSeekable;
    private final Uri uri;
    private final String userAgent;

    public void maybeThrowSourceInfoRefreshError() {
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
    }

    static {
        MediaLibraryInfo.registerModule("media3.exoplayer.rtsp");
    }

    public static final class Factory implements MediaSourceFactory {
        private boolean debugLoggingEnabled;
        private boolean forceUseRtpTcp;
        private SocketFactory socketFactory = SocketFactory.getDefault();
        private long timeoutMs = 8000;
        private String userAgent = MediaLibraryInfo.VERSION_SLASHY;

        public int[] getSupportedTypes() {
            return new int[]{3};
        }

        public /* synthetic */ MediaSource.Factory setCmcdConfigurationFactory(CmcdConfiguration.Factory factory) {
            return MediaSource.Factory.CC.$default$setCmcdConfigurationFactory(this, factory);
        }

        public Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
            return this;
        }

        public Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            return this;
        }

        public Factory setForceUseRtpTcp(boolean z) {
            this.forceUseRtpTcp = z;
            return this;
        }

        public Factory setUserAgent(String str) {
            this.userAgent = str;
            return this;
        }

        public Factory setSocketFactory(SocketFactory socketFactory2) {
            this.socketFactory = socketFactory2;
            return this;
        }

        public Factory setDebugLoggingEnabled(boolean z) {
            this.debugLoggingEnabled = z;
            return this;
        }

        public Factory setTimeoutMs(long j) {
            Assertions.checkArgument(j > 0);
            this.timeoutMs = j;
            return this;
        }

        public RtspMediaSource createMediaSource(MediaItem mediaItem) {
            RtpDataChannel.Factory factory;
            Assertions.checkNotNull(mediaItem.localConfiguration);
            if (this.forceUseRtpTcp) {
                factory = new TransferRtpDataChannelFactory(this.timeoutMs);
            } else {
                factory = new UdpDataSourceRtpDataChannelFactory(this.timeoutMs);
            }
            return new RtspMediaSource(mediaItem, factory, this.userAgent, this.socketFactory, this.debugLoggingEnabled);
        }
    }

    public static class RtspPlaybackException extends IOException {
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

    public static final class RtspUdpUnsupportedTransportException extends RtspPlaybackException {
        public RtspUdpUnsupportedTransportException(String str) {
            super(str);
        }
    }

    RtspMediaSource(MediaItem mediaItem2, RtpDataChannel.Factory factory, String str, SocketFactory socketFactory2, boolean z) {
        this.mediaItem = mediaItem2;
        this.rtpDataChannelFactory = factory;
        this.userAgent = str;
        this.uri = ((MediaItem.LocalConfiguration) Assertions.checkNotNull(mediaItem2.localConfiguration)).uri;
        this.socketFactory = socketFactory2;
        this.debugLoggingEnabled = z;
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        notifySourceInfoRefreshed();
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new RtspMediaPeriod(allocator, this.rtpDataChannelFactory, this.uri, new RtspMediaPeriod.Listener() {
            public void onSourceInfoRefreshed(RtspSessionTiming rtspSessionTiming) {
                long unused = RtspMediaSource.this.timelineDurationUs = Util.msToUs(rtspSessionTiming.getDurationMs());
                boolean unused2 = RtspMediaSource.this.timelineIsSeekable = !rtspSessionTiming.isLive();
                boolean unused3 = RtspMediaSource.this.timelineIsLive = rtspSessionTiming.isLive();
                boolean unused4 = RtspMediaSource.this.timelineIsPlaceholder = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }

            public void onSeekingUnsupported() {
                boolean unused = RtspMediaSource.this.timelineIsSeekable = false;
                RtspMediaSource.this.notifySourceInfoRefreshed();
            }
        }, this.userAgent, this.socketFactory, this.debugLoggingEnabled);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((RtspMediaPeriod) mediaPeriod).release();
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [androidx.media3.exoplayer.rtsp.RtspMediaSource$2] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifySourceInfoRefreshed() {
        /*
            r9 = this;
            androidx.media3.exoplayer.source.SinglePeriodTimeline r8 = new androidx.media3.exoplayer.source.SinglePeriodTimeline
            long r1 = r9.timelineDurationUs
            boolean r3 = r9.timelineIsSeekable
            r4 = 0
            boolean r5 = r9.timelineIsLive
            r6 = 0
            androidx.media3.common.MediaItem r7 = r9.mediaItem
            r0 = r8
            r0.<init>((long) r1, (boolean) r3, (boolean) r4, (boolean) r5, (java.lang.Object) r6, (androidx.media3.common.MediaItem) r7)
            boolean r0 = r9.timelineIsPlaceholder
            if (r0 == 0) goto L_0x001a
            androidx.media3.exoplayer.rtsp.RtspMediaSource$2 r0 = new androidx.media3.exoplayer.rtsp.RtspMediaSource$2
            r0.<init>(r8)
            r8 = r0
        L_0x001a:
            r9.refreshSourceInfo(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.rtsp.RtspMediaSource.notifySourceInfoRefreshed():void");
    }
}
