package com.mbridge.msdk.playercommon.exoplayer2.text.ssa;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.text.Cue;
import com.mbridge.msdk.playercommon.exoplayer2.text.SimpleSubtitleDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.LongArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SsaDecoder extends SimpleSubtitleDecoder {
    private static final String DIALOGUE_LINE_PREFIX = "Dialogue: ";
    private static final String FORMAT_LINE_PREFIX = "Format: ";
    private static final Pattern SSA_TIMECODE_PATTERN = Pattern.compile("(?:(\\d+):)?(\\d+):(\\d+)(?::|\\.)(\\d+)");
    private static final String TAG = "SsaDecoder";
    private int formatEndIndex;
    private int formatKeyCount;
    private int formatStartIndex;
    private int formatTextIndex;
    private final boolean haveInitializationData;

    public SsaDecoder() {
        this((List<byte[]>) null);
    }

    public SsaDecoder(List<byte[]> list) {
        super(TAG);
        if (list == null || list.isEmpty()) {
            this.haveInitializationData = false;
            return;
        }
        this.haveInitializationData = true;
        String fromUtf8Bytes = Util.fromUtf8Bytes(list.get(0));
        Assertions.checkArgument(fromUtf8Bytes.startsWith(FORMAT_LINE_PREFIX));
        parseFormatLine(fromUtf8Bytes);
        parseHeader(new ParsableByteArray(list.get(1)));
    }

    /* access modifiers changed from: protected */
    public final SsaSubtitle decode(byte[] bArr, int i, boolean z) {
        ArrayList arrayList = new ArrayList();
        LongArray longArray = new LongArray();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        if (!this.haveInitializationData) {
            parseHeader(parsableByteArray);
        }
        parseEventBody(parsableByteArray, arrayList, longArray);
        Cue[] cueArr = new Cue[arrayList.size()];
        arrayList.toArray(cueArr);
        return new SsaSubtitle(cueArr, longArray.toArray());
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private void parseHeader(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r3) {
        /*
            r2 = this;
        L_0x0000:
            java.lang.String r0 = r3.readLine()
            if (r0 == 0) goto L_0x000e
            java.lang.String r1 = "[Events]"
            boolean r0 = r0.startsWith(r1)
            if (r0 == 0) goto L_0x0000
        L_0x000e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ssa.SsaDecoder.parseHeader(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray):void");
    }

    private void parseEventBody(ParsableByteArray parsableByteArray, List<Cue> list, LongArray longArray) {
        while (true) {
            String readLine = parsableByteArray.readLine();
            if (readLine == null) {
                return;
            }
            if (!this.haveInitializationData && readLine.startsWith(FORMAT_LINE_PREFIX)) {
                parseFormatLine(readLine);
            } else if (readLine.startsWith(DIALOGUE_LINE_PREFIX)) {
                parseDialogueLine(readLine, list, longArray);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void parseFormatLine(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 8
            java.lang.String r6 = r6.substring(r0)
            java.lang.String r0 = ","
            java.lang.String[] r6 = android.text.TextUtils.split(r6, r0)
            int r0 = r6.length
            r5.formatKeyCount = r0
            r0 = -1
            r5.formatStartIndex = r0
            r5.formatEndIndex = r0
            r5.formatTextIndex = r0
            r1 = 0
            r2 = 0
        L_0x0018:
            int r3 = r5.formatKeyCount
            if (r2 >= r3) goto L_0x0063
            r3 = r6[r2]
            java.lang.String r3 = r3.trim()
            java.lang.String r3 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.toLowerInvariant(r3)
            r3.hashCode()
            int r4 = r3.hashCode()
            switch(r4) {
                case 100571: goto L_0x004a;
                case 3556653: goto L_0x003e;
                case 109757538: goto L_0x0032;
                default: goto L_0x0030;
            }
        L_0x0030:
            r3 = -1
            goto L_0x0054
        L_0x0032:
            java.lang.String r4 = "start"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x003c
            goto L_0x0030
        L_0x003c:
            r3 = 2
            goto L_0x0054
        L_0x003e:
            java.lang.String r4 = "text"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0048
            goto L_0x0030
        L_0x0048:
            r3 = 1
            goto L_0x0054
        L_0x004a:
            java.lang.String r4 = "end"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0053
            goto L_0x0030
        L_0x0053:
            r3 = 0
        L_0x0054:
            switch(r3) {
                case 0: goto L_0x005e;
                case 1: goto L_0x005b;
                case 2: goto L_0x0058;
                default: goto L_0x0057;
            }
        L_0x0057:
            goto L_0x0060
        L_0x0058:
            r5.formatStartIndex = r2
            goto L_0x0060
        L_0x005b:
            r5.formatTextIndex = r2
            goto L_0x0060
        L_0x005e:
            r5.formatEndIndex = r2
        L_0x0060:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0063:
            int r6 = r5.formatStartIndex
            if (r6 == r0) goto L_0x006f
            int r6 = r5.formatEndIndex
            if (r6 == r0) goto L_0x006f
            int r6 = r5.formatTextIndex
            if (r6 != r0) goto L_0x0071
        L_0x006f:
            r5.formatKeyCount = r1
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.text.ssa.SsaDecoder.parseFormatLine(java.lang.String):void");
    }

    private void parseDialogueLine(String str, List<Cue> list, LongArray longArray) {
        long j;
        if (this.formatKeyCount == 0) {
            Log.w(TAG, "Skipping dialogue line before complete format: " + str);
            return;
        }
        String[] split = str.substring(10).split(",", this.formatKeyCount);
        if (split.length != this.formatKeyCount) {
            Log.w(TAG, "Skipping dialogue line with fewer columns than format: " + str);
            return;
        }
        long parseTimecodeUs = parseTimecodeUs(split[this.formatStartIndex]);
        if (parseTimecodeUs == -9223372036854775807L) {
            Log.w(TAG, "Skipping invalid timing: " + str);
            return;
        }
        String str2 = split[this.formatEndIndex];
        if (!str2.trim().isEmpty()) {
            j = parseTimecodeUs(str2);
            if (j == -9223372036854775807L) {
                Log.w(TAG, "Skipping invalid timing: " + str);
                return;
            }
        } else {
            j = -9223372036854775807L;
        }
        list.add(new Cue(split[this.formatTextIndex].replaceAll("\\{.*?\\}", "").replaceAll("\\\\N", "\n").replaceAll("\\\\n", "\n")));
        longArray.add(parseTimecodeUs);
        if (j != -9223372036854775807L) {
            list.add((Object) null);
            longArray.add(j);
        }
    }

    public static long parseTimecodeUs(String str) {
        Matcher matcher = SSA_TIMECODE_PATTERN.matcher(str);
        if (!matcher.matches()) {
            return -9223372036854775807L;
        }
        return (Long.parseLong(matcher.group(1)) * 60 * 60 * 1000000) + (Long.parseLong(matcher.group(2)) * 60 * 1000000) + (Long.parseLong(matcher.group(3)) * 1000000) + (Long.parseLong(matcher.group(4)) * 10000);
    }
}
