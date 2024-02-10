package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.rtsp.MediaDescription;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.google.android.exoplayer2.util.Assertions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class SessionDescriptionParser {
    private static final Pattern ATTRIBUTE_PATTERN = Pattern.compile("([0-9A-Za-z-]+)(?::(.*))?");
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
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01d2, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.source.rtsp.SessionDescription parse(java.lang.String r12) throws com.google.android.exoplayer2.ParserException {
        /*
            com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder r0 = new com.google.android.exoplayer2.source.rtsp.SessionDescription$Builder
            r0.<init>()
            java.lang.String[] r12 = com.google.android.exoplayer2.source.rtsp.RtspMessageUtil.splitRtspMessageBody(r12)
            int r1 = r12.length
            r2 = 0
            r3 = 0
            r5 = r2
            r4 = 0
        L_0x000e:
            if (r4 >= r1) goto L_0x01d6
            r6 = r12[r4]
            java.lang.String r7 = ""
            boolean r7 = r7.equals(r6)
            if (r7 == 0) goto L_0x001c
            goto L_0x01d2
        L_0x001c:
            java.util.regex.Pattern r7 = SDP_LINE_PATTERN
            java.util.regex.Matcher r7 = r7.matcher(r6)
            boolean r8 = r7.matches()
            if (r8 != 0) goto L_0x0043
            java.lang.String r12 = java.lang.String.valueOf(r6)
            int r0 = r12.length()
            java.lang.String r1 = "Malformed SDP line: "
            if (r0 == 0) goto L_0x0039
            java.lang.String r12 = r1.concat(r12)
            goto L_0x003e
        L_0x0039:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r1)
        L_0x003e:
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x0043:
            r8 = 1
            java.lang.String r9 = r7.group(r8)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r10 = 2
            java.lang.String r7 = r7.group(r10)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            java.lang.String r7 = (java.lang.String) r7
            int r11 = r9.hashCode()
            switch(r11) {
                case 97: goto L_0x00f9;
                case 98: goto L_0x00ee;
                case 99: goto L_0x00e4;
                case 100: goto L_0x0060;
                case 101: goto L_0x00da;
                case 102: goto L_0x0060;
                case 103: goto L_0x0060;
                case 104: goto L_0x0060;
                case 105: goto L_0x00d0;
                case 106: goto L_0x0060;
                case 107: goto L_0x00c5;
                case 108: goto L_0x0060;
                case 109: goto L_0x00ba;
                case 110: goto L_0x0060;
                case 111: goto L_0x00b0;
                case 112: goto L_0x00a6;
                case 113: goto L_0x0060;
                case 114: goto L_0x009b;
                case 115: goto L_0x0090;
                case 116: goto L_0x0084;
                case 117: goto L_0x0079;
                case 118: goto L_0x006e;
                case 119: goto L_0x0060;
                case 120: goto L_0x0060;
                case 121: goto L_0x0060;
                case 122: goto L_0x0062;
                default: goto L_0x0060;
            }
        L_0x0060:
            goto L_0x0104
        L_0x0062:
            java.lang.String r11 = "z"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 14
            goto L_0x0105
        L_0x006e:
            java.lang.String r11 = "v"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 0
            goto L_0x0105
        L_0x0079:
            java.lang.String r11 = "u"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 4
            goto L_0x0105
        L_0x0084:
            java.lang.String r11 = "t"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 9
            goto L_0x0105
        L_0x0090:
            java.lang.String r11 = "s"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 2
            goto L_0x0105
        L_0x009b:
            java.lang.String r11 = "r"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 13
            goto L_0x0105
        L_0x00a6:
            java.lang.String r11 = "p"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 6
            goto L_0x0105
        L_0x00b0:
            java.lang.String r11 = "o"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 1
            goto L_0x0105
        L_0x00ba:
            java.lang.String r11 = "m"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 12
            goto L_0x0105
        L_0x00c5:
            java.lang.String r11 = "k"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 10
            goto L_0x0105
        L_0x00d0:
            java.lang.String r11 = "i"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 3
            goto L_0x0105
        L_0x00da:
            java.lang.String r11 = "e"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 5
            goto L_0x0105
        L_0x00e4:
            java.lang.String r11 = "c"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 7
            goto L_0x0105
        L_0x00ee:
            java.lang.String r11 = "b"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 8
            goto L_0x0105
        L_0x00f9:
            java.lang.String r11 = "a"
            boolean r9 = r9.equals(r11)
            if (r9 == 0) goto L_0x0104
            r9 = 11
            goto L_0x0105
        L_0x0104:
            r9 = -1
        L_0x0105:
            switch(r9) {
                case 0: goto L_0x01ba;
                case 1: goto L_0x01b6;
                case 2: goto L_0x01b2;
                case 3: goto L_0x01a8;
                case 4: goto L_0x01a0;
                case 5: goto L_0x019c;
                case 6: goto L_0x0198;
                case 7: goto L_0x018e;
                case 8: goto L_0x016b;
                case 9: goto L_0x0166;
                case 10: goto L_0x015a;
                case 11: goto L_0x0115;
                case 12: goto L_0x010a;
                default: goto L_0x0108;
            }
        L_0x0108:
            goto L_0x01d2
        L_0x010a:
            if (r5 == 0) goto L_0x010f
            addMediaDescriptionToSession(r0, r5)
        L_0x010f:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$Builder r5 = parseMediaDescriptionLine(r7)
            goto L_0x01d2
        L_0x0115:
            java.util.regex.Pattern r9 = ATTRIBUTE_PATTERN
            java.util.regex.Matcher r7 = r9.matcher(r7)
            boolean r9 = r7.matches()
            if (r9 != 0) goto L_0x013c
            java.lang.String r12 = java.lang.String.valueOf(r6)
            int r0 = r12.length()
            java.lang.String r1 = "Malformed Attribute line: "
            if (r0 == 0) goto L_0x0132
            java.lang.String r12 = r1.concat(r12)
            goto L_0x0137
        L_0x0132:
            java.lang.String r12 = new java.lang.String
            r12.<init>(r1)
        L_0x0137:
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x013c:
            java.lang.String r6 = r7.group(r8)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            java.lang.String r6 = (java.lang.String) r6
            java.lang.String r7 = r7.group(r10)
            java.lang.String r7 = com.google.common.base.Strings.nullToEmpty(r7)
            if (r5 != 0) goto L_0x0155
            r0.addAttribute(r6, r7)
            goto L_0x01d2
        L_0x0155:
            r5.addAttribute(r6, r7)
            goto L_0x01d2
        L_0x015a:
            if (r5 != 0) goto L_0x0161
            r0.setKey(r7)
            goto L_0x01d2
        L_0x0161:
            r5.setKey(r7)
            goto L_0x01d2
        L_0x0166:
            r0.setTiming(r7)
            goto L_0x01d2
        L_0x016b:
            java.lang.String r6 = ":\\s?"
            java.lang.String[] r6 = com.google.android.exoplayer2.util.Util.split(r7, r6)
            int r7 = r6.length
            if (r7 != r10) goto L_0x0176
            r7 = 1
            goto L_0x0177
        L_0x0176:
            r7 = 0
        L_0x0177:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r7)
            r6 = r6[r8]
            int r6 = java.lang.Integer.parseInt(r6)
            if (r5 != 0) goto L_0x0188
            int r6 = r6 * 1000
            r0.setBitrate(r6)
            goto L_0x01d2
        L_0x0188:
            int r6 = r6 * 1000
            r5.setBitrate(r6)
            goto L_0x01d2
        L_0x018e:
            if (r5 != 0) goto L_0x0194
            r0.setConnection(r7)
            goto L_0x01d2
        L_0x0194:
            r5.setConnection(r7)
            goto L_0x01d2
        L_0x0198:
            r0.setPhoneNumber(r7)
            goto L_0x01d2
        L_0x019c:
            r0.setEmailAddress(r7)
            goto L_0x01d2
        L_0x01a0:
            android.net.Uri r6 = android.net.Uri.parse(r7)
            r0.setUri(r6)
            goto L_0x01d2
        L_0x01a8:
            if (r5 != 0) goto L_0x01ae
            r0.setSessionInfo(r7)
            goto L_0x01d2
        L_0x01ae:
            r5.setMediaTitle(r7)
            goto L_0x01d2
        L_0x01b2:
            r0.setSessionName(r7)
            goto L_0x01d2
        L_0x01b6:
            r0.setOrigin(r7)
            goto L_0x01d2
        L_0x01ba:
            java.lang.String r6 = "0"
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x01c3
            goto L_0x01d2
        L_0x01c3:
            java.lang.Object[] r12 = new java.lang.Object[r8]
            r12[r3] = r7
            java.lang.String r0 = "SDP version %s is not supported."
            java.lang.String r12 = java.lang.String.format(r0, r12)
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r12, r2)
            throw r12
        L_0x01d2:
            int r4 = r4 + 1
            goto L_0x000e
        L_0x01d6:
            if (r5 == 0) goto L_0x01db
            addMediaDescriptionToSession(r0, r5)
        L_0x01db:
            com.google.android.exoplayer2.source.rtsp.SessionDescription r12 = r0.build()     // Catch:{ IllegalArgumentException -> 0x01e2, IllegalStateException -> 0x01e0 }
            return r12
        L_0x01e0:
            r12 = move-exception
            goto L_0x01e3
        L_0x01e2:
            r12 = move-exception
        L_0x01e3:
            com.google.android.exoplayer2.ParserException r12 = com.google.android.exoplayer2.ParserException.createForMalformedManifest(r2, r12)
            goto L_0x01e9
        L_0x01e8:
            throw r12
        L_0x01e9:
            goto L_0x01e8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.SessionDescriptionParser.parse(java.lang.String):com.google.android.exoplayer2.source.rtsp.SessionDescription");
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
        if (!matcher.matches()) {
            String valueOf = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf) : new String("Malformed SDP media description line: "), (Throwable) null);
        }
        try {
            return new MediaDescription.Builder((String) Assertions.checkNotNull(matcher.group(1)), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(2))), (String) Assertions.checkNotNull(matcher.group(3)), Integer.parseInt((String) Assertions.checkNotNull(matcher.group(4))));
        } catch (NumberFormatException e) {
            String valueOf2 = String.valueOf(str);
            throw ParserException.createForMalformedManifest(valueOf2.length() != 0 ? "Malformed SDP media description line: ".concat(valueOf2) : new String("Malformed SDP media description line: "), e);
        }
    }

    private SessionDescriptionParser() {
    }
}
