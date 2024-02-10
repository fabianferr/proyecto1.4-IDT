package androidx.media3.exoplayer.rtsp.reader;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableBitArray;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.rtsp.RtpPayloadFormat;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;

public final class RtpAc3Reader implements RtpPayloadReader {
    private static final int AC3_FRAME_TYPE_COMPLETE_FRAME = 0;
    private static final int AC3_FRAME_TYPE_INITIAL_FRAGMENT_A = 1;
    private static final int AC3_FRAME_TYPE_INITIAL_FRAGMENT_B = 2;
    private static final int AC3_FRAME_TYPE_NON_INITIAL_FRAGMENT = 3;
    private static final int AC3_PAYLOAD_HEADER_SIZE = 2;
    private long firstReceivedTimestamp = -9223372036854775807L;
    private int numBytesPendingMetadataOutput;
    private final RtpPayloadFormat payloadFormat;
    private long sampleTimeUsOfFramePendingMetadataOutput;
    private final ParsableBitArray scratchBitBuffer = new ParsableBitArray();
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    public RtpAc3Reader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 1);
        this.trackOutput = track;
        track.format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        Assertions.checkState(this.firstReceivedTimestamp == -9223372036854775807L);
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte() & 255;
        long sampleTimeUs = RtpReaderUtils.toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.payloadFormat.clockRate);
        if (readUnsignedByte != 0) {
            if (readUnsignedByte == 1 || readUnsignedByte == 2) {
                maybeOutputSampleMetadata();
            } else if (readUnsignedByte != 3) {
                throw new IllegalArgumentException(String.valueOf(readUnsignedByte));
            }
            processFragmentedPacket(parsableByteArray, z, readUnsignedByte, sampleTimeUs);
            return;
        }
        maybeOutputSampleMetadata();
        if (readUnsignedByte2 == 1) {
            processSingleFramePacket(parsableByteArray, sampleTimeUs);
        } else {
            processMultiFramePacket(parsableByteArray, readUnsignedByte2, sampleTimeUs);
        }
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.startTimeOffsetUs = j2;
    }

    private void processSingleFramePacket(ParsableByteArray parsableByteArray, long j) {
        int bytesLeft = parsableByteArray.bytesLeft();
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, bytesLeft);
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, 1, bytesLeft, 0, (TrackOutput.CryptoData) null);
    }

    private void processMultiFramePacket(ParsableByteArray parsableByteArray, int i, long j) {
        this.scratchBitBuffer.reset(parsableByteArray.getData());
        this.scratchBitBuffer.skipBytes(2);
        for (int i2 = 0; i2 < i; i2++) {
            Ac3Util.SyncFrameInfo parseAc3SyncframeInfo = Ac3Util.parseAc3SyncframeInfo(this.scratchBitBuffer);
            ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, parseAc3SyncframeInfo.frameSize);
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, 1, parseAc3SyncframeInfo.frameSize, 0, (TrackOutput.CryptoData) null);
            j += ((long) (parseAc3SyncframeInfo.sampleCount / parseAc3SyncframeInfo.sampleRate)) * 1000000;
            this.scratchBitBuffer.skipBytes(parseAc3SyncframeInfo.frameSize);
        }
    }

    private void processFragmentedPacket(ParsableByteArray parsableByteArray, boolean z, int i, long j) {
        int bytesLeft = parsableByteArray.bytesLeft();
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleData(parsableByteArray, bytesLeft);
        this.numBytesPendingMetadataOutput += bytesLeft;
        this.sampleTimeUsOfFramePendingMetadataOutput = j;
        if (z && i == 3) {
            outputSampleMetadataForFragmentedPackets();
        }
    }

    private void maybeOutputSampleMetadata() {
        if (this.numBytesPendingMetadataOutput > 0) {
            outputSampleMetadataForFragmentedPackets();
        }
    }

    private void outputSampleMetadataForFragmentedPackets() {
        ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(this.sampleTimeUsOfFramePendingMetadataOutput, 1, this.numBytesPendingMetadataOutput, 0, (TrackOutput.CryptoData) null);
        this.numBytesPendingMetadataOutput = 0;
    }
}