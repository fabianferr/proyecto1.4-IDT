package androidx.media3.datasource.cache;

import android.net.Uri;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface ContentMetadata {
    public static final String KEY_CONTENT_LENGTH = "exo_len";
    public static final String KEY_CUSTOM_PREFIX = "custom_";
    public static final String KEY_REDIRECTED_URI = "exo_redir";

    boolean contains(String str);

    long get(String str, long j);

    String get(String str, String str2);

    byte[] get(String str, byte[] bArr);

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.datasource.cache.ContentMetadata$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static long getContentLength(ContentMetadata contentMetadata) {
            return contentMetadata.get("exo_len", -1);
        }

        public static Uri getRedirectedUri(ContentMetadata contentMetadata) {
            String str = null;
            String str2 = contentMetadata.get("exo_redir", (String) null);
            if (str2 == null) {
                return null;
            }
            return Uri.parse(str2);
        }
    }
}
