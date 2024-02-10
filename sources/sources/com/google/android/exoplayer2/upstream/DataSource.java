package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface DataSource extends DataReader {

    public interface Factory {
        DataSource createDataSource();
    }

    void addTransferListener(TransferListener transferListener);

    void close() throws IOException;

    Map<String, List<String>> getResponseHeaders();

    Uri getUri();

    long open(DataSpec dataSpec) throws IOException;

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.upstream.DataSource$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$getResponseHeaders(DataSource _this) {
            return Collections.emptyMap();
        }
    }
}
