package com.mbridge.msdk.playercommon.exoplayer2.text;

import com.mbridge.msdk.playercommon.exoplayer2.Format;
import com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea608Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.cea.Cea708Decoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.dvb.DvbDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.pgs.PgsDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.ssa.SsaDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.subrip.SubripDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.tx3g.Tx3gDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.webvtt.Mp4WebvttDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.text.webvtt.WebvttDecoder;

public interface SubtitleDecoderFactory {
    public static final SubtitleDecoderFactory DEFAULT = new SubtitleDecoderFactory() {
        public final boolean supportsFormat(Format format) {
            String str = format.sampleMimeType;
            return "text/vtt".equals(str) || "text/x-ssa".equals(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/x-subrip".equals(str) || "application/x-quicktime-tx3g".equals(str) || "application/cea-608".equals(str) || "application/x-mp4-cea-608".equals(str) || "application/cea-708".equals(str) || "application/dvbsubs".equals(str) || "application/pgs".equals(str);
        }

        public final SubtitleDecoder createDecoder(Format format) {
            String str = format.sampleMimeType;
            str.hashCode();
            char c = 65535;
            switch (str.hashCode()) {
                case -1351681404:
                    if (str.equals("application/dvbsubs")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1248334819:
                    if (str.equals("application/pgs")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1026075066:
                    if (str.equals("application/x-mp4-vtt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1004728940:
                    if (str.equals("text/vtt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 691401887:
                    if (str.equals("application/x-quicktime-tx3g")) {
                        c = 4;
                        break;
                    }
                    break;
                case 822864842:
                    if (str.equals("text/x-ssa")) {
                        c = 5;
                        break;
                    }
                    break;
                case 930165504:
                    if (str.equals("application/x-mp4-cea-608")) {
                        c = 6;
                        break;
                    }
                    break;
                case 1566015601:
                    if (str.equals("application/cea-608")) {
                        c = 7;
                        break;
                    }
                    break;
                case 1566016562:
                    if (str.equals("application/cea-708")) {
                        c = 8;
                        break;
                    }
                    break;
                case 1668750253:
                    if (str.equals("application/x-subrip")) {
                        c = 9;
                        break;
                    }
                    break;
                case 1693976202:
                    if (str.equals("application/ttml+xml")) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return new DvbDecoder(format.initializationData);
                case 1:
                    return new PgsDecoder();
                case 2:
                    return new Mp4WebvttDecoder();
                case 3:
                    return new WebvttDecoder();
                case 4:
                    return new Tx3gDecoder(format.initializationData);
                case 5:
                    return new SsaDecoder(format.initializationData);
                case 6:
                case 7:
                    return new Cea608Decoder(format.sampleMimeType, format.accessibilityChannel);
                case 8:
                    return new Cea708Decoder(format.accessibilityChannel);
                case 9:
                    return new SubripDecoder();
                case 10:
                    return new TtmlDecoder();
                default:
                    throw new IllegalArgumentException("Attempted to create decoder for unsupported format");
            }
        }
    };

    SubtitleDecoder createDecoder(Format format);

    boolean supportsFormat(Format format);
}
