package androidx.media3.exoplayer.rtsp.reader;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.rtsp.RtpPacket;
import androidx.media3.exoplayer.rtsp.RtpPayloadFormat;
import androidx.media3.extractor.ExtractorOutput;
import androidx.media3.extractor.TrackOutput;

final class RtpMp4aReader implements RtpPayloadReader {
    private static final String PARAMETER_MP4A_CONFIG = "config";
    private static final String TAG = "RtpMp4aReader";
    private long firstReceivedTimestamp;
    private int fragmentedSampleSizeBytes;
    private long fragmentedSampleTimeUs;
    private final int numberOfSubframes;
    private final RtpPayloadFormat payloadFormat;
    private int previousSequenceNumber;
    private long startTimeOffsetUs;
    private TrackOutput trackOutput;

    public RtpMp4aReader(RtpPayloadFormat rtpPayloadFormat) {
        this.payloadFormat = rtpPayloadFormat;
        try {
            this.numberOfSubframes = getNumOfSubframesFromMpeg4AudioConfig(rtpPayloadFormat.fmtpParameters);
            this.firstReceivedTimestamp = -9223372036854775807L;
            this.previousSequenceNumber = -1;
            this.fragmentedSampleSizeBytes = 0;
            this.startTimeOffsetUs = 0;
            this.fragmentedSampleTimeUs = -9223372036854775807L;
        } catch (ParserException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, int i) {
        TrackOutput track = extractorOutput.track(i, 2);
        this.trackOutput = track;
        ((TrackOutput) Util.castNonNull(track)).format(this.payloadFormat.format);
    }

    public void onReceivingFirstPacket(long j, int i) {
        Assertions.checkState(this.firstReceivedTimestamp == -9223372036854775807L);
        this.firstReceivedTimestamp = j;
    }

    public void consume(ParsableByteArray parsableByteArray, long j, int i, boolean z) {
        Assertions.checkStateNotNull(this.trackOutput);
        int nextSequenceNumber = RtpPacket.getNextSequenceNumber(this.previousSequenceNumber);
        if (this.fragmentedSampleSizeBytes > 0 && nextSequenceNumber < i) {
            outputSampleMetadataForFragmentedPackets();
        }
        for (int i2 = 0; i2 < this.numberOfSubframes; i2++) {
            int i3 = 0;
            while (parsableByteArray.getPosition() < parsableByteArray.limit()) {
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                i3 += readUnsignedByte;
                if (readUnsignedByte != 255) {
                    break;
                }
            }
            this.trackOutput.sampleData(parsableByteArray, i3);
            this.fragmentedSampleSizeBytes += i3;
        }
        this.fragmentedSampleTimeUs = RtpReaderUtils.toSampleTimeUs(this.startTimeOffsetUs, j, this.firstReceivedTimestamp, this.payloadFormat.clockRate);
        if (z) {
            outputSampleMetadataForFragmentedPackets();
        }
        this.previousSequenceNumber = i;
    }

    public void seek(long j, long j2) {
        this.firstReceivedTimestamp = j;
        this.fragmentedSampleSizeBytes = 0;
        this.startTimeOffsetUs = j2;
    }

    /* JADX WARNING: type inference failed for: r5v10, types: [int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getNumOfSubframesFromMpeg4AudioConfig(com.google.common.collect.ImmutableMap<java.lang.String, java.lang.String> r5) throws androidx.media3.common.ParserException {
        /*
            java.lang.String r0 = "config"
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0069
            int r2 = r5.length()
            int r2 = r2 % 2
            if (r2 != 0) goto L_0x0069
            byte[] r5 = androidx.media3.common.util.Util.getBytesFromHexString(r5)
            androidx.media3.common.util.ParsableBitArray r2 = new androidx.media3.common.util.ParsableBitArray
            r2.<init>(r5)
            int r5 = r2.readBits(r0)
            if (r5 != 0) goto L_0x0054
            int r5 = r2.readBits(r0)
            if (r5 != r0) goto L_0x002b
            r5 = 1
            goto L_0x002c
        L_0x002b:
            r5 = 0
        L_0x002c:
            java.lang.String r3 = "Only supports allStreamsSameTimeFraming."
            androidx.media3.common.util.Assertions.checkArgument(r5, r3)
            r5 = 6
            int r5 = r2.readBits(r5)
            r3 = 4
            int r3 = r2.readBits(r3)
            if (r3 != 0) goto L_0x003f
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            java.lang.String r4 = "Only suppors one program."
            androidx.media3.common.util.Assertions.checkArgument(r3, r4)
            r3 = 3
            int r2 = r2.readBits(r3)
            if (r2 != 0) goto L_0x004d
            r1 = 1
        L_0x004d:
            java.lang.String r2 = "Only suppors one layer."
            androidx.media3.common.util.Assertions.checkArgument(r1, r2)
            r1 = r5
            goto L_0x0069
        L_0x0054:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "unsupported audio mux version: "
            r0.<init>(r1)
            r0.append(r5)
            java.lang.String r5 = r0.toString()
            r0 = 0
            androidx.media3.common.ParserException r5 = androidx.media3.common.ParserException.createForMalformedDataOfUnknownType(r5, r0)
            throw r5
        L_0x0069:
            int r1 = r1 + r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.rtsp.reader.RtpMp4aReader.getNumOfSubframesFromMpeg4AudioConfig(com.google.common.collect.ImmutableMap):int");
    }

    private void outputSampleMetadataForFragmentedPackets() {
        ((TrackOutput) Assertions.checkNotNull(this.trackOutput)).sampleMetadata(this.fragmentedSampleTimeUs, 1, this.fragmentedSampleSizeBytes, 0, (TrackOutput.CryptoData) null);
        this.fragmentedSampleSizeBytes = 0;
        this.fragmentedSampleTimeUs = -9223372036854775807L;
    }
}
