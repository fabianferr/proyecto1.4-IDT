package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {
    private static final int OPUS_CODE = 1332770163;
    private static final byte[] OPUS_SIGNATURE = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean headerRead;

    OpusReader() {
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (bytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.headerRead = false;
        }
    }

    /* access modifiers changed from: protected */
    public long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.getData()));
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) {
        boolean z = true;
        if (!this.headerRead) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            int channelCount = OpusUtil.getChannelCount(copyOf);
            setupData.format = new Format.Builder().setSampleMimeType("audio/opus").setChannelCount(channelCount).setSampleRate(48000).setInitializationData(OpusUtil.buildInitializationData(copyOf)).build();
            this.headerRead = true;
            return true;
        }
        Assertions.checkNotNull(setupData.format);
        if (parsableByteArray.readInt() != 1332770163) {
            z = false;
        }
        parsableByteArray.setPosition(0);
        return z;
    }

    private long getPacketDurationUs(byte[] bArr) {
        byte b;
        byte b2 = bArr[0] & 255;
        byte b3 = b2 & 3;
        if (b3 != 0) {
            b = 2;
            if (!(b3 == 1 || b3 == 2)) {
                b = bArr[1] & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            b = 1;
        }
        int i = b2 >> 3;
        int i2 = i & 3;
        return ((long) b) * ((long) (i >= 16 ? 2500 << i2 : i >= 12 ? 10000 << (i2 & 1) : i2 == 3 ? 60000 : 10000 << i2));
    }
}