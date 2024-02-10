package androidx.media3.exoplayer.audio;

import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.extractor.OpusUtil;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;

public class DefaultAudioTrackBufferSizeProvider implements DefaultAudioSink.AudioTrackBufferSizeProvider {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int MAX_PCM_BUFFER_DURATION_US = 750000;
    private static final int MIN_PCM_BUFFER_DURATION_US = 250000;
    private static final int OFFLOAD_BUFFER_DURATION_US = 50000000;
    private static final int PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final int PCM_BUFFER_MULTIPLICATION_FACTOR = 4;
    public final int ac3BufferMultiplicationFactor;
    protected final int maxPcmBufferDurationUs;
    protected final int minPcmBufferDurationUs;
    protected final int offloadBufferDurationUs;
    protected final int passthroughBufferDurationUs;
    protected final int pcmBufferMultiplicationFactor;

    public static class Builder {
        /* access modifiers changed from: private */
        public int ac3BufferMultiplicationFactor = 2;
        /* access modifiers changed from: private */
        public int maxPcmBufferDurationUs = DefaultAudioTrackBufferSizeProvider.MAX_PCM_BUFFER_DURATION_US;
        /* access modifiers changed from: private */
        public int minPcmBufferDurationUs = 250000;
        /* access modifiers changed from: private */
        public int offloadBufferDurationUs = DefaultAudioTrackBufferSizeProvider.OFFLOAD_BUFFER_DURATION_US;
        /* access modifiers changed from: private */
        public int passthroughBufferDurationUs = 250000;
        /* access modifiers changed from: private */
        public int pcmBufferMultiplicationFactor = 4;

        public Builder setMinPcmBufferDurationUs(int i) {
            this.minPcmBufferDurationUs = i;
            return this;
        }

        public Builder setMaxPcmBufferDurationUs(int i) {
            this.maxPcmBufferDurationUs = i;
            return this;
        }

        public Builder setPcmBufferMultiplicationFactor(int i) {
            this.pcmBufferMultiplicationFactor = i;
            return this;
        }

        public Builder setPassthroughBufferDurationUs(int i) {
            this.passthroughBufferDurationUs = i;
            return this;
        }

        public Builder setOffloadBufferDurationUs(int i) {
            this.offloadBufferDurationUs = i;
            return this;
        }

        public Builder setAc3BufferMultiplicationFactor(int i) {
            this.ac3BufferMultiplicationFactor = i;
            return this;
        }

        public DefaultAudioTrackBufferSizeProvider build() {
            return new DefaultAudioTrackBufferSizeProvider(this);
        }
    }

    protected DefaultAudioTrackBufferSizeProvider(Builder builder) {
        this.minPcmBufferDurationUs = builder.minPcmBufferDurationUs;
        this.maxPcmBufferDurationUs = builder.maxPcmBufferDurationUs;
        this.pcmBufferMultiplicationFactor = builder.pcmBufferMultiplicationFactor;
        this.passthroughBufferDurationUs = builder.passthroughBufferDurationUs;
        this.offloadBufferDurationUs = builder.offloadBufferDurationUs;
        this.ac3BufferMultiplicationFactor = builder.ac3BufferMultiplicationFactor;
    }

    public int getBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        double d2 = (double) get1xBufferSizeInBytes(i, i2, i3, i4, i5, i6);
        Double.isNaN(d2);
        return (((Math.max(i, (int) (d2 * d)) + i4) - 1) / i4) * i4;
    }

    /* access modifiers changed from: protected */
    public int get1xBufferSizeInBytes(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return getPcmBufferSizeInBytes(i, i5, i4);
        }
        if (i3 == 1) {
            return getOffloadBufferSizeInBytes(i2);
        }
        if (i3 == 2) {
            return getPassthroughBufferSizeInBytes(i2, i6);
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: protected */
    public int getPcmBufferSizeInBytes(int i, int i2, int i3) {
        return Util.constrainValue(i * this.pcmBufferMultiplicationFactor, durationUsToBytes(this.minPcmBufferDurationUs, i2, i3), durationUsToBytes(this.maxPcmBufferDurationUs, i2, i3));
    }

    /* access modifiers changed from: protected */
    public int getPassthroughBufferSizeInBytes(int i, int i2) {
        int i3;
        int i4 = this.passthroughBufferDurationUs;
        if (i == 5) {
            i4 *= this.ac3BufferMultiplicationFactor;
        }
        if (i2 != -1) {
            i3 = IntMath.divide(i2, 8, RoundingMode.CEILING);
        } else {
            i3 = getMaximumEncodedRateBytesPerSecond(i);
        }
        return Ints.checkedCast((((long) i4) * ((long) i3)) / 1000000);
    }

    /* access modifiers changed from: protected */
    public int getOffloadBufferSizeInBytes(int i) {
        return Ints.checkedCast((((long) this.offloadBufferDurationUs) * ((long) getMaximumEncodedRateBytesPerSecond(i))) / 1000000);
    }

    protected static int durationUsToBytes(int i, int i2, int i3) {
        return Ints.checkedCast(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    protected static int getMaximumEncodedRateBytesPerSecond(int i) {
        switch (i) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return 768000;
            case 7:
                return 192000;
            case 8:
                return 2250000;
            case 9:
                return 40000;
            case 10:
                return 100000;
            case 11:
                return 16000;
            case 12:
                return 7000;
            case 14:
                return 3062500;
            case 15:
                return 8000;
            case 16:
                return 256000;
            case 17:
                return 336000;
            case 20:
                return OpusUtil.MAX_BYTES_PER_SECOND;
            default:
                throw new IllegalArgumentException();
        }
    }
}
