package com.google.android.exoplayer2.source.rtsp;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;

interface RtpDataChannel extends DataSource {

    public interface Factory {

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: com.google.android.exoplayer2.source.rtsp.RtpDataChannel$Factory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static Factory $default$createFallbackDataChannelFactory(Factory _this) {
                return null;
            }
        }

        RtpDataChannel createAndOpenDataChannel(int i) throws IOException;

        Factory createFallbackDataChannelFactory();
    }

    RtspMessageChannel.InterleavedBinaryDataListener getInterleavedBinaryDataListener();

    int getLocalPort();

    String getTransport();
}
