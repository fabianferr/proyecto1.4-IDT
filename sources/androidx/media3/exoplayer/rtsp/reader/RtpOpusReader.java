package androidx.media3.exoplayer.rtsp.reader;

import androidx.media3.common.Format;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.rtsp.RtpPacket;
import androidx.media3.exoplayer.rtsp.RtpPayloadFormat;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.OpusUtil;
import androidx.media3.extractor.TrackOutput;
import java.util.List;

final class RtpOpusReader implements RtpPayloadReader {
    private static final int MEDIA_CLOCK_FREQUENCY = 48000;
    private static final String TAG = "RtpOpusReader";
    private long firstReceivedTimestamp = -1;
    private boolean foundOpusCommentHeader;
    private boolean foundOpusIDHeader;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber = -1;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    public RtpOpusReader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 1);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i2 = i;
        Assertions.checkStateNotNull(this.trackOutput);
        if (!this.foundOpusIDHeader) {
            validateOpusIdHeader(parsableByteArray);
            List<byte[]> buildInitializationData = OpusUtil.buildInitializationData(parsableByteArray.getData());
            Format.Builder buildUpon = this.payloadFormat.format.buildUpon();
            buildUpon.setInitializationData(buildInitializationData);
            this.trackOutput.format(buildUpon.build());
            this.foundOpusIDHeader = true;
        } else {
            boolean z2 = false;
            if (!this.foundOpusCommentHeader) {
                if (parsableByteArray.limit() >= 8) {
                    z2 = true;
                }
                Assertions.checkArgument(z2, "Comment Header has insufficient data");
                Assertions.checkArgument(parsableByteArray2.readString(8).equals("OpusTags"), "Comment Header should follow ID Header");
                this.foundOpusCommentHeader = true;
            } else {
                int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
                if (i2 != nextSequenceNumber) {
                    Log.w(TAG, Util.formatInvariant("Received RTP packet with unexpected sequence number. Expected: %d; received: %d.", Integer.valueOf(nextSequenceNumber), Integer.valueOf(i)));
                }
                int bytesLeft = parsableByteArray.bytesLeft();
                this.trackOutput.sampleData(parsableByteArray2, bytesLeft);
                this.trackOutput.sampleMetadata(RtpReaderUtils.toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, 48000), 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
            }
        }
        this.previousSequenceNumber = i2;
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }

    private static void validateOpusIdHeader(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        boolean z = false;
        Assertions.checkArgument(parsableByteArray.limit() > 18, "ID Header has insufficient data");
        Assertions.checkArgument(parsableByteArray.readString(8).equals("OpusHead"), "ID Header missing");
        if (parsableByteArray.readUnsignedByte() == 1) {
            z = true;
        }
        Assertions.checkArgument(z, "version number must always be 1");
        parsableByteArray.setPosition(position);
    }
}
