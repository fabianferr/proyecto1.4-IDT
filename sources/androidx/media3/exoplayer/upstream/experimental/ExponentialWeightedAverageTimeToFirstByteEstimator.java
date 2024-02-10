package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Clock;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ExponentialWeightedAverageTimeToFirstByteEstimator implements TimeToFirstByteEstimator {
    public static final double DEFAULT_SMOOTHING_FACTOR = 0.85d;
    private static final int MAX_DATA_SPECS = 10;
    private final Clock clock;
    private long estimateUs;
    private final LinkedHashMap<DataSpec, Long> initializedDataSpecs;
    private final double smoothingFactor;

    public ExponentialWeightedAverageTimeToFirstByteEstimator() {
        this(0.85d, Clock.DEFAULT);
    }

    public ExponentialWeightedAverageTimeToFirstByteEstimator(double d) {
        this(d, Clock.DEFAULT);
    }

    ExponentialWeightedAverageTimeToFirstByteEstimator(double d, Clock clock2) {
        this.smoothingFactor = d;
        this.clock = clock2;
        this.initializedDataSpecs = new FixedSizeLinkedHashMap(10);
        this.estimateUs = -9223372036854775807L;
    }

    public long getTimeToFirstByteEstimateUs() {
        return this.estimateUs;
    }

    public void reset() {
        this.estimateUs = -9223372036854775807L;
    }

    public void onTransferInitializing(DataSpec dataSpec) {
        this.initializedDataSpecs.remove(dataSpec);
        this.initializedDataSpecs.put(dataSpec, Long.valueOf(Util.msToUs(this.clock.elapsedRealtime())));
    }

    public void onTransferStart(DataSpec dataSpec) {
        Long l = (Long) this.initializedDataSpecs.remove(dataSpec);
        if (l != null) {
            long msToUs = Util.msToUs(this.clock.elapsedRealtime()) - l.longValue();
            long j = this.estimateUs;
            if (j == -9223372036854775807L) {
                this.estimateUs = msToUs;
                return;
            }
            double d = this.smoothingFactor;
            double d2 = (double) j;
            Double.isNaN(d2);
            double d3 = (double) msToUs;
            Double.isNaN(d3);
            this.estimateUs = (long) ((d2 * d) + ((1.0d - d) * d3));
        }
    }

    private static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int maxSize;

        public FixedSizeLinkedHashMap(int i) {
            this.maxSize = i;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.maxSize;
        }
    }
}
