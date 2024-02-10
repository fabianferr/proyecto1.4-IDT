package androidx.media3.exoplayer.rtsp;

import android.os.Handler;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSourceUtil;
import androidx.media3.exoplayer.rtsp.RtpDataChannel;
import androidx.media3.exoplayer.upstream.Loader;
import androidx.media3.extractor.DefaultExtractorInput;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import java.io.IOException;

final class RtpDataLoadable implements Loader.Loadable {
    private RtpDataChannel dataChannel;
    private final EventListener eventListener;
    private RtpExtractor extractor;
    private DefaultExtractorInput extractorInput;
    private volatile boolean loadCancelled;
    private volatile long nextRtpTimestamp;
    private final ExtractorOutput output;
    private volatile long pendingSeekPositionUs;
    private final Handler playbackThreadHandler = Util.createHandlerForCurrentLooper();
    private final RtpDataChannel.Factory rtpDataChannelFactory;
    public final RtspMediaTrack rtspMediaTrack;
    public final int trackId;

    public interface EventListener {
        void onTransportReady(String str, RtpDataChannel rtpDataChannel);
    }

    public RtpDataLoadable(int i, RtspMediaTrack rtspMediaTrack2, EventListener eventListener2, ExtractorOutput extractorOutput, RtpDataChannel.Factory factory) {
        this.trackId = i;
        this.rtspMediaTrack = rtspMediaTrack2;
        this.eventListener = eventListener2;
        this.output = extractorOutput;
        this.rtpDataChannelFactory = factory;
        this.pendingSeekPositionUs = -9223372036854775807L;
    }

    public void setTimestamp(long j) {
        if (j != -9223372036854775807L && !((RtpExtractor) Assertions.checkNotNull(this.extractor)).hasReadFirstRtpPacket()) {
            this.extractor.setFirstTimestamp(j);
        }
    }

    public void setSequenceNumber(int i) {
        if (!((RtpExtractor) Assertions.checkNotNull(this.extractor)).hasReadFirstRtpPacket()) {
            this.extractor.setFirstSequenceNumber(i);
        }
    }

    public void cancelLoad() {
        this.loadCancelled = true;
    }

    public void load() throws IOException {
        if (this.loadCancelled) {
            this.loadCancelled = false;
        }
        try {
            if (this.dataChannel == null) {
                RtpDataChannel createAndOpenDataChannel = this.rtpDataChannelFactory.createAndOpenDataChannel(this.trackId);
                this.dataChannel = createAndOpenDataChannel;
                this.playbackThreadHandler.post(new RtpDataLoadable$$ExternalSyntheticLambda0(this, createAndOpenDataChannel.getTransport(), this.dataChannel));
                this.extractorInput = new DefaultExtractorInput((DataReader) Assertions.checkNotNull(this.dataChannel), 0, -1);
                RtpExtractor rtpExtractor = new RtpExtractor(this.rtspMediaTrack.payloadFormat, this.trackId);
                this.extractor = rtpExtractor;
                rtpExtractor.init(this.output);
            }
            while (!this.loadCancelled) {
                if (this.pendingSeekPositionUs != -9223372036854775807L) {
                    ((RtpExtractor) Assertions.checkNotNull(this.extractor)).seek(this.nextRtpTimestamp, this.pendingSeekPositionUs);
                    this.pendingSeekPositionUs = -9223372036854775807L;
                }
                if (((RtpExtractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), new PositionHolder()) == -1) {
                    break;
                }
            }
            this.loadCancelled = false;
        } finally {
            if (((RtpDataChannel) Assertions.checkNotNull(this.dataChannel)).needsClosingOnLoadCompletion()) {
                DataSourceUtil.closeQuietly(this.dataChannel);
                this.dataChannel = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$load$0$androidx-media3-exoplayer-rtsp-RtpDataLoadable  reason: not valid java name */
    public /* synthetic */ void m140lambda$load$0$androidxmedia3exoplayerrtspRtpDataLoadable(String str, RtpDataChannel rtpDataChannel) {
        this.eventListener.onTransportReady(str, rtpDataChannel);
    }

    public void resetForSeek() {
        ((RtpExtractor) Assertions.checkNotNull(this.extractor)).preSeek();
    }

    public void seekToUs(long j, long j2) {
        this.pendingSeekPositionUs = j;
        this.nextRtpTimestamp = j2;
    }
}
