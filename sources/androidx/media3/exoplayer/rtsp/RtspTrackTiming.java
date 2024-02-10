package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UriUtil;

final class RtspTrackTiming {
    public final long rtpTimestamp;
    public final int sequenceNumber;
    public final Uri uri;

    /* JADX WARNING: Removed duplicated region for block: B:24:0x006b A[Catch:{ Exception -> 0x008e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0082 A[Catch:{ Exception -> 0x008e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.common.collect.ImmutableList<androidx.media3.exoplayer.rtsp.RtspTrackTiming> parseTrackTiming(java.lang.String r18, android.net.Uri r19) throws androidx.media3.common.ParserException {
        /*
            com.google.common.collect.ImmutableList$Builder r0 = new com.google.common.collect.ImmutableList$Builder
            r0.<init>()
            java.lang.String r1 = ","
            r2 = r18
            java.lang.String[] r1 = androidx.media3.common.util.Util.split(r2, r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x0010:
            if (r4 >= r2) goto L_0x00c2
            r5 = r1[r4]
            java.lang.String r6 = ";"
            java.lang.String[] r6 = androidx.media3.common.util.Util.split(r5, r6)
            int r7 = r6.length
            r12 = 0
            r13 = 0
            r14 = -1
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0023:
            if (r12 >= r7) goto L_0x0094
            r8 = r6[r12]
            java.lang.String r9 = "="
            java.lang.String[] r9 = androidx.media3.common.util.Util.splitAtFirst(r8, r9)     // Catch:{ Exception -> 0x008e }
            r11 = r9[r3]     // Catch:{ Exception -> 0x008e }
            r3 = 1
            r9 = r9[r3]     // Catch:{ Exception -> 0x008e }
            int r10 = r11.hashCode()     // Catch:{ Exception -> 0x008e }
            r3 = 113759(0x1bc5f, float:1.5941E-40)
            r17 = r1
            r1 = 2
            if (r10 == r3) goto L_0x005e
            r3 = 116079(0x1c56f, float:1.62661E-40)
            if (r10 == r3) goto L_0x0053
            r3 = 1524180539(0x5ad9263b, float:3.05610524E16)
            if (r10 == r3) goto L_0x0049
            goto L_0x0068
        L_0x0049:
            java.lang.String r3 = "rtptime"
            boolean r3 = r11.equals(r3)     // Catch:{ Exception -> 0x008e }
            if (r3 == 0) goto L_0x0068
            r3 = 2
            goto L_0x0069
        L_0x0053:
            java.lang.String r3 = "url"
            boolean r3 = r11.equals(r3)     // Catch:{ Exception -> 0x008e }
            if (r3 == 0) goto L_0x0068
            r3 = 0
            goto L_0x0069
        L_0x005e:
            java.lang.String r3 = "seq"
            boolean r3 = r11.equals(r3)     // Catch:{ Exception -> 0x008e }
            if (r3 == 0) goto L_0x0068
            r3 = 1
            goto L_0x0069
        L_0x0068:
            r3 = -1
        L_0x0069:
            if (r3 == 0) goto L_0x0082
            r10 = 1
            if (r3 == r10) goto L_0x007b
            if (r3 != r1) goto L_0x0075
            long r15 = java.lang.Long.parseLong(r9)     // Catch:{ Exception -> 0x008e }
            goto L_0x007f
        L_0x0075:
            r0 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r11, r0)     // Catch:{ Exception -> 0x008e }
            throw r0     // Catch:{ Exception -> 0x008e }
        L_0x007b:
            int r14 = java.lang.Integer.parseInt(r9)     // Catch:{ Exception -> 0x008e }
        L_0x007f:
            r1 = r19
            goto L_0x0088
        L_0x0082:
            r1 = r19
            android.net.Uri r13 = resolveUri(r9, r1)     // Catch:{ Exception -> 0x008e }
        L_0x0088:
            int r12 = r12 + 1
            r1 = r17
            r3 = 0
            goto L_0x0023
        L_0x008e:
            r0 = move-exception
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r8, r0)
            throw r0
        L_0x0094:
            r17 = r1
            r1 = r19
            if (r13 == 0) goto L_0x00bc
            java.lang.String r3 = r13.getScheme()
            if (r3 == 0) goto L_0x00bc
            r3 = -1
            r8 = r15
            if (r14 != r3) goto L_0x00ad
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x00bc
        L_0x00ad:
            androidx.media3.exoplayer.rtsp.RtspTrackTiming r3 = new androidx.media3.exoplayer.rtsp.RtspTrackTiming
            r3.<init>(r8, r14, r13)
            r0.add((java.lang.Object) r3)
            int r4 = r4 + 1
            r1 = r17
            r3 = 0
            goto L_0x0010
        L_0x00bc:
            r0 = 0
            androidx.media3.common.ParserException r0 = androidx.media3.common.ParserException.createForMalformedManifest(r5, r0)
            throw r0
        L_0x00c2:
            com.google.common.collect.ImmutableList r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.rtsp.RtspTrackTiming.parseTrackTiming(java.lang.String, android.net.Uri):com.google.common.collect.ImmutableList");
    }

    static Uri resolveUri(String str, Uri uri2) {
        Assertions.checkArgument(((String) Assertions.checkNotNull(uri2.getScheme())).equals("rtsp"));
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        Uri parse2 = Uri.parse("rtsp://" + str);
        String uri3 = uri2.toString();
        if (((String) Assertions.checkNotNull(parse2.getHost())).equals(uri2.getHost())) {
            return parse2;
        }
        if (uri3.endsWith("/")) {
            return UriUtil.resolveToUri(uri3, str);
        }
        return UriUtil.resolveToUri(uri3 + "/", str);
    }

    private RtspTrackTiming(long j, int i, Uri uri2) {
        this.rtpTimestamp = j;
        this.sequenceNumber = i;
        this.uri = uri2;
    }
}
