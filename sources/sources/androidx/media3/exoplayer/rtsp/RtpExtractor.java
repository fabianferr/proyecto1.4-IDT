package androidx.media3.exoplayer.rtsp;

import android.os.SystemClock;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.exoplayer.rtsp.reader.DefaultRtpPayloadReaderFactory;
import androidx.media3.exoplayer.rtsp.reader.RtpPayloadReader;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.SeekMap;
import java.io.IOException;

final class RtpExtractor implements Extractor {
    private boolean firstPacketRead;
    private volatile int firstSequenceNumber = -1;
    private volatile long firstTimestamp = -9223372036854775807L;
    private boolean isSeekPending;
    private final Object lock = new Object();
    private long nextRtpTimestamp = -9223372036854775807L;
    private ExtractorOutput output;
    private final RtpPayloadReader payloadReader;
    private long playbackStartTimeUs = -9223372036854775807L;
    private final RtpPacketReorderingQueue reorderingQueue = new RtpPacketReorderingQueue();
    private final ParsableByteArray rtpPacketDataBuffer = new ParsableByteArray();
    private final ParsableByteArray rtpPacketScratchBuffer = new ParsableByteArray(65507);
    private final int trackId;

    private static long getCutoffTimeMs(long j) {
        return j - 30;
    }

    public void release() {
    }

    public RtpExtractor(RtpPayloadFormat rtpPayloadFormat, int i) {
        this.trackId = i;
        this.payloadReader = (RtpPayloadReader) Assertions.checkNotNull(new DefaultRtpPayloadReaderFactory().createPayloadReader(rtpPayloadFormat));
    }

    public void setFirstTimestamp(long j) {
        this.firstTimestamp = j;
    }

    public void setFirstSequenceNumber(int i) {
        this.firstSequenceNumber = i;
    }

    public boolean hasReadFirstRtpPacket() {
        return this.firstPacketRead;
    }

    public void preSeek() {
        synchronized (this.lock) {
            this.isSeekPending = true;
        }
    }

    public boolean sniff(ExtractorInput extractorInput) {
        throw new UnsupportedOperationException("RTP packets are transmitted in a packet stream do not support sniffing.");
    }

    public void init(ExtractorOutput extractorOutput) {
        this.payloadReader.createTracks(extractorOutput, this.trackId);
        extractorOutput.endTracks();
        extractorOutput.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
        this.output = extractorOutput;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        Assertions.checkNotNull(this.output);
        int read = extractorInput.read(this.rtpPacketScratchBuffer.getData(), 0, 65507);
        if (read == -1) {
            return -1;
        }
        if (read == 0) {
            return 0;
        }
        this.rtpPacketScratchBuffer.setPosition(0);
        this.rtpPacketScratchBuffer.setLimit(read);
        RtpPacket parse = RtpPacket.parse(this.rtpPacketScratchBuffer);
        if (parse == null) {
            return 0;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long cutoffTimeMs = getCutoffTimeMs(elapsedRealtime);
        this.reorderingQueue.offer(parse, elapsedRealtime);
        RtpPacket poll = this.reorderingQueue.poll(cutoffTimeMs);
        if (poll == null) {
            return 0;
        }
        if (!this.firstPacketRead) {
            if (this.firstTimestamp == -9223372036854775807L) {
                this.firstTimestamp = poll.timestamp;
            }
            if (this.firstSequenceNumber == -1) {
                this.firstSequenceNumber = poll.sequenceNumber;
            }
            this.payloadReader.onReceivingFirstPacket(this.firstTimestamp, this.firstSequenceNumber);
            this.firstPacketRead = true;
        }
        synchronized (this.lock) {
            if (!this.isSeekPending) {
                do {
                    this.rtpPacketDataBuffer.reset(poll.payloadData);
                    this.payloadReader.consume(this.rtpPacketDataBuffer, poll.timestamp, poll.sequenceNumber, poll.marker);
                    poll = this.reorderingQueue.poll(cutoffTimeMs);
                } while (poll != null);
            } else if (!(this.nextRtpTimestamp == -9223372036854775807L || this.playbackStartTimeUs == -9223372036854775807L)) {
                this.reorderingQueue.reset();
                this.payloadReader.seek(this.nextRtpTimestamp, this.playbackStartTimeUs);
                this.isSeekPending = false;
                this.nextRtpTimestamp = -9223372036854775807L;
                this.playbackStartTimeUs = -9223372036854775807L;
            }
        }
        return 0;
    }

    public void seek(long j, long j2) {
        synchronized (this.lock) {
            if (!this.isSeekPending) {
                this.isSeekPending = true;
            }
            this.nextRtpTimestamp = j;
            this.playbackStartTimeUs = j2;
        }
    }
}
