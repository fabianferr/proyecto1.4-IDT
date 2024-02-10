package androidx.media3.exoplayer.dash;

import androidx.media3.exoplayer.dash.manifest.RangedUri;
import androidx.media3.extractor.ChunkIndex;

public final class DashWrappingSegmentIndex implements DashSegmentIndex {
    private final ChunkIndex chunkIndex;
    private final long timeOffsetUs;

    public long getFirstAvailableSegmentNum(long j, long j2) {
        return 0;
    }

    public long getFirstSegmentNum() {
        return 0;
    }

    public long getNextSegmentAvailableTimeUs(long j, long j2) {
        return -9223372036854775807L;
    }

    public boolean isExplicit() {
        return true;
    }

    public DashWrappingSegmentIndex(ChunkIndex chunkIndex2, long j) {
        this.chunkIndex = chunkIndex2;
        this.timeOffsetUs = j;
    }

    public long getSegmentCount(long j) {
        return (long) this.chunkIndex.length;
    }

    public long getAvailableSegmentCount(long j, long j2) {
        return (long) this.chunkIndex.length;
    }

    public long getTimeUs(long j) {
        return this.chunkIndex.timesUs[(int) j] - this.timeOffsetUs;
    }

    public long getDurationUs(long j, long j2) {
        return this.chunkIndex.durationsUs[(int) j];
    }

    public RangedUri getSegmentUrl(long j) {
        int i = (int) j;
        return new RangedUri((String) null, this.chunkIndex.offsets[i], (long) this.chunkIndex.sizes[i]);
    }

    public long getSegmentNum(long j, long j2) {
        return (long) this.chunkIndex.getChunkIndex(j + this.timeOffsetUs);
    }
}
