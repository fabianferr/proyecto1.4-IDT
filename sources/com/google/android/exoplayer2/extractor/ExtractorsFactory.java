package com.google.android.exoplayer2.extractor;

import android.net.Uri;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import java.util.Map;

public interface ExtractorsFactory {
    public static final ExtractorsFactory EMPTY = new ExtractorsFactory$$ExternalSyntheticLambda0();

    Extractor[] createExtractors();

    Extractor[] createExtractors(Uri uri, Map<String, List<String>> map);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.android.exoplayer2.extractor.ExtractorsFactory$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            ExtractorsFactory extractorsFactory = ExtractorsFactory.EMPTY;
        }

        public static /* synthetic */ Extractor[] lambda$static$0() {
            return new Extractor[0];
        }

        public static Extractor[] $default$createExtractors(ExtractorsFactory _this, Uri uri, Map map) {
            return _this.createExtractors();
        }
    }
}
