package androidx.media3.exoplayer.upstream;

import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.common.collect.ImmutableMap;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.UUID;

public final class CmcdConfiguration {
    public static final String KEY_BITRATE = "br";
    public static final String KEY_BUFFER_LENGTH = "bl";
    public static final String KEY_CMCD_OBJECT = "CMCD-Object";
    public static final String KEY_CMCD_REQUEST = "CMCD-Request";
    public static final String KEY_CMCD_SESSION = "CMCD-Session";
    public static final String KEY_CMCD_STATUS = "CMCD-Status";
    public static final String KEY_CONTENT_ID = "cid";
    public static final String KEY_MAXIMUM_REQUESTED_BITRATE = "rtp";
    public static final String KEY_MEASURED_THROUGHPUT = "mtp";
    public static final String KEY_OBJECT_DURATION = "d";
    public static final String KEY_OBJECT_TYPE = "ot";
    public static final String KEY_SESSION_ID = "sid";
    public static final String KEY_STREAMING_FORMAT = "sf";
    public static final String KEY_STREAM_TYPE = "st";
    public static final String KEY_TOP_BITRATE = "tb";
    public static final String KEY_VERSION = "v";
    public static final int MAX_ID_LENGTH = 64;
    public final String contentId;
    public final RequestConfig requestConfig;
    public final String sessionId;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface CmcdKey {
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface HeaderKey {
    }

    public interface Factory {
        public static final Factory DEFAULT = new CmcdConfiguration$Factory$$ExternalSyntheticLambda0();

        CmcdConfiguration createCmcdConfiguration(MediaItem mediaItem);

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: androidx.media3.exoplayer.upstream.CmcdConfiguration$Factory$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            static {
                Factory factory = Factory.DEFAULT;
            }

            public static /* synthetic */ CmcdConfiguration lambda$static$0(MediaItem mediaItem) {
                return new CmcdConfiguration(UUID.randomUUID().toString(), mediaItem.mediaId != null ? mediaItem.mediaId : "", new RequestConfig() {
                    public /* synthetic */ ImmutableMap getCustomData() {
                        return RequestConfig.CC.$default$getCustomData(this);
                    }

                    public /* synthetic */ int getRequestedMaximumThroughputKbps(int i) {
                        return RequestConfig.CC.$default$getRequestedMaximumThroughputKbps(this, i);
                    }

                    public /* synthetic */ boolean isKeyAllowed(String str) {
                        return RequestConfig.CC.$default$isKeyAllowed(this, str);
                    }
                });
            }
        }
    }

    public interface RequestConfig {
        ImmutableMap<String, String> getCustomData();

        int getRequestedMaximumThroughputKbps(int i);

        boolean isKeyAllowed(String str);

        @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
        /* renamed from: androidx.media3.exoplayer.upstream.CmcdConfiguration$RequestConfig$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
            public static int $default$getRequestedMaximumThroughputKbps(RequestConfig _this, int i) {
                return C.RATE_UNSET_INT;
            }

            public static boolean $default$isKeyAllowed(RequestConfig _this, String str) {
                return true;
            }

            public static ImmutableMap $default$getCustomData(RequestConfig _this) {
                return ImmutableMap.of();
            }
        }
    }

    public CmcdConfiguration(String str, String str2, RequestConfig requestConfig2) {
        boolean z = false;
        Assertions.checkArgument(str == null || str.length() <= 64);
        Assertions.checkArgument((str2 == null || str2.length() <= 64) ? true : z);
        Assertions.checkNotNull(requestConfig2);
        this.sessionId = str;
        this.contentId = str2;
        this.requestConfig = requestConfig2;
    }

    public boolean isBitrateLoggingAllowed() {
        return this.requestConfig.isKeyAllowed("br");
    }

    public boolean isBufferLengthLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_BUFFER_LENGTH);
    }

    public boolean isContentIdLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_CONTENT_ID);
    }

    public boolean isSessionIdLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_SESSION_ID);
    }

    public boolean isMaximumRequestThroughputLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_MAXIMUM_REQUESTED_BITRATE);
    }

    public boolean isStreamingFormatLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_STREAMING_FORMAT);
    }

    public boolean isStreamTypeLoggingAllowed() {
        return this.requestConfig.isKeyAllowed("st");
    }

    public boolean isTopBitrateLoggingAllowed() {
        return this.requestConfig.isKeyAllowed("tb");
    }

    public boolean isObjectDurationLoggingAllowed() {
        return this.requestConfig.isKeyAllowed("d");
    }

    public boolean isMeasuredThroughputLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_MEASURED_THROUGHPUT);
    }

    public boolean isObjectTypeLoggingAllowed() {
        return this.requestConfig.isKeyAllowed(KEY_OBJECT_TYPE);
    }
}
