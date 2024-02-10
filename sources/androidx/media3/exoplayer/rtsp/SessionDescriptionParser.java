package androidx.media3.exoplayer.rtsp;

import androidx.media3.common.ParserException;
import androidx.media3.common.util.Assertions;
import androidx.media3.exoplayer.rtsp.MediaDescription;
import androidx.media3.exoplayer.rtsp.SessionDescription;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SessionDescriptionParser {
    private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::(.*))?");
    private static final String ATTRIBUTE_TYPE = "a";
    private static final String BANDWIDTH_TYPE = "b";
    private static final String CONNECTION_TYPE = "c";
    private static final String EMAIL_TYPE = "e";
    private static final String INFORMATION_TYPE = "i";
    private static final String KEY_TYPE = "k";
    private static final Pattern MEDIA_DESCRIPTION_PATTERN = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");
    private static final String MEDIA_TYPE = "m";
    private static final String ORIGIN_TYPE = "o";
    private static final String PHONE_NUMBER_TYPE = "p";
    private static final String REPEAT_TYPE = "r";
    private static final Pattern SDP_LINE_PATTERN = Pattern.compile("([a-z])=\\s?(.+)");
    private static final String SESSION_TYPE = "s";
    private static final String TIMING_TYPE = "t";
    private static final String URI_TYPE = "u";
    private static final String VERSION_TYPE = "v";
    private static final String ZONE_TYPE = "z";

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x01b3, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.media3.exoplayer.rtsp.SessionDescription parse(java.lang.String r12) throws androidx.media3.common.ParserException {
        /*
            androidx.media3.exoplayer.rtsp.SessionDescription$Builder r0 = new androidx.media3.exoplayer.rtsp.SessionDescription$Builder
            r0.<init>()
            java.lang.String[] r12 = androidx.media3.exoplayer.rtsp.RtspMessageUtil.splitRtspMessageBody(r12)
            int r1 = r12.length
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x01ca
            r6 = r12[r4]
            java.lang.String r7 = ""
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x001c
            goto L_0x01b3
        L_0x001c:
            java.util.regex.Pattern r7 = SDP_LINE_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r8 = r7.matches()
            if (r8 == 0) goto L_0x01b7
            r8 = 1
            java.lang.String r9 = r7.group(r8)
            java.lang.Object r9 = androidx.media3.common.util.Assertions.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            java.lang.String r7 = r7.group(r10)
            java.lang.Object r7 = androidx.media3.common.util.Assertions.checkNotNull(r7)
            java.lang.String r7 = (java.lang.String) r7
            int r11 = r9.hashCode()
            switch(r11) {
                case 97: goto L_0x00e2;
                case 98: goto L_0x00d7;
                case 99: goto L_0x00cd;
                case 100: goto L_0x0045;
                case 101: goto L_0x00c3;
                case 102: goto L_0x0045;
                case 103: goto L_0x0045;
                case 104: goto L_0x0045;
                case 105: goto L_0x00b9;
                case 106: goto L_0x0045;
                case 107: goto L_0x00ae;
                case 108: goto L_0x0045;
                case 109: goto L_0x00a3;
                case 110: goto L_0x0045;
                case 111: goto L_0x0099;
                case 112: goto L_0x008f;
                case 113: goto L_0x0045;
                case 114: goto L_0x0084;
                case 115: goto L_0x0079;
                case 116: goto L_0x006c;
                case 117: goto L_0x0060;
                case 118: goto L_0x0054;
                case 119: goto L_0x0045;
                case 120: goto L_0x0045;
                case 121: goto L_0x0045;
                case 122: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x00ed
        L_0x0047:
            java.lang.String r11 = "z"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 14
            goto L_0x00ee
        L_0x0054:
            java.lang.String r11 = "v"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 0
            goto L_0x00ee
        L_0x0060:
            java.lang.String r11 = "u"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 4
            goto L_0x00ee
        L_0x006c:
            java.lang.String r11 = "t"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 9
            goto L_0x00ee
        L_0x0079:
            java.lang.String r11 = "s"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 2
            goto L_0x00ee
        L_0x0084:
            java.lang.String r11 = "r"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 13
            goto L_0x00ee
        L_0x008f:
            java.lang.String r11 = "p"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 6
            goto L_0x00ee
        L_0x0099:
            java.lang.String r11 = "o"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 1
            goto L_0x00ee
        L_0x00a3:
            java.lang.String r11 = "m"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 12
            goto L_0x00ee
        L_0x00ae:
            java.lang.String r11 = "k"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 10
            goto L_0x00ee
        L_0x00b9:
            java.lang.String r11 = "i"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 3
            goto L_0x00ee
        L_0x00c3:
            java.lang.String r11 = "e"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 5
            goto L_0x00ee
        L_0x00cd:
            java.lang.String r11 = "c"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 7
            goto L_0x00ee
        L_0x00d7:
            java.lang.String r11 = "b"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 8
            goto L_0x00ee
        L_0x00e2:
            java.lang.String r11 = "a"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x00ed
            r9 = 11
            goto L_0x00ee
        L_0x00ed:
            r9 = -1
        L_0x00ee:
            switch(r9) {
                case 0: goto L_0x019b;
                case 1: goto L_0x0197;
                case 2: goto L_0x0193;
                case 3: goto L_0x0189;
                case 4: goto L_0x0181;
                case 5: goto L_0x017d;
                case 6: goto L_0x0179;
                case 7: goto L_0x016f;
                case 8: goto L_0x014c;
                case 9: goto L_0x0147;
                case 10: goto L_0x013b;
                case 11: goto L_0x00fe;
                case 12: goto L_0x00f3;
                default: goto L_0x00f1;
            }
        L_0x00f1:
            goto L_0x01b3
        L_0x00f3:
            if (r5 == 0) goto L_0x00f8
            addMediaDescriptionToSession(r0, r5)
        L_0x00f8:
            androidx.media3.exoplayer.rtsp.MediaDescription$Builder r5 = parseMediaDescriptionLine(r7)
            goto L_0x01b3
        L_0x00fe:
            java.util.regex.Pattern r9 = ATTRIBUTE_PATTERN
            java.util.regex.Matcher r7 = r9.matcher(r7)
            boolean r9 = r7.matches()
            if (r9 == 0) goto L_0x0128
            java.lang.String r6 = r7.group(r8)
            java.lang.Object r6 = androidx.media3.common.util.Assertions.checkNotNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r7.group(r10)
            java.lang.String r7 = com.google.common.base.Strings.nullToEmpty(r7)
            if (r5 != 0) goto L_0x0123
            r0.addAttribute(r6, r7)
            goto L_0x01b3
        L_0x0123:
            r5.addAttribute(r6, r7)
            goto L_0x01b3
        L_0x0128:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Malformed Attribute line: "
            r12.<init>(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x013b:
            if (r5 != 0) goto L_0x0142
            r0.setKey(r7)
            goto L_0x01b3
        L_0x0142:
            r5.setKey(r7)
            goto L_0x01b3
        L_0x0147:
            r0.setTiming(r7)
            goto L_0x01b3
        L_0x014c:
            java.lang.String r6 = ":\\s?"
            java.lang.String[] r6 = androidx.media3.common.util.Util.split(r7, r6)
            int r7 = r6.length
            if (r7 != r10) goto L_0x0157
            r7 = 1
            goto L_0x0158
        L_0x0157:
            r7 = 0
        L_0x0158:
            androidx.media3.common.util.Assertions.checkArgument(r7)
            r6 = r6[r8]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r5 != 0) goto L_0x0169
            int r6 = r6 * 1000
            r0.setBitrate(r6)
            goto L_0x01b3
        L_0x0169:
            int r6 = r6 * 1000
            r5.setBitrate(r6)
            goto L_0x01b3
        L_0x016f:
            if (r5 != 0) goto L_0x0175
            r0.setConnection(r7)
            goto L_0x01b3
        L_0x0175:
            r5.setConnection(r7)
            goto L_0x01b3
        L_0x0179:
            r0.setPhoneNumber(r7)
            goto L_0x01b3
        L_0x017d:
            r0.setEmailAddress(r7)
            goto L_0x01b3
        L_0x0181:
            android.net.Uri r6 = android.net.Uri.parse(r7)
            r0.setUri(r6)
            goto L_0x01b3
        L_0x0189:
            if (r5 != 0) goto L_0x018f
            r0.setSessionInfo(r7)
            goto L_0x01b3
        L_0x018f:
            r5.setMediaTitle(r7)
            goto L_0x01b3
        L_0x0193:
            r0.setSessionName(r7)
            goto L_0x01b3
        L_0x0197:
            r0.setOrigin(r7)
            goto L_0x01b3
        L_0x019b:
            java.lang.String r6 = "0"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01a4
            goto L_0x01b3
        L_0x01a4:
            java.lang.Object[] r12 = new java.lang.Object[r8]
            r12[r3] = r7
            java.lang.String r0 = "SDP version %s is not supported."
            java.lang.String r12 = java.lang.String.format(r0, r12)
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x01b3:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x01b7:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r0 = "Malformed SDP line: "
            r12.<init>(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x01ca:
            if (r5 == 0) goto L_0x01cf
            addMediaDescriptionToSession(r0, r5)
        L_0x01cf:
            androidx.media3.exoplayer.rtsp.SessionDescription r12 = r0.build()     // Catch:{ IllegalArgumentException -> 0x01d6, IllegalStateException -> 0x01d4 }
            return r12
        L_0x01d4:
            r12 = move-exception
            goto L_0x01d7
        L_0x01d6:
            r12 = move-exception
        L_0x01d7:
            androidx.media3.common.ParserException r12 = androidx.media3.common.ParserException.createForMalformedManifest(r2, r12)
            goto L_0x01dd
        L_0x01dc:
            throw r12
        L_0x01dd:
            goto L_0x01dc
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.rtsp.SessionDescriptionParser.parse(java.lang.String):androidx.media3.exoplayer.rtsp.SessionDescription");
    }

    private static void addMediaDescriptionToSession(SessionDescription.Builder builder, MediaDescription.Builder builder2) throws ParserException {
        try {
            builder.addMediaDescription(builder2.build());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw ParserException.createForMalformedManifest((String) null, e);
        }
    }

    private static MediaDescription.Builder parseMediaDescriptionLine(String str) throws ParserException {
        Matcher matcher = MEDIA_DESCRIPTION_PATTERN.matcher(str);
        if (matcher.matches()) {
            String str2 = (String) Assertions.checkNotNull(matcher.group(1));
            String str3 = (String) Assertions.checkNotNull(matcher.group(2));
            try {
                return new MediaDescription.Builder(str2, Integer.parseInt(str3), (String) Assertions.checkNotNull(matcher.group(3)), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(4))));
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, e);
            }
        } else {
            throw ParserException.createForMalformedManifest("Malformed SDP media description line: " + str, (Throwable) null);
        }
    }

    private SessionDescriptionParser() {
    }
}
