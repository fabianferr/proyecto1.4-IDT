package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.Format;
import com.google.common.base.Ascii;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

public final class RtpPayloadFormat {
    private static final String RTP_MEDIA_AC3 = "AC3";
    private static final String RTP_MEDIA_H264 = "H264";
    private static final String RTP_MEDIA_MPEG4_GENERIC = "MPEG4-GENERIC";
    public final int clockRate;
    public final ImmutableMap<String, String> fmtpParameters;
    public final Format format;
    public final int rtpPayloadType;

    public static boolean isFormatSupported(MediaDescription mediaDescription) {
        String upperCase = Ascii.toUpperCase(mediaDescription.rtpMapAttribute.mediaEncoding);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case -1922091719:
                if (upperCase.equals("MPEG4-GENERIC")) {
                    c = 0;
                    break;
                }
                break;
            case 64593:
                if (upperCase.equals("AC3")) {
                    c = 1;
                    break;
                }
                break;
            case 2194728:
                if (upperCase.equals("H264")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public static String getMimeTypeFromRtpMediaType(String str) {
        String upperCase = Ascii.toUpperCase(str);
        upperCase.hashCode();
        char c = 65535;
        switch (upperCase.hashCode()) {
            case -1922091719:
                if (upperCase.equals("MPEG4-GENERIC")) {
                    c = 0;
                    break;
                }
                break;
            case 64593:
                if (upperCase.equals("AC3")) {
                    c = 1;
                    break;
                }
                break;
            case 2194728:
                if (upperCase.equals("H264")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return "audio/mp4a-latm";
            case 1:
                return "audio/ac3";
            case 2:
                return "video/avc";
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public RtpPayloadFormat(Format format2, int i, int i2, Map<String, String> map) {
        this.rtpPayloadType = i;
        this.clockRate = i2;
        this.format = format2;
        this.fmtpParameters = ImmutableMap.copyOf(map);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtpPayloadFormat rtpPayloadFormat = (RtpPayloadFormat) obj;
        if (this.rtpPayloadType != rtpPayloadFormat.rtpPayloadType || this.clockRate != rtpPayloadFormat.clockRate || !this.format.equals(rtpPayloadFormat.format) || !this.fmtpParameters.equals(rtpPayloadFormat.fmtpParameters)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((217 + this.rtpPayloadType) * 31) + this.clockRate) * 31) + this.format.hashCode()) * 31) + this.fmtpParameters.hashCode();
    }
}
