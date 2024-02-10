package androidx.media3.extractor.mp3;

import androidx.media3.extractor.ConstantBitrateSeekMap;
import androidx.media3.extractor.MpegAudioUtil;

final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public long getDataEndPosition() {
        return -1;
    }

    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.Header header, boolean z) {
        super(j, j2, header.bitrate, header.frameSize, z);
    }

    public long getTimeUs(long j) {
        return getTimeUsAtPosition(j);
    }
}
