package androidx.media3.exoplayer.upstream.experimental;

public class ExponentialWeightedAverageStatistic implements BandwidthStatistic {
    public static final double DEFAULT_SMOOTHING_FACTOR = 0.9999d;
    private long bitrateEstimate;
    private final double smoothingFactor;

    public ExponentialWeightedAverageStatistic() {
        this(0.9999d);
    }

    public ExponentialWeightedAverageStatistic(double d) {
        this.smoothingFactor = d;
        this.bitrateEstimate = Long.MIN_VALUE;
    }

    public void addSample(long j, long j2) {
        long j3 = (8000000 * j) / j2;
        if (this.bitrateEstimate == Long.MIN_VALUE) {
            this.bitrateEstimate = j3;
            return;
        }
        double pow = Math.pow(this.smoothingFactor, Math.sqrt((double) j));
        double d = (double) this.bitrateEstimate;
        Double.isNaN(d);
        double d2 = d * pow;
        double d3 = 1.0d - pow;
        double d4 = (double) j3;
        Double.isNaN(d4);
        this.bitrateEstimate = (long) (d2 + (d3 * d4));
    }

    public long getBandwidthEstimate() {
        return this.bitrateEstimate;
    }

    public void reset() {
        this.bitrateEstimate = Long.MIN_VALUE;
    }
}
