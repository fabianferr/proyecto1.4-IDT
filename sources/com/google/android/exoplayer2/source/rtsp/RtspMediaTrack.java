package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

final class RtspMediaTrack {
    private static final String AAC_CODECS_PREFIX = "mp4a.40.";
    private static final String GENERIC_CONTROL_ATTR = "*";
    private static final String H264_CODECS_PREFIX = "avc1.";
    private static final String PARAMETER_PROFILE_LEVEL_ID = "profile-level-id";
    private static final String PARAMETER_SPROP_PARAMS = "sprop-parameter-sets";
    public final RtpPayloadFormat payloadFormat;
    public final Uri uri;

    public RtspMediaTrack(MediaDescription mediaDescription, Uri uri2) {
        Assertions.checkArgument(mediaDescription.attributes.containsKey("control"));
        this.payloadFormat = generatePayloadFormat(mediaDescription);
        this.uri = extractTrackUri(uri2, (String) Util.castNonNull(mediaDescription.attributes.get("control")));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtspMediaTrack rtspMediaTrack = (RtspMediaTrack) obj;
        if (!this.payloadFormat.equals(rtspMediaTrack.payloadFormat) || !this.uri.equals(rtspMediaTrack.uri)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((217 + this.payloadFormat.hashCode()) * 31) + this.uri.hashCode();
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat generatePayloadFormat(com.google.android.exoplayer2.source.rtsp.MediaDescription r10) {
        /*
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            int r1 = r10.bitrate
            if (r1 <= 0) goto L_0x000e
            int r1 = r10.bitrate
            r0.setAverageBitrate(r1)
        L_0x000e:
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r1 = r10.rtpMapAttribute
            int r1 = r1.payloadType
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r2 = r10.rtpMapAttribute
            java.lang.String r2 = r2.mediaEncoding
            java.lang.String r2 = com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat.getMimeTypeFromRtpMediaType(r2)
            r0.setSampleMimeType(r2)
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r3 = r10.rtpMapAttribute
            int r3 = r3.clockRate
            java.lang.String r4 = "audio"
            java.lang.String r5 = r10.mediaType
            boolean r4 = r4.equals(r5)
            r5 = -1
            if (r4 == 0) goto L_0x003c
            com.google.android.exoplayer2.source.rtsp.MediaDescription$RtpMapAttribute r4 = r10.rtpMapAttribute
            int r4 = r4.encodingParameters
            int r4 = inferChannelCount(r4, r2)
            com.google.android.exoplayer2.Format$Builder r6 = r0.setSampleRate(r3)
            r6.setChannelCount(r4)
            goto L_0x003d
        L_0x003c:
            r4 = -1
        L_0x003d:
            com.google.common.collect.ImmutableMap r10 = r10.getFmtpParametersAsMap()
            int r6 = r2.hashCode()
            r7 = -53558318(0xfffffffffccec3d2, float:-8.588679E36)
            r8 = 0
            r9 = 1
            if (r6 == r7) goto L_0x006b
            r7 = 187078296(0xb269698, float:3.208373E-32)
            if (r6 == r7) goto L_0x0061
            r7 = 1331836730(0x4f62373a, float:3.79527014E9)
            if (r6 == r7) goto L_0x0057
            goto L_0x0075
        L_0x0057:
            java.lang.String r6 = "video/avc"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0075
            r2 = 1
            goto L_0x0076
        L_0x0061:
            java.lang.String r6 = "audio/ac3"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0075
            r2 = 2
            goto L_0x0076
        L_0x006b:
            java.lang.String r6 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0075
            r2 = 0
            goto L_0x0076
        L_0x0075:
            r2 = -1
        L_0x0076:
            if (r2 == 0) goto L_0x0087
            if (r2 == r9) goto L_0x007b
            goto L_0x009a
        L_0x007b:
            boolean r2 = r10.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processH264FmtpAttribute(r0, r10)
            goto L_0x009a
        L_0x0087:
            if (r4 == r5) goto L_0x008b
            r2 = 1
            goto L_0x008c
        L_0x008b:
            r2 = 0
        L_0x008c:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            boolean r2 = r10.isEmpty()
            r2 = r2 ^ r9
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            processAacFmtpAttribute(r0, r10, r4, r3)
        L_0x009a:
            if (r3 <= 0) goto L_0x009e
            r2 = 1
            goto L_0x009f
        L_0x009e:
            r2 = 0
        L_0x009f:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r2)
            r2 = 96
            if (r1 < r2) goto L_0x00a7
            r8 = 1
        L_0x00a7:
            com.google.android.exoplayer2.util.Assertions.checkArgument(r8)
            com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat r2 = new com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat
            com.google.android.exoplayer2.Format r0 = r0.build()
            r2.<init>(r0, r1, r3, r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.rtsp.RtspMediaTrack.generatePayloadFormat(com.google.android.exoplayer2.source.rtsp.MediaDescription):com.google.android.exoplayer2.source.rtsp.RtpPayloadFormat");
    }

    private static int inferChannelCount(int i, String str) {
        if (i != -1) {
            return i;
        }
        return str.equals("audio/ac3") ? 6 : 1;
    }

    private static void processAacFmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap, int i, int i2) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_PROFILE_LEVEL_ID));
        String valueOf = String.valueOf((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_PROFILE_LEVEL_ID)));
        builder.setCodecs(valueOf.length() != 0 ? AAC_CODECS_PREFIX.concat(valueOf) : new String(AAC_CODECS_PREFIX));
        builder.setInitializationData(ImmutableList.of(AacUtil.buildAacLcAudioSpecificConfig(i2, i)));
    }

    private static void processH264FmtpAttribute(Format.Builder builder, ImmutableMap<String, String> immutableMap) {
        Assertions.checkArgument(immutableMap.containsKey(PARAMETER_SPROP_PARAMS));
        String[] split = Util.split((String) Assertions.checkNotNull(immutableMap.get(PARAMETER_SPROP_PARAMS)), ",");
        Assertions.checkArgument(split.length == 2);
        ImmutableList of = ImmutableList.of(getH264InitializationDataFromParameterSet(split[0]), getH264InitializationDataFromParameterSet(split[1]));
        builder.setInitializationData(of);
        byte[] bArr = (byte[]) of.get(0);
        NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(bArr, NalUnitUtil.NAL_START_CODE.length, bArr.length);
        builder.setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthAspectRatio);
        builder.setHeight(parseSpsNalUnit.height);
        builder.setWidth(parseSpsNalUnit.width);
        String str = immutableMap.get(PARAMETER_PROFILE_LEVEL_ID);
        if (str != null) {
            String valueOf = String.valueOf(str);
            builder.setCodecs(valueOf.length() != 0 ? H264_CODECS_PREFIX.concat(valueOf) : new String(H264_CODECS_PREFIX));
            return;
        }
        builder.setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc));
    }

    private static byte[] getH264InitializationDataFromParameterSet(String str) {
        byte[] decode = Base64.decode(str, 0);
        byte[] bArr = new byte[(decode.length + NalUnitUtil.NAL_START_CODE.length)];
        System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, 0, NalUnitUtil.NAL_START_CODE.length);
        System.arraycopy(decode, 0, bArr, NalUnitUtil.NAL_START_CODE.length, decode.length);
        return bArr;
    }

    private static Uri extractTrackUri(Uri uri2, String str) {
        Uri parse = Uri.parse(str);
        if (parse.isAbsolute()) {
            return parse;
        }
        if (str.equals("*")) {
            return uri2;
        }
        return uri2.buildUpon().appendEncodedPath(str).build();
    }
}
