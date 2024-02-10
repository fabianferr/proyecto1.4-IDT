package androidx.media3.common.util;

public final class TimestampAdjuster {
    private static final long MAX_PTS_PLUS_ONE = 8589934592L;
    public static final long MODE_NO_OFFSET = Long.MAX_VALUE;
    public static final long MODE_SHARED = 9223372036854775806L;
    private long firstSampleTimestampUs;
    private long lastUnadjustedTimestampUs;
    private final ThreadLocal<Long> nextSampleTimestampUs = new ThreadLocal<>();
    private long timestampOffsetUs;

    public TimestampAdjuster(long j) {
        reset(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sharedInitializeOrWait(boolean r9, long r10, long r12) throws java.lang.InterruptedException, java.util.concurrent.TimeoutException {
        /*
            r8 = this;
            monitor-enter(r8)
            long r0 = r8.firstSampleTimestampUs     // Catch:{ all -> 0x007d }
            r2 = 9223372036854775806(0x7ffffffffffffffe, double:NaN)
            r4 = 1
            r5 = 0
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            androidx.media3.common.util.Assertions.checkState(r0)     // Catch:{ all -> 0x007d }
            boolean r0 = r8.isInitialized()     // Catch:{ all -> 0x007d }
            if (r0 == 0) goto L_0x001c
            monitor-exit(r8)
            return
        L_0x001c:
            if (r9 == 0) goto L_0x0028
            java.lang.ThreadLocal<java.lang.Long> r9 = r8.nextSampleTimestampUs     // Catch:{ all -> 0x007d }
            java.lang.Long r10 = java.lang.Long.valueOf(r10)     // Catch:{ all -> 0x007d }
            r9.set(r10)     // Catch:{ all -> 0x007d }
            goto L_0x007b
        L_0x0028:
            r9 = 0
            r2 = r9
            r0 = r12
        L_0x002c:
            boolean r11 = r8.isInitialized()     // Catch:{ all -> 0x007d }
            if (r11 != 0) goto L_0x007b
            int r11 = (r12 > r9 ? 1 : (r12 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x003a
            r8.wait()     // Catch:{ all -> 0x007d }
            goto L_0x002c
        L_0x003a:
            int r11 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1))
            if (r11 <= 0) goto L_0x0040
            r11 = 1
            goto L_0x0041
        L_0x0040:
            r11 = 0
        L_0x0041:
            androidx.media3.common.util.Assertions.checkState(r11)     // Catch:{ all -> 0x007d }
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007d }
            r8.wait(r0)     // Catch:{ all -> 0x007d }
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x007d }
            long r0 = r0 - r6
            long r2 = r2 + r0
            int r11 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r11 < 0) goto L_0x0078
            boolean r11 = r8.isInitialized()     // Catch:{ all -> 0x007d }
            if (r11 == 0) goto L_0x005c
            goto L_0x0078
        L_0x005c:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r9.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r10 = "TimestampAdjuster failed to initialize in "
            r9.append(r10)     // Catch:{ all -> 0x007d }
            r9.append(r12)     // Catch:{ all -> 0x007d }
            java.lang.String r10 = " milliseconds"
            r9.append(r10)     // Catch:{ all -> 0x007d }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x007d }
            java.util.concurrent.TimeoutException r10 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x007d }
            r10.<init>(r9)     // Catch:{ all -> 0x007d }
            throw r10     // Catch:{ all -> 0x007d }
        L_0x0078:
            long r0 = r12 - r2
            goto L_0x002c
        L_0x007b:
            monitor-exit(r8)
            return
        L_0x007d:
            r9 = move-exception
            monitor-exit(r8)
            goto L_0x0081
        L_0x0080:
            throw r9
        L_0x0081:
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.util.TimestampAdjuster.sharedInitializeOrWait(boolean, long, long):void");
    }

    public synchronized long getFirstSampleTimestampUs() {
        long j;
        j = this.firstSampleTimestampUs;
        if (j == Long.MAX_VALUE || j == 9223372036854775806L) {
            j = -9223372036854775807L;
        }
        return j;
    }

    public synchronized long getLastAdjustedTimestampUs() {
        long j;
        long j2 = this.lastUnadjustedTimestampUs;
        if (j2 != -9223372036854775807L) {
            j = j2 + this.timestampOffsetUs;
        } else {
            j = getFirstSampleTimestampUs();
        }
        return j;
    }

    public synchronized long getTimestampOffsetUs() {
        return this.timestampOffsetUs;
    }

    public synchronized void reset(long j) {
        this.firstSampleTimestampUs = j;
        this.timestampOffsetUs = j == Long.MAX_VALUE ? 0 : -9223372036854775807L;
        this.lastUnadjustedTimestampUs = -9223372036854775807L;
    }

    public synchronized long adjustTsTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.lastUnadjustedTimestampUs;
        if (j2 != -9223372036854775807L) {
            long usToNonWrappedPts = usToNonWrappedPts(j2);
            long j3 = (4294967296L + usToNonWrappedPts) / MAX_PTS_PLUS_ONE;
            long j4 = ((j3 - 1) * MAX_PTS_PLUS_ONE) + j;
            j += j3 * MAX_PTS_PLUS_ONE;
            if (Math.abs(j4 - usToNonWrappedPts) < Math.abs(j - usToNonWrappedPts)) {
                j = j4;
            }
        }
        return adjustSampleTimestamp(ptsToUs(j));
    }

    public synchronized long adjustSampleTimestamp(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        if (!isInitialized()) {
            long j2 = this.firstSampleTimestampUs;
            if (j2 == 9223372036854775806L) {
                j2 = ((Long) Assertions.checkNotNull(this.nextSampleTimestampUs.get())).longValue();
            }
            this.timestampOffsetUs = j2 - j;
            notifyAll();
        }
        this.lastUnadjustedTimestampUs = j;
        return j + this.timestampOffsetUs;
    }

    public synchronized boolean isInitialized() {
        return this.timestampOffsetUs != -9223372036854775807L;
    }

    public static long ptsToUs(long j) {
        return (j * 1000000) / 90000;
    }

    public static long usToWrappedPts(long j) {
        return usToNonWrappedPts(j) % MAX_PTS_PLUS_ONE;
    }

    public static long usToNonWrappedPts(long j) {
        return (j * 90000) / 1000000;
    }
}
