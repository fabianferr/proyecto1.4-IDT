package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class RtspSessionTiming {
    public static final RtspSessionTiming DEFAULT = new RtspSessionTiming(0, -9223372036854775807L);
    private static final long LIVE_START_TIME = 0;
    private static final Pattern NPT_RANGE_PATTERN = Pattern.compile("npt=([.\\d]+|now)\\s?-\\s?([.\\d]+)?");
    private static final String START_TIMING_NTP_FORMAT = "npt=%.3f-";
    public final long startTimeMs;
    public final long stopTimeMs;

    public static RtspSessionTiming parseTiming(String str) throws ParserException {
        long j;
        long j2;
        Matcher matcher = NPT_RANGE_PATTERN.matcher(str);
        Assertions.checkArgument(matcher.matches());
        boolean z = true;
        String str2 = (String) Assertions.checkNotNull(matcher.group(1));
        if (str2.equals("now")) {
            j = 0;
        } else {
            j = (long) (Float.parseFloat(str2) * 1000.0f);
        }
        String group = matcher.group(2);
        if (group != null) {
            try {
                j2 = (long) (Float.parseFloat(group) * 1000.0f);
                if (j2 <= j) {
                    z = false;
                }
                Assertions.checkArgument(z);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(group, e);
            }
        } else {
            j2 = -9223372036854775807L;
        }
        return new RtspSessionTiming(j, j2);
    }

    public static String getOffsetStartTimeTiming(long j) {
        double d = (double) j;
        Double.isNaN(d);
        return Util.formatInvariant(START_TIMING_NTP_FORMAT, Double.valueOf(d / 1000.0d));
    }

    private RtspSessionTiming(long j, long j2) {
        this.startTimeMs = j;
        this.stopTimeMs = j2;
    }

    public boolean isLive() {
        return this.stopTimeMs == -9223372036854775807L;
    }

    public long getDurationMs() {
        return this.stopTimeMs - this.startTimeMs;
    }
}
