package androidx.media3.datasource.cache;

import androidx.media3.datasource.DataSpec;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface CacheKeyFactory {
    public static final CacheKeyFactory DEFAULT = new CacheKeyFactory$$ExternalSyntheticLambda0();

    String buildCacheKey(DataSpec dataSpec);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.datasource.cache.CacheKeyFactory$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            CacheKeyFactory cacheKeyFactory = CacheKeyFactory.DEFAULT;
        }

        public static /* synthetic */ String lambda$static$0(DataSpec dataSpec) {
            return dataSpec.key != null ? dataSpec.key : dataSpec.uri.toString();
        }
    }
}
